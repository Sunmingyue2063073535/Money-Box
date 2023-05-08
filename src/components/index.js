import FormTopDesc from './FormTopDesc.vue'
import TopDesc from './TopDesc.vue'
import Copy from "./Copy.vue";
export default {
    install(Vue) {
        Vue.component('FormTopDesc', FormTopDesc)
        Vue.component('TopDesc', TopDesc)
        Vue.component('Copy', Copy)
    }
}