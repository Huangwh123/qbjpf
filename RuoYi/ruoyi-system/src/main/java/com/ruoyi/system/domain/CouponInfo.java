package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠劵表 t_coupon_info
 * 
 * @author ruoyi
 * @date 2018-12-22
 */
public class CouponInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Long id;
	/** 优惠卷来源:0淘宝联盟,1更多劵,2美逛 */
	private Integer couponSource;
	/** 商品全称 */
	private String fullName;
	/** 商品简称 */
	private String abbreviationName;
	/** 商品种类:0电器类,1珠宝类,2服饰类 */
	private Integer couponType;
	/** 优惠卷单价 */
	private BigDecimal couponPrice;
	/** 商品原价 */
	private BigDecimal originalPrice;
	/** 使用之后的价格 */
	private BigDecimal discountPrice;
	/** 商品状态;1正常状态,0下架状态 */
	private Integer tradeState;
	/** 商品图片 */
	private String tradePicture;
	/** 优惠劵复制文本 */
	private String couponText;
	/** 优惠劵链接 */
	private String couponUrl;
	/** 创建时间 */
	private Date createDate;
	/** 更新时间 */
	private Date updateDate;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCouponSource(Integer couponSource) 
	{
		this.couponSource = couponSource;
	}

	public Integer getCouponSource() 
	{
		return couponSource;
	}
	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public String getFullName() 
	{
		return fullName;
	}
	public void setAbbreviationName(String abbreviationName) 
	{
		this.abbreviationName = abbreviationName;
	}

	public String getAbbreviationName() 
	{
		return abbreviationName;
	}
	public void setCouponType(Integer couponType) 
	{
		this.couponType = couponType;
	}

	public Integer getCouponType() 
	{
		return couponType;
	}
	public void setCouponPrice(BigDecimal couponPrice) 
	{
		this.couponPrice = couponPrice;
	}

	public BigDecimal getCouponPrice() 
	{
		return couponPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) 
	{
		this.originalPrice = originalPrice;
	}

	public BigDecimal getOriginalPrice() 
	{
		return originalPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) 
	{
		this.discountPrice = discountPrice;
	}

	public BigDecimal getDiscountPrice() 
	{
		return discountPrice;
	}
	public void setTradeState(Integer tradeState) 
	{
		this.tradeState = tradeState;
	}

	public Integer getTradeState() 
	{
		return tradeState;
	}
	public void setTradePicture(String tradePicture) 
	{
		this.tradePicture = tradePicture;
	}

	public String getTradePicture() 
	{
		return tradePicture;
	}
	public void setCouponText(String couponText) 
	{
		this.couponText = couponText;
	}

	public String getCouponText() 
	{
		return couponText;
	}
	public void setCouponUrl(String couponUrl) 
	{
		this.couponUrl = couponUrl;
	}

	public String getCouponUrl() 
	{
		return couponUrl;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("couponSource", getCouponSource())
            .append("fullName", getFullName())
            .append("abbreviationName", getAbbreviationName())
            .append("couponType", getCouponType())
            .append("couponPrice", getCouponPrice())
            .append("originalPrice", getOriginalPrice())
            .append("discountPrice", getDiscountPrice())
            .append("tradeState", getTradeState())
            .append("tradePicture", getTradePicture())
            .append("couponText", getCouponText())
            .append("couponUrl", getCouponUrl())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
