package com.jtf.sp.dynamodb.api.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@DynamoDBTable(tableName = "jtf_expense")
public class Expense {

    @Id
    @DynamoDBHashKey(attributeName = "expense_id")
    private long expense_id;
    @DynamoDBRangeKey(attributeName = "user_id")
    private String usr_id;
    @DynamoDBAttribute
    private Date date_expense_crdt;
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
