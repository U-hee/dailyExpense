package com.dailyExpense.repository;

import com.dailyExpense.domain.Expense;
import com.dailyExpense.dto.ExpenseListViewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
