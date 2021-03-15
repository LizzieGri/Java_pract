package Homework.Java_PW2.Pract_6;

interface Copyable {
    Copyable copy();
}
class ComplicatedObject implements Copyable {
    private Type type;
    public enum Type {
        ONE, TWO
    }
    public ComplicatedObject copy() {
        ComplicatedObject complicatedobject = new ComplicatedObject();
        return complicatedobject;
    }
    public void setType(Type type) {
        this.type = type;
    }
}

public class Prototype {
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = prototype.copy();
        clone.setType(ComplicatedObject.Type.ONE);
    }
}
