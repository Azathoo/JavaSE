package com.zqh;

/**
 * Description 有关 多态 和 继承 的一道练习题
 * date 2024/2/27 15:38
 *
 * @author zqh
 * @since JDK 1.8
 */
public class DuoTaiPrictise {
    /* 题目：
    *   有 A、B、C、D 四个类，B 继承 A类，
    *   C、D 继承 B 类。
    *   写出 sout 输出的 内容*/

    // 重要：方法的调用链（super 忽略 Object 类）：
    // this.show(obj)-->super.show(obj)-->this.show((super)obj)-->super.show((super)obj)

    public static void main(String[] args) {
        // 左：引用变量，右：实际变量
        // 变量以及方法 从左边 找，但是若遇到 多态、重写，方法从右边找
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        /*  a1 不是多态情况，方法直接从 A 类找。
            A.show(B) -> 未找到 -> A.show(A) -> 输出 A and A*/
        System.out.println("1--" + a1.show(b));
        /*  a1 不是多态情况，方法直接从 A 类找。
            A.show(C) -> 未找到 -> A.show(B) -> 未找到，重头来 -> A.show(B) -> A.show(A) -> 输出 A and A*/
        System.out.println("2--" + a1.show(c));
        /*  a1 不是多态情况，方法直接从 A 类找。
            A.show(D) -> 输出 A and D*/
        System.out.println("3--" + a1.show(d));
        /*  a2 引用变量是 A 类，实际若遇重写方法 是 B 类中的方法。先从 A 类寻找有没有方法。
            A.show(B) -> A 类中没有接收参数 为 B 类的方法 -> A.show(A) -> A 类中 有 参数为 A 的方法，
            那么从 B 类寻找该方法的重写 -> 输出 B and A*/
        System.out.println("4--" + a2.show(b));
        /*  a2 引用变量是 A 类，实际若遇重写方法 是 B 类中的方法。先从 A 类寻找有没有方法。
            A.show(C) -> A 类中没有接收参数 为 B 类的方法 -> A.show(B) -> A 类中 没有 参数为 B 的方法，重头来
            -> A.show(A) -> A 类中有参数 为 A 的方法，在 B 类寻找该方法的重写 -> 输出 B and A*/
        System.out.println("5--" + a2.show(c));
        /*  a2 引用变量是 A 类，实际若遇重写方法 是 B 类中的方法。先从 A 类寻找有没有方法。
            A.show(D) -> A 类中有接收参数 为 D 类的方法 -> 输出 A and D*/
        System.out.println("6--" + a2.show(d));
        // B and B
        System.out.println("7--" + b.show(b));
        // B.show(C) -> A.show(C) -> B.show(B) -> 输出 B and B
        System.out.println("8--" + b.show(c));
        // B.show(D) -> A.show(D) -> 输出 A and D
        System.out.println("9--" + b.show(d));
    }
}


class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    @Override
    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{

}

class D extends B{

}

