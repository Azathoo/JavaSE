package com.zqh;

import java.nio.charset.StandardCharsets;

/**
 * Description String类学习
 * date 2023/11/16 11:01
 *
 * @author zqh
 * @since JDK 1.8
 */
public class StringStudy {
    public static void main(String[] args) {
        // 一：调用创建字符串的方法
        createString();
    }

    /**
     * Description 学习创建字符串的几种方法
     * date 2023/11/16 11:07
     *
     * @author zqh
     * @since JDK 1.8
     */
    public static void createString(){
        // 方法一：直接赋值
            // 注：直接赋值的字符串，会在字符串常量池寻找
        String name = "zqh";
            // 测试字符串常量池，name2的地址会指向name的地址
        String name2 = "zqh";

        // 方法二：通过有参/无参构造
        String haveParam = new String("hln");
        String noParam = new String();

        // 方法三：通过byte类创建（实际上是通过默认字符集解码创建）
            // 默认字符集为ASCII码，65,66,67 为 A,B,C
        byte[] bytes = {65,66,67};
        String byASCII = new String(bytes);

        // 方法四：通过char类创建
        char[] chars ={'l','o','v','e'};
        String byChar = new String(chars);

        // 查看结果
            // 字符串常量池
        System.out.println(Integer.toHexString(System.identityHashCode(name)));
        System.out.println(Integer.toHexString(System.identityHashCode(name2)));

        System.out.println("直接赋值的字符串："+name);
        System.out.println("有参构造："+haveParam);
        System.out.println("无参构造："+noParam);
        System.out.println("通过 byte 类创建："+byASCII);
        System.out.println("通过 char 类创建："+byChar);

        // 比较
        Person p1 = new Person();
        // 常量池中有了“归海”
        p1.name = "归海";
        Person p2 = new Person() ;
        p2.name = "归海";
        System.out.println(p1.name.equals(p2.name));//true/fales
        System.out.println(p1.name == p2.name) ; //true/fales
        System.out.println(p1.name == "归海") ; //true/fales

        StringBuffer stringBuffer = new StringBuffer("zqh");
        // stringBuffer 方法
        stringBuffer.append("hln");
        System.out.println(stringBuffer);
    }
}


