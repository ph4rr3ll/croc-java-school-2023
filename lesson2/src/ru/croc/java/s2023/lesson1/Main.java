package ru.croc.java.s2023.lesson1;


//import ru.croc.java.s2023.lesson1.obj.Person;

public class Main {
//    public static void main(String[] args) {
//        for(int i = 0; i < 10; ) {
//            i = i++;
//            System.out.println("Java");
//        }
//
//    }

    public static void main(String[] args) {
        ru.croc.java.s2023.lesson1.obj.Person person = new ru.croc.java.s2023.lesson1.obj.Person("Bob");
        System.out.println(person.getName() + " => " + person.getAge());
    }
}