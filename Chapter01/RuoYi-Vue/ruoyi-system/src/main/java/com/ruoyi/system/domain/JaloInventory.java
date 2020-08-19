package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存对象 jalo_inventory
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public class JaloInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 产品 */
    @Excel(name = "产品")
    private String product;

    /** 可销售库存金额 */
    @Excel(name = "可销售库存金额")
    private BigDecimal saleableInventoryAmount;

    /** 不可销售库存金额 */
    @Excel(name = "不可销售库存金额")
    private BigDecimal unsaleableInventoryAmount;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal inventoryAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProduct(String product) 
    {
        this.product = product;
    }

    public String getProduct() 
    {
        return product;
    }
    public void setSaleableInventoryAmount(BigDecimal saleableInventoryAmount) 
    {
        this.saleableInventoryAmount = saleableInventoryAmount;
    }

    public BigDecimal getSaleableInventoryAmount() 
    {
        return saleableInventoryAmount;
    }
    public void setUnsaleableInventoryAmount(BigDecimal unsaleableInventoryAmount) 
    {
        this.unsaleableInventoryAmount = unsaleableInventoryAmount;
    }

    public BigDecimal getUnsaleableInventoryAmount() 
    {
        return unsaleableInventoryAmount;
    }
    public void setInventoryAmount(BigDecimal inventoryAmount) 
    {
        this.inventoryAmount = inventoryAmount;
    }

    public BigDecimal getInventoryAmount() 
    {
        return inventoryAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("product", getProduct())
            .append("saleableInventoryAmount", getSaleableInventoryAmount())
            .append("unsaleableInventoryAmount", getUnsaleableInventoryAmount())
            .append("inventoryAmount", getInventoryAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
