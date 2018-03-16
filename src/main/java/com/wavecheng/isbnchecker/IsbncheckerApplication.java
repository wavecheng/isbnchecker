package com.wavecheng.isbnchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavecheng.isbnchecker.entity.IsbnQueryResult;
import static com.wavecheng.isbnchecker.ActiveMQConfig.ORDER_QUEUE;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class IsbncheckerApplication implements ApplicationRunner {

	  private static Logger log = LoggerFactory.getLogger(IsbncheckerApplication.class);

	    @Autowired
	    private OrderSender orderSender;
	    
	public static void main(String[] args) {
		SpringApplication.run(IsbncheckerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 5; i++){
        	IsbnQueryResult myMessage = new IsbnQueryResult(i + 
        			" - Sending JMS Message using Embedded activeMQ", "test");
            orderSender.send(myMessage);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
	}
}
