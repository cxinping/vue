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
import com.ruoyi.system.domain.JaloLoanUsage;
import com.ruoyi.system.service.IJaloLoanUsageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 贷款使用Controller
 * 
 * @author ruoyi
 * @date 2020-08-29
 */
@RestController
@RequestMapping("/amount/usage")
public class JaloLoanUsageController extends BaseController
{
    @Autowired
    private IJaloLoanUsageService jaloLoanUsageService;

    /**
     * 查询贷款使用列表
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloLoanUsage jaloLoanUsage)
    {
        startPage();
        List<JaloLoanUsage> list = jaloLoanUsageService.selectJaloLoanUsageList(jaloLoanUsage);
        return getDataTable(list);
    }

    /**
     * 导出贷款使用列表
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:export')")
    @Log(title = "贷款使用", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloLoanUsage jaloLoanUsage)
    {
        List<JaloLoanUsage> list = jaloLoanUsageService.selectJaloLoanUsageList(jaloLoanUsage);
        ExcelUtil<JaloLoanUsage> util = new ExcelUtil<JaloLoanUsage>(JaloLoanUsage.class);
        return util.exportExcel(list, "usage");
    }

    /**
     * 获取贷款使用详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloLoanUsageService.selectJaloLoanUsageById(id));
    }

    /**
     * 新增贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:add')")
    @Log(title = "贷款使用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloLoanUsage jaloLoanUsage)
    {
        System.out.println("*** add *** ");
        System.out.println(jaloLoanUsage);

        if(null != jaloLoanUsage){
            jaloLoanUsage.setUpdateTime(new Date());
        }
        return toAjax(jaloLoanUsageService.insertJaloLoanUsage(jaloLoanUsage));
    }

    /**
     * 修改贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:edit')")
    @Log(title = "贷款使用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloLoanUsage jaloLoanUsage)
    {
        return toAjax(jaloLoanUsageService.updateJaloLoanUsage(jaloLoanUsage));
    }

    /**
     * 删除贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:usage:remove')")
    @Log(title = "贷款使用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloLoanUsageService.deleteJaloLoanUsageByIds(ids));
    }
}
