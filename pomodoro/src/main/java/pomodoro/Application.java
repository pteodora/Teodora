package pomodoro;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@EntityScan("pomodoro.entity")
@SpringBootApplication
public class Application {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
