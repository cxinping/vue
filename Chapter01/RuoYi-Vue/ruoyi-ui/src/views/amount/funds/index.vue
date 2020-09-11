<template>
  <div class="app-container">
    <!--
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="招行" prop="merchantsBank">
        <el-input
          v-model="queryParams.merchantsBank"
          placeholder="请输入招行"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="浦发" prop="pufaBank">
        <el-input
          v-model="queryParams.pufaBank"
          placeholder="请输入浦发"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工行" prop="icbcBank">
        <el-input
          v-model="queryParams.icbcBank"
          placeholder="请输入工行"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="有赞" prop="youZan">
        <el-input
          v-model="queryParams.youZan"
          placeholder="请输入有赞"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付宝" prop="alipay">
        <el-input
          v-model="queryParams.alipay"
          placeholder="请输入支付宝"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="京东" prop="jingdong">
        <el-input
          v-model="queryParams.jingdong"
          placeholder="请输入京东"
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
          v-hasPermi="['amount:funds:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:funds:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:funds:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:funds:export']"
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

    <el-table v-loading="loading" :data="fundsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="招行" align="center" prop="merchantsBank" :formatter="stateFormat" />
      <el-table-column label="浦发" align="center" prop="pufaBank" :formatter="stateFormat" />
      <el-table-column label="工行" align="center" prop="icbcBank" :formatter="stateFormat" />
      <el-table-column label="有赞" align="center" prop="youZan" :formatter="stateFormat" />
      <el-table-column label="支付宝" align="center" prop="alipay" :formatter="stateFormat" />
      <el-table-column label="京东" align="center" prop="jingdong" :formatter="stateFormat" />
      <el-table-column label="合计金额" align="center" prop="totalAmount" :formatter="stateFormat" />

      <el-table-column label="更新时间" align="center" prop="createTime" width="180">
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
            v-hasPermi="['amount:funds:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:funds:remove']"
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

    <!-- 添加或修改可用资金对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="招行" prop="merchantsBank" required >
          <el-input v-model="form.merchantsBank" placeholder="请输入招行的可用资金余额，单位：元" type="number" clearable/>
        </el-form-item>
        <el-form-item label="浦发" prop="pufaBank" required >
          <el-input v-model="form.pufaBank" placeholder="请输入浦发的可用资金余额，单位：元" type="number" clearable/>
        </el-form-item>
        <el-form-item label="工行" prop="icbcBank" required >
          <el-input v-model="form.icbcBank" placeholder="请输入工行的可用资金余额，单位：元" type="number" clearable/>
        </el-form-item>
        <el-form-item label="有赞" prop="youZan" required >
          <el-input v-model="form.youZan" placeholder="请输入有赞的可用资金余额，单位：元" type="number" clearable/>
        </el-form-item>
        <el-form-item label="支付宝" prop="alipay" required >
          <el-input v-model="form.alipay" placeholder="请输入支付宝的可用资金余额，单位：元" type="number" clearable/>
        </el-form-item>
        <el-form-item label="京东" prop="jingdong" required >
          <el-input v-model="form.jingdong" placeholder="请输入京东的可用资金余额，单位：元" type="number" clearable/>
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
import { listFunds, getFunds, delFunds, addFunds, updateFunds, exportFunds } from "@/api/amount/funds";

export default {
  name: "Funds",
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
      // 可用资金表格数据
      fundsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        merchantsBank: null,
        pufaBank: null,
        icbcBank: null,
        youZan: null,
        alipay: null,
        jingdong: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
          merchantsBank: [
            { required: true, message: '请输入招行的可用资金余额，单位：元', trigger: 'blur' }             
          ],
          pufaBank: [
            { required: true, message: '请输入浦发的可用资金余额，单位：元', trigger: 'blur' }             
          ],
          icbcBank: [
            { required: true, message: '请输入工行的可用资金余额，单位：元', trigger: 'blur' }             
          ],
          youZan: [
            { required: true, message: '请输入有赞的可用资金余额，单位：元', trigger: 'blur' }             
          ],
          alipay: [
            { required: true, message: '请输入支付宝的可用资金余额，单位：元', trigger: 'blur' }             
          ],
          jingdong: [
            { required: true, message: '请输入京东的可用资金余额，单位：元', trigger: 'blur' }             
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

    /** 查询可用资金列表 */
    getList() {
      this.loading = true;
      listFunds(this.queryParams).then(response => {
        this.fundsList = response.rows;
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
        merchantsBank: null,
        pufaBank: null,
        icbcBank: null,
        youZan: null,
        alipay: null,
        jingdong: null,
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
      this.title = "添加可用资金";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFunds(id).then(response => {
        this.form = response.data;

        // 修改数据时，乘以 10000
        //this.form.merchantsBank = this.form.merchantsBank * 10000;
        //this.form.pufaBank = this.form.pufaBank * 10000;
        //this.form.icbcBank = this.form.icbcBank * 10000;
        //this.form.youZan = this.form.youZan * 10000;
        //this.form.alipay = this.form.alipay * 10000;
        //this.form.jingdong = this.form.jingdong * 10000;
        
        this.open = true;
        this.title = "修改可用资金";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 对输入金额进行转换，保留小数点后2位
          //const merchantsBankFmt = this.keepTwoDecimal( this.form.merchantsBank / 10000 );
          //this.form.merchantsBank = merchantsBankFmt ;
          //const pufaBankFmt = this.keepTwoDecimal( this.form.pufaBank / 10000 );
          //this.form.pufaBank = pufaBankFmt ;
          //const icbcBankFmt = this.keepTwoDecimal( this.form.icbcBank / 10000 );
          //this.form.icbcBank = icbcBankFmt ;
          //const youZanFmt = this.keepTwoDecimal( this.form.youZan / 10000 );
          //this.form.youZan = youZanFmt ;   
          //const alipayFmt = this.keepTwoDecimal( this.form.alipay / 10000 );
          //this.form.alipay = alipayFmt ;
          //const jingdongFmt = this.keepTwoDecimal( this.form.jingdong / 10000 );
          //this.form.jingdong = jingdongFmt ;   

          // 去除输入的特殊字符，比如 ,
          const merchantsBankFmt = String(this.form.merchantsBank).replace(",","");
          this.form.merchantsBank = merchantsBankFmt ;
          const pufaBankFmt = String(this.form.pufaBank).replace(",","");
          this.form.pufaBank = pufaBankFmt ;
          const icbcBankFmt = String(this.form.icbcBank).replace(",","");
          this.form.icbcBank = icbcBankFmt ;
          const youZanFmt = String(this.form.youZan).replace(",","");
          this.form.youZan = youZanFmt ;
          const alipayFmt = String(this.form.alipay).replace(",","");
          this.form.alipay = alipayFmt ;
          const jingdongFmt = String(this.form.jingdong).replace(",","");
          this.form.jingdong = jingdongFmt ;


          if (this.form.id != null) {
            updateFunds(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addFunds(this.form).then(response => {
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
      this.$confirm('是否确认删除可用资金编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delFunds(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有可用资金数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportFunds(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
