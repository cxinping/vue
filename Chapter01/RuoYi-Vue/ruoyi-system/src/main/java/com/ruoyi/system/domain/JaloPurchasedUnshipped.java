package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 已购买未发货对象 jalo_purchased_unshipped
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class JaloPurchasedUnshipped extends BaseEntity
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
    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("youzan", getYouzan())
            .append("taobao", getTaobao())
            .append("tianmao", getTianmao())
            .append("jingdong", getJingdong())
            .append("totalAmount", getTotalAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
