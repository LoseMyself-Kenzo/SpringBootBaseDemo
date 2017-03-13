package com.zpf;

import com.zpf.dto.girlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LoseMyself on 2017/3/1.
 */
@SpringBootApplication
@RestController
public class Application {

/*    @Value("${cupSize}")
    private String cupSize;

    @Value("${height}")
    private Integer height;\
*/

    @Autowired
    private girlProperties girlProperties;

    @RequestMapping("/")
    public String index(){
        return girlProperties.getCupSize()+girlProperties.getAge();
    }
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
