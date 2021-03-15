package Homework.Java_PW2.Pract_2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class PR2 {
    public static void main(String[] args) {
        List humans = new ArrayList<Human>();
        List Age = new ArrayList<Integer>();
        Stream<Human> stream = humans.stream();
        int mul = 1;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            Human human = new Human();
            int day = 1 + (int)(Math.random()*((30 - 1) + 1));
            int mon = 1 + (int)(Math.random()*((12 - 1) + 1));
            int year = 1920 + (int)(Math.random()*((2021 - 1920) + 1));
            int weight = 20 + (int)(Math.random()*((80 - 20) + 1));
            int age = 2021 - year;
            LocalDate date = LocalDate.of(year, mon, day);
            human.setAge(age);
            System.out.print("Введите фамилию: ");
            human.setLastName(scan.nextLine());
            human.setBirthDate(date);
            human.setWeight(weight);
            humans.add(human);
        }

        System.out.println();
        System.out.println("Сортировка по последней букве фамилии: ");
        stream.sorted(Comparator.comparing(human -> (int)(human.getLastName().charAt(human.getLastName().length()-1))))
                .forEach(human -> System.out.println("Фамилия: " + human.getLastName()));
        System.out.println();


        System.out.println("Фильтрация по признаку \"возраст больше, чем вес\": ");
        stream = humans.stream();
        stream.filter(human -> (human.getAge() > human.getWeight()))
                .forEach(human -> System.out.println("Возраст: " + human.getAge() +" Вес: "+human.getWeight() + " Фамилия: " + human.getLastName()));
        System.out.println();


        System.out.println("Сортировка по дате рождения: ");
        stream = humans.stream();
        stream.sorted(Comparator.comparing(human -> (LocalDate)(human.getBirthDate())))
                .forEach(human -> System.out.println("Дата рождения: " + human.getBirthDate()));
        System.out.println();


        stream = humans.stream();
        System.out.print("Произведение всех возрастов = ");
        stream.forEach(human -> Age.add(human.getAge()));
        for (int i = 0 ; i < Age.size();i++){
            mul = (int) Age.get(i) * mul;
        }

        System.out.println(mul);
    }
}
