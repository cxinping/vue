package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

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

    /** 可销售库存数量 */
    @Excel(name = "可销售库存数量")
    private Long saleableInventoryNum;

    /** 可销售库存金额 */
    @Excel(name = "可销售库存金额")
    private BigDecimal saleableInventoryAmount;

    /** 不可销售库存数量 */
    @Excel(name = "不可销售库存数量")
    private Long unsaleableInventoryNum;

    /** 不可销售库存金额 */
    @Excel(name = "不可销售库存金额")
    private BigDecimal unsaleableInventoryAmount;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal inventoryAmount;

    /** 顺序号 */
    @Excel(name = "顺序号")
    private Integer orderNum;

    /** $column.columnComment */
    @Excel(name = "顺序号")
    private String jaloInventorySumId;

    private String parentid;

    private String nodetype;

    private List<JaloInventoryDetail>  children;

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public Long getSaleableInventoryNum() {
        return saleableInventoryNum;
    }

    public void setSaleableInventoryNum(Long saleableInventoryNum) {
        this.saleableInventoryNum = saleableInventoryNum;
    }

    public Long getUnsaleableInventoryNum() {
        return unsaleableInventoryNum;
    }

    public void setUnsaleableInventoryNum(Long unsaleableInventoryNum) {
        this.unsaleableInventoryNum = unsaleableInventoryNum;
    }

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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public List<JaloInventoryDetail> getChildren() {
        return children;
    }

    public void setChildren(List<JaloInventoryDetail> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "JaloInventoryDetail{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", saleableInventoryNum=" + saleableInventoryNum +
                ", saleableInventoryAmount=" + saleableInventoryAmount +
                ", unsaleableInventoryNum=" + unsaleableInventoryNum +
                ", unsaleableInventoryAmount=" + unsaleableInventoryAmount +
                ", inventoryAmount=" + inventoryAmount +
                ", orderNum=" + orderNum +
                ", jaloInventorySumId='" + jaloInventorySumId + '\'' +
                ", parentid='" + parentid + '\'' +
                ", children=" + children +
                ", nodetype='" + nodetype + '\'' +
                '}';
    }

    @Override
    public int compareTo(JaloInventoryDetail inventoryDetail) {
        return this.orderNum - inventoryDetail.getOrderNum();
    }
}
