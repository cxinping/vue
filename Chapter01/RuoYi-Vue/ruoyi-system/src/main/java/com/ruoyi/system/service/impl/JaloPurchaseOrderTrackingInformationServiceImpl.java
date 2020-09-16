package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SumJaloPurchaseOrderTrackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloPurchaseOrderTrackingInformationMapper;
import com.ruoyi.system.domain.JaloPurchaseOrderTrackingInformation;
import com.ruoyi.system.service.IJaloPurchaseOrderTrackingInformationService;

/**
 * 采购订单跟踪信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@Service
public class JaloPurchaseOrderTrackingInformationServiceImpl implements IJaloPurchaseOrderTrackingInformationService 
{
    @Autowired
    private JaloPurchaseOrderTrackingInformationMapper jaloPurchaseOrderTrackingInformationMapper;

    /**
     * 查询采购订单跟踪信息
     * 
     * @param id 采购订单跟踪信息ID
     * @return 采购订单跟踪信息
     */
    @Override
    public JaloPurchaseOrderTrackingInformation selectJaloPurchaseOrderTrackingInformationById(Long id)
    {
        return jaloPurchaseOrderTrackingInformationMapper.selectJaloPurchaseOrderTrackingInformationById(id);
    }

    /**
     * 查询采购订单跟踪信息列表
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 采购订单跟踪信息
     */
    @Override
    public List<JaloPurchaseOrderTrackingInformation> selectJaloPurchaseOrderTrackingInformationList(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        return jaloPurchaseOrderTrackingInformationMapper.selectJaloPurchaseOrderTrackingInformationList(jaloPurchaseOrderTrackingInformation);
    }

    /**
     * 新增采购订单跟踪信息
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 结果
     */
    @Override
    public int insertJaloPurchaseOrderTrackingInformation(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        jaloPurchaseOrderTrackingInformation.setCreateTime(DateUtils.getNowDate());
        return jaloPurchaseOrderTrackingInformationMapper.insertJaloPurchaseOrderTrackingInformation(jaloPurchaseOrderTrackingInformation);
    }

    /**
     * 修改采购订单跟踪信息
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 结果
     */
    @Override
    public int updateJaloPurchaseOrderTrackingInformation(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        jaloPurchaseOrderTrackingInformation.setUpdateTime(DateUtils.getNowDate());
        return jaloPurchaseOrderTrackingInformationMapper.updateJaloPurchaseOrderTrackingInformation(jaloPurchaseOrderTrackingInformation);
    }

    /**
     * 批量删除采购订单跟踪信息
     * 
     * @param ids 需要删除的采购订单跟踪信息ID
     * @return 结果
     */
    @Override
    public int deleteJaloPurchaseOrderTrackingInformationByIds(Long[] ids)
    {
        return jaloPurchaseOrderTrackingInformationMapper.deleteJaloPurchaseOrderTrackingInformationByIds(ids);
    }

    /**
     * 删除采购订单跟踪信息信息
     * 
     * @param id 采购订单跟踪信息ID
     * @return 结果
     */
    @Override
    public int deleteJaloPurchaseOrderTrackingInformationById(Long id)
    {
        return jaloPurchaseOrderTrackingInformationMapper.deleteJaloPurchaseOrderTrackingInformationById(id);
    }

    @Override
    public List<SumJaloPurchaseOrderTrackingInfo> selectSumJaloPurchaseOrderTrackingInfoList(){
        return jaloPurchaseOrderTrackingInformationMapper.selectSumJaloPurchaseOrderTrackingInfoList();
    }

}
