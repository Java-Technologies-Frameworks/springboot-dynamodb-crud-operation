package com.jtf.sp.dynamodb.api.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@DynamoDBTable(tableName = "jtf_budget")
public class Budget {

    @Id
    @DynamoDBHashKey(attributeName = "budget_id")
    private long budget_id;
    @DynamoDBRangeKey(attributeName = "user_id")
    private String usr_id;
    @DynamoDBAttribute
    private Date date_budget_crdt;
    @DynamoDBAttribute
    private double food;
    @DynamoDBAttribute
    private double fuel;
    @DynamoDBAttribute
    private double groceries;
    @DynamoDBAttribute
    private double toiletries;
    @DynamoDBAttribute
    private double vegetables;
    @DynamoDBAttribute
    private double telephone;
    @DynamoDBAttribute
    private double others;
}
