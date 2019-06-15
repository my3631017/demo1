package com.example.demo1;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ConfigurationProperties(prefix = "list")
@Data
public class Demo1ApplicationTests {

    private List<String> names;

    @Test
    public void contextLoads() {
        System.out.println();
    }

}
