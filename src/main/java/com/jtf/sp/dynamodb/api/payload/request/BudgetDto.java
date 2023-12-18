package com.jtf.sp.dynamodb.api.payload.request;

import lombok.Data;

import java.util.Date;

@Data
public class BudgetDto {

    private Long budget_id;
	private String user_id;
    private Date date_budget_crdt;
    private double food;
    private double fuel;
    private double groceries;
    private double toiletries;
    private double vegetables;
    private double telephone;
    private double others;

}
