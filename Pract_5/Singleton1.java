package Homework.Java_PW2.Pract_5;

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {}
    private static Singleton1 getInstance() {
        return instance;
    }

}
