package com.ruoyi.web.controller.jalohome;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(JaloInventoryDetailController.class);

    @Autowired
    private IJaloInventoryDetailService jaloInventoryDetailService;

    /**
     * 查询库存详细列表
     */
//    @PreAuthorize("@ss.hasPermi('amount:detail:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(JaloInventoryDetail jaloInventoryDetail)
//    {
//        startPage();
//        List<JaloInventoryDetail> list = jaloInventoryDetailService.selectJaloInventoryDetailList(jaloInventoryDetail);
//        return getDataTable(list);
//    }

    @PreAuthorize("@ss.hasPermi('amount:detail:list')")
    @GetMapping("/list")
    public JaloInventoryDetail list(JaloInventoryDetail jaloInventoryDetail)
    {
        logger.info("----- JaloInventoryDetailController list----");

        JaloInventoryDetail inventoryDetail = jaloInventoryDetailService.treeJaloInventoryDetailList(jaloInventoryDetail);
        return inventoryDetail;
    }

    /**
     * 导出库存详细列表
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:export')")
    @Log(title = "库存详细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JaloInventoryDetail jaloInventoryDetail)
    {
//        List<JaloInventoryDetail> list = jaloInventoryDetailService.selectJaloInventoryDetailList(jaloInventoryDetail);
//        ExcelUtil<JaloInventoryDetail> util = new ExcelUtil<JaloInventoryDetail>(JaloInventoryDetail.class);
        //return util.exportExcel(list, "detail");

        JaloInventoryDetail inventoryDetail = jaloInventoryDetailService.treeJaloInventoryDetailList(null);
        List<JaloInventoryDetail> children = inventoryDetail.getChildren();

        return jaloInventoryDetailService.exportExcel(children, "库存");

    }

    /**
     * 获取库存详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(jaloInventoryDetailService.selectJaloInventoryDetailById(id));
    }

    /**
     * 新增库存详细
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:add')")
    @Log(title = "库存详细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody JaloInventoryDetail jaloInventoryDetail)
    {
        logger.info("----- JaloInventoryDetailController add----");
        String id = IdUtils.fastSimpleUUID();
        if(null != jaloInventoryDetail){
            jaloInventoryDetail.setId(id);
            jaloInventoryDetail.setUpdateTime(new Date());
            BigDecimal inventoryAmount = jaloInventoryDetail.getSaleableInventoryAmount().add(jaloInventoryDetail.getUnsaleableInventoryAmount());
            jaloInventoryDetail.setInventoryAmount(inventoryAmount );
        }

        int flag = jaloInventoryDetailService.insertJaloInventoryDetail(jaloInventoryDetail);
        jaloInventoryDetailService.callInventoryDetailSum(jaloInventoryDetail);

        return toAjax(flag);
    }

    /**
     * 修改库存详细
     */
    @PreAuthorize("@ss.hasPermi('amount:detail:edit')")
    @Log(title = "库存详细", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody JaloInventoryDetail jaloInventoryDetail)
    {
        logger.info("----- JaloInventoryDetailController edit----");

        if(null != jaloInventoryDetail){
            jaloInventoryDetail.setUpdateTime(new Date());
            BigDecimal inventoryAmount = jaloInventoryDetail.getSaleableInventoryAmount().add(jaloInventoryDetail.getUnsaleableInventoryAmount());
            jaloInventoryDetail.setInventoryAmount(inventoryAmount );
        }

        int flag = jaloInventoryDetailService.updateJaloInventoryDetail(jaloInventoryDetail);
        flag= 1;

        jaloInventoryDetailService.callInventoryDetailSum(jaloInventoryDetail);

        return toAjax(flag);
    }

    /**
     * 删除库存详细
     */
//    @PreAuthorize("@ss.hasPermi('amount:detail:remove')")
//    @Log(title = "库存详细", businessType = BusinessType.DELETE)
//	  @DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable String[] ids)
//    {
//        return toAjax(jaloInventoryDetailService.deleteJaloInventoryDetailByIds(ids));
//    }

    @PreAuthorize("@ss.hasPermi('amount:detail:remove')")
    @Log(title = "库存详细", businessType = BusinessType.DELETE)
    @DeleteMapping("/remove/{id}")
    public AjaxResult remove(@PathVariable("id") String id)
    {
        logger.info("----- JaloInventoryDetailController remove----");
        JaloInventoryDetail inventoryDetail=  jaloInventoryDetailService.selectJaloInventoryDetailById(id);
        int flag = jaloInventoryDetailService.deleteJaloInventoryDetailById(id);

        jaloInventoryDetailService.callInventoryDetailSum(inventoryDetail);

        return toAjax(flag);
    }


}
