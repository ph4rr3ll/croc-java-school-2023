package ru.croc.java.lesson4.other;

public class C extends B {
    protected int a = 3;

    public void print() {
        System.out.println("A.a: " + ((A)this).a);
        System.out.println("B.a: " + super.a);
        System.out.println("C.a: " + a);
    }

    public static void main(String[] args) {
        new C().print();
    }
}
