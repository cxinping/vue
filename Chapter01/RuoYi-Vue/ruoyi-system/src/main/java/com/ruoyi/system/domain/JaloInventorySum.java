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

    /** 可销售库存金额汇总 */
    @Excel(name = "可销售库存金额汇总")
    private BigDecimal sumSaleableInventoryAmount;

    /** 可销售库存数量汇总 */
    @Excel(name = "可销售库存数量汇总")
    private Long sumSaleableInventoryNum;

    /** 不可销售库存金额汇总 */
    @Excel(name = "不可销售库存金额汇总")
    private BigDecimal sumUnsaleableInventoryAmount;

    /** 不可销售库存数量汇总 */
    @Excel(name = "不可销售库存数量汇总")
    private Long sumUnsaleableInventoryNum;

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

    public Long getSumSaleableInventoryNum() {
        return sumSaleableInventoryNum;
    }

    public void setSumSaleableInventoryNum(Long sumSaleableInventoryNum) {
        this.sumSaleableInventoryNum = sumSaleableInventoryNum;
    }

    public Long getSumUnsaleableInventoryNum() {
        return sumUnsaleableInventoryNum;
    }

    public void setSumUnsaleableInventoryNum(Long sumUnsaleableInventoryNum) {
        this.sumUnsaleableInventoryNum = sumUnsaleableInventoryNum;
    }

    @Override
    public String toString() {
        return "JaloInventorySum{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", sumSaleableInventoryAmount=" + sumSaleableInventoryAmount +
                ", sumSaleableInventoryNum=" + sumSaleableInventoryNum +
                ", sumUnsaleableInventoryAmount=" + sumUnsaleableInventoryAmount +
                ", sumUnsaleableInventoryNum=" + sumUnsaleableInventoryNum +
                ", sumInventoryAmount=" + sumInventoryAmount +
                ", inventoryDetails=" + inventoryDetails +
                '}';
    }
}
