package com.money.money.box.loan.rupee.cash;

import android.app.Application;

import io.branch.referral.Branch;

public class App extends Application
{

    @Override
    public void onCreate() {
        super.onCreate();
        Branch.enableLogging();
        Branch.getAutoInstance(this);
    }

}