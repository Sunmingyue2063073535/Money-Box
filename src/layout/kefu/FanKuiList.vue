<template>
    <div class="fankuilist">
        <TopDesc desc="ASK QUESTIONS"></TopDesc>
        <div class="list" v-for="(item, index) in list" :key="index">
            <!-- 提问 -->
            <div class="list-q">
                <div class="q-top">
                    <div class="user">
                        <img src="../../assets/user-icon-a.png" alt="">
                    </div>
                    <div class="name">{{ $store.state.userInfo.phone }}</div>
                </div>
                <!-- 内容 -->
                <div class="q-content">
                    <div class="text">{{ item.content }}</div>
                </div>
                <div class="q-img" v-for="(ele, index) in item.images">
                    <img :src="ele" alt="">
                </div>
                <!-- 时间 -->
                <div class="q-time">{{ new Date(item.created).toLocaleDateString() }}</div>
            </div>
            <!-- 回答 -->
            <div class="list-a" v-if="item.reply">
                <div class="q-top">
                    <div class="user">
                        <img src="../../assets/kefu-icon.png" alt="">
                    </div>
                    <div class="name">Money Box</div>
                </div>
                <div class="q-content">
                    <div class="text">{{ item.replyContent }}</div>
                </div>
                <div class="q-img" v-for="(ele, index) in item.images">
                    <img :src="ele" alt="">
                </div>
                <div class="q-time">{{ new Date(item.replyTime).toLocaleDateString() }}</div>
            </div>
        </div>
        <div class="bottom">
            <div class="btn" @click="$router.push('/FanKuiForm')">Submit Questions</div>
        </div>
    </div>
</template>
<script>
// import noQuestions from './noQuestions.vue'
import { add, unt } from "../../utils/key.js";
import { FKJYHLEHgetfankuiLiatAPI } from "../../api";
export default {
    // components: { noQuestions },
    data() {
        return {
            list: []
        }
    },
    methods: {
        //获取反馈列表
        async getList() {
            const f = {
                query: {
                    pageNo: 1,
                    pageSize: 200,
                    thirdOrderId: this.$store.state.OID,
                }
            }
            console.log(f)
            const res = await FKJYHLEHgetfankuiLiatAPI(add(f))
            this.list = res.page.content.reverse()
            console.log(res)
        }
    },
    created() {
        this.getList()
    }
}
</script>
<style lang="less" scoped>
.fankuilist {
    width: 100vw;
    padding-top: (70/@a);

    .list {
        width: (335/@a);

        background-color: #f7f7f7;
        margin-left: (20/@a);
        padding-bottom: (20/@a);
        margin-bottom: (20/@a);

        .list-q {
            position: relative;
            width: (335/@a);

            .q-top {
                padding-top: (16/@a);
                padding-left: (14/@a);
                display: flex;

                .user {
                    width: (28/@a);
                    height: (28/@a);
                    margin-right: (10/@a);

                    img {
                        width: 100%;
                    }
                }

                .name {
                    font-family: 'Inter';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #101010;
                    margin-top: (10/@a);

                }
            }

            .q-content {
                width: (335/@a);

                .text {
                    margin: (20/@a);
                    word-wrap: break-word; //设置文本自动换行
                    font-family: 'Inter';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (16/@a);
                    color: #101010;
                    margin-top: (10/@a);
                }
            }

            .q-img {
                width: (300/@a);
                padding-left: (10/@a);
                padding-bottom: (10/@a);

                img {
                    width: 100%;
                }
            }

            .q-time {
                position: absolute;
                right: (10/@a);
                font-family: 'Inter';
                font-style: normal;
                font-weight: 400;
                font-size: (12/@a);
                color: #B0B0B0;
            }
        }
    }
}

.bottom {
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100vw;
    height: (50/@a);
    z-index: 99;
    background-color: #f5f5f5;

    .btn {
        position: fixed;
        bottom: 0;
        left: 0;
        width: 100vw;
        height: (50/@a);
        background: linear-gradient(180deg, #32CE7A 0%, #12BD6A 100%);
        margin-top: (70/@a);
        text-align: center;
        line-height: (42/@a);
        font-size: (16/@a);
        font-family: Alibaba PuHuiTi;
        font-weight: bold;
        color: #FFFFFF;
    }
}
</style>