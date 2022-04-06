package com.sh.basicknow;

import java.util.Random;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class Student {
    public static long OUTER_DATE = System.currentTimeMillis();

    static{
        System.out.println("外部类静态块加载时间:"+System.currentTimeMillis());
    }

    {
        System.out.println("外部类非静态代码块加载时间:"+System.currentTimeMillis());
        String a = "000";
        class A{
            private String name = "123";
            public void call(){
                System.out.println(name);
            }
        }

        new A().call();

    }

    public Student(){

        System.out.println("外部类构造时间:"+System.currentTimeMillis());
    }
    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }
    private int a = 0;
    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            INNER_DATE = System.currentTimeMillis();
            System.out.println(OUTER_DATE+"--------------------------------");

        }
    }
    public static void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }
    public static void outerStaticMethod() {
        System.out.println("外部类静态方法执行了");

        String a = "000";
        class A{
            private String name = "123";
            public void call(){
                System.out.println(a);
            }
        }
    }

}
