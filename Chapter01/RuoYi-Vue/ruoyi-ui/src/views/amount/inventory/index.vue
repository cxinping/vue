<template>
  <div class="app-container">
    <!-- 
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="合计金额汇总" prop="sumSaleableInventoryAmount">
        <el-input
          v-model="queryParams.sumSaleableInventoryAmount"
          placeholder="请输入合计金额汇总"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="不可销售库存金额汇总" prop="sumUnsaleableInventoryAmount">
        <el-input
          v-model="queryParams.sumUnsaleableInventoryAmount"
          placeholder="请输入不可销售库存金额汇总"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合计金额汇总" prop="sumInventoryAmount">
        <el-input
          v-model="queryParams.sumInventoryAmount"
          placeholder="请输入合计金额汇总"
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
          v-hasPermi="['amount:sum:add']"
        >新增</el-button>
      </el-col>
      <!-- 
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['amount:sum:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['amount:sum:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['amount:sum:export']"
        >导出</el-button>
      </el-col>
      -->
      <el-col :span="1.5">
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
        >搜索</el-button>
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

    <el-table
    :data="sumList"
    style="width: 100%;margin-bottom: 20px;"
    row-key="id"
    border
    default-expand-all
    :tree-props="{children: 'inventoryDetails', hasChildren: 'hasChildren'}">
    <el-table-column
      prop="product"
      label="产品名称"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="inventoryAmount"
      label="合计金额"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="saleableInventoryAmount"
      label="可销售库存金额"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="unsaleableInventoryAmount"
      label="不可销售库存金额">
    </el-table-column>
    <el-table-column
      prop="updateTime"
      label="更新时间">
    </el-table-column>
     <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
          v-if="scope.row.inventoryDetails"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['amount:sum:edit']"
          >修改</el-button>
          <el-button
            v-if="scope.row.inventoryDetails"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:sum:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
  </el-table>
    
<!--
    <el-table v-loading="loading" :data="sumList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
       <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="产品名称" align="center" prop="sumSaleableInventoryAmount" />
      <el-table-column label="可销售库存金额汇总" align="center" prop="sumSaleableInventoryAmount" />
      <el-table-column label="不可销售库存金额汇总" align="center" prop="sumUnsaleableInventoryAmount" />
      <el-table-column label="合计金额汇总" align="center" prop="sumInventoryAmount" />

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
            v-hasPermi="['amount:sum:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['amount:sum:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    -->
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-table
        :data="newTable"
        border
        style="width: 100%">
        <el-table-column
          prop="product"
          label="产品"
          width="180">
        </el-table-column>
        <el-table-column
          label="可销售库存金额"
         >
          <template slot-scope="scope">
            <el-input v-model="scope.row.saleableInventoryAmount" placeholder="请输入合计金额汇总,单位：元" />
          </template>
        </el-table-column>
        <el-table-column
          label="不可销售库存金额">
          <template slot-scope="scope">
            <el-input v-model="scope.row.unsaleableInventoryAmount" placeholder="请输入合计金额汇总,单位：元" />
          </template>
        </el-table-column>
        <el-table-column
          label="合计金额">
          <template slot-scope="scope">
            <div>{{parseFloat(scope.row.saleableInventoryAmount || 0) + parseFloat(scope.row.unsaleableInventoryAmount || 0)}}</div>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    

    <!-- 添加或修改库存汇总对话框 -->
    <!-- <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合计金额汇总" prop="sumSaleableInventoryAmount">
          <el-input v-model="form.sumSaleableInventoryAmount" placeholder="请输入合计金额汇总" />
        </el-form-item>
        <el-form-item label="不可销售库存金额汇总" prop="sumUnsaleableInventoryAmount">
          <el-input v-model="form.sumUnsaleableInventoryAmount" placeholder="请输入不可销售库存金额汇总" />
        </el-form-item>
        <el-form-item label="合计金额汇总" prop="sumInventoryAmount">
          <el-input v-model="form.sumInventoryAmount" placeholder="请输入合计金额汇总" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog> -->
  </div>
</template>

<script>
import { listSum, getSum, delSum, addSum, updateSum, exportSum } from "@/api/amount/inventory";

export default {
  name: "Sum",
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
      // 库存汇总表格数据
      sumList: [],
      newTabelTip: "",
      newTable: [{
        product: "建材",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "日用品",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "电器",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "家具",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "厨房卫浴",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "灯具",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "软装",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "纺织品",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
      },{
        product: "其它",
        saleableInventoryAmount: "",
        unsaleableInventoryAmount: ""
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
        sumSaleableInventoryAmount: null,
        sumUnsaleableInventoryAmount: null,
        sumInventoryAmount: null,
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
    /** 查询库存汇总列表 */
    getList() {
      this.loading = true;
      listSum(this.queryParams).then(response => {
        this.sumList = response.rows.map(item => {
          return {
            saleableInventoryAmount: item.sumSaleableInventoryAmount,
            unsaleableInventoryAmount: item.sumUnsaleableInventoryAmount,
            inventoryAmount: item.sumInventoryAmount,
            updateTime: item.updateTime,
            ...item
          }
        });
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
        sumSaleableInventoryAmount: null,
        sumUnsaleableInventoryAmount: null,
        sumInventoryAmount: null,
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
      this.title = "添加库存汇总";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.open = true;
      this.modify = true;
      console.log(row)
      this.newTableId = row.id;
      this.newTable = row.inventoryDetails.map(item => ({
        ...item,
        unsaleableInventoryAmount: item.unsaleableInventoryAmount * 10000,
        saleableInventoryAmount: item.saleableInventoryAmount * 10000
      }))
      // this.newTable = /
      // const id = row.id || this.ids
      // getSum(id).then(response => {
      //   this.form = response.data;
      //   this.open = true;
      //   this.title = "修改库存汇总";
      // });
    },

    
    /** 提交按钮 */
    submitForm() {
      console.log(this.newTable );
      let sumSaleableInventoryAmount = 0;
      let sumUnsaleableInventoryAmount = 0;
      let sumInventoryAmount = 0

      const errItem = this.newTable.filter(item => item.saleableInventoryAmount === '' || item.unsaleableInventoryAmount === "" )[0]
      if (errItem) {
        this.newTabelTip = `${errItem.product}的${errItem.saleableInventoryAmount ? '不可销售库存金额' : '可销售库存金额'}不能为空`
        this.$message(this.newTabelTip);
        return
      }

      this.newTable.forEach(item => {
        sumSaleableInventoryAmount += parseFloat(item.saleableInventoryAmount);
        sumUnsaleableInventoryAmount += parseFloat(item.unsaleableInventoryAmount);
      })
  if (!this.modify) {
     addSum(
          {
                "product": "产品",
                "sumSaleableInventoryAmount": sumSaleableInventoryAmount / 10000,
                "sumUnsaleableInventoryAmount": sumUnsaleableInventoryAmount / 10000,
                "sumInventoryAmount": (sumSaleableInventoryAmount + sumUnsaleableInventoryAmount) / 10000,
                "inventoryDetails": this.newTable.map((item, index) => ({
                  ...item,
                  orderNum: index + 1,
                  saleableInventoryAmount: item.saleableInventoryAmount / 10000,
                  unsaleableInventoryAmount: item.unsaleableInventoryAmount / 10000,
                  inventoryAmount: parseFloat(item.saleableInventoryAmount  / 10000) + parseFloat( item.unsaleableInventoryAmount / 10000)
                }))
            }
           ).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
                this.newTabelTip = ""
                this.newTable=[{
                    product: "建材",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "日用品",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "电器",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "家具",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "厨房卫浴",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "灯具",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "软装",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "纺织品",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "其它",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  }
                  
                  
                  ]
              }
           })
  } else {
    
     updateSum(
          {     "id": this.newTableId,
                 "product": "产品",
                "sumSaleableInventoryAmount": sumSaleableInventoryAmount / 10000,
                "sumUnsaleableInventoryAmount": sumUnsaleableInventoryAmount / 10000,
                "sumInventoryAmount": (sumSaleableInventoryAmount + sumUnsaleableInventoryAmount) / 10000,
                "inventoryDetails": this.newTable.map((item, index)  => ({
                  ...item,
                  orderNum: index + 1,
                  saleableInventoryAmount: item.saleableInventoryAmount / 10000,
                  unsaleableInventoryAmount: item.unsaleableInventoryAmount / 10000,
                  inventoryAmount: parseFloat(item.saleableInventoryAmount  / 10000) + parseFloat( item.unsaleableInventoryAmount / 10000)
                }))
            }
           ).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
                this.newTabelTip = ""
                this.newTable=[{
                    product: "建材",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "日用品",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "电器",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "家具",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "厨房卫浴",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "灯具",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "软装",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "纺织品",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  },{
                    product: "其它",
                    saleableInventoryAmount: "",
                    unsaleableInventoryAmount: ""
                  }]
              }
           })
  }
          

      // this.$refs["form"].validate(valid => {
      //   if (valid) {
      //     if (this.form.id != null) {
      //       updateSum(this.form).then(response => {
      //         if (response.code === 200) {
      //           this.msgSuccess("修改成功");
      //           this.open = false;
      //           this.getList();
      //         }
      //       });
      //     } else {
      //       addSum(this.form).then(response => {
      //         if (response.code === 200) {
      //           this.msgSuccess("新增成功");
      //           this.open = false;
      //           this.getList();
      //         }
      //       });
      //     }
      //   }
      // });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除库存汇总编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSum(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有库存汇总数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportSum(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
