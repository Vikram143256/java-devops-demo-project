package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // HTML Web Page - Beautiful Dashboard
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // REST API - Get application status
    @GetMapping("/api/status")
    @ResponseBody
    public Map<String, Object> apiStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Java DevOps Demo!");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", "running");
        response.put("version", "1.0.0");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("osName", System.getProperty("os.name"));
        return response;
    }

    // REST API - Health check for Kubernetes
    @GetMapping("/api/health")
    @ResponseBody
    public Map<String, String> apiHealth() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "java-devops-demo");
        health.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return health;
    }

    // REST API - System information
    @GetMapping("/api/info")
    @ResponseBody
    public Map<String, Object> apiInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("appName", "Java DevOps Demo");
        info.put("version", "1.0.0");
        info.put("javaVersion", System.getProperty("java.version"));
        info.put("memoryMax", Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        info.put("memoryTotal", Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        info.put("memoryFree", Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");
        info.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        return info;
    }
}
