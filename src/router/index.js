import Vue from 'vue'
import VueRouter from 'vue-router'
import aaa from './aaa'
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: aaa
})

export default router