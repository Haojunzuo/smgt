package com.wbz.system.service;

import com.wbz.system.domain.Res;
import com.wbz.system.domain.vo.MetaVo;
import com.wbz.system.domain.vo.RouterVo;
import com.wbz.system.mapper.ResMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class ResService {
    @Autowired
    private ResMapper resMapper;

    public List<Res> selectMenuTreeByUserId(Integer role) {
        List<Res> menus = resMapper.selectMenuTreeByRole(role);
        return getChildPerms(menus);
    }

    private List<Res> getChildPerms(List<Res> list) {
        List<Res> returnList = new ArrayList<Res>();
        for (Res t : list) {
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == 0) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    private void recursionFn(List<Res> list, Res t) {
        // 得到子节点列表
        List<Res> childList = getChildList(list, t);
        t.setChildren(childList);
        for (Res tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    private List<Res> getChildList(List<Res> list, Res t) {
        List<Res> tlist = new ArrayList<Res>();
        for (Res n : list) {
            if (n.getParentId().longValue() == t.getResId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    private boolean hasChild(List<Res> list, Res t)
    {
        return getChildList(list, t).size() > 0;
    }

    public List<RouterVo> buildMenus(List<Res> menus)
    {
        List<RouterVo> routers = new LinkedList<RouterVo>();
        for (Res menu : menus)
        {
            RouterVo router = new RouterVo();
            router.setHidden("1".equals(menu.getVisible()));
            router.setName(getRouteName(menu));
            router.setPath(getRouterPath(menu));
            router.setComponent(getComponent(menu));
            router.setMeta(new MetaVo(menu.getResName(), menu.getIcon(), "1".equals(menu.getIsCache()), menu.getPath()));
            List<Res> cMenus = menu.getChildren();
            if (!cMenus.isEmpty() && cMenus.size() > 0 && "M".equals(menu.getMenuType()))
            {
                router.setAlwaysShow(true);
                router.setRedirect("noRedirect");
                router.setChildren(buildMenus(cMenus));
            }
            else if (isMenuFrame(menu))
            {
                router.setMeta(null);
                List<RouterVo> childrenList = new ArrayList<RouterVo>();
                RouterVo children = new RouterVo();
                children.setPath(menu.getPath());
                children.setComponent(menu.getComponent());
                children.setName(menu.getPath());
                children.setMeta(new MetaVo(menu.getResName(), menu.getIcon(), "1".equals(menu.getIsCache()), menu.getPath()));
                childrenList.add(children);
                router.setChildren(childrenList);
            }
            routers.add(router);
        }
        return routers;
    }

    private String getRouteName(Res menu) {
        String routerName = menu.getPath();
        // 非外链并且是一级目录（类型为目录）
        if (isMenuFrame(menu))
        {
            routerName = "";
        }
        return routerName;
    }


    private boolean isMenuFrame(Res menu) {
        return menu.getParentId().intValue() == 0 && "C".equals(menu.getMenuType())
                && menu.getIsFrame().equals("1");
    }

    private String getRouterPath(Res menu) {
        String routerPath = menu.getPath();
        // 非外链并且是一级目录（类型为目录）
        if (0 == menu.getParentId().intValue() && "M".equals(menu.getMenuType())
                && "1".equals(menu.getIsFrame()))
        {
            routerPath = "/" + menu.getPath();
        }
        // 非外链并且是一级目录（类型为菜单）
        else if (isMenuFrame(menu))
        {
            routerPath = "/";
        }
        return routerPath;
    }

    private String getComponent(Res menu) {
        String component = "Layout";
        if (!isEmpty(menu.getComponent()) && !isMenuFrame(menu))
        {
            component = menu.getComponent();
        }
        else if (isEmpty(menu.getComponent()) && isParentView(menu))
        {
            component = "ParentView";
        }
        return component;
    }

    private static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        } else if (str.trim().equals("")) {
            return true;
        } else {
            return str.trim().equals("null");
        }
    }

    private boolean isParentView(Res menu) {
        return menu.getParentId().intValue() != 0 && "M".equals(menu.getMenuType());
    }
}
