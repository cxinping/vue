<template>
  <div class="app-container">
      <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="98px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商" prop="supplier">
        <el-input
          v-model="queryParams.supplier"
          placeholder="请输入供应商"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同签订时间" prop="contractSigningTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.contractSigningTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择合同签订时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="合同结束时间" prop="contractEndTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.contractEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择合同结束时间">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="合同金额" prop="contractAmount">
        <el-input
          v-model="queryParams.contractAmount"
          placeholder="请输入合同金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应付预付款时间" prop="payableTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.payableTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择应付预付款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="应付预付款金额" prop="prepaymentAmountPayable">
        <el-input
          v-model="queryParams.prepaymentAmountPayable"
          placeholder="请输入应付预付款金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已付预付款金额" prop="prepaymentAmountPaid">
        <el-input
          v-model="queryParams.prepaymentAmountPaid"
          placeholder="请输入已付预付款金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应付预付款时间" prop="prepaymentPayableTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.prepaymentPayableTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择应付预付款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="应付预付款金额" prop="prepaymentPayableAmount">
        <el-input
          v-model="queryParams.prepaymentPayableAmount"
          placeholder="请输入应付预付款金额"
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
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['amount:information:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:information:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:information:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:information:export']"
        >导出</el-button>
      </el-col>
       <el-col :span="1.5">
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
        >搜索</el-button>
      </el-col>
      <el-col :span="1.5">        
         <el-tag>页面显示，单位：元</el-tag>               
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

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange"
      border style="width: 100%" >
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="供应商" align="center" prop="supplier" />
      <el-table-column label="合同签订时间" align="center" prop="contractSigningTime" width="130">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractSigningTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同结束时间" align="center" prop="contractEndTime" width="130">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同金额" align="center" prop="contractAmount"  :formatter="stateFormat"  />
      
      <el-table-column label="采购货款"  align="center">   
        <el-table-column label="已付预付款金额" align="center" prop="prepaymentAmountPayable"  :formatter="stateFormat"  />
        <el-table-column label="应付尾款时间" align="center" prop="payableTime" width="130">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.payableTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="应付尾款金额" align="center" prop="prepaymentAmountPaid"  :formatter="stateFormat" />
       
      </el-table-column>

      <!-- 
      <el-table-column label="预付款金额"> 
        <el-table-column label="应付预付款时间" align="center" prop="prepaymentPayableTime" width="130">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.prepaymentPayableTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="应付预付款金额" align="center" prop="prepaymentPayableAmount" />
      </el-table-column>
      -->

      <el-table-column label="更新时间" align="center" prop="createTime" width="130">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>      
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['amount:information:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:information:remove']"
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

    <!-- 添加或修改采购订单跟踪信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-row>
        <el-col :span="12">
          <el-form-item label="项目名称" prop="projectName"   >
            <el-input v-model="form.projectName" placeholder="请输入项目名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="供应商" prop="supplier" required >
            <el-input v-model="form.supplier" placeholder="请输入供应商" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="合同签订时间" prop="contractSigningTime" required >
            <el-date-picker clearable size="small" style="width: 200px"
              v-model="form.contractSigningTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择合同签订时间">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="合同结束时间" prop="contractEndTime" required >
            <el-date-picker clearable size="small" style="width: 200px"
              v-model="form.contractEndTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择合同结束时间">
            </el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
      <el-col :span="12">
          <el-form-item label="合同金额" prop="contractAmount" required >
            <el-input v-model="form.contractAmount" placeholder="请输入合同金额，单位：元" />
          </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="应付尾款时间" prop="payableTime"  >
            <el-date-picker clearable size="small" style="width: 200px"
              v-model="form.payableTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择应付尾款时间">
            </el-date-picker>
          </el-form-item>
      </el-col>
    </el-row>            
    <el-row>
    <el-col :span="12">
      <el-form-item label="已付预付款金额" prop="prepaymentAmountPayable" required >
            <el-input v-model="form.prepaymentAmountPayable" placeholder="请输入已付预付款金额，单位：元" />
        </el-form-item>
    </el-col>
    <el-col :span="12">
         <el-form-item label="应付尾款金额" prop="prepaymentAmountPaid" required >
          <el-input v-model="form.prepaymentAmountPaid" placeholder="请输入应付尾款金额，单位：元" />
        </el-form-item>
    </el-col>
  </el-row>    

  <!-- 
  <el-row>
    <el-col :span="12">
      <el-form-item label="应付预付款时间" prop="prepaymentPayableTime" required >
            <el-date-picker clearable size="small" style="width: 200px"
              v-model="form.prepaymentPayableTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择应付预付款时间">
            </el-date-picker>
          </el-form-item>
    </el-col>
    <el-col :span="12">
         <el-form-item label="应付预付款金额" prop="prepaymentPayableAmount" required >
          <el-input v-model="form.prepaymentPayableAmount" placeholder="请输入应付预付款金额，单位：元" />
        </el-form-item>
    </el-col>
  </el-row>     
  -->

  </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInformation, getInformation, delInformation, addInformation, updateInformation, exportInformation } from "@/api/amount/information";

export default {
  name: "Information",
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
      // 采购订单跟踪信息表格数据
      informationList: [],
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
            { required: true, message: '请输入供应商', trigger: 'blur' }             
          ],
          contractSigningTime: [
            { required: true, message: '请输入合同签订时间', trigger: 'blur' }             
          ] ,
          contractEndTime: [
            { required: true, message: '请输入合同结束时间', trigger: 'blur' }             
          ],
          contractAmount: [
            { required: true, message: '请输入合同金额，单位：元', trigger: 'blur' }             
          ] ,
          /*** 
          payableTime: [
            { required: true, message: '请输入应付尾款时间', trigger: 'blur' }             
          ],*/
          prepaymentAmountPayable: [
            { required: true, message: '请输入已付预付款金额，单位：元', trigger: 'blur' }             
          ],
          prepaymentAmountPaid: [
            { required: true, message: '请输入应付尾款金额，单位：元', trigger: 'blur' }             
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
  },
  methods: {
    stateFormat(row, column, cellValue) {
			cellValue += '';
			if (!cellValue.includes('.')) cellValue += '.';
			return cellValue.replace(/(\d)(?=(\d{3})+\.)/g, function ($0, $1) {
				return $1 + ',';
			}).replace(/\.$/, '');
    },
    
    /** 查询采购订单跟踪信息列表 */
    getList() {
      this.loading = true;
      listInformation(this.queryParams).then(response => {
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
        updateTime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
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
      const id = row.id || this.ids
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
          const contractAmountFmt = String(this.form.contractAmount).replace(",","");
          this.form.contractAmount = contractAmountFmt ;
          const prepaymentAmountPayableFmt = String(this.form.prepaymentAmountPayable).replace(",","");
          this.form.prepaymentAmountPayable = prepaymentAmountPayableFmt ;
          const prepaymentAmountPaidFmt = String(this.form.prepaymentAmountPaid).replace(",","");
          this.form.prepaymentAmountPaid = prepaymentAmountPaidFmt ;

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
        alert('传递参数错误，请检查！');
        return false;
        }
        result = Math.round(num * 100) / 100;
        return result;
    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除采购订单跟踪信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInformation(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有采购订单跟踪信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportInformation(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
