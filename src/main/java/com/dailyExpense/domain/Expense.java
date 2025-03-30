package com.dailyExpense.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(nullable = true)
    private Long userId;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private LocalDate spentDate;

    @Column(nullable = true)
    private String paymentMethod;

    private Long cardId;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Expense(long userId, String category, Long price, LocalDate spentDate, String paymentMethod, Long cardId) {
        this.userId = userId;
        this.category = category;
        this.price = price;
        this.spentDate = spentDate;
        this.paymentMethod = paymentMethod;
        this.cardId = cardId;
    }

    public void update(long userId, String category, Long price, LocalDate spentDate, String paymentMethod, Long cardId) {
        this.userId = userId;
        this.category = category;
        this.price = price;
        this.spentDate = spentDate;
        this.paymentMethod = paymentMethod;
        this.cardId = cardId;
    }
}