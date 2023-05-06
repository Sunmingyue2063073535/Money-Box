import { FKJYHLEHgetwwcFormApi } from '../../api'
import { add, unt } from "../../utils/key";

export default {
    state: {
        //未完成表单数据
        formData: [],
    },
    getters: {

    },
    mutations: {
        //设置未完成表单
        setFormData(state, payload) {
            state.formData = payload
        },
    },
    actions: {
        //获取一个未完成表单
        async weiwancehngform(content) {
            const form = {
                model: {
                    nodeType: ''
                }
            }
            const res = await FKJYHLEHgetwwcFormApi(add(form))
            const result = res
            console.log('未完成的表单vuex', result)
            content.commit('setFormData', result.model.forms)
        }
    },
    namespaced: true,
}