import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import './style/base.css'
import Vant from 'vant';
import 'vant/lib/index.css';
import SunCom from './components/index'
import { add, unt } from "./utils/key";
import { FKJYHLEHuploadGoogleTokenAPI, FKJYHLEHuploadInstanceIdAPI, FKJYHLEHuploadInstallReferrerAPI } from './api'
Vue.use(Vant);
Vue.use(SunCom)
Vue.config.productionTip = false;
// 挂载全局函数， android调用
window.UploadThreeId = async function(item) {
    if (item && item.type == 1 && item.token) {
        console.log(JSON.stringify(item), '上报谷歌token')
            // console.log('111')
        const result = await FKJYHLEHuploadGoogleTokenAPI(add({ model: item.token || null }))
            // console.log(item.token, '谷歌token')
        console.log(JSON.stringify(result), '上报谷歌token')
        console.log(result, '上报谷歌token')
    }
    if (item && item.type == 2 && item.id) {
        console.log(JSON.stringify(item), '上报InstanceId')
        const result = await FKJYHLEHuploadInstanceIdAPI(add({ model: item.id || null }))
            // console.log(item.id, '第二个id')
        console.log(JSON.stringify(result), '上报InstanceId')
        console.log(result, '上报InstanceId')
            // console.log('222')
    }
    if (item && item.type == 3) {
        console.log(JSON.stringify(item), '上报InstallReferrer')
            // console.log(JSON.stringify(item), 'InstallReferrer')
        const result = await FKJYHLEHuploadInstallReferrerAPI(add({ model: item || {} }))
        console.log(JSON.stringify(result), '上报InstallReferrer')
        console.log(result, '上报InstallReferrer')
            // console.log('333')
    }
}


new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");