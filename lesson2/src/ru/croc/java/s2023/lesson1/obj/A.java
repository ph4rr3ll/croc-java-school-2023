package ru.croc.java.s2023.lesson1.obj;

public class A {

    static final int c = 4;
    static {
        System.out.println("static - " + c);
    }


    int a = 0;
    {
        System.out.println("c = " + c);
        System.out.println(a);
        a = 1;
    }


    long b = 3;
    {
        System.out.println(a);
        a= 3;
    }

    public static void main(String[] args) {
//        System.out.println("----");
//        System.out.println(new A().a);
//        System.out.println("----");
//
//        final int age;
//
//        System.out.println();
//        age = 7;
        System.out.println(B.class.getName());
    }
}

class B {
    static int  a = 1;
    static {
        System.out.println("static - " + a);
    }

}
