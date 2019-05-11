package com.lianhe.jiudaili.vo;

import com.lianhe.jiudaili.entity.NavigationBar;
import com.lianhe.jiudaili.entity.Region;

import java.util.List;

public class RegionVo {
    private Integer id;
    private String region;
    private String regionUrl;
    private List<Region> childRegions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl;
    }

    public List<Region> getChildRegions() {
        return childRegions;
    }

    public void setChildRegions(List<Region> childRegions) {
        this.childRegions = childRegions;
    }
}
