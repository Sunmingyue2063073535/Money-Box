<template>
    <div class="productMask">
        <div class="top">
            <div class="title">You have applied for 1 loan products</div>
            <div class="desc">The details of your loan products are as follows :</div>
            <div class="close" @click="$emit('closeDialog')">
                <img src="../../assets/close.png" alt="">
            </div>
        </div>
        <div class="content">
            <div class="c-title">Product NO:</div>
            <div class="list" v-for="ele in shouxufeiArr">
                <ul class="key">
                    <li>Loan products:</li>
                    <li>Term (Days):</li>
                    <li>Loan amount:</li>
                    <li>Amount Received:</li>
                    <li>Total interest and service fee:</li>
                </ul>
                <ul class="val">
                    <li>{{ ele.name }}</li>
                    <li>{{ ele.term }}</li>
                    <li>{{ ele.amount }}</li>
                    <li>{{ ele.actualAmount }}</li>
                    <li>{{ (ele.interestAmount + ele.adminAmount).toFixed(2) }}</li>
                </ul>
            </div>
        </div>
        <!-- 底部按钮 -->
        <div class="bottom">
            <div class="cancle" @click="$emit('closeDialog')">Cancle</div>
            <div class="confirm" @click="doConfirm">Confirm</div>
        </div>

    </div>
</template>
<script>
import { FKJYHLEHdkUploadAPI } from '../../api'
import { add } from "../../utils/key.js";
export default {
    props: ['shouxufeiArr'],
    methods: {
        async doConfirm() {
            const f = {
                model: {
                    productIds: [this.$store.state.PID]
                }
            }
            console.log(f)
            const r = await FKJYHLEHdkUploadAPI(add(f))
            this.$router.push('/myloan')
            console.log(r)
        }
    },
    created() {
        console.log(this.shouxufeiArr)
    }
}
</script>
<style lang="less" scoped>
.productMask {
    width: 100%;

    .bottom {
        display: flex;
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 500;
        font-size: (22/@a);
        color: #FFFFFF;
        text-align: center;
        line-height: (54/@a);

        .cancle {
            width: 50%;
            height: (54/@a);
            background-color: #c2c2c2;
        }

        .confirm {
            width: 50%;
            height: (54/@a);
            background-color: #18c16d;
        }
    }

    .content {
        width: 100%;
        height: (218/@a);
        padding-top: (14/@a);
        padding-left: (20/@a);
        background-color: #fff;

        .list {
            display: flex;
            justify-content: space-between;
            padding-right: (20/@a);

            li {
                margin-bottom: (15/@a);
            }

            .key {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (11/@a);
                color: #808080;
            }

            .val {
                text-align: right;
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (11/@a);
                color: #202020;

            }
        }

        .c-title {
            font-family: 'Inter';
            margin-bottom: (10/@a);
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #101010;
        }
    }

    .top {
        position: relative;
        width: (328/@a);
        height: (68/@a);
        background-color: #18c16d;
        padding-top: (20/@a);
        padding-left: (20/@a);

        .title {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (14/@a);
            color: #FFFFFF;
        }

        .desc {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #0A820F;
        }

        .close {
            position: absolute;
            top: (10/@a);
            right: (10/@a);
            width: (30/@a);
            height: (30/@a);

            img {
                width: 100%;
            }
        }


    }
}
</style>