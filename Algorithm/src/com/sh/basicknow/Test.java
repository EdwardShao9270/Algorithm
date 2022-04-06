package com.sh.basicknow;

import java.util.Random;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class Test {
    public static void main(String[] args) {
        timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....静态内部类加载时间：" + Student.InnerStaticClass.INNER_STATIC_DATE);
        timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....外部类静态变量加载时间：" + Student.OUTER_DATE);


       /* timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....调用外部静态方法：" ) ;Student.outerStaticMethod();
        timeElapsed();
        Student student1 = new Student();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....非静态内部类加载时间：" + student1.new InnerClass().INNER_DATE);*/

    }

    private static void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }

    }

    public int NumberOf1(int n) {
        int count = 0;
        boolean a = true;
        while(a){
            count++;
            n = (n-1)&n;
            if(n == 0){
                a = false;
            }
        }
        return count;
    }
}
