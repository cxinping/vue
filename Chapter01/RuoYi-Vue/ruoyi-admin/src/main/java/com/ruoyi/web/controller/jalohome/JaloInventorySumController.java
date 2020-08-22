package com.ruoyi.web.controller.jalohome;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.id.IdGenerator;
import com.ruoyi.system.domain.JaloInventoryDetail;
import com.ruoyi.system.service.IJaloInventoryDetailService;
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
@RequestMapping("/amount/sum")
public class JaloInventorySumController extends BaseController
{
    @Autowired
    private IJaloInventorySumService jaloInventorySumService;

    @Autowired
    private IJaloInventoryDetailService jaloInventoryDetailService;

    /**
     * 查询库存汇总列表
     */
    @PreAuthorize("@ss.hasPermi('amount:sum:list')")
    @GetMapping("/list")
    public TableDataInfo list(JaloInventorySum jaloInventorySum)
    {
        startPage();
        List<JaloInventorySum> list = jaloInventorySumService.selectJaloInventorySumList(jaloInventorySum);
        String inventory_id = null;
        for(JaloInventorySum inventory : list){
            inventory_id = inventory.getId();
            List<JaloInventoryDetail> inventoryDetails =  jaloInventoryDetailService.selectJaloInventoryDetailListByInventorySumId(inventory_id);
            inventory.setInventoryDetails(inventoryDetails );
        }

        return getDataTable(list);
    }

    /**
     * 导出库存汇总列表
     */
    @PreAuthorize("@ss.hasPermi('amount:sum:export')")
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
    @PreAuthorize("@ss.hasPermi('amount:sum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jaloInventorySumService.selectJaloInventorySumById(id));
    }

    /**
     * 新增库存汇总
     */
    @PreAuthorize("@ss.hasPermi('amount:sum:add')")
    @Log(title = "库存汇总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JaloInventorySum jaloInventorySum)
    {
        if(null != jaloInventorySum){
            jaloInventorySum.setUpdateTime(new Date());
        }

        System.out.println("===========  add ===========");
        System.out.println( jaloInventorySum );


        String id = IdGenerator.get();
        jaloInventorySum.setId(id);

        List<JaloInventoryDetail> inventoryDetails = jaloInventorySum.getInventoryDetails();

        if(null != inventoryDetails ){
            for(JaloInventoryDetail inventoryDetail :inventoryDetails){
                inventoryDetail.setId( IdGenerator.get());
                inventoryDetail.setJaloInventorySumId(id);
                inventoryDetail.setCreateTime(new Date());
                inventoryDetail.setUpdateTime(new Date());
                jaloInventoryDetailService.insertJaloInventoryDetail( inventoryDetail);

                System.out.println( "orderNum = " + inventoryDetail.getOrderNum() +  "\n");

            }
        }

        return toAjax(jaloInventorySumService.insertJaloInventorySum(jaloInventorySum));
    }

    /**
     * 修改库存汇总
     */
    @PreAuthorize("@ss.hasPermi('amount:sum:edit')")
    @Log(title = "库存汇总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JaloInventorySum jaloInventorySum)
    {
        System.out.println("------ edit step 0 --------");
        System.out.println( jaloInventorySum );


        String jaloInventorySumId = jaloInventorySum.getId();
        if(null != jaloInventorySumId ){
            jaloInventoryDetailService.deleteJaloInventoryDetailByInventorySumId(jaloInventorySumId );
        }

        jaloInventorySum.setUpdateTime(new Date());
        List<JaloInventoryDetail> inventoryDetails = jaloInventorySum.getInventoryDetails();

        if(null != inventoryDetails){
            for(JaloInventoryDetail inventoryDetail : inventoryDetails){
               inventoryDetail.setId(IdGenerator.get());
               inventoryDetail.setJaloInventorySumId( jaloInventorySumId );
               inventoryDetail.setUpdateTime(new Date());
               inventoryDetail.setCreateTime(new Date());
               jaloInventoryDetailService.insertJaloInventoryDetail(inventoryDetail );

               System.out.println( inventoryDetail + "\n");
            }
        }

        int updateFlag = jaloInventorySumService.updateJaloInventorySum(jaloInventorySum);
        updateFlag = 1;
        System.out.println("**** step 2 updateFlag=" + updateFlag );

        return toAjax(updateFlag);
    }

    /**
     * 删除库存汇总
     */
    @PreAuthorize("@ss.hasPermi('amount:sum:remove')")
    @Log(title = "库存汇总", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        System.out.println("****** remove ************** ids=" + ids[0] );


        jaloInventoryDetailService.deleteJaloInventoryDetailByInventorySumId(ids[0]);

        return toAjax(jaloInventorySumService.deleteJaloInventorySumByIds(ids));
    }





}
