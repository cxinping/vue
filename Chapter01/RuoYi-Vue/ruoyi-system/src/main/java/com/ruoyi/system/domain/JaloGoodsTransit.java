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
 * @date 2020-08-19
 */
public class JaloGoodsTransit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 建材 */
    @Excel(name = "建材")
    private BigDecimal buildingMaterials;

    /** 日用品 */
    @Excel(name = "日用品")
    private BigDecimal dailyNecessities;

    /** 电器 */
    @Excel(name = "电器")
    private BigDecimal device;

    /** 家具 */
    @Excel(name = "家具")
    private BigDecimal furniture;

    /** 厨房卫浴 */
    @Excel(name = "厨房卫浴")
    private BigDecimal kitchenBathroom;

    /** 灯具 */
    @Excel(name = "灯具")
    private BigDecimal lamps;

    /** 软装 */
    @Excel(name = "软装")
    private BigDecimal softOutfit;

    /** 纺织品 */
    @Excel(name = "纺织品")
    private BigDecimal textile;

    /** 其他 */
    @Excel(name = "其他")
    private BigDecimal other;

    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuildingMaterials(BigDecimal buildingMaterials) 
    {
        this.buildingMaterials = buildingMaterials;
    }

    public BigDecimal getBuildingMaterials() 
    {
        return buildingMaterials;
    }
    public void setDailyNecessities(BigDecimal dailyNecessities) 
    {
        this.dailyNecessities = dailyNecessities;
    }

    public BigDecimal getDailyNecessities() 
    {
        return dailyNecessities;
    }
    public void setDevice(BigDecimal device) 
    {
        this.device = device;
    }

    public BigDecimal getDevice() 
    {
        return device;
    }
    public void setFurniture(BigDecimal furniture) 
    {
        this.furniture = furniture;
    }

    public BigDecimal getFurniture() 
    {
        return furniture;
    }
    public void setKitchenBathroom(BigDecimal kitchenBathroom) 
    {
        this.kitchenBathroom = kitchenBathroom;
    }

    public BigDecimal getKitchenBathroom() 
    {
        return kitchenBathroom;
    }
    public void setLamps(BigDecimal lamps) 
    {
        this.lamps = lamps;
    }

    public BigDecimal getLamps() 
    {
        return lamps;
    }
    public void setSoftOutfit(BigDecimal softOutfit) 
    {
        this.softOutfit = softOutfit;
    }

    public BigDecimal getSoftOutfit() 
    {
        return softOutfit;
    }
    public void setTextile(BigDecimal textile) 
    {
        this.textile = textile;
    }

    public BigDecimal getTextile() 
    {
        return textile;
    }
    public void setOther(BigDecimal other) 
    {
        this.other = other;
    }

    public BigDecimal getOther() 
    {
        return other;
    }

    @Override
    public String toString() {
        return "JaloGoodsTransit{" +
                "id=" + id +
                ", buildingMaterials=" + buildingMaterials +
                ", dailyNecessities=" + dailyNecessities +
                ", device=" + device +
                ", furniture=" + furniture +
                ", kitchenBathroom=" + kitchenBathroom +
                ", lamps=" + lamps +
                ", softOutfit=" + softOutfit +
                ", textile=" + textile +
                ", other=" + other +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
