package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloInventorySumMapper;
import com.ruoyi.system.domain.JaloInventorySum;
import com.ruoyi.system.service.IJaloInventorySumService;

/**
 * 库存汇总Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloInventorySumServiceImpl implements IJaloInventorySumService 
{
    @Autowired
    private JaloInventorySumMapper jaloInventorySumMapper;

    /**
     * 查询库存汇总
     * 
     * @param id 库存汇总ID
     * @return 库存汇总
     */
    @Override
    public JaloInventorySum selectJaloInventorySumById(Long id)
    {
        return jaloInventorySumMapper.selectJaloInventorySumById(id);
    }

    /**
     * 查询库存汇总列表
     * 
     * @param jaloInventorySum 库存汇总
     * @return 库存汇总
     */
    @Override
    public List<JaloInventorySum> selectJaloInventorySumList(JaloInventorySum jaloInventorySum)
    {
        return jaloInventorySumMapper.selectJaloInventorySumList(jaloInventorySum);
    }

    /**
     * 新增库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    @Override
    public int insertJaloInventorySum(JaloInventorySum jaloInventorySum)
    {
        jaloInventorySum.setCreateTime(DateUtils.getNowDate());
        return jaloInventorySumMapper.insertJaloInventorySum(jaloInventorySum);
    }

    /**
     * 修改库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    @Override
    public int updateJaloInventorySum(JaloInventorySum jaloInventorySum)
    {
        jaloInventorySum.setUpdateTime(DateUtils.getNowDate());
        return jaloInventorySumMapper.updateJaloInventorySum(jaloInventorySum);
    }

    /**
     * 批量删除库存汇总
     * 
     * @param ids 需要删除的库存汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventorySumByIds(Long[] ids)
    {
        return jaloInventorySumMapper.deleteJaloInventorySumByIds(ids);
    }

    /**
     * 删除库存汇总信息
     * 
     * @param id 库存汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventorySumById(Long id)
    {
        return jaloInventorySumMapper.deleteJaloInventorySumById(id);
    }
}
