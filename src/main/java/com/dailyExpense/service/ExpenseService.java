package com.dailyExpense.service;

import com.dailyExpense.domain.Expense;
import com.dailyExpense.dto.AddExpenseRequest;
import com.dailyExpense.dto.UpdateExpenseRequest;
import com.dailyExpense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Expense save(AddExpenseRequest request) {
        return expenseRepository.save(request.toEntity());
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(int id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(int id) {
        expenseRepository.deleteById(id);
    }

    public Expense update(int id, UpdateExpenseRequest request) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: id"));

        expense.update(request.getUserId(), request.getCategory(), request.getPrice(), request.getSpentDate(), request.getPaymentMethod(), request.getCardId());

        return expense;
    }
}
