package com.money.money.box.loan.rupee.cash.utils;

public class Person {
    private String name;
    private int age;

    // 构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 获取姓名
    public String getName() {
        return this.name;
    }

    // 获取年龄
    public int getAge() {
        return this.age;
    }

    // 改变姓名
    public void changeName(String name) {
        this.name = name;
    }

    // 改变年龄
    public void changeAge(int age) {
        this.age = age;
    }

    // 通过字符串返回个人信息
    public String toString() {
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
}