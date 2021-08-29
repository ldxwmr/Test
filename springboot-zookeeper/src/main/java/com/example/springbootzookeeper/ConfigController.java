package com.example.springbootzookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ld
 * @date 2021/8/28 11:30
 */
//@RefreshScope  //表示当前bean中的属性需要动态刷新
@RestController
public class ConfigController {
    @Autowired
    Environment environment;

    @Value(value = "${name}")
    private String name;

    @Value("${job}")
    private String job;

    @Value("${zookeeper}")
    private String command;

    @GetMapping("/env")
    public String env() {
        return environment.getProperty("name") + "\n" + command;
    }
}
