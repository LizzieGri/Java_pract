package Homework.Java_PW2.Pract_6;

interface MakeDeveloper {
    Game createGame();
    Bot createBot();
}

class JavaProduct implements MakeDeveloper {
    @Override
    public Game createGame() {
        return new JavaGame();
    }

    @Override
    public Bot createBot() {
        return new JavaBot();
    }
}

class PythonProduct implements MakeDeveloper {
    @Override
    public Game createGame() {
        return new PythonGame();
    }

    @Override
    public Bot createBot() {
        return new PythonBot();
    }
}

interface Game {}

interface Bot {}

class JavaBot implements Bot {
    public JavaBot() {
        System.out.println("Create new java bot");
    }
}

class JavaGame implements Game {
    public JavaGame() {
        System.out.println("Create new java game");
    }
}

class PythonBot implements Bot {
    public PythonBot() {
        System.out.println("Create new python bot");
    }
}

class PythonGame implements Game {
    public PythonGame() { System.out.println("Create new python game"); }
}

public class AbstractFactory {
    public static void main(String[] args) {
        MakeDeveloper makeDeveloper = new JavaProduct();
        makeDeveloper.createGame();
    }
}
