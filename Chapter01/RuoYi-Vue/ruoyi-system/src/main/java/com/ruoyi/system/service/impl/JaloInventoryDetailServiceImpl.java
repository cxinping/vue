package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloInventoryDetailMapper;
import com.ruoyi.system.domain.JaloInventoryDetail;
import com.ruoyi.system.service.IJaloInventoryDetailService;

/**
 * 库存详细Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloInventoryDetailServiceImpl implements IJaloInventoryDetailService 
{
    @Autowired
    private JaloInventoryDetailMapper jaloInventoryDetailMapper;

    /**
     * 查询库存详细
     * 
     * @param id 库存详细ID
     * @return 库存详细
     */
    @Override
    public JaloInventoryDetail selectJaloInventoryDetailById(Long id)
    {
        return jaloInventoryDetailMapper.selectJaloInventoryDetailById(id);
    }

    /**
     * 查询库存详细列表
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 库存详细
     */
    @Override
    public List<JaloInventoryDetail> selectJaloInventoryDetailList(JaloInventoryDetail jaloInventoryDetail)
    {
        return jaloInventoryDetailMapper.selectJaloInventoryDetailList(jaloInventoryDetail);
    }

    public List<JaloInventoryDetail> selectJaloInventoryDetailListByInventorySumId(String jaloInventorySumId){
        return jaloInventoryDetailMapper.selectJaloInventoryDetailListByInventorySumId(jaloInventorySumId);
    }




    /**
     * 新增库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    @Override
    public int insertJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail)
    {
        jaloInventoryDetail.setCreateTime(DateUtils.getNowDate());
        return jaloInventoryDetailMapper.insertJaloInventoryDetail(jaloInventoryDetail);
    }

    /**
     * 修改库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    @Override
    public int updateJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail)
    {
        jaloInventoryDetail.setUpdateTime(DateUtils.getNowDate());
        return jaloInventoryDetailMapper.updateJaloInventoryDetail(jaloInventoryDetail);
    }

    /**
     * 批量删除库存详细
     * 
     * @param ids 需要删除的库存详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryDetailByIds(Long[] ids)
    {
        return jaloInventoryDetailMapper.deleteJaloInventoryDetailByIds(ids);
    }

    /**
     * 删除库存详细信息
     * 
     * @param id 库存详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryDetailById(Long id)
    {
        return jaloInventoryDetailMapper.deleteJaloInventoryDetailById(id);
    }
}
