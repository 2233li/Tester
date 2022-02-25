<template>
  <div>
    <!-- 搜索框 -->
    <div>
      <el-form :inline="true">
        <el-form-item label="系统名称">
          <el-input v-model="formSearch.SystemName"></el-input>
        </el-form-item>
        <el-form-item label="系统状态">
        <el-select v-model="formSearch.SystemStatus">
          <el-option label="有效" value="1"></el-option>
          <el-option label="失效" value="-1"></el-option>
        </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getSystemConfig(1)">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 数据列表框 -->
    <div>
      <el-button type="info" @click="dialogVisiable=true" >新增</el-button>
      <el-table :data="SystemLists" border>
        <el-table-column label="系统id" prop="systemId"></el-table-column>
        <el-table-column label="系统名称" prop="systemName"></el-table-column>
        <el-table-column label="系统状态" prop="systemStatus" >
          <div v-if="systemStatus&&systemStatus==1">有效</div>
          <div v-else>无效</div>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
          <el-button type="primary" plain @click="editSystemConfig(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" plain>失效</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--分页-->
    <div>
      <el-pagination :page-size="formSearch.pagesize"
                     :current-page="formSearch.currentPage"
                     :total="SystemLists.length"
                     @current-change="changePage"></el-pagination>
    </div>
    <!-- 新增&编辑-->
    <div>
      <el-dialog :visible.sync="dialogVisiable"
                 title="新增&编辑">
      <el-form label-width="80px">
        <el-form-item label="系统id" v-if="systemConfig.id">
          <el-input v-model="systemConfig.id"></el-input>
        </el-form-item>
        <el-form-item label="系统名称">
          <el-input v-model="systemConfig.name"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="saveSystemConfig">保存</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  export default{
    name:"Systemconfig",
    data(){return{
      formSearch:{systemStatus:"1",currentPage:1,pagesize:1,},
      SystemLists:[{"systemId":1,"systemName":"mag","systemStatus":1}],
      systemConfig:{},
      dialogVisiable:false
    }},
    created(){
      this.getSystemConfig(1)
    },

    methods:{
      getSystemConfig(currentPage){
        this.formSearch.currentPage=currentPage
        console.log(this.formSearch)

      },
      changePage(currentPage){
        this.getSystemConfig(currentPage)
      },
      saveSystemConfig(){
        console.log("保存数据")
      },
      editSystemConfig(index,row){
        this.dialogVisiable=true,
        this.systemConfig=row
        
      }
    }
  }
</script>
