package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloAmountStatisticsView;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface JaloAmountStatisticsViewMapper 
{
    /**
     * 查询VIEW
     * 
     * @param days VIEWID
     * @return VIEW
     */
    public JaloAmountStatisticsView selectJaloAmountStatisticsViewById(String days);

    /**
     * 查询VIEW列表
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return VIEW集合
     */
    public List<JaloAmountStatisticsView> selectJaloAmountStatisticsViewList(JaloAmountStatisticsView jaloAmountStatisticsView);

    /**
     * 新增VIEW
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return 结果
     */
    public int insertJaloAmountStatisticsView(JaloAmountStatisticsView jaloAmountStatisticsView);

    /**
     * 修改VIEW
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return 结果
     */
    public int updateJaloAmountStatisticsView(JaloAmountStatisticsView jaloAmountStatisticsView);

    /**
     * 删除VIEW
     * 
     * @param days VIEWID
     * @return 结果
     */
    public int deleteJaloAmountStatisticsViewById(String days);

    /**
     * 批量删除VIEW
     * 
     * @param dayss 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloAmountStatisticsViewByIds(String[] dayss);
}
