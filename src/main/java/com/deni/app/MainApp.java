package com.deni.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by Deni Setiawan on 08/12/2022.
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainApp {


    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }


}
