import home from '@/layout/Home/home.vue'
import me from '@/layout/Home/me.vue'
import login from '@/layout/login.vue'
import ocr from '@/layout/Form/ocr.vue'
const routes = [
    { path: '/', component: login },
    { path: '/login', component: login },
    { path: '/home', component: home },
    { path: '/me', component: me },
    { path: '/ocr', component: ocr },

]
export default routes