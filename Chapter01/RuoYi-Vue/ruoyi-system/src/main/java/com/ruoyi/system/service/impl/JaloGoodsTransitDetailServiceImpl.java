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
import com.ruoyi.system.domain.JaloInventorySum;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloGoodsTransitDetailMapper;
import com.ruoyi.system.domain.JaloGoodsTransitDetail;
import com.ruoyi.system.service.IJaloGoodsTransitDetailService;

/**
 * 在途物资详细Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-03
 */
@Service
public class JaloGoodsTransitDetailServiceImpl implements IJaloGoodsTransitDetailService 
{
    @Autowired
    private JaloGoodsTransitDetailMapper jaloGoodsTransitDetailMapper;

    /**
     * 查询在途物资详细
     * 
     * @param id 在途物资详细ID
     * @return 在途物资详细
     */
    @Override
    public JaloGoodsTransitDetail selectJaloGoodsTransitDetailById(String id)
    {
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailById(id);
    }

    /**
     * 查询在途物资详细列表
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 在途物资详细
     */
    @Override
    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailList(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailList(jaloGoodsTransitDetail);
    }

    /**
     * 新增在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    @Override
    public int insertJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        jaloGoodsTransitDetail.setCreateTime(DateUtils.getNowDate());
        return jaloGoodsTransitDetailMapper.insertJaloGoodsTransitDetail(jaloGoodsTransitDetail);
    }

    /**
     * 修改在途物资详细
     * 
     * @param jaloGoodsTransitDetail 在途物资详细
     * @return 结果
     */
    @Override
    public int updateJaloGoodsTransitDetail(JaloGoodsTransitDetail jaloGoodsTransitDetail)
    {
        jaloGoodsTransitDetail.setUpdateTime(DateUtils.getNowDate());
        return jaloGoodsTransitDetailMapper.updateJaloGoodsTransitDetail(jaloGoodsTransitDetail);
    }

    /**
     * 批量删除在途物资详细
     * 
     * @param ids 需要删除的在途物资详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitDetailByIds(String[] ids)
    {
        return jaloGoodsTransitDetailMapper.deleteJaloGoodsTransitDetailByIds(ids);
    }

    /**
     * 删除在途物资详细信息
     * 
     * @param id 在途物资详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloGoodsTransitDetailById(String id)
    {
        return jaloGoodsTransitDetailMapper.deleteJaloGoodsTransitDetailById(id);
    }

    @Override
    public List<JaloGoodsTransitDetail> selectJaloGoodsTransitDetailListByTransitSumId(String jaloTransitSumId){
        return jaloGoodsTransitDetailMapper.selectJaloGoodsTransitDetailListByTransitSumId(jaloTransitSumId);
    }

    public AjaxResult exportExcel(List<JaloGoodsTransitDetail> list, String sheetName){
        HSSFWorkbook wb = new HSSFWorkbook();
        //2.创建工作簿
        HSSFSheet sheet = wb.createSheet();
        //3.创建标题行
        HSSFRow titlerRow = sheet.createRow(0);
        titlerRow.createCell(0).setCellValue("供应商");
        titlerRow.createCell(1).setCellValue("产品名称");
        titlerRow.createCell(2).setCellValue("采购订单号");
        titlerRow.createCell(3).setCellValue("数量");
        titlerRow.createCell(4).setCellValue("金额");

        int rowNum = 1;
        for(JaloGoodsTransitDetail transitDetail : list){
            Row tempRow = sheet.createRow(rowNum++);

            for(int j=0 ; j<5;j++){
                Cell tempCell = tempRow.createCell(j);
                String tempValue = j+"";

                if(j == 0){
                    tempValue = transitDetail.getProduct();
                }else if( j==1 ){
                    tempValue = transitDetail.getSupport();
                }else if( j==2 ) {
                    tempValue = transitDetail.getPurchaseOrderNumber();
                }else if( j==3 ) {
                    tempValue = transitDetail.getNum() +"";
                }else if( j==4 ) {
                    tempValue = transitDetail.getAmount() +"";
                }

                tempCell.setCellValue(tempValue);
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
