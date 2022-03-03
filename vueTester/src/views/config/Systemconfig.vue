<template>
  <div>
    <!-- 搜索框 -->
    <div>
      <el-form :inline="true" :model="formSearch" >
        <el-form-item label="系统名称">
          <el-input v-model="formSearch.systemName"></el-input>
        </el-form-item>
        <el-form-item label="系统状态">
        <el-select v-model="formSearch.systemStatus" :clearable=true>
          <el-option label="有效" value=1></el-option>
          <el-option label="失效" value=-1 ></el-option>
        </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getSystemConfig(true)">查询</el-button>
          <el-button  type="info" @click="initSearchForm(true)">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 数据列表框 -->
    <div>
      <el-button type="info" @click="dialogVisiable=true" style="margin:5px;" >新增</el-button>
      <el-table :data="systemLists" border>
        <el-table-column label="系统id" prop="systemId"></el-table-column>
        <el-table-column label="系统名称" prop="systemName"></el-table-column>
        <el-table-column label="系统状态" prop="systemStatus" >
          <template slot-scope="scope">
            <p v-if="scope.row.systemStatus==1">有效</p>
            <p v-else>失效</p>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
          <el-button type="primary" plain @click="editSystemConfig(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" plain @click="delecteSystemconig(scope.$index,scope.row)" >失效</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--分页-->
    <div>
      <el-pagination :page-size="formSearch.pagesize"
                     :current-page="formSearch.currentPage"
                     :total="systemLists.length"
                     @current-change="changePage"></el-pagination>
    </div>
    <!-- 新增&编辑-->
    <div>
      <el-dialog :visible.sync="dialogVisiable" @closed="beforeCloDialog('systemConfig')"
                 title="新增&编辑">
      <el-form label-width="80px" :model="systemConfig" ref="systemConfig" :rules="systemConfigRules" >
        <el-form-item label="系统id" v-if="systemConfig.systemId">
          <el-input v-model="systemConfig.systemId" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="系统名称" prop="systemName">
          <el-input v-model="systemConfig.systemName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="saveSystemConfig('systemConfig')">保存</el-button>
          <el-button @click="dialogVisiable=false">取消</el-button>
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
      formSearch:{systemStatus:"1",currentPage:1,pagesize:2,},
      systemLists:[{"systemId":1,"systemName":"mag","systemStatus":1}],
      systemConfig:{},
      systemConfigRules:{
        systemName:[{required:true,message:"请输入系统名称",trigger:"blur"}]
      },
      dialogVisiable:false
    }},
    created(){
      this.getSystemConfig(true)
    },

    methods:{
      // 搜索配置数据
      getSystemConfig(isInitialPage){
        if(isInitialPage) this.formSearch.currentPage=1;

        console.log(this.formSearch.currentPage)

      },
      // 重置搜索条件
      initSearchForm(){
        this.formSearch.systemStatus=null;
        this.formSearch.systemName=null;

      },
      // 分页触发
      changePage(currentPage){
        this.formSearch.currentPage=currentPage
        this.getSystemConfig()
      },
      // 保存数据
      saveSystemConfig(refName){
        this.$refs[systemConfig].validate((valid)=>{
          if(valid){
            console.log("保存数据")
            console.log(this.$refs)
          }
        })

      },
      // 关闭编辑框前回调
      beforeCloDialog(refName){
        this.$refs[refName].resetFields();
        this.systemConfig={}

      },
      // 编辑
      editSystemConfig(index,row){
        var newRowdata=this.deepcopy(row)
        this.dialogVisiable=true,
        this.systemConfig=newRowdata
        },
      //失效系统配置
      delecteSystemconig(index,row){

      }

    }
  }
</script>
