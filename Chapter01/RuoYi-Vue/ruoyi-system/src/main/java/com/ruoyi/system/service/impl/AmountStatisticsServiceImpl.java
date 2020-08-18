package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AmountStatisticsMapper;
import com.ruoyi.system.domain.AmountStatistics;
import com.ruoyi.system.service.IAmountStatisticsService;

/**
 * 统计页面Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@Service
public class AmountStatisticsServiceImpl implements IAmountStatisticsService 
{
    @Autowired
    private AmountStatisticsMapper amountStatisticsMapper;

    /**
     * 查询统计页面
     * 
     * @param id 统计页面ID
     * @return 统计页面
     */
    @Override
    public AmountStatistics selectAmountStatisticsById(Long id)
    {
        return amountStatisticsMapper.selectAmountStatisticsById(id);
    }

    /**
     * 查询统计页面列表
     * 
     * @param amountStatistics 统计页面
     * @return 统计页面
     */
    @Override
    public List<AmountStatistics> selectAmountStatisticsList(AmountStatistics amountStatistics)
    {
        return amountStatisticsMapper.selectAmountStatisticsList(amountStatistics);
    }

    /**
     * 新增统计页面
     * 
     * @param amountStatistics 统计页面
     * @return 结果
     */
    @Override
    public int insertAmountStatistics(AmountStatistics amountStatistics)
    {
        return amountStatisticsMapper.insertAmountStatistics(amountStatistics);
    }

    /**
     * 修改统计页面
     * 
     * @param amountStatistics 统计页面
     * @return 结果
     */
    @Override
    public int updateAmountStatistics(AmountStatistics amountStatistics)
    {
        return amountStatisticsMapper.updateAmountStatistics(amountStatistics);
    }

    /**
     * 批量删除统计页面
     * 
     * @param ids 需要删除的统计页面ID
     * @return 结果
     */
    @Override
    public int deleteAmountStatisticsByIds(Long[] ids)
    {
        return amountStatisticsMapper.deleteAmountStatisticsByIds(ids);
    }

    /**
     * 删除统计页面信息
     * 
     * @param id 统计页面ID
     * @return 结果
     */
    @Override
    public int deleteAmountStatisticsById(Long id)
    {
        return amountStatisticsMapper.deleteAmountStatisticsById(id);
    }
}
