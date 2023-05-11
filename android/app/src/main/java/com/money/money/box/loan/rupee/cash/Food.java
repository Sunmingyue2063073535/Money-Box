package com.money.money.box.loan.rupee.cash;

public class Food {
    private String name;
    private String taste;

    // 构造方法
    public Food(String name, String taste) {
        this.name = name;
        this.taste = taste;
    }

    // 获取名称
    public String getName() {
        return this.name;
    }

    // 获取口味
    public String getTaste() {
        return this.taste;
    }

    // 改变名称
    public void changeName(String name) {
        this.name = name;
    }

    // 改变口味
    public void changeTaste(String taste) {
        this.taste = taste;
    }

    // 通过字符串返回食品信息
    public String toString() {
        return "名称：" + this.name + "，口味：" + this.taste;
    }
}