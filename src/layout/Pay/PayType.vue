<template>
    <div class="payType">
        <TopDesc desc="RepayMent Mode"></TopDesc>
        <div class="box">
            <div class="top">
                <div class="title">Repayment amount</div>
                <div class="amount">₹{{ this.$store.state.OInfo.actualAmount }}</div>
            </div>
            <div class="content">
                <div class="desc">Choose your payment mode:</div>
                <div class="type">
                    <div class="icon">
                        <img src="../../assets/bank.png" alt="">
                    </div>
                    <div class="text">Please Choose</div>
                </div>
                <div class="payTypeEle" v-for="item in list" @click="doPay(item)">{{ item.methodName }}</div>
            </div>
        </div>
        <Copy> </Copy>
    </div>
</template>
<script>
import { FKJYHLEHgetOrderPayType, FKJYHLEHgetOrderLinkAPI } from '../../api'
import { add } from "../../utils/key.js";
export default {
    data() {
        return {
            list: [],
            item: {},//选中的还款方式
            payInfo: {}
        }
    },
    methods: {
        //还款
        async doPay(item) {
            this.item = item
            const f = {
                model: {
                    orderId: this.$store.state.OID,
                    repayMethod: this.item.repayMethod,
                    methodCode: this.item.methodCode,
                    repayType: "IMMEDIATE"
                }
            }
            const r = await FKJYHLEHgetOrderLinkAPI(add(f))
            const href = r.model.repayCode
            setTimeout(() => {
                window.location.href = href
            }, 500);
        },
        //获取订单还款方式
        async getOrderPayType() {
            const f = {
                model: { orderId: this.$store.state.OID }
            }
            const r = await FKJYHLEHgetOrderPayType(add(f))
            console.log(r)
            this.list = r.model.methods
        }
    },
    created() {
        this.getOrderPayType()
    }
}
</script>
<style lang="less" scoped>
.payType {
    padding-top: (70/@a);

    .box {
        width: (345/@a);
        background-color: #f5f5f5;
        margin-left: (15/@a);
        border-radius: (15/@a);
        padding-bottom: (20/@a);

        .content {
            padding-top: (5/@a);
            padding-left: (25/@a);

            .payTypeEle {
                width: (80/@a);
                height: (26/@a);
                background-color: #18c16d;
                border-radius: (5/@a);
                font-family: 'Inter';
                font-style: normal;
                font-weight: 700;
                font-size: (12/@a);
                color: #FFFFFF;
                text-align: center;
                line-height: (26/@a);
                margin-top: (10/@a);
            }

            .type {
                display: flex;
                align-items: center;
                margin-top: (10/@a);
                vertical-align: middle;

                .text {
                    text-align: center;
                    font-family: 'Inter';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #101010;
                    margin-left: (10/@a);
                }

                .icon {
                    width: (20/@a);
                    height: (20/@a);

                    img {
                        width: 100%;
                    }
                }
            }

            .desc {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #217514;
            }
        }

        .top {
            width: 100%;
            height: (62/@a);
            background-color: #18c16d;
            border-radius: (15/@a) (15/@a) 0 0;
            padding-top: (5/@a);
            padding-left: (113/@a);

            .title {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #FFFFFF;
            }

            .amount {
                font-family: 'Inter';
                font-style: normal;
                font-weight: 700;
                font-size: (24/@a);
                color: #FFFFFF;
                margin-left: (5/@a);
            }
        }
    }
}
</style>