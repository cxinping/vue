package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 jalo_amount_statistics_view
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class JaloAmountStatisticsView extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String days;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumContractAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumPrepaymentAmountPayable;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumPrepaymentAmountPaid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumShippedUnsettledTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumPurchasedUnshippedTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal loanUsageTotalLoanCreditAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal loanUsageTotalLoanCreditBalance;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal loanUsageTotalLoanCreditRemaining;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumAvailableFundsTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumSaleableInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumUnsaleableInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal goodsTransitTotalAmount;

    // 统计指标1 = 已下单未发货 + 已发货未结算 + 可用资金 – 贷款已使用金额
    private BigDecimal statisticalIndicators1;


    public void setDays(String days) 
    {
        this.days = days;
    }

    public String getDays() 
    {
        return days;
    }
    public void setSumContractAmount(BigDecimal sumContractAmount) 
    {
        this.sumContractAmount = sumContractAmount;
    }

    public BigDecimal getSumContractAmount() 
    {
        return sumContractAmount;
    }
    public void setSumPrepaymentAmountPayable(BigDecimal sumPrepaymentAmountPayable) 
    {
        this.sumPrepaymentAmountPayable = sumPrepaymentAmountPayable;
    }

    public BigDecimal getSumPrepaymentAmountPayable() 
    {
        return sumPrepaymentAmountPayable;
    }
    public void setSumPrepaymentAmountPaid(BigDecimal sumPrepaymentAmountPaid) 
    {
        this.sumPrepaymentAmountPaid = sumPrepaymentAmountPaid;
    }

    public BigDecimal getSumPrepaymentAmountPaid() 
    {
        return sumPrepaymentAmountPaid;
    }
    public void setSumShippedUnsettledTotalAmount(BigDecimal sumShippedUnsettledTotalAmount) 
    {
        this.sumShippedUnsettledTotalAmount = sumShippedUnsettledTotalAmount;
    }

    public BigDecimal getSumShippedUnsettledTotalAmount() 
    {
        return sumShippedUnsettledTotalAmount;
    }
    public void setSumPurchasedUnshippedTotalAmount(BigDecimal sumPurchasedUnshippedTotalAmount) 
    {
        this.sumPurchasedUnshippedTotalAmount = sumPurchasedUnshippedTotalAmount;
    }

    public BigDecimal getSumPurchasedUnshippedTotalAmount() 
    {
        return sumPurchasedUnshippedTotalAmount;
    }
    public void setLoanUsageTotalLoanCreditAmount(BigDecimal loanUsageTotalLoanCreditAmount) 
    {
        this.loanUsageTotalLoanCreditAmount = loanUsageTotalLoanCreditAmount;
    }

    public BigDecimal getLoanUsageTotalLoanCreditAmount() 
    {
        return loanUsageTotalLoanCreditAmount;
    }
    public void setLoanUsageTotalLoanCreditBalance(BigDecimal loanUsageTotalLoanCreditBalance) 
    {
        this.loanUsageTotalLoanCreditBalance = loanUsageTotalLoanCreditBalance;
    }

    public BigDecimal getLoanUsageTotalLoanCreditBalance() 
    {
        return loanUsageTotalLoanCreditBalance;
    }
    public void setLoanUsageTotalLoanCreditRemaining(BigDecimal loanUsageTotalLoanCreditRemaining) 
    {
        this.loanUsageTotalLoanCreditRemaining = loanUsageTotalLoanCreditRemaining;
    }

    public BigDecimal getLoanUsageTotalLoanCreditRemaining() 
    {
        return loanUsageTotalLoanCreditRemaining;
    }
    public void setSumAvailableFundsTotalAmount(BigDecimal sumAvailableFundsTotalAmount) 
    {
        this.sumAvailableFundsTotalAmount = sumAvailableFundsTotalAmount;
    }

    public BigDecimal getSumAvailableFundsTotalAmount() 
    {
        return sumAvailableFundsTotalAmount;
    }
    public void setSumInventoryAmount(BigDecimal sumInventoryAmount) 
    {
        this.sumInventoryAmount = sumInventoryAmount;
    }

    public BigDecimal getSumInventoryAmount() 
    {
        return sumInventoryAmount;
    }
    public void setSumSaleableInventoryAmount(BigDecimal sumSaleableInventoryAmount) 
    {
        this.sumSaleableInventoryAmount = sumSaleableInventoryAmount;
    }

    public BigDecimal getSumSaleableInventoryAmount() 
    {
        return sumSaleableInventoryAmount;
    }
    public void setSumUnsaleableInventoryAmount(BigDecimal sumUnsaleableInventoryAmount) 
    {
        this.sumUnsaleableInventoryAmount = sumUnsaleableInventoryAmount;
    }

    public BigDecimal getSumUnsaleableInventoryAmount() 
    {
        return sumUnsaleableInventoryAmount;
    }
    public void setGoodsTransitTotalAmount(BigDecimal goodsTransitTotalAmount) 
    {
        this.goodsTransitTotalAmount = goodsTransitTotalAmount;
    }

    public BigDecimal getGoodsTransitTotalAmount() 
    {
        return goodsTransitTotalAmount;
    }

    public BigDecimal getStatisticalIndicators1() {
        return statisticalIndicators1;
    }

    public void setStatisticalIndicators1(BigDecimal statisticalIndicators1) {
        this.statisticalIndicators1 = statisticalIndicators1;
    }

    @Override
    public String toString() {
        return "JaloAmountStatisticsView{" +
                "days='" + days + '\'' +
                ", sumContractAmount=" + sumContractAmount +
                ", sumPrepaymentAmountPayable=" + sumPrepaymentAmountPayable +
                ", sumPrepaymentAmountPaid=" + sumPrepaymentAmountPaid +
                ", sumShippedUnsettledTotalAmount=" + sumShippedUnsettledTotalAmount +
                ", sumPurchasedUnshippedTotalAmount=" + sumPurchasedUnshippedTotalAmount +
                ", loanUsageTotalLoanCreditAmount=" + loanUsageTotalLoanCreditAmount +
                ", loanUsageTotalLoanCreditBalance=" + loanUsageTotalLoanCreditBalance +
                ", loanUsageTotalLoanCreditRemaining=" + loanUsageTotalLoanCreditRemaining +
                ", sumAvailableFundsTotalAmount=" + sumAvailableFundsTotalAmount +
                ", sumInventoryAmount=" + sumInventoryAmount +
                ", sumSaleableInventoryAmount=" + sumSaleableInventoryAmount +
                ", sumUnsaleableInventoryAmount=" + sumUnsaleableInventoryAmount +
                ", goodsTransitTotalAmount=" + goodsTransitTotalAmount +
                ", statisticalIndicators1=" + statisticalIndicators1 +
                '}';
    }
}
