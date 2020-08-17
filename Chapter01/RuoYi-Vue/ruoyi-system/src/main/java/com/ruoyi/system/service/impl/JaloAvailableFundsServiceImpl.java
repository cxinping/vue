package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloAvailableFundsMapper;
import com.ruoyi.system.domain.JaloAvailableFunds;
import com.ruoyi.system.service.IJaloAvailableFundsService;

/**
 * 可用资金Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
@Service
public class JaloAvailableFundsServiceImpl implements IJaloAvailableFundsService 
{
    @Autowired
    private JaloAvailableFundsMapper jaloAvailableFundsMapper;

    /**
     * 查询可用资金
     * 
     * @param id 可用资金ID
     * @return 可用资金
     */
    @Override
    public JaloAvailableFunds selectJaloAvailableFundsById(Long id)
    {
        return jaloAvailableFundsMapper.selectJaloAvailableFundsById(id);
    }

    /**
     * 查询可用资金列表
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 可用资金
     */
    @Override
    public List<JaloAvailableFunds> selectJaloAvailableFundsList(JaloAvailableFunds jaloAvailableFunds)
    {
        return jaloAvailableFundsMapper.selectJaloAvailableFundsList(jaloAvailableFunds);
    }

    /**
     * 新增可用资金
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 结果
     */
    @Override
    public int insertJaloAvailableFunds(JaloAvailableFunds jaloAvailableFunds)
    {
        jaloAvailableFunds.setCreateTime(DateUtils.getNowDate());
        return jaloAvailableFundsMapper.insertJaloAvailableFunds(jaloAvailableFunds);
    }

    /**
     * 修改可用资金
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 结果
     */
    @Override
    public int updateJaloAvailableFunds(JaloAvailableFunds jaloAvailableFunds)
    {
        jaloAvailableFunds.setUpdateTime(DateUtils.getNowDate());
        return jaloAvailableFundsMapper.updateJaloAvailableFunds(jaloAvailableFunds);
    }

    /**
     * 批量删除可用资金
     * 
     * @param ids 需要删除的可用资金ID
     * @return 结果
     */
    @Override
    public int deleteJaloAvailableFundsByIds(Long[] ids)
    {
        return jaloAvailableFundsMapper.deleteJaloAvailableFundsByIds(ids);
    }

    /**
     * 删除可用资金信息
     * 
     * @param id 可用资金ID
     * @return 结果
     */
    @Override
    public int deleteJaloAvailableFundsById(Long id)
    {
        return jaloAvailableFundsMapper.deleteJaloAvailableFundsById(id);
    }
}
