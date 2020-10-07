package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class JaloInventoryDetailSum {

    /** 可销售库存数量汇总 */
    private Long saleableInventorySumNum;

    /** 可销售库存金额汇总 */
    private BigDecimal saleableInventorySumAmount;

    /** 不可销售库存数量 */
    private Long unsaleableInventorySumNum;

    /** 不可销售库存金额汇总 */
    private BigDecimal unsaleableInventorySumAmount;

    /** 合计金额汇总 */
    private BigDecimal inventorySumAmount;

    public Long getSaleableInventorySumNum() {
        return saleableInventorySumNum;
    }

    public void setSaleableInventorySumNum(Long saleableInventorySumNum) {
        this.saleableInventorySumNum = saleableInventorySumNum;
    }

    public Long getUnsaleableInventorySumNum() {
        return unsaleableInventorySumNum;
    }

    public void setUnsaleableInventorySumNum(Long unsaleableInventorySumNum) {
        this.unsaleableInventorySumNum = unsaleableInventorySumNum;
    }

    public BigDecimal getSaleableInventorySumAmount() {
        return saleableInventorySumAmount;
    }

    public void setSaleableInventorySumAmount(BigDecimal saleableInventorySumAmount) {
        this.saleableInventorySumAmount = saleableInventorySumAmount;
    }

    public BigDecimal getUnsaleableInventorySumAmount() {
        return unsaleableInventorySumAmount;
    }

    public void setUnsaleableInventorySumAmount(BigDecimal unsaleableInventorySumAmount) {
        this.unsaleableInventorySumAmount = unsaleableInventorySumAmount;
    }

    public BigDecimal getInventorySumAmount() {
        return inventorySumAmount;
    }

    public void setInventorySumAmount(BigDecimal inventorySumAmount) {
        this.inventorySumAmount = inventorySumAmount;
    }

    @Override
    public String toString() {
        return "JaloInventoryDetailSum{" +
                "saleableInventorySumNum=" + saleableInventorySumNum +
                ", saleableInventorySumAmount=" + saleableInventorySumAmount +
                ", unsaleableInventorySumNum=" + unsaleableInventorySumNum +
                ", unsaleableInventorySumAmount=" + unsaleableInventorySumAmount +
                ", inventorySumAmount=" + inventorySumAmount +
                '}';
    }
}
