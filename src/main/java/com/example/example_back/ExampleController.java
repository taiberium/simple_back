package com.example.example_back;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("version")
    public VersionDto getVersion() {
        return new VersionDto("1");
    }

    @Value
    private static class VersionDto {
        private String version;
    }
}
