package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloAmountStatisticsViewMapper;
import com.ruoyi.system.domain.JaloAmountStatisticsView;
import com.ruoyi.system.service.IJaloAmountStatisticsViewService;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class JaloAmountStatisticsViewServiceImpl implements IJaloAmountStatisticsViewService 
{
    @Autowired
    private JaloAmountStatisticsViewMapper jaloAmountStatisticsViewMapper;

    /**
     * 查询VIEW
     * 
     * @param days VIEWID
     * @return VIEW
     */
    @Override
    public JaloAmountStatisticsView selectJaloAmountStatisticsViewById(String days)
    {
        return jaloAmountStatisticsViewMapper.selectJaloAmountStatisticsViewById(days);
    }

    /**
     * 查询VIEW列表
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return VIEW
     */
    @Override
    public List<JaloAmountStatisticsView> selectJaloAmountStatisticsViewList(JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        return jaloAmountStatisticsViewMapper.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
    }

    /**
     * 新增VIEW
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return 结果
     */
    @Override
    public int insertJaloAmountStatisticsView(JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        return jaloAmountStatisticsViewMapper.insertJaloAmountStatisticsView(jaloAmountStatisticsView);
    }

    /**
     * 修改VIEW
     * 
     * @param jaloAmountStatisticsView VIEW
     * @return 结果
     */
    @Override
    public int updateJaloAmountStatisticsView(JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        return jaloAmountStatisticsViewMapper.updateJaloAmountStatisticsView(jaloAmountStatisticsView);
    }

    /**
     * 批量删除VIEW
     * 
     * @param dayss 需要删除的VIEWID
     * @return 结果
     */
    @Override
    public int deleteJaloAmountStatisticsViewByIds(String[] dayss)
    {
        return jaloAmountStatisticsViewMapper.deleteJaloAmountStatisticsViewByIds(dayss);
    }

    /**
     * 删除VIEW信息
     * 
     * @param days VIEWID
     * @return 结果
     */
    @Override
    public int deleteJaloAmountStatisticsViewById(String days)
    {
        return jaloAmountStatisticsViewMapper.deleteJaloAmountStatisticsViewById(days);
    }
}
