package com.money.money.box.loan.rupee.cash.Busl;

public class Cloth {
    private String name;
    private String color;

    // 构造方法
    public Cloth(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // 获取名称
    public String getName() {
        return this.name;
    }

    // 获取颜色
    public String getColor() {
        return this.color;
    }

    // 改变名称
    public void changeName(String name) {
        this.name = name;
    }

    // 改变颜色
    public void changeColor(String color) {
        this.color =color;
    }

    // 通过字符串返回服装信息
    public String toString() {
        return "名称：" + this.name + "，颜色：" + this.color;
    }
}