package com.money.money.box.loan.rupee.cash.utils;

import com.money.money.box.loan.rupee.cash.Animal;
import com.money.money.box.loan.rupee.cash.Busl.Cloth;
import com.money.money.box.loan.rupee.cash.Busl.Computer;
import com.money.money.box.loan.rupee.cash.Food;
import com.money.money.box.loan.rupee.cash.Fruit;
import com.money.money.box.loan.rupee.cash.loan.Sport;
import com.money.money.box.loan.rupee.cash.nbin.Bag;
import com.money.money.box.loan.rupee.cash.nbin.Book;
import com.money.money.box.loan.rupee.cash.nbin.Car;

public class Text {
    public static void callAllMethods() {
        // 创建一个Person对象
        Person person = new Person("张三", 20);
        // 创建一个Animal对象
        Animal animal = new Animal("狗", 3);
        // 创建一个Fruit对象
        Fruit fruit = new Fruit("苹果", "红色");
        // 创建一个Book对象
        Book book = new Book("Java 编程思想", "Bruce Eckel", 78.5);
        // 创建一个Computer对象
        Computer computer = new Computer("戴尔", 5000);
        // 创建一个Car对象
        Car car = new Car("奔驰", 78000);
        // 创建一个Sport对象
        Sport sport = new Sport("跑步", 60);
        // 创建一个Food对象
        Food food = new Food("汉堡", "咸甜口味");
        // 创建一个Cloth对象
        Cloth cloth = new Cloth("衬衫", "蓝色");
        // 创建一个Bag对象
        Bag bag = new Bag("双肩包", "NIKE");

        // 调用Person类中的方法
        System.out.println(person.getName() + "今年" + person.getAge() + "岁。");
        person.changeName("李四");
        person.changeAge(25);
        System.out.println("但是他最近决定改名为" + person.getName() + "，并且改变了年龄为" + person.getAge() + "岁。");

        // 调用Animal类中的方法

                // 调用Fruit类中的方法
                System.out.println("我最喜欢吃的水果是" + fruit.getName() + "，它的颜色是" + fruit.getColor() + "。");

        // 调用Book类中的方法
        System.out.println("我正在读的书名为" + book.getName() + "，作者为" + book.getAuthor() + "，价格为" + book.getPrice() + "元。");

        // 调用Computer类中的方法
        System.out.println("我最近买了一台" + computer.getBrand() +"品牌的电脑，价格为" + computer.getPrice() + "元。");
        computer.changePrice(5500);
        System.out.println("但是昨天突然发现电脑坏了，只好去修理，结果修理费用为" + computer.getPrice() + "元。");

        // 调用Car类中的方法
        System.out.println("我最近也添了一辆" + car.getBrand() +"品牌的汽车，价格为" + car.getPrice() + "元。");
        car.changePrice(76000);
        System.out.println("但是今天发现同款车在另一家卖家那里价值更大，所以决定出售我的这辆汽车。售价为" + car.getPrice() + "元。");

        // 调用Sport类中的方法
        System.out.println("今天我锻炼了" + sport.getName() + "，时间为" + sport.getTime() + "分钟。");
        sport.changeName("跳绳");
        sport.changeTime(30);
        System.out.println("但是我觉得运动时间太长了，所以改变为" + sport.getName() + "，时间缩短为" + sport.getTime() + "分钟。");

        // 调用Food类中的方法
        System.out.println("今天我吃了一份" + food.getName() + "，口感非常" + food.getTaste() + "。");

        // 调用Cloth类中的方法
        System.out.println("今天我穿了一件" + cloth.getColor() + "的" + cloth.getName() + "，感觉非常舒适。");

        // 调用Bag类中的方法
        System.out.println("我正在使用一款" + bag.getBrand() + "品牌的" + bag.getName() + "，非常实用。");
    }
}
