package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JaloGoodsTransitSum;

/**
 * 在途物资汇总Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
public interface JaloGoodsTransitSumMapper 
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
     * 删除在途物资汇总
     * 
     * @param id 在途物资汇总ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitSumById(String id);

    /**
     * 批量删除在途物资汇总
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitSumByIds(String[] ids);
}
