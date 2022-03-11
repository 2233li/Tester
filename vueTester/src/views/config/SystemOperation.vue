<template>
  <div>
    <!-- 搜索 -->
    <div>
      <el-form :model="searchFormData" :inline="true">
        <el-form-item label="系统">
          <el-select v-model="searchFormData.sysId" @change="changeSearchFormSysId()" >
            <el-option v-for="(item,index) in sysLists" :label="item.sysName" :value="item.sysId" :key="item.sysId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="实体">
          <el-select v-model="searchFormData.sysEntityId">
            <el-option v-for="(item,index) in sysEntityLists" :label="item.sysEntityName" :value="item.sysEntityId" :key="item.sysEntityId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="操作">
          <el-input v-model="searchFormData.sysOperationName"></el-input>
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
        <el-table-column label="操作" prop="sysOperationName"></el-table-column>
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
          <el-button type="danger" plain @click="deleteData(scope.$index,scope.row)">失效</el-button>
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
      <el-dialog title="新增&编辑" :visible.sync="dialogVisiable" @closed="clostDialog" >
       <el-form :model="sysOperation" :rules="sysOperationFormRules" ref="sysOperation" label-width="90px">
         <el-form-item label="系统" prop="sysId">
           <el-select v-model="sysOperation.sysId" @change="changeOperaSysId()">
              <el-option v-for="(item,index) in sysLists" :label="item.sysName" :value="item.sysId" :key="item.sysId"></el-option>
           </el-select>
         </el-form-item>
         <el-form-item label="实体" prop="sysEntityId">
           <el-select v-model="sysOperation.sysEntityId">
             <el-option v-for="(item,index) in sysEntityLists" :label="item.sysEntityName" :value="item.sysEntityId" :key="item.sysEntityId"></el-option>
           </el-select>
         </el-form-item>
         <el-form-item label="操作" prop="sysOperationName">
           <el-input v-model="sysOperation.sysOperationName"></el-input>
         </el-form-item>
         <el-form-item label="自动化" prop="isAutoTest">
           <el-radio-group v-model="sysOperation.isAutoTest">
             <el-radio :label="-1">不支持</el-radio>
             <el-radio :label="1">支持</el-radio>
           </el-radio-group>
         </el-form-item>
         <el-form-item label="模式" prop="autoTestModel" v-if="sysOperation.isAutoTest==1">
           <el-radio-group v-model="sysOperation.autoTestModel">
             <el-radio :label="1">非定制</el-radio>
             <el-radio :label="-1">定制</el-radio>
           </el-radio-group>
         </el-form-item>
         <el-form-item label="响应规则" prop="resultRule" v-if="sysOperation.isAutoTest==1&&sysOperation.autoTestModel==1" >
           <el-input type="textarea" autosize v-model="sysOperation.resultRule" ></el-input>
         </el-form-item>
         <el-form-item label="反射关联" prop="resultRef" v-if="sysOperation.isAutoTest==1&&sysOperation.autoTestModel==-1" >
           <el-input v-model="sysOperation.resultRef"></el-input>
         </el-form-item>
         <el-form-item label="请求报文" prop="request" v-if="sysOperation.isAutoTest==1" >
           <el-input type="textarea" autosize v-model="sysOperation.request"></el-input>
         </el-form-item>
         <el-form-item>
           <el-button type="primary" @click="saveData('sysOperation')" >保存</el-button>
           <el-button type="info" @click="dialogVisiable=false">取消</el-button>
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
    searchFormData:{currentPage:1,sysEntityId:null},
    sysOpetationLists:[{sysName:"mag",sysId:1,sysEntity:"快手",sysEntityId:1,sysOperationName:"下单",isAutoTest:1,status:1}],
    sysOperation:{sysEntityId:null},
    sysLists:[],
    sysEntityLists:[],
    // 自定义校验规则
    sysOperationFormRules:{
      sysId:{ required: true, message: '请选择测试系统', trigger: 'blur' },
      sysEntityId:{ required: true, message: '请选择实体', trigger: 'blur' },
      sysOperationName:{ required: true, message: '请输入操作', trigger: 'blur' },
      isAutoTest:{required: true, message: '请选择是否支持自动化', trigger: 'blur' },
      autoTestModel:{required: true, message: '请选择模式', trigger: 'blur' },
      resultRule:{required: true, message: '请输入响应规则', trigger: 'blur' },
      resultRef:{required: true, message: '请输入反射关联', trigger: 'blur' },
      request:{required: true, message: '请输入请求报文', trigger: 'blur' }}
  }},
  created(){
    this.getLists(true)
    this.getSysList()
  },


  methods:{
    // 搜索数据
    getLists(isInitialPage){
      if(isInitialPage) this.searchFormData.currentPage=1
      console.log("搜索数据" + this.searchFormData.sysEntityId)
    },
    // 重置搜索数据
    resetSerchData(){
      this.searchFormData={currentPage:this.searchFormData.currentPage}
    },
    // 触发编辑数据
    editForm(index,row){
      var newRo=this.deepcopy(row)
      this.sysOperation.sysId=1
      this.getSysEntityList();
      this.sysOperation=newRo
      this.dialogVisiable=true
      console.log("触发编辑")
    },
    // 失效数据
    deleteData(index,row){
      console.log(失效数据)
    },
    // 保存数据

    saveData(refName){
      this.$refs[refName].validate((valid)=>{
        if(valid){
          console.log("保存数据")
          this.dialogVisiable=false

        }
      })


    },
    // 切换页面
    changePage(currentPage){
      this.searchFormData.currentPage=currentPage
      this.getLists(false);

    },
    //获取系统列表数据
    getSysList(){
      console.log("获取系统列表数据")
      this.sysLists=[{sysName:"mag",sysId:1},{sysName:"eb",sysId:2}]
    },
    //获取实体列表数据
    getSysEntityList(){
       console.log("获取实体列表数据")
       if(this.searchFormData.sysId==1|| this.sysOperation.sysId==1) this.sysEntityLists=[{sysEntityName:"快手",sysEntityId:1}]
       else{
         this.sysEntityLists={}
       }
    },
    // 搜索框sysId发生变更
    changeSearchFormSysId(){
      this.searchFormData.sysEntityId=null
      this.getSysEntityList()
    },
    changeOperaSysId(){
      this.sysOperation.sysEntityId=null
      this.getSysEntityList()
    },
    // 关闭dialog 前回调
    clostDialog(){
      this.$refs["sysOperation"].resetFields();
      this.sysOperation={sysEntityId:null}
    }

  }
  }
</script>
