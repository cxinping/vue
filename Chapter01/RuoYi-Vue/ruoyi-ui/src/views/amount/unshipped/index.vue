<template>
  <div class="app-container">
    <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="有赞" prop="youzan">
        <el-input
          v-model="queryParams.youzan"
          placeholder="请输入有赞"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="淘宝" prop="taobao">
        <el-input
          v-model="queryParams.taobao"
          placeholder="请输入淘宝"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="天猫" prop="tianmao">
        <el-input
          v-model="queryParams.tianmao"
          placeholder="请输入天猫"
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
      <el-form-item label="合计金额" prop="totalAmount">
        <el-input
          v-model="queryParams.totalAmount"
          placeholder="请输入合计金额"
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
          v-hasPermi="['amount:unshipped:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:unshipped:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:unshipped:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:unshipped:export']"
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

    <el-table v-loading="loading" :data="unshippedList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
     <!--  <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="有赞" align="center" prop="youzan"  :formatter="stateFormat" />
      <el-table-column label="淘宝" align="center" prop="taobao"  :formatter="stateFormat" />
      <el-table-column label="天猫" align="center" prop="tianmao"  :formatter="stateFormat" />
      <el-table-column label="京东" align="center" prop="jingdong"  :formatter="stateFormat" />
      <el-table-column label="合计金额" align="center" prop="totalAmount"  :formatter="stateFormat" />

      <el-table-column label="更新时间" align="center" prop="updateTime" width="130">
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
            v-hasPermi="['amount:unshipped:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:unshipped:remove']"
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

    <!-- 添加或修改已购买未发货对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="有赞" prop="youzan" required>
          <el-input v-model="form.youzan" placeholder="请输入有赞已购买未发货金额，单位：元" />
        </el-form-item>
        <el-form-item label="淘宝" prop="taobao" required>
          <el-input v-model="form.taobao" placeholder="请输入淘宝已购买未发货金额，单位：元" />
        </el-form-item>
        <el-form-item label="天猫" prop="tianmao" required>
          <el-input v-model="form.tianmao" placeholder="请输入天猫已购买未发货金额，单位：元" />
        </el-form-item>
        <el-form-item label="京东" prop="jingdong" required >
          <el-input v-model="form.jingdong" placeholder="请输入京东已购买未发货金额，单位：元" />
        </el-form-item>
        <!-- 
        <el-form-item label="合计金额" prop="totalAmount">
          <el-input v-model="form.totalAmount" placeholder="请输入合计金额" />
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
import { listUnshipped, getUnshipped, delUnshipped, addUnshipped, updateUnshipped, exportUnshipped } from "@/api/amount/unshipped";

export default {
  name: "Unshipped",
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
      // 已购买未发货表格数据
      unshippedList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        youzan: null,
        taobao: null,
        tianmao: null,
        jingdong: null,
        totalAmount: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        youzan: [
            { required: true, message: '请输入有赞已购买未发货金额，单位：元', trigger: 'blur' }             
          ],
          taobao: [
            { required: true, message: '请输入淘宝已购买未发货金额，单位：元', trigger: 'blur' }             
          ],
          tianmao: [
            { required: true, message: '请输入天猫已购买未发货金额，单位：元', trigger: 'blur' }             
          ],
          jingdong: [
            { required: true, message: '请输入京东已购买未发货金额，单位：元', trigger: 'blur' }             
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

    /** 查询已购买未发货列表 */
    getList() {
      this.loading = true;
      listUnshipped(this.queryParams).then(response => {
        this.unshippedList = response.rows;
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
        youzan: null,
        taobao: null,
        tianmao: null,
        jingdong: null,
        totalAmount: null,
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
      this.title = "添加已购买未发货";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUnshipped(id).then(response => {
        this.form = response.data;

        // 修改数据时，乘以 10000
        //this.form.youzan = this.form.youzan * 10000;
        //this.form.taobao = this.form.taobao * 10000;
        //this.form.tianmao = this.form.tianmao * 10000;
        //this.form.jingdong = this.form.jingdong * 10000;

        this.open = true;
        this.title = "修改已购买未发货";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 对输入金额进行转换，保留小数点后2位
          //const youzanFmt = this.keepTwoDecimal( this.form.youzan / 10000 );
          //this.form.youzan = youzanFmt ;
          //const taobaoFmt = this.keepTwoDecimal( this.form.taobao / 10000 );
          //this.form.taobao = taobaoFmt ;
          //const tianmaoFmt = this.keepTwoDecimal( this.form.tianmao / 10000 );
          //this.form.tianmao = tianmaoFmt ;
          //const jingdongFmt = this.keepTwoDecimal( this.form.jingdong / 10000 );
          //this.form.jingdong = jingdongFmt ;
          //this.form.totalAmount = this.keepTwoDecimal(youzanFmt + taobaoFmt + tianmaoFmt + jingdongFmt);
          //this.form.totalAmount = parseFloat(this.form.youzan) + parseFloat(this.form.taobao)
          //     + parseFloat(this.form.tianmao) + parseFloat(this.form.jingdong) ;

           // 去除输入的特殊字符，比如 ,
          const youzanFmt = String(this.form.youzan).replace(",","");
          this.form.youzan = youzanFmt ;
          const taobaoFmt = String(this.form.taobao).replace(",","");
          this.form.taobao = taobaoFmt ;
          const tianmaoFmt = String(this.form.tianmao).replace(",","");
          this.form.tianmao = tianmaoFmt ;
          const jingdongFmt = String(this.form.jingdong).replace(",","");
          this.form.jingdong = jingdongFmt ;
          this.form.totalAmount = parseFloat(this.form.youzan) + parseFloat(this.form.taobao)
               + parseFloat(this.form.tianmao) + parseFloat(this.form.jingdong) ;


          if (this.form.id != null) {
            updateUnshipped(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addUnshipped(this.form).then(response => {
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
      this.$confirm('是否确认删除已购买未发货编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUnshipped(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有已购买未发货数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportUnshipped(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
