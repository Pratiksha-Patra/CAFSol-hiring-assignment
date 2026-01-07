package com.example.configreader;

import com.example.configreader.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigReaderServiceApplication implements CommandLineRunner {

    @Autowired
    private ConfigService configService;

    public static void main(String[] args) {
        SpringApplication.run(ConfigReaderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        configService.loadConfig("src/main/resources/config/app-config.txt");
    }
}
