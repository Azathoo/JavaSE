package com.zqh;

/**
 * Description 基本数据类型 char 学习
 * date 2023/11/21 10:32
 *
 * @author zqh
 * @since JDK 1.8
 */
public class CharStudy {
    // char 默认值为空字符 '\u0000' 预期：控制台不显示，不是空格也不是null
    static char i1;
    // 定义一个空格字符，用于比较
    static char i2 = ' ';
    public static void main(String[] args) {
        compare();
    }

    /**
     * Description 比较空字符和 char 默认值的区别
     * date 2023/11/21 10:47
     *
     * @author zqh
     * @since JDK 1.8
     */
    public static void compare(){
        // 分别打印 i1 与 i2
        System.out.println("i1:"+i1);
        System.out.println("i2:"+i2);
    }
}
