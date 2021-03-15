package Homework.Java_PW2.Pract_5;

public class Singleton3 {
    private static Singleton3 instance;
    public String value;

    private Singleton3(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton3 getInstance(String value) {
        if (instance == null) {
            instance = new Singleton3(value);
        }
        return instance;
    }
}
