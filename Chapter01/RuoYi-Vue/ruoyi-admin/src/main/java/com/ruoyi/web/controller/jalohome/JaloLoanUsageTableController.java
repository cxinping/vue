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
import com.ruoyi.system.domain.JaloLoanUsageTable;
import com.ruoyi.system.service.IJaloLoanUsageTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 贷款使用Controller
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
@RestController
@RequestMapping("/amount/loan")
public class JaloLoanUsageTableController extends BaseController
{
    @Autowired
    private IJaloLoanUsageTableService jaloLoanUsageTableService;

    /**
     * 查询贷款使用列表
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloLoanUsageTable jaloLoanUsageTable)
    {
        startPage();
        List<JaloLoanUsageTable> list = jaloLoanUsageTableService.selectJaloLoanUsageTableList(jaloLoanUsageTable);
        return getDataTable(list);
    }

    /**
     * 导出贷款使用列表
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:export')")
    @Log(title = "贷款使用", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloLoanUsageTable jaloLoanUsageTable)
    {
        List<JaloLoanUsageTable> list = jaloLoanUsageTableService.selectJaloLoanUsageTableList(jaloLoanUsageTable);
        ExcelUtil<JaloLoanUsageTable> util = new ExcelUtil<JaloLoanUsageTable>(JaloLoanUsageTable.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 获取贷款使用详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloLoanUsageTableService.selectJaloLoanUsageTableById(id));
    }

    /**
     * 新增贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:add')")
    @Log(title = "贷款使用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloLoanUsageTable jaloLoanUsageTable)
    {
        if(null != jaloLoanUsageTable){
            jaloLoanUsageTable.setUpdateTime(new Date());
        }

        return toAjax(jaloLoanUsageTableService.insertJaloLoanUsageTable(jaloLoanUsageTable));
    }

    /**
     * 修改贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:edit')")
    @Log(title = "贷款使用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloLoanUsageTable jaloLoanUsageTable)
    {
        return toAjax(jaloLoanUsageTableService.updateJaloLoanUsageTable(jaloLoanUsageTable));
    }

    /**
     * 删除贷款使用
     */
    @PreAuthorize("@ss.hasPermi('amount:loan:remove')")
    @Log(title = "贷款使用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloLoanUsageTableService.deleteJaloLoanUsageTableByIds(ids));
    }
}
