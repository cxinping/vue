<template>
  <div class="app-container">
   <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="days">
        <el-input
          v-model="queryParams.days"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumSaleableInventoryAmount">
        <el-input
          v-model="queryParams.sumSaleableInventoryAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumUnsaleableInventoryAmount">
        <el-input
          v-model="queryParams.sumUnsaleableInventoryAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumInventoryAmount">
        <el-input
          v-model="queryParams.sumInventoryAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumPrepaymentAmountPaid">
        <el-input
          v-model="queryParams.sumPrepaymentAmountPaid"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumShippedUnsettledTotalAmount">
        <el-input
          v-model="queryParams.sumShippedUnsettledTotalAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="sumAvailableFundsTotalAmount">
        <el-input
          v-model="queryParams.sumAvailableFundsTotalAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="goodsTransitTotalAmount">
        <el-input
          v-model="queryParams.goodsTransitTotalAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="placedNotShippedTotalAmount">
        <el-input
          v-model="queryParams.placedNotShippedTotalAmount"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
      -->

<el-row :gutter="10" class="mb8">
      
      <el-col :span="1.5">
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
        >刷新</el-button>
      </el-col>

      <el-col :span="1.5">        
        <el-tag>页面显示，单位：万元</el-tag>               
      </el-col>
      <div class="top-right-btn">
        <el-tooltip class="item" effect="dark" content="刷新" placement="top">
          <el-button size="mini" circle icon="el-icon-refresh" @click="handleQuery" />
        </el-tooltip>
        <el-tooltip class="item" effect="dark" :content="showSearch ? '隐藏搜索' : '显示搜索'" placement="top">
          <el-button size="mini" circle icon="el-icon-search" @click="showSearch=!showSearch" />
        </el-tooltip>
      </div>
    </el-row>

    <el-row :gutter="10" style="background: #1b2137;">
      <el-col :span="24" style="color: #fff; text-align: right; padding: 10px 20px;">{{viewList[0].days}}</el-col>
      <!-- 
      <el-col :span="24">
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            采购合同款
          </div>
          <div class="num" style="text-align: center; font-size: 30px;color:#FACC2E;">{{viewList[0].sumContractAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
      -->

      <el-col :span="24" >
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            已付预付款
          </div>
          <div class="num" style="text-align: center; font-size: 40px;color:#ff7f00;">{{viewList[0].sumPrepaymentAmountPayable}} <span style="font-size: 14px;">万元</span> </div>
        </div>
      </el-col>
      <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            应付尾款
          </div>
          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">{{viewList[0].sumPrepaymentAmountPaid}} <span style="font-size: 14px;">万元</span> </div>
        </div>
      </el-col>
       <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            已发货未结算
          </div>
          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">{{viewList[0].sumShippedUnsettledTotalAmount}} <span style="font-size: 14px;">万元</span> </div>
        </div>
      </el-col>
       <el-col :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            已下单未发货
          </div>
          <div class="num" style="text-align: center; font-size: 40px;color:#ff7f00;">{{viewList[0].sumPurchasedUnshippedTotalAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>

      <!-- 
      <el-col :span="24" >
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            贷款授信额度
          </div>
          <div class="num" style="text-align: center; font-size: 30px;color:#FACC2E;">{{viewList[0].loanUsageTotalLoanCreditAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
      -->

      <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            贷款已使用金额
          </div>
          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">{{viewList[0].loanUsageTotalLoanCreditBalance}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>

      <!-- 
       <el-col  :span="24">
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            剩余可使用额度
          </div>
          <div class="num" style="text-align: center; font-size:30px;color:#FACC2E;">{{viewList[0].loanUsageTotalLoanCreditRemaining}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
    -->

      <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            可用资金
          </div>
          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">{{viewList[0].sumAvailableFundsTotalAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
      <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
            库存
          </div>
          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">{{viewList[0].sumInventoryAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
      <!-- 
      <el-col  :span="24">
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            可销售库存
          </div>
          <div class="num" style="text-align: center; font-size:30px;color:#FACC2E;">{{viewList[0].sumSaleableInventoryAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
     

      <el-col  :span="24">
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            等通知发货库存
          </div>
          <div class="num" style="text-align: center; font-size:30px;color:#FACC2E;">{{viewList[0].sumUnsaleableInventoryAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
     

      <el-col  :span="24">
        <div class="card"  style="background: #000; color: #fff; padding: 20px;">
          <div class="title">
            在途物资
          </div>
          <div class="num" style="text-align: center; font-size:30px;color:#FACC2E;">{{viewList[0].goodsTransitTotalAmount}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>
      -->

      <el-col  :span="24">
        <div class="card"  style="background: #1b2137; color: #fff; padding: 20px;">
          <div class="title">
              
          </div>
          <!-- 
          <div class="num" style="text-align: center; font-size:30px;color:#ff7f00;"><span style="font-size: 14px;">已下单未发货+已发货未结算+可用资金–贷款已使用金额=</span>{{viewList[0].statisticalIndicators1}} <span style="font-size: 14px;">万元</span></div>
          -->

          <div class="num" style="text-align: center; font-size:40px;color:#ff7f00;">已下单未发货+已发货未结算+可用资金–贷款已使用金额={{viewList[0].statisticalIndicators1}} <span style="font-size: 14px;">万元</span></div>
        </div>
      </el-col>

    </el-row>

    
   <!-- 
    <el-table v-loading="loading" :data="viewList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日期" align="center" prop="days" />
      <el-table-column label="预付款合计金额" align="center" prop="sumPrepaymentAmountPaid" />
      <el-table-column label="可销售库存合计金额" align="center" prop="sumSaleableInventoryAmount" />
      <el-table-column label="不可销售库存合计金额" align="center" prop="sumUnsaleableInventoryAmount" />
      <el-table-column label="库存合计金额" align="center" prop="sumInventoryAmount" />
      <el-table-column label="已发货未结算合计金额" align="center" prop="sumShippedUnsettledTotalAmount" />
      <el-table-column label="可用资金取合计金额" align="center" prop="sumAvailableFundsTotalAmount" />
      <el-table-column label="在途物资取合计金额" align="center" prop="goodsTransitTotalAmount" />
      <el-table-column label="已下单未发货合计金额数" align="center" prop="placedNotShippedTotalAmount" />
    
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['amount:view:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:view:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
     

    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
 -->

    <!-- 添加或修改VIEW对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="days">
          <el-input v-model="form.days" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumSaleableInventoryAmount">
          <el-input v-model="form.sumSaleableInventoryAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumUnsaleableInventoryAmount">
          <el-input v-model="form.sumUnsaleableInventoryAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumInventoryAmount">
          <el-input v-model="form.sumInventoryAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumPrepaymentAmountPaid">
          <el-input v-model="form.sumPrepaymentAmountPaid" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumShippedUnsettledTotalAmount">
          <el-input v-model="form.sumShippedUnsettledTotalAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sumAvailableFundsTotalAmount">
          <el-input v-model="form.sumAvailableFundsTotalAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="goodsTransitTotalAmount">
          <el-input v-model="form.goodsTransitTotalAmount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="placedNotShippedTotalAmount">
          <el-input v-model="form.placedNotShippedTotalAmount" placeholder="请输入${comment}" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { queryNewFromList,listView, getView, delView, addView, updateView, exportView } from "@/api/amount/view";

export default {
  name: "View",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // VIEW表格数据
      viewList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        days: null,
        sumSaleableInventoryAmount: null,
        sumUnsaleableInventoryAmount: null,
        sumInventoryAmount: null,
        sumPrepaymentAmountPaid: null,
        sumShippedUnsettledTotalAmount: null,
        sumAvailableFundsTotalAmount: null,
        goodsTransitTotalAmount: null,
        placedNotShippedTotalAmount: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询VIEW列表 */
    getList() {
      this.loading = true;
      //listView(this.queryParams).then(response => {
      queryNewFromList(this.queryParams).then(response => {
        this.viewList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        days: null,
        sumSaleableInventoryAmount: null,
        sumUnsaleableInventoryAmount: null,
        sumInventoryAmount: null,
        sumPrepaymentAmountPaid: null,
        sumShippedUnsettledTotalAmount: null,
        sumAvailableFundsTotalAmount: null,
        goodsTransitTotalAmount: null,
        placedNotShippedTotalAmount: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.days)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加VIEW";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const days = row.days || this.ids
      getView(days).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改VIEW";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.days != null) {
            updateView(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addView(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const dayss = row.days || this.ids;
      this.$confirm('是否确认删除VIEW编号为"' + dayss + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delView(dayss);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有VIEW数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportView(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
