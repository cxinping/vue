package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在途物资详细对象 jalo_goods_transit_detail
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
public class JaloGoodsTransitDetail extends BaseEntity implements Comparable<JaloGoodsTransitDetail>
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String product;

    /** 供应商 */
    @Excel(name = "供应商")
    private String support;

    /** 采购订单号 */
    @Excel(name = "采购订单号")
    private String purchaseOrderNumber;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 金额 */
    @Excel(name = "金额")
    private Long amount;

    /** 顺序号 */
    @Excel(name = "顺序号")
    private Integer orderNumber;

    /** $column.columnComment */
    @Excel(name = "顺序号")
    private String jaloGoodsTransitSumId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
    public void setSupport(String support) 
    {
        this.support = support;
    }

    public String getSupport() 
    {
        return support;
    }
    public void setPurchaseOrderNumber(String purchaseOrderNumber) 
    {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPurchaseOrderNumber() 
    {
        return purchaseOrderNumber;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    public void setOrderNumber(Integer orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber()
    {
        return orderNumber;
    }
    public void setJaloGoodsTransitSumId(String jaloGoodsTransitSumId) 
    {
        this.jaloGoodsTransitSumId = jaloGoodsTransitSumId;
    }

    public String getJaloGoodsTransitSumId() 
    {
        return jaloGoodsTransitSumId;
    }

    @Override
    public String toString() {
        return "JaloGoodsTransitDetail{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", support='" + support + '\'' +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", num=" + num +
                ", amount=" + amount +
                ", orderNumber=" + orderNumber +
                ", jaloGoodsTransitSumId='" + jaloGoodsTransitSumId + '\'' +
                '}';
    }

    @Override
    public int compareTo(JaloGoodsTransitDetail goodsTransitDetail) {
        return this.orderNumber- goodsTransitDetail.getOrderNumber();
    }

}
