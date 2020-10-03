//package com.ruoyi.web.controller.jalohome;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import com.ruoyi.common.utils.id.IdGenerator;
//import com.ruoyi.system.domain.JaloGoodsTransitDetail;
//import com.ruoyi.system.domain.JaloInventoryDetail;
//import com.ruoyi.system.service.IJaloGoodsTransitDetailService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.ruoyi.common.annotation.Log;
//import com.ruoyi.common.core.controller.BaseController;
//import com.ruoyi.common.core.domain.AjaxResult;
//import com.ruoyi.common.enums.BusinessType;
//import com.ruoyi.system.domain.JaloGoodsTransitSum;
//import com.ruoyi.system.service.IJaloGoodsTransitSumService;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.common.core.page.TableDataInfo;
//
///**
// * 在途物资汇总Controller
// *
// * @author ruoyi
// * @date 2020-10-03
// */
//@RestController
//@RequestMapping("/amount/transit/sum")
//public class JaloGoodsTransitSumController extends BaseController
//{
//    private final Logger logger = LoggerFactory.getLogger(JaloGoodsTransitSumController.class);
//
//
//    @Autowired
//    private IJaloGoodsTransitSumService jaloGoodsTransitSumService;
//    @Autowired
//    private IJaloGoodsTransitDetailService jaloGoodsTransitDetailService;
//
//
//    /**
//     * 查询在途物资汇总列表
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(JaloGoodsTransitSum jaloGoodsTransitSum)
//    {
//        logger.info("----------- JaloGoodsTransitSumController list -----------------");
//
//
//        startPage();
//        List<JaloGoodsTransitSum> list = jaloGoodsTransitSumService.selectJaloGoodsTransitSumList(jaloGoodsTransitSum);
//        String transit_sum_id = null;
//
//        for (JaloGoodsTransitSum transitSum: list) {
//            transit_sum_id = transitSum.getId();
//            List<JaloGoodsTransitDetail> transitDetails = jaloGoodsTransitDetailService.selectJaloGoodsTransitDetailListByTransitSumId(transit_sum_id);
//
//            if( null != transitDetails){
//                // 按照编号排序
//                Collections.sort(transitDetails);
//                transitSum.setTransitDetails(transitDetails);
//            }
//        }
//
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出在途物资汇总列表
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:export')")
//    @Log(title = "在途物资汇总", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(JaloGoodsTransitSum jaloGoodsTransitSum)
//    {
//        List<JaloGoodsTransitSum> list = jaloGoodsTransitSumService.selectJaloGoodsTransitSumList(jaloGoodsTransitSum);
//        ExcelUtil<JaloGoodsTransitSum> util = new ExcelUtil<JaloGoodsTransitSum>(JaloGoodsTransitSum.class);
//        return util.exportExcel(list, "sum");
//    }
//
//    /**
//     * 获取在途物资汇总详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") String id)
//    {
//        return AjaxResult.success(jaloGoodsTransitSumService.selectJaloGoodsTransitSumById(id));
//    }
//
//    /**
//     * 新增在途物资汇总
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:add')")
//    @Log(title = "在途物资汇总", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody JaloGoodsTransitSum jaloGoodsTransitSum)
//    {
//        logger.info("------------ JaloGoodsTransitSumController add -------------");
//        if(null != jaloGoodsTransitSum){
//            jaloGoodsTransitSum.setUpdateTime(new Date() );
//        }
//
//        String id = IdGenerator.get();
//        jaloGoodsTransitSum.setId(id);
//        List<JaloGoodsTransitDetail>  transitDetails = jaloGoodsTransitSum.getTransitDetails();
//        if(null != transitDetails ){
//            for(JaloGoodsTransitDetail transitDetail :transitDetails){
//                transitDetail.setId( IdGenerator.get());
//                transitDetail.setJaloGoodsTransitSumId(id);
//                transitDetail.setCreateTime(new Date());
//                transitDetail.setUpdateTime(new Date());
//                jaloGoodsTransitDetailService.insertJaloGoodsTransitDetail( transitDetail);
//            }
//        }
//
//        return toAjax(jaloGoodsTransitSumService.insertJaloGoodsTransitSum(jaloGoodsTransitSum));
//    }
//
//    /**
//     * 修改在途物资汇总
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:edit')")
//    @Log(title = "在途物资汇总", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody JaloGoodsTransitSum jaloGoodsTransitSum)
//    {
//        logger.info("------------ JaloGoodsTransitSumController edit -------------");
//        logger.info(jaloGoodsTransitSum.toString());
//        String transit_sum_id = jaloGoodsTransitSum.getId();
//        if(null != transit_sum_id ){
//            jaloGoodsTransitDetailService.deleteJaloGoodsTransitDetailBytransitSumId(transit_sum_id);
//        }
//
//        List<JaloGoodsTransitDetail> transitDetails = jaloGoodsTransitSum.getTransitDetails();
//
//        if(null != transitDetails){
//            for (JaloGoodsTransitDetail transitDetail:  transitDetails) {
//                transitDetail.setId(IdGenerator.get());
//                transitDetail.setJaloGoodsTransitSumId(  transit_sum_id );
//                transitDetail.setUpdateTime(new Date());
//                transitDetail.setCreateTime(new Date());
//                jaloGoodsTransitDetailService.insertJaloGoodsTransitDetail(transitDetail );
//                System.out.println( transitDetail + "\n");
//            }
//        }
//
//        int updateFlag = jaloGoodsTransitSumService.updateJaloGoodsTransitSum(jaloGoodsTransitSum);
//        updateFlag = 1;
//
//        return toAjax(updateFlag);
//    }
//
//    /**
//     * 删除在途物资汇总
//     */
//    @PreAuthorize("@ss.hasPermi('transit:sum:remove')")
//    @Log(title = "在途物资汇总", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable String[] ids)
//    {
//        logger.info("------------ JaloGoodsTransitSumController remove -------------");
//
//        int result = 0;
//
//        try{
//            if(null != ids){
//                for(String id : ids){
//                    jaloGoodsTransitDetailService.deleteJaloGoodsTransitDetailBytransitSumId(id);
//                }
//                result = jaloGoodsTransitSumService.deleteJaloGoodsTransitSumByIds(ids);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return toAjax(result);
//    }
//
//}
