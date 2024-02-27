package com.zqh;

import java.math.BigDecimal;

/**
 * Description 浮点数精度丢失
 * date 2024/2/18 19:36
 * @author zqh
 * @since JDK 1.8
 */
public class JingDuDiuShi {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);  // 0.100000024
        System.out.println(b);  //0.0999999905
        System.out.println(a==b);   //fasle
        // 精度丢失原因：计算机存储数据是二进制的，小数无法精确的转换为二进制 （比如说 十进制的 0.2 无法转换为二进制）
        // 解决方法：使用 BigDecimal
        BigDecimal c = new BigDecimal("2.0");
        BigDecimal d = new BigDecimal("1.9");
        System.out.println(c.subtract(d));  // 0.1

        // 比较 BigDecimal 时，使用 compareTo 而不是 equals，相等返回 0
        BigDecimal e = new BigDecimal("1");
        BigDecimal f = new BigDecimal("1.0");
        System.out.println(e.equals(f));
        System.out.println(e.compareTo(f));
    }
}
