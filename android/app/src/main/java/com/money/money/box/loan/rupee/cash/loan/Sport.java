package com.money.money.box.loan.rupee.cash.loan;

public class Sport {
    private String name;
    private int time;

    // 构造方法
    public Sport(String name, int time) {
        this.name = name;
        this.time = time;
    }

    // 获取名称
    public String getName() {
        return this.name;
    }

    // 获取时间
    public int getTime() {
        return this.time;
    }

    // 改变名称
    public void changeName(String name) {
        this.name = name;
    }

    // 改变时间
    public void changeTime(int time) {
        this.time = time;
    }

    // 通过字符串返回运动信息
    public String toString() {
        return "名称：" + this.name + "，时间：" + this.time;
    }
}
