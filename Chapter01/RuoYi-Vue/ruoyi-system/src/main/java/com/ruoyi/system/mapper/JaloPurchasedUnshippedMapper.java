package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloPurchasedUnshipped;

/**
 * 已购买未发货Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface JaloPurchasedUnshippedMapper 
{
    /**
     * 查询已购买未发货
     * 
     * @param id 已购买未发货ID
     * @return 已购买未发货
     */
    public JaloPurchasedUnshipped selectJaloPurchasedUnshippedById(Long id);

    /**
     * 查询已购买未发货列表
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 已购买未发货集合
     */
    public List<JaloPurchasedUnshipped> selectJaloPurchasedUnshippedList(JaloPurchasedUnshipped jaloPurchasedUnshipped);

    /**
     * 新增已购买未发货
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 结果
     */
    public int insertJaloPurchasedUnshipped(JaloPurchasedUnshipped jaloPurchasedUnshipped);

    /**
     * 修改已购买未发货
     * 
     * @param jaloPurchasedUnshipped 已购买未发货
     * @return 结果
     */
    public int updateJaloPurchasedUnshipped(JaloPurchasedUnshipped jaloPurchasedUnshipped);

    /**
     * 删除已购买未发货
     * 
     * @param id 已购买未发货ID
     * @return 结果
     */
    public int deleteJaloPurchasedUnshippedById(Long id);

    /**
     * 批量删除已购买未发货
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloPurchasedUnshippedByIds(Long[] ids);
}
