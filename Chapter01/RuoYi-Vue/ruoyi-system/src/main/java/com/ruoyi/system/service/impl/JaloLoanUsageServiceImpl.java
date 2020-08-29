package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloLoanUsageMapper;
import com.ruoyi.system.domain.JaloLoanUsage;
import com.ruoyi.system.service.IJaloLoanUsageService;

/**
 * 贷款使用Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-29
 */
@Service
public class JaloLoanUsageServiceImpl implements IJaloLoanUsageService 
{
    @Autowired
    private JaloLoanUsageMapper jaloLoanUsageMapper;

    /**
     * 查询贷款使用
     * 
     * @param id 贷款使用ID
     * @return 贷款使用
     */
    @Override
    public JaloLoanUsage selectJaloLoanUsageById(Long id)
    {
        return jaloLoanUsageMapper.selectJaloLoanUsageById(id);
    }

    /**
     * 查询贷款使用列表
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 贷款使用
     */
    @Override
    public List<JaloLoanUsage> selectJaloLoanUsageList(JaloLoanUsage jaloLoanUsage)
    {
        return jaloLoanUsageMapper.selectJaloLoanUsageList(jaloLoanUsage);
    }

    /**
     * 新增贷款使用
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 结果
     */
    @Override
    public int insertJaloLoanUsage(JaloLoanUsage jaloLoanUsage)
    {
        jaloLoanUsage.setCreateTime(DateUtils.getNowDate());
        return jaloLoanUsageMapper.insertJaloLoanUsage(jaloLoanUsage);
    }

    /**
     * 修改贷款使用
     * 
     * @param jaloLoanUsage 贷款使用
     * @return 结果
     */
    @Override
    public int updateJaloLoanUsage(JaloLoanUsage jaloLoanUsage)
    {
        jaloLoanUsage.setUpdateTime(DateUtils.getNowDate());
        return jaloLoanUsageMapper.updateJaloLoanUsage(jaloLoanUsage);
    }

    /**
     * 批量删除贷款使用
     * 
     * @param ids 需要删除的贷款使用ID
     * @return 结果
     */
    @Override
    public int deleteJaloLoanUsageByIds(Long[] ids)
    {
        return jaloLoanUsageMapper.deleteJaloLoanUsageByIds(ids);
    }

    /**
     * 删除贷款使用信息
     * 
     * @param id 贷款使用ID
     * @return 结果
     */
    @Override
    public int deleteJaloLoanUsageById(Long id)
    {
        return jaloLoanUsageMapper.deleteJaloLoanUsageById(id);
    }
}
