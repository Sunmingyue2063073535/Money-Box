<template>
    <div class="pettycash">
        <TopDesc desc="Petty Cash"></TopDesc>
        <div class="desc">Get more amount after instant payment</div>
        <div class="info">
            <div class="kefu" @click="$router.push('/FanKuiList')">
                <img src="../../assets/kefu.png" alt="">
            </div>
            <div class="title">Repayment amount</div>
            <div class="amount">₹{{ OInfo.actualAmount }}</div>
            <div class="list">
                <ul class="key">
                    <li>Loan note number</li>
                    <li>Phone number</li>
                    <li>Bank card number</li>
                    <li>Term(Days)</li>
                    <li>End date</li>
                    <li>Interest</li>
                    <li>Total service charge</li>
                    <li>Overdue interest</li>
                </ul>
                <ul class="val">
                    <li>{{ OInfo.orderId }}</li>
                    <li>{{ OInfo.phone }}</li>
                    <li>{{ OInfo.bankCard }}</li>
                    <li>{{ OInfo.loanTerm }}</li>
                    <li>{{ new Date(OInfo.expiryTime).toLocaleDateString() }}</li>
                    <li>{{ a(OInfo.interestRate) }}</li>
                    <li>{{ OInfo.interestAmount.toFixed(2) }}</li>
                    <li>{{ OInfo.expiryAmount.toFixed(2) }}</li>
                </ul>
            </div>
            <div class="bottom">
                <div class="rollover" @click="$router.push('/Rollover')">Rollover</div>
                <div class="repayment" @click="$router.push('/PayType')">Full Repayment</div>
            </div>
        </div>
        <Copy></Copy>
    </div>
</template>
<script>
export default {
    methods: {
        //转换百分数保留两位小数
        a(point) {
            let str = Number(point * 100).toFixed(2);
            str += "%";
            return str;
        },
    },
    computed: {
        OInfo() {
            return this.$store.state.OInfo
        }
    }
}
</script>
<style lang="less" scoped>
.pettycash {
    padding-top: (70/@a);

    .info {
        position: relative;
        width: (335/@a);
        height: (368/@a);
        background-color: #f5f5f5;
        border-radius: (15/@a);
        margin-top: (20/@a);
        margin-left: (20/@a);
        padding-top: (21/@a);

        .kefu {
            position: absolute;
            top: (20/@a);
            right: (20/@a);
            width: (40/@a);
            height: (40/@a);

            img {
                width: 100%;
            }
        }

        .bottom {
            display: flex;
            justify-content: space-around;
            margin-top: (20/@a);

            .repayment {
                width: (140/@a);
                height: (38/@a);
                border: (1/@a) solid #18C16D;
                border-radius: (18/@a);
                background-color: #18c16d;
                text-align: center;
                line-height: (38/@a);
                font-family: 'Inter';
                font-style: normal;
                font-weight: 600;
                font-size: (12/@a);
                color: #fff;
            }

            .rollover {
                width: (140/@a);
                height: (38/@a);
                border: (1/@a) solid #18C16D;
                border-radius: (18/@a);
                background-color: #f5f5f5;
                text-align: center;
                line-height: (38/@a);
                font-family: 'Inter';
                font-style: normal;
                font-weight: 600;
                font-size: (12/@a);
                color: #18C16D;
            }
        }

        .list {
            width: (305/@a);
            height: (200/@a);
            background-color: #e3f9ec;
            margin-top: (10/@a);
            margin-left: (15/@a);
            padding-top: (10/@a);
            display: flex;
            justify-content: space-between;


            .key {
                margin-left: (15/@a);

                li {
                    font-family: 'Inter';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #808080;
                    margin-bottom: (5/@a);
                }
            }

            .val {
                text-align: right;
                margin-right: (15/@a);

                li {
                    font-family: 'Inter';
                    font-style: normal;
                    font-weight: 400;
                    font-size: (12/@a);
                    color: #202020;
                    margin-bottom: (5/@a);
                }
            }
        }

        .title {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #21985D;
            padding-left: (110/@a);
        }

        .amount {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 700;
            font-size: (28/@a);
            color: #21985D;
            padding-left: (110/@a);
        }
    }

    .desc {
        width: 100vw;
        height: (44/@a);
        background-color: #e3f9ec;
        text-align: center;
        line-height: (44/@a);
        font-family: 'Inter';
        font-style: normal;
        font-weight: 400;
        font-size: (14/@a);
        color: #217514;
    }
}
</style>