package com.javaweb.service;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;

import java.util.List;

public interface ITransactionService {
    TransactionEntity createTransaction(TransactionDTO transactionDTO);
    TransactionEntity updateTransaction(TransactionDTO transactionDTO);
    String deleteTransaction(Long id, String code, Long customerId);
}
