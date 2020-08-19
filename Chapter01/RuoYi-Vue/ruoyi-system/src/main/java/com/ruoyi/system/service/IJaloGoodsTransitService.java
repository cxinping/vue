package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloGoodsTransit;

/**
 * 在途物资Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IJaloGoodsTransitService 
{
    /**
     * 查询在途物资
     * 
     * @param id 在途物资ID
     * @return 在途物资
     */
    public JaloGoodsTransit selectJaloGoodsTransitById(Long id);

    /**
     * 查询在途物资列表
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 在途物资集合
     */
    public List<JaloGoodsTransit> selectJaloGoodsTransitList(JaloGoodsTransit jaloGoodsTransit);

    /**
     * 新增在途物资
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 结果
     */
    public int insertJaloGoodsTransit(JaloGoodsTransit jaloGoodsTransit);

    /**
     * 修改在途物资
     * 
     * @param jaloGoodsTransit 在途物资
     * @return 结果
     */
    public int updateJaloGoodsTransit(JaloGoodsTransit jaloGoodsTransit);

    /**
     * 批量删除在途物资
     * 
     * @param ids 需要删除的在途物资ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitByIds(Long[] ids);

    /**
     * 删除在途物资信息
     * 
     * @param id 在途物资ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitById(Long id);
}
