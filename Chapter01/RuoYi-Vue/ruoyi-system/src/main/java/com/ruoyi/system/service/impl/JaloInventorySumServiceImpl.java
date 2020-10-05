package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.JaloInventoryDetail;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloInventorySumMapper;
import com.ruoyi.system.domain.JaloInventorySum;
import com.ruoyi.system.service.IJaloInventorySumService;

/**
 * 库存汇总Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloInventorySumServiceImpl implements IJaloInventorySumService 
{
    @Autowired
    private JaloInventorySumMapper jaloInventorySumMapper;

    /**
     * 查询库存汇总
     * 
     * @param id 库存汇总ID
     * @return 库存汇总
     */
    @Override
    public JaloInventorySum selectJaloInventorySumById(Long id)
    {
        return jaloInventorySumMapper.selectJaloInventorySumById(id);
    }

    /**
     * 查询库存汇总列表
     * 
     * @param jaloInventorySum 库存汇总
     * @return 库存汇总
     */
    @Override
    public List<JaloInventorySum> selectJaloInventorySumList(JaloInventorySum jaloInventorySum)
    {
        return jaloInventorySumMapper.selectJaloInventorySumList(jaloInventorySum);
    }

    /**
     * 新增库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    @Override
    public int insertJaloInventorySum(JaloInventorySum jaloInventorySum)
    {
        jaloInventorySum.setCreateTime(DateUtils.getNowDate());
        return jaloInventorySumMapper.insertJaloInventorySum(jaloInventorySum);
    }

    /**
     * 修改库存汇总
     * 
     * @param jaloInventorySum 库存汇总
     * @return 结果
     */
    @Override
    public int updateJaloInventorySum(JaloInventorySum jaloInventorySum)
    {
        jaloInventorySum.setUpdateTime(DateUtils.getNowDate());
        return jaloInventorySumMapper.updateJaloInventorySum(jaloInventorySum);
    }

    /**
     * 批量删除库存汇总
     * 
     * @param ids 需要删除的库存汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventorySumByIds(String[] ids)
    {
        return jaloInventorySumMapper.deleteJaloInventorySumByIds(ids);
    }

    /**
     * 删除库存汇总信息
     * 
     * @param id 库存汇总ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventorySumById(String id)
    {
        return jaloInventorySumMapper.deleteJaloInventorySumById(id);
    }

    public AjaxResult exportExcel(List<JaloInventorySum> list, String sheetName){
        HSSFWorkbook wb = new HSSFWorkbook();
        //2.创建工作簿
        HSSFSheet sheet = wb.createSheet();
        //3.创建标题行
        HSSFRow titlerRow = sheet.createRow(0);
        titlerRow.createCell(0).setCellValue("产品名称");
        titlerRow.createCell(1).setCellValue("合计金额");
        titlerRow.createCell(2).setCellValue("可销售库存");
        titlerRow.createCell(3).setCellValue("");
        titlerRow.createCell(4).setCellValue("不可销售库存");
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));

        HSSFRow secondrRow = sheet.createRow(1);
        secondrRow.createCell(0).setCellValue("");
        secondrRow.createCell(1).setCellValue("");
        secondrRow.createCell(2).setCellValue("数量");
        secondrRow.createCell(3).setCellValue("金额");
        secondrRow.createCell(4).setCellValue("数量");
        secondrRow.createCell(5).setCellValue("金额");
        int rowNum = 2;
        for(JaloInventorySum inventorySum : list){
            List<JaloInventoryDetail> inventoryDetails =  inventorySum.getInventoryDetails();

            for(JaloInventoryDetail inventoryDetail : inventoryDetails){
                Row tempRow = sheet.createRow(rowNum++);

                for(int j=0 ; j<6;j++){
                    Cell tempCell = tempRow.createCell(j);
                    String tempValue = j+"";

                    if(j == 0){
                        tempValue = inventoryDetail.getProduct();
                    }else if( j==1 ){
                        tempValue = inventorySum.getSumInventoryAmount() + "";
                    }else if( j==2 ) {
                        tempValue = inventoryDetail.getSaleableInventoryNum()+"";
                    }else if( j==3 ) {
                        tempValue = inventoryDetail.getSaleableInventoryAmount()+"";
                    }else if( j==4 ) {
                        tempValue = inventoryDetail.getUnsaleableInventoryNum() + "";
                    }else if( j==5 ) {
                        tempValue = inventoryDetail.getUnsaleableInventoryAmount() + "";
                    }

                    tempCell.setCellValue(tempValue);
                }
            }
        }

        OutputStream out = null;

        try{


            String filename = encodingFilename(sheetName);
            out = new FileOutputStream(getAbsoluteFile(filename));
            wb.write(out);

            return AjaxResult.success(filename);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String getAbsoluteFile(String filename)
    {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    /**
     * 编码文件名
     */
    public String encodingFilename(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xls";
        return filename;
    }


}
