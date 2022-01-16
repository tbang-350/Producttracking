package com.example.Producttracking.configuration;

import com.example.Producttracking.entity.Contractors;
import com.example.Producttracking.repository.ContractorRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
public class ContractorConfig {

    @Bean
    CommandLineRunner commandLineRunner(ContractorRepository repository){
        return args -> {
            Contractors david = new Contractors(
                    "David",
                    "tbway350@gmail.com",
                    "0689009094",
                    "username1",
                    "password1"
            );

            Contractors frank = new Contractors(
                    "frank",
                    "frank350@gmail.com",
                    "0689009094",
                    "username1",
                    "password1"
            );

            repository.saveAll(
                    List.of(david, frank)
            );
        };
    };
}
