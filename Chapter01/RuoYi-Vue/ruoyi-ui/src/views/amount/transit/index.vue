<template>
  <div class="app-container">
    <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="建材" prop="buildingMaterials">
        <el-input
          v-model="queryParams.buildingMaterials"
          placeholder="请输入建材"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="日用品" prop="dailyNecessities">
        <el-input
          v-model="queryParams.dailyNecessities"
          placeholder="请输入日用品"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电器" prop="device">
        <el-input
          v-model="queryParams.device"
          placeholder="请输入电器"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="家具" prop="furniture">
        <el-input
          v-model="queryParams.furniture"
          placeholder="请输入家具"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="厨房卫浴" prop="kitchenBathroom">
        <el-input
          v-model="queryParams.kitchenBathroom"
          placeholder="请输入厨房卫浴"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="灯具" prop="lamps">
        <el-input
          v-model="queryParams.lamps"
          placeholder="请输入灯具"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="软装" prop="softOutfit">
        <el-input
          v-model="queryParams.softOutfit"
          placeholder="请输入软装"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纺织品" prop="textile">
        <el-input
          v-model="queryParams.textile"
          placeholder="请输入纺织品"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="其他" prop="other">
        <el-input
          v-model="queryParams.other"
          placeholder="请输入其他"
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
          v-hasPermi="['amount:transit:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:transit:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:transit:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:transit:export']"
        >导出</el-button>
      </el-col>
      
      <el-col :span="1.5">
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
        >导出</el-button>
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

    <el-table v-loading="loading" :data="transitList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="建材" align="center" prop="buildingMaterials" :formatter="stateFormat" />
      <el-table-column label="日用品" align="center" prop="dailyNecessities" :formatter="stateFormat" />
      <el-table-column label="电器" align="center" prop="device" :formatter="stateFormat" />
      <el-table-column label="家具" align="center" prop="furniture" :formatter="stateFormat" />
      <el-table-column label="厨房卫浴" align="center" prop="kitchenBathroom" :formatter="stateFormat" />
      <el-table-column label="灯具" align="center" prop="lamps" :formatter="stateFormat" />
      <el-table-column label="软装" align="center" prop="softOutfit" :formatter="stateFormat" />
      <el-table-column label="纺织品" align="center" prop="textile" :formatter="stateFormat" />
      <el-table-column label="其他" align="center" prop="other" :formatter="stateFormat" />
      <el-table-column label="合计金额" align="center" prop="totalAmount" :formatter="stateFormat" />
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
            v-hasPermi="['amount:transit:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:transit:remove']"
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

    <!-- 添加或修改在途物资对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="建材" prop="buildingMaterials" required >
          <el-input v-model="form.buildingMaterials" placeholder="请输入建材的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="日用品" prop="dailyNecessities" required >
          <el-input v-model="form.dailyNecessities" placeholder="请输入日用品的在途物资金额，单位：元" />
        </el-form-item>
       
        <el-form-item label="电器" prop="device" required >
          <el-input v-model="form.device" placeholder="请输入电器的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="家具" prop="furniture" required >
          <el-input v-model="form.furniture" placeholder="请输入家具的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="厨房卫浴" prop="kitchenBathroom" required >
          <el-input v-model="form.kitchenBathroom" placeholder="请输入厨房卫浴的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="灯具" prop="lamps" required >
          <el-input v-model="form.lamps" placeholder="请输入灯具的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="软装" prop="softOutfit" required >
          <el-input v-model="form.softOutfit" placeholder="请输入软装的在途物资金额，单位：元" />
        </el-form-item>

        <el-form-item label="纺织品" prop="textile" required >
          <el-input v-model="form.textile" placeholder="请输入纺织品的在途物资金额，单位：元" />
        </el-form-item>
        
        <el-form-item label="其他" prop="other" required >
          <el-input v-model="form.other" placeholder="请输入其他的在途物资金额，单位：元" />
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
import { listTransit, getTransit, delTransit, addTransit, updateTransit, exportTransit } from "@/api/amount/transit";

export default {
  name: "Transit",
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
        buildingMaterials: null,
        dailyNecessities: null,
        device: null,
        furniture: null,
        kitchenBathroom: null,
        lamps: null,
        softOutfit: null,
        textile: null,
        other: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
          buildingMaterials: [
            { required: true, message: '请输入建材的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          dailyNecessities: [
            { required: true, message: '请输入日用品的在途物资金额，单位：元', trigger: 'blur' }             
          ] ,
          device: [
            { required: true, message: '请输入电器的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          furniture: [
            { required: true, message: '请输入家具的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          kitchenBathroom: [
            { required: true, message: '请输入厨房卫浴的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          lamps: [
            { required: true, message: '请输入灯具的在途物资金额，单位：元', trigger: 'blur' }             
          ] ,
          softOutfit: [
            { required: true, message: '请输入软装的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          textile: [
            { required: true, message: '请输入纺织品的在途物资金额，单位：元', trigger: 'blur' }             
          ],
          other: [
            { required: true, message: '请输入其他的在途物资金额，单位：元', trigger: 'blur' }             
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
        buildingMaterials: null,
        dailyNecessities: null,
        device: null,
        furniture: null,
        kitchenBathroom: null,
        lamps: null,
        softOutfit: null,
        textile: null,
        other: null,
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
      this.title = "添加在途物资";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTransit(id).then(response => {
        this.form = response.data;

        // 修改数据时，乘以 10000
        //this.form.buildingMaterials = this.form.buildingMaterials * 10000;
        //this.form.dailyNecessities = this.form.dailyNecessities * 10000;
        //this.form.device = this.form.device * 10000;
        //this.form.furniture = this.form.furniture * 10000;
        //this.form.kitchenBathroom = this.form.kitchenBathroom * 10000;
        //this.form.lamps = this.form.lamps * 10000;
        //this.form.softOutfit = this.form.softOutfit * 10000;
        //this.form.textile = this.form.textile * 10000;
        //this.form.other = this.form.other * 10000;

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
          //const dailyNecessitiesFmt = this.keepTwoDecimal( this.form.dailyNecessities / 10000 );
          //this.form.dailyNecessities = dailyNecessitiesFmt ;
          //const deviceFmt = this.keepTwoDecimal( this.form.device / 10000 );
          //this.form.device = deviceFmt ;
          //const furnitureFmt = this.keepTwoDecimal( this.form.furniture / 10000 );
          //this.form.furniture = furnitureFmt ;
          //const kitchenBathroomFmt = this.keepTwoDecimal( this.form.kitchenBathroom / 10000 );
          //this.form.kitchenBathroom = kitchenBathroomFmt ;
          //const lampsFmt = this.keepTwoDecimal( this.form.lamps / 10000 );
          //this.form.lamps = lampsFmt ;
          //const softOutfitFmt = this.keepTwoDecimal( this.form.softOutfit / 10000 );
          //this.form.softOutfit = softOutfitFmt ;
          //const textileFmt = this.keepTwoDecimal( this.form.textile / 10000 );
          //this.form.textile = textileFmt ;
          //const otherFmt = this.keepTwoDecimal( this.form.other / 10000 );
          //this.form.other = otherFmt ;

          // 去除输入的特殊字符，比如 ,
          const buildingMaterialsFmt = String(this.form.buildingMaterials).replace(",","");
          this.form.buildingMaterials = buildingMaterialsFmt ;
          const dailyNecessitiesFmt = String(this.form.dailyNecessities).replace(",","");
          this.form.dailyNecessities = dailyNecessitiesFmt ;
          const deviceFmt = String(this.form.device).replace(",","");
          this.form.device = deviceFmt ;
          const furnitureFmt = String(this.form.furniture).replace(",","");
          this.form.furniture = furnitureFmt ;
          const kitchenBathroomFmt = String(this.form.kitchenBathroom).replace(",","");
          this.form.kitchenBathroom = kitchenBathroomFmt ;
          const lampsFmt = String(this.form.lamps).replace(",","");
          this.form.lamps = lampsFmt ;
          const softOutfitFmt = String(this.form.softOutfit).replace(",","");
          this.form.softOutfit = softOutfitFmt ;
          const textileFmt = String(this.form.textile).replace(",","");
          this.form.textile = textileFmt ;
          const otherFmt = String(this.form.other).replace(",","");
          this.form.other = otherFmt ;

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
        alert('传递参数错误，请检查！');
        return false;
        }
        result = Math.round(num * 100) / 100;
        return result;
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除在途物资编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTransit(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有在途物资数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTransit(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
