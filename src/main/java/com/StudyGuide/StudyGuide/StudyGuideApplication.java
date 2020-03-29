package com.StudyGuide.StudyGuide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
public class StudyGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyGuideApplication.class, args);
	}

}
