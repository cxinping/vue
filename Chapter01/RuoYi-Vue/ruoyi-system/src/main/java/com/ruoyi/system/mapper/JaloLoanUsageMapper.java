package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloLoanUsage;

/**
 * 贷款使用Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-29
 */
public interface JaloLoanUsageMapper 
{
    /**
     * 查询贷款使用
     * 
     * @param id 贷款使用ID
     * @return 贷款使用
     */
    public JaloLoanUsage selectJaloLoanUsageById(Long id);

    /**
     * 查询贷款使用列表
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 贷款使用集合
     */
    public List<JaloLoanUsage> selectJaloLoanUsageList(JaloLoanUsage jaloLoanUsage);

    /**
     * 新增贷款使用
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 结果
     */
    public int insertJaloLoanUsage(JaloLoanUsage jaloLoanUsage);

    /**
     * 修改贷款使用
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 结果
     */
    public int updateJaloLoanUsage(JaloLoanUsage jaloLoanUsage);

    /**
     * 删除贷款使用
     * 
     * @param id 贷款使用ID
     * @return 结果
     */
    public int deleteJaloLoanUsageById(Long id);

    /**
     * 批量删除贷款使用
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloLoanUsageByIds(Long[] ids);
}
