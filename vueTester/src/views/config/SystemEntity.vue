<template>
  <div>
    <!--搜索框 -->
    <div>
      <el-form :inline="true" :model="formSearch">
        <el-form-item label="系统">
          <el-select v-model="formSearch.systemId">
            <el-option v-for="(item,index) in sysConfigLists" :label="item.systemName" :value="item.systemId" :key="item.systemId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="实体">
          <el-input v-model="formSearch.sysEntityName"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="formSearch.status">
            <el-option label="有效" value="1"></el-option>
            <el-option label="无效" value="-1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getSysEntityList(true)" > 搜索</el-button>
          <el-button type="info" @click="initialSearch()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!--表格数据-->
    <div>
      <el-button type="info" plain  style="margin: 5px;" @click="dialogVisiable=true">新增</el-button>
      <el-table :data="systemEntityLists" border>
        <el-table-column label="系统" prop="sysName"></el-table-column>
        <el-table-column label="实体" prop="sysEntiName"></el-table-column>
        <el-table-column label="状态" prop="status">
          <template slot-scope="scope">
            <p v-if="scope.row.status==1">有效</p>
            <p v-else>失效</p>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
          <el-button type="primary" plain @click="editData(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" plain @click="delectData"  >删除</el-button>
          </template>
         </el-table-column>
      </el-table>
    </div>

    <!-- 分页-->
    <div>
      <el-pagination :page-size="formSearch.pageSize"
                     :current-page="formSearch.currentPage"
                     :total="totalData"
                     @current-change="changePage"></el-pagination>
    </div>
    <!-- 新增&编辑-->
    <el-dialog :visible.sync="dialogVisiable" @closed="afterDioClose('systemEntity')"
               title="新增&编辑">
      <el-form label-width="80px" :model="systemEntity" :rules="systemEntityRules" ref="systemEntity" >
        <el-form-item label="系统" prop="systemId">
         <el-select v-model="systemEntity.systemId">
           <el-option v-for="(item,index) in sysConfigLists" :label="item.systemName" :value="item.systemId" :key="item.systemId"></el-option>
         </el-select>
        </el-form-item>
        <el-form-item label="实体名称" prop="sysEntiName">
          <el-input v-model="systemEntity.sysEntiName" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addEditData('systemEntity')" >保存</el-button>
          <el-button type="info" @click="dialogVisiable=false" plain>取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>


</template>
<script>
  export default{
    name:"SystemEntity",
    data(){return{
      dialogVisiable:false,
      formSearch:{status:"1",pageSize:2,currentPage:1}, // 搜索框数据
      systemEntityLists:[{sysName:'mag系统',sysEntiName:'快手',status:'1',systemId:1}],// 数据列表数据
      systemEntity:{},// 编辑&新增 数据对象
      systemEntityRules:{
        systemId:[{ required: true, message: '请选择测试系统', trigger: 'blur' }],
        sysEntiName:[{ required: true, message: '请输入操作名称', trigger: 'blur' }]

      },
      totalData:0,
      sysConfigLists:[{systemName:"mag",systemId:1}],// 搜索 系统下拉框数据

    }},
    created(){
     this.getSystemConfigList();
     this.getSysEntityList()
    },
    methods:{
      //获取系统配置列表
      getSystemConfigList(){
        console.log("获取系统配置列表")
      },
      // 搜索数据列表 SystemEntity
      getSysEntityList(isInitialPage){
        console.log("获取数据列表")
        this.totalData=30
      },
      // 重置搜索框
      initialSearch(){
        console.log(" // 重置搜索框")
      },
      // 失效数据
      delectData(index,row){
        console.log("失效数据")
      },
      // 编辑数据触发
      editData(index,row){
        var newRowData=this.deepcopy(row)
        this.dialogVisiable=true
        this.systemEntity=newRowData

      },
      // 新增&编辑数据
      addEditData(refName){
        this.$refs[refName].validate((valid)=>{
           console.log("增&编辑数新据")
        })


      },
      // 新增 编辑 关闭前回调
      afterDioClose(refName){
        this.systemEntity={}
        this.$refs[refName].resetFields();// 关闭dialog 前，清除数据校验
      },
      // 分页
      changePage(currentPage){
        console.log("currentPage"+currentPage)

      }

    }
  }
</script>

<style>

</style>
