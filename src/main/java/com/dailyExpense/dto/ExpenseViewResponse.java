package com.dailyExpense.dto;

import com.dailyExpense.domain.Expense;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ExpenseViewResponse {

    private Long id;
    private Long userId;
    private String category;
    private Long price;
    private LocalDate spentDate;
    private String paymentMethod;
    private Long cardId;

    public ExpenseViewResponse(Expense expense) {
        this.id = expense.getId();
        this.userId = expense.getUserId();
        this.category = expense.getCategory();
        this.price = expense.getPrice();
        this.spentDate = expense.getSpentDate();
        this.paymentMethod = expense.getPaymentMethod();
        this.cardId = expense.getCardId();
    }
}
