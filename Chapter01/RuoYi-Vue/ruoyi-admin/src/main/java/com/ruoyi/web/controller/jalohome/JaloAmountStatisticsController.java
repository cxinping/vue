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
import com.ruoyi.system.domain.JaloAmountStatistics;
import com.ruoyi.system.service.IJaloAmountStatisticsService;
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
public class JaloAmountStatisticsController extends BaseController
{
    @Autowired
    private IJaloAmountStatisticsService jaloAmountStatisticsService;

    /**
     * 查询统计页面列表
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloAmountStatistics jaloAmountStatistics)
    {
        startPage();
        List<JaloAmountStatistics> list = jaloAmountStatisticsService.selectJaloAmountStatisticsList(jaloAmountStatistics);
        return getDataTable(list);
    }

    /**
     * 导出统计页面列表
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:export')")
    @Log(title = "统计页面", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloAmountStatistics jaloAmountStatistics)
    {
        List<JaloAmountStatistics> list = jaloAmountStatisticsService.selectJaloAmountStatisticsList(jaloAmountStatistics);
        ExcelUtil<JaloAmountStatistics> util = new ExcelUtil<JaloAmountStatistics>(JaloAmountStatistics.class);
        return util.exportExcel(list, "statistics");
    }

    /**
     * 获取统计页面详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloAmountStatisticsService.selectJaloAmountStatisticsById(id));
    }

    /**
     * 新增统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:add')")
    @Log(title = "统计页面", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloAmountStatistics jaloAmountStatistics)
    {
        if(null != jaloAmountStatistics){
            jaloAmountStatistics.setUpdateTime(new Date());
        }
        return toAjax(jaloAmountStatisticsService.insertJaloAmountStatistics(jaloAmountStatistics));
    }

    /**
     * 修改统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:edit')")
    @Log(title = "统计页面", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloAmountStatistics jaloAmountStatistics)
    {
        return toAjax(jaloAmountStatisticsService.updateJaloAmountStatistics(jaloAmountStatistics));
    }

    /**
     * 删除统计页面
     */
    @PreAuthorize("@ss.hasPermi('amount:statistics:remove')")
    @Log(title = "统计页面", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jaloAmountStatisticsService.deleteJaloAmountStatisticsByIds(ids));
    }
}
