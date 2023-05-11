import home from '@/layout/Home/home.vue'
import me from '@/layout/Home/me.vue'
import login from '@/layout/login.vue'
import ocr from '@/layout/Form/ocr.vue'
import baseForm from '@/layout/Form/baseForm.vue'
import myloan from '@/layout/Loan/MyLoan.vue'
import alive from '../layout/Form/alive.vue'
import productList from '../layout/Product/productList.vue'
import PettyCash from "@/layout/Pay/PettyCash.vue";
import PayType from '../layout/Pay/PayType.vue'
import Rollover from "@/layout/Pay/Rollover.vue";
import FanKuiList from "../layout/kefu/FanKuiList.vue";
import FanKuiForm from '../layout/kefu/FankuiForm.vue'
import xieyi from '../layout/xieyi/xieyi.vue'
import beforeqx from '../layout/before/beforeqx.vue'
import beforeys from '../layout/before/beforeys.vue'
const routes = [
    { path: '/', component: xieyi },
    { path: '/login', component: login },
    { path: '/home', component: home },
    { path: '/me', component: me },
    { path: '/ocr', component: ocr },
    { path: '/baseForm', component: baseForm },
    { path: '/myloan', component: myloan },
    { path: '/alive', component: alive },
    { path: '/productList', component: productList },
    { path: '/PettyCash', component: PettyCash },
    { path: '/PayType', component: PayType },
    { path: '/Rollover', component: Rollover },
    { path: '/FanKuiList', component: FanKuiList },
    { path: '/FanKuiForm', component: FanKuiForm },
    { path: '/beforeqx', component: beforeqx },
    { path: '/beforeys', component: beforeys },

]
export default routes