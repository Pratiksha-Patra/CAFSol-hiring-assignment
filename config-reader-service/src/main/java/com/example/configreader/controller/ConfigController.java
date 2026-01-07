package com.example.configreader.controller;

import com.example.configreader.service.ConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/config")
    public Map<String, Object> getConfig(@RequestParam String section) {
        return configService.getSection(section);
    }
}