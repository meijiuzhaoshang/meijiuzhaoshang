package com.lianhe.jiudaili.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@TableName("drinks_advertisement")
public class DrinksAdvertisement extends Model<DrinksAdvertisement> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 厂家ID
     */
	@TableField("manufacturers_id")
	private Integer manufacturersId;
    /**
     * 厂家网址
     */
	@TableField("manufacturers_url")
	private String manufacturersUrl;


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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
