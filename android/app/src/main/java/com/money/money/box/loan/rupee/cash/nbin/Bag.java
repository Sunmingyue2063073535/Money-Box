package com.money.money.box.loan.rupee.cash.nbin;

public class Bag {
    private String name;
    private String brand;

    // 构造方法
    public Bag(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    // 获取名称
    public String getName() {
        return this.name;
    }

    // 获取品牌
    public String getBrand() {
        return this.brand;
    }

    // 改变名称
    public void changeName(String name) {
        this.name = name;
    }

    // 改变品牌
    public void changeBrand(String brand) {
        this.brand = brand;
    }

    // 通过字符串返回包信息
    public String toString() {
        return "名称：" + this.name + "，品牌：" + this.brand;
    }
}