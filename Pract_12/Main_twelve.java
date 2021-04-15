package Pract_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main_twelve {
    private final MakeHash makeHash;

    @Autowired
    public Main_twelve(MakeHash makeHash) {
        this.makeHash = makeHash;
    }

    public static void main(String[] args) throws Exception {
        String[] l;
        l = new String[2];
        l[1]="second";
        l[0]="first";
        SpringApplication.run(Main_twelve.class,l);
    }
}
