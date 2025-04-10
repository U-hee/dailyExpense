package com.dailyExpense.controller;

import com.dailyExpense.domain.Expense;
import com.dailyExpense.dto.ExpenseListViewResponse;
import com.dailyExpense.dto.ExpenseViewResponse;
import com.dailyExpense.service.ExpenseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExpenseViewController {
    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public String getExpenses(Model model) {
        List<ExpenseListViewResponse> expenses = expenseService.findAll().stream()
                .map(ExpenseListViewResponse::new)
                .toList();
        model.addAttribute("expenses", expenses);

        return "expensesList";
    }

    @GetMapping("/expenses/{id}")
    public String getExpense(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findById(id);

        model.addAttribute("expense", new ExpenseViewResponse(expense));

        return "expense";
    }

    @GetMapping("/new-expense")
    public String newExpense(@RequestParam(name = "id", required = false) Long id, Model model) {
        if(id == null) {
            model.addAttribute("expense", new ExpenseViewResponse());
        } else {
          Expense expense = expenseService.findById(id);
          model.addAttribute("expense", new ExpenseViewResponse(expense));
        }

        return "newExpense";
    }
}
