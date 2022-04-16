package com.wbz.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SysFile {
    private String name;
    private String url;

    public SysFile() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return (new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)).append("name", this.getName()).append("url", this.getUrl()).toString();
    }
}

