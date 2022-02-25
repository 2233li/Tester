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
      <el-button type="info">新增</el-button>
      <el-table>
        <el-table-column label="系统id"></el-table-column>
        <el-table-column label="系统名称"></el-table-column>
        <el-table-column label="操作">
          <el-button>编辑</el-button>
          <el-button>失效</el-button>
        </el-table-column>
      </el-table>
    </div>
    <!--分页-->
    <div>
      <el-pagination :page-size="pagesize"
                     :current-page="currentPage"
                     :total="SystemLists.length"
                     @current-change="changePage"></el-pagination>
    </div>
    <!-- 新增&编辑-->
    <div>
      <el-form></el-form>
    </div>
  </div>
</template>
<script>
  export default{
    name:"Systemconfig",
    data(){return{
      currentPage:1,
      pagesize:1,
      formSearch:{SystemStatus:"1"},
      SystemLists:[1,2,3]
    }},
    created(){
      this.getSystemConfig(1)
    },

    methods:{
      getSystemConfig(currentPage){
        this.currentPage=currentPage
        console.log("getSystemConfig" +currentPage)
      },
      changePage(currentPage){
        this.getSystemConfig(currentPage)
      },
      saveSystemConfig(){}
    }
  }
</script>
