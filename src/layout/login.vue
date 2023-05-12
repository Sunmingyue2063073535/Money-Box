<template>
    <div class="login">
        <div class="logo">
            <img src="../assets/login-logo.png" alt="">
        </div>
        <div class="desc">Welcome back</div>
        <div class="callback" @click="$router.back()">&lt;</div>
        <div class="form">
            <van-form>
                <div class="phone">
                    <div class="phone-icon">
                        <img src="../assets/login-phone.png" alt="">
                    </div>
                    <div class="phone-name">phone number</div>
                </div>
                <van-field class="sjh" v-model="phone" type="tel" name="phone" placeholder="Enter phone number"
                    :rules="[{ required: true }]" />
                <div class="code">
                    <div class="code-icon">
                        <img src="../assets/login-code.png" alt="">
                    </div>
                    <div class="code-name">verification code</div>
                    <!-- otp -->
                    <div class="otp" @click="fasong" v-if="!isShow"> OTP</div>
                    <!-- 时间 -->
                    <div class="yanzhengma" v-else> {{ time }}s</div>
                    <div class="xian">|</div>
                </div>
                <van-field class="yzm" v-model="code" type="type" name="password" placeholder="Enter verification code"
                    :rules="[{ required: true }]" />


                <div class="btn" @click="doLogin">Login</div>
            </van-form>
        </div>
        <div class="bottom">
            <div class="box"><van-checkbox v-model="checked" class="check" checked-color="#237B3C"></van-checkbox></div>
            <div class="bottom-desc">To proceed to the next step means that you agree to <span>&lt;Privacy
                    Policy&gt;</span>and <span>&lt;Terms
                    and Conditionn&gt;</span>.</div>
        </div>
    </div>
</template>
<script>
import { FKJYHLEHgetyzmApi, FKJYHLEHgetLoginApi } from "@/api";
import { add, unt } from "../utils/key.js";
import { Toast } from "vant";
export default {
    data() {
        return {
            isShow: false,
            checked: false,
            phone: '',
            code: '',
            time: ''
        }
    },
    methods: {
        //登录
        async doLogin() {
            if (!this.phone && !this.code) {
                return Toast('Please fill in the mobile phone number or verification code')
            }
            if (!this.checked) {
                return Toast('Please check the agreement')

            }
            const f = {
                phone: this.phone,
                phoneCode: '+91',
                code: this.code
            }
            const r = await FKJYHLEHgetLoginApi(add(f))
            console.log(r)
            if (!r.status) {
                //登录成功
                this.$store.commit('setUserInfo', r.user)
                this.$router.push('/home')
                this.$store.commit('changeLogin', true)
            }

        },
        //发送验证码
        async fasong() {
            if (!this.phone) {
                Toast('Please enter phone number')
                return
            }
            const f = {
                model: {
                    phone: this.phone,
                    phoneCode: '+91'
                }
            }
            const r = await FKJYHLEHgetyzmApi(add(f))
            console.log(r)
            if (r.status === 0) {
                this.isShow = true
                this.time = 60
                let timer = setInterval(() => {
                    this.time--
                    if (this.time <= 0) {
                        this.isShow = false
                        clearInterval(timer)
                    }
                }, 1000)
            }
        }
    }
}
</script>
<style lang="less">
/deep/ input::placeholder {

    color: #AECCA3 !important;
}

.login {
    .callback {
        position: fixed;
        top: (20/@a);
        left: (20/@a);
        font-size: (40/@a);
        color: #12BD6A;
    }

    .form {
        position: relative;
        width: (288/@a);
        height: (300/@a);
        background: #FDFEFF;
        border: (1/@a) solid #96B8A7;
        box-shadow: 0px (4/@a) (4/@a) rgba(0, 0, 0, 0.05);
        border-radius: (22/@a);
        margin-top: (20/@a);
        margin-left: (40/@a);
        padding: (36/@a) (20/@a);





        .btn {
            width: (247/@a);
            height: (40/@a);
            background: linear-gradient(180deg, #32CE7A 0%, #12BD6A 100%);
            border-radius: (20/@a);
            text-align: center;
            line-height: (40/@a);
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 500;
            font-size: (18/@a);
            color: #fff;
        }

        .sjh {
            width: (247/@a);
            height: (42/@a);
            background: #D1F1D3;
            border-radius: (21/@a);
            margin-bottom: (20/@a);
            margin-top: (5/@a);

            &::placeholder {
                color: #AECCA3;
            }
        }

        .yzm {
            width: (247/@a);
            height: (42/@a);
            background: #D1F1D3;
            border-radius: (21/@a);
            margin-bottom: (20/@a);
            margin-top: (5/@a);
        }

        .code {
            position: relative;
            display: flex;
            margin-bottom: (4/@a);

            .code-icon {
                width: (12/@a);
                height: (16/@a);

                img {
                    width: 100%;
                }
            }

            .code-name {
                color: #4D8058;
                margin-left: (8/@a);
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (14/@a);
            }

            .otp {
                position: absolute;
                top: (36/@a);
                right: (15/@a);
                z-index: 999;
                color: #1CC26F;
            }

            .yanzhengma {
                position: absolute;
                top: (36/@a);
                right: (15/@a);
                z-index: 999;
                color: #A6A6A6;
            }

            .xian {
                position: absolute;
                top: (35/@a);
                right: (60/@a);
                z-index: 999;
                color: #1CC26F;
            }
        }

        .phone {
            display: flex;
            margin-bottom: (4/@a);

            .phone-icon {
                width: (12/@a);
                height: (18/@a);

                img {
                    width: 100%;
                }
            }

            .phone-name {
                color: #4D8058;
                margin-left: (8/@a);
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (14/@a);
            }
        }
    }

    .bottom {
        display: flex;
        margin-top: (53/@a);
        font-family: 'Roboto';
        margin-left: (20/@a);
        font-style: normal;
        font-weight: 400;
        font-size: (12/@a);

        .box {
            margin-top: (10/@a);
        }

        .bottom-desc {
            margin-left: (10/@a);

            span {
                color: #17924F;
            }
        }
    }

    .desc {
        margin-top: (10/@a);
        margin-left: (124/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 400;
        font-size: (16/@a);
    }

    .logo {
        width: (70/@a);
        height: (70/@a);
        margin-top: (38/@a);
        margin-left: (145/@a);

        img {
            width: 100%;
        }
    }
}
</style>