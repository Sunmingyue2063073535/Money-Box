package com.money.money.box.loan.rupee.cash.nbin;

public class Book {
    private String name;
    private String author;
    private double price;

    // 构造方法
    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // 获取名称
    public String getName() {
        return this.name;
    }

    // 获取作者
    public String getAuthor() {
        return this.author;
    }

    // 获取价格
    public double getPrice() {
        return this.price;
    }

    // 改变名称
    public void changeName(String name) {
        this.name = name;
    }

    // 改变作者
    public void changeAuthor(String author) {
        this.author = author;
    }

    // 改变价格
    public void changePrice(double price) {
        this.price = price;
    }

    // 通过字符串返回书籍信息
    public String toString() {
        return "书名：" + this.name + "，作者：" + this.author + "，价格：" + this.price;
    }
}