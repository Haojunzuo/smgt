package com.wbz.system.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class GeneralListener<T> extends AnalysisEventListener<T> {

    private List<T> list = Lists.newArrayList();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        list.add(t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("read data complete!");
    }
    public List<T> getList(){
        return list;
    }
}
