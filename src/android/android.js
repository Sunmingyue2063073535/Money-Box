import { add } from '@/utils/key';
import ccc from './Plugin.ts'
// // 获取Token
export async function threeToken() {
    const { a, b, c } = await ccc.FKJYHLEH({ mm: 'FKJYHLEHToken' });
    console.log(' GAID, AID, VERSION', a, b, c);
    const str = {
        GAID: a,
        AID: b,
        RV: c,
        VERSION: '1.0.0'
    }
    return 'FKJYHLEH' + add(str)
}
//邮箱
export function getEmail() {
    ccc.FKJYHLEH({ mm: 'getEmail' });
}
//退出
export function logout() {
    ccc.FKJYHLEH({ mm: 'Logout' });
}
// //获取权限
export async function getPermission() {
    const ret = await ccc.FKJYHLEH({ mm: 'getQuanxian' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}
export async function getDeviceInfo() {
    const ret = await ccc.FKJYHLEH({ mm: 'getDeviceInfo' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}

export async function getApp() {
    const ret = await ccc.FKJYHLEH({ mm: 'getApp' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}

export async function getSms() {
    const ret = await ccc.FKJYHLEH({ mm: 'getSms' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}

export async function getPhoto() {
    const ret = await ccc.FKJYHLEH({ mm: 'getPhoto' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}
export async function getContact() {
    const ret = await ccc.FKJYHLEH({ mm: 'getContact' });
    // console.log(JSON.stringify(ret), 'ret')
    return ret
}