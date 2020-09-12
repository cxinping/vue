<template>
  <div class="app-container">
    <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="贷款授信金额" prop="loanCreditAmount">
        <el-input
          v-model="queryParams.loanCreditAmount"
          placeholder="请输入贷款授信金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="贷款授信余额" prop="loanCreditBalance">
        <el-input
          v-model="queryParams.loanCreditBalance"
          placeholder="请输入贷款授信余额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="剩余可使用额度" prop="loanCreditRemaining">
        <el-input
          v-model="queryParams.loanCreditRemaining"
          placeholder="请输入剩余可使用额度"
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
          v-hasPermi="['amount:usage:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:usage:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:usage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:usage:export']"
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

    <el-table v-loading="loading" :data="usageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="贷款授信金额" align="center" prop="loanCreditAmount" :formatter="stateFormat"  />
      <el-table-column label="贷款使用金额" align="center" prop="loanCreditBalance" :formatter="stateFormat"  />
      <el-table-column label="剩余可使用额度" align="center" prop="loanCreditRemaining" :formatter="stateFormat"  />
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
            v-hasPermi="['amount:usage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:usage:remove']"
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

    <!-- 添加或修改贷款使用对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="贷款授信金额" prop="loanCreditAmount" required >
          <el-input v-model="form.loanCreditAmount" placeholder="请输入贷款授信金额，单位：元" 
            type="number" clearable />
        </el-form-item>
        <el-form-item label="贷款使用金额" prop="loanCreditBalance" required >
          <el-input v-model="form.loanCreditBalance" placeholder="请输入贷款使用金额，单位：元" 
           type="number" clearable />
        </el-form-item>
        <!--
        <el-form-item label="剩余可使用额度" prop="loanCreditRemaining">
          <el-input v-model="form.loanCreditRemaining" placeholder="请输入剩余可使用额度" />
        </el-form-item>
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
import { listUsage, getUsage, delUsage, addUsage, updateUsage, exportUsage } from "@/api/amount/usage";

export default {
  name: "Usage",
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
      // 贷款使用表格数据
      usageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        loanCreditAmount: null,
        loanCreditBalance: null,
        loanCreditRemaining: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
          loanCreditAmount: [
            { required: true, message: '请输入贷款授信金额，单位：元', trigger: 'blur' }             
          ],
          loanCreditBalance: [
            { required: true, message: '请输入贷款使用金额，单位：元', trigger: 'blur' }             
          ]

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

    /** 查询贷款使用列表 */
    getList() {
      this.loading = true;
      listUsage(this.queryParams).then(response => {
        this.usageList = response.rows;
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
        loanCreditAmount: null,
        loanCreditBalance: null,
        loanCreditRemaining: null,
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
      this.title = "添加贷款使用";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUsage(id).then(response => {
        this.form = response.data;

        // 修改数据时，乘以 10000
        //this.form.loanCreditAmount = this.form.loanCreditAmount * 10000;
        //this.form.loanCreditBalance = this.form.loanCreditBalance * 10000;

        this.open = true;
        this.title = "修改贷款使用";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {

          // 对输入金额进行转换，保留小数点后2位
          //const loanCreditAmountFmt = this.keepTwoDecimal( this.form.loanCreditAmount / 10000 );
          //this.form.loanCreditAmount = loanCreditAmountFmt ;
          //const loanCreditBalanceFmt = this.keepTwoDecimal( this.form.loanCreditBalance / 10000 );
          //this.form.loanCreditBalance = loanCreditBalanceFmt ;
          //const loanCreditRemainingFmt = this.keepTwoDecimal(this.form.loanCreditAmount - this.form.loanCreditBalance) ;
          //this.form.loanCreditRemaining = loanCreditRemainingFmt;
          //this.form.loanCreditRemaining = this.keepTwoDecimal(this.form.loanCreditAmount - this.form.loanCreditBalance) 

          // 去除输入的特殊字符，比如 ,
          const loanCreditAmountFmt = String(this.form.loanCreditAmount).replace(",","");
          this.form.loanCreditAmount = loanCreditAmountFmt ;
          const loanCreditBalanceFmt = String(this.form.loanCreditBalance).replace(",","");
          this.form.loanCreditBalance = loanCreditBalanceFmt ;
          this.form.loanCreditRemaining = this.keepTwoDecimal(this.form.loanCreditAmount - this.form.loanCreditBalance) 



          if (this.form.id != null) {
            updateUsage(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addUsage(this.form).then(response => {
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
      this.$confirm('是否确认删除贷款使用编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUsage(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有贷款使用数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportUsage(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
