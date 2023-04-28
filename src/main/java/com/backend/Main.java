package com.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    // => Entry point of the server
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }


}
