<template>
    <div class="myloan">
        <TopDesc desc="My Loan"></TopDesc>
        <!-- 顶部导航 -->
        <ul class="nav">
            <li v-for="(item, index) in navList" :key="item.id" @click="doTab(item, index)"
                :class="{ active: index == isActiveId }">{{
                    item.name }}</li>
        </ul>
        <!-- 产品列表 -->
        <ul class="pr-list" v-if="list.length">
            <li v-for="item in list">
                <div class="li-top">
                    <div class="li-top-icon">
                        <img :src="icon(item.product.icon)" alt="">
                    </div>
                    <div class="li-top-name">{{ item.product.name }}</div>
                    <div class="li-top-btn" :style="{ 'color': item.statusColor }" @click="doStatusBtn(item)">{{
                        item.statusName }}</div>
                </div>
                <div class="li-content">
                    <div class="li-c-left">
                        <div class="li-key">Loan Amount</div>
                        <div class="li-key">term（Days）</div>
                        <div class="li-key">loan date</div>
                        <div class="li-key">loan note number</div>
                        <div class="li-key" v-if="item.status === 'PASS' || item.status === 'LOAN_SUCCESS'">Ask Questions
                        </div>
                    </div>
                    <div class="li-c-right">
                        <div class="li-val">rs {{ item.amount }}</div>
                        <div class="li-val">{{ item.term }} {{ item.termUnit }}</div>
                        <div class="li-val">{{ new Date(item.created).toLocaleDateString() }}</div>
                        <div class="li-val">{{ item.id }}</div>
                        <div class="kefu-val" v-if="item.status === 'PASS' || item.status === 'LOAN_SUCCESS'"
                            @click="doKefuList(item)">
                            <img src="../../assets/kefu.png" alt="">
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <div v-if="!list.length" class="noOrder">NULL</div>
    </div>
</template>
<script>
import { FKJYHLEHgetDingDanListAPI, FKJYHLEHdingdanhuankuanAPI } from "../../api";
import { add } from "../../utils/key.js";
import { Toast } from "vant";
export default {
    data() {
        return {
            //顶部状态数据
            navList: [
                { id: 0, name: 'ALL', msg: null },
                { id: 1, name: 'Success', msg: 'LOAN_SUCCESS' },
                { id: 2, name: 'Overdue', msg: 'DUNNING' },
                { id: 3, name: 'Finish', msg: 'FINISH' },
            ],
            //点击选中的id
            isActiveId: this.$store.state.count,
            list: []
        }
    },
    methods: {
        doKefuList() {
            this.$router.push('/FanKuiList')
        },
        //去还款
        async doStatusBtn(item) {
            if (!item.loan) {
                Toast(item.statusNote)
                return
            }
            //将订单id存入vuex中
            this.$store.commit('setOID', item.id)
            //获取订单还款计划
            const f = {
                model: { orderId: this.$store.state.OID }
            }
            const r = await FKJYHLEHdingdanhuankuanAPI(add(f))
            //将信息存入vuex
            this.$store.commit('setOInfo', r.model)
            console.log(this.$store.state.OInfo, 'ximxi')
            this.$router.push('/PettyCash')
        },
        //获取订单列表
        async getOrderList(status) {
            const f = {
                query: {
                    status: status,
                    pageNo: 1,
                    pageSize: 100
                }
            }
            const r = await FKJYHLEHgetDingDanListAPI(add(f))
            this.list = r.page.content
            console.log(r)
        },
        //切换顶部状态
        doTab(item, index) {
            this.isActiveId = item.id
            this.getOrderList(this.navList[index].msg)
        },
        icon(icon) {
            return `https://app.money-box.xyz/lt-image/resize/0x0/${icon}`
        },
    },
    created() {
        const count = this.$store.state.count
        const state = this.navList[count].msg
        console.log(state)
        this.getOrderList(state)
    }
}
</script>
<style lang="less" scoped>
.noOrder {
    margin-top: (200/@a);
    margin-left: (150/@a);
    font-family: 'Roboto';
    font-style: normal;
    font-weight: 400;
    font-size: (30/@a);
    color: #B3B3B3;
}

.myloan {
    padding-top: (80/@a);

    .pr-list {
        padding-bottom: (20/@a);

        li {
            &:first-child {
                margin-top: (27/@a);
            }

            &:last-child {
                margin-bottom: 0;
            }

            width: (345/@a);
            background-color: #18c16d;
            border-radius: (15/@a);
            margin-bottom: (20/@a);
            margin-left: (16/@a);
            padding-top: (11/@a);
            padding-bottom: (20/@a);

            .li-top {
                margin-left: (14/@a);
                display: flex;
                align-items: center;

                .li-top-icon {
                    width: (22/@a);
                    height: (22/@a);

                    img {
                        width: 100%;
                    }
                }

                .li-top-name {
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 500;
                    font-size: (14/@a);
                    flex: 1;
                    color: #FFFFFF;
                    margin-left: (10/@a);
                }

                .li-top-btn {
                    width: (100/@a);
                    height: (24/@a);
                    background-color: #fff;
                    border-radius: (12/@a);
                    margin-right: (10/@a);
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 500;
                    font-size: (12/@a);
                    text-align: center;
                    line-height: (24/@a);
                    color: #18C16D;
                }

            }

            .li-content {
                width: (315/@a);
                background-color: #fff;
                margin-left: (15/@a);
                margin-top: (10/@a);
                border-radius: (15/@a);
                display: flex;
                justify-content: space-between;
                padding: (11/@a) (17/@a);

                .kefu-val {
                    width: (35/@a);
                    height: (35/@a);
                    transform: translateX((90/@a));

                    img {
                        width: 100%;
                    }
                }

                .li-c-left {
                    text-align: left;
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #919191;

                    .li-key {
                        margin-bottom: (5/@a);
                    }
                }

                .li-c-right {
                    text-align: right;
                    font-family: 'Roboto';
                    font-style: normal;
                    font-weight: 500;
                    font-size: (12/@a);
                    color: #373737;
                    margin-bottom: (6/@a);

                    .li-val {
                        margin-bottom: (5/@a);
                    }
                }
            }
        }
    }

    .nav {
        display: flex;
        justify-content: space-around;

        .active {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 400;
            font-size: (14/@a);
            color: #3F2509;
            border-bottom: (2/@a) solid #18C16D;
        }

        li {
            font-family: 'Roboto';
            font-style: normal;
            font-weight: 400;
            font-size: (14/@a);
            color: #B3B3B3;
        }
    }
}
</style>