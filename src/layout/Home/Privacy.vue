<template>
    <div class="privacy">
        <div class="title">User Services Agreement <span @click="$emit('privacyClose')">X</span></div>
        <iframe src="https://app.money-box.xyz/instability_dominator_clitellum/paronomasia/fill_reich/grx8dh.html"
            frameborder="0"></iframe>
    </div>
</template>

<style lang="less" scoped>
.privacy {
    padding-bottom: (30/@a);

    .title {
        width: 100%;
        height: (50/@a);
        background-color: #21cf77;
        font-size: (18/@a);
        text-align: center;
        line-height: (50/@a);
        font-weight: bold;
        font-style: Source Han Sans CN;
        color: #fff;

        span {
            margin-left: (30/@a);
        }
    }

    iframe {
        width: 100%;
        height: (300/@a);
    }
}
</style>