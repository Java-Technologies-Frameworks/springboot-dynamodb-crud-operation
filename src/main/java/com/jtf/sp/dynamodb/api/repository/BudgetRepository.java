package com.jtf.sp.dynamodb.api.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import com.jtf.sp.dynamodb.api.entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BudgetRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    public Budget saveBudget(Budget budget) {
        dynamoDBMapper.save(budget);
        return budget;
    }

    public Budget findByBudgetId(Long budgetId, String userId) {
        return dynamoDBMapper.load(Budget.class, budgetId, userId);
    }

    public List<Budget> findAllBudgetDetails() {
        return dynamoDBMapper.scan(Budget.class, new DynamoDBScanExpression());
    }

    public Long updateBudgetUsingId(Long budgetId, String userId, Budget budget) {
//        dynamoDBMapper.save(budget, new DynamoDBSaveExpression()
//                .withExpectedEntry("budget_id",
//                        new ExpectedAttributeValue(
//                                new AttributeValue().withS(String.valueOf(budgetId)))).
//                withExpectedEntry("user_id",
//                        new ExpectedAttributeValue(
//                                new AttributeValue().withS(userId)
//                        )));
//        return budgetId;

        Budget budgetObj = dynamoDBMapper.load(Budget.class,budgetId,userId);
        budgetObj.setDate_budget_crdt(budget.getDate_budget_crdt());
        budgetObj.setFood(budget.getFood());
        budgetObj.setFuel(budget.getFuel());
        budget.setGroceries(budget.getGroceries());
        budgetObj.setToiletries(budget.getToiletries());
        budgetObj.setVegetables(budget.getVegetables());
        budgetObj.setTelephone(budget.getTelephone());
        budgetObj.setOthers(budget.getOthers());
        dynamoDBMapper.save(budgetObj);

        // Step 4: Update the attributes

        //query(User.class, queryExpression);
        return budgetId;
    }

    public String deleteBudget(Long budgetId,String userId) {
        Budget budget = dynamoDBMapper.load(Budget.class, budgetId,userId);
        dynamoDBMapper.delete(budget);
        return "Budget deleted successfully for the budgetId :: " + budgetId;
    }
}
