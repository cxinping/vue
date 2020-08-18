package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AmountStatistics;

/**
 * 统计页面Service接口
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public interface IAmountStatisticsService 
{
    /**
     * 查询统计页面
     * 
     * @param id 统计页面ID
     * @return 统计页面
     */
    public AmountStatistics selectAmountStatisticsById(Long id);

    /**
     * 查询统计页面列表
     * 
     * @param amountStatistics 统计页面
     * @return 统计页面集合
     */
    public List<AmountStatistics> selectAmountStatisticsList(AmountStatistics amountStatistics);

    /**
     * 新增统计页面
     * 
     * @param amountStatistics 统计页面
     * @return 结果
     */
    public int insertAmountStatistics(AmountStatistics amountStatistics);

    /**
     * 修改统计页面
     * 
     * @param amountStatistics 统计页面
     * @return 结果
     */
    public int updateAmountStatistics(AmountStatistics amountStatistics);

    /**
     * 批量删除统计页面
     * 
     * @param ids 需要删除的统计页面ID
     * @return 结果
     */
    public int deleteAmountStatisticsByIds(Long[] ids);

    /**
     * 删除统计页面信息
     * 
     * @param id 统计页面ID
     * @return 结果
     */
    public int deleteAmountStatisticsById(Long id);
}
