<template>
	<el-menu
      default-active="2"
      router
      class="el-menu-vertical-demo">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-setting"></i>
          <span>配置</span>
        </template>
          <el-menu-item index="/setting/systems" >系统配置</el-menu-item>
		  <el-menu-item index="/setting/entitys">系统模块</el-menu-item>
		  <el-menu-item index="/setting/operation">系统操作</el-menu-item>
      </el-submenu>
	  <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span>计划</span>
        </template>
          <el-menu-item index="/setting/testCase">计划配置</el-menu-item>
      </el-submenu>
	  <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span>执行</span>
        </template>
          <el-menu-item index="3-1">环境配置</el-menu-item>
		  <el-menu-item index="3-2">用例配置</el-menu-item>
		  <el-menu-item index="3-3">执行日志</el-menu-item>

      </el-submenu>
    </el-menu>
</template>
<script>
export default {
	name:"myAside",

}
</script>
<style scoped>
.el-menu-vertical-demo{
	height: 100%;
}
</style>
