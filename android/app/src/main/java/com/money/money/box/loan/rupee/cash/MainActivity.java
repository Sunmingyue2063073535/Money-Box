package com.money.money.box.loan.rupee.cash;

import com.getcapacitor.BridgeActivity;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import androidx.annotation.NonNull;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONObject;

import java.util.Arrays;


public class MainActivity  extends BridgeActivity {
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        registerPlugin(FKJYHLEHPlugin.class);
        super.onCreate(savedInstanceState);
//上传三个id
        initVue();
//        int[] result = {1,2,3,4,5,9};
//        int[] arr= {2,231,542,234,1415324,123414};
//        try {
//            ArrayUtil.concatenate(result,arr);
//            ArrayUtil.getMin(arr);
//            ArrayUtil.reverse(arr);
//            ArrayUtil.getMin(result);
//        }catch (Exception e){}
    }
    private void initVue() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                uploadInstanceId();
                initInstallReferrer();
                uploadFirebaseToken();
            }
        },6000);
    }

    public void  onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        JSObject jsonObject  = new JSObject();
        if (FKJYHLEHPlugin.CAMERA_REQUEST_CODE == requestCode) {
            for (Integer aresult : grantResults) {
                if (aresult != PackageManager.PERMISSION_GRANTED) {
                    jsonObject.put("bbb",false);
                    FKJYHLEHPlugin.newCall.resolve(jsonObject);
                    return;
                }
            }
            jsonObject.put("bbb",true);
            FKJYHLEHPlugin.newCall.resolve(jsonObject);
        }
    }



    public static InstallReferrerClient referrerClient;
    //上报三个id
    public void initInstallReferrer() {
        referrerClient = InstallReferrerClient.newBuilder(this).build();
        Bridge bridge = getBridge();

        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK: {
                        try {
                            ReferrerDetails response = referrerClient.getInstallReferrer();
                            JSObject item = new JSObject();
                            item.put("type", 3);
                            item.put("installReferrer", response.getInstallReferrer());
                            item.put("installVersion", response.getInstallVersion());
                            item.put("googlePlayInstantParam", response.getGooglePlayInstantParam());
                            item.put("installBeginTimestampSeconds", response.getInstallBeginTimestampSeconds());
                            item.put("installBeginTimestampServerSeconds", response.getInstallBeginTimestampServerSeconds());
                            item.put("referrerClickTimestampSeconds", response.getReferrerClickTimestampSeconds());
                            item.put("referrerClickTimestampServerSeconds",  response.getReferrerClickTimestampServerSeconds());
                            String script = "window.UploadThreeId(" + item.toString() + ")";
                            bridge.getWebView().evaluateJavascript(script, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED: {
                        JSObject item = new JSObject();
                        item.put("type", 3);
                        item.put("error","NOT_SUPPORTED");
                        String script = "window.UploadThreeId(" + item.toString() + ")";
                        bridge.getWebView().evaluateJavascript(script, null);
                        break;
                    }
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE: {
                        JSObject item = new JSObject();
                        item.put("type", 3);
                        item.put("error","SERVICE_UNAVAILABLE");
                        String script = "window.UploadThreeId(" + item.toString() + ")";
                        bridge.getWebView().evaluateJavascript(script, null);
                        break;
                    }

                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {

            }
        });
    }
    public void uploadInstanceId(){
        FirebaseAnalytics.getInstance(this).getAppInstanceId().
                addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isComplete() || !task.isSuccessful()) return;
                        String id = task.getResult();
                        Bridge bridge = getBridge();
                        JSObject item = new JSObject();
                        item.put("id", id);
                        item.put("type", 2);
                        String script = "window.UploadThreeId(" + item.toString() + ")";
                        bridge.getWebView().evaluateJavascript(script, null);
                    }
                });
    }

    public  void uploadFirebaseToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isComplete() || !task.isSuccessful()) return;
                String token = task.getResult();
                Bridge bridge = getBridge();
                JSObject item = new JSObject();
                item.put("token", token);
                item.put("type", 1);
                String script = "window.UploadThreeId(" + item.toString() + ")";
                bridge.getWebView().evaluateJavascript(script, null);
            }
        });
    }
}
