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
import com.ruoyi.system.domain.AmountStatistics;
import com.ruoyi.system.service.IAmountStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 统计页面Controller
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
@RestController
@RequestMapping("/amount/statistics")
public class AmountStatisticsController extends BaseController
{
    @Autowired
    private IAmountStatisticsService amountStatisticsService;

    /**
     * 查询统计页面列表
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(AmountStatistics amountStatistics)
    {
        startPage();
        List<AmountStatistics> list = amountStatisticsService.selectAmountStatisticsList(amountStatistics);
        return getDataTable(list);
    }

    /**
     * 导出统计页面列表
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:export')")
    @Log(title = "统计页面", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AmountStatistics amountStatistics)
    {
        List<AmountStatistics> list = amountStatisticsService.selectAmountStatisticsList(amountStatistics);
        ExcelUtil<AmountStatistics> util = new ExcelUtil<AmountStatistics>(AmountStatistics.class);
        return util.exportExcel(list, "statistics");
    }

    /**
     * 获取统计页面详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(amountStatisticsService.selectAmountStatisticsById(id));
    }

    /**
     * 新增统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:add')")
    @Log(title = "统计页面", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AmountStatistics amountStatistics)
    {
        return toAjax(amountStatisticsService.insertAmountStatistics(amountStatistics));
    }

    /**
     * 修改统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:edit')")
    @Log(title = "统计页面", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AmountStatistics amountStatistics)
    {
        return toAjax(amountStatisticsService.updateAmountStatistics(amountStatistics));
    }

    /**
     * 删除统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:remove')")
    @Log(title = "统计页面", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(amountStatisticsService.deleteAmountStatisticsByIds(ids));
    }
}
