package com.jtf.sp.dynamodb.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.jtf.sp.dynamodb.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public User saveUser(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    public User findByUserId(String userId) {
        return dynamoDBMapper.load(User.class,userId);
    }

    public List<User> findAllUserDetails() {
        return dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());
    }

    public String updateUserUsingId(String userId, User user) {
        dynamoDBMapper.save(user, new DynamoDBSaveExpression()
                .withExpectedEntry("user_id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(userId)))
        );
        return userId;
    }

    public String deleteUser(String userId) {
        User user = dynamoDBMapper.load(User.class, userId);
        dynamoDBMapper.delete(user);
        return "User entry deleted successfully for the userId" + userId;
    }


}
