package com.example.KafkaConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.KafkaConsumer.Application.IniConfig;

@SpringBootApplication
@EnableScheduling
public class KafkaConsumerApplication {

	public static void main(String[] args) {
	    SpringApplication application = new SpringApplication(KafkaConsumerApplication.class);
	    application.addInitializers(new IniConfig());
	    application.run(args);	
	}
	
}
