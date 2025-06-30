package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class TransactionService implements ITransactionService {
    @Autowired
    TransactionConverter transactionConverter;
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public TransactionEntity createTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionConverter.toTransactionEntity(transactionDTO);
        return transactionRepository.save(transactionEntity);
    }


    @Override
    public TransactionEntity updateTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
        if (transactionEntity == null){
            throw new RuntimeException("Transaction not found!");
        }
        TransactionEntity updateTransaction = transactionConverter.toUpdateTransactionEntity(transactionDTO);
        return transactionRepository.save(updateTransaction);
    }

    @Override
    public String deleteTransaction(Long id, String code, Long customerId) {
        transactionRepository.deleteByIdAndCodeAndCustomerId(id, code, customerId);
        return "Deleted Transaction!";
    }
}
