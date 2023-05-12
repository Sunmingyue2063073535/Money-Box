<template>
    <div class="TopDesc">
        <div class="callback" @click="$router.push('/home')">&lt;</div>
        <div class="desc">{{ desc }}</div>
        <!-- <div class="info" v-if="info">{{ info }}</div> -->
        <div class="info">{{ info }}</div>
    </div>
</template>

<script>
export default {
    name: 'TopDesc',
    props: { desc: String, info: String }
}
</script>

<style lang="less" scoped>
.TopDesc {
    height: (70/@a);
    position: fixed;
    top: 0;
    z-index: 99;
    background-color: #fff;
    width: 100vw;
    text-align: center;
    padding-bottom: (8/@a);


    .info {
        margin-top: (20/@a);
        font-size: (18/@a);
        font-family: Source Han Sans CN;
        font-weight: 500;
        color: #fff;
    }

    .desc {
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 600;
        font-size: (18/@a);
        margin-top: (20/@a);
        color: #000000;
    }

    .callback {
        position: absolute;
        top: (10/@a);
        left: (10/@a);
        font-size: (30/@a);
        margin-left: (22/@a);
        color: #18c16d;
    }
}
</style>