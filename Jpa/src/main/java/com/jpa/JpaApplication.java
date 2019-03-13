package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/***
 *
 *  reference link
 *  	https://jojoldu.tistory.com/251
 *  	https://jojoldu.tistory.com/255?category=635883
 */

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class JpaApplication {


	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
