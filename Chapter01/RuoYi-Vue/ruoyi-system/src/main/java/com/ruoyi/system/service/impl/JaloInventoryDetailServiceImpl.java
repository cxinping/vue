package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.JaloGoodsTransitDetail;
import com.ruoyi.system.domain.JaloInventoryDetailSum;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JaloInventoryDetailMapper;
import com.ruoyi.system.domain.JaloInventoryDetail;
import com.ruoyi.system.service.IJaloInventoryDetailService;

/**
 * 库存详细Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class JaloInventoryDetailServiceImpl implements IJaloInventoryDetailService 
{
    private final Logger logger = LoggerFactory.getLogger(JaloInventoryDetailServiceImpl.class);

    @Autowired
    private JaloInventoryDetailMapper jaloInventoryDetailMapper;

    /**
     * 查询库存详细
     * 
     * @param id 库存详细ID
     * @return 库存详细
     */
    @Override
    public JaloInventoryDetail selectJaloInventoryDetailById(String id)
    {
        return jaloInventoryDetailMapper.selectJaloInventoryDetailById(id);
    }

    /**
     * 查询库存详细列表
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 库存详细
     */
    @Override
    public List<JaloInventoryDetail> selectJaloInventoryDetailList(JaloInventoryDetail jaloInventoryDetail)
    {
        return jaloInventoryDetailMapper.selectJaloInventoryDetailList(jaloInventoryDetail);
    }

    public List<JaloInventoryDetail> selectJaloInventoryDetailListByInventorySumId(String jaloInventorySumId){
        return jaloInventoryDetailMapper.selectJaloInventoryDetailListByInventorySumId(jaloInventorySumId);
    }

    /**
     * 新增库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    @Override
    public int insertJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail)
    {
        if(null != jaloInventoryDetail && StringUtils.isBlank(jaloInventoryDetail.getParentid())){
            throw new RuntimeException("输入的数据中 parentId 不能为空");
        }

        jaloInventoryDetail.setCreateTime(DateUtils.getNowDate());
        if(StringUtils.isBlank(jaloInventoryDetail.getNodetype())){
           jaloInventoryDetail.setNodetype("group");
        }

        return jaloInventoryDetailMapper.insertJaloInventoryDetail(jaloInventoryDetail);
    }

    /**
     * 修改库存详细
     * 
     * @param jaloInventoryDetail 库存详细
     * @return 结果
     */
    @Override
    public int updateJaloInventoryDetail(JaloInventoryDetail jaloInventoryDetail)
    {
        jaloInventoryDetail.setUpdateTime(DateUtils.getNowDate());
        return jaloInventoryDetailMapper.updateJaloInventoryDetail(jaloInventoryDetail);
    }

    /**
     * 批量删除库存详细
     * 
     * @param ids 需要删除的库存详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryDetailByIds(String[] ids)
    {
        return jaloInventoryDetailMapper.deleteJaloInventoryDetailByIds(ids);
    }

    public int deleteJaloInventoryDetailByInventorySumId(String jaloInventorySumId){
        return jaloInventoryDetailMapper.deleteJaloInventoryDetailByInventorySumId(jaloInventorySumId);
    }

    /**
     * 删除库存详细信息
     * 
     * @param id 库存详细ID
     * @return 结果
     */
    @Override
    public int deleteJaloInventoryDetailById(String id)
    {
        return jaloInventoryDetailMapper.deleteJaloInventoryDetailById(id);
    }

    @Override
    public List<JaloInventoryDetail> selectJaloInventoryDetailListByParentid(String parentid){
        return jaloInventoryDetailMapper.selectJaloInventoryDetailListByParentid(parentid);
    }

    public JaloInventoryDetail selectJaloInventoryDetailRoot(){
        return jaloInventoryDetailMapper.selectJaloInventoryDetailRoot();
    }

    public JaloInventoryDetail treeJaloInventoryDetailList(JaloInventoryDetail jaloInventoryDetail)
    {
        List<JaloInventoryDetail> inventoryDetails = null;
        JaloInventoryDetail inventoryDetailRoot = jaloInventoryDetailMapper.selectJaloInventoryDetailRoot();
        logger.info("******* inventoryDetailRoot=" + inventoryDetailRoot.toString());

        //List list = jaloInventoryDetailMapper.selectJaloInventoryDetailList(jaloInventoryDetail);

        queryInventoryDetailChild(inventoryDetailRoot);
        return inventoryDetailRoot;
    }

    private void queryInventoryDetailChild(JaloInventoryDetail inventoryDetail ){
        //根节点的id当做所有子节点的父id
        String parentid = inventoryDetail.getId();
        List<JaloInventoryDetail> inventoryDetails = jaloInventoryDetailMapper.selectJaloInventoryDetailListByParentid( parentid);

        if(null == inventoryDetails && inventoryDetails.size() == 0 ){
            return ;
        }else{
            inventoryDetail.setChildren( inventoryDetails );
            for(JaloInventoryDetail inventoryDetailRst  : inventoryDetails){
                logger.info(inventoryDetailRst.toString() );
                queryInventoryDetailChild(inventoryDetailRst);
            }

        }
    }

    public JaloInventoryDetailSum calJaloInventoryDetailSum(String parentid){
        return jaloInventoryDetailMapper.calJaloInventoryDetailSum(parentid);
    }

    public void callInventoryDetailSum(JaloInventoryDetail inventoryDetail ){
        logger.info("******* callInventoryDetailSum ***********  "   );
        String id = inventoryDetail.getId();
        String parentid = inventoryDetail.getParentid();

        if(!id.equals("1") && StringUtils.isBlank(parentid)){
            throw new RuntimeException("输入的数据中 parentid 不能为空");
        }

        try{
            //得到父节点
            JaloInventoryDetail pareInventoryDetail  = selectJaloInventoryDetailById(parentid);
            if(pareInventoryDetail.getId().equals("1")){
                return ;
            }

            // 计算父节点统计的金额和数量
            JaloInventoryDetailSum inventoryDetailSum= calJaloInventoryDetailSum(parentid);
            logger.info(inventoryDetailSum.toString());
            pareInventoryDetail.setInventoryAmount(inventoryDetailSum.getInventorySumAmount());
            pareInventoryDetail.setSaleableInventoryAmount(inventoryDetailSum.getSaleableInventorySumAmount() );
            pareInventoryDetail.setSaleableInventoryNum(inventoryDetailSum.getSaleableInventorySumNum() );
            pareInventoryDetail.setUnsaleableInventoryAmount(inventoryDetailSum.getUnsaleableInventorySumAmount() );
            pareInventoryDetail.setUnsaleableInventoryNum(inventoryDetailSum.getUnsaleableInventorySumNum() );
            pareInventoryDetail.setUpdateTime(new java.util.Date());
            updateJaloInventoryDetail(pareInventoryDetail);

            callInventoryDetailSum(pareInventoryDetail);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static int rowNum = 2;
    private void writeRow(HSSFSheet sheet , JaloInventoryDetail inventoryDetail){
        Row tempRow = sheet.createRow(rowNum++);

        for(int j=0 ; j<6;j++){
            Cell tempCell = tempRow.createCell(j);
            String tempValue = j+"";

            if(j == 0){
                tempValue = inventoryDetail.getProduct();
            }else if( j==1 ){
                tempValue = inventoryDetail.getInventoryAmount() + "";
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

    public AjaxResult exportExcel(List<JaloInventoryDetail> list, String sheetName){
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

        for (JaloInventoryDetail inventoryDetail : list  ) {
            writeRow(sheet, inventoryDetail);


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
