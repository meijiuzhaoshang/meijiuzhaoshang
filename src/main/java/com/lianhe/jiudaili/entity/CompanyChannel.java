package com.lianhe.jiudaili.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 美菜商城APP后端开发小组——龚世杰、徐冲、刘东亮
 * @since 2019-05-17
 */
@TableName("company_channel")
public class CompanyChannel extends Model<CompanyChannel> {

    private static final long serialVersionUID = 1L;

	private Integer cid;
	private Integer chid;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}


}
