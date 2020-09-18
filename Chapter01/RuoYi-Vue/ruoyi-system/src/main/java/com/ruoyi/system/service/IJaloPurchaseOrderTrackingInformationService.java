package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloPurchaseOrderTrackingInformation;
import com.ruoyi.system.domain.SumJaloPurchaseOrderTrackingInfo;
import com.ruoyi.system.vo.SupplierVo;

/**
 * 采购订单跟踪信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public interface IJaloPurchaseOrderTrackingInformationService 
{
    /**
     * 查询采购订单跟踪信息
     * 
     * @param id 采购订单跟踪信息ID
     * @return 采购订单跟踪信息
     */
    public JaloPurchaseOrderTrackingInformation selectJaloPurchaseOrderTrackingInformationById(Long id);

    /**
     * 查询采购订单跟踪信息列表
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 采购订单跟踪信息集合
     */
    public List<JaloPurchaseOrderTrackingInformation> selectJaloPurchaseOrderTrackingInformationList(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation);

    /**
     * 新增采购订单跟踪信息
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 结果
     */
    public int insertJaloPurchaseOrderTrackingInformation(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation);

    /**
     * 修改采购订单跟踪信息
     * 
     * @param jaloPurchaseOrderTrackingInformation 采购订单跟踪信息
     * @return 结果
     */
    public int updateJaloPurchaseOrderTrackingInformation(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation);

    /**
     * 批量删除采购订单跟踪信息
     * 
     * @param ids 需要删除的采购订单跟踪信息ID
     * @return 结果
     */
    public int deleteJaloPurchaseOrderTrackingInformationByIds(Long[] ids);

    /**
     * 删除采购订单跟踪信息信息
     * 
     * @param id 采购订单跟踪信息ID
     * @return 结果
     */
    public int deleteJaloPurchaseOrderTrackingInformationById(Long id);

    public List<SumJaloPurchaseOrderTrackingInfo> selectSumJaloPurchaseOrderTrackingInfoList();

    public List<SupplierVo> selectJaloPurchaseOrderTrackingInfoSupplierList();

}
