package com.ruoyi.web.controller.jalohome;

import java.util.*;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SumJaloPurchaseOrderTrackingInfo;
import com.ruoyi.system.vo.SupplierVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.JaloPurchaseOrderTrackingInformation;
import com.ruoyi.system.service.IJaloPurchaseOrderTrackingInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单跟踪信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@RestController
@RequestMapping("/amount/information")
public class JaloPurchaseOrderTrackingInformationController extends BaseController
{
    private final Logger logger = LoggerFactory.getLogger(JaloPurchaseOrderTrackingInformationController.class);

    @Autowired
    private IJaloPurchaseOrderTrackingInformationService jaloPurchaseOrderTrackingInformationService;

    /**
     * 查询采购订单跟踪信息列表
     */
    @PreAuthorize("@ss.hasPermi('amount:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        logger.info("---- JaloPurchaseOrderTrackingInformationController list ----" );
        logger.info(jaloPurchaseOrderTrackingInformation.toString() );


        startPage();
        List<JaloPurchaseOrderTrackingInformation> list = jaloPurchaseOrderTrackingInformationService.selectJaloPurchaseOrderTrackingInformationList(jaloPurchaseOrderTrackingInformation);
        SumJaloPurchaseOrderTrackingInfo sumInfo = jaloPurchaseOrderTrackingInformationService.selectSumJaloPurchaseOrderTrackingInfoList(jaloPurchaseOrderTrackingInformation);

        return getDataTable(list,sumInfo);
    }

    /**
     * 查询供应商
     *
     * http://localhost:8080/amount/information/getSupplier
     */
    @PostMapping("/getSupplier")
    public AjaxResult getSupplier(String supplier){
        logger.info("---- JaloPurchaseOrderTrackingInformationController getSupplier supplier=" + supplier );

        Map result = new HashMap();
        List suppliers = null;

        if(StringUtils.isBlank(supplier)){
            suppliers = new ArrayList();
        }else{
            suppliers = jaloPurchaseOrderTrackingInformationService.selectJaloPurchaseOrderTrackingInfoSuppliersByInfo(supplier);
        }

        result.put("rows", suppliers);

        return AjaxResult.success(result);
    }

    /**
     * http://localhost:8080/amount/information/suppplier/list
     *
     * */
    @GetMapping("/suppplier/list")
    public AjaxResult listSupplier(){
        List<SupplierVo> suppliers = jaloPurchaseOrderTrackingInformationService.selectJaloPurchaseOrderTrackingInfoSupplierList();
        //logger.info("---- listSupplier ----");
        //logger.info(suppliers.toString());

        return AjaxResult.success(suppliers);
    }

    /**
     * 导出采购订单跟踪信息列表
     */
    @PreAuthorize("@ss.hasPermi('amount:information:export')")
    @Log(title = "采购订单跟踪信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        List<JaloPurchaseOrderTrackingInformation> list = jaloPurchaseOrderTrackingInformationService.selectJaloPurchaseOrderTrackingInformationList(jaloPurchaseOrderTrackingInformation);
        ExcelUtil<JaloPurchaseOrderTrackingInformation> util = new ExcelUtil<JaloPurchaseOrderTrackingInformation>(JaloPurchaseOrderTrackingInformation.class);
        return util.exportExcel(list, "采购订单跟踪信息列表");
    }

    /**
     * 获取采购订单跟踪信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        System.out.println("*** getInfo() **** id=" + id );
        return AjaxResult.success(jaloPurchaseOrderTrackingInformationService.selectJaloPurchaseOrderTrackingInformationById(id));
    }

    /**
     * 新增采购订单跟踪信息
     */
    @PreAuthorize("@ss.hasPermi('amount:information:add')")
    @Log(title = "采购订单跟踪信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        if(null != jaloPurchaseOrderTrackingInformation){
            jaloPurchaseOrderTrackingInformation.setUpdateTime(new Date());
        }
        return toAjax(jaloPurchaseOrderTrackingInformationService.insertJaloPurchaseOrderTrackingInformation(jaloPurchaseOrderTrackingInformation));
    }

    /**
     * 修改采购订单跟踪信息
     */
    @PreAuthorize("@ss.hasPermi('amount:information:edit')")
    @Log(title = "采购订单跟踪信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloPurchaseOrderTrackingInformation jaloPurchaseOrderTrackingInformation)
    {
        return toAjax(jaloPurchaseOrderTrackingInformationService.updateJaloPurchaseOrderTrackingInformation(jaloPurchaseOrderTrackingInformation));
    }

    /**
     * 删除采购订单跟踪信息
     */
    @PreAuthorize("@ss.hasPermi('amount:information:remove')")
    @Log(title = "采购订单跟踪信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloPurchaseOrderTrackingInformationService.deleteJaloPurchaseOrderTrackingInformationByIds(ids));
    }
}
