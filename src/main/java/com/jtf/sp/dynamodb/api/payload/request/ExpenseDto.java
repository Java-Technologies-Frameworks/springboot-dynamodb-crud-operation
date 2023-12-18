package com.jtf.sp.dynamodb.api.payload.request;

import lombok.*;
import java.util.Date;

@Data
public class ExpenseDto {

	private Long expense_id;
	private String user_id;
	private Date date_expense_crdt;
	private double food;
	private double fuel;
	private double groceries;
	private double toiletries;
	private double vegetables;
	private double telephone;
	private double others;
}
