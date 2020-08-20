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
 * @date 2020-08-20
 */
public class JaloAmountStatisticsView extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String days;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumSaleableInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumUnsaleableInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumInventoryAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumPrepaymentAmountPaid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumShippedUnsettledTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sumAvailableFundsTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal goodsTransitTotalAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal placedNotShippedTotalAmount;

    public void setDays(String days) 
    {
        this.days = days;
    }

    public String getDays() 
    {
        return days;
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
    public void setSumInventoryAmount(BigDecimal sumInventoryAmount) 
    {
        this.sumInventoryAmount = sumInventoryAmount;
    }

    public BigDecimal getSumInventoryAmount() 
    {
        return sumInventoryAmount;
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
    public void setSumAvailableFundsTotalAmount(BigDecimal sumAvailableFundsTotalAmount) 
    {
        this.sumAvailableFundsTotalAmount = sumAvailableFundsTotalAmount;
    }

    public BigDecimal getSumAvailableFundsTotalAmount() 
    {
        return sumAvailableFundsTotalAmount;
    }
    public void setGoodsTransitTotalAmount(BigDecimal goodsTransitTotalAmount) 
    {
        this.goodsTransitTotalAmount = goodsTransitTotalAmount;
    }

    public BigDecimal getGoodsTransitTotalAmount() 
    {
        return goodsTransitTotalAmount;
    }
    public void setPlacedNotShippedTotalAmount(BigDecimal placedNotShippedTotalAmount) 
    {
        this.placedNotShippedTotalAmount = placedNotShippedTotalAmount;
    }

    public BigDecimal getPlacedNotShippedTotalAmount() 
    {
        return placedNotShippedTotalAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("days", getDays())
            .append("sumSaleableInventoryAmount", getSumSaleableInventoryAmount())
            .append("sumUnsaleableInventoryAmount", getSumUnsaleableInventoryAmount())
            .append("sumInventoryAmount", getSumInventoryAmount())
            .append("sumPrepaymentAmountPaid", getSumPrepaymentAmountPaid())
            .append("sumShippedUnsettledTotalAmount", getSumShippedUnsettledTotalAmount())
            .append("sumAvailableFundsTotalAmount", getSumAvailableFundsTotalAmount())
            .append("goodsTransitTotalAmount", getGoodsTransitTotalAmount())
            .append("placedNotShippedTotalAmount", getPlacedNotShippedTotalAmount())
            .toString();
    }
}
