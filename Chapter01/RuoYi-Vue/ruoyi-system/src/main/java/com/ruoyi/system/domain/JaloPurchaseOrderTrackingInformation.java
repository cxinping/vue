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

    private Date contractSigningBeginTime;
    private Date contractSigningEndTime;

    /** 合同结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractEndTime;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private BigDecimal contractAmount;

    /** 应付预付款金额 ，改为 已付预付款金额 ， 又改为 预付款金额 */
    @Excel(name = "已付预付款金额")
    private BigDecimal prepaymentAmountPayable;

    /** 应付预付款时间，改为 应付尾款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应付尾款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payableTime;
    private Date payableBeginTime;
    private Date payableEndTime;

    /** 已付预付款金额,改为 应付尾款金额 */
    @Excel(name = "应付尾款金额")
    private BigDecimal prepaymentAmountPaid;

    /** 应付预付款时间,  改为 预付款时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "应付预付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prepaymentPayableTime;

    /** 应付预付款金额 */
    //@Excel(name = "应付预付款金额")
    private BigDecimal prepaymentPayableAmount;

    /** 后续进度 */
    @Excel(name = "后续进度")
    private String progress;

    /** 印花税 */
    @Excel(name = "印花税")
    private String stampduty;

    /** 合同签署情况 */
    @Excel(name = "合同签署情况")
    private String contractsigning;

    private String columnname;

    private String orderby;

    private String param;

    public Date getPayableBeginTime() {
        return payableBeginTime;
    }

    public void setPayableBeginTime(Date payableBeginTime) {
        this.payableBeginTime = payableBeginTime;
    }

    public Date getPayableEndTime() {
        return payableEndTime;
    }

    public void setPayableEndTime(Date payableEndTime) {
        this.payableEndTime = payableEndTime;
    }

    public Date getContractSigningBeginTime() {
        return contractSigningBeginTime;
    }

    public void setContractSigningBeginTime(Date contractSigningBeginTime) {
        this.contractSigningBeginTime = contractSigningBeginTime;
    }

    public Date getContractSigningEndTime() {
        return contractSigningEndTime;
    }

    public void setContractSigningEndTime(Date contractSigningEndTime) {
        this.contractSigningEndTime = contractSigningEndTime;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getStampduty() {
        return stampduty;
    }

    public void setStampduty(String stampduty) {
        this.stampduty = stampduty;
    }

    public String getContractsigning() {
        return contractsigning;
    }

    public void setContractsigning(String contractsigning) {
        this.contractsigning = contractsigning;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

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
        return "JaloPurchaseOrderTrackingInformation{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", supplier='" + supplier + '\'' +
                ", contractSigningTime=" + contractSigningTime +
                ", contractSigningBeginTime=" + contractSigningBeginTime +
                ", contractSigningEndTime=" + contractSigningEndTime +
                ", contractEndTime=" + contractEndTime +
                ", contractAmount=" + contractAmount +
                ", prepaymentAmountPayable=" + prepaymentAmountPayable +
                ", payableTime=" + payableTime +
                ", payableBeginTime=" + payableBeginTime +
                ", payableEndTime=" + payableEndTime +
                ", prepaymentAmountPaid=" + prepaymentAmountPaid +
                ", prepaymentPayableTime=" + prepaymentPayableTime +
                ", prepaymentPayableAmount=" + prepaymentPayableAmount +
                ", progress='" + progress + '\'' +
                ", stampduty='" + stampduty + '\'' +
                ", contractsigning='" + contractsigning + '\'' +
                ", columnname='" + columnname + '\'' +
                ", orderby='" + orderby + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
