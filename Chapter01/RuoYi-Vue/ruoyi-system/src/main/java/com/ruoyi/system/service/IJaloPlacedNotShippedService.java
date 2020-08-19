package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloPlacedNotShipped;

/**
 * 已下单未发货Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IJaloPlacedNotShippedService 
{
    /**
     * 查询已下单未发货
     * 
     * @param id 已下单未发货ID
     * @return 已下单未发货
     */
    public JaloPlacedNotShipped selectJaloPlacedNotShippedById(Long id);

    /**
     * 查询已下单未发货列表
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 已下单未发货集合
     */
    public List<JaloPlacedNotShipped> selectJaloPlacedNotShippedList(JaloPlacedNotShipped jaloPlacedNotShipped);

    /**
     * 新增已下单未发货
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 结果
     */
    public int insertJaloPlacedNotShipped(JaloPlacedNotShipped jaloPlacedNotShipped);

    /**
     * 修改已下单未发货
     * 
     * @param jaloPlacedNotShipped 已下单未发货
     * @return 结果
     */
    public int updateJaloPlacedNotShipped(JaloPlacedNotShipped jaloPlacedNotShipped);

    /**
     * 批量删除已下单未发货
     * 
     * @param ids 需要删除的已下单未发货ID
     * @return 结果
     */
    public int deleteJaloPlacedNotShippedByIds(Long[] ids);

    /**
     * 删除已下单未发货信息
     * 
     * @param id 已下单未发货ID
     * @return 结果
     */
    public int deleteJaloPlacedNotShippedById(Long id);
}
