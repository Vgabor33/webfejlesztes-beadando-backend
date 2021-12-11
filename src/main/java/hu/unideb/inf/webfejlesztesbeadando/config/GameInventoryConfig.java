package hu.unideb.inf.webfejlesztesbeadando.config;


import hu.unideb.inf.webfejlesztesbeadando.GameInventoryRepository;
import hu.unideb.inf.webfejlesztesbeadando.model.GameInventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameInventoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(GameInventoryRepository repository) {
        return args -> {
            GameInventory chiXiao = new GameInventory(
                    "Mjölnir",
                    6,
                    "hammer",
                    1,
                    90
            );
            GameInventory excalibur = new GameInventory(
                    "Excalibur",
                    6,
                    "sword",
                    1,
                    90
            );

            repository.saveAll(
                    List.of(chiXiao, excalibur)
            );
        };
    }
}
