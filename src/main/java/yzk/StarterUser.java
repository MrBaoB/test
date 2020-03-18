package yzk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"yzk.user.mapper","yzk.classs.mapper","yzk.power.mapper"})
public class StarterUser {
	
	public static void main(String[] args) {
		SpringApplication.run(StarterUser.class, args);
	}
}
