package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloInventoryDetail;

/**
 * 库存详细Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface JaloInventoryDetailMapper 
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


    public List<JaloInventoryDetail> selectJaloInventoryDetailListByInventorySumId(String jaloInventorySumId);

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
     * 删除库存详细
     * 
     * @param id 库存详细ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailById(Long id);

    public int deleteJaloInventoryDetailByInventorySumId(String jaloInventorySumId);

    /**
     * 批量删除库存详细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailByIds(Long[] ids);
}
