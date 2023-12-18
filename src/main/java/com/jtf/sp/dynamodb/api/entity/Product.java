package com.jtf.sp.dynamodb.api.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DynamoDBTable(tableName = "jtf_product")
public class Product implements Serializable {

    @Id
    private int productid;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String code;
    @DynamoDBAttribute
    private double price;
    @DynamoDBAttribute
    private byte[] image;
    @Temporal(TemporalType.TIMESTAMP)
    @DynamoDBAttribute
    private Date createDate;
}