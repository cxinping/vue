
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

-- ----------------------------
-- 创建库存表的视图
-- ----------------------------
CREATE VIEW jalo_inventory_view AS SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(saleable_inventory_amount) AS sum_saleable_inventory_amount,
	SUM(unsaleable_inventory_amount	) AS sum_unsaleable_inventory_amount,
	SUM(inventory_amount) AS sum_inventory_amount
FROM
	jalo_inventory_detail
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建采购订单跟踪信息表的视图
-- ----------------------------
CREATE VIEW jalo_purchase_order_tracking_information_view AS
SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(prepayment_amount_paid) AS sum_prepayment_amount_paid
FROM
	jalo_purchase_order_tracking_information
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建已发货未结算金额表的视图
-- ----------------------------
CREATE VIEW jalo_shipped_unsettled_view AS
SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(total_amount) AS sum_shipped_unsettled_total_amount
FROM
	jalo_shipped_unsettled
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建可用资金表的视图
-- ----------------------------
CREATE VIEW jalo_available_funds_view AS
SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(total_amount) AS sum_available_funds_total_amount
FROM
	jalo_available_funds
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建在途物资表的视图
-- ----------------------------
CREATE VIEW jalo_goods_transit_view AS
SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(total_amount) AS goods_transit_total_amount
FROM
	jalo_goods_transit
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建已下单未发货表的视图
-- ----------------------------
CREATE VIEW jalo_placed_not_shipped_view AS
SELECT
	DATE_FORMAT(create_time, '%Y-%m-%d') AS days,
	SUM(placed_not_shipped) AS placed_not_shipped_total_amount
FROM
	jalo_placed_not_shipped
GROUP BY
	days
ORDER BY
	create_time DESC

-- ----------------------------
-- 创建统计页面表的视图
-- ----------------------------
CREATE VIEW jalo_amount_statistics_view AS
SELECT
	inventory.days,
	inventory.sum_saleable_inventory_amount,
	inventory.sum_unsaleable_inventory_amount,
	inventory.sum_inventory_amount,
	information.sum_prepayment_amount_paid
FROM
	jalo_inventory_view AS inventory
LEFT JOIN jalo_purchase_order_tracking_information_view AS information ON inventory.days = information.days
ORDER BY
	inventory.days DESC

CREATE VIEW jalo_amount_statistics_view AS
SELECT
	inventory.days,
	inventory.sum_saleable_inventory_amount,
	inventory.sum_unsaleable_inventory_amount,
	inventory.sum_inventory_amount,
	information.sum_prepayment_amount_paid,
	unsettled.sum_shipped_unsettled_total_amount,
	funds.sum_available_funds_total_amount,
    transit.goods_transit_total_amount,
	shipped.placed_not_shipped_total_amount
FROM
	jalo_inventory_view AS inventory
LEFT JOIN jalo_purchase_order_tracking_information_view AS information ON inventory.days = information.days
LEFT JOIN jalo_shipped_unsettled_view AS unsettled ON inventory.days = unsettled.days
LEFT JOIN jalo_available_funds_view AS funds ON inventory.days = funds.days
LEFT JOIN jalo_goods_transit_view AS transit ON inventory.days = transit.days
LEFT JOIN jalo_placed_not_shipped_view as shipped ON inventory.days = shipped.days
ORDER BY
	inventory.days DESC

