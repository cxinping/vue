package com.ruoyi.web.controller.jalohome;

import java.util.ArrayList;
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
import com.ruoyi.system.domain.JaloAmountStatisticsView;
import com.ruoyi.system.service.IJaloAmountStatisticsViewService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2020-08-20
 */
@RestController
@RequestMapping("/amount/view")
public class JaloAmountStatisticsViewController extends BaseController
{
    @Autowired
    private IJaloAmountStatisticsViewService jaloAmountStatisticsViewService;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('amount:view:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        startPage();
         List<JaloAmountStatisticsView> list = jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
         return getDataTable(list);

//        List<JaloAmountStatisticsView> list = jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
//        List<JaloAmountStatisticsView> queryNewFromList = new ArrayList<JaloAmountStatisticsView>();
//        if(list.size()>0){
//            queryNewFromList.add( list.get(0));
//        }
//
//        return getDataTable(queryNewFromList);
    }

    @GetMapping("/queryNewFromList")
    public TableDataInfo queryNewFromList (JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        startPage();
        List<JaloAmountStatisticsView> list = jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
        List<JaloAmountStatisticsView> queryNewFromList = new ArrayList<JaloAmountStatisticsView>();
        if(list.size()>0){
            queryNewFromList.add( list.get(0));
        }

        return getDataTable(queryNewFromList);
    }


    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('amount:view:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        List<JaloAmountStatisticsView> list = jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
        ExcelUtil<JaloAmountStatisticsView> util = new ExcelUtil<JaloAmountStatisticsView>(JaloAmountStatisticsView.class);
        return util.exportExcel(list, "view");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:view:query')")
    @GetMapping(value = "/{days}")
    public AjaxResult getInfo(@PathVariable("days") String days)
    {
        return AjaxResult.success(jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewById(days));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('amount:view:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        return toAjax(jaloAmountStatisticsViewService.insertJaloAmountStatisticsView(jaloAmountStatisticsView));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('amount:view:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloAmountStatisticsView jaloAmountStatisticsView)
    {
        return toAjax(jaloAmountStatisticsViewService.updateJaloAmountStatisticsView(jaloAmountStatisticsView));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('amount:view:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dayss}")
    public AjaxResult remove(@PathVariable String[] dayss)
    {
        return toAjax(jaloAmountStatisticsViewService.deleteJaloAmountStatisticsViewByIds(dayss));
    }
}
