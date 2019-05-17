package com.lianhe.jiudaili.entity;


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
@TableName("company_area")
public class CompanyArea extends Model<CompanyArea> {

    private static final long serialVersionUID = 1L;

	private Integer cid;
    /**
     * 酒水分区中间表
     */
	private Integer aid;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}


}
