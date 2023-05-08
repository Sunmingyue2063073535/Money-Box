import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import './style/base.css'
import Vant from 'vant';
import 'vant/lib/index.css';
import SunCom from './components/index'
Vue.use(Vant);
Vue.use(SunCom)
Vue.config.productionTip = false;
new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");