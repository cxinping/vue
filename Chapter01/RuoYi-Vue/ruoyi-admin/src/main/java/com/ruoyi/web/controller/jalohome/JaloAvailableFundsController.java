package com.ruoyi.web.controller.jalohome;

import java.util.Date;
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
import com.ruoyi.system.domain.JaloAvailableFunds;
import com.ruoyi.system.service.IJaloAvailableFundsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 可用资金Controller
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
@RestController
@RequestMapping("/amount/funds")
public class JaloAvailableFundsController extends BaseController
{
    @Autowired
    private IJaloAvailableFundsService jaloAvailableFundsService;

    /**
     * 查询可用资金列表
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloAvailableFunds jaloAvailableFunds)
    {
        startPage();
        List<JaloAvailableFunds> list = jaloAvailableFundsService.selectJaloAvailableFundsList(jaloAvailableFunds);
        return getDataTable(list);
    }

    /**
     * 导出可用资金列表
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:export')")
    @Log(title = "可用资金", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloAvailableFunds jaloAvailableFunds)
    {
        List<JaloAvailableFunds> list = jaloAvailableFundsService.selectJaloAvailableFundsList(jaloAvailableFunds);
        ExcelUtil<JaloAvailableFunds> util = new ExcelUtil<JaloAvailableFunds>(JaloAvailableFunds.class);
        return util.exportExcel(list, "funds");
    }

    /**
     * 获取可用资金详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloAvailableFundsService.selectJaloAvailableFundsById(id));
    }

    /**
     * 新增可用资金
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:add')")
    @Log(title = "可用资金", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloAvailableFunds jaloAvailableFunds)
    {
        if(null != jaloAvailableFunds){
            jaloAvailableFunds.setUpdateTime(new Date());
        }
        return toAjax(jaloAvailableFundsService.insertJaloAvailableFunds(jaloAvailableFunds));
    }

    /**
     * 修改可用资金
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:edit')")
    @Log(title = "可用资金", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloAvailableFunds jaloAvailableFunds)
    {
        return toAjax(jaloAvailableFundsService.updateJaloAvailableFunds(jaloAvailableFunds));
    }

    /**
     * 删除可用资金
     */
    @PreAuthorize("@ss.hasPermi('amount:funds:remove')")
    @Log(title = "可用资金", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloAvailableFundsService.deleteJaloAvailableFundsByIds(ids));
    }
}
