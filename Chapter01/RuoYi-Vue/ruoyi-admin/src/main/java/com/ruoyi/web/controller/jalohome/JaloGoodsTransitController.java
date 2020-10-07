//package com.ruoyi.web.controller.jalohome;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
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
//import com.ruoyi.system.domain.JaloGoodsTransit;
//import com.ruoyi.system.service.IJaloGoodsTransitService;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.common.core.page.TableDataInfo;
//
///**
// * 在途物资Controller
// *
// * @author ruoyi
// * @date 2020-08-19
// */
//@RestController
//@RequestMapping("/amount/transit")
//public class JaloGoodsTransitController extends BaseController
//{
//    @Autowired
//    private IJaloGoodsTransitService jaloGoodsTransitService;
//
//    /**
//     * 查询在途物资列表
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(JaloGoodsTransit jaloGoodsTransit)
//    {
//        startPage();
//        List<JaloGoodsTransit> list = jaloGoodsTransitService.selectJaloGoodsTransitList(jaloGoodsTransit);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出在途物资列表
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:export')")
//    @Log(title = "在途物资", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(JaloGoodsTransit jaloGoodsTransit)
//    {
//        List<JaloGoodsTransit> list = jaloGoodsTransitService.selectJaloGoodsTransitList(jaloGoodsTransit);
//        ExcelUtil<JaloGoodsTransit> util = new ExcelUtil<JaloGoodsTransit>(JaloGoodsTransit.class);
//        return util.exportExcel(list, "transit");
//    }
//
//    /**
//     * 获取在途物资详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Long id)
//    {
//        return AjaxResult.success(jaloGoodsTransitService.selectJaloGoodsTransitById(id));
//    }
//
//    /**
//     * 新增在途物资
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:add')")
//    @Log(title = "在途物资", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody JaloGoodsTransit jaloGoodsTransit)
//    {
//        if(null != jaloGoodsTransit){
//            jaloGoodsTransit.setUpdateTime(new Date());
//        }
//
//        BigDecimal totalAmount = jaloGoodsTransit.getBuildingMaterials().add( jaloGoodsTransit.getDailyNecessities())
//                                    .add(jaloGoodsTransit.getDevice()).add(jaloGoodsTransit.getFurniture())
//                                    .add(jaloGoodsTransit.getKitchenBathroom()).add(jaloGoodsTransit.getLamps())
//                                    .add(jaloGoodsTransit.getOther()).add(jaloGoodsTransit.getDailyNecessities())
//                                    .add(jaloGoodsTransit.getTextile());
//        jaloGoodsTransit.setTotalAmount(totalAmount);
//
//        return toAjax(jaloGoodsTransitService.insertJaloGoodsTransit(jaloGoodsTransit));
//    }
//
//    /**
//     * 修改在途物资
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:edit')")
//    @Log(title = "在途物资", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody JaloGoodsTransit jaloGoodsTransit)
//    {
//        if(null != jaloGoodsTransit){
//            jaloGoodsTransit.setUpdateTime(new Date());
//        }
//
//        BigDecimal totalAmount = jaloGoodsTransit.getBuildingMaterials().add( jaloGoodsTransit.getDailyNecessities())
//                .add(jaloGoodsTransit.getDevice()).add(jaloGoodsTransit.getFurniture())
//                .add(jaloGoodsTransit.getKitchenBathroom()).add(jaloGoodsTransit.getLamps())
//                .add(jaloGoodsTransit.getOther()).add(jaloGoodsTransit.getDailyNecessities())
//                .add(jaloGoodsTransit.getTextile());
//        jaloGoodsTransit.setTotalAmount(totalAmount);
//
//        System.out.println("*** edit jaloGoodsTransit=> " + jaloGoodsTransit);
//
//        return toAjax(jaloGoodsTransitService.updateJaloGoodsTransit(jaloGoodsTransit));
//    }
//
//    /**
//     * 删除在途物资
//     */
//    @PreAuthorize("@ss.hasPermi('amount:transit:remove')")
//    @Log(title = "在途物资", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Long[] ids)
//    {
//        return toAjax(jaloGoodsTransitService.deleteJaloGoodsTransitByIds(ids));
//    }
//}
