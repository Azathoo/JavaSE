package com.zqh;

/**
 * Description 学习包装类的缓存机制
 * date 2024/2/18 19:27
 *
 * @author zqh
 * @since JDK 1.8
 */
public class BaoZhuangLei {
    // 整形数据类型的包装类会缓存-128,127
    public static void main(String[] args) {
        // 以下代码结果为 true or false ？
        // 把 40 这个数据 自动装箱成 Integer i1，因此这个 40 拿的是 Integer 的缓存池的对象
        Integer i1 = 40;    // Integer i1 = Integer.valueOf(40)
        // 创建了个新对象
        Integer i2 = new Integer(40);
        // == 比较引用数据类型时 比较地址值 所以结果为 false
        System.out.println(i1 == i2);
        // equals 比较两个对象内容是否相同
        System.out.println(i1.equals(i2));
    }
}
