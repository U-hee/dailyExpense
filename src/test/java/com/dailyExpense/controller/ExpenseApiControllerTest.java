package com.dailyExpense.controller;

import com.dailyExpense.domain.Expense;
import com.dailyExpense.dto.AddExpenseRequest;
import com.dailyExpense.repository.ExpenseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExpenseApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    ExpenseRepository expenseRepository;

    @BeforeEach
    public void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        expenseRepository.deleteAll();
    }

    @DisplayName("addExpense: 글 추가에 성공한다.")
    @Test
    void addExpense() throws Exception {

        final String url = "/api/expenses";
        final Long userId = 1L;
        final String category = "category";
        final Long price = 10000L;
        final LocalDate spentDate = LocalDate.now();
        final String paymentMethod = "card";
        final Long cardId=1L;
        final AddExpenseRequest expenseRequest = new AddExpenseRequest(userId, category, price, spentDate,paymentMethod, cardId);

        final String requestBody = objectMapper.writeValueAsString(expenseRequest);
        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));
        //then
        result.andExpect(status().isCreated()   );

        List<Expense> expenses = expenseRepository.findAll();

        assertThat(expenses.size()).isEqualTo(1);
        assertThat(expenses.get(0).getCategory()).isEqualTo(category);
    }
}