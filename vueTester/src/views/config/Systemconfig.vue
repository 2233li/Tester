<template>
	<div>
    <div>
      <el-form :model="formData" :inline="true">
        <el-form-item label="系统id">
          <el-input v-model="formData.testSystemId" placeholder="系统id"></el-input>
        </el-form-item>
        <el-form-item label="系统名称">
          <el-input v-model="formData.testSystemName" placeholder="系统名称"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="formData.status" placeholder="系统状态">
            <el-option label="生效" value="1"></el-option>
            <el-option label="失效" value="-1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item >
          <el-button type="primary  "> 查询</el-button>
        </el-form-item>

      </el-form>
    </div>
    <div class="operation"><el-button type="info" plain>新增</el-button></div>
    <div>
      <el-table :data="TestSystemList" border style="width: 100%;"
          :header-cell-style="{color:'#333'}">
        <el-table-column label="系统id" prop="testSystemId"></el-table-column>
        <el-table-column label="系统名称" prop="testSystemName"></el-table-column>
        <el-table-column label="创建时间" prop="createDate"></el-table-column>
        <el-table-column label="状态" prop="status"></el-table-column>
        <el-table-column label="操作">
          <el-button type="primary" plain>编辑</el-button>
          <el-button type="danger" plain >删除</el-button>
        </el-table-column>
      </el-table>
    </div>

	</div>

</template>
<script>
export default {
	name:"Systemconfig",
	data(){
		return {
			TestSystemList:[
  {
    "testSystemId": 1,
    "testSystemName": "mag系统"
  },
  {
    "testSystemId": 2,
    "testSystemName": "eb系统"
  },
  {
    "testSystemId": 3,
    "testSystemName": "elk日志查询系统"
  },
  {
    "testSystemId": 4,
    "testSystemName": "分销系统"
  }
],
      formData:{
        "testSystemId":"",
        "testSystemName":"",
        "status":""



      }
		};

	},

	// created:function(){
	// 	this.getTestSystem();
	// },
	methods:{
		getTestSystem:function(){
			this.getRequest('/api/testsystem/findAll').then((resp)=>{
				this.TestSystemList=resp.data

			}).catch((err) =>{

			})

		}

	}
}
</script>

<style>
  .operation{
    margin-bottom: 10px;
  }
</style>
