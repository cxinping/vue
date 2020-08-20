package com.ruoyi.system.util;

public enum InventoryTypeEnum {

    Building_Materials(1) , Daily_Necessities(2), Electrical_Appliances(3), Furniture(4),
    Kitchen_Bathroom(5) , Lamps(6) , Soft_Outfit(7), Textile(8) , Other(9);


    private int orderNum;

    private InventoryTypeEnum(int orderNum ){
        this.orderNum=orderNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public static InventoryTypeEnum getEnumByType(int orderNum){
        for(InventoryTypeEnum item:values()){
            if(item.orderNum == orderNum ){
                return item;
            }
        }
        return null;
    }

}
