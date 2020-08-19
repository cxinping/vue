package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存汇总对象 jalo_inventory_sum
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public class JaloInventorySum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    private String product;

    /** 合计金额汇总 */
    @Excel(name = "合计金额汇总")
    private BigDecimal sumSaleableInventoryAmount;

    /** 不可销售库存金额汇总 */
    @Excel(name = "不可销售库存金额汇总")
    private BigDecimal sumUnsaleableInventoryAmount;

    /** 合计金额汇总 */
    @Excel(name = "合计金额汇总")
    private BigDecimal sumInventoryAmount;

    private List<JaloInventoryDetail> inventoryDetails = null;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public List<JaloInventoryDetail> getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(List<JaloInventoryDetail> inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sumSaleableInventoryAmount", getSumSaleableInventoryAmount())
            .append("sumUnsaleableInventoryAmount", getSumUnsaleableInventoryAmount())
            .append("sumInventoryAmount", getSumInventoryAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
