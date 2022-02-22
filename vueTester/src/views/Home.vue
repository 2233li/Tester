<template>
  <div class="homeWrap">
	<el-container class="main_container" >
   <el-header class="header" height="50px">
     <myHeader></myHeader>
   </el-header>
    <el-container>
      <el-aside width="220px">
        <myAside></myAside>
      </el-aside>
       <el-main> <router-view/></el-main>
    </el-container>
  </el-container>
  </div>
	
</template>

<script>
import myAside from "@/components/myAside"
import myHeader from "@/components/myHeader"
export default {
  name:"Home",
  components:{  
    myAside,
    myHeader
  }
}
</script>
<style scoped>
  .homeWrap{
    position: absolute;
    top:0;
    left: 0;
    width: 100%;
    height: 100%;

  }
  .main_container{
    height:100%;
  }
  .header{
    padding: 0%;
  }

</style>

