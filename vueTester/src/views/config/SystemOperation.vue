<template>
  <div>
  <!--搜索栏 -->
  <div>
    <el-form :inline="true">
      <el-form-item label="系统" >
        <el-select v-model="searchFormData.testSystemId">
          <el-option v-for="item in testSystemLists" :key="item.testSystemId" :label="item.testSystemName" :value="item.testSystemId" ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="实体">
        <el-select v-model="searchFormData.entityId" >
          <el-option v-for="item in EntityLists" :key="item.entityId" :label="item.entityName" :value="item.entityId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="操作名称">
        <el-input v-model="searchFormData.operationName" />
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="searchFormData.status" >
          <el-option label="有效" value="1"></el-option>
          <el-option label="失效" value="-1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="findOperationList" >查询</el-button>
        <el-button type="primary" @click="searchFormData={}">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
	<!--操作栏-->
  <div class="operations">
    <el-button type="info" plain @click="editdialogVisable=true" >新增</el-button>
  </div>
  <!-- 数据列表 -->
  <div>
    <el-table :data="operationLists" border style="width: 100%;"
          :header-cell-style="{color:'#333'}">
          <el-table-column label="系统" prop="testSystemName"></el-table-column>
          <el-table-column label="实体" prop="entityName"></el-table-column>
          <el-table-column label="操作名称" prop="operationName"></el-table-column>
          <el-table-column label="状态" prop="status"></el-table-column>
          <el-table-column label="操作">
           <template slot-scope="scope">
           <el-button  type="primary" plain @click="editOperation(scope.$index,scope.row)">编辑</el-button>
           <el-button type="danger" plain >删除</el-button>
           </template>
          </el-table-column>
    </el-table>
  </div>
  <!-- 编辑操作数据 -->
  <div>
    <el-dialog title="新增&编辑" :visible.sync="editdialogVisable" width="60%" :before-close="closeOperationDialog" >
      <el-form label-width="100px" :model="operationData" :rules="operationRules" ref="operationData">
        <el-form-item label="系统" prop="testSystemId">
          <el-select v-model="operationData.testSystemId" >
            <el-option v-for="item in testSystemLists " :key="item.testSystemId" :label="item.testSystemName" :value="item.testSystemName"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="实体" prop="entityId">
          <el-select v-model="operationData.entityId"></el-select>
        </el-form-item>
        <el-form-item label="操作名称" prop="operationName">
          <el-input v-model="operationData.operationName"></el-input>
        </el-form-item>
        <el-form-item label="操作反射" prop="operationRef">
          <el-input v-model="operationData.operationRef"></el-input>
        </el-form-item>
        <el-form-item label="操作模板" prop="operationTemp">
          <el-input v-model="operationData.operationTemp" type="textarea" autosize ></el-input>
        </el-form-item>
        <el-form-item>
         <el-button type="primary" @click="saveOperation('operationData')" >保存</el-button>
         <el-button @click="closeOperationDialog('operationData')" >取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
  </div>
 </div>
</template>

<script>
export default {
	name:"SystemOperation",
  data(){return {
    searchFormData:{},
    testSystemLists:[],
    EntityLists:[],
    operationLists:[],
    operationData:{},
    operationRules:{
      testSystemId:[{ required: true, message: '请选择测试系统', trigger: 'change' }],
      operationName:[{ required: true, message: '请输入操作名称', trigger: 'blur' }]
    },
    editdialogVisable:false

  }},
  created:function(){
    this.testSystemLists=[
      {"testSystemName": "mag",
      "testSystemId": 1},
      {"testSystemName": "elk",
      "testSystemId": 2}];
    this.operationLists=[{
      "testSystemName":"mag",
      "entityName":"酒景",
      "operationName":"失效酒景"
    }];

  },
  methods:{
    findOperationList(){
      console.log(JSON.stringify(this.searchFormData));
    },
    editOperation(index,row){
      this.editdialogVisable=true
      this.operationData=this.operationLists[index]

      },
    saveOperation(form){
      this.$refs[form].validate((valid)=>{
        if(valid){
          console.log(JSON.stringify(this.operationData))
        }
      })

    },
    closeOperationDialog(form){
      this.$refs[form].resetField();
      this.editdialogVisable=false;

    }
  }
}
</script>

<style>

  .operations{
    margin-bottom: 10px;
  }

</style>
