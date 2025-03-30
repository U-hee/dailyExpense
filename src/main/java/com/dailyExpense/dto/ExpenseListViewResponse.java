package com.dailyExpense.dto;

import com.dailyExpense.domain.Expense;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ExpenseListViewResponse {
    private int id;
    private Long userId;
    private String category;
    private Long price;
    private LocalDate spentDate;
    private String paymentMethod;
    private Long cardId;

    public ExpenseListViewResponse(Expense expense) {
        this.id = expense.getId();
        this.userId = expense.getUserId();
        this.category = expense.getCategory();
        this.price = expense.getPrice();
        this.spentDate = expense.getSpentDate();
        this.paymentMethod = expense.getPaymentMethod();
        this.cardId = expense.getCardId();
    }
}
