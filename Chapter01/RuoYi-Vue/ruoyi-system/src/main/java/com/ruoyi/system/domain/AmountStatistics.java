package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 统计页面对象 amount_statistics
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public class AmountStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 预付款 */
    @Excel(name = "预付款")
    private BigDecimal prepayments;

    /** 库存 */
    @Excel(name = "库存")
    private BigDecimal inStock;

    /** 已发货未结算金额 */
    @Excel(name = "已发货未结算金额")
    private BigDecimal shippedUnsettledAmount;

    /** 可用资金 */
    @Excel(name = "可用资金")
    private BigDecimal totalAvailableFunds;

    /** 在途物资 */
    @Excel(name = "在途物资")
    private BigDecimal totalMaterialsInTransit;

    /** 已下单未发货金额合计数 */
    @Excel(name = "已下单未发货金额合计数")
    private Long ordersNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPrepayments(BigDecimal prepayments) 
    {
        this.prepayments = prepayments;
    }

    public BigDecimal getPrepayments() 
    {
        return prepayments;
    }
    public void setInStock(BigDecimal inStock) 
    {
        this.inStock = inStock;
    }

    public BigDecimal getInStock() 
    {
        return inStock;
    }
    public void setShippedUnsettledAmount(BigDecimal shippedUnsettledAmount) 
    {
        this.shippedUnsettledAmount = shippedUnsettledAmount;
    }

    public BigDecimal getShippedUnsettledAmount() 
    {
        return shippedUnsettledAmount;
    }
    public void setTotalAvailableFunds(BigDecimal totalAvailableFunds) 
    {
        this.totalAvailableFunds = totalAvailableFunds;
    }

    public BigDecimal getTotalAvailableFunds() 
    {
        return totalAvailableFunds;
    }
    public void setTotalMaterialsInTransit(BigDecimal totalMaterialsInTransit) 
    {
        this.totalMaterialsInTransit = totalMaterialsInTransit;
    }

    public BigDecimal getTotalMaterialsInTransit() 
    {
        return totalMaterialsInTransit;
    }
    public void setOrdersNumber(Long ordersNumber) 
    {
        this.ordersNumber = ordersNumber;
    }

    public Long getOrdersNumber() 
    {
        return ordersNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("prepayments", getPrepayments())
            .append("inStock", getInStock())
            .append("shippedUnsettledAmount", getShippedUnsettledAmount())
            .append("totalAvailableFunds", getTotalAvailableFunds())
            .append("totalMaterialsInTransit", getTotalMaterialsInTransit())
            .append("ordersNumber", getOrdersNumber())
            .toString();
    }
}
