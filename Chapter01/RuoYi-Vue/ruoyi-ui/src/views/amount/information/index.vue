<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
    >
      <!-- <el-form-item label="模糊查询" prop="param" v-show="!queryPattern">
        <el-input
          v-model="queryParams.param"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->

      <el-form-item label="精准查询" prop="exactParam">
        <div class="exactInput">
          <el-input
            v-model="queryParams.supplier"
            placeholder="请输入供应商名称"
            clearable
            size="small"
            style="width: 200px"
          />

          <!-- <el-select v-model="queryParams.supplier" placeholder="请输入供应商名称">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
               style="width: 200px"
            >
            </el-option>
          </el-select> -->
          <el-input
            v-model="queryParams.progress"
            placeholder="请输入后续进度"
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
          />
          <el-input
            v-model="queryParams.stampduty"
            placeholder="请输入印花税"
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
          />
          <el-input
            v-model="queryParams.contractsigning"
            placeholder="请输入合同签署情况"
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
          />
        </div>
        <div class="exactDate">
          <el-date-picker
            clearable
            size="small"
            style="width: 200px"
            v-model="queryParams.contractSigningBeginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择合同签订开始时间"
          >
          </el-date-picker>
          <el-date-picker
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
            v-model="queryParams.contractSigningEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择合同签订结束时间"
          >
          </el-date-picker>
          <el-date-picker
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
            v-model="queryParams.payableBeginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择应付尾款开始时间"
          >
          </el-date-picker>
          <el-date-picker
            clearable
            size="small"
            style="width: 200px; margin-left: 20px"
            v-model="queryParams.payableEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择应付尾款结束时间"
          >
          </el-date-picker>
        </div>
      </el-form-item>

      <el-form-item>
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
        <!-- <el-button icon="el-icon-d-caret" size="mini" @click="toggleQuery"
          >修改查询方式</el-button
        > -->
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['amount:information:add']"
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
          v-hasPermi="['amount:information:edit']"
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
          v-hasPermi="['amount:information:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:information:export']"
          >导出</el-button
        >
      </el-col>

      <el-col :span="1.5">
        <el-tag>页面显示，单位：元</el-tag>
      </el-col>

      <div class="top-right-btn">
        <el-tooltip class="item" effect="dark" content="刷新" placement="top">
          <el-button
            size="mini"
            circle
            icon="el-icon-refresh"
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
            icon="el-icon-search"
            @click="showSearch = !showSearch"
          />
        </el-tooltip>
      </div>
    </el-row>

    <el-table
      v-loading="loading"
      :data="informationList"
      @selection-change="handleSelectionChange"
      border
      style="width: 100%"
    >
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="采购订单号" align="center" prop="projectName" />
      <el-table-column label="供应商" align="center" prop="supplier" sortable />
      <el-table-column
        label="合同签订时间"
        align="center"
        prop="contractSigningTime"
        width="130"
      >
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.contractSigningTime, "{y}-{m}-{d}")
          }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="合同金额"
        align="center"
        prop="contractAmount"
        :formatter="stateFormat"
      />

      <el-table-column label="采购订单" align="center">
        <el-table-column
          label="预付款时间"
          align="center"
          prop="prepaymentPayableTime"
          :formatter="stateFormat"
        />
        <el-table-column
          label="预付款金额"
          align="center"
          prop="prepaymentAmountPayable"
          :formatter="stateFormat"
        />
        <el-table-column
          label="应付尾款时间"
          align="center"
          prop="payableTime"
          width="130"
          sortable
        >
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.payableTime, "{y}-{m}-{d}") }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="应付尾款金额"
          align="center"
          prop="prepaymentAmountPaid"
          :formatter="stateFormat"
        />
      </el-table-column>

      <el-table-column label="后续进度" align="center" prop="progress" />
      <el-table-column label="印花税" align="center" prop="stampduty" />
      <el-table-column
        label="合同签署情况"
        align="center"
        prop="contractsigning"
      />

      <el-table-column
        label="更新时间"
        align="center"
        prop="createTime"
        width="130"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改采购订单跟踪信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="采购订单号" prop="projectName">
              <el-input
                v-model="form.projectName"
                placeholder="请输入采购订单号"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="供应商" prop="supplier" required>
              <el-input
                v-model="form.supplier"
                placeholder="请输入供应商"
                @input="requestSupplier(form.supplier)"
                class="supplierInputClass"
              />
              <div
                class="supplierDiv"
                v-show="relateSupplier && relateSupplier.length != 0"
              >
                <div
                  class="supplierText"
                  v-for="(item, index) in relateSupplier"
                  :key="index"
                  @click="chooseSupplier(item)"
                >
                  {{ item }}
                </div>
              </div>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="合同签订时间" prop="contractSigningTime">
              <el-date-picker
                clearable
                size="small"
                style="width: 200px"
                v-model="form.contractSigningTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择合同签订时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合同结束时间" prop="contractEndTime" required>
              <el-date-picker
                clearable
                size="small"
                style="width: 200px"
                v-model="form.contractEndTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择合同结束时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="合同金额" prop="contractAmount" required>
              <el-input
                v-model="form.contractAmount"
                placeholder="请输入合同金额，单位：元"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="预付款时间" prop="prepaymentPayableTime">
              <el-date-picker
                clearable
                size="small"
                style="width: 200px"
                v-model="form.prepaymentPayableTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择预付款时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item
              label="预付款金额"
              prop="prepaymentAmountPayable"
              required
            >
              <el-input
                v-model="form.prepaymentAmountPayable"
                placeholder="请输入预付款金额，单位：元"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="应付尾款时间" prop="payableTime">
              <el-date-picker
                clearable
                size="small"
                style="width: 200px"
                v-model="form.payableTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择应付尾款时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="应付尾款金额" prop="prepaymentAmountPaid">
              <el-input v-model="computedShouldPay" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="后续进度" prop="progress" required>
              <el-select v-model="form.progress" placeholder="请选择">
                <el-option
                  v-for="item in progress_options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="印花税" prop="stampduty" required>
              <el-select v-model="form.stampduty" placeholder="请选择">
                <el-option
                  v-for="item in stampduty_options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="合同签署情况" prop="contractsigning" required>
              <el-input
                v-model="form.contractsigning"
                placeholder="请输入合同签署情况"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<style scoped></style>
<script>
import {
  listInformation,
  getInformation,
  delInformation,
  addInformation,
  updateInformation,
  exportInformation,
  listSupplier,
  getSupplierInformation
} from "@/api/amount/information";

export default {
  name: "Information",
  data() {
    return {
      queryPattern: false,
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
      relateSupplier: [],
      // 采购订单跟踪信息表格数据
      informationList: [],

      suppliertList: [],

      progress_options: [
        {
          value: "进行中",
          label: "进行中"
        },
        {
          value: "已结束",
          label: "已结束"
        }
      ],
      stampduty_options: [
        {
          value: "已申报",
          label: "已申报"
        },
        {
          value: "未申报",
          label: "未申报"
        }
      ],
      contractsigning_options: [
        {
          value: "进行中",
          label: "进行中"
        },
        {
          value: "已完成",
          label: "已完成"
        }
      ],

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        supplier: null,
        contractSigningTime: null,
        contractEndTime: null,
        contractAmount: null,
        payableTime: null,
        prepaymentAmountPayable: null,
        prepaymentAmountPaid: null,
        prepaymentPayableTime: null,
        prepaymentPayableAmount: null,
        param: null,
        progress: null,
        stampduty: null,
        contractsigning: null,
        contractSigningBeginTime: null,
        contractSigningEndTime: null,
        payableBeginTime: null,
        payableEndTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        /***
          projectName: [
            { required: true, message: '请输入项目名称', trigger: 'blur' }
          ], */

        supplier: [
          { required: true, message: "请输入供应商", trigger: "blur" }
        ],
        // contractSigningTime: [
        //   { required: true, message: "请输入合同签订时间", trigger: "blur" }
        // ],
        contractEndTime: [
          { required: true, message: "请输入合同结束时间", trigger: "blur" }
        ],
        contractAmount: [
          {
            required: true,
            message: "请输入合同金额，单位：元",
            trigger: "blur"
          }
        ],
        /***
          payableTime: [
            { required: true, message: '请输入应付尾款时间', trigger: 'blur' }
          ],*/
        prepaymentPayableTime: [
          { required: true, message: "请输入预付款时间", trigger: "blur" }
        ],
        prepaymentAmountPayable: [
          {
            required: true,
            message: "请输入已付预付款金额，单位：元",
            trigger: "blur"
          }
        ],

        contractsigning: [
          { required: true, message: "请输入合同签署情况", trigger: "blur" }
        ]

        /**
          prepaymentPayableTime: [
            { required: true, message: '请输入应付预付款时间', trigger: 'blur' }
          ],
          prepaymentPayableAmount: [
            { required: true, message: '请输入应付预付款金额，单位：元', trigger: 'blur' }
          ]
        **/
      }
    };
  },
  created() {
    this.getList();
    this.querySuppliertList();
  },
  mounted() {
    var self = this;
    document.onkeydown = function(e) {
      let currentChoose = document.querySelector(".chooseSupplier");
      let allSupplierDiv = document.querySelectorAll(".supplierText");
      if (allSupplierDiv) {
        switch (e.keyCode) {
          case 38:
            if (currentChoose) {
              if (allSupplierDiv && allSupplierDiv.length != 0) {
                if (currentChoose.previousElementSibling) {
                  currentChoose.previousElementSibling.className =
                    "chooseSupplier";
                } else {
                  allSupplierDiv[allSupplierDiv.length - 1].className =
                    "chooseSupplier";
                }
                currentChoose.className = "supplierText";
              }
            } else {
              if (allSupplierDiv && allSupplierDiv.length != 0) {
                allSupplierDiv[allSupplierDiv.length - 1].className =
                  "chooseSupplier";
              }
            }
            break;
          case 40:
            if (currentChoose) {
              if (allSupplierDiv && allSupplierDiv.length != 0) {
                if (currentChoose.nextElementSibling) {
                  currentChoose.nextElementSibling.className = "chooseSupplier";
                } else {
                  allSupplierDiv[0].className = "chooseSupplier";
                }
                currentChoose.className = "supplierText";
              }
            } else {
              if (allSupplierDiv && allSupplierDiv.length != 0) {
                allSupplierDiv[0].className = "chooseSupplier";
              }
            }
            break;
          case 13:
            document.querySelector(
              ".supplierInputClass input"
            ).value = document
              .querySelector(".chooseSupplier")
              .innerHTML.trim();
            self.relateSupplier = [];
            break;
        }
      }
    };
  },
  computed: {
    computedShouldPay() {
      let total = 0;
      let alreadyPay = 0;
      if (
        this.form.contractAmount &&
        this.form.contractAmount.toString().indexOf(",") != -1
      ) {
        total = parseInt(this.form.contractAmount.replaceAll(",", ""));
      } else {
        if (this.form.contractAmount) {
          total = parseInt(this.form.contractAmount);
        }
      }
      if (
        this.form.prepaymentAmountPayable &&
        this.form.prepaymentAmountPayable.toString().indexOf(",") != -1
      ) {
        alreadyPay = parseInt(
          this.form.prepaymentAmountPayable.replaceAll(",", "")
        );
      } else {
        if (this.form.prepaymentAmountPayable) {
          alreadyPay = parseInt(this.form.prepaymentAmountPayable);
        }
      }

      let shouldPay = total - alreadyPay;
      this.form.prepaymentAmountPaid = shouldPay;
      return this.toDecimalMark(shouldPay);
    }
  },
  methods: {
    toDecimalMark(num) {
      if (!num) {
        return 0;
      }
      return num.toLocaleString("en-US");
    },
    stateFormat(row, column, cellValue) {
      cellValue += "";
      if (!cellValue.includes(".")) cellValue += ".";
      return cellValue
        .replace(/(\d)(?=(\d{3})+\.)/g, function($0, $1) {
          return $1 + ",";
        })
        .replace(/\.$/, "");
    },

    querySuppliertList() {
      listSupplier().then(response => {
        this.suppliertList = response.data;
      });
    },

    /** 查询采购订单跟踪信息列表 */
    getList() {
      this.loading = true;
      listInformation(this.queryParams).then(response => {
        //debugger;
        this.informationList = response.rows;
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
        projectName: null,
        supplier: null,
        contractSigningTime: null,
        contractEndTime: null,
        contractAmount: null,
        payableTime: null,
        prepaymentAmountPayable: null,
        prepaymentAmountPaid: null,
        prepaymentPayableTime: null,
        prepaymentPayableAmount: null,
        createTime: null,
        updateTime: null,
        param: null,
        progress: null,
        stampduty: null,
        contractsigning: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      //debugger;
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
      this.ids = selection.map(item => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加采购订单跟踪信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getInformation(id).then(response => {
        this.form = response.data;

        // 修改数据时，乘以 10000
        //this.form.contractAmount = this.form.contractAmount * 10000;
        //this.form.prepaymentAmountPayable = this.form.prepaymentAmountPayable * 10000;
        //this.form.prepaymentAmountPaid = this.form.prepaymentAmountPaid * 10000;
        //this.form.prepaymentPayableAmount = this.form.prepaymentPayableAmount * 10000;

        this.open = true;
        this.title = "修改采购订单跟踪信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 对输入金额进行转换，保留小数点后2位
          //const contractAmountFmt = this.keepTwoDecimal( this.form.contractAmount / 10000 );
          //this.form.contractAmount = contractAmountFmt ;
          //const prepaymentAmountPayableFmt = this.keepTwoDecimal( this.form.prepaymentAmountPayable / 10000 );
          //this.form.prepaymentAmountPayable = prepaymentAmountPayableFmt ;
          //const prepaymentAmountPaidFmt = this.keepTwoDecimal( this.form.prepaymentAmountPaid / 10000 );
          //this.form.prepaymentAmountPaid = prepaymentAmountPaidFmt ;
          //const prepaymentPayableAmountFmt = this.keepTwoDecimal( this.form.prepaymentPayableAmount / 10000 );
          //this.form.prepaymentPayableAmount = prepaymentPayableAmountFmt ;

          // 去除输入的特殊字符，比如 ,
          const contractAmountFmt = String(this.form.contractAmount).replace(
            ",",
            ""
          );
          this.form.contractAmount = contractAmountFmt;
          const prepaymentAmountPayableFmt = String(
            this.form.prepaymentAmountPayable
          ).replace(",", "");
          this.form.prepaymentAmountPayable = prepaymentAmountPayableFmt;
          const prepaymentAmountPaidFmt = String(
            this.form.prepaymentAmountPaid
          ).replace(",", "");
          this.form.prepaymentAmountPaid = prepaymentAmountPaidFmt;

          if (this.form.id != null) {
            updateInformation(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addInformation(this.form).then(response => {
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
      this.$confirm(
        '是否确认删除采购订单跟踪信息编号为"' + ids + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }
      )
        .then(function() {
          return delInformation(ids);
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
      this.$confirm("是否确认导出所有采购订单跟踪信息数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(function() {
          return exportInformation(queryParams);
        })
        .then(response => {
          this.download(response.msg);
        })
        .catch(function() {});
    },
    toggleQuery() {
      this.queryPattern = !this.queryPattern;
    },

    requestSupplier(supplier) {
      getSupplierInformation(supplier).then(resolve => {
        if (resolve.code == 200) {
          this.relateSupplier = resolve.data && resolve.data.rows;
        }
      });
    },

    chooseSupplier(supplierName) {
      this.form.supplier = supplierName;
      this.relateSupplier = [];
    }
  }
};
</script>

<style scoped>
.supplierDiv {
  position: absolute;
  background: white;
  width: 100%;
  z-index: 1;
  max-height: 150px;
  overflow: auto;
}
.supplierText {
  cursor: pointer;
  height: 30px;
  padding-left: 18px;
  line-height: 30px;
}

.chooseSupplier {
  cursor: pointer;
  height: 30px;
  padding-left: 18px;
  background: #e0e0e0;
  line-height: 30px;
}
</style>
