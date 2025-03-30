package com.dailyExpense.dto;

import com.dailyExpense.domain.Expense;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class ExpenseResponse {
//    this.userId = userId;
//        this.category = category;
//        this.price = price;
//        this.spentDate = spentDate;
    private Long userId;
    private String category;
    private Long price;
    private LocalDate spentDate;
    private String paymentMethod;
    private Long cardId;

    public ExpenseResponse(Expense expense) {
        this.userId = expense.getUserId();
        this.category = expense.getCategory();
        this.price = expense.getPrice();
        this.spentDate = expense.getSpentDate();
        this.paymentMethod = expense.getPaymentMethod();
        this.cardId = getCardId();
    }
}
