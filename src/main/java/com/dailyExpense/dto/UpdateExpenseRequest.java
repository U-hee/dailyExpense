package com.dailyExpense.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateExpenseRequest {
    private Long userId;
    private String category;
    private Long price;
    private LocalDate spentDate;
    private String paymentMethod;
    private Long cardId;
}
