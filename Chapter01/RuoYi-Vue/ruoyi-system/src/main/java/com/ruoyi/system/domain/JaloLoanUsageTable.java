package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 贷款使用对象 jalo_loan_usage_table
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
public class JaloLoanUsageTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 贷款授信金额 */
    @Excel(name = "贷款授信金额")
    private Long loanCreditAmount;

    /** 贷款授信余额 */
    @Excel(name = "贷款授信余额")
    private Long loanCreditBalance;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoanCreditAmount(Long loanCreditAmount) 
    {
        this.loanCreditAmount = loanCreditAmount;
    }

    public Long getLoanCreditAmount() 
    {
        return loanCreditAmount;
    }
    public void setLoanCreditBalance(Long loanCreditBalance) 
    {
        this.loanCreditBalance = loanCreditBalance;
    }

    public Long getLoanCreditBalance() 
    {
        return loanCreditBalance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("loanCreditAmount", getLoanCreditAmount())
            .append("loanCreditBalance", getLoanCreditBalance())
            .toString();
    }
}
