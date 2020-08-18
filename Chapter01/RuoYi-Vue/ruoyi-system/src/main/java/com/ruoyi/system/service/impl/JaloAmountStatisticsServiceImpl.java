package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloAmountStatisticsMapper;
import com.ruoyi.system.domain.JaloAmountStatistics;
import com.ruoyi.system.service.IJaloAmountStatisticsService;

/**
 * 统计页面Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@Service
public class JaloAmountStatisticsServiceImpl implements IJaloAmountStatisticsService 
{
    @Autowired
    private JaloAmountStatisticsMapper jaloAmountStatisticsMapper;

    /**
     * 查询统计页面
     * 
     * @param id 统计页面ID
     * @return 统计页面
     */
    @Override
    public JaloAmountStatistics selectJaloAmountStatisticsById(Long id)
    {
        return jaloAmountStatisticsMapper.selectJaloAmountStatisticsById(id);
    }

    /**
     * 查询统计页面列表
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 统计页面
     */
    @Override
    public List<JaloAmountStatistics> selectJaloAmountStatisticsList(JaloAmountStatistics jaloAmountStatistics)
    {
        return jaloAmountStatisticsMapper.selectJaloAmountStatisticsList(jaloAmountStatistics);
    }

    /**
     * 新增统计页面
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 结果
     */
    @Override
    public int insertJaloAmountStatistics(JaloAmountStatistics jaloAmountStatistics)
    {
        return jaloAmountStatisticsMapper.insertJaloAmountStatistics(jaloAmountStatistics);
    }

    /**
     * 修改统计页面
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 结果
     */
    @Override
    public int updateJaloAmountStatistics(JaloAmountStatistics jaloAmountStatistics)
    {
        return jaloAmountStatisticsMapper.updateJaloAmountStatistics(jaloAmountStatistics);
    }

    /**
     * 批量删除统计页面
     * 
     * @param ids 需要删除的统计页面ID
     * @return 结果
     */
    @Override
    public int deleteJaloAmountStatisticsByIds(Long[] ids)
    {
        return jaloAmountStatisticsMapper.deleteJaloAmountStatisticsByIds(ids);
    }

    /**
     * 删除统计页面信息
     * 
     * @param id 统计页面ID
     * @return 结果
     */
    @Override
    public int deleteJaloAmountStatisticsById(Long id)
    {
        return jaloAmountStatisticsMapper.deleteJaloAmountStatisticsById(id);
    }
}
