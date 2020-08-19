package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloInventoryDetail;

/**
 * 库存详细Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IJaloInventoryDetailService 
{
    /**
     * 查询库存详细
     * 
     * @param id 库存详细ID
     * @return 库存详细
     */
    public JaloInventoryDetail selectJaloInventoryDetailById(Long id);

    /**
     * 查询库存详细列表
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 库存详细集合
     */
    public List<JaloInventoryDetail> selectJaloInventoryDetailList(JaloInventoryDetail jaloInventoryDetail);

    /**
     * 新增库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    public int insertJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail);

    /**
     * 修改库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    public int updateJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail);

    /**
     * 批量删除库存详细
     * 
     * @param ids 需要删除的库存详细ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailByIds(Long[] ids);

    /**
     * 删除库存详细信息
     * 
     * @param id 库存详细ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailById(Long id);
}
