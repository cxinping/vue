package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloShippedUnsettledMapper;
import com.ruoyi.system.domain.JaloShippedUnsettled;
import com.ruoyi.system.service.IJaloShippedUnsettledService;

/**
 * 已发货未结算金额Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@Service
public class JaloShippedUnsettledServiceImpl implements IJaloShippedUnsettledService 
{
    @Autowired
    private JaloShippedUnsettledMapper jaloShippedUnsettledMapper;

    /**
     * 查询已发货未结算金额
     * 
     * @param id 已发货未结算金额ID
     * @return 已发货未结算金额
     */
    @Override
    public JaloShippedUnsettled selectJaloShippedUnsettledById(Long id)
    {
        return jaloShippedUnsettledMapper.selectJaloShippedUnsettledById(id);
    }

    /**
     * 查询已发货未结算金额列表
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 已发货未结算金额
     */
    @Override
    public List<JaloShippedUnsettled> selectJaloShippedUnsettledList(JaloShippedUnsettled jaloShippedUnsettled)
    {
        return jaloShippedUnsettledMapper.selectJaloShippedUnsettledList(jaloShippedUnsettled);
    }

    /**
     * 新增已发货未结算金额
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 结果
     */
    @Override
    public int insertJaloShippedUnsettled(JaloShippedUnsettled jaloShippedUnsettled)
    {
        jaloShippedUnsettled.setCreateTime(DateUtils.getNowDate());
        return jaloShippedUnsettledMapper.insertJaloShippedUnsettled(jaloShippedUnsettled);
    }

    /**
     * 修改已发货未结算金额
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 结果
     */
    @Override
    public int updateJaloShippedUnsettled(JaloShippedUnsettled jaloShippedUnsettled)
    {
        jaloShippedUnsettled.setUpdateTime(DateUtils.getNowDate());
        return jaloShippedUnsettledMapper.updateJaloShippedUnsettled(jaloShippedUnsettled);
    }

    /**
     * 批量删除已发货未结算金额
     * 
     * @param ids 需要删除的已发货未结算金额ID
     * @return 结果
     */
    @Override
    public int deleteJaloShippedUnsettledByIds(Long[] ids)
    {
        return jaloShippedUnsettledMapper.deleteJaloShippedUnsettledByIds(ids);
    }

    /**
     * 删除已发货未结算金额信息
     * 
     * @param id 已发货未结算金额ID
     * @return 结果
     */
    @Override
    public int deleteJaloShippedUnsettledById(Long id)
    {
        return jaloShippedUnsettledMapper.deleteJaloShippedUnsettledById(id);
    }
}
