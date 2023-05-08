<template>
    <div class="productList" :class="{ a: selectIndex !== -1 }">
        <TopDesc desc="Product List"></TopDesc>
        <div class="top">
            <div class="top-left">My Loan History</div>
            <div class="top-right" @click="$router.push('/myloan')">View</div>
        </div>
        <!-- 产品列表 -->
        <ul class="list">
            <li v-for="( item, index ) in  list " :key="item.id" @click="doSelect(item, index)"
                :class="{ active: selectIndex == index }">
                <div class="list-top">
                    <div class="list-icon">
                        <img :src="icon(item.icon)" alt="">
                    </div>
                    <div class="list-name">{{ item.name }}</div>
                </div>
                <div class="list-desc">
                    <div class="list-desc-left">
                        <div class="list-desc-left-key">Loan Amount</div>
                        <div class="list-desc-left-val">rs {{ item.amount }}</div>
                    </div>
                    <div class="list-desc-right">
                        <div class="list-desc-left-key">Term（days）</div>
                        <div class="list-desc-left-val">{{ item.term }} </div>
                    </div>
                </div>
                <div class="list-content">
                    <div class="list-left">
                        <div class="list-key">interest</div>
                        <div class="list-key">Total service charge</div>
                        <div class="list-key">Amount received</div>
                        <div class="list-key">repayment amount</div>
                    </div>
                    <div class="list-right">
                        <div class="list-val">{{ toPercent(item.dayRate) }}</div>
                        <div class="list-val">rs {{ item.serviceAmount }}</div>
                        <div class="list-val">rs {{ item.amount - item.serviceAmount }}</div>
                        <div class="list-val">rs {{ item.amount }}</div>
                    </div>
                </div>
            </li>
        </ul>
        <!-- 提交按钮 -->
        <div class="bottom" v-if="selectIndex !== -1">
            <div class="btn" @click="doClick">Submit</div>
        </div>
        <van-dialog v-model="isShow" :showCancelButton="false" :showConfirmButton="false">
            <productMask :shouxufeiArr="shouxufeiArr" @closeDialog="isShow = false"></productMask>
        </van-dialog>
    </div>
</template>
<script>
import { FKJYHLEHgetOrderListAPI, FKJYHLEHgetOrderPayAPI } from "../../api";
import { add } from "../../utils/key.js";
import productMask from './productMask'
export default {
    components: { productMask },
    data() {
        return {
            list: [],
            selectIndex: -1,
            isShow: false,
            shouxufeiArr: []
        }
    },
    methods: {
        //点击提交
        async doClick() {
            const f = {
                model: {
                    productIds: [this.$store.state.PID]
                }
            }
            const r = await FKJYHLEHgetOrderPayAPI(add(f))
            this.shouxufeiArr = r.model
            this.isShow = true
        },
        //选中商品
        doSelect(item, index) {
            this.selectIndex = index
            const PID = this.list[this.selectIndex].id
            console.log(this.selectIndex)
            console.log(this.list[this.selectIndex].id)
            //将选中的产品id存入vuex
            this.$store.commit('setPID', PID)
        },
        //获取产品数据
        async getList() {
            const f = {
                query: {}
            }
            const res = await FKJYHLEHgetOrderListAPI(add(f))
            this.list = res.page.content
            console.log(res)
        },
        toPercent(point) {
            let str = Number(point * 100).toFixed(2);
            str += "%";
            return str;
        },
        icon(icon) {
            return `https://app.money-box.xyz/lt-image/resize/0x0/${icon}`
        },
    },
    created() {
        this.getList()
    }
}


</script>
<style lang="less" scoped>
.a {
    padding-bottom: (90/@a);
}

.productList {
    padding-top: (70/@a);


    .bottom {
        width: 100vw;
        height: (80/@a);
        position: fixed;
        bottom: 0;
        left: 0;
        background-color: #fff;
        z-index: 99;

        .btn {
            width: (305/@a);
            height: (52/@a);
            background: linear-gradient(180deg, #32CE7A 0%, #12BD6A 100%);
            border-radius: (26/@a);
            text-align: center;
            line-height: (52/@a);
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 500;
            font-size: (22/@a);
            margin-left: (35/@a);
            margin-top: (14/@a);
            color: #FFFFFF;

        }
    }

    .list {
        margin-left: (30/@a);

        .active {
            border: (2/@a) solid #18C16D !important;
        }

        li {
            width: (320/@a);
            height: (170/@a);
            background-color: #f4f4f4;
            border-radius: (16/@a);
            border: (2/@a) solid transparent;
            margin-bottom: (15/@a);
            padding-top: (12/@a);

            .list-top {
                margin-left: (64/@a);
                display: flex;
                align-items: center;

                .list-icon {
                    width: (24/@a);
                    height: (24/@a);

                    img {
                        width: 100%;
                    }
                }

                .list-name {
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 500;
                    font-size: (14/@a);
                    color: #272323;
                    margin-left: (8/@a);
                }
            }

            .list-desc {
                width: (320/@a);
                height: (47/@a);
                background-color: #18C16D;
                margin-top: (5/@a);
                display: flex;
                justify-content: center;

                .list-desc-right {
                    margin-left: (50/@a);
                }

                .list-desc-left-key {
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #FFFFFF;
                }

                .list-desc-left-val {
                    text-align: center;
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 600;
                    font-size: (20/@a);
                    color: #FFFFFF;


                }
            }

            .list-content {
                display: flex;
                justify-content: space-around;
                padding-top: (5/@a);

                .list-left {
                    .list-key {
                        font-family: 'Roboto';
                        font-style: normal;
                        font-weight: 400;
                        font-size: (12/@a );
                        color: #7E7E7E;
                    }
                }

                .list-right {
                    .list-val {
                        font-family: 'Roboto';
                        font-style: normal;
                        font-weight: 400;
                        font-size: (12/@a);
                        color: #7E7E7E;
                    }
                }
            }
        }
    }

    .top {
        width: 100vw;
        height: (42/@a);
        display: flex;
        justify-content: space-between;
        padding-left: (18/@a);
        padding-right: (18/@a);
        margin-bottom: (13/@a);

        .top-right {
            width: (60/@a);
            height: (26/@a);
            background-color: #18c16d;
            text-align: center;
            line-height: (26/@a);
            border-radius: (6/@a);
        }
    }
}
</style>