package Homework.Java_PW2.Pract_6;

interface Developer {

    void write();

    static Developer of(String type){
        switch(type){
            case "Java": return new JavaDeveloper();
            case "Python" : return new PythonDeveloper();
            default: throw new UnsupportedOperationException("Not supported for " + type);
        }
    }

}

class JavaDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Let's write java code");
    }
}

class PythonDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Let's write python code");
    }
}



public class FactoryMethod {
    public static void main(String[] args) {
        Developer javaDeveloper = Developer.of("Java");
        javaDeveloper.write();
    }
}
