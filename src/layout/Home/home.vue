<template>
    <div class="home">
        <div class="title">Max Loan Amount</div>
        <div class="amount">₹200,000</div>
        <div class="data">
            <img src="@/assets/home-data.png" alt="">
        </div>
        <div class="loan">
            <img src="@/assets/home-loan.png" alt="">
        </div>
        <!-- 按钮 -->
        <div class="btn">Start Apply</div>
        <div class="bottom">
            <img src="@/assets/home-bottom.png" alt="">
        </div>
        <div class="bottom-left">
            <img src="@/assets/home-left.png" alt="">
        </div>
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
export default {

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
        top: (146/@a);
        left: (40/@a);
        width: (290/@a);
        height: (53/@a);
        z-index: 9;


        img {
            width: 100%;
        }
    }

    .loan {
        position: absolute;
        top: (233/@a);
        left: (35/@a);

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