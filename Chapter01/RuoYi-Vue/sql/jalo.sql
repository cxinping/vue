
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
  `payable_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '应付预付款时间',
  `prepayment_amount_payable` decimal(10,2) DEFAULT '0.00' COMMENT '应付预付款金额',
  `prepayment_amount_paid` decimal(10,2) DEFAULT '0.00' COMMENT '已付预付款金额',
  `prepayment_payable_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '应付预付款时间',
  `prepayment_payable_amount` decimal(10,2) DEFAULT '0.00' COMMENT '应付预付款金额',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单跟踪信息表';


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
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='可用资金';


-- ----------------------------
-- Table structure for jalo_loan_usage_table
-- ----------------------------
DROP TABLE IF EXISTS `jalo_loan_usage_table`;
CREATE TABLE `jalo_loan_usage_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_credit_amount` decimal(10,2) DEFAULT '0.00' COMMENT '贷款授信金额',
  `loan_credit_balance` decimal(10,2) DEFAULT '0.00' COMMENT '贷款授信余额',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='贷款使用表';


