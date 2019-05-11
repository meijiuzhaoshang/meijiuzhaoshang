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
@TableName("drinks_advertisement_imgs")
public class DrinksAdvertisementImgs extends Model<DrinksAdvertisementImgs> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("img_url")
	private String imgUrl;
    /**
     * 酒水广告表ID
     */
	@TableField("drinks_advertisement_id")
	private Integer drinksAdvertisementId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getDrinksAdvertisementId() {
		return drinksAdvertisementId;
	}

	public void setDrinksAdvertisementId(Integer drinksAdvertisementId) {
		this.drinksAdvertisementId = drinksAdvertisementId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
