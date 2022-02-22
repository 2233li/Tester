import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home  from '@/views/Home'
import Systemconfig from '@/views/systems/Systemconfig'
import SystemEntity from '@/views/systems/SystemEntity'
import SystemOperation from '@/views/systems/SystemOperation'
import testCase from '@/views/testCase/testCase'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Home',
      component:Home,
      children:[
        {path:"setting/systems",name:'系统配置',component:Systemconfig},
        {path:'setting/entitys',name:'实体配置',component:SystemEntity},
        {path:'setting/operation',name:'实体操作',component:testOperation},
        {path:"setting/testCase",name:'测试用例', component:testCase}

      ]

    }
  ]
})
