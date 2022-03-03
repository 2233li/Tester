import axios from "axios"
import {Message} from "element-ui"
import router from '@//router'
import {mymessage} from "@/utils/Mymessage"


let base='http://localhost:8081';

// 自定义拦截器：response 响应码处理

// 表单提交

// get方法
export const getRequest=(url,param)=>{
	console.log(url)
	return axios({
		method:"get",
		url:`${base}${url}`,
		data:param
	})
};

//post 方法
export const postRequest=(url,param)=>{

	return axios({
		method:"post",
		url:`${url}`,
		data:param,
    headers:{'content-type':'application/json;charset=UTF-8',
    "Origin":'http-ota-j-pre.yaochufa.com'
    }
	})
};

//深拷贝
export const deepcopy=(obj)=>{
   let newObj = null
      if (typeof obj === 'object' && obj !== null) {
          newObj = obj instanceof Array ? [] : {}
          for (let i in obj) {
              newObj[i] = typeof obj[i] === 'object' ? copy(obj[i]) : obj[i]
          }
      } else {
          newObj = obj
      }
      return newObj
}
