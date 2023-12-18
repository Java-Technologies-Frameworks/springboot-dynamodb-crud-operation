package com.jtf.sp.dynamodb.api.controller;

import com.jtf.sp.dynamodb.api.entity.Budget;
import com.jtf.sp.dynamodb.api.payload.request.BudgetDto;
import com.jtf.sp.dynamodb.api.payload.response.ApiResponse;
import com.jtf.sp.dynamodb.api.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/budget")
public class BudgetController {

    @Autowired
    private BudgetRepository budgetRepository;

    @PostMapping("/addBudget")
    public ApiResponse addBudget(@RequestBody BudgetDto budgetdto) {

        Budget budget = new Budget();
        budget.setBudget_id(budgetdto.getBudget_id());
        budget.setUsr_id(budgetdto.getUser_id());
        budget.setDate_budget_crdt(budgetdto.getDate_budget_crdt());
        budget.setFuel(budgetdto.getFuel());
        budget.setFood(budgetdto.getFood());
        budget.setOthers(budgetdto.getOthers());
        budget.setTelephone(budgetdto.getTelephone());
        budget.setVegetables(budgetdto.getVegetables());
        budget.setGroceries(budgetdto.getGroceries());
        budget.setToiletries(budgetdto.getToiletries());
        return new ApiResponse(HttpStatus.OK.value(), "Budget saved successfully.", budgetRepository.saveBudget(budget));
    }

    @GetMapping("/findBudget/{budgetId}/{userId}")
    public Budget getBudgetDetailsById(@PathVariable("budgetId") Long budgetId,
                                       @PathVariable("userId") String userId) {
        return budgetRepository.findByBudgetId(budgetId, userId);
    }

    @GetMapping("/getAllBudget")
    public List<Budget> findAllBudgetDetails() {
        return budgetRepository.findAllBudgetDetails();
    }

    @PutMapping("/updateBudget/{budgetId}/{userId}")
    public Long updateBudgetUsingId(@PathVariable("budgetId") Long bugetId,
                                    @PathVariable("userId") String userId, @RequestBody BudgetDto budgetdto) {
        Budget budget = new Budget();
        budget.setDate_budget_crdt(budgetdto.getDate_budget_crdt());
        budget.setFuel(budgetdto.getFuel());
        budget.setFood(budgetdto.getFood());
        budget.setOthers(budgetdto.getOthers());
        budget.setTelephone(budgetdto.getTelephone());
        budget.setVegetables(budgetdto.getVegetables());
        budget.setGroceries(budgetdto.getGroceries());
        budget.setToiletries(budgetdto.getToiletries());
        return budgetRepository.updateBudgetUsingId(bugetId, userId, budget);
    }

    @DeleteMapping("/deleteBudget")
    public String deleteBudget(@RequestParam Long budgetId, @RequestParam String userId) {
        return budgetRepository.deleteBudget(budgetId, userId);
    }

}
