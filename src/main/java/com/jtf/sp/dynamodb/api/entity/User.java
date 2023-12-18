package com.jtf.sp.dynamodb.api.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@DynamoDBTable(tableName = "jtf_user")
public class User {

    @Id
	@DynamoDBHashKey(attributeName = "user_id")
    private String id;
    private String username;
	@DynamoDBAttribute
    private Date createdDate;
	@DynamoDBAttribute
    private String email;
	@DynamoDBAttribute
    private String password;
	@DynamoDBAttribute
    private Date dob;
	@DynamoDBAttribute
    private int age;
	@DynamoDBAttribute
    private String job;
	@DynamoDBAttribute
    private Long mobileNumber;
}
