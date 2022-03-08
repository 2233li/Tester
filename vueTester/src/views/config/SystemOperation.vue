<template>
  <div>
    <!-- 搜索 -->
    <div>
      <el-form :model="searchFormData" :inline="true">
        <el-form-item label="系统">
          <el-select v-model="searchFormData.sysId">
            <el-option v-for="(item,index) in sysLists" :label="item.sysName" :value="item.sysId" :key="item.sysId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="实体">
          <el-select v-model="searchFormData.entityId"></el-select>
        </el-form-item>
        <el-form-item label="操作">
          <el-input v-model="searchFormData.operation"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="searchFormData.status">
            <el-option label="有效" value="1"></el-option>
            <el-option label="失效" value="-1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getLists(true)">搜索</el-button>
          <el-button type="info" @click="resetSerchData">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 数据列表 -->
    <div>
      <el-button type="info" plain @click="dialogVisiable=true" style="margin: 5px;">新增</el-button>
      <el-table :data="sysOpetationLists" border>
        <el-table-column label="系统" prop="sysName"></el-table-column>
        <el-table-column label="实体" prop="sysEntity"></el-table-column>
        <el-table-column label="操作" prop="sysOperation"></el-table-column>
        <el-table-column label="支持自动化" prop="isAutoTest">
          <template slot-scope="scope">
          <p v-if="scope.row.isAutoTest==1">是</p>
          <p v-else>否</p>
          </template>
        </el-table-column>
        <el-table-column label="状态" prop="status">
          <template slot-scope="scope">
            <p v-if="scope.row.status==1">有效</p>
            <p v-else>失效</p>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
          <el-button type="primary" plain @click="editForm(scope.$index,scope.row)">编辑</el-button>
          <el-button type="info" plain @click="deleteData(scope.$index,scope.row)">失效</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 分页 -->
    <div>
      <el-pagination :page-size="10"
                     :current-page="searchFormData.currentPage"
                     :total="totalData"
                     @current-change="changePage"
                      ></el-pagination>
    </div>
    <!-- 新增&编辑 弹框 -->
    <div>
      <el-dialog title="新增&编辑" :visible.sync="dialogVisiable">
       <el-form :model="sysOperation" label-width="80px">
         <el-form-item label="系统">
           <el-select v-model="sysOperation.sysName"></el-select>
         </el-form-item>
       </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name:"SystemOperation",
  data(){return{
    totalData:20,
    dialogVisiable:false,
    searchFormData:{currentPage:1},
    sysOpetationLists:[{sysName:"mag",sysEntity:"快手",sysOperation:"下单",isAutoTest:1,status:1}],
    sysOperation:{},
    sysLists:[],
    sysEntityLists:[]
  }},
  created(){
    this.getLists(true)
    this.getSysList()
  },
  watch:{
    'searchFormData.sysId':function(val,oldVal){
     
    }
  },


  methods:{
    // 搜索数据
    getLists(isInitialPage){
      if(isInitialPage) this.searchFormData.currentPage=1
      console.log("搜索数据" + this.searchFormData.currentPage)
    },
    // 重置搜索数据
    resetSerchData(){
      this.searchFormData={currentPage:this.searchFormData.currentPage}
    },
    // 触发编辑数据
    editForm(index,row){
      var newRo=this.deepcopy(row)
      this.sysOperation=row
      this.dialogVisiable=true
      console.log("触发编辑")
    },
    // 失效数据
    deleteData(index,row){
      console.log(失效数据)
    },
    // 保存数据
    // 切换页面
    changePage(currentPage){
      this.searchFormData.currentPage=currentPage
      this.getLists(false);

    },
    //获取系统列表数据
    getSysList(){
      console.log("获取系统列表数据")
      this.sysLists=[{sysName:"mag",sysId:"1"},{sysName:"eb",sysId:"2"}]
    },
    //获取实体列表数据
    getSysEntityList(){
       console.log(获取实体列表数据)
    }

  }
  }
</script>
