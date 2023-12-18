package com.jtf.sp.dynamodb.api.controller;

import com.jtf.sp.dynamodb.api.entity.Expense;
import com.jtf.sp.dynamodb.api.payload.request.ExpenseDto;
import com.jtf.sp.dynamodb.api.payload.response.ApiResponse;
import com.jtf.sp.dynamodb.api.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping("/addExpense")
    public ApiResponse addExpense(@RequestBody ExpenseDto expenseDto) {

        Expense expense = new Expense();
        expense.setExpense_id(expenseDto.getExpense_id());
        expense.setUsr_id(expenseDto.getUser_id());
        expense.setDate_expense_crdt(expenseDto.getDate_expense_crdt());
        expense.setFuel(expenseDto.getFuel());
        expense.setFood(expenseDto.getFood());
        expense.setOthers(expenseDto.getOthers());
        expense.setTelephone(expenseDto.getTelephone());
        expense.setVegetables(expenseDto.getVegetables());
        expense.setGroceries(expenseDto.getGroceries());
        expense.setToiletries(expenseDto.getToiletries());
        return new ApiResponse(HttpStatus.OK.value(), "Expense saved successfully.", expenseRepository.saveExpense(expense));
    }

    @GetMapping("/findExpenseById/{expenseId}/{userId}")
    public Expense getExpenseDetailsById(@PathVariable("expenseId") Long expenseId,
                                      @PathVariable("userId") String userId) {

       return expenseRepository.findByExpenseId(expenseId, userId);
    }

    @GetMapping("/getAllExpense")
    public List<Expense> findAllExpenseDetails() {
        return expenseRepository.findAllExpenseDetails();
    }

    @PutMapping("/updateExpense/{expenseId}/{userId}")
    public Long updateExpenseUsingId(@PathVariable("expenseId") Long expenseId, @PathVariable("userId") String userId, @RequestBody ExpenseDto expenseDto) {

        return expenseRepository.updateExpenseUsingId(expenseId, userId, expenseDto);
    }

    @DeleteMapping("/deleteExpense")
    public String deleteExpense(@RequestParam Long expenseId, @RequestParam String userId) {
        return expenseRepository.deleteExpense(expenseId, userId);
    }
}
