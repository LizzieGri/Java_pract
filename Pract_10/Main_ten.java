package Pract_10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main_ten {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = context.getBean(Junior.class);
        junior.doCoding();

        Middle middle = context.getBean(Middle.class);
        middle.doCoding();

        Senior senior = context.getBean(Senior.class);
        senior.doCoding();
    }
}
