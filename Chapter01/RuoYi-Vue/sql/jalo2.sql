CREATE VIEW jalo_amount_statistics_view2 AS

SELECT
    information.sum_contract_amount ,                -- 采购合同款， 合同金额
    information.sum_prepayment_amount_payable,       -- 已付预付款， 应付预付款金额
	information.sum_prepayment_amount_paid,          -- 应付尾款， 应付尾款金额
	unsettled.sum_shipped_unsettled_total_amount,    -- 已发货未结算
     purchased.sum_purchased_unshipped_total_amount,  -- 已下单未发货
	loan.loan_usage_total_loan_credit_amount,        -- 贷款授信额度， 贷款授信金额
	loan.loan_usage_total_loan_credit_balance,       -- 贷款已使用金额， 贷款使用金额
	loan.loan_usage_total_loan_credit_remaining,     -- 剩余可使用额度， 剩余可使用额度
	funds.sum_available_funds_total_amount,          -- 可用资金
	inventory.sum_inventory_amount,                  -- 库存
	inventory.sum_saleable_inventory_amount,         -- 可销售库存,
	inventory.sum_unsaleable_inventory_amount,       -- 等通知发货库存
    transit.goods_transit_total_amount               -- 在途物资
FROM
	information_view as information,
	unsettled_view as unsettled ,
	purchased_view as  purchased,
	loan_view as  loan,
    funds_view as  funds,
	inventory_view as inventory,
	transit_view as transit

--------------------------------------

CREATE VIEW information_view AS
SELECT
    SUM(contract_amount) AS sum_contract_amount,											-- 合同金额
    SUM(prepayment_amount_payable) AS sum_prepayment_amount_payable,	-- 应付预付款金额
    SUM(prepayment_amount_paid) AS sum_prepayment_amount_paid 				-- 应付尾款金额
FROM
    jalo_purchase_order_tracking_information


CREATE VIEW unsettled_view AS SELECT
	SUM(total_amount) AS sum_shipped_unsettled_total_amount -- 已发货未结算
FROM
	jalo_shipped_unsettled


CREATE VIEW purchased_view AS
SELECT
    SUM(total_amount) AS sum_purchased_unshipped_total_amount       	-- 已下单未发货
FROM
    jalo_purchased_unshipped

CREATE VIEW loan_view AS
SELECT
      SUM(loan_credit_amount) AS loan_usage_total_loan_credit_amount,			-- 贷款授信额度， 贷款授信金额
      SUM(loan_credit_balance) AS loan_usage_total_loan_credit_balance,		-- 贷款已使用金额， 贷款使用金额
      SUM(loan_credit_remaining) AS loan_usage_total_loan_credit_remaining -- 剩余可使用额度， 剩余可使用额度
  FROM
    jalo_loan_usage

CREATE VIEW funds_view AS
SELECT
    SUM(total_amount) AS sum_available_funds_total_amount				-- 可用资金
FROM
    jalo_available_funds

CREATE VIEW inventory_view AS
SELECT
    SUM(saleable_inventory_amount) AS sum_saleable_inventory_amount,			-- 可销售库存金额
    SUM(unsaleable_inventory_amount) AS sum_unsaleable_inventory_amount,	-- 不可销售库存金额
    SUM(inventory_amount) AS sum_inventory_amount 												-- 合计金额
FROM
    jalo_inventory_detail

CREATE VIEW transit_view AS
SELECT
    SUM(total_amount) AS goods_transit_total_amount											-- 在途物资
FROM
    jalo_goods_transit
