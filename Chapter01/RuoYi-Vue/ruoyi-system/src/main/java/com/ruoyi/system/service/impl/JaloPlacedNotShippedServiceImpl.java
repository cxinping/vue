package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloPlacedNotShippedMapper;
import com.ruoyi.system.domain.JaloPlacedNotShipped;
import com.ruoyi.system.service.IJaloPlacedNotShippedService;

/**
 * 已下单未发货Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloPlacedNotShippedServiceImpl implements IJaloPlacedNotShippedService 
{
    @Autowired
    private JaloPlacedNotShippedMapper jaloPlacedNotShippedMapper;

    /**
     * 查询已下单未发货
     * 
     * @param id 已下单未发货ID
     * @return 已下单未发货
     */
    @Override
    public JaloPlacedNotShipped selectJaloPlacedNotShippedById(Long id)
    {
        return jaloPlacedNotShippedMapper.selectJaloPlacedNotShippedById(id);
    }

    /**
     * 查询已下单未发货列表
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 已下单未发货
     */
    @Override
    public List<JaloPlacedNotShipped> selectJaloPlacedNotShippedList(JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        return jaloPlacedNotShippedMapper.selectJaloPlacedNotShippedList(jaloPlacedNotShipped);
    }

    /**
     * 新增已下单未发货
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 结果
     */
    @Override
    public int insertJaloPlacedNotShipped(JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        jaloPlacedNotShipped.setCreateTime(DateUtils.getNowDate());
        return jaloPlacedNotShippedMapper.insertJaloPlacedNotShipped(jaloPlacedNotShipped);
    }

    /**
     * 修改已下单未发货
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 结果
     */
    @Override
    public int updateJaloPlacedNotShipped(JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        jaloPlacedNotShipped.setUpdateTime(DateUtils.getNowDate());
        return jaloPlacedNotShippedMapper.updateJaloPlacedNotShipped(jaloPlacedNotShipped);
    }

    /**
     * 批量删除已下单未发货
     * 
     * @param ids 需要删除的已下单未发货ID
     * @return 结果
     */
    @Override
    public int deleteJaloPlacedNotShippedByIds(Long[] ids)
    {
        return jaloPlacedNotShippedMapper.deleteJaloPlacedNotShippedByIds(ids);
    }

    /**
     * 删除已下单未发货信息
     * 
     * @param id 已下单未发货ID
     * @return 结果
     */
    @Override
    public int deleteJaloPlacedNotShippedById(Long id)
    {
        return jaloPlacedNotShippedMapper.deleteJaloPlacedNotShippedById(id);
    }
}
