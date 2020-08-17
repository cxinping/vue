package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloLoanUsageTable;

/**
 * 贷款使用Service接口
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
public interface IJaloLoanUsageTableService 
{
    /**
     * 查询贷款使用
     * 
     * @param id 贷款使用ID
     * @return 贷款使用
     */
    public JaloLoanUsageTable selectJaloLoanUsageTableById(Long id);

    /**
     * 查询贷款使用列表
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 贷款使用集合
     */
    public List<JaloLoanUsageTable> selectJaloLoanUsageTableList(JaloLoanUsageTable jaloLoanUsageTable);

    /**
     * 新增贷款使用
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 结果
     */
    public int insertJaloLoanUsageTable(JaloLoanUsageTable jaloLoanUsageTable);

    /**
     * 修改贷款使用
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 结果
     */
    public int updateJaloLoanUsageTable(JaloLoanUsageTable jaloLoanUsageTable);

    /**
     * 批量删除贷款使用
     * 
     * @param ids 需要删除的贷款使用ID
     * @return 结果
     */
    public int deleteJaloLoanUsageTableByIds(Long[] ids);

    /**
     * 删除贷款使用信息
     * 
     * @param id 贷款使用ID
     * @return 结果
     */
    public int deleteJaloLoanUsageTableById(Long id);
}
