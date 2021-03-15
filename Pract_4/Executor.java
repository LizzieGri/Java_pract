package Homework.Java_PW2.Pract_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    int Theads;
    ExecutorService executorService;
    public Executor(int kolvo) {
        Theads = kolvo;
        executorService = Executors.newFixedThreadPool(Theads);
    }
    public void Go() {
        for (int i = 0; i < Theads; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println(finalI + 1);
                }
            });
        }
        executorService.shutdown();
    }
}
