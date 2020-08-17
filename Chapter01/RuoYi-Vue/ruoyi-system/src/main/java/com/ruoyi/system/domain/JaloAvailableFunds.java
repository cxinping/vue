package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 可用资金对象 jalo_available_funds
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
public class JaloAvailableFunds extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 招行 */
    @Excel(name = "招行")
    private BigDecimal merchantsBank;

    /** 浦发 */
    @Excel(name = "浦发")
    private BigDecimal pufaBank;

    /** 工行 */
    @Excel(name = "工行")
    private BigDecimal icbcBank;

    /** 有赞 */
    @Excel(name = "有赞")
    private BigDecimal youZan;

    /** 支付宝 */
    @Excel(name = "支付宝")
    private BigDecimal alipay;

    /** 京东 */
    @Excel(name = "京东")
    private BigDecimal jingdong;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMerchantsBank(BigDecimal merchantsBank) 
    {
        this.merchantsBank = merchantsBank;
    }

    public BigDecimal getMerchantsBank() 
    {
        return merchantsBank;
    }
    public void setPufaBank(BigDecimal pufaBank) 
    {
        this.pufaBank = pufaBank;
    }

    public BigDecimal getPufaBank() 
    {
        return pufaBank;
    }
    public void setIcbcBank(BigDecimal icbcBank) 
    {
        this.icbcBank = icbcBank;
    }

    public BigDecimal getIcbcBank() 
    {
        return icbcBank;
    }
    public void setYouZan(BigDecimal youZan) 
    {
        this.youZan = youZan;
    }

    public BigDecimal getYouZan() 
    {
        return youZan;
    }
    public void setAlipay(BigDecimal alipay) 
    {
        this.alipay = alipay;
    }

    public BigDecimal getAlipay() 
    {
        return alipay;
    }
    public void setJingdong(BigDecimal jingdong) 
    {
        this.jingdong = jingdong;
    }

    public BigDecimal getJingdong() 
    {
        return jingdong;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("merchantsBank", getMerchantsBank())
            .append("pufaBank", getPufaBank())
            .append("icbcBank", getIcbcBank())
            .append("youZan", getYouZan())
            .append("alipay", getAlipay())
            .append("jingdong", getJingdong())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}