import router from "../../router";
import store from '../../store'
export default async function () {
    await store.dispatch('form/weiwancehngform')
    const form = store.state.form.formData
    let ele = {};
    for (var i in form) {
        ele = form[i] || {};
        break;
    }
    if (ele.formType == "OCR") {
        router.push('/ocr')
        //跳转OCR
        return;
    } else if (ele.formType == "ALIVE") {
        router.push('/alive')
        return
    } else if (ele.formType == "BASIC") {
        router.push('/baseForm')
        //条表单
        return
    } else {
        router.push('/productList')
    }
}