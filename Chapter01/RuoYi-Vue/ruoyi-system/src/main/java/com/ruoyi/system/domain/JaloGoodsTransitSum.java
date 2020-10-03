package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在途物资汇总对象 jalo_goods_transit_sum
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
public class JaloGoodsTransitSum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String product;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalAmount;

    /** 合计数量 */
    @Excel(name = "合计数量")
    private BigDecimal totalNum;

    private List<JaloGoodsTransitDetail> transitDetails = null;

    public List<JaloGoodsTransitDetail> getTransitDetails() {
        return transitDetails;
    }

    public void setTransitDetails(List<JaloGoodsTransitDetail> transitDetails) {
        this.transitDetails = transitDetails;
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
    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }
    public void setTotalNum(BigDecimal totalNum) 
    {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalNum() 
    {
        return totalNum;
    }

    @Override
    public String toString() {
        return "JaloGoodsTransitSum{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", totalAmount=" + totalAmount +
                ", totalNum=" + totalNum +
                ", transitDetails=" + transitDetails +
                '}';
    }
}
