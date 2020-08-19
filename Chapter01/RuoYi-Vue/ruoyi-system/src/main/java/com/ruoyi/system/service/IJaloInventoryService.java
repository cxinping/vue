package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloInventory;

/**
 * 库存Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IJaloInventoryService 
{
    /**
     * 查询库存
     * 
     * @param id 库存ID
     * @return 库存
     */
    public JaloInventory selectJaloInventoryById(Long id);

    /**
     * 查询库存列表
     * 
     * @param jaloInventory 库存
     * @return 库存集合
     */
    public List<JaloInventory> selectJaloInventoryList(JaloInventory jaloInventory);

    /**
     * 新增库存
     * 
     * @param jaloInventory 库存
     * @return 结果
     */
    public int insertJaloInventory(JaloInventory jaloInventory);

    /**
     * 修改库存
     * 
     * @param jaloInventory 库存
     * @return 结果
     */
    public int updateJaloInventory(JaloInventory jaloInventory);

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的库存ID
     * @return 结果
     */
    public int deleteJaloInventoryByIds(Long[] ids);

    /**
     * 删除库存信息
     * 
     * @param id 库存ID
     * @return 结果
     */
    public int deleteJaloInventoryById(Long id);
}
