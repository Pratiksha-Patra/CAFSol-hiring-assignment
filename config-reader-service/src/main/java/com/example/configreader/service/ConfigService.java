package com.example.configreader.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ConfigService {

    private final Map<String, Map<String, Object>> configData = new HashMap<>();

    public void loadConfig(String filePath) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String currentSection = null;

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (!line.contains("=")) {
                currentSection = line;
                configData.put(currentSection, new HashMap<>());
            } else {
                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (value.contains(",")) {
                    configData.get(currentSection)
                            .put(key, Arrays.asList(value.split(",")));
                } else {
                    configData.get(currentSection).put(key, value);
                }
            }
        }
    }

    public Map<String, Object> getSection(String section) {
        return configData.get(section);
    }
}