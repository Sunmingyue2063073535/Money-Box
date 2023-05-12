// 导出一个axios的实例  而且这个实例要有请求拦截器 响应拦截器
import axios from 'axios'
import store from '../store'
import router from '../router'
import { Toast } from "vant";
import { unt } from "../utils/key";
import { threeToken } from "../android/android";
// 创建一个axios的实例
const c = axios.create({
    // 设置基地址
    baseURL: 'https://app.money-box.xyz',
    withCredentials: true,
    timeout: 60000,
})
c.defaults.headers["Content-Type"] = "application/json";

// 请求拦截器
c.interceptors.request.use(
    async (config) => {
        store.commit('showLoading')
        const token = await threeToken()
        // const token = 'FKJYHLEHee77bf0b72a4430d83d3834332030841ea26716f4d8fe2fb4b0c5a198c1c97ddcd484130272c45307a39174451871f5e03ee98e4d2fb02bdb8d75f74d30ef83997e38c00fed2d9ce622fce16414645754f80b57c7dba38a46aec840f5e851b4fe99c2f902f8671012bc0e3e7603963bb'
        config.headers.Token = token
        //添加登录的token
        const a = store.state.userInfo.token
        if (a) {
            config.headers.Auth = a
        }
        return config
    },
    (error) => {
        store.commit('hideLoading')
        return Promise.reject(error)
    }
)

// 响应拦截器
c.interceptors.response.use(
    (response) => {
        //判断登录失效
        if (response.data.status === 1012) {
            // 跳到登录页
            router.push('/login')
            // 提示登录
            Toast('Please log in first')
        }
        //对请求错误的结果进行拦截
        try {
            if (response.data.status && response.data.status !== 0) {
                store.commit('hideLoading')
                Toast(response.data.message)
                return
            }
        } catch (error) {

        }
        store.commit('hideLoading')
        return unt(response.data)
    },
    (error) => {
        store.commit('hideLoading')
        return Promise.reject(error)
    }
)

export default c // 导出axios实例