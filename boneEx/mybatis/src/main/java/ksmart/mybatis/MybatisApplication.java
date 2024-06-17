package ksmart.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@Slf4j
public class MybatisApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
		//log.info("로그 쓰기");
		//System.out.println("기존 로그쓰기");
		
	}

}
