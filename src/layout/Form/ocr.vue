<template>
    <div class="ocr">
        <div class="top">
            <div class="top-callback">
                <div class="callback" @click="$router.back()">
                    <img src="@/assets/callback.png" alt="">
                </div>
                <div class="title">OCR inspection</div>
            </div>
            <div class="desc">*Please Upload A Clear Photo Of Your ID Card HereWhich Willlncrease The
                Success Rate of <span>Your Loan Application From 20% To30%</span></div>
        </div>
        <!-- 第一张  -->
        <div class="one">
            <div class="one-title">Aadhaar Front</div>
            <div class="ocr-img" @click="doone">
                <input class="sfz" id="sfzqian" type="file" accept="image/*" capture="camera" @change="uploadeSFZQian"
                    style="width:50px'">
                <img :src="sfzqImg" alt="">
            </div>
            <div class="one-desc">Click Here To Upload The Aadhaar Front</div>
        </div>
        <!-- 第二张 -->
        <div class="one">
            <div class="one-title">Aadhaar Back</div>
            <div class="ocr-img" @click="dotwo">
                <input class="sfz" id="sfzhou" type="file" accept="image/*" capture="camera" @change="uploadeSFZHou"
                    style="width:50px'">
                <img :src="sfzhImg" alt="">
            </div>
            <div class="one-desc">Click Here To Upload The Aadhaar Back</div>
        </div>
        <!-- 第三张 -->
        <div class="one">
            <div class="one-title">Pan Card Front</div>
            <div class="ocr-img" @click="doBank">
                <input class="sfz" id="bank" type="file" accept="image/*" capture="camera" @change="uploadeBank"
                    style="width:50px'">
                <img :src="bankImg" alt="">
            </div>
            <div class="one-desc">Click Here To Upload The Pan Card Front</div>
        </div>
        <div class="btn" @click="doContinue">Continue</div>
        <!-- 确认信息组件 -->
        <van-dialog v-model="isshow" title="OCR" titleColor="#12BD6A" :show-cancel-button="false" v-if="isshow"
            :show-confirm-button="false">
            <ocrDialog :user="user" :isupload="isupload" @doClose="isshow = false"></ocrDialog>
        </van-dialog>
    </div>
</template>
<script>
import { FKJYHLEHuploadFileApi, FKJYHLEHzhengjainshibieAPI } from "../../api";
import { add, unt } from '../../utils/key.js'
import { Toast } from "vant";
import ocrDialog from './ocrDialog'
export default {
    components: { ocrDialog },
    data() {
        return {
            sfzqImg: require('../../assets/ocr.png'),
            sfzhImg: require('../../assets/ocr.png'),
            bankImg: require('../../assets/ocr.png'),
            user: {
            },
            isupload: {
                sfzqImg: '',
                sfzhImg: '',
                bankImg: ''
            },
            isshow: false
        }
    },
    methods: {
        // 上传
        doContinue() {
            if (!this.isupload.sfzImg && !this.isupload.sfzhImg && !this.isupload.bankImg) {
                Toast('Please upload documents')
            } else {
                this.isshow = true
            }
        },
        //身份证钱
        uploadeSFZQian(event) {
            // this.$store.commit('showLoading')
            // 获取图片元素的引用
            const photo = this.$refs.photo
            // 获取用户选择的文件对象
            const file = event.target.files[0]
            // 创建一个FileReader对象，用于读取文件内容
            const reader = new FileReader()
            // 当文件读取完成后，触发onload事件
            reader.onload = async () => {
                // 将读取的文件内容设置为图片的src属性
                // photo.src = reader.result
                // this.$store.commit('showLoading')
                const newFile = this.base64toFile(reader.result, file.name)
                const fileObj = {
                    content: reader.result,
                    file: newFile,
                    message: '',
                    status: ''
                }
                const newFileObj = await this.photoZip(fileObj.file)
                console.log(newFileObj, '1')
                //压缩后的
                const res = await FKJYHLEHuploadFileApi(newFileObj)
                console.log(res)
                console.log(res, '上传图片的结果身份证前')
                if (res.status == 0) {
                    //识别证件的结果
                    console.log(res)
                    this.user = Object.assign({ ... await this.zjsb(res.model.id, 'FRONT') }, this.user)
                    this.sfzqImg = res.model.id
                    this.isupload.sfzqImg = res.model.id
                    this.user.sfqian = res.model.id
                }
            }
            // 开始读取文件内容，这会触发onload事件
            reader.readAsDataURL(file)
        },
        doone() {
            document.getElementById('sfzqian').click()
        },
        // 身份证后
        uploadeSFZHou(event) {
            this.$store.commit('showLoading')
            // 获取图片元素的引用
            const photo = this.$refs.photo
            // 获取用户选择的文件对象
            const file = event.target.files[0]
            // 创建一个FileReader对象，用于读取文件内容
            const reader = new FileReader()
            // 当文件读取完成后，触发onload事件
            reader.onload = async () => {
                this.$store.commit('showLoading')
                // 将读取的文件内容设置为图片的src属性
                // photo.src = reader.result

                const newFile = this.base64toFile(reader.result, file.name)
                const fileObj = {
                    content: reader.result,
                    file: newFile,
                    message: '',
                    status: ''
                }
                const newFileObj = await this.photoZip(fileObj.file)
                console.log(newFileObj, '1')
                //压缩后的
                const res = await FKJYHLEHuploadFileApi(newFileObj)
                if (res.status == 0) {
                    this.user = Object.assign({ ...await this.zjsb(res.model.id, 'BACK') }, this.user)
                    console.log(res, '上传图片的结果身份证前')
                    this.sfzhImg = res.model.id
                    this.isupload.sfzhImg = res.model.id
                    // this.user.sfqian = res.model.id
                }

            }
            // 开始读取文件内容，这会触发onload事件
            reader.readAsDataURL(file)
        },
        dotwo() {
            document.getElementById('sfzhou').click()
        },
        //银行卡
        uploadeBank(event) {
            this.$store.commit('showLoading')
            // 获取图片元素的引用
            const photo = this.$refs.photo
            // 获取用户选择的文件对象
            const file = event.target.files[0]
            // 创建一个FileReader对象，用于读取文件内容
            const reader = new FileReader()
            // 当文件读取完成后，触发onload事件
            reader.onload = async () => {
                // 将读取的文件内容设置为图片的src属性
                // photo.src = reader.result
                this.$store.commit('showLoading')
                const newFile = this.base64toFile(reader.result, file.name)
                const fileObj = {
                    content: reader.result,
                    file: newFile,
                    message: '',
                    status: ''
                }
                const newFileObj = await this.photoZip(fileObj.file)
                console.log(newFileObj, '1')
                //压缩后的
                const res = await FKJYHLEHuploadFileApi(newFileObj)
                if (res.status == 0) {
                    this.user = Object.assign({ ...await this.zjsb(res.model.id, 'PAN') }, this.user)
                    console.log(res, '上传图片的结果身份证前')
                    this.bankImg = res.model.id
                    this.isupload.bankImg = res.model.id
                    // this.user.sfqian = res.model.id
                }

            }
            // 开始读取文件内容，这会触发onload事件
            reader.readAsDataURL(file)
        },
        doBank() {
            document.getElementById('bank').click()
        },


        //base64转成file对象
        base64toFile(base64String, fileName) {
            const binaryString = atob(base64String.split(',')[1]);
            const buffer = new ArrayBuffer(binaryString.length);
            const bytes = new Uint8Array(buffer);

            for (let i = 0; i < binaryString.length; i++) {
                bytes[i] = binaryString.charCodeAt(i);
            }

            const blob = new Blob([buffer], { type: 'image/png' });
            return new File([blob], fileName, { type: 'image/png' });
        },
        // 压缩照片
        async photoZip(file) {
            return new Promise((resolve, reject) => {
                const reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = () => {
                    const base64 = reader.result;
                    const img = new Image();
                    img.src = base64;
                    img.onload = () => {
                        const canvas = document.createElement('canvas');
                        const context = canvas.getContext('2d');
                        canvas.width = img.width;
                        canvas.height = img.height;
                        context.drawImage(img, 0, 0);
                        const quality = 0.7;
                        const maxWidth = 800;
                        const maxHeight = 800;
                        let newBase64 = canvas.toDataURL('image/jpeg', quality);
                        console.log(newBase64.length / 1024, '11111111111111')
                        while (newBase64.length / 1024 > 100) {
                            canvas.width *= 0.9;
                            canvas.height *= 0.9;
                            context.drawImage(img, 0, 0, canvas.width, canvas.height);
                            newBase64 = canvas.toDataURL('image/jpeg', quality);
                        }
                        const blob = this.dataURLtoBlob(newBase64);
                        const newFile = new File([blob], file.name, { type: 'image/jpeg' });
                        console.log(newBase64.length / 1024, '33333333')
                        // 返回file对象格式
                        resolve({ file: newFile, content: newBase64, message: '', status: '' });
                    }
                }
                reader.onerror = reject;
            }
            );
        },
        dataURLtoBlob(dataURL) {
            const arr = dataURL.split(',');
            const mime = arr[0].match(/:(.*?);/)[1];
            const bstr = atob(arr[1]);
            let n = bstr.length;
            const u8arr = new Uint8Array(n);
            while (n--) {
                u8arr[n] = bstr.charCodeAt(n);
            }
            return new Blob([u8arr], { type: mime });
        },
        //证件识别
        async zjsb(file, cardType) {
            const form = {
                model: {
                    url: file,
                    cardType: cardType
                }
            }
            console.log(form, '证件识别的参数')
            const res = await FKJYHLEHzhengjainshibieAPI(add(form))
            if (res.status == 0) {
                console.log(res, '证件识别的结果')
                return res.model
            }
            return
        },
    },
}
</script>
<style lang="less" scoped>
.sfz {
    display: none;
}

.ocr {
    padding-bottom: (60/@a);

    .btn {
        position: fixed;
        bottom: (20/@a);
        left: (50/@a);
        text-align: center;
        line-height: (46/@a);
        width: (272/@a);
        height: (46/@a);
        background: linear-gradient(180deg, #32CE7A 0%, #12BD6A 100%);
        border-radius: (26/@a);
        font-family: 'Roboto';
        font-style: normal;
        font-weight: 500;
        font-size: (22/@a);
        color: #FFFFFF;
    }

    .one {
        width: (272/@a);
        height: (160/@a);
        background-color: #f9f9f9;
        margin-left: (50/@a);
        transform: translateY((-45/@a));
        padding-top: (5/@a);
        border-radius: (8/@a);
        margin-bottom: (10/@a);

        .one-desc {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #808080;
            margin-top: (20/@a);
            margin-left: (20/@a);
        }

        .ocr-img {
            width: (150/@a);
            height: (80/@a);
            margin-top: (5/@a);
            margin-left: (60/@a);

            img {
                width: (150/@a);
                height: (80/@a);
            }
        }

        .one-title {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            color: #2CAD49;
            margin-left: (95/@a);

        }
    }

    .top {
        width: 100vw;
        height: (163/@a);
        background-color: #18c16d;
        padding-top: (20/@a);
        padding-left: (20/@a);

        .desc {
            font-family: 'Inter';
            font-style: normal;
            font-weight: 400;
            font-size: (12/@a);
            margin-top: (14/@a);
            color: #fff;

            span {
                color: #FFF733;
            }
        }

        .top-callback {
            display: flex;

            .callback {
                width: (15/@a);
                height: (15/@a);

                img {
                    width: 100%;
                }
            }

            .title {
                margin-left: (100/@a);
                font-family: 'Roboto';
                font-style: normal;
                font-weight: 500;
                font-size: (16/@a);
                color: #fff;
            }
        }
    }
}
</style>