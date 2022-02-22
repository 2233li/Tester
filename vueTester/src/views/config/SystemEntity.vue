<template>
	<div>
    <!-- 搜索框 -->
    <div>
      <el-form :model="SearchFormData" :inline="true">
        <el-form-item label="系统名称">
          <el-select v-model="SearchFormData.testSystemId" clearable>
            <el-option v-for="item in EntityLists" :key="item.testSystemId" :label="item.testSystemName" :value="item.testSystemId" ></el-option>

          </el-select>

        </el-form-item>
        <el-form-item label="实体id">
          <el-input v-model="SearchFormData.entityId" placeholder="实体id"></el-input>
        </el-form-item>
        <el-form-item label="实体名称">
          <el-input v-model="SearchFormData.entityName" placeholder="实体名称"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="SearchFormData.status" placeholder="系统状态">
            <el-option label="生效" value="1"></el-option>
            <el-option label="失效" value="-1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item >
          <el-button type="primary"> 查询</el-button>
        </el-form-item>

      </el-form>
    </div>
   <!-- 新增按钮 -->
    <div class="operation"><el-button type="info" plain @click="EditEntityDialogVisiable=true">新增</el-button></div>

    <!-- 新增&编辑实体 -->
   <el-dialog title="修改实体数据" :visible.sync="EditEntityDialogVisiable"
    width="60%">
    <el-form :model="Entity" ref="Entity" label-width="100px" :rules="EntityDataRule">
      <el-form-item label="测试系统" prop="testSystemId">
        <el-select v-model="Entity.testSystemId" >
          <el-option v-for="item in EntityLists" :key="item.testSystemId" :label="item.testSystemName" :value="item.testSystemId"></el-option>
          </el-select>
      </el-form-item>
      <el-form-item label="实体名称" prop="entityName">
        <el-input v-model="Entity.entityName"></el-input>
      </el-form-item>

      <el-form-item label="实体反射" prop="EntityReflect">
        <el-input v-model="Entity.EntityReflect"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveEntity('Entity')">保存</el-button>
        <el-button @click="resetSaveEntityForm('Entity')" >取消</el-button>
      </el-form-item>

    </el-form>

    </el-dialog>

    <!-- 数据表单部分-->
    <div>
      <el-table :data="EntityLists" border style="width: 100%;"
          :header-cell-style="{color:'#333'}">
        <el-table-column label="实体id" prop="entityId"></el-table-column>
        <el-table-column label="系统名称" prop="testSystemName"></el-table-column>
        <el-table-column label="实体名称" prop="entityIdName"></el-table-column>
        <el-table-column label="修改时间" prop="modifyDate"></el-table-column>
        <el-table-column label="状态" >
            <div v-if="status===1">有效</div>
            <div v-else> 失效</div>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
          <el-button  type="primary" plain @click="Editentity(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" plain >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

	</div>

</template>
<script>
export default {
	name:"SystemEntity",
	data(){
		return {
      EditEntityDialogVisiable:false,
      SearchFormData:{},
      EntityLists:[],
      Entity:{},
      EntityDataRule:{
        entityName:[ { required: true, message: '请输入实体名称', trigger: 'blur' }],
        EntityReflect:[{ required: true, message: '请输入实体反射', trigger: 'blur' }],
        testSystemId:[{ required: true, message: '请选择测试系统', trigger: 'change' }]

      }
		};

	},


	methods:{

    getEntityLists(){},

    saveEntity(formName){
      this.$refs[formName].validate((valid)=>{
        if(valid){

          console.log(JSON.stringify(this.EnditEntityForm))
        }
      })
    },

    resetSaveEntityForm(formName){
      this.$refs[formName].resetFields();

     this.EditEntityDialogVisiable=false;
    },
    Editentity(index,row){
     this.EditEntityDialogVisiable=true;
     this.EnditEntityForm=this.EntityLists[index]


    }

	},
  created:function(){
    this.getEntityLists();
    this.EntityLists=[
  {
    "testSystemId": 1,
    "testSystemName": "mag系统",
    "entityId": 3,
    "entityIdName": "实体名称",
    "status": -1,
    "modifyDate":"2022/01/12 17:08"
  }
]
  }
}
</script>

<style>
  .operation{
    margin-bottom: 10px;
  }
</style>
