package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloAvailableFunds;

/**
 * 可用资金Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
public interface JaloAvailableFundsMapper 
{
    /**
     * 查询可用资金
     * 
     * @param id 可用资金ID
     * @return 可用资金
     */
    public JaloAvailableFunds selectJaloAvailableFundsById(Long id);

    /**
     * 查询可用资金列表
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 可用资金集合
     */
    public List<JaloAvailableFunds> selectJaloAvailableFundsList(JaloAvailableFunds jaloAvailableFunds);

    /**
     * 新增可用资金
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 结果
     */
    public int insertJaloAvailableFunds(JaloAvailableFunds jaloAvailableFunds);

    /**
     * 修改可用资金
     * 
     * @param jaloAvailableFunds 可用资金
     * @return 结果
     */
    public int updateJaloAvailableFunds(JaloAvailableFunds jaloAvailableFunds);

    /**
     * 删除可用资金
     * 
     * @param id 可用资金ID
     * @return 结果
     */
    public int deleteJaloAvailableFundsById(Long id);

    /**
     * 批量删除可用资金
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloAvailableFundsByIds(Long[] ids);
}
