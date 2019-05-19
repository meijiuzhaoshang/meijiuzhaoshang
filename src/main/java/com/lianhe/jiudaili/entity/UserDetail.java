package com.lianhe.jiudaili.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 酒代理后端开发小组——冯志立、龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-17
 */
@TableName("user_detail")
public class UserDetail extends Model<UserDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，和用户注册表ID相同
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 姓名
     */
	private String name;
    /**
     * 昵称
     */
	private String nick;
    /**
     * 固定电话
     */
	private String tel;
    /**
     * qq号
     */
	private String qqcard;
    /**
     * 地址
     */
	private String uaddress;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQqcard() {
		return qqcard;
	}

	public void setQqcard(String qqcard) {
		this.qqcard = qqcard;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
