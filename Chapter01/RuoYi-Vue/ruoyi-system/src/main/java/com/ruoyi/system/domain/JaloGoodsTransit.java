package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在途物资对象 jalo_goods_transit
 * 
 * @author ruoyi
 * @date 2020-09-19
 */
public class JaloGoodsTransit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 采购订单号 */
    @Excel(name = "采购订单号")
    private String purchaseOrderNumber;

    /** 建材 */
    @Excel(name = "建材")
    private BigDecimal buildingMaterials;

    /** 建材数量 */
    @Excel(name = "建材数量")
    private BigDecimal buildingMaterialsNum;

    /** 日用品 */
    @Excel(name = "日用品")
    private BigDecimal dailyNecessities;

    /** 日用品数量 */
    @Excel(name = "日用品数量")
    private BigDecimal dailyNecessitiesNum;

    /** 电器 */
    @Excel(name = "电器")
    private BigDecimal device;

    /** 电器数量 */
    @Excel(name = "电器数量")
    private BigDecimal deviceNum;

    /** 家具 */
    @Excel(name = "家具")
    private BigDecimal furniture;

    /** 家具数量 */
    @Excel(name = "家具数量")
    private BigDecimal furnitureNum;

    /** 厨房卫浴 */
    @Excel(name = "厨房卫浴")
    private BigDecimal kitchenBathroom;

    /** 厨房卫浴数量 */
    @Excel(name = "厨房卫浴数量")
    private BigDecimal kitchenBathroomNum;

    /** 灯具 */
    @Excel(name = "灯具")
    private BigDecimal lamps;

    /** 灯具数量 */
    @Excel(name = "灯具数量")
    private BigDecimal lampsNum;

    /** 软装 */
    @Excel(name = "软装")
    private BigDecimal softOutfit;

    /** 软装数量 */
    @Excel(name = "软装数量")
    private BigDecimal softOutfitNum;

    /** 纺织品 */
    @Excel(name = "纺织品")
    private BigDecimal textile;

    /** 纺织品数量 */
    @Excel(name = "纺织品数量")
    private BigDecimal textileNum;

    /** 其他 */
    @Excel(name = "其他")
    private BigDecimal other;

    /** 其他数量 */
    @Excel(name = "其他数量")
    private BigDecimal otherNum;

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
    public void setPurchaseOrderNumber(String purchaseOrderNumber) 
    {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPurchaseOrderNumber() 
    {
        return purchaseOrderNumber;
    }
    public void setBuildingMaterials(BigDecimal buildingMaterials) 
    {
        this.buildingMaterials = buildingMaterials;
    }

    public BigDecimal getBuildingMaterials() 
    {
        return buildingMaterials;
    }
    public void setBuildingMaterialsNum(BigDecimal buildingMaterialsNum) 
    {
        this.buildingMaterialsNum = buildingMaterialsNum;
    }

    public BigDecimal getBuildingMaterialsNum() 
    {
        return buildingMaterialsNum;
    }
    public void setDailyNecessities(BigDecimal dailyNecessities) 
    {
        this.dailyNecessities = dailyNecessities;
    }

    public BigDecimal getDailyNecessities() 
    {
        return dailyNecessities;
    }
    public void setDailyNecessitiesNum(BigDecimal dailyNecessitiesNum) 
    {
        this.dailyNecessitiesNum = dailyNecessitiesNum;
    }

    public BigDecimal getDailyNecessitiesNum() 
    {
        return dailyNecessitiesNum;
    }
    public void setDevice(BigDecimal device) 
    {
        this.device = device;
    }

    public BigDecimal getDevice() 
    {
        return device;
    }
    public void setDeviceNum(BigDecimal deviceNum) 
    {
        this.deviceNum = deviceNum;
    }

    public BigDecimal getDeviceNum() 
    {
        return deviceNum;
    }
    public void setFurniture(BigDecimal furniture) 
    {
        this.furniture = furniture;
    }

    public BigDecimal getFurniture() 
    {
        return furniture;
    }
    public void setFurnitureNum(BigDecimal furnitureNum) 
    {
        this.furnitureNum = furnitureNum;
    }

    public BigDecimal getFurnitureNum() 
    {
        return furnitureNum;
    }
    public void setKitchenBathroom(BigDecimal kitchenBathroom) 
    {
        this.kitchenBathroom = kitchenBathroom;
    }

    public BigDecimal getKitchenBathroom() 
    {
        return kitchenBathroom;
    }
    public void setKitchenBathroomNum(BigDecimal kitchenBathroomNum) 
    {
        this.kitchenBathroomNum = kitchenBathroomNum;
    }

    public BigDecimal getKitchenBathroomNum() 
    {
        return kitchenBathroomNum;
    }
    public void setLamps(BigDecimal lamps) 
    {
        this.lamps = lamps;
    }

    public BigDecimal getLamps() 
    {
        return lamps;
    }
    public void setLampsNum(BigDecimal lampsNum) 
    {
        this.lampsNum = lampsNum;
    }

    public BigDecimal getLampsNum() 
    {
        return lampsNum;
    }
    public void setSoftOutfit(BigDecimal softOutfit) 
    {
        this.softOutfit = softOutfit;
    }

    public BigDecimal getSoftOutfit() 
    {
        return softOutfit;
    }
    public void setSoftOutfitNum(BigDecimal softOutfitNum) 
    {
        this.softOutfitNum = softOutfitNum;
    }

    public BigDecimal getSoftOutfitNum() 
    {
        return softOutfitNum;
    }
    public void setTextile(BigDecimal textile) 
    {
        this.textile = textile;
    }

    public BigDecimal getTextile() 
    {
        return textile;
    }
    public void setTextileNum(BigDecimal textileNum) 
    {
        this.textileNum = textileNum;
    }

    public BigDecimal getTextileNum() 
    {
        return textileNum;
    }
    public void setOther(BigDecimal other) 
    {
        this.other = other;
    }

    public BigDecimal getOther() 
    {
        return other;
    }
    public void setOtherNum(BigDecimal otherNum) 
    {
        this.otherNum = otherNum;
    }

    public BigDecimal getOtherNum() 
    {
        return otherNum;
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
            .append("purchaseOrderNumber", getPurchaseOrderNumber())
            .append("buildingMaterials", getBuildingMaterials())
            .append("buildingMaterialsNum", getBuildingMaterialsNum())
            .append("dailyNecessities", getDailyNecessities())
            .append("dailyNecessitiesNum", getDailyNecessitiesNum())
            .append("device", getDevice())
            .append("deviceNum", getDeviceNum())
            .append("furniture", getFurniture())
            .append("furnitureNum", getFurnitureNum())
            .append("kitchenBathroom", getKitchenBathroom())
            .append("kitchenBathroomNum", getKitchenBathroomNum())
            .append("lamps", getLamps())
            .append("lampsNum", getLampsNum())
            .append("softOutfit", getSoftOutfit())
            .append("softOutfitNum", getSoftOutfitNum())
            .append("textile", getTextile())
            .append("textileNum", getTextileNum())
            .append("other", getOther())
            .append("otherNum", getOtherNum())
            .append("totalAmount", getTotalAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
