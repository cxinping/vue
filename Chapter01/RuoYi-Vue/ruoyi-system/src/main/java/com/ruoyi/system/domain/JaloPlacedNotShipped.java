package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 已下单未发货对象 jalo_placed_not_shipped
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public class JaloPlacedNotShipped extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 已下单未发货合计金额数 */
    @Excel(name = "已下单未发货合计金额数")
    private BigDecimal placedNotShipped;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlacedNotShipped(BigDecimal placedNotShipped) 
    {
        this.placedNotShipped = placedNotShipped;
    }

    public BigDecimal getPlacedNotShipped() 
    {
        return placedNotShipped;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("placedNotShipped", getPlacedNotShipped())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
