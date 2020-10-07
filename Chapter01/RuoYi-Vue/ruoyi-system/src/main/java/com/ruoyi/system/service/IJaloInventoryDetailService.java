package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.JaloInventoryDetail;
import com.ruoyi.system.domain.JaloInventoryDetailSum;

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
    public JaloInventoryDetail selectJaloInventoryDetailById(String id);

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
     * 批量删除库存详细
     * 
     * @param ids 需要删除的库存详细ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailByIds(String[] ids);

    public int deleteJaloInventoryDetailByInventorySumId(String jaloInventorySumId);

    /**
     * 删除库存详细信息
     * 
     * @param id 库存详细ID
     * @return 结果
     */
    public int deleteJaloInventoryDetailById(String id);

    public List<JaloInventoryDetail> selectJaloInventoryDetailListByParentid(String parentid);

    public JaloInventoryDetail selectJaloInventoryDetailRoot();

    public JaloInventoryDetail treeJaloInventoryDetailList(JaloInventoryDetail jaloInventoryDetail);

    public void callInventoryDetailSum(JaloInventoryDetail inventoryDetail );

    public JaloInventoryDetailSum calJaloInventoryDetailSum(String parentid);

    public AjaxResult exportExcel(List<JaloInventoryDetail> list, String sheetName);

}
