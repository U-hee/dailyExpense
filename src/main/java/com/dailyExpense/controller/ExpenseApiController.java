package com.dailyExpense.controller;

import com.dailyExpense.domain.Expense;
import com.dailyExpense.dto.AddExpenseRequest;
import com.dailyExpense.dto.ExpenseResponse;
import com.dailyExpense.dto.UpdateExpenseRequest;
import com.dailyExpense.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExpenseApiController {
    private final ExpenseService expenseService;

    @PostMapping("/api/expenses")
    public ResponseEntity<Expense> addExpense(@RequestBody AddExpenseRequest request) {
        Expense savedExpense = expenseService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedExpense);
    }

    @GetMapping("/api/expenses")
    public ResponseEntity<List<ExpenseResponse>> findAllExpenses() {
        List<ExpenseResponse> expenseResponses = expenseService.findAll()
                .stream()
                .map(ExpenseResponse::new)
                .toList();

        return ResponseEntity.ok().body(expenseResponses);
    }

    @GetMapping("/api/expense/{id}")
    public ResponseEntity<Expense> findExpense(@PathVariable("id") Long id) {
        Expense expense = expenseService.findById(id);

        return ResponseEntity.ok().body(expense);
    }

    @DeleteMapping("/api/expense/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        expenseService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/expense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody UpdateExpenseRequest request) {
        Expense updateExpense = expenseService.update(id, request);

        return ResponseEntity.ok().body(updateExpense);
    }
}
