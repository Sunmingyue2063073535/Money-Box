<template>
    <div class="me">
        <div class="me-top" v-if="isLogin">
            <div class="user-icon">
                <img src="@/assets/user-icon-a.png" alt="">
            </div>
            <div class="user-name">Hello User</div>
        </div>
        <div class="me-top" v-else>
            <div class="user-icon">
                <img src="@/assets/user-icon.png" alt="">
            </div>
            <div class="user-name">Please Login</div>
        </div>
        <div class="status">
            <img src="@/assets/me-nav.png" alt="">
        </div>
        <!-- 列表 -->
        <ul class="list">
            <!-- My Order -->
            <li>
                <div class="list-icon">
                    <img src="@/assets/list-wallet.png" alt="">
                </div>
                <div class="list-name">My order</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- 隐私协议 -->
            <li>
                <div class="list-icon">
                    <img src="@/assets/list-yinsi.png" alt="">
                </div>
                <div class="list-name">Privacy Policy</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- Terms -->
            <li>
                <div class="list-icon">
                    <img src="@/assets/list-terms.png" alt="">
                </div>
                <div class="list-name">Terms & Condition</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- Loan Product -->
            <li>
                <div class="list-icon">
                    <img src="@/assets/list-house.png" alt="">
                </div>
                <div class="list-name">loan product</div>
                <div class="list-jiantou">
                    <img src="@/assets/youjiantou.png" alt="">
                </div>
            </li>
            <!-- 邮箱 -->
            <li>
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
        <div class="login" v-if="!isLogin" @click="$router.push('/login')">Login</div>
        <div class="login" v-else>Log out</div>
        <!-- 底部导航 -->
        <div class="nav">
            <div class="nav-home" @click="$router.push('/home')">
                <img src="@/assets/home.png" alt="">
            </div>
            <div class="nav-me">
                <img src="@/assets/me-a.png" alt="">
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            isLogin: false
        }
    },
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

    .status {
        position: absolute;
        top: (145/@a);
        left: (15/@a);
        width: (350/@a);
        height: (113/@a);

        img {
            width: 100%;
        }
    }

    .me-top {
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