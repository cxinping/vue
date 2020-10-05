package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.JaloGoodsTransitDetail;
import com.ruoyi.system.domain.JaloGoodsTransitSumDetail;

/**
 * 在途物资详细Service接口
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
public interface IJaloGoodsTransitDetailService 
{
    /**
     * 查询在途物资详细
     * 
     * @param id 在途物资详细ID
     * @return 在途物资详细
     */
    public JaloGoodsTransitDetail selectJaloGoodsTransitDetailById(String id);

    /**
     * 查询在途物资详细列表
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 在途物资详细集合
     */
    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailList(JaloGoodsTransitDetail jaloGoodsTransitDetail);

    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailListByTransitSumId(String jaloTransitSumId);

    /**
     * 新增在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    public int insertJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail);

    /**
     * 修改在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    public int updateJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail);

    /**
     * 批量删除在途物资详细
     * 
     * @param ids 需要删除的在途物资详细ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitDetailByIds(String[] ids);

    /**
     * 删除在途物资详细信息
     * 
     * @param id 在途物资详细ID
     * @return 结果
     */
    public int deleteJaloGoodsTransitDetailById(String id);

    public AjaxResult exportExcel(List<JaloGoodsTransitDetail> list, String sheetName);

    public JaloGoodsTransitSumDetail selectJaloGoodsTransitDetailSum();
}
