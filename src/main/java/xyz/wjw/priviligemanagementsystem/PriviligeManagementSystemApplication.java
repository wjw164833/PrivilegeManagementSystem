package xyz.wjw.priviligemanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author ASUS
 */
@SpringBootApplication
@MapperScan("xyz.wjw.priviligemanagementsystem.mapper")
public class PriviligeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriviligeManagementSystemApplication.class, args);
    }

}
