package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 已发货未结算金额对象 jalo_shipped_unsettled
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public class JaloShippedUnsettled extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 有赞 */
    @Excel(name = "有赞")
    private BigDecimal youzan;

    /** 淘宝 */
    @Excel(name = "淘宝")
    private BigDecimal taobao;

    /** 天猫 */
    @Excel(name = "天猫")
    private BigDecimal tianmao;

    /** 京东 */
    @Excel(name = "京东")
    private BigDecimal jingdong;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYouzan(BigDecimal youzan) 
    {
        this.youzan = youzan;
    }

    public BigDecimal getYouzan() 
    {
        return youzan;
    }
    public void setTaobao(BigDecimal taobao) 
    {
        this.taobao = taobao;
    }

    public BigDecimal getTaobao() 
    {
        return taobao;
    }
    public void setTianmao(BigDecimal tianmao) 
    {
        this.tianmao = tianmao;
    }

    public BigDecimal getTianmao() 
    {
        return tianmao;
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
        return "JaloShippedUnsettled{" +
                "id=" + id +
                ", youzan=" + youzan +
                ", taobao=" + taobao +
                ", tianmao=" + tianmao +
                ", jingdong=" + jingdong +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
