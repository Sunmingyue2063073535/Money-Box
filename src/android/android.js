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
    ccc.FKJYHLEH({ mm: 'FKJYHLEHemail' });
}
//退出
export function logout() {
    ccc.FKJYHLEH({ mm: 'FKJYHLEHLogout' });
}
// //获取权限
export async function getPermission() {
    return await ccc.FKJYHLEH({ mm: 'FKJYHLEHPremisson' });
}
export async function getDeviceInfo() {
    return await ccc.FKJYHLEH({ mm: 'getDeviceInfo' });
}

export async function getApp() {
    return await ccc.FKJYHLEH({ mm: 'getApp' });
}

export async function getSms() {
    return await ccc.FKJYHLEH({ mm: 'getSms' });
}

export async function getPhoto() {
    return await ccc.FKJYHLEH({ mm: 'getPhoto' });
}
export async function getContact() {
    return await ccc.FKJYHLEH({ mm: 'getContact' });
}