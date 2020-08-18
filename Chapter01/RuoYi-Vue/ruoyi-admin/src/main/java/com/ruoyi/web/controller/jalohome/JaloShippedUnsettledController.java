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
import com.ruoyi.system.domain.JaloShippedUnsettled;
import com.ruoyi.system.service.IJaloShippedUnsettledService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 已发货未结算金额Controller
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@RestController
@RequestMapping("/amount/unsettled")
public class JaloShippedUnsettledController extends BaseController
{
    @Autowired
    private IJaloShippedUnsettledService jaloShippedUnsettledService;

    /**
     * 查询已发货未结算金额列表
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloShippedUnsettled jaloShippedUnsettled)
    {
        startPage();
        List<JaloShippedUnsettled> list = jaloShippedUnsettledService.selectJaloShippedUnsettledList(jaloShippedUnsettled);
        return getDataTable(list);
    }

    /**
     * 导出已发货未结算金额列表
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:export')")
    @Log(title = "已发货未结算金额", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloShippedUnsettled jaloShippedUnsettled)
    {
        List<JaloShippedUnsettled> list = jaloShippedUnsettledService.selectJaloShippedUnsettledList(jaloShippedUnsettled);
        ExcelUtil<JaloShippedUnsettled> util = new ExcelUtil<JaloShippedUnsettled>(JaloShippedUnsettled.class);
        return util.exportExcel(list, "unsettled");
    }

    /**
     * 获取已发货未结算金额详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloShippedUnsettledService.selectJaloShippedUnsettledById(id));
    }

    /**
     * 新增已发货未结算金额
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:add')")
    @Log(title = "已发货未结算金额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloShippedUnsettled jaloShippedUnsettled)
    {
        return toAjax(jaloShippedUnsettledService.insertJaloShippedUnsettled(jaloShippedUnsettled));
    }

    /**
     * 修改已发货未结算金额
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:edit')")
    @Log(title = "已发货未结算金额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloShippedUnsettled jaloShippedUnsettled)
    {
        return toAjax(jaloShippedUnsettledService.updateJaloShippedUnsettled(jaloShippedUnsettled));
    }

    /**
     * 删除已发货未结算金额
     */
    @PreAuthorize("@ss.hasPermi('amount:unsettled:remove')")
    @Log(title = "已发货未结算金额", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloShippedUnsettledService.deleteJaloShippedUnsettledByIds(ids));
    }
}
