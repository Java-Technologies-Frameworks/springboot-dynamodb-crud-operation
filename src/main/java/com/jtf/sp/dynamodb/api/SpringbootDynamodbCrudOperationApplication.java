package com.jtf.sp.dynamodb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootDynamodbCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDynamodbCrudOperationApplication.class, args);
	}

}
