package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloShippedUnsettled;

/**
 * 已发货未结算金额Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public interface JaloShippedUnsettledMapper 
{
    /**
     * 查询已发货未结算金额
     * 
     * @param id 已发货未结算金额ID
     * @return 已发货未结算金额
     */
    public JaloShippedUnsettled selectJaloShippedUnsettledById(Long id);

    /**
     * 查询已发货未结算金额列表
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 已发货未结算金额集合
     */
    public List<JaloShippedUnsettled> selectJaloShippedUnsettledList(JaloShippedUnsettled jaloShippedUnsettled);

    /**
     * 新增已发货未结算金额
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 结果
     */
    public int insertJaloShippedUnsettled(JaloShippedUnsettled jaloShippedUnsettled);

    /**
     * 修改已发货未结算金额
     * 
     * @param jaloShippedUnsettled 已发货未结算金额
     * @return 结果
     */
    public int updateJaloShippedUnsettled(JaloShippedUnsettled jaloShippedUnsettled);

    /**
     * 删除已发货未结算金额
     * 
     * @param id 已发货未结算金额ID
     * @return 结果
     */
    public int deleteJaloShippedUnsettledById(Long id);

    /**
     * 批量删除已发货未结算金额
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloShippedUnsettledByIds(Long[] ids);
}
