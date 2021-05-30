package Pract_22;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class Schedule implements ScheduleMXBean {
    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }
    @ManagedOperation
    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        if(isEmpty(new File("D:\\java\\first_spring\\src\\main\\java\\smth"))){
            for (File myFile : new File("D:\\java\\first_spring\\src\\main\\java\\smth")
                    .listFiles()) {
                if (myFile.isFile()) myFile.delete();
            }
        }
        BankController bankController = new BankController();
        CardController cardController = new CardController();
        List <Bank> banks = bankController.getAll();
        List <Card> cards = cardController.getAll();
        for (int i=0; i< banks.size();i++) {
            File bank = new File("D:\\java\\first_spring\\src\\main\\java\\smth");
            FileWriter writer = new FileWriter(bank, false);
            writer.write(banks.get(i).toString());
        }

        for (int i=0; i< cards.size();i++) {
            File card = new File("D:\\java\\first_spring\\src\\main\\java\\smth");
            FileWriter writer = new FileWriter(card, false);
            writer.write(cards.get(i).toString());
        }
    }
}