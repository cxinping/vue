package com.ruoyi.web.controller.jalohome;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.id.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.JaloGoodsTransitDetail;
import com.ruoyi.system.service.IJaloGoodsTransitDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在途物资详细Controller
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
@RestController
@RequestMapping("/amount/transit/detail")
public class JaloGoodsTransitDetailController extends BaseController
{
    private final Logger logger = LoggerFactory.getLogger(JaloGoodsTransitDetailController.class);

    @Autowired
    private IJaloGoodsTransitDetailService jaloGoodsTransitDetailService;

    /**
     * 查询在途物资详细列表
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        logger.info("----------- JaloGoodsTransitDetailController list -----------------");

        startPage();
        List<JaloGoodsTransitDetail> list = jaloGoodsTransitDetailService.selectJaloGoodsTransitDetailList(jaloGoodsTransitDetail);

        return getDataTable(list);
    }

    /**
     * 导出在途物资详细列表
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:export')")
    @Log(title = "在途物资详细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        List<JaloGoodsTransitDetail> list = jaloGoodsTransitDetailService.selectJaloGoodsTransitDetailList(jaloGoodsTransitDetail);
        ExcelUtil<JaloGoodsTransitDetail> util = new ExcelUtil<JaloGoodsTransitDetail>(JaloGoodsTransitDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 获取在途物资详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(jaloGoodsTransitDetailService.selectJaloGoodsTransitDetailById(id));
    }

    /**
     * 新增在途物资详细
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:add')")
    @Log(title = "在途物资详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        if(null != jaloGoodsTransitDetail){
            String id = IdGenerator.get();
            jaloGoodsTransitDetail.setId(id);
            jaloGoodsTransitDetail.setCreateTime(new java.util.Date());
            jaloGoodsTransitDetail.setUpdateTime(new java.util.Date());
        }

        return toAjax(jaloGoodsTransitDetailService.insertJaloGoodsTransitDetail(jaloGoodsTransitDetail));
    }

    /**
     * 修改在途物资详细
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:edit')")
    @Log(title = "在途物资详细", businessType = BusinessType.UPDATE)
    //@PutMapping
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public AjaxResult edit(@RequestBody JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        logger.info("----------- JaloGoodsTransitDetailController edit -----------------");

        if(null != jaloGoodsTransitDetail){
            jaloGoodsTransitDetail.setUpdateTime(new java.util.Date());
        }

        logger.info(jaloGoodsTransitDetail.toString());

        return toAjax(jaloGoodsTransitDetailService.updateJaloGoodsTransitDetail(jaloGoodsTransitDetail));
    }

    /**
     * 删除在途物资详细
     */
    @PreAuthorize("@ss.hasPermi('transit:detail:remove')")
    @Log(title = "在途物资详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(jaloGoodsTransitDetailService.deleteJaloGoodsTransitDetailByIds(ids));
    }
}
