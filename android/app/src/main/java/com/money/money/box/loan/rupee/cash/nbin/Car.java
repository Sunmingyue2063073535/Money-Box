package com.money.money.box.loan.rupee.cash.nbin;

public class Car {
    private String brand;
    private double price;

    // 构造方法
    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    // 获取品牌
    public String getBrand() {
        return this.brand;
    }

    // 获取价格
    public double getPrice() {
        return this.price;
    }

    // 改变品牌
    public void changeBrand(String brand) {
        this.brand = brand;
    }

    // 改变价格
    public void changePrice(double price) {
        this.price = price;
    }

    // 通过字符串返回汽车信息
    public String toString() {
        return "品牌：" + this.brand + "，价格：" + this.price;
    }
}