package Homework.Java_PW2.Pract_6;

class Complex {
    // Части
    public double re; // вещественная часть комплексного числа
    public double im; // мнимая часть комплексного числа
}

class Builder{
    void CreateComplex() {}
    void BuildPart1(int part1) {}
    void BuildPart2(int part2) {}
    Complex GetResult() { return null; }
}

// Класс, который есть конкретным строителем
class ConcreteBuilder extends Builder {
    // Ссылка
    private Complex currentBuilder;

    // Конструктор
    ConcreteBuilder() {
        currentBuilder = null;
    }

    // Переопределение методов, которые определены в классе Builder
    void CreateComplex() {
        currentBuilder = new Complex();
    }

    // Построить часть 1
    void BuildPart1(int part1) {
        currentBuilder.re = part1;
    }

    // Построить часть 2
    void BuildPart2(int part2) {
        currentBuilder.im = part2;
    }

    // Вернуть комплексное число для клиента
    Complex GetResult() {
        return currentBuilder;
    }
}

// Класс-распорядитель
class Director {
    // Метод, конструирующий части,
    // получает ссылку на класс, который реализует интерфейс с клиентом
    void Construct(Builder builder) {
        // Создать продукт
        builder.CreateComplex();

        // Построить часть 1
        builder.BuildPart1(15);

        // Построить часть 2
        builder.BuildPart2(30);
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Complex C;

        // 2. Создать конкретный экземпляр класса ConcreteBuilder
        ConcreteBuilder B = new ConcreteBuilder();

        // 3. Создать класс-распорядитель и сконфигурировать его продуктом B
        Director D = new Director();
        D.Construct(B);

        // 4. Передать созданный продукт клиенту
        C = B.GetResult();

        // 5. Вывести значение комплексного числа (для проверки)
        System.out.println("C.re = " + C.re);
        System.out.println("C.im = " + C.im);
    }
}
