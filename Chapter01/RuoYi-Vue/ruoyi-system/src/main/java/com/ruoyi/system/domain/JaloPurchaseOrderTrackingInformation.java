package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单跟踪信息对象 jalo_purchase_order_tracking_information
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public class JaloPurchaseOrderTrackingInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 合同签订时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractSigningTime;

    /** 合同结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractEndTime;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private BigDecimal contractAmount;

    /** 应付预付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应付预付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payableTime;

    /** 应付预付款金额 */
    @Excel(name = "应付预付款金额")
    private BigDecimal prepaymentAmountPayable;

    /** 已付预付款金额 */
    @Excel(name = "已付预付款金额")
    private BigDecimal prepaymentAmountPaid;

    /** 应付预付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应付预付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prepaymentPayableTime;

    /** 应付预付款金额 */
    @Excel(name = "应付预付款金额")
    private BigDecimal prepaymentPayableAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setContractSigningTime(Date contractSigningTime) 
    {
        this.contractSigningTime = contractSigningTime;
    }

    public Date getContractSigningTime() 
    {
        return contractSigningTime;
    }
    public void setContractEndTime(Date contractEndTime) 
    {
        this.contractEndTime = contractEndTime;
    }

    public Date getContractEndTime() 
    {
        return contractEndTime;
    }
    public void setContractAmount(BigDecimal contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount() 
    {
        return contractAmount;
    }
    public void setPayableTime(Date payableTime) 
    {
        this.payableTime = payableTime;
    }

    public Date getPayableTime() 
    {
        return payableTime;
    }
    public void setPrepaymentAmountPayable(BigDecimal prepaymentAmountPayable) 
    {
        this.prepaymentAmountPayable = prepaymentAmountPayable;
    }

    public BigDecimal getPrepaymentAmountPayable() 
    {
        return prepaymentAmountPayable;
    }
    public void setPrepaymentAmountPaid(BigDecimal prepaymentAmountPaid) 
    {
        this.prepaymentAmountPaid = prepaymentAmountPaid;
    }

    public BigDecimal getPrepaymentAmountPaid() 
    {
        return prepaymentAmountPaid;
    }
    public void setPrepaymentPayableTime(Date prepaymentPayableTime) 
    {
        this.prepaymentPayableTime = prepaymentPayableTime;
    }

    public Date getPrepaymentPayableTime() 
    {
        return prepaymentPayableTime;
    }
    public void setPrepaymentPayableAmount(BigDecimal prepaymentPayableAmount) 
    {
        this.prepaymentPayableAmount = prepaymentPayableAmount;
    }

    public BigDecimal getPrepaymentPayableAmount() 
    {
        return prepaymentPayableAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("supplier", getSupplier())
            .append("contractSigningTime", getContractSigningTime())
            .append("contractEndTime", getContractEndTime())
            .append("contractAmount", getContractAmount())
            .append("payableTime", getPayableTime())
            .append("prepaymentAmountPayable", getPrepaymentAmountPayable())
            .append("prepaymentAmountPaid", getPrepaymentAmountPaid())
            .append("prepaymentPayableTime", getPrepaymentPayableTime())
            .append("prepaymentPayableAmount", getPrepaymentPayableAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
