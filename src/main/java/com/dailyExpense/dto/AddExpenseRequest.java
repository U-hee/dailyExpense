package com.dailyExpense.dto;

import com.dailyExpense.domain.Expense;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddExpenseRequest {

    private Long userId;
    private String category;
    private Long price;
    private LocalDate spentDate;
    private String paymentMethod;
    private Long cardId;

    public Expense toEntity() {
        return Expense.builder()
                .userId(userId)
                .category(category)
                .price(price)
                .spentDate(spentDate)
                .paymentMethod(paymentMethod)
                .cardId(cardId)
                .build();
    }
}
