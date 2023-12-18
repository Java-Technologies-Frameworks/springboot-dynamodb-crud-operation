package com.jtf.sp.dynamodb.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.jtf.sp.dynamodb.api.entity.Expense;
import com.jtf.sp.dynamodb.api.payload.request.ExpenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    public Expense saveExpense(Expense expense) {
        dynamoDBMapper.save(expense);
        return expense;
    }

    public Expense findByExpenseId(Long expenseId, String userId) {
        return dynamoDBMapper.load(Expense.class, expenseId,userId);
    }

    public List<Expense> findAllExpenseDetails() {
        return dynamoDBMapper.scan(Expense.class, new DynamoDBScanExpression());
    }

    public Long updateExpenseUsingId(Long expenseId, String userId, ExpenseDto expense) {
//        dynamoDBMapper.save(expense, new DynamoDBSaveExpression()
//                .withExpectedEntry("expense_id",
//                        new ExpectedAttributeValue(
//                                new AttributeValue().withS(String.valueOf(expenseId))))
//        );


        Expense expenseObj  = dynamoDBMapper.load(Expense.class,expenseId,userId);
        expenseObj.setDate_expense_crdt(expense.getDate_expense_crdt());
        expenseObj.setFood(expense.getFood());
        expenseObj.setFuel(expense.getFuel());
        expenseObj.setGroceries(expense.getGroceries());
        expenseObj.setToiletries(expense.getToiletries());
        expenseObj.setVegetables(expense.getVegetables());
        expenseObj.setTelephone(expense.getTelephone());
        expenseObj.setOthers(expense.getOthers());
        dynamoDBMapper.save(expenseObj);
        return expenseId;
    }

    public String deleteExpense(Long expenseId,String userId) {
        Expense expense = dynamoDBMapper.load(Expense.class, expenseId,userId);
        dynamoDBMapper.delete(expense);
        return "Expense entry deleted successfully for the expenseId :: " + expenseId;
    }
}
