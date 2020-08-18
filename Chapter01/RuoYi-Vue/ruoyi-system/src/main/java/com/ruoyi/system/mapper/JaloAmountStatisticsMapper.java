package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloAmountStatistics;

/**
 * 统计页面Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public interface JaloAmountStatisticsMapper 
{
    /**
     * 查询统计页面
     * 
     * @param id 统计页面ID
     * @return 统计页面
     */
    public JaloAmountStatistics selectJaloAmountStatisticsById(Long id);

    /**
     * 查询统计页面列表
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 统计页面集合
     */
    public List<JaloAmountStatistics> selectJaloAmountStatisticsList(JaloAmountStatistics jaloAmountStatistics);

    /**
     * 新增统计页面
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 结果
     */
    public int insertJaloAmountStatistics(JaloAmountStatistics jaloAmountStatistics);

    /**
     * 修改统计页面
     * 
     * @param jaloAmountStatistics 统计页面
     * @return 结果
     */
    public int updateJaloAmountStatistics(JaloAmountStatistics jaloAmountStatistics);

    /**
     * 删除统计页面
     * 
     * @param id 统计页面ID
     * @return 结果
     */
    public int deleteJaloAmountStatisticsById(Long id);

    /**
     * 批量删除统计页面
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloAmountStatisticsByIds(Long[] ids);
}
