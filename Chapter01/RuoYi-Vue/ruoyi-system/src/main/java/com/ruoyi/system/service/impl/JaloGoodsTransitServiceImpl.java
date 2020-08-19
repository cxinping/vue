package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloGoodsTransitMapper;
import com.ruoyi.system.domain.JaloGoodsTransit;
import com.ruoyi.system.service.IJaloGoodsTransitService;

/**
 * 在途物资Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloGoodsTransitServiceImpl implements IJaloGoodsTransitService 
{
    @Autowired
    private JaloGoodsTransitMapper jaloGoodsTransitMapper;

    /**
     * 查询在途物资
     * 
     * @param id 在途物资ID
     * @return 在途物资
     */
    @Override
    public JaloGoodsTransit selectJaloGoodsTransitById(Long id)
    {
        return jaloGoodsTransitMapper.selectJaloGoodsTransitById(id);
    }

    /**
     * 查询在途物资列表
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 在途物资
     */
    @Override
    public List<JaloGoodsTransit> selectJaloGoodsTransitList(JaloGoodsTransit jaloGoodsTransit)
    {
        return jaloGoodsTransitMapper.selectJaloGoodsTransitList(jaloGoodsTransit);
    }

    /**
     * 新增在途物资
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 结果
     */
    @Override
    public int insertJaloGoodsTransit(JaloGoodsTransit jaloGoodsTransit)
    {
        jaloGoodsTransit.setCreateTime(DateUtils.getNowDate());
        return jaloGoodsTransitMapper.insertJaloGoodsTransit(jaloGoodsTransit);
    }

    /**
     * 修改在途物资
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 结果
     */
    @Override
    public int updateJaloGoodsTransit(JaloGoodsTransit jaloGoodsTransit)
    {
        jaloGoodsTransit.setUpdateTime(DateUtils.getNowDate());
        return jaloGoodsTransitMapper.updateJaloGoodsTransit(jaloGoodsTransit);
    }

    /**
     * 批量删除在途物资
     * 
     * @param ids 需要删除的在途物资ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitByIds(Long[] ids)
    {
        return jaloGoodsTransitMapper.deleteJaloGoodsTransitByIds(ids);
    }

    /**
     * 删除在途物资信息
     * 
     * @param id 在途物资ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitById(Long id)
    {
        return jaloGoodsTransitMapper.deleteJaloGoodsTransitById(id);
    }
}
