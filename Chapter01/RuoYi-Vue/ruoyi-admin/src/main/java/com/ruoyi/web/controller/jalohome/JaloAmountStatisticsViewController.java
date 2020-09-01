package com.ruoyi.web.controller.jalohome;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.Arith;
import com.ruoyi.common.utils.StringUtils;
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
        System.out.println("----- list ------- ");
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
        System.out.println("----- queryNewFromList ------- ");
        startPage();
        List<JaloAmountStatisticsView> list = jaloAmountStatisticsViewService.selectJaloAmountStatisticsViewList(jaloAmountStatisticsView);
        List<JaloAmountStatisticsView> queryNewFromList = new ArrayList<JaloAmountStatisticsView>();

        System.out.println(" step 1 list.size()=" + list.size() );
        if(list.size()>0){

            JaloAmountStatisticsView amountStatisticsView = list.get(0);
            System.out.println(amountStatisticsView );
            initJaloAmountStatisticsView(amountStatisticsView);

            // 已下单未发货 + 已发货未结算 + 可用资金 – 贷款已使用金额
            BigDecimal statisticalIndicators1 = amountStatisticsView.getSumPurchasedUnshippedTotalAmount().add(amountStatisticsView.getSumShippedUnsettledTotalAmount() )
                    .add(amountStatisticsView.getSumAvailableFundsTotalAmount())
                    .subtract(amountStatisticsView.getLoanUsageTotalLoanCreditBalance());

            amountStatisticsView.setStatisticalIndicators1(statisticalIndicators1);
            queryNewFromList.add(amountStatisticsView);
        }else{
            JaloAmountStatisticsView amountStatisticsView = new JaloAmountStatisticsView();
            initJaloAmountStatisticsView(amountStatisticsView);

            queryNewFromList.add(amountStatisticsView);

        }

        return getDataTable(queryNewFromList);
    }

    private void  initJaloAmountStatisticsView(JaloAmountStatisticsView amountStatisticsView){
        if(amountStatisticsView.getSumContractAmount() == null){
            amountStatisticsView.setSumContractAmount( new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumContractAmount() ,10000,2);
            amountStatisticsView.setSumContractAmount(result);
        }

        if(amountStatisticsView.getSumPrepaymentAmountPaid() == null){
            amountStatisticsView.setSumPrepaymentAmountPaid(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumPrepaymentAmountPaid() ,10000,2);
            amountStatisticsView.setSumPrepaymentAmountPaid(result);
        }

        if(amountStatisticsView.getSumPrepaymentAmountPayable() == null){
            amountStatisticsView.setSumPrepaymentAmountPayable( new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumPrepaymentAmountPayable() ,10000,2);
            amountStatisticsView.setSumPrepaymentAmountPayable(result);
        }

        if(amountStatisticsView.getSumShippedUnsettledTotalAmount() == null){
            amountStatisticsView.setSumShippedUnsettledTotalAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumShippedUnsettledTotalAmount() ,10000,2);
            amountStatisticsView.setSumShippedUnsettledTotalAmount(result);
        }

        if(amountStatisticsView.getSumPurchasedUnshippedTotalAmount() == null){
            amountStatisticsView.setSumPurchasedUnshippedTotalAmount(new BigDecimal(0) );
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumPurchasedUnshippedTotalAmount() ,10000,2);
            amountStatisticsView.setSumPurchasedUnshippedTotalAmount(result);
        }

        if(amountStatisticsView.getLoanUsageTotalLoanCreditAmount() == null){
            amountStatisticsView.setLoanUsageTotalLoanCreditAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getLoanUsageTotalLoanCreditAmount() ,10000,2);
            amountStatisticsView.setLoanUsageTotalLoanCreditAmount(result);
        }

        if(amountStatisticsView.getLoanUsageTotalLoanCreditBalance() == null){
            amountStatisticsView.setLoanUsageTotalLoanCreditBalance(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getLoanUsageTotalLoanCreditBalance() ,10000,2);
            amountStatisticsView.setLoanUsageTotalLoanCreditBalance(result);
        }

        if(amountStatisticsView.getLoanUsageTotalLoanCreditRemaining() == null){
            amountStatisticsView.setLoanUsageTotalLoanCreditRemaining(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getLoanUsageTotalLoanCreditRemaining() ,10000,2);
            amountStatisticsView.setLoanUsageTotalLoanCreditRemaining(result);
        }

        if(amountStatisticsView.getSumAvailableFundsTotalAmount() == null){
            amountStatisticsView.setSumAvailableFundsTotalAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumAvailableFundsTotalAmount() ,10000,2);
            amountStatisticsView.setSumAvailableFundsTotalAmount(result);
        }

        if(amountStatisticsView.getSumInventoryAmount() == null){
            amountStatisticsView.setSumInventoryAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumInventoryAmount() ,10000,2);
            amountStatisticsView.setSumInventoryAmount(result);
        }

        if(amountStatisticsView.getSumSaleableInventoryAmount() == null){
            amountStatisticsView.setSumSaleableInventoryAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumSaleableInventoryAmount() ,10000,2);
            amountStatisticsView.setSumSaleableInventoryAmount(result);
        }

        if(amountStatisticsView.getSumUnsaleableInventoryAmount() == null){
            amountStatisticsView.setSumUnsaleableInventoryAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getSumUnsaleableInventoryAmount() ,10000,2);
            amountStatisticsView.setSumUnsaleableInventoryAmount(result);
        }

        if(amountStatisticsView.getGoodsTransitTotalAmount() == null){
            amountStatisticsView.setGoodsTransitTotalAmount(new BigDecimal(0));
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getGoodsTransitTotalAmount() ,10000,2);
            amountStatisticsView.setGoodsTransitTotalAmount(result);
        }

        if(amountStatisticsView.getStatisticalIndicators1() == null){
            amountStatisticsView.setStatisticalIndicators1( new BigDecimal(0) );
        }else{
            BigDecimal result = Arith.divNumber(amountStatisticsView.getStatisticalIndicators1() ,10000,2);
            amountStatisticsView.setStatisticalIndicators1(result);
        }

        if(amountStatisticsView.getDays() == null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String currTime = df.format(new Date());
            amountStatisticsView.setDays(currTime);
        }

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
