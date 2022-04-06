package com.sh.offer.array;

import java.io.PipedWriter;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class Test {
/*    public static void main(String[] args) {
        Test p = new Test();
        p.Power(1.0,1);

        final int m =0;
        System.out.println(m);
        Test a = new Test();
        testMethod();

    }*/


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        Test.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swap(Student x, Student y) {
       /* Student temp = x;
        x = y;
        y = temp;*/
       x.setName("xiaoli");
       y.setName("xiaozhang");
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

/*    public  double Power(double base, int exponent) {
        System.out.println("123");
        return 1.0;
    }

    public static void testMethod(){
        System.out.println("123");
    }*/

    private static class Student{
        private String name;
        private Student(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

