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
import com.ruoyi.system.domain.JaloInventorySum;
import com.ruoyi.system.service.IJaloInventorySumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存汇总Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@RestController
@RequestMapping("/system/sum")
public class JaloInventorySumController extends BaseController
{
    @Autowired
    private IJaloInventorySumService jaloInventorySumService;

    /**
     * 查询库存汇总列表
     */
    @PreAuthorize("@ss.hasPermi('system:sum:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloInventorySum jaloInventorySum)
    {
        startPage();
        List<JaloInventorySum> list = jaloInventorySumService.selectJaloInventorySumList(jaloInventorySum);
        return getDataTable(list);
    }

    /**
     * 导出库存汇总列表
     */
    @PreAuthorize("@ss.hasPermi('system:sum:export')")
    @Log(title = "库存汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloInventorySum jaloInventorySum)
    {
        List<JaloInventorySum> list = jaloInventorySumService.selectJaloInventorySumList(jaloInventorySum);
        ExcelUtil<JaloInventorySum> util = new ExcelUtil<JaloInventorySum>(JaloInventorySum.class);
        return util.exportExcel(list, "sum");
    }

    /**
     * 获取库存汇总详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloInventorySumService.selectJaloInventorySumById(id));
    }

    /**
     * 新增库存汇总
     */
    @PreAuthorize("@ss.hasPermi('system:sum:add')")
    @Log(title = "库存汇总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloInventorySum jaloInventorySum)
    {
        if(null != jaloInventorySum){
            jaloInventorySum.setUpdateTime(new Date());
        }
        return toAjax(jaloInventorySumService.insertJaloInventorySum(jaloInventorySum));
    }

    /**
     * 修改库存汇总
     */
    @PreAuthorize("@ss.hasPermi('system:sum:edit')")
    @Log(title = "库存汇总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloInventorySum jaloInventorySum)
    {
        return toAjax(jaloInventorySumService.updateJaloInventorySum(jaloInventorySum));
    }

    /**
     * 删除库存汇总
     */
    @PreAuthorize("@ss.hasPermi('system:sum:remove')")
    @Log(title = "库存汇总", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloInventorySumService.deleteJaloInventorySumByIds(ids));
    }
}
