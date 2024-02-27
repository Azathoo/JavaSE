package com.zqh;

import com.sun.org.apache.xpath.internal.operations.Neg;

/**
 * Description 学习 多态 与 继承
 * date 2024/2/27 15:03
 *
 * @author zqh
 * @since JDK 1.8
 */
public class DuoTaiAndJiCheng {


    public static void main(String[] args) {
    // 继承 测试
        // 实例化 son 对象，son 对象拥有 father 的所有属性和方法
        Son son = new Son();
        // son 拥有 father 的 book 属性
        System.out.println(son.book);

        // 子类拥有自己的 属性或方法
        System.out.println(son.paper);
        // 子类可重写父类方法
        son.print();

    // 多态 测试
        // 引用变量（左边） 为 animal ，实际变量为（右边） cat
        Animal animal = new Cat();
        System.out.println(animal.name);    // 输出结果为：animal
        animal.eat();       // 输出结果为 ：猫就不吃
        /* 上面输出内容的解释：
        *       animal.name 为 animal 是因为，该变量访问的还是引用变量指向的对象，也就是 Animal 类中的 name
        *       而 animal.eat 的输出内容为 猫就不吃 是因为，虽然调用的是 Animal 类的 animal.eat 方法，
        *       但是此时这个方法已经被 B类 重写，所以是 B 类中的 eat 方法*/

        Animal animal1 = new Dog();
        animal1.eat();
    }
}

/* 继承
 *   1.子类拥有父类的所有属性和方法
 *   2.子类可拥有自己的属性和方法对父类扩展
 *   3.子类可以用自己的方式实现父类（多态）*/

class Father{
    int book;
    public void print(){
        System.out.println("父类的输出...");
    }
}

class Son extends Father{
    // 子类变量 paper
    int paper = 5;
    // 重写的父类方法 print
    @Override
    public void print() {
        System.out.println("子类输出...");
    }
}

/* 多态
*   本质上就一个要求：类之间有父子关系*/

// 父类，也是基类
class Animal{
    String name = "animal";
    public void eat(){
        System.out.println(name+"在吃饭..");
    }
}

class Cat extends Animal{
    String name = "猫";

    @Override
    public void eat() {
        System.out.println(name + "就不吃");
    }
}

class Dog extends Animal{
    String name = "狗";

    @Override
    public void eat() {
        System.out.println(name + "爱吃屎");
    }
}
