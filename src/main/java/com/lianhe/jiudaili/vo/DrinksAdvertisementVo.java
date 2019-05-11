package com.lianhe.jiudaili.vo;

import com.lianhe.jiudaili.entity.DrinksAdvertisementImgs;

import java.util.List;

public class DrinksAdvertisementVo {
    private Integer id;
    /**
     * 厂家ID
     */
    private Integer manufacturersId;
    /**
     * 厂家网址
     */
    private String manufacturersUrl;

    // 酒水广告图列表
    private List<DrinksAdvertisementImgs> drinksAdvertisementImgs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManufacturersId() {
        return manufacturersId;
    }

    public void setManufacturersId(Integer manufacturersId) {
        this.manufacturersId = manufacturersId;
    }

    public String getManufacturersUrl() {
        return manufacturersUrl;
    }

    public void setManufacturersUrl(String manufacturersUrl) {
        this.manufacturersUrl = manufacturersUrl;
    }

    public List<DrinksAdvertisementImgs> getDrinksAdvertisementImgs() {
        return drinksAdvertisementImgs;
    }

    public void setDrinksAdvertisementImgs(List<DrinksAdvertisementImgs> drinksAdvertisementImgs) {
        this.drinksAdvertisementImgs = drinksAdvertisementImgs;
    }
}
