package Homework.Java_PW2.Pract_1;
import java.util.function.Predicate;
import java.util.Scanner;


public class PR1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов массива: ");
            int num = scan.nextInt();
            int[] arr = new int[num];
            System.out.print("Введите элементы массива: ");
            for (int i = 0; i < num; i++) {
                arr[i] = scan.nextInt();
            }
            Predicate<Integer> max = (x) -> {
                int c = 0;
                for (int i : arr) {
                    if (i == x) {
                        c++;
                    }
                }
                if (c > 0) {
                    return true;
                } else {
                    return false;
                }
            };
            System.out.println(max.test(100));
        } catch (Exception E) {
            System.out.println("Ввод буквенного значения!");
        }
    }
}

