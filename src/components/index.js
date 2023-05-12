import FormTopDesc from './FormTopDesc.vue'
import TopDesc from './TopDesc.vue'
import Copy from "./Copy.vue";
import ProDesc from './ProDesc.vue'
export default {
    install(Vue) {
        Vue.component('FormTopDesc', FormTopDesc)
        Vue.component('TopDesc', TopDesc)
        Vue.component('Copy', Copy)
        Vue.component('ProDesc', ProDesc)
    }
}