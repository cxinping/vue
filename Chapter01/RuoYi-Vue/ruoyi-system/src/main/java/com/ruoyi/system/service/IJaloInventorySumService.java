package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloInventorySum;

/**
 * 库存汇总Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IJaloInventorySumService 
{
    /**
     * 查询库存汇总
     * 
     * @param id 库存汇总ID
     * @return 库存汇总
     */
    public JaloInventorySum selectJaloInventorySumById(Long id);

    /**
     * 查询库存汇总列表
     * 
     * @param jaloInventorySum 库存汇总
     * @return 库存汇总集合
     */
    public List<JaloInventorySum> selectJaloInventorySumList(JaloInventorySum jaloInventorySum);

    /**
     * 新增库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    public int insertJaloInventorySum(JaloInventorySum jaloInventorySum);

    /**
     * 修改库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    public int updateJaloInventorySum(JaloInventorySum jaloInventorySum);

    /**
     * 批量删除库存汇总
     * 
     * @param ids 需要删除的库存汇总ID
     * @return 结果
     */
    public int deleteJaloInventorySumByIds(String[] ids);

    /**
     * 删除库存汇总信息
     * 
     * @param id 库存汇总ID
     * @return 结果
     */
    public int deleteJaloInventorySumById(String id);
}
