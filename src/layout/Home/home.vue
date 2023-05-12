<template>
    <div class="home">
        <div class="title">Max Loan Amount</div>
        <div class="amount">₹200,000</div>
        <div class="data">
            <div class="data-left">
                <div class="data-left-top">95~ 365 Day</div>
                <div class="data-left-bottom">Loan period</div>
            </div>
            <div class="data-right">
                <div class="data-left-top">0.05%(day)</div>
                <div class="data-left-bottom">interest</div>
            </div>
        </div>
        <div class="loan">
            <div class="t">Loan Example</div>
            <div class="content">
                <div class="c-left">
                    <div class="c-amount">
                        <div class="c-a-top">Loan Amount</div>
                        <div class="c-a-bottom">₹50,000</div>
                    </div>
                    <div class="c-charged">
                        <div class="c-b-top">interest charged</div>
                        <div class="c-b-bottom">₹1,500</div>
                    </div>
                </div>
                <div class="c-right">
                    <div class="c-period">
                        <div class="c-a-top">Loan period</div>
                        <div class="c-a-bottom">365 days</div>
                    </div>
                    <div class="c-repayment">
                        <div class="c-b-top">Total repayment</div>
                        <div class="c-b-bottom">₹51,500</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 按钮 -->
        <div class="btn" @click="doApply">Start Apply</div>
        <div class="bottom">
            <img src="@/assets/home-bottom.png" alt="">
        </div>
        <ul class="bottom-left">
            <li>
                <div class="li-img">
                    <img src="../../assets/dui.png" alt="" />
                </div>
                <div class="li-desc">100% online loan</div>
            </li>
            <li>
                <div class="li-img">
                    <img src="../../assets/dui.png" alt="" />
                </div>
                <div class="li-desc">99% Approval</div>
            </li>
            <li>
                <div class="li-img">
                    <img src="../../assets/dui.png" alt="">
                </div>

                <div class="li-desc">No paperwork</div>
            </li>
        </ul>
        <div class="bottom-right">
            <div class="one">Flexible repayment</div>
            <div class="two">Borrow anytime repay anytime</div>
        </div>
        <!-- 底部导航 -->
        <div class="nav">
            <div class="nav-home">
                <img src="@/assets/home-a.png" alt="">
            </div>
            <div class="nav-me" @click="$router.push('/me')">
                <img src="@/assets/me.png" alt="">
            </div>
        </div>
    </div>
</template>
<script>
import toNext from '../Form/toNext.js'
import { Toast } from 'vant'
export default {
    methods: {
        async doApply() {
            if (!this.$store.state.isLogin) {
                this.$router.push('/login')
                return c('please log in first')
            }
            this.$router.push('/beforeys')
        }
    }
}
</script>
<style lang="less">
.home {
    position: relative;
    width: 100vw;
    height: (325/@a);
    background: linear-gradient(180deg, #2BDB80 0%, #10BA68 100%);
    border-radius: 0 0 (25/@a) (25/@a);
    margin-bottom: (60/@a);

    .nav {
        width: 100vw;
        height: (60/@a);
        background-color: #fff;
        position: fixed;
        bottom: 0;
        left: 0;
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

    .bottom-right {
        width: (125/@a);
        text-align: center;
        position: absolute;
        right: (35/@a);
        top: (520/@a);

        .one {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 600;
            font-size: (13/@a);
            color: #535353;
        }

        .two {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #ACACAC;
        }
    }

    .bottom {
        position: absolute;
        left: (23/@a);
        top: (503/@a);
    }

    .bottom-left {
        position: absolute;
        left: (50/@a);
        top: (520/@a);

        li {
            display: flex;

            .li-img {
                width: (12/@a);
                height: (12/@a);
                margin-right: (5/@a);

                img {
                    width: 100%;
                }
            }

            .li-desc {
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #4A4A4A;
                margin-top: (3/@a);
            }
        }
    }

    .btn {
        position: absolute;
        width: (258/@a);
        height: (50/@a);
        left: (55/@a);
        top: (410/@a);
        z-index: 99;
        background: #F8A039;
        border-radius: (10/@a);
        text-align: center;
        line-height: (50/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 500;
        font-size: (20/@a);
        color: #fff;
    }

    .data {
        position: absolute;
        display: flex;
        top: (146/@a);
        left: (40/@a);
        width: (290/@a);
        height: (53/@a);
        z-index: 9;
        background-color: #fff;
        border-radius: (20/@a);

        .data-left {
            margin-top: (6/@a);
            margin-left: (40/@a);
            margin-right: (50/@a);
        }

        .data-right {
            margin-top: (6/@a);
        }

        .data-left-top {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 500;
            font-size: (14/@a);
            color: #0D621D;
        }

        .data-left-bottom {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #0D621D;
        }
    }

    .loan {
        position: absolute;
        top: (233/@a);
        left: (35/@a);
        width: (300/@a);
        height: (240/@a);
        border-radius: (20/@a);
        background-color: #fff;
        padding-top: (20/@a);

        .t {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 500;
            font-size: (18/@a);
            color: #444444;
            margin-left: (90/@a);
        }

        .content {
            display: flex;

            .c-left {
                margin-left: (20/@a);
                margin-top: (10/@a);
                margin-right: (50/@a);
            }

            .c-right {
                margin-top: (10/@a);
            }

            .c-a-top {
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #535353;
            }

            .c-a-bottom {
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 500;
                font-size: (15/@a);
                color: #179D2D;
                margin-top: (5/@a);
            }

            .c-b-top {
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #535353;
                margin-top: (5/@a);
            }

            .c-b-bottom {
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 500;
                font-size: (15/@a);
                color: #535353;
                margin-top: (5/@a);
            }
        }

    }

    .title {
        position: absolute;
        top: (53/@a);
        left: (118/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 400;
        font-size: (15/@a);
        color: #fff;
    }

    .amount {
        position: absolute;
        top: (70/@a);
        left: (75/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 400;
        font-size: (48/@a);
        color: #fff;
    }
}
</style>