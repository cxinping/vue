package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 贷款使用对象 jalo_loan_usage
 * 
 * @author ruoyi
 * @date 2020-08-29
 */
public class JaloLoanUsage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 贷款授信金额 */
    @Excel(name = "贷款授信金额")
    private BigDecimal loanCreditAmount;

    /** 贷款授信余额 */
    @Excel(name = "贷款授信余额")
    private BigDecimal loanCreditBalance;

    /** 剩余可使用额度 */
    @Excel(name = "剩余可使用额度")
    private BigDecimal loanCreditRemaining;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoanCreditAmount(BigDecimal loanCreditAmount) 
    {
        this.loanCreditAmount = loanCreditAmount;
    }

    public BigDecimal getLoanCreditAmount() 
    {
        return loanCreditAmount;
    }
    public void setLoanCreditBalance(BigDecimal loanCreditBalance) 
    {
        this.loanCreditBalance = loanCreditBalance;
    }

    public BigDecimal getLoanCreditBalance() 
    {
        return loanCreditBalance;
    }
    public void setLoanCreditRemaining(BigDecimal loanCreditRemaining) 
    {
        this.loanCreditRemaining = loanCreditRemaining;
    }

    public BigDecimal getLoanCreditRemaining() 
    {
        return loanCreditRemaining;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loanCreditAmount", getLoanCreditAmount())
            .append("loanCreditBalance", getLoanCreditBalance())
            .append("loanCreditRemaining", getLoanCreditRemaining())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
