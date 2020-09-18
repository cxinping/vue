package com.ruoyi.system.vo;

public class SupplierVo {

    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SupplierVo{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
