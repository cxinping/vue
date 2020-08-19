package com.ruoyi.web.controller.jalohome;

import java.util.List;
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
import com.ruoyi.system.domain.JaloPlacedNotShipped;
import com.ruoyi.system.service.IJaloPlacedNotShippedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 已下单未发货 Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@RestController
@RequestMapping("/amount/shipped")
public class JaloPlacedNotShippedController extends BaseController
{
    @Autowired
    private IJaloPlacedNotShippedService jaloPlacedNotShippedService;

    /**
     * 查询已下单未发货列表
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        startPage();
        List<JaloPlacedNotShipped> list = jaloPlacedNotShippedService.selectJaloPlacedNotShippedList(jaloPlacedNotShipped);
        return getDataTable(list);
    }

    /**
     * 导出已下单未发货列表
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:export')")
    @Log(title = "已下单未发货", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        List<JaloPlacedNotShipped> list = jaloPlacedNotShippedService.selectJaloPlacedNotShippedList(jaloPlacedNotShipped);
        ExcelUtil<JaloPlacedNotShipped> util = new ExcelUtil<JaloPlacedNotShipped>(JaloPlacedNotShipped.class);
        return util.exportExcel(list, "shipped");
    }

    /**
     * 获取已下单未发货详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloPlacedNotShippedService.selectJaloPlacedNotShippedById(id));
    }

    /**
     * 新增已下单未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:add')")
    @Log(title = "已下单未发货", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        return toAjax(jaloPlacedNotShippedService.insertJaloPlacedNotShipped(jaloPlacedNotShipped));
    }

    /**
     * 修改已下单未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:edit')")
    @Log(title = "已下单未发货", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloPlacedNotShipped jaloPlacedNotShipped)
    {
        return toAjax(jaloPlacedNotShippedService.updateJaloPlacedNotShipped(jaloPlacedNotShipped));
    }

    /**
     * 删除已下单未发货
     */
    @PreAuthorize("@ss.hasPermi('amount:shipped:remove')")
    @Log(title = "已下单未发货", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloPlacedNotShippedService.deleteJaloPlacedNotShippedByIds(ids));
    }
}
