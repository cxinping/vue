package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.JaloGoodsTransitSum;

/**
 * 在途物资汇总Service接口
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
public interface IJaloGoodsTransitSumService 
{
    /**
     * 查询在途物资汇总
     * 
     * @param id 在途物资汇总ID
     * @return 在途物资汇总
     */
    public JaloGoodsTransitSum selectJaloGoodsTransitSumById(String id);

    /**
     * 查询在途物资汇总列表
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 在途物资汇总集合
     */
    public List<JaloGoodsTransitSum> selectJaloGoodsTransitSumList(JaloGoodsTransitSum jaloGoodsTransitSum);

    /**
     * 新增在途物资汇总
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 结果
     */
    public int insertJaloGoodsTransitSum(JaloGoodsTransitSum jaloGoodsTransitSum);

    /**
     * 修改在途物资汇总
     * 
     * @param jaloGoodsTransitSum 在途物资汇总
     * @return 结果
     */
    public int updateJaloGoodsTransitSum(JaloGoodsTransitSum jaloGoodsTransitSum);

    /**
     * 批量删除在途物资汇总
     * 
     * @param ids 需要删除的在途物资汇总ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitSumByIds(String[] ids);

    /**
     * 删除在途物资汇总信息
     * 
     * @param id 在途物资汇总ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitSumById(String id);


}
