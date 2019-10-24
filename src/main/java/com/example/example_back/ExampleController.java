package com.example.example_back;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class ExampleController {

    @GetMapping("version")
    public VersionDto getVersion() {
        return new VersionDto("2");
    }

    @GetMapping("info")
    public ServerInfoDto getServerInfo() {
        LocalDateTime uptime = LocalDateTime.now().minusYears(2019).minusDays(LocalDate.now().getDayOfYear());
        return new ServerInfoDto(uptime, getRandomPercentage(), getRandomPercentage(), getRandomPercentage());
    }

    private int getRandomPercentage() {
        return ThreadLocalRandom.current().nextInt(100);
    }

    @Value
    private static class VersionDto {
        private String version;
    }

    @Value
    private static class ServerInfoDto {
        private LocalDateTime uptime;
        private int ram;
        private int proc;
        private int hard;
    }
}
