<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['amount:transit:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:transit:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:transit:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:transit:export']"
          >导出</el-button
        >
      </el-col>

      <el-col :span="1.5" v-show="this.transitList && this.transitList[0]">
        <el-tag>{{
          this.transitList &&
            this.transitList[0] &&
            "在途物资金额合计：" +
              this.transitList[0].sumamount +
              "元 数量合计：" +
              this.transitList[0].sumnum +
              "个"
        }}</el-tag>
      </el-col>

      <div class="top-right-btn" style="display: flex">
        <el-input
          v-model="searchInput"
          placeholder="请输入搜索条件"
          v-show="showSearch"
          size="small"
          class="searchClass"
          ref="serchInput"
        ></el-input>
        <el-tooltip class="item" effect="dark" content="查询" placement="top">
          <el-button
            size="mini"
            circle
            icon="el-icon-search"
            @click="handleQuery"
          />
        </el-tooltip>
        <el-tooltip
          class="item"
          effect="dark"
          :content="showSearch ? '隐藏搜索' : '显示搜索'"
          placement="top"
        >
          <el-button
            size="mini"
            circle
            icon="el-icon-refresh"
            @click="showSearch = !showSearch"
          />
        </el-tooltip>
      </div>
    </el-row>
    <el-table
      :data="transitList"
      default-expand-all
      border
      row-key="id"
      @select="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="在途物资" align="center">
        <el-table-column label="供应商" align="center" prop="support" />
        <el-table-column label="产品名称" align="center" prop="product" />
        <el-table-column
          label="采购订单号"
          align="center"
          prop="purchaseOrderNumber"
        />
        <el-table-column label="数量" align="center" prop="num" />
        <el-table-column
          label="金额"
          align="center"
          prop="amount"
          :formatter="stateFormat"
        />
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改在途物资对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="500px"
      append-to-body
      custom-class="customClass"
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="供应商" prop="support" required>
          <el-input v-model="form.support" placeholder="请输入供应商" />
        </el-form-item>

        <el-form-item label="产品名称" prop="product" required>
          <el-input v-model="form.product" placeholder="请输入产品名称" />
        </el-form-item>

        <el-form-item label="订单号" prop="purchaseOrderNumber" required>
          <el-input
            v-model="form.purchaseOrderNumber"
            placeholder="请输入采购订单号"
          />
        </el-form-item>

        <el-form-item label="数量" prop="num" required>
          <el-input v-model="form.num" placeholder="请输入数量" />
        </el-form-item>

        <el-form-item label="金额" prop="amount" required>
          <el-input v-model="form.amount" placeholder="请输入金额，单位：元" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<style scoped>
.searchClass {
  height: 28px;
  line-height: 28px;
  right: 10px;
}
</style>
<style>
.el-dialog.customClass {
  display: flex !important;
  flex-direction: column !important;
  margin: 0 !important ;
  position: absolute !important;
  top: 50% !important;
  left: 50% !important;
  color: #bab9ba;
  transform: translate(-50%, -50%) !important;
}
</style>

<script>
import {
  listTransit,
  getTransit,
  delTransit,
  addTransit,
  updateTransit,
  exportTransit
} from "@/api/amount/transit";

export default {
  name: "Transit",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],

      orderIds: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 在途物资表格数据
      transitList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        support: null,
        product: null,
        purchaseOrderNumber: null,
        num: null,
        amount: null,
        param: null
      },
      sumNumInfo: 0,
      sumAmountInfo: 0,
      searchInput: "",
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        support: [
          {
            required: true,
            message: "请输入供应商名称",
            trigger: "blur"
          }
        ],
        product: [
          {
            required: true,
            message: "请输入产品名称",
            trigger: "blur"
          }
        ],
        purchaseOrderNumber: [
          {
            required: true,
            message: "请输入采购订单号",
            trigger: "blur"
          }
        ],
        num: [
          {
            required: true,
            message: "请输入数量",
            trigger: "blur"
          }
        ],
        amount: [
          {
            required: true,
            message: "请输入金额，单位：元",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  computed: {
    computeSumInfo() {
      debugger;
      if (this.transitList && this.transitList[0]) {
        return;
        "在途物资金额合计：" +
          this.transitList[0].sumamount +
          "元 数量合计：" +
          this.transitList[0].sumnum +
          "个";
      } else {
        return "";
      }
    }
  },

  methods: {
    stateFormat(row, column, cellValue) {
      cellValue += "";
      if (!cellValue.includes(".")) cellValue += ".";
      return cellValue
        .replace(/(\d)(?=(\d{3})+\.)/g, function($0, $1) {
          return $1 + ",";
        })
        .replace(/\.$/, "");
    },

    /** 查询在途物资列表 */
    getList() {
      this.loading = true;
      listTransit(this.queryParams).then(response => {
        this.transitList = response.rows;
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
        id: null,
        support: null,
        product: null,
        purchaseOrderNumber: null,
        num: null,
        amount: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.queryParams.param = this.searchInput;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection, row) {
      this.ids = selection.map(item => item.id);
      this.orderIds = selection.map(item => item.purchaseOrderNumber);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加在途物资";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getTransit(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改在途物资";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 对输入金额进行转换，保留小数点后2位
          //const buildingMaterialsFmt = this.keepTwoDecimal( this.form.buildingMaterials / 10000 );
          //this.form.buildingMaterials = buildingMaterialsFmt ;

          // 去除输入的特殊字符，比如 ,
          const supportFmt = String(this.form.support).replace(",", "");
          this.form.support = supportFmt;
          const productFmt = String(this.form.product).replace(",", "");
          this.form.product = productFmt;
          const purchaseOrderNumberFmt = String(
            this.form.purchaseOrderNumber
          ).replace(",", "");
          this.form.purchaseOrderNumber = purchaseOrderNumberFmt;
          const numFmt = String(this.form.num).replace(",", "");
          this.form.num = numFmt;
          const amountFmt = String(this.form.amount).replace(",", "");
          this.form.amount = amountFmt;

          if (this.form.id != null) {
            updateTransit(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addTransit(this.form).then(response => {
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
    /** 保留小数点后2位 */
    keepTwoDecimal(num) {
      var result = parseFloat(num);
      if (isNaN(result)) {
        alert("传递参数错误，请检查！");
        return false;
      }
      result = Math.round(num * 100) / 100;
      return result;
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      const orderIds = row.id || this.orderIds;

      this.$confirm(
        '是否确认删除在途物资采购订单号为"' + orderIds + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }
      )
        .then(function() {
          return delTransit(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
        .catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm("是否确认导出所有在途物资数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(function() {
          return exportTransit();
        })
        .then(response => {
          this.download(response.msg);
        })
        .catch(function() {});
    }
  }
};
</script>
