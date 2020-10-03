package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloGoodsTransitSumMapper;
import com.ruoyi.system.domain.JaloGoodsTransitSum;
import com.ruoyi.system.service.IJaloGoodsTransitSumService;

/**
 * 在途物资汇总Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
@Service
public class JaloGoodsTransitSumServiceImpl implements IJaloGoodsTransitSumService 
{
    @Autowired
    private JaloGoodsTransitSumMapper jaloGoodsTransitSumMapper;

    /**
     * 查询在途物资汇总
     * 
     * @param id 在途物资汇总ID
     * @return 在途物资汇总
     */
    @Override
    public JaloGoodsTransitSum selectJaloGoodsTransitSumById(String id)
    {
        return jaloGoodsTransitSumMapper.selectJaloGoodsTransitSumById(id);
    }

    /**
     * 查询在途物资汇总列表
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 在途物资汇总
     */
    @Override
    public List<JaloGoodsTransitSum> selectJaloGoodsTransitSumList(JaloGoodsTransitSum jaloGoodsTransitSum)
    {
        return jaloGoodsTransitSumMapper.selectJaloGoodsTransitSumList(jaloGoodsTransitSum);
    }

    /**
     * 新增在途物资汇总
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 结果
     */
    @Override
    public int insertJaloGoodsTransitSum(JaloGoodsTransitSum jaloGoodsTransitSum)
    {
        jaloGoodsTransitSum.setCreateTime(DateUtils.getNowDate());
        return jaloGoodsTransitSumMapper.insertJaloGoodsTransitSum(jaloGoodsTransitSum);
    }

    /**
     * 修改在途物资汇总
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 结果
     */
    @Override
    public int updateJaloGoodsTransitSum(JaloGoodsTransitSum jaloGoodsTransitSum)
    {
        jaloGoodsTransitSum.setUpdateTime(DateUtils.getNowDate());
        return jaloGoodsTransitSumMapper.updateJaloGoodsTransitSum(jaloGoodsTransitSum);
    }

    /**
     * 批量删除在途物资汇总
     * 
     * @param ids 需要删除的在途物资汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitSumByIds(String[] ids)
    {
        return jaloGoodsTransitSumMapper.deleteJaloGoodsTransitSumByIds(ids);
    }

    /**
     * 删除在途物资汇总信息
     * 
     * @param id 在途物资汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitSumById(String id)
    {
        return jaloGoodsTransitSumMapper.deleteJaloGoodsTransitSumById(id);
    }
}
