<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-tag>页面显示，单位：万元</el-tag>
      </el-col>
    </el-row>

    <el-row
      :gutter="10"
      style="background: #1b2137"
      v-if="viewList && viewList.length != 0"
    >
      <el-col
        :span="24"
        style="
          color: #fff;
          text-align: right;
          padding: 10px 20px;
          font-size: 20px;
        "
        >{{ viewList[0].days }}</el-col
      >

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">已付预付款</div>
          <div class="num spanClass">
            {{ viewList[0].sumPrepaymentAmountPayable }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">应付尾款</div>
          <div class="num spanClass">
            {{ viewList[0].sumPrepaymentAmountPaid }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">已发货未结算</div>
          <div class="num spanClass">
            {{ viewList[0].sumShippedUnsettledTotalAmount }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">已下单未发货</div>
          <div class="num spanClass">
            {{ viewList[0].sumPurchasedUnshippedTotalAmount }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">贷款已使用金额</div>
          <div class="num spanClass">
            {{ viewList[0].loanUsageTotalLoanCreditBalance }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">可用资金</div>
          <div class="num spanClass">
            {{ viewList[0].sumAvailableFundsTotalAmount }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">库存</div>
          <div class="num spanClass">
            {{ viewList[0].sumInventoryAmount }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px"
        >
          <div class="title">在途物资</div>
          <div class="num spanClass">
            {{ viewList[0].goodsTransitTotalAmount }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
      <div class="strikeLine"></div>

      <el-col :span="24">
        <div
          class="card"
          style="background: #1b2137; color: #fff; padding: 20px 0"
        >
          <div class="title"></div>

          <div class="num spanClass" style="font-size: 1.9rem">
            已下单未发货+已发货未结算+可用资金–贷款已使用金额={{
              viewList[0].statisticalIndicators1
            }}
            <span style="font-size: 14px">万元</span>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<style scoped>
.title {
  font-size: 2rem;
  color: #fff;
  text-align: left;
  height: 8rem;
}
.strikeLine {
  border-bottom: 8px rgb(11, 20, 53) solid;
  float: left;
  width: 100%;
}
.spanClass {
  text-align: center;
  font-size: 3.5rem;
  color: #ff7f00;
}
</style>
<style>
@media screen and (min-width: 1501px) and (max-width: 1930px) {
  html {
    font-size: 10px !important;
  }
}

@media screen and (min-width: 1201px) and (max-width: 1500px) {
  html {
    font-size: 8.6px !important;
  }
}

@media screen and (min-width: 901px) and (max-width: 1200px) {
  html {
    font-size: 6.9px !important;
  }
}

@media screen and (max-width: 900px) {
  html {
    font-size: 5.5px !important;
  }
}
</style>
<script>
import {
  queryNewFromList,
  listView,
  getView,
  delView,
  addView,
  updateView,
  exportView,
} from "@/api/amount/view";

export default {
  name: "DisplayView",
  data() {
    return {
      /* 遮罩层 */
      loading: true,

      /* // 表单参数 */

      form: {},
      /* // 表单校验 */
      rules: {},
      viewList: [],
      open: false,
      title: "",
    };
  },
  created() {
    this.getList();
  },
  activated() {
    this.getList();
  },
  methods: {
    /** 查询VIEW列表 */
    getList() {
      this.loading = true;
      queryNewFromList(this.queryParams).then((response) => {
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
        placedNotShippedTotalAmount: null,
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
      this.ids = selection.map((item) => item.days);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
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
      const days = row.days || this.ids;
      getView(days).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改VIEW";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.days != null) {
            updateView(this.form).then((response) => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addView(this.form).then((response) => {
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
        type: "warning",
      })
        .then(function () {
          return delView(dayss);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
        .catch(function () {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm("是否确认导出所有VIEW数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return exportView(queryParams);
        })
        .then((response) => {
          this.download(response.msg);
        })
        .catch(function () {});
    },
  },
};
</script>
