package com.lianhe.jiudaili.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
@TableName("company_homepage")
public class CompanyHomepage extends Model<CompanyHomepage> {

    private static final long serialVersionUID = 1L;

	private Integer cid;
	private String title;
    /**
     * 公司首页展示表
     */
	@TableField("image_homepage")
	private String imageHomepage;
	@TableField("image_homepage2")
	private String imageHomepage2;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageHomepage() {
		return imageHomepage;
	}

	public void setImageHomepage(String imageHomepage) {
		this.imageHomepage = imageHomepage;
	}

	public String getImageHomepage2() {
		return imageHomepage2;
	}

	public void setImageHomepage2(String imageHomepage2) {
		this.imageHomepage2 = imageHomepage2;
	}

	@Override
	protected Serializable pkVal() {
		return this.cid;
	}

}
