package com.javaweb.converter;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionConverter {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionEntity toTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO,TransactionEntity.class);
        return transactionEntity;
    }

    public TransactionEntity toUpdateTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO,TransactionEntity.class);
        TransactionEntity existingEntity = transactionRepository.findById(transactionDTO.getId()).orElse(null);
        if (existingEntity == null) {
            throw new MyException("Transaction not found");
        }
        transactionEntity.setCreatedDate(existingEntity.getCreatedDate());
        transactionEntity.setCreatedBy(existingEntity.getCreatedBy());
        return transactionEntity;
    }
}
