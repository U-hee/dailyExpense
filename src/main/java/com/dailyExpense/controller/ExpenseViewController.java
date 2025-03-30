package com.dailyExpense.controller;

import com.dailyExpense.dto.ExpenseListViewResponse;
import com.dailyExpense.service.ExpenseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExpenseViewController {
    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public String getExpense(Model model) {
        List<ExpenseListViewResponse> expenses = expenseService.findAll().stream()
                .map(ExpenseListViewResponse::new)
                .toList();
        model.addAttribute("expenses", expenses);

        return "expensesList";
    }
}
