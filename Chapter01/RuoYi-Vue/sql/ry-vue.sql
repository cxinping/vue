/*
Navicat MySQL Data Transfer

Source Server         : aliyun-47.93.212.169
Source Server Version : 50643
Source Host           : 47.93.212.169:3306
Source Database       : ry-vue

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2020-09-16 16:42:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('51', 'ent_uploadfile_expireddetail', '上传文件过期数据表', 'EntUploadfileExpireddetail', 'crud', 'com.ruoyi.system', 'system', 'expireddetail', '上传文件过期数据', 'ruoyi', '0', '/', null, 'admin', '2020-09-09 10:22:52', '', null, null);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=579 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES ('562', '51', 'id', 'id', 'bigint(20)', 'Long', 'id', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('563', '51', 'file_name', '上传文件名称', 'varchar(200)', 'String', 'fileName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '2', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('564', '51', 'file_type', '上传文件类型', 'varchar(100)', 'String', 'fileType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '3', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('565', '51', 'table_name', '上传文件所在的表名', 'varchar(20)', 'String', 'tableName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '4', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('566', '51', 'table_id', '上传文件所在的表id', 'bigint(20)', 'Long', 'tableId', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('567', '51', 'operator', '操作人', 'varchar(100)', 'String', 'operator', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('568', '51', 'file_shotdt', '文件拍摄时间', 'timestamp', 'Date', 'fileShotdt', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'datetime', '', '7', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('569', '51', 'source_distributed_server_ip', '源文件的分布式服务器IP', 'varchar(200)', 'String', 'sourceDistributedServerIp', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '8', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('570', '51', 'source_distributed_server_store_path', '源文件的分布式服务器存储地址', 'varchar(200)', 'String', 'sourceDistributedServerStorePath', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('571', '51', 'thumbnail_distributed_server_ip', '缩略图的分布式服务器IP', 'varchar(200)', 'String', 'thumbnailDistributedServerIp', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '10', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('572', '51', 'thumbnail_distributed_server_store_path', '缩略图的分布式服务器存储地址', 'varchar(200)', 'String', 'thumbnailDistributedServerStorePath', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '11', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('573', '51', 'remark', '描述', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '12', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('574', '51', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '13', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('575', '51', 'create_time', '创建时间', 'timestamp', 'Date', 'createTime', '0', '0', '1', '1', null, null, null, 'EQ', 'datetime', '', '14', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('576', '51', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '15', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('577', '51', 'update_time', '修改时间', 'timestamp', 'Date', 'updateTime', '0', '0', '1', '1', '1', null, null, 'EQ', 'datetime', '', '16', 'admin', '2020-09-09 10:22:52', '', null);
INSERT INTO `gen_table_column` VALUES ('578', '51', 'expire_time', '过期时间', 'timestamp', 'Date', 'expireTime', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'datetime', '', '17', 'admin', '2020-09-09 10:22:52', '', null);

-- ----------------------------
-- Table structure for jalo_amount_statistics
-- ----------------------------
DROP TABLE IF EXISTS `jalo_amount_statistics`;
CREATE TABLE `jalo_amount_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `prepayments` decimal(10,2) DEFAULT '0.00' COMMENT '预付款',
  `in_stock` decimal(10,2) DEFAULT '0.00' COMMENT '库存',
  `shipped_unsettled_amount` decimal(10,2) DEFAULT '0.00' COMMENT '已发货未结算金额',
  `total_available_funds` decimal(10,2) DEFAULT '0.00' COMMENT '可用资金',
  `total_materials_in_transit` decimal(10,2) DEFAULT '0.00' COMMENT '在途物资',
  `orders_number` decimal(10,0) DEFAULT NULL COMMENT '已下单未发货金额合计数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='统计页面';

-- ----------------------------
-- Records of jalo_amount_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for jalo_available_funds
-- ----------------------------
DROP TABLE IF EXISTS `jalo_available_funds`;
CREATE TABLE `jalo_available_funds` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `merchants_bank` decimal(10,2) DEFAULT '0.00' COMMENT '招行',
  `pufa_bank` decimal(10,2) DEFAULT '0.00' COMMENT '浦发',
  `icbc_bank` decimal(10,2) DEFAULT '0.00' COMMENT '工行',
  `you_zan` decimal(10,2) DEFAULT '0.00' COMMENT '有赞',
  `alipay` decimal(10,2) DEFAULT '0.00' COMMENT '支付宝',
  `jingdong` decimal(10,2) DEFAULT '0.00' COMMENT '京东',
  `total_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='可用资金表';

-- ----------------------------
-- Records of jalo_available_funds
-- ----------------------------
INSERT INTO `jalo_available_funds` VALUES ('26', '11200.00', '10000.00', '10000.00', '10000.00', '10000.00', '20000.00', '71200.00', '2020-09-12 16:04:03', '2020-09-12 18:40:19');

-- ----------------------------
-- Table structure for jalo_goods_transit
-- ----------------------------
DROP TABLE IF EXISTS `jalo_goods_transit`;
CREATE TABLE `jalo_goods_transit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `building_materials` decimal(10,2) DEFAULT '0.00' COMMENT '建材',
  `daily_necessities` decimal(10,2) DEFAULT '0.00' COMMENT '日用品',
  `device` decimal(10,2) DEFAULT '0.00' COMMENT '电器',
  `furniture` decimal(10,2) DEFAULT '0.00' COMMENT '家具',
  `kitchen_bathroom` decimal(10,2) DEFAULT '0.00' COMMENT '厨房卫浴',
  `lamps` decimal(10,2) DEFAULT '0.00' COMMENT '灯具',
  `soft_outfit` decimal(10,2) DEFAULT '0.00' COMMENT '软装',
  `textile` decimal(10,2) DEFAULT '0.00' COMMENT '纺织品',
  `other` decimal(10,2) DEFAULT '0.00' COMMENT '其他',
  `total_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='在途物资表';

-- ----------------------------
-- Records of jalo_goods_transit
-- ----------------------------
INSERT INTO `jalo_goods_transit` VALUES ('20', '10000.00', '10000.00', '10000.00', '10000.00', '10000.00', '10000.00', '10000.00', '10000.00', '10000.00', '90000.00', '2020-09-12 16:04:34', '2020-09-12 16:04:34');

-- ----------------------------
-- Table structure for jalo_inventory_detail
-- ----------------------------
DROP TABLE IF EXISTS `jalo_inventory_detail`;
CREATE TABLE `jalo_inventory_detail` (
  `id` varchar(200) NOT NULL COMMENT '编号',
  `product` varchar(255) DEFAULT NULL COMMENT '产品',
  `saleable_inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '可销售库存金额',
  `unsaleable_inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '不可销售库存金额',
  `inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额',
  `order_num` int(11) DEFAULT NULL COMMENT '顺序号',
  `jalo_inventory_sum_id` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存详细表';

-- ----------------------------
-- Records of jalo_inventory_detail
-- ----------------------------
INSERT INTO `jalo_inventory_detail` VALUES ('1fbc5ad4b99b46f999be6fb12d03fb39', '其它', '10000.00', '10000.00', '20000.00', '9', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('46850a69f2aa404f995885226508a52f', '电器', '10000.00', '10000.00', '20000.00', '3', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('5100721d59c74aa2beefd6012eb7d049', '灯具', '10000.00', '10000.00', '20000.00', '6', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('595b4bc7a95143e6a5001d28714ee853', '日用品', '10000.00', '10000.00', '20000.00', '2', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('bb6c226ad6f74fc5848ae013c77765ff', '软装', '10000.00', '10000.00', '20000.00', '7', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('cf21e211329b47359d9f1f5ea4f15c3a', '纺织品', '10000.00', '10000.00', '20000.00', '8', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('e890758769464b228c863de33137f051', '家具', '10000.00', '10000.00', '20000.00', '4', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('eaee2485b4b9478286a31ffe48d2420c', '建材', '11200.00', '10000.00', '21200.00', '1', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');
INSERT INTO `jalo_inventory_detail` VALUES ('f18f5fedfe804daf9852cca0f72ff6ae', '厨房卫浴', '10000.00', '10000.00', '20000.00', '5', '080eadcf88d84b8c8892f995559819ca', '2020-09-12 18:40:00', '2020-09-12 18:40:00');

-- ----------------------------
-- Table structure for jalo_inventory_sum
-- ----------------------------
DROP TABLE IF EXISTS `jalo_inventory_sum`;
CREATE TABLE `jalo_inventory_sum` (
  `id` varchar(200) NOT NULL COMMENT '编号',
  `product` varchar(255) DEFAULT NULL,
  `sum_saleable_inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额汇总',
  `sum_unsaleable_inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '不可销售库存金额汇总',
  `sum_inventory_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额汇总',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存汇总表';

-- ----------------------------
-- Records of jalo_inventory_sum
-- ----------------------------
INSERT INTO `jalo_inventory_sum` VALUES ('080eadcf88d84b8c8892f995559819ca', null, '91200.00', '90000.00', '181200.00', '2020-09-12 18:29:13', '2020-09-12 18:40:00');

-- ----------------------------
-- Table structure for jalo_loan_usage
-- ----------------------------
DROP TABLE IF EXISTS `jalo_loan_usage`;
CREATE TABLE `jalo_loan_usage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_credit_amount` decimal(10,2) DEFAULT '0.00' COMMENT '贷款授信金额',
  `loan_credit_balance` decimal(10,2) DEFAULT '0.00' COMMENT '贷款授信余额',
  `loan_credit_remaining` decimal(10,2) DEFAULT '0.00' COMMENT '剩余可使用额度',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='贷款使用表';

-- ----------------------------
-- Records of jalo_loan_usage
-- ----------------------------
INSERT INTO `jalo_loan_usage` VALUES ('53', '4000000.00', '2800000.00', '1200000.00', '2020-09-03 11:29:12', '2020-09-12 18:11:09');

-- ----------------------------
-- Table structure for jalo_placed_not_shipped
-- ----------------------------
DROP TABLE IF EXISTS `jalo_placed_not_shipped`;
CREATE TABLE `jalo_placed_not_shipped` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `placed_not_shipped` decimal(10,2) DEFAULT '0.00' COMMENT '已下单未发货合计金额数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='已下单未发货表';

-- ----------------------------
-- Records of jalo_placed_not_shipped
-- ----------------------------
INSERT INTO `jalo_placed_not_shipped` VALUES ('9', '1.00', '2020-08-29 13:25:56', '2020-08-29 13:25:56');
INSERT INTO `jalo_placed_not_shipped` VALUES ('10', '1.00', '2020-08-29 19:04:54', '2020-08-29 19:04:54');
INSERT INTO `jalo_placed_not_shipped` VALUES ('11', '0.10', '2020-08-30 13:28:45', '2020-08-30 13:28:45');

-- ----------------------------
-- Table structure for jalo_purchase_order_tracking_information
-- ----------------------------
DROP TABLE IF EXISTS `jalo_purchase_order_tracking_information`;
CREATE TABLE `jalo_purchase_order_tracking_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `contract_signing_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '合同签订时间',
  `contract_end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '合同结束时间',
  `contract_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合同金额',
  `payable_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '应付尾款时间',
  `prepayment_amount_payable` decimal(10,2) DEFAULT '0.00' COMMENT '已付预付款金额',
  `prepayment_amount_paid` decimal(10,2) DEFAULT '0.00' COMMENT '应付尾款金额',
  `prepayment_payable_time` datetime DEFAULT NULL COMMENT '应付预付款时间, 以作废',
  `prepayment_payable_amount` decimal(10,2) DEFAULT '0.00' COMMENT '应付尾款金额, 以作废',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='采购订单跟踪信息表';

-- ----------------------------
-- Records of jalo_purchase_order_tracking_information
-- ----------------------------
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('18', 'PJ家具定金', '杭州容安家具有限公司', '2020-07-31 00:00:00', '2020-09-14 00:00:00', '197835.00', '2020-09-14 00:00:00', '98917.50', '98917.50', null, '0.00', '2020-09-03 13:40:16', '2020-09-03 13:40:16');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('19', '亚麻9000米定布', '青岛宇宙针纺织品有限公司', '2020-07-23 00:00:00', '2020-09-15 00:00:00', '490700.00', '2020-09-15 00:00:00', '245350.00', '245350.00', null, '0.00', '2020-09-03 13:43:03', '2020-09-03 13:43:34');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('20', '180支双股/160支四股 1100根埃及棉5000米', '无锡长江精密纺织有限公司', '2020-07-21 00:00:00', '2020-09-10 00:00:00', '625000.00', '2020-09-30 00:00:00', '180000.00', '445000.00', null, '0.00', '2020-09-03 13:45:30', '2020-09-03 13:45:30');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('21', '7月17日灯订单', '中山市顿耀灯饰有限公司', '2020-07-17 00:00:00', '2020-09-30 00:00:00', '103892.00', '2020-09-30 00:00:00', '62335.20', '41556.80', null, '0.00', '2020-09-03 13:47:40', '2020-09-03 13:51:17');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('22', '6月23日灯订单', '中山市顿耀灯饰有限公司', '2020-06-23 00:00:00', '2020-09-30 00:00:00', '250239.00', '2020-09-30 00:00:00', '151835.11', '98403.89', null, '0.00', '2020-09-03 13:50:46', '2020-09-03 13:50:57');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('23', '水泥花砖', '佛山市怡升建材有限公司', '2020-08-07 00:00:00', '2020-09-30 00:00:00', '50198.40', '2020-09-30 00:00:00', '15060.00', '35138.40', null, '0.00', '2020-09-03 13:52:57', '2020-09-03 13:52:57');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('24', '5000尺意大利皮MK-54', '常熟尤尼卡皮革有限公司', '2020-05-31 00:00:00', '2020-09-30 00:00:00', '128400.00', '2020-09-30 00:00:00', '38520.00', '89880.00', null, '0.00', '2020-09-03 13:58:22', '2020-09-03 13:58:22');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('25', '马尾毛', '安平县双马鬃尾厂', '2020-03-01 00:00:00', '2020-09-30 00:00:00', '39600.00', '2020-09-30 00:00:00', '11880.00', '27720.00', null, '0.00', '2020-09-03 14:30:55', '2020-09-03 14:30:55');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('26', '羊毛与棉混纺层', '清河县天河绒毛制品有限公司', '2020-02-25 00:00:00', '2020-09-30 00:00:00', '56000.00', '2020-09-30 00:00:00', '16800.00', '39200.00', null, '0.00', '2020-09-03 14:38:02', '2020-09-03 14:38:02');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('27', '意大利转角沙发', '深圳市雅帝家具有限公司龙岗分公司', '2020-06-12 00:00:00', '2020-09-30 00:00:00', '264870.00', '2020-09-30 00:00:00', '79461.00', '185409.00', null, '0.00', '2020-09-03 14:39:33', '2020-09-03 14:39:33');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('28', '沙发', '深圳市雅帝家具有限公司龙岗分公司', '2020-06-22 00:00:00', '2020-09-30 00:00:00', '90490.00', '2020-09-30 00:00:00', '27147.00', '63343.00', null, '0.00', '2020-09-03 14:42:17', '2020-09-03 14:42:17');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('29', '押金', '桐乡龙海家具有限公司', '2020-07-03 00:00:00', '2020-09-30 00:00:00', '750000.00', '2020-09-30 00:00:00', '750000.00', '0.00', null, '0.00', '2020-09-03 14:43:46', '2020-09-03 14:43:46');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('30', '2019年12月16日订货这批印度窗帘桌布', '印度', '2020-09-03 00:00:00', '2020-09-03 00:00:00', '459304.74', '2020-09-30 00:00:00', '459304.74', '0.00', null, '0.00', '2020-09-03 14:44:34', '2020-09-03 14:44:34');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('31', '伊朗地毯', '伊朗', '2020-09-03 00:00:00', '2020-09-03 00:00:00', '168353.80', '2020-09-03 00:00:00', '168353.80', '0.00', null, '0.00', '2020-09-03 14:45:09', '2020-09-03 14:45:09');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('32', '玻璃杯', '印度', '2019-09-26 00:00:00', '2020-12-31 00:00:00', '14671.00', '2020-12-31 00:00:00', '14671.00', '0.00', null, '0.00', '2020-09-03 14:48:13', '2020-09-03 14:48:13');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('33', '家具中使用的五金配件类产品定金', '中山市顿耀灯饰有限公司', '2020-05-28 00:00:00', '2020-09-30 00:00:00', '139102.00', '2020-09-30 00:00:00', '139102.00', '0.00', null, '0.00', '2020-09-03 14:50:59', '2020-09-03 14:50:59');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('34', '007单家具', '桐乡龙海家具有限公司', '2020-09-01 00:00:00', '2020-09-30 00:00:00', '650342.00', '2020-09-30 00:00:00', '0.00', '650342.00', null, '0.00', '2020-09-03 14:53:11', '2020-09-03 14:53:11');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('35', '008单家具', '桐乡龙海家具有限公司', '2020-09-03 00:00:00', '2020-09-30 00:00:00', '447081.40', '2020-09-30 00:00:00', '0.00', '447081.40', null, '0.00', '2020-09-03 14:54:25', '2020-09-03 14:54:25');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('36', '009单家具', '桐乡龙海家具有限公司', '2020-09-03 00:00:00', '2020-09-30 00:00:00', '130473.20', '2020-09-30 00:00:00', '0.00', '130473.20', null, '0.00', '2020-09-03 14:57:20', '2020-09-03 14:57:20');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('37', '010单家具', '桐乡龙海家具有限公司', '2020-09-03 00:00:00', '2020-09-30 00:00:00', '55140.00', '2020-09-30 00:00:00', '0.00', '55140.00', null, '0.00', '2020-09-03 14:58:34', '2020-09-03 14:58:34');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('38', '家具011单', '桐乡龙海家具有限公司', '2020-09-03 00:00:00', '2020-09-30 00:00:00', '1179796.50', '2020-09-29 00:00:00', '0.00', '1179796.50', null, '0.00', '2020-09-03 14:59:43', '2020-09-03 14:59:43');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('39', '挂墙柜挂杆', '东莞市擎飞金属有限公司', '2020-05-09 00:00:00', '2020-08-24 00:00:00', '50050.00', '2020-08-24 00:00:00', '50050.00', '0.00', null, '0.00', '2020-09-03 15:01:18', '2020-09-03 15:01:18');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('40', '灯', '中山市古镇帕绱照明厂', '2020-08-20 00:00:00', '2020-09-30 00:00:00', '9180.00', '2020-09-30 00:00:00', '500.00', '8680.00', null, '0.00', '2020-09-03 15:02:24', '2020-09-03 15:02:24');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('41', '大理石马赛克', '云浮市云安区曼哈顿石材有限公司', '2020-08-24 00:00:00', '2020-09-30 00:00:00', '14321.03', '2020-09-30 00:00:00', '4300.00', '10021.03', null, '0.00', '2020-09-03 15:03:29', '2020-09-03 15:03:29');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('42', '缝制', '无锡市康佳乐寝饰用品厂', '2020-08-25 00:00:00', '2020-08-25 00:00:00', '17972.18', '2020-08-25 00:00:00', '17972.18', '0.00', null, '0.00', '2020-09-03 15:04:41', '2020-09-03 15:04:41');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('43', '瓷砖', '上海贝利泰陶瓷有限公司', '2020-08-25 00:00:00', '2020-08-25 00:00:00', '12089.76', '2020-09-30 00:00:00', '12089.76', '0.00', null, '0.00', '2020-09-03 15:06:22', '2020-09-03 15:06:22');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('44', '染色费用', '浙江华帝纺织印染有限公司', '2020-08-24 00:00:00', '2020-08-24 00:00:00', '46434.90', '2020-08-24 00:00:00', '46434.90', '0.00', null, '0.00', '2020-09-03 15:07:31', '2020-09-03 15:07:31');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('45', 'B3 2000个盒子', '东莞市泰阳纸制品有限公司', '2020-08-24 00:00:00', '2020-08-24 00:00:00', '18400.00', '2020-08-24 00:00:00', '18400.00', '0.00', null, '0.00', '2020-09-03 15:10:43', '2020-09-03 15:10:43');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('46', '黄铜五金件中纯铜置物架有450个配套挂钩', '中山市顿耀灯饰有限公司', '2020-08-20 00:00:00', '2020-08-20 00:00:00', '8730.00', '2020-08-20 00:00:00', '8730.00', '0.00', null, '0.00', '2020-09-03 15:12:21', '2020-09-03 15:12:21');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('47', '8月18日灯订单', '中山市顿耀灯饰有限公司', '2020-08-18 00:00:00', '2020-09-28 00:00:00', '61938.00', '2020-09-28 00:00:00', '37162.80', '24775.20', null, '0.00', '2020-09-03 15:45:20', '2020-09-03 15:45:20');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('48', '97件家具', '深圳市雅帝家具有限公司龙岗分公司', '2020-09-02 00:00:00', '2020-10-02 00:00:00', '122118.00', '2020-10-02 00:00:00', '122118.00', '407060.00', null, '0.00', '2020-09-03 15:50:02', '2020-09-03 15:50:28');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('49', 'D036 小红玫瑰 +20个 FD038 小鲁丹鸟+20个 FD041 大海底捞+10个 FD043 大红玫瑰+10个', '时光香氛(深圳)贸易有限公司', '2020-09-01 00:00:00', '2020-09-01 00:00:00', '5750.00', '2020-09-02 00:00:00', '5750.00', '0.00', null, '0.00', '2020-09-03 15:51:49', '2020-09-03 15:51:49');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('50', '王氏木椅补货63件', '东莞市王氏家具有限公司', '2020-09-01 00:00:00', '2020-10-31 00:00:00', '88230.00', '2020-09-30 00:00:00', '26469.00', '61761.00', null, '0.00', '2020-09-03 15:53:16', '2020-09-03 15:53:16');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('51', '水洗', '青岛新润昌服装水洗有限公司', '2020-09-01 00:00:00', '2020-09-01 00:00:00', '11160.00', '2020-09-03 00:00:00', '11160.00', '0.00', null, '0.00', '2020-09-03 15:55:15', '2020-09-03 15:55:15');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('52', '快递费', '青岛安能速达物流管理咨询有限公司', '2020-08-31 00:00:00', '2020-08-31 00:00:00', '1234.00', '2020-08-31 00:00:00', '1234.00', '0.00', null, '0.00', '2020-09-03 15:56:05', '2020-09-03 15:56:05');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('53', '亚麻桌布面料杜邦涂层加工费', '无锡市瑞盛纺织品后整理研发中心', '2020-08-28 00:00:00', '2020-08-28 00:00:00', '19538.00', '2020-08-28 00:00:00', '19538.00', '0.00', null, '0.00', '2020-09-03 15:58:40', '2020-09-03 15:58:40');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('54', '瓷砖', '佛山市居壁建材有限公司', '2020-08-28 00:00:00', '2020-09-30 00:00:00', '15084.00', '2020-09-30 00:00:00', '4525.00', '10559.00', null, '0.00', '2020-09-03 16:00:46', '2020-09-03 16:00:46');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('55', '灯', '中山市顿耀灯饰有限公司', '2020-09-07 00:00:00', '2020-10-31 00:00:00', '142642.50', '2020-09-07 00:00:00', '0.00', '85585.50', null, '0.00', '2020-09-03 16:01:44', '2020-09-03 16:01:44');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('56', '波兰椅子', '波兰', '2020-09-03 00:00:00', '2020-11-30 00:00:00', '896999.95', '2020-11-30 00:00:00', '0.00', '269106.29', null, '0.00', '2020-09-03 16:03:08', '2020-09-07 14:03:43');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('65', '005单', '桐乡龙海家具有限公司', '2020-09-14 00:00:00', '2020-09-14 00:00:00', '424919.10', '2020-09-16 16:33:53', '424919.10', '0.00', null, '0.00', '2020-09-16 16:33:42', '2020-09-16 16:33:53');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('66', '水晶灯', '中山市顿耀灯饰有限公司', '2020-09-16 00:00:00', '2020-11-30 00:00:00', '98070.00', null, '0.00', '98070.00', null, '0.00', '2020-09-16 16:36:05', '2020-09-16 16:36:05');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('67', '橘灯、柚木灯', '中山市顿耀灯饰有限公司', '2020-09-16 00:00:00', '2020-12-31 00:00:00', '317448.00', '2020-11-30 00:00:00', '0.00', '317448.00', null, '0.00', '2020-09-16 16:37:21', '2020-09-16 16:37:21');
INSERT INTO `jalo_purchase_order_tracking_information` VALUES ('68', null, '无锡长江精密纺织有限公司', '2020-09-10 00:00:00', '2020-10-31 00:00:00', '225000.00', '2020-09-16 00:00:00', '0.00', '225000.00', null, '0.00', '2020-09-16 16:41:32', '2020-09-16 16:41:32');

-- ----------------------------
-- Table structure for jalo_purchased_unshipped
-- ----------------------------
DROP TABLE IF EXISTS `jalo_purchased_unshipped`;
CREATE TABLE `jalo_purchased_unshipped` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `youzan` decimal(10,2) DEFAULT '0.00' COMMENT '有赞',
  `taobao` decimal(10,2) DEFAULT '0.00' COMMENT '淘宝',
  `tianmao` decimal(10,2) DEFAULT '0.00' COMMENT '天猫',
  `jingdong` decimal(10,2) DEFAULT '0.00' COMMENT '京东',
  `total_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='已下单未发货';

-- ----------------------------
-- Records of jalo_purchased_unshipped
-- ----------------------------
INSERT INTO `jalo_purchased_unshipped` VALUES ('35', '11200.00', '10000.00', '10000.00', '10000.00', '41200.00', '2020-09-12 16:35:25', '2020-09-12 18:40:37');

-- ----------------------------
-- Table structure for jalo_shipped_unsettled
-- ----------------------------
DROP TABLE IF EXISTS `jalo_shipped_unsettled`;
CREATE TABLE `jalo_shipped_unsettled` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `youzan` decimal(10,2) DEFAULT '0.00' COMMENT '有赞',
  `taobao` decimal(10,2) DEFAULT '0.00' COMMENT '淘宝',
  `tianmao` decimal(10,2) DEFAULT '0.00' COMMENT '天猫',
  `jingdong` decimal(10,2) DEFAULT '0.00' COMMENT '京东',
  `total_amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='已发货未结算';

-- ----------------------------
-- Records of jalo_shipped_unsettled
-- ----------------------------
INSERT INTO `jalo_shipped_unsettled` VALUES ('26', '11200.00', '10000.00', '10000.00', '10000.00', '41200.00', '2020-09-12 16:51:37', '2020-09-12 18:40:46');

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_CALENDARS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_FIRED_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('RuoyiScheduler', 'iZ2zegf8231x53bkh9kxdeZ1599903053866', '1600245764970', '15000');

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SIMPLE_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SIMPROP_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `QRTZ_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `sys_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深色主题theme-dark，浅色主题theme-light');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-08-18 14:37:43');
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('200', '100', '0,100', '北京总公司', '3', null, null, null, '0', '0', 'admin', '2020-08-18 14:37:34', 'admin', '2020-08-18 14:37:43');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `sys_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `sys_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `sys_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `sys_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `sys_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `sys_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `sys_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `sys_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `sys_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES ('1', 'gao', '117.136.0.169', 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '登录成功', '2020-09-14 08:32:54');
INSERT INTO `sys_logininfor` VALUES ('2', 'gao', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '登录成功', '2020-09-14 16:26:41');
INSERT INTO `sys_logininfor` VALUES ('3', 'gao', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '退出成功', '2020-09-14 16:49:53');
INSERT INTO `sys_logininfor` VALUES ('4', 'leader', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '登录成功', '2020-09-14 16:50:06');
INSERT INTO `sys_logininfor` VALUES ('5', 'gao', '223.104.3.185', 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '登录成功', '2020-09-15 07:55:17');
INSERT INTO `sys_logininfor` VALUES ('6', 'gao', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '登录成功', '2020-09-15 11:45:05');
INSERT INTO `sys_logininfor` VALUES ('7', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:17:08');
INSERT INTO `sys_logininfor` VALUES ('8', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 13:23:09');
INSERT INTO `sys_logininfor` VALUES ('9', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:23:14');
INSERT INTO `sys_logininfor` VALUES ('10', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 13:23:40');
INSERT INTO `sys_logininfor` VALUES ('11', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-09-15 13:23:43');
INSERT INTO `sys_logininfor` VALUES ('12', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:23:48');
INSERT INTO `sys_logininfor` VALUES ('13', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:31:39');
INSERT INTO `sys_logininfor` VALUES ('14', 'admin', '223.72.91.84', 'XX XX', 'Firefox 8', 'Windows 10', '0', '登录成功', '2020-09-15 13:42:40');
INSERT INTO `sys_logininfor` VALUES ('15', 'admin', '223.72.91.84, 211.103.82.170', '内网IP', 'Chrome Mobile', 'Android 1.x', '1', '验证码错误', '2020-09-15 13:43:11');
INSERT INTO `sys_logininfor` VALUES ('16', 'admin', '223.72.91.84, 211.103.82.170', '内网IP', 'Chrome Mobile', 'Android 1.x', '0', '登录成功', '2020-09-15 13:43:15');
INSERT INTO `sys_logininfor` VALUES ('17', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 13:44:03');
INSERT INTO `sys_logininfor` VALUES ('18', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:44:17');
INSERT INTO `sys_logininfor` VALUES ('19', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:53:40');
INSERT INTO `sys_logininfor` VALUES ('20', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 13:54:47');
INSERT INTO `sys_logininfor` VALUES ('21', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 13:54:50');
INSERT INTO `sys_logininfor` VALUES ('22', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 14:06:39');
INSERT INTO `sys_logininfor` VALUES ('23', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 14:38:27');
INSERT INTO `sys_logininfor` VALUES ('24', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 20:56:46');
INSERT INTO `sys_logininfor` VALUES ('25', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 21:00:03');
INSERT INTO `sys_logininfor` VALUES ('26', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 21:07:16');
INSERT INTO `sys_logininfor` VALUES ('27', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码已失效', '2020-09-15 21:09:25');
INSERT INTO `sys_logininfor` VALUES ('28', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 21:09:33');
INSERT INTO `sys_logininfor` VALUES ('29', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-15 21:10:40');
INSERT INTO `sys_logininfor` VALUES ('30', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-09-15 21:10:50');
INSERT INTO `sys_logininfor` VALUES ('31', 'gao', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '登录成功', '2020-09-16 14:02:50');
INSERT INTO `sys_logininfor` VALUES ('32', 'gao', '223.104.3.197', 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '验证码错误', '2020-09-16 14:04:04');
INSERT INTO `sys_logininfor` VALUES ('33', 'gao', '223.104.3.197', 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '登录成功', '2020-09-16 14:04:11');
INSERT INTO `sys_logininfor` VALUES ('34', 'Gao', '124.205.3.174', 'XX XX', 'Chrome Mobile', 'Android 1.x', '0', '登录成功', '2020-09-16 14:08:29');
INSERT INTO `sys_logininfor` VALUES ('35', 'gao', '61.148.244.94', 'XX XX', 'Chrome Mobile', 'Android 1.x', '0', '登录成功', '2020-09-16 14:10:22');
INSERT INTO `sys_logininfor` VALUES ('37', 'admin', '146.196.54.243', 'XX XX', 'Chrome', 'Windows 10', '0', '退出成功', '2020-09-16 15:35:46');
INSERT INTO `sys_logininfor` VALUES ('38', 'gao', '111.193.199.30', 'XX XX', 'Chrome', 'Windows 7', '0', '登录成功', '2020-09-16 16:28:31');
INSERT INTO `sys_logininfor` VALUES ('39', 'admin', '223.72.91.84', 'XX XX', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2020-09-16 16:41:07');
INSERT INTO `sys_logininfor` VALUES ('40', 'admin', '223.72.91.84', 'XX XX', 'Firefox 8', 'Windows 10', '0', '登录成功', '2020-09-16 16:41:11');
INSERT INTO `sys_logininfor` VALUES ('41', 'admin', '223.72.91.84', 'XX XX', 'Firefox 8', 'Windows 10', '0', '退出成功', '2020-09-16 16:42:02');
INSERT INTO `sys_logininfor` VALUES ('42', 'admin', '223.72.91.84', 'XX XX', 'Firefox 8', 'Windows 10', '0', '登录成功', '2020-09-16 16:42:13');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2091 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '1', 'M', '0', '0', '', 'system', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', 'monitor', null, '1', 'M', '0', '0', '', 'monitor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', 'tool', null, '1', 'M', '0', '0', '', 'tool', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '1', 'C', '0', '0', 'system:user:list', 'user', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '1', 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '1', 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '1', 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '1', 'C', '0', '0', 'system:post:list', 'post', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '1', 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '1', 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '1', 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', 'log', 'system/log/index', '1', 'M', '0', '0', '', 'log', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '1', 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '1', 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '1', 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '1', 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('113', '表单构建', '3', '1', 'build', 'tool/build/index', '1', 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('114', '代码生成', '3', '2', 'gen', 'tool/gen/index', '1', 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('115', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '1', 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '1', 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '1', 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '1', 'F', '0', '0', 'system:user:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '1', 'F', '0', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '1', 'F', '0', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '1', 'F', '0', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '1', 'F', '0', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '1', 'F', '0', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '1', 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '1', 'F', '0', '0', 'system:role:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '1', 'F', '0', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '1', 'F', '0', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '1', 'F', '0', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '1', 'F', '0', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '1', 'F', '0', '0', 'system:menu:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '1', 'F', '0', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '1', 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '1', 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1017', '部门查询', '103', '1', '', '', '1', 'F', '0', '0', 'system:dept:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1018', '部门新增', '103', '2', '', '', '1', 'F', '0', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1019', '部门修改', '103', '3', '', '', '1', 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1020', '部门删除', '103', '4', '', '', '1', 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位查询', '104', '1', '', '', '1', 'F', '0', '0', 'system:post:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位新增', '104', '2', '', '', '1', 'F', '0', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位修改', '104', '3', '', '', '1', 'F', '0', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位删除', '104', '4', '', '', '1', 'F', '0', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '岗位导出', '104', '5', '', '', '1', 'F', '0', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典查询', '105', '1', '#', '', '1', 'F', '0', '0', 'system:dict:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典新增', '105', '2', '#', '', '1', 'F', '0', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典修改', '105', '3', '#', '', '1', 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '字典删除', '105', '4', '#', '', '1', 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '字典导出', '105', '5', '#', '', '1', 'F', '0', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数查询', '106', '1', '#', '', '1', 'F', '0', '0', 'system:config:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数新增', '106', '2', '#', '', '1', 'F', '0', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数修改', '106', '3', '#', '', '1', 'F', '0', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '参数删除', '106', '4', '#', '', '1', 'F', '0', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1035', '参数导出', '106', '5', '#', '', '1', 'F', '0', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1036', '公告查询', '107', '1', '#', '', '1', 'F', '0', '0', 'system:notice:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1037', '公告新增', '107', '2', '#', '', '1', 'F', '0', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1038', '公告修改', '107', '3', '#', '', '1', 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1039', '公告删除', '107', '4', '#', '', '1', 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1040', '操作查询', '500', '1', '#', '', '1', 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1041', '操作删除', '500', '2', '#', '', '1', 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', '1', 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', '1', 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', '1', 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', '1', 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1046', '在线查询', '109', '1', '#', '', '1', 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1047', '批量强退', '109', '2', '#', '', '1', 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1048', '单条强退', '109', '3', '#', '', '1', 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1049', '任务查询', '110', '1', '#', '', '1', 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1050', '任务新增', '110', '2', '#', '', '1', 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1051', '任务修改', '110', '3', '#', '', '1', 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1052', '任务删除', '110', '4', '#', '', '1', 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1053', '状态修改', '110', '5', '#', '', '1', 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1054', '任务导出', '110', '7', '#', '', '1', 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1055', '生成查询', '114', '1', '#', '', '1', 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1056', '生成修改', '114', '2', '#', '', '1', 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1057', '生成删除', '114', '3', '#', '', '1', 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1058', '导入代码', '114', '2', '#', '', '1', 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1059', '预览代码', '114', '4', '#', '', '1', 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1060', '生成代码', '114', '5', '#', '', '1', 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('2000', '财务共享中心', '0', '5', '/amount', null, '1', 'M', '0', '0', '', 'build', 'admin', '2020-08-17 16:28:50', 'admin', '2020-09-15 13:23:05', '');
INSERT INTO `sys_menu` VALUES ('2007', '可用资金表', '2000', '5', 'funds', 'amount/funds/index', '1', 'C', '0', '0', 'amount:funds:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 13:24:05', '可用资金菜单');
INSERT INTO `sys_menu` VALUES ('2008', '可用资金查询', '2007', '1', '#', '', '1', 'F', '0', '0', 'amount:funds:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-17 22:20:09', '');
INSERT INTO `sys_menu` VALUES ('2009', '可用资金新增', '2007', '2', '#', '', '1', 'F', '0', '0', 'amount:funds:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-17 22:20:15', '');
INSERT INTO `sys_menu` VALUES ('2010', '可用资金修改', '2007', '3', '#', '', '1', 'F', '0', '0', 'amount:funds:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-17 22:20:21', '');
INSERT INTO `sys_menu` VALUES ('2011', '可用资金删除', '2007', '4', '#', '', '1', 'F', '0', '0', 'amount:funds:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-17 22:20:27', '');
INSERT INTO `sys_menu` VALUES ('2012', '可用资金导出', '2007', '5', '#', '', '1', 'F', '0', '0', 'amount:funds:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-17 22:20:33', '');
INSERT INTO `sys_menu` VALUES ('2013', '采购订单跟踪信息', '2000', '1', 'information', 'amount/information/index', '1', 'C', '0', '0', 'amount:information:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:22:31', '采购订单跟踪信息菜单');
INSERT INTO `sys_menu` VALUES ('2014', '采购订单跟踪信息查询', '2013', '1', '#', '', '1', 'F', '0', '0', 'amount:information:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:14:30', '');
INSERT INTO `sys_menu` VALUES ('2015', '采购订单跟踪信息新增', '2013', '2', '#', '', '1', 'F', '0', '0', 'amount:information:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:14:41', '');
INSERT INTO `sys_menu` VALUES ('2016', '采购订单跟踪信息修改', '2013', '3', '#', '', '1', 'F', '0', '0', 'amount:information:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:14:52', '');
INSERT INTO `sys_menu` VALUES ('2017', '采购订单跟踪信息删除', '2013', '4', '#', '', '1', 'F', '0', '0', 'amount:information:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:15:04', '');
INSERT INTO `sys_menu` VALUES ('2018', '采购订单跟踪信息导出', '2013', '5', '#', '', '1', 'F', '0', '0', 'amount:information:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 00:15:20', '');
INSERT INTO `sys_menu` VALUES ('2037', '已发货未结算', '2000', '3', 'unsettled', 'amount/unsettled/index', '1', 'C', '0', '0', 'amount:unsettled:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:34:38', '已发货未结算金额菜单');
INSERT INTO `sys_menu` VALUES ('2038', '已发货未结算金额查询', '2037', '1', '#', '', '1', 'F', '0', '0', 'amount:unsettled:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 21:44:07', '');
INSERT INTO `sys_menu` VALUES ('2039', '已发货未结算金额新增', '2037', '2', '#', '', '1', 'F', '0', '0', 'amount:unsettled:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 21:44:13', '');
INSERT INTO `sys_menu` VALUES ('2040', '已发货未结算金额修改', '2037', '3', '#', '', '1', 'F', '0', '0', 'amount:unsettled:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 21:44:20', '');
INSERT INTO `sys_menu` VALUES ('2041', '已发货未结算金额删除', '2037', '4', '#', '', '1', 'F', '0', '0', 'amount:unsettled:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 21:44:27', '');
INSERT INTO `sys_menu` VALUES ('2042', '已发货未结算金额导出', '2037', '5', '#', '', '1', 'F', '0', '0', 'amount:unsettled:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-18 21:44:34', '');
INSERT INTO `sys_menu` VALUES ('2043', '在途物资', '2000', '7', 'transit', 'amount/transit/index', '1', 'C', '0', '0', 'amount:transit:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:35:12', '在途物资菜单');
INSERT INTO `sys_menu` VALUES ('2044', '在途物资查询', '2043', '1', '#', '', '1', 'F', '0', '0', 'amount:transit:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-19 17:28:07', '');
INSERT INTO `sys_menu` VALUES ('2045', '在途物资新增', '2043', '2', '#', '', '1', 'F', '0', '0', 'amount:transit:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-19 17:28:12', '');
INSERT INTO `sys_menu` VALUES ('2046', '在途物资修改', '2043', '3', '#', '', '1', 'F', '0', '0', 'amount:transit:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-19 17:28:17', '');
INSERT INTO `sys_menu` VALUES ('2047', '在途物资删除', '2043', '4', '#', '', '1', 'F', '0', '0', 'amount:transit:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-19 17:28:22', '');
INSERT INTO `sys_menu` VALUES ('2048', '在途物资导出', '2043', '5', '#', '', '1', 'F', '0', '0', 'amount:transit:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-19 17:28:28', '');
INSERT INTO `sys_menu` VALUES ('2061', '财务数据汇总', '2000', '8', 'view', 'amount/view/index', '1', 'C', '0', '0', 'amount:view:list', 'build', 'admin', '2018-03-01 00:00:00', 'admin', '2020-09-15 13:23:32', 'VIEW菜单');
INSERT INTO `sys_menu` VALUES ('2062', '统计页面查询', '2061', '1', '#', '', '1', 'F', '0', '0', 'amount:view:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-20 19:53:27', '');
INSERT INTO `sys_menu` VALUES ('2063', '统计页面新增', '2061', '2', '#', '', '1', 'F', '0', '0', 'amount:view:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-20 19:53:38', '');
INSERT INTO `sys_menu` VALUES ('2064', '统计页面修改', '2061', '3', '#', '', '1', 'F', '0', '0', 'amount:view:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-20 19:53:55', '');
INSERT INTO `sys_menu` VALUES ('2065', '统计页面删除', '2061', '4', '#', '', '1', 'F', '0', '0', 'amount:view:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-20 19:53:46', '');
INSERT INTO `sys_menu` VALUES ('2066', '统计页面导出', '2061', '5', '#', '', '1', 'F', '0', '0', 'amount:view:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-20 19:54:04', '');
INSERT INTO `sys_menu` VALUES ('2067', '库存', '2000', '6', 'sum', 'amount/sum/index', '1', 'C', '0', '0', 'amount:sum:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 13:23:43', '库存汇总菜单');
INSERT INTO `sys_menu` VALUES ('2068', '库存汇总查询', '2067', '1', '#', '', '1', 'F', '0', '0', 'amount:sum:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 14:09:58', '');
INSERT INTO `sys_menu` VALUES ('2069', '库存汇总新增', '2067', '2', '#', '', '1', 'F', '0', '0', 'amount:sum:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 14:10:18', '');
INSERT INTO `sys_menu` VALUES ('2070', '库存汇总修改', '2067', '3', '#', '', '1', 'F', '0', '0', 'amount:sum:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 14:10:12', '');
INSERT INTO `sys_menu` VALUES ('2071', '库存汇总删除', '2067', '4', '#', '', '1', 'F', '0', '0', 'amount:sum:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 14:10:22', '');
INSERT INTO `sys_menu` VALUES ('2072', '库存汇总导出', '2067', '5', '#', '', '1', 'F', '0', '0', 'amount:sum:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 14:10:28', '');
INSERT INTO `sys_menu` VALUES ('2073', '贷款使用表', '2000', '4', 'usage', 'amount/usage/index', '1', 'C', '0', '0', 'amount:usage:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 13:14:44', '贷款使用菜单');
INSERT INTO `sys_menu` VALUES ('2074', '贷款使用查询', '2073', '1', '#', '', '1', 'F', '0', '0', 'amount:usage:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 16:52:42', '');
INSERT INTO `sys_menu` VALUES ('2075', '贷款使用新增', '2073', '2', '#', '', '1', 'F', '0', '0', 'amount:usage:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 16:52:48', '');
INSERT INTO `sys_menu` VALUES ('2076', '贷款使用修改', '2073', '3', '#', '', '1', 'F', '0', '0', 'amount:usage:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 16:52:57', '');
INSERT INTO `sys_menu` VALUES ('2077', '贷款使用删除', '2073', '4', '#', '', '1', 'F', '0', '0', 'amount:usage:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 16:53:46', '');
INSERT INTO `sys_menu` VALUES ('2078', '贷款使用导出', '2073', '5', '#', '', '1', 'F', '0', '0', 'amount:usage:exportamount', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-29 16:54:01', '');
INSERT INTO `sys_menu` VALUES ('2085', '已下单未发货', '2000', '2', 'unshipped', 'amount/unshipped/index', '1', 'C', '0', '0', 'amount:unshipped:list', 'dict', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 16:39:03', '已购买未发货菜单');
INSERT INTO `sys_menu` VALUES ('2086', '已购买未发货查询', '2085', '1', '#', '', '1', 'F', '0', '0', 'amount:unshipped:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:38:33', '');
INSERT INTO `sys_menu` VALUES ('2087', '已购买未发货新增', '2085', '2', '#', '', '1', 'F', '0', '0', 'amount:unshipped:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:38:39', '');
INSERT INTO `sys_menu` VALUES ('2088', '已购买未发货修改', '2085', '3', '#', '', '1', 'F', '0', '0', 'amount:unshipped:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:38:44', '');
INSERT INTO `sys_menu` VALUES ('2089', '已购买未发货删除', '2085', '4', '#', '', '1', 'F', '0', '0', 'amount:unshipped:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:38:49', '');
INSERT INTO `sys_menu` VALUES ('2090', '已购买未发货导出', '2085', '5', '#', '', '1', 'F', '0', '0', 'amount:unshipped:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-08-30 12:39:42', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('1', '操作日志', '9', 'com.ruoyi.web.controller.monitor.SysOperlogController.clean()', 'DELETE', '1', 'admin', null, '/monitor/operlog/clean', '223.72.91.84', 'XX XX', '{}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-13 22:00:39');
INSERT INTO `sys_oper_log` VALUES ('2', '登陆日志', '9', 'com.ruoyi.web.controller.monitor.SysLogininforController.clean()', 'DELETE', '1', 'admin', null, '/monitor/logininfor/clean', '223.72.91.84', 'XX XX', '{}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-13 22:00:42');
INSERT INTO `sys_oper_log` VALUES ('3', '采购订单跟踪信息', '5', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.export()', 'GET', '1', 'gao', null, '/amount/information/export', '111.193.199.30', 'XX XX', '{}', '{\"msg\":\"23b59c04-b7fb-43d8-a6f6-48fe269c905e_information.xlsx\",\"code\":200}', '0', null, '2020-09-15 11:45:47');
INSERT INTO `sys_oper_log` VALUES ('4', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"build\",\"orderNum\":\"5\",\"menuName\":\"财务共享中心\",\"params\":{},\"parentId\":0,\"path\":\"/amount\",\"children\":[],\"createTime\":1597652930000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-15 13:23:05');
INSERT INTO `sys_oper_log` VALUES ('5', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"build\",\"orderNum\":\"8\",\"menuName\":\"财务数据汇总\",\"params\":{},\"parentId\":2000,\"path\":\"view\",\"component\":\"amount/view/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2061,\"menuType\":\"C\",\"perms\":\"amount:view:list\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-15 13:23:32');
INSERT INTO `sys_oper_log` VALUES ('8', '采购订单跟踪信息', '3', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.remove()', 'DELETE', '1', 'gao', null, '/amount/information/64', '111.193.199.30', 'XX XX', '{ids=64}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:28:54');
INSERT INTO `sys_oper_log` VALUES ('9', '采购订单跟踪信息', '1', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.add()', 'POST', '1', 'gao', null, '/amount/information', '111.193.199.30', 'XX XX', '{\"contractSigningTime\":1600012800000,\"updateTime\":1600245222252,\"params\":{},\"contractEndTime\":1600012800000,\"createTime\":1600245222252,\"prepaymentAmountPayable\":424919.10,\"supplier\":\"桐乡龙海家具有限公司\",\"prepaymentAmountPaid\":0,\"contractAmount\":424919.10,\"id\":65}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:33:42');
INSERT INTO `sys_oper_log` VALUES ('10', '采购订单跟踪信息', '2', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.edit()', 'PUT', '1', 'gao', null, '/amount/information', '111.193.199.30', 'XX XX', '{\"contractSigningTime\":1600012800000,\"updateTime\":1600245233053,\"params\":{},\"contractEndTime\":1600012800000,\"prepaymentPayableAmount\":0,\"createTime\":1600245222000,\"prepaymentAmountPayable\":424919.1,\"supplier\":\"桐乡龙海家具有限公司\",\"prepaymentAmountPaid\":0,\"contractAmount\":424919.1,\"id\":65,\"projectName\":\"005单\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:33:53');
INSERT INTO `sys_oper_log` VALUES ('11', '采购订单跟踪信息', '1', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.add()', 'POST', '1', 'gao', null, '/amount/information', '111.193.199.30', 'XX XX', '{\"contractSigningTime\":1600185600000,\"updateTime\":1600245365059,\"params\":{},\"contractEndTime\":1606665600000,\"createTime\":1600245365059,\"prepaymentAmountPayable\":0,\"supplier\":\"中山市顿耀灯饰有限公司\",\"prepaymentAmountPaid\":98070,\"contractAmount\":98070,\"id\":66,\"projectName\":\"水晶灯\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:36:05');
INSERT INTO `sys_oper_log` VALUES ('12', '采购订单跟踪信息', '1', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.add()', 'POST', '1', 'gao', null, '/amount/information', '111.193.199.30', 'XX XX', '{\"contractSigningTime\":1600185600000,\"updateTime\":1600245441050,\"params\":{},\"contractEndTime\":1609344000000,\"createTime\":1600245441050,\"prepaymentAmountPayable\":0,\"supplier\":\"中山市顿耀灯饰有限公司\",\"prepaymentAmountPaid\":317448,\"contractAmount\":317448,\"id\":67,\"projectName\":\"橘灯、柚木灯\",\"payableTime\":1606665600000}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:37:21');
INSERT INTO `sys_oper_log` VALUES ('13', '采购订单跟踪信息', '1', 'com.ruoyi.web.controller.jalohome.JaloPurchaseOrderTrackingInformationController.add()', 'POST', '1', 'gao', null, '/amount/information', '111.193.199.30', 'XX XX', '{\"contractSigningTime\":1599667200000,\"updateTime\":1600245691804,\"params\":{},\"contractEndTime\":1604073600000,\"createTime\":1600245691804,\"prepaymentAmountPayable\":0,\"supplier\":\"无锡长江精密纺织有限公司\",\"prepaymentAmountPaid\":225000,\"contractAmount\":225000,\"id\":68,\"payableTime\":1600185600000}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2020-09-16 16:41:31');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '普通角色');
INSERT INTO `sys_role` VALUES ('100', '伽罗领导', 'leader', '3', '1', '0', '0', 'admin', '2020-08-18 14:34:59', 'admin', '2020-08-30 18:52:00', null);
INSERT INTO `sys_role` VALUES ('101', '伽罗员工', 'staff', '4', '1', '0', '0', 'admin', '2020-08-18 14:35:55', 'admin', '2020-08-30 18:52:08', null);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '115');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1001');
INSERT INTO `sys_role_menu` VALUES ('2', '1002');
INSERT INTO `sys_role_menu` VALUES ('2', '1003');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1005');
INSERT INTO `sys_role_menu` VALUES ('2', '1006');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1008');
INSERT INTO `sys_role_menu` VALUES ('2', '1009');
INSERT INTO `sys_role_menu` VALUES ('2', '1010');
INSERT INTO `sys_role_menu` VALUES ('2', '1011');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1017');
INSERT INTO `sys_role_menu` VALUES ('2', '1018');
INSERT INTO `sys_role_menu` VALUES ('2', '1019');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1021');
INSERT INTO `sys_role_menu` VALUES ('2', '1022');
INSERT INTO `sys_role_menu` VALUES ('2', '1023');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1026');
INSERT INTO `sys_role_menu` VALUES ('2', '1027');
INSERT INTO `sys_role_menu` VALUES ('2', '1028');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1031');
INSERT INTO `sys_role_menu` VALUES ('2', '1032');
INSERT INTO `sys_role_menu` VALUES ('2', '1033');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1051');
INSERT INTO `sys_role_menu` VALUES ('2', '1052');
INSERT INTO `sys_role_menu` VALUES ('2', '1053');
INSERT INTO `sys_role_menu` VALUES ('2', '1054');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');
INSERT INTO `sys_role_menu` VALUES ('2', '1056');
INSERT INTO `sys_role_menu` VALUES ('2', '1057');
INSERT INTO `sys_role_menu` VALUES ('2', '1058');
INSERT INTO `sys_role_menu` VALUES ('2', '1059');
INSERT INTO `sys_role_menu` VALUES ('2', '1060');
INSERT INTO `sys_role_menu` VALUES ('100', '2000');
INSERT INTO `sys_role_menu` VALUES ('100', '2061');
INSERT INTO `sys_role_menu` VALUES ('100', '2062');
INSERT INTO `sys_role_menu` VALUES ('101', '2000');
INSERT INTO `sys_role_menu` VALUES ('101', '2007');
INSERT INTO `sys_role_menu` VALUES ('101', '2008');
INSERT INTO `sys_role_menu` VALUES ('101', '2009');
INSERT INTO `sys_role_menu` VALUES ('101', '2010');
INSERT INTO `sys_role_menu` VALUES ('101', '2011');
INSERT INTO `sys_role_menu` VALUES ('101', '2012');
INSERT INTO `sys_role_menu` VALUES ('101', '2013');
INSERT INTO `sys_role_menu` VALUES ('101', '2014');
INSERT INTO `sys_role_menu` VALUES ('101', '2015');
INSERT INTO `sys_role_menu` VALUES ('101', '2016');
INSERT INTO `sys_role_menu` VALUES ('101', '2017');
INSERT INTO `sys_role_menu` VALUES ('101', '2018');
INSERT INTO `sys_role_menu` VALUES ('101', '2037');
INSERT INTO `sys_role_menu` VALUES ('101', '2038');
INSERT INTO `sys_role_menu` VALUES ('101', '2039');
INSERT INTO `sys_role_menu` VALUES ('101', '2040');
INSERT INTO `sys_role_menu` VALUES ('101', '2041');
INSERT INTO `sys_role_menu` VALUES ('101', '2042');
INSERT INTO `sys_role_menu` VALUES ('101', '2043');
INSERT INTO `sys_role_menu` VALUES ('101', '2044');
INSERT INTO `sys_role_menu` VALUES ('101', '2045');
INSERT INTO `sys_role_menu` VALUES ('101', '2046');
INSERT INTO `sys_role_menu` VALUES ('101', '2047');
INSERT INTO `sys_role_menu` VALUES ('101', '2048');
INSERT INTO `sys_role_menu` VALUES ('101', '2061');
INSERT INTO `sys_role_menu` VALUES ('101', '2062');
INSERT INTO `sys_role_menu` VALUES ('101', '2063');
INSERT INTO `sys_role_menu` VALUES ('101', '2064');
INSERT INTO `sys_role_menu` VALUES ('101', '2065');
INSERT INTO `sys_role_menu` VALUES ('101', '2066');
INSERT INTO `sys_role_menu` VALUES ('101', '2067');
INSERT INTO `sys_role_menu` VALUES ('101', '2068');
INSERT INTO `sys_role_menu` VALUES ('101', '2069');
INSERT INTO `sys_role_menu` VALUES ('101', '2070');
INSERT INTO `sys_role_menu` VALUES ('101', '2071');
INSERT INTO `sys_role_menu` VALUES ('101', '2072');
INSERT INTO `sys_role_menu` VALUES ('101', '2073');
INSERT INTO `sys_role_menu` VALUES ('101', '2074');
INSERT INTO `sys_role_menu` VALUES ('101', '2075');
INSERT INTO `sys_role_menu` VALUES ('101', '2076');
INSERT INTO `sys_role_menu` VALUES ('101', '2077');
INSERT INTO `sys_role_menu` VALUES ('101', '2078');
INSERT INTO `sys_role_menu` VALUES ('101', '2085');
INSERT INTO `sys_role_menu` VALUES ('101', '2086');
INSERT INTO `sys_role_menu` VALUES ('101', '2087');
INSERT INTO `sys_role_menu` VALUES ('101', '2088');
INSERT INTO `sys_role_menu` VALUES ('101', '2089');
INSERT INTO `sys_role_menu` VALUES ('101', '2090');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员');
INSERT INTO `sys_user` VALUES ('100', '200', 'gao', 'staff', '00', 'xpws2006@163.com', '13412311231', '1', '', '$2a$10$l4LE6FYfkoD1KupaiKYXX.KTr.RfxwjW9K.ts/w18w6VWjMtrC0ZG', '0', '0', '', null, 'admin', '2020-08-18 14:38:25', '', null, null);
INSERT INTO `sys_user` VALUES ('101', '200', 'leader', 'leader', '00', 'xpws2007@163.com', '13501200637', '0', '', '$2a$10$nD6FxZ4Xd0AtL2X6pZ0y7.UZaHmKXB6Xu488/UmO1P484UUP0lEce', '0', '0', '', null, 'admin', '2020-08-18 14:40:36', '', null, null);
INSERT INTO `sys_user` VALUES ('102', '108', 'test', 'test', '00', '15688789632@qq.com', '15688789632', '0', '', '$2a$10$ve1Xysi/.TfFnIe3m6EjW.bLJvjUD.FtJRDEp/uAu30r4uJ7bnN1C', '0', '0', '', null, 'admin', '2020-09-16 15:32:14', '', null, null);

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('100', '101');
INSERT INTO `sys_user_role` VALUES ('101', '100');

-- ----------------------------
-- View structure for funds_view
-- ----------------------------
DROP VIEW IF EXISTS `funds_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `funds_view` AS select sum(`jalo_available_funds`.`total_amount`) AS `sum_available_funds_total_amount` from `jalo_available_funds` ;

-- ----------------------------
-- View structure for information_view
-- ----------------------------
DROP VIEW IF EXISTS `information_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `information_view` AS select sum(`jalo_purchase_order_tracking_information`.`contract_amount`) AS `sum_contract_amount`,sum(`jalo_purchase_order_tracking_information`.`prepayment_amount_payable`) AS `sum_prepayment_amount_payable`,sum(`jalo_purchase_order_tracking_information`.`prepayment_amount_paid`) AS `sum_prepayment_amount_paid` from `jalo_purchase_order_tracking_information` ;

-- ----------------------------
-- View structure for inventory_view
-- ----------------------------
DROP VIEW IF EXISTS `inventory_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `inventory_view` AS select sum(`jalo_inventory_detail`.`saleable_inventory_amount`) AS `sum_saleable_inventory_amount`,sum(`jalo_inventory_detail`.`unsaleable_inventory_amount`) AS `sum_unsaleable_inventory_amount`,sum(`jalo_inventory_detail`.`inventory_amount`) AS `sum_inventory_amount` from `jalo_inventory_detail` ;

-- ----------------------------
-- View structure for jalo_amount_statistics_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_amount_statistics_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_amount_statistics_view` AS select `inventory`.`days` AS `days`,`information`.`sum_contract_amount` AS `sum_contract_amount`,`information`.`sum_prepayment_amount_payable` AS `sum_prepayment_amount_payable`,`information`.`sum_prepayment_amount_paid` AS `sum_prepayment_amount_paid`,`unsettled`.`sum_shipped_unsettled_total_amount` AS `sum_shipped_unsettled_total_amount`,`purchased`.`sum_purchased_unshipped_total_amount` AS `sum_purchased_unshipped_total_amount`,`loan`.`loan_usage_total_loan_credit_amount` AS `loan_usage_total_loan_credit_amount`,`loan`.`loan_usage_total_loan_credit_balance` AS `loan_usage_total_loan_credit_balance`,`loan`.`loan_usage_total_loan_credit_remaining` AS `loan_usage_total_loan_credit_remaining`,`funds`.`sum_available_funds_total_amount` AS `sum_available_funds_total_amount`,`inventory`.`sum_inventory_amount` AS `sum_inventory_amount`,`inventory`.`sum_saleable_inventory_amount` AS `sum_saleable_inventory_amount`,`inventory`.`sum_unsaleable_inventory_amount` AS `sum_unsaleable_inventory_amount`,`transit`.`goods_transit_total_amount` AS `goods_transit_total_amount` from ((((((`jalo_inventory_view` `inventory` left join `jalo_purchase_order_tracking_information_view` `information` on((`inventory`.`days` = `information`.`days`))) left join `jalo_shipped_unsettled_view` `unsettled` on((`inventory`.`days` = `unsettled`.`days`))) left join `jalo_purchased_unshipped_view` `purchased` on((`inventory`.`days` = `purchased`.`days`))) left join `jalo_loan_usage_view` `loan` on((`inventory`.`days` = `loan`.`days`))) left join `jalo_available_funds_view` `funds` on((`inventory`.`days` = `funds`.`days`))) left join `jalo_goods_transit_view` `transit` on((`inventory`.`days` = `transit`.`days`))) order by `inventory`.`days` desc ;

-- ----------------------------
-- View structure for jalo_amount_statistics_view2
-- ----------------------------
DROP VIEW IF EXISTS `jalo_amount_statistics_view2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_amount_statistics_view2` AS select `information`.`sum_contract_amount` AS `sum_contract_amount`,`information`.`sum_prepayment_amount_payable` AS `sum_prepayment_amount_payable`,`information`.`sum_prepayment_amount_paid` AS `sum_prepayment_amount_paid`,`unsettled`.`sum_shipped_unsettled_total_amount` AS `sum_shipped_unsettled_total_amount`,`purchased`.`sum_purchased_unshipped_total_amount` AS `sum_purchased_unshipped_total_amount`,`loan`.`loan_usage_total_loan_credit_amount` AS `loan_usage_total_loan_credit_amount`,`loan`.`loan_usage_total_loan_credit_balance` AS `loan_usage_total_loan_credit_balance`,`loan`.`loan_usage_total_loan_credit_remaining` AS `loan_usage_total_loan_credit_remaining`,`funds`.`sum_available_funds_total_amount` AS `sum_available_funds_total_amount`,`inventory`.`sum_inventory_amount` AS `sum_inventory_amount`,`inventory`.`sum_saleable_inventory_amount` AS `sum_saleable_inventory_amount`,`inventory`.`sum_unsaleable_inventory_amount` AS `sum_unsaleable_inventory_amount`,`transit`.`goods_transit_total_amount` AS `goods_transit_total_amount` from ((((((`information_view` `information` join `unsettled_view` `unsettled`) join `purchased_view` `purchased`) join `loan_view` `loan`) join `funds_view` `funds`) join `inventory_view` `inventory`) join `transit_view` `transit`) ;

-- ----------------------------
-- View structure for jalo_available_funds_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_available_funds_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_available_funds_view` AS select date_format(`jalo_available_funds`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_available_funds`.`total_amount`) AS `sum_available_funds_total_amount` from `jalo_available_funds` group by `days` order by `jalo_available_funds`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_goods_transit_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_goods_transit_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_goods_transit_view` AS select date_format(`jalo_goods_transit`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_goods_transit`.`total_amount`) AS `goods_transit_total_amount` from `jalo_goods_transit` group by `days` order by `jalo_goods_transit`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_inventory_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_inventory_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_inventory_view` AS select date_format(`jalo_inventory_detail`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_inventory_detail`.`saleable_inventory_amount`) AS `sum_saleable_inventory_amount`,sum(`jalo_inventory_detail`.`unsaleable_inventory_amount`) AS `sum_unsaleable_inventory_amount`,sum(`jalo_inventory_detail`.`inventory_amount`) AS `sum_inventory_amount` from `jalo_inventory_detail` group by `days` order by `jalo_inventory_detail`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_loan_usage_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_loan_usage_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_loan_usage_view` AS select date_format(`jalo_loan_usage`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_loan_usage`.`loan_credit_amount`) AS `loan_usage_total_loan_credit_amount`,sum(`jalo_loan_usage`.`loan_credit_balance`) AS `loan_usage_total_loan_credit_balance`,sum(`jalo_loan_usage`.`loan_credit_remaining`) AS `loan_usage_total_loan_credit_remaining` from `jalo_loan_usage` group by `days` order by `jalo_loan_usage`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_placed_not_shipped_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_placed_not_shipped_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_placed_not_shipped_view` AS select date_format(`jalo_placed_not_shipped`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_placed_not_shipped`.`placed_not_shipped`) AS `placed_not_shipped_total_amount` from `jalo_placed_not_shipped` group by `days` order by `jalo_placed_not_shipped`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_purchase_order_tracking_information_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_purchase_order_tracking_information_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_purchase_order_tracking_information_view` AS select date_format(`jalo_purchase_order_tracking_information`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_purchase_order_tracking_information`.`contract_amount`) AS `sum_contract_amount`,sum(`jalo_purchase_order_tracking_information`.`prepayment_amount_payable`) AS `sum_prepayment_amount_payable`,sum(`jalo_purchase_order_tracking_information`.`prepayment_amount_paid`) AS `sum_prepayment_amount_paid` from `jalo_purchase_order_tracking_information` group by `days` order by `jalo_purchase_order_tracking_information`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_purchased_unshipped_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_purchased_unshipped_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_purchased_unshipped_view` AS select date_format(`jalo_purchased_unshipped`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_purchased_unshipped`.`total_amount`) AS `sum_purchased_unshipped_total_amount` from `jalo_purchased_unshipped` group by `days` order by `jalo_purchased_unshipped`.`create_time` desc ;

-- ----------------------------
-- View structure for jalo_shipped_unsettled_view
-- ----------------------------
DROP VIEW IF EXISTS `jalo_shipped_unsettled_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `jalo_shipped_unsettled_view` AS select date_format(`jalo_shipped_unsettled`.`create_time`,'%Y-%m-%d') AS `days`,sum(`jalo_shipped_unsettled`.`total_amount`) AS `sum_shipped_unsettled_total_amount` from `jalo_shipped_unsettled` group by `days` order by `jalo_shipped_unsettled`.`create_time` desc ;

-- ----------------------------
-- View structure for loan_view
-- ----------------------------
DROP VIEW IF EXISTS `loan_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `loan_view` AS select sum(`jalo_loan_usage`.`loan_credit_amount`) AS `loan_usage_total_loan_credit_amount`,sum(`jalo_loan_usage`.`loan_credit_balance`) AS `loan_usage_total_loan_credit_balance`,sum(`jalo_loan_usage`.`loan_credit_remaining`) AS `loan_usage_total_loan_credit_remaining` from `jalo_loan_usage` ;

-- ----------------------------
-- View structure for purchased_view
-- ----------------------------
DROP VIEW IF EXISTS `purchased_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `purchased_view` AS select sum(`jalo_purchased_unshipped`.`total_amount`) AS `sum_purchased_unshipped_total_amount` from `jalo_purchased_unshipped` ;

-- ----------------------------
-- View structure for transit_view
-- ----------------------------
DROP VIEW IF EXISTS `transit_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `transit_view` AS select sum(`jalo_goods_transit`.`total_amount`) AS `goods_transit_total_amount` from `jalo_goods_transit` ;

-- ----------------------------
-- View structure for unsettled_view
-- ----------------------------
DROP VIEW IF EXISTS `unsettled_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`xinping`@`%` SQL SECURITY DEFINER VIEW `unsettled_view` AS select sum(`jalo_shipped_unsettled`.`total_amount`) AS `sum_shipped_unsettled_total_amount` from `jalo_shipped_unsettled` ;
