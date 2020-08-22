package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存详细对象 jalo_inventory_detail
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public class JaloInventoryDetail extends BaseEntity implements Comparable<JaloInventoryDetail>
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

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

    /** 顺序号 */
    @Excel(name = "顺序号")
    private Integer orderNum;

    private String jaloInventorySumId;



    public String getJaloInventorySumId() {
        return jaloInventorySumId;
    }

    public void setJaloInventorySumId(String jaloInventorySumId) {
        this.jaloInventorySumId = jaloInventorySumId;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
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
        return "JaloInventoryDetail{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", saleableInventoryAmount=" + saleableInventoryAmount +
                ", unsaleableInventoryAmount=" + unsaleableInventoryAmount +
                ", inventoryAmount=" + inventoryAmount +
                ", orderNum=" + orderNum +
                ", jaloInventorySumId='" + jaloInventorySumId + '\'' +
                '}';
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public int compareTo(JaloInventoryDetail inventoryDetail) {
        return this.orderNum - inventoryDetail.getOrderNum();
    }
}
