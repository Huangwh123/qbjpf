package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 工具表 t_tools_info
 * 
 * @author ruoyi
 * @date 2018-12-29
 */
public class ToolsInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Long id;
	/** 工具来源:0鹏飞,1其他 */
	private Integer toolSource;
	/** 工具名称 */
	private String toolName;
	/** 工具简称 */
	private String toolAbbreviation;
	/** 工具种类:0电器类,1珠宝类,2服饰类 */
	private Integer toolsType;
	/** 押金元 */
	private BigDecimal deposit;
	/** 租出单价元 */
	private BigDecimal rentalPrice;
	/** 出租状态:0待出租,出租中 */
	private Integer rentalState;
	/** 出借期限: 0小时,1天; */
	private Integer periodUnit;
	/** 出借期限 */
	private Integer period;
	/** 工具状态;0正常状态,1下架状态 */
	private Integer tradeState;
	/** 工具图片 */
	private String toolPicture;
	/** 工具简介 */
	private String toolText;
	/** 保险费用单位元 */
	private BigDecimal insurancePremium;
	/** 保险描述 */
	private String insuranceBrief;
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
	public void setToolSource(Integer toolSource) 
	{
		this.toolSource = toolSource;
	}

	public Integer getToolSource() 
	{
		return toolSource;
	}
	public void setToolName(String toolName) 
	{
		this.toolName = toolName;
	}

	public String getToolName() 
	{
		return toolName;
	}
	public void setToolAbbreviation(String toolAbbreviation) 
	{
		this.toolAbbreviation = toolAbbreviation;
	}

	public String getToolAbbreviation() 
	{
		return toolAbbreviation;
	}
	public void setToolsType(Integer toolsType) 
	{
		this.toolsType = toolsType;
	}

	public Integer getToolsType() 
	{
		return toolsType;
	}
	public void setDeposit(BigDecimal deposit) 
	{
		this.deposit = deposit;
	}

	public BigDecimal getDeposit() 
	{
		return deposit;
	}
	public void setRentalPrice(BigDecimal rentalPrice) 
	{
		this.rentalPrice = rentalPrice;
	}

	public BigDecimal getRentalPrice() 
	{
		return rentalPrice;
	}
	public void setRentalState(Integer rentalState) 
	{
		this.rentalState = rentalState;
	}

	public Integer getRentalState() 
	{
		return rentalState;
	}
	public void setPeriodUnit(Integer periodUnit) 
	{
		this.periodUnit = periodUnit;
	}

	public Integer getPeriodUnit() 
	{
		return periodUnit;
	}
	public void setPeriod(Integer period) 
	{
		this.period = period;
	}

	public Integer getPeriod() 
	{
		return period;
	}
	public void setTradeState(Integer tradeState) 
	{
		this.tradeState = tradeState;
	}

	public Integer getTradeState() 
	{
		return tradeState;
	}
	public void setToolPicture(String toolPicture) 
	{
		this.toolPicture = toolPicture;
	}

	public String getToolPicture() 
	{
		return toolPicture;
	}
	public void setToolText(String toolText) 
	{
		this.toolText = toolText;
	}

	public String getToolText() 
	{
		return toolText;
	}
	public void setInsurancePremium(BigDecimal insurancePremium) 
	{
		this.insurancePremium = insurancePremium;
	}

	public BigDecimal getInsurancePremium() 
	{
		return insurancePremium;
	}
	public void setInsuranceBrief(String insuranceBrief) 
	{
		this.insuranceBrief = insuranceBrief;
	}

	public String getInsuranceBrief() 
	{
		return insuranceBrief;
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
            .append("toolSource", getToolSource())
            .append("toolName", getToolName())
            .append("toolAbbreviation", getToolAbbreviation())
            .append("toolsType", getToolsType())
            .append("deposit", getDeposit())
            .append("rentalPrice", getRentalPrice())
            .append("rentalState", getRentalState())
            .append("periodUnit", getPeriodUnit())
            .append("period", getPeriod())
            .append("tradeState", getTradeState())
            .append("toolPicture", getToolPicture())
            .append("toolText", getToolText())
            .append("insurancePremium", getInsurancePremium())
            .append("insuranceBrief", getInsuranceBrief())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
