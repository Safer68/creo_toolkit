package by.nenartovich.spring_app;

import by.nenartovich.spring_app.ribbonCommand.RibbonMenu;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@AllArgsConstructor
public class SpringApplication implements CommandLineRunner {

    private final ApplicationContext appContext;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RibbonMenu ribbonMenu = appContext.getBean(RibbonMenu.class);
        ribbonMenu.setupRibbonCommands();
    }
}
