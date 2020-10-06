package com.ruoyi.web.controller.jalohome;

import java.util.Date;
import java.util.List;

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
import com.ruoyi.system.domain.JaloPurchasedUnshipped;
import com.ruoyi.system.service.IJaloPurchasedUnshippedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 已购买未发货Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@RestController
@RequestMapping("/amount/unshipped")
public class JaloPurchasedUnshippedController extends BaseController
{
    private final Logger logger = LoggerFactory.getLogger(JaloPurchasedUnshippedController.class);

    @Autowired
    private IJaloPurchasedUnshippedService jaloPurchasedUnshippedService;

    /**
     * 查询已购买未发货列表
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        logger.info("---------- JaloPurchasedUnshippedController list ------------");

        startPage();
        List<JaloPurchasedUnshipped> list = jaloPurchasedUnshippedService.selectJaloPurchasedUnshippedList(jaloPurchasedUnshipped);
        return getDataTable(list);
    }

    /**
     * 导出已购买未发货列表
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:export')")
    @Log(title = "已购买未发货", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        logger.info("---------- JaloPurchasedUnshippedController export ------------");
        List<JaloPurchasedUnshipped> list = jaloPurchasedUnshippedService.selectJaloPurchasedUnshippedList(jaloPurchasedUnshipped);
        ExcelUtil<JaloPurchasedUnshipped> util = new ExcelUtil<JaloPurchasedUnshipped>(JaloPurchasedUnshipped.class);
        return util.exportExcel(list, "unshipped");
    }

    /**
     * 获取已购买未发货详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloPurchasedUnshippedService.selectJaloPurchasedUnshippedById(id));
    }

    /**
     * 新增已购买未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:add')")
    @Log(title = "已购买未发货", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        if(null != jaloPurchasedUnshipped){
            jaloPurchasedUnshipped.setUpdateTime(new Date());
        }
        return toAjax(jaloPurchasedUnshippedService.insertJaloPurchasedUnshipped(jaloPurchasedUnshipped));
    }

    /**
     * 修改已购买未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:edit')")
    @Log(title = "已购买未发货", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloPurchasedUnshipped jaloPurchasedUnshipped)
    {
        return toAjax(jaloPurchasedUnshippedService.updateJaloPurchasedUnshipped(jaloPurchasedUnshipped));
    }

    /**
     * 删除已购买未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:unshipped:remove')")
    @Log(title = "已购买未发货", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloPurchasedUnshippedService.deleteJaloPurchasedUnshippedByIds(ids));
    }
}
