package com.tangyechun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tangyechun.mapper")
public class BookstoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

}
