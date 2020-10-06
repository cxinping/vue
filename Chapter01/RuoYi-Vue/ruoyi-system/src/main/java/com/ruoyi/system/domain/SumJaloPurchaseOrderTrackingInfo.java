package com.ruoyi.system.domain;

import java.math.BigDecimal;

public class SumJaloPurchaseOrderTrackingInfo {

    /** 汇总合同金额 */
    private BigDecimal sumContractAmount;

    /** 汇总应付预付款金额 */
    private BigDecimal sumPrepaymentAmountPayable;

    /** 汇总已付预付款金额 */
    private BigDecimal sumPrepaymentAmountPaid;

    public BigDecimal getSumContractAmount() {
        return sumContractAmount;
    }

    public void setSumContractAmount(BigDecimal sumContractAmount) {
        this.sumContractAmount = sumContractAmount;
    }

    public BigDecimal getSumPrepaymentAmountPayable() {
        return sumPrepaymentAmountPayable;
    }

    public void setSumPrepaymentAmountPayable(BigDecimal sumPrepaymentAmountPayable) {
        this.sumPrepaymentAmountPayable = sumPrepaymentAmountPayable;
    }

    public BigDecimal getSumPrepaymentAmountPaid() {
        return sumPrepaymentAmountPaid;
    }

    public void setSumPrepaymentAmountPaid(BigDecimal sumPrepaymentAmountPaid) {
        this.sumPrepaymentAmountPaid = sumPrepaymentAmountPaid;
    }

    @Override
    public String toString() {
        return "SumJaloPurchaseOrderTrackingInfo{" +
                "sumContractAmount=" + sumContractAmount +
                ", sumPrepaymentAmountPayable=" + sumPrepaymentAmountPayable +
                ", sumPrepaymentAmountPaid=" + sumPrepaymentAmountPaid +
                '}';
    }
}
