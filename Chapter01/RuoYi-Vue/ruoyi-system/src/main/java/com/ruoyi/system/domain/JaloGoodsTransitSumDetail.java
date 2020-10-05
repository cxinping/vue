package com.ruoyi.system.domain;

public class JaloGoodsTransitSumDetail {

    private Long sumamount;
    private Long sumnum;

    public Long getSumamount() {
        return sumamount;
    }

    public void setSumamount(Long sumamount) {
        this.sumamount = sumamount;
    }

    public Long getSumnum() {
        return sumnum;
    }

    public void setSumnum(Long sumnum) {
        this.sumnum = sumnum;
    }

    @Override
    public String toString() {
        return "JaloGoodsTransitSumDetail{" +
                "sumamount=" + sumamount +
                ", sumnum=" + sumnum +
                '}';
    }
}
