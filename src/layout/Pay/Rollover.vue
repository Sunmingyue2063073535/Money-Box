<template>
    <div class="rollover">
        <TopDesc desc="Rollover"></TopDesc>
        <div class="title">Payment has been completed and repayment isdelayed.</div>
        <div class="box">
            <div class="box-top">
                <div class="k">Pay Now</div>
                <div class="v">₹{{ info.loanAmount }}</div>
            </div>
            <div class="box-center">
                <ul class="key">
                    <li>Delayed date</li>
                    <li>Extend time</li>
                    <li>Recording delay(max.10000)</li>
                </ul>
                <ul class="val">
                    <li>{{ new Date(info.expiryTime).toLocaleDateString() }}</li>
                    <li>{{ info.delayTerm }} {{ info.termUnit }}</li>
                    <li>{{ info.limitTimes }} Time</li>
                </ul>
            </div>
        </div>
        <div class="btn" @click="$router.push('/PayType')">Need to repay loan ₹{{ info.loanAmount }}</div>
        <Copy></Copy>
    </div>
</template>
<script>
import { FKJYHLEHzhanqiAPI } from "../../api";
import { add } from "../../utils/key.js";
export default {

    data() {
        return {
            info: {}
        }
    },
    methods: {
        //展期试算
        async Zanqi() {
            const f = {
                model: {
                    orderId: this.$store.state.OID
                }
            }
            const r = await FKJYHLEHzhanqiAPI(add(f))
            console.log(r)
            this.info = r.model
        }
    },
    created() {
        this.Zanqi()
    }
}
</script>
<style lang="less" scoped>
.rollover {
    padding-top: (70/@a);

    .box {
        width: (345/@a);
        height: (180/@a);
        background-color: #e3f9ec;
        border-radius: (15/@a);
        margin-top: (35/@a);
        margin-left: (15/@a);
        padding-top: (20/@a);

        .box-center {
            display: flex;
            justify-content: space-around;
            width: (325/@a);
            height: (100/@a);
            background-color: #fff;
            border-radius: (15/@a);
            padding-top: (13/@a);
            margin-left: (10/@a);
            margin-top: (10/@a);

            li {
                margin-bottom: (10/@a);
            }

            .key {
                text-align-last: left;
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #808080;
            }

            .val {
                text-align: right;
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #202020;
            }
        }

        .box-top {
            display: flex;
            justify-content: space-around;
            margin-left: (15/@a);

            .k {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (14/@a);
                color: #101010;
            }

            .v {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 700;
                font-size: (24/@a);
                color: #21985D;
            }
        }
    }

    .btn {
        width: (325/@a);
        height: (45/@a);
        margin-top: (25/@a);
        margin-left: (25/@a);
        text-align: center;
        line-height: (45/@a);
        font-family: 'Inter';
        font-style: normal;
        font-weight: 700;
        font-size: (15/@a);
        color: #FFFFFF;
        background-color: #18C16D;
        border-radius: (28/@a);
    }

    .title {
        width: 100vw;
        height: (50/@a);
        padding-top: (5/@a);
        padding-left: (25/@a);
        background-color: #e3f9ec;
        font-family: 'Inter';
        font-style: normal;
        font-weight: 400;
        font-size: (14/@a);
        color: #217514;
    }
}
</style>