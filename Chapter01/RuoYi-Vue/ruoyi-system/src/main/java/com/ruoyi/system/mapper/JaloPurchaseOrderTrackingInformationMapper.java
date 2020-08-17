package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloPurchaseOrderTrackingInformation;

/**
 * 采购订单跟踪信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public interface JaloPurchaseOrderTrackingInformationMapper 
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
     * 删除采购订单跟踪信息
     * 
     * @param id 采购订单跟踪信息ID
     * @return 结果
     */
    public int deleteJaloPurchaseOrderTrackingInformationById(Long id);

    /**
     * 批量删除采购订单跟踪信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloPurchaseOrderTrackingInformationByIds(Long[] ids);
}
