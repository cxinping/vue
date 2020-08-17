package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloLoanUsageTableMapper;
import com.ruoyi.system.domain.JaloLoanUsageTable;
import com.ruoyi.system.service.IJaloLoanUsageTableService;

/**
 * 贷款使用Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
@Service
public class JaloLoanUsageTableServiceImpl implements IJaloLoanUsageTableService 
{
    @Autowired
    private JaloLoanUsageTableMapper jaloLoanUsageTableMapper;

    /**
     * 查询贷款使用
     * 
     * @param id 贷款使用ID
     * @return 贷款使用
     */
    @Override
    public JaloLoanUsageTable selectJaloLoanUsageTableById(Long id)
    {
        return jaloLoanUsageTableMapper.selectJaloLoanUsageTableById(id);
    }

    /**
     * 查询贷款使用列表
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 贷款使用
     */
    @Override
    public List<JaloLoanUsageTable> selectJaloLoanUsageTableList(JaloLoanUsageTable jaloLoanUsageTable)
    {
        return jaloLoanUsageTableMapper.selectJaloLoanUsageTableList(jaloLoanUsageTable);
    }

    /**
     * 新增贷款使用
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 结果
     */
    @Override
    public int insertJaloLoanUsageTable(JaloLoanUsageTable jaloLoanUsageTable)
    {
        jaloLoanUsageTable.setCreateTime(DateUtils.getNowDate());
        return jaloLoanUsageTableMapper.insertJaloLoanUsageTable(jaloLoanUsageTable);
    }

    /**
     * 修改贷款使用
     * 
     * @param jaloLoanUsageTable 贷款使用
     * @return 结果
     */
    @Override
    public int updateJaloLoanUsageTable(JaloLoanUsageTable jaloLoanUsageTable)
    {
        jaloLoanUsageTable.setUpdateTime(DateUtils.getNowDate());
        return jaloLoanUsageTableMapper.updateJaloLoanUsageTable(jaloLoanUsageTable);
    }

    /**
     * 批量删除贷款使用
     * 
     * @param ids 需要删除的贷款使用ID
     * @return 结果
     */
    @Override
    public int deleteJaloLoanUsageTableByIds(Long[] ids)
    {
        return jaloLoanUsageTableMapper.deleteJaloLoanUsageTableByIds(ids);
    }

    /**
     * 删除贷款使用信息
     * 
     * @param id 贷款使用ID
     * @return 结果
     */
    @Override
    public int deleteJaloLoanUsageTableById(Long id)
    {
        return jaloLoanUsageTableMapper.deleteJaloLoanUsageTableById(id);
    }
}
