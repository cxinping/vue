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


