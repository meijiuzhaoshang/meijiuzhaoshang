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
@TableName("compony_region")
public class ComponyRegion extends Model<ComponyRegion> {

    private static final long serialVersionUID = 1L;

	private Integer cid;
	private Integer rid;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}


}
