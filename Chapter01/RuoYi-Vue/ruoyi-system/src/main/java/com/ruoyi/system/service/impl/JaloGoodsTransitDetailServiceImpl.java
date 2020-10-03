package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloGoodsTransitDetailMapper;
import com.ruoyi.system.domain.JaloGoodsTransitDetail;
import com.ruoyi.system.service.IJaloGoodsTransitDetailService;

/**
 * 在途物资详细Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
@Service
public class JaloGoodsTransitDetailServiceImpl implements IJaloGoodsTransitDetailService 
{
    @Autowired
    private JaloGoodsTransitDetailMapper jaloGoodsTransitDetailMapper;

    /**
     * 查询在途物资详细
     * 
     * @param id 在途物资详细ID
     * @return 在途物资详细
     */
    @Override
    public JaloGoodsTransitDetail selectJaloGoodsTransitDetailById(String id)
    {
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailById(id);
    }

    /**
     * 查询在途物资详细列表
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 在途物资详细
     */
    @Override
    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailList(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailList(jaloGoodsTransitDetail);
    }

    /**
     * 新增在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    @Override
    public int insertJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        jaloGoodsTransitDetail.setCreateTime(DateUtils.getNowDate());
        return jaloGoodsTransitDetailMapper.insertJaloGoodsTransitDetail(jaloGoodsTransitDetail);
    }

    /**
     * 修改在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    @Override
    public int updateJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        jaloGoodsTransitDetail.setUpdateTime(DateUtils.getNowDate());
        return jaloGoodsTransitDetailMapper.updateJaloGoodsTransitDetail(jaloGoodsTransitDetail);
    }

    /**
     * 批量删除在途物资详细
     * 
     * @param ids 需要删除的在途物资详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitDetailByIds(String[] ids)
    {
        return jaloGoodsTransitDetailMapper.deleteJaloGoodsTransitDetailByIds(ids);
    }

    /**
     * 删除在途物资详细信息
     * 
     * @param id 在途物资详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitDetailById(String id)
    {
        return jaloGoodsTransitDetailMapper.deleteJaloGoodsTransitDetailById(id);
    }

    @Override
    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailListByTransitSumId(String jaloTransitSumId){
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailListByTransitSumId(jaloTransitSumId);
    }

}
