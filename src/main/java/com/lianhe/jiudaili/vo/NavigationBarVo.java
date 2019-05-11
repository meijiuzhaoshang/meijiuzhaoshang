package com.lianhe.jiudaili.vo;

import com.lianhe.jiudaili.entity.NavigationBar;

import java.util.List;

public class NavigationBarVo {
    private Integer id;
    private String title;
    private String titleUrl;
    private List<NavigationBar> childNavs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public List<NavigationBar> getChildNavs() {
        return childNavs;
    }

    public void setChildNavs(List<NavigationBar> childNavs) {
        this.childNavs = childNavs;
    }
}
