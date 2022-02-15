package tn.isi.worldcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WorldCupApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldCupApplication.class, args);
    }

}
