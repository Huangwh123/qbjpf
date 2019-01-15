package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表 t_users
 * 
 * @author ruoyi
 * @date 2019-01-14
 */
public class Users extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private String id;
	/** 创建时间 */
	private Date time;
	/** 用户昵称 */
	private String name;
	/** 图像 */
	private String photo;
	/** 是否允许登录(锁定) 0 否(可以登录) 1 是 */
	private Boolean isAllowLogin;
	/** 登录次数 */
	private Long loginCount;
	/** 上次登录时间 */
	private Date lastLoginTime;
	/** 上次登录ip */
	private String lastLoginIp;
	/** 手机号码 */
	private String mobile;
	/** 余额 */
	private BigDecimal balance;
	/** 冻结金额 */
	private BigDecimal freeze;
	/** 用户表资金改动标记 */
	private String sign1;
	/** 用户明细表改动标记 */
	private String sign2;
	/** 微信Id */
	private String openId;

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setTime(Date time) 
	{
		this.time = time;
	}

	public Date getTime() 
	{
		return time;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPhoto(String photo) 
	{
		this.photo = photo;
	}

	public String getPhoto() 
	{
		return photo;
	}
	public void setIsAllowLogin(Boolean isAllowLogin) 
	{
		this.isAllowLogin = isAllowLogin;
	}

	public Boolean getIsAllowLogin() 
	{
		return isAllowLogin;
	}
	public void setLoginCount(Long loginCount) 
	{
		this.loginCount = loginCount;
	}

	public Long getLoginCount() 
	{
		return loginCount;
	}
	public void setLastLoginTime(Date lastLoginTime) 
	{
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() 
	{
		return lastLoginTime;
	}
	public void setLastLoginIp(String lastLoginIp) 
	{
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() 
	{
		return lastLoginIp;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setBalance(BigDecimal balance) 
	{
		this.balance = balance;
	}

	public BigDecimal getBalance() 
	{
		return balance;
	}
	public void setFreeze(BigDecimal freeze) 
	{
		this.freeze = freeze;
	}

	public BigDecimal getFreeze() 
	{
		return freeze;
	}
	public void setSign1(String sign1) 
	{
		this.sign1 = sign1;
	}

	public String getSign1() 
	{
		return sign1;
	}
	public void setSign2(String sign2) 
	{
		this.sign2 = sign2;
	}

	public String getSign2() 
	{
		return sign2;
	}
	public void setOpenId(String openId) 
	{
		this.openId = openId;
	}

	public String getOpenId() 
	{
		return openId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("time", getTime())
            .append("name", getName())
            .append("photo", getPhoto())
            .append("isAllowLogin", getIsAllowLogin())
            .append("loginCount", getLoginCount())
            .append("lastLoginTime", getLastLoginTime())
            .append("lastLoginIp", getLastLoginIp())
            .append("mobile", getMobile())
            .append("balance", getBalance())
            .append("freeze", getFreeze())
            .append("sign1", getSign1())
            .append("sign2", getSign2())
            .append("openId", getOpenId())
            .toString();
    }
}
