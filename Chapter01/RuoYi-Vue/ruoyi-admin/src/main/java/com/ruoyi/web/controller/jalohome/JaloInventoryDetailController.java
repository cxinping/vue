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
import com.ruoyi.system.domain.JaloInventoryDetail;
import com.ruoyi.system.service.IJaloInventoryDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存详细Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@RestController
@RequestMapping("/amount/detail")
public class JaloInventoryDetailController extends BaseController
{
    @Autowired
    private IJaloInventoryDetailService jaloInventoryDetailService;

    /**
     * 查询库存详细列表
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloInventoryDetail jaloInventoryDetail)
    {
        startPage();
        List<JaloInventoryDetail> list = jaloInventoryDetailService.selectJaloInventoryDetailList(jaloInventoryDetail);
        return getDataTable(list);
    }

    /**
     * 导出库存详细列表
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:export')")
    @Log(title = "库存详细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloInventoryDetail jaloInventoryDetail)
    {
        List<JaloInventoryDetail> list = jaloInventoryDetailService.selectJaloInventoryDetailList(jaloInventoryDetail);
        ExcelUtil<JaloInventoryDetail> util = new ExcelUtil<JaloInventoryDetail>(JaloInventoryDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 获取库存详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloInventoryDetailService.selectJaloInventoryDetailById(id));
    }

    /**
     * 新增库存详细
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:add')")
    @Log(title = "库存详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloInventoryDetail jaloInventoryDetail)
    {
        return toAjax(jaloInventoryDetailService.insertJaloInventoryDetail(jaloInventoryDetail));
    }

    /**
     * 修改库存详细
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:edit')")
    @Log(title = "库存详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloInventoryDetail jaloInventoryDetail)
    {
        return toAjax(jaloInventoryDetailService.updateJaloInventoryDetail(jaloInventoryDetail));
    }

    /**
     * 删除库存详细
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:remove')")
    @Log(title = "库存详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(jaloInventoryDetailService.deleteJaloInventoryDetailByIds(ids));
    }
}
