package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloPurchasedUnshippedMapper;
import com.ruoyi.system.domain.JaloPurchasedUnshipped;
import com.ruoyi.system.service.IJaloPurchasedUnshippedService;

/**
 * 已购买未发货Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class JaloPurchasedUnshippedServiceImpl implements IJaloPurchasedUnshippedService 
{
    @Autowired
    private JaloPurchasedUnshippedMapper jaloPurchasedUnshippedMapper;

    /**
     * 查询已购买未发货
     * 
     * @param id 已购买未发货ID
     * @return 已购买未发货
     */
    @Override
    public JaloPurchasedUnshipped selectJaloPurchasedUnshippedById(Long id)
    {
        return jaloPurchasedUnshippedMapper.selectJaloPurchasedUnshippedById(id);
    }

    /**
     * 查询已购买未发货列表
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 已购买未发货
     */
    @Override
    public List<JaloPurchasedUnshipped> selectJaloPurchasedUnshippedList(JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        return jaloPurchasedUnshippedMapper.selectJaloPurchasedUnshippedList(jaloPurchasedUnshipped);
    }

    /**
     * 新增已购买未发货
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 结果
     */
    @Override
    public int insertJaloPurchasedUnshipped(JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        jaloPurchasedUnshipped.setCreateTime(DateUtils.getNowDate());
        return jaloPurchasedUnshippedMapper.insertJaloPurchasedUnshipped(jaloPurchasedUnshipped);
    }

    /**
     * 修改已购买未发货
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 结果
     */
    @Override
    public int updateJaloPurchasedUnshipped(JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        jaloPurchasedUnshipped.setUpdateTime(DateUtils.getNowDate());
        return jaloPurchasedUnshippedMapper.updateJaloPurchasedUnshipped(jaloPurchasedUnshipped);
    }

    /**
     * 批量删除已购买未发货
     * 
     * @param ids 需要删除的已购买未发货ID
     * @return 结果
     */
    @Override
    public int deleteJaloPurchasedUnshippedByIds(Long[] ids)
    {
        return jaloPurchasedUnshippedMapper.deleteJaloPurchasedUnshippedByIds(ids);
    }

    /**
     * 删除已购买未发货信息
     * 
     * @param id 已购买未发货ID
     * @return 结果
     */
    @Override
    public int deleteJaloPurchasedUnshippedById(Long id)
    {
        return jaloPurchasedUnshippedMapper.deleteJaloPurchasedUnshippedById(id);
    }
}
