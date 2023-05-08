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
const routes = [
    { path: '/', component: login },
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

]
export default routes