package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloInventoryMapper;
import com.ruoyi.system.domain.JaloInventory;
import com.ruoyi.system.service.IJaloInventoryService;

/**
 * 库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloInventoryServiceImpl implements IJaloInventoryService 
{
    @Autowired
    private JaloInventoryMapper jaloInventoryMapper;

    /**
     * 查询库存
     * 
     * @param id 库存ID
     * @return 库存
     */
    @Override
    public JaloInventory selectJaloInventoryById(Long id)
    {
        return jaloInventoryMapper.selectJaloInventoryById(id);
    }

    /**
     * 查询库存列表
     * 
     * @param jaloInventory 库存
     * @return 库存
     */
    @Override
    public List<JaloInventory> selectJaloInventoryList(JaloInventory jaloInventory)
    {
        return jaloInventoryMapper.selectJaloInventoryList(jaloInventory);
    }

    /**
     * 新增库存
     * 
     * @param jaloInventory 库存
     * @return 结果
     */
    @Override
    public int insertJaloInventory(JaloInventory jaloInventory)
    {
        jaloInventory.setCreateTime(DateUtils.getNowDate());
        return jaloInventoryMapper.insertJaloInventory(jaloInventory);
    }

    /**
     * 修改库存
     * 
     * @param jaloInventory 库存
     * @return 结果
     */
    @Override
    public int updateJaloInventory(JaloInventory jaloInventory)
    {
        jaloInventory.setUpdateTime(DateUtils.getNowDate());
        return jaloInventoryMapper.updateJaloInventory(jaloInventory);
    }

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的库存ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryByIds(Long[] ids)
    {
        return jaloInventoryMapper.deleteJaloInventoryByIds(ids);
    }

    /**
     * 删除库存信息
     * 
     * @param id 库存ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryById(Long id)
    {
        return jaloInventoryMapper.deleteJaloInventoryById(id);
    }
}
