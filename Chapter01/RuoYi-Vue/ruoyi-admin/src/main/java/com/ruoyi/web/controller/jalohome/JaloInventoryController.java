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
import com.ruoyi.system.domain.JaloInventory;
import com.ruoyi.system.service.IJaloInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@RestController
@RequestMapping("/amount/inventory")
public class JaloInventoryController extends BaseController
{
    @Autowired
    private IJaloInventoryService jaloInventoryService;

    /**
     * 查询库存列表
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloInventory jaloInventory)
    {
        startPage();
        List<JaloInventory> list = jaloInventoryService.selectJaloInventoryList(jaloInventory);
        return getDataTable(list);
    }

    /**
     * 导出库存列表
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:export')")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloInventory jaloInventory)
    {
        List<JaloInventory> list = jaloInventoryService.selectJaloInventoryList(jaloInventory);
        ExcelUtil<JaloInventory> util = new ExcelUtil<JaloInventory>(JaloInventory.class);
        return util.exportExcel(list, "inventory");
    }

    /**
     * 获取库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloInventoryService.selectJaloInventoryById(id));
    }

    /**
     * 新增库存
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:add')")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloInventory jaloInventory)
    {
        return toAjax(jaloInventoryService.insertJaloInventory(jaloInventory));
    }

    /**
     * 修改库存
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:edit')")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloInventory jaloInventory)
    {
        return toAjax(jaloInventoryService.updateJaloInventory(jaloInventory));
    }

    /**
     * 删除库存
     */
    @PreAuthorize("@ss.hasPermi('amount:inventory:remove')")
    @Log(title = "库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloInventoryService.deleteJaloInventoryByIds(ids));
    }
}
