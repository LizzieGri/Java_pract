package Homework.Java_PW2.Pract_3;

import java.util.*;

public class PR3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < 4; i++) {
            System.out.print("Введите элемент: ");
            set.add(scan.nextLine());
        }

        Set<String> synset = Collections.synchronizedSet(set);

        System.out.println(synset);
    }
}
