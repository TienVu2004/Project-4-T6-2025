package com.javaweb.api.admin;

import com.javaweb.exception.MyException;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionAPI {
    @Autowired
    TransactionService transactionService;
    @PostMapping
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO, BindingResult bindingResult) {
        ResponseDTO reponseDTO = new ResponseDTO();
        try{
            if (bindingResult.hasErrors()) {
                List<String> fieldErrors = bindingResult.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());
                reponseDTO.setMessage("Validate Failed");
                reponseDTO.setData(fieldErrors);
                return ResponseEntity.badRequest().body(reponseDTO);
            }
        }catch (Exception e){
            reponseDTO.setMessage("Internal Server Error");
            reponseDTO.setDetail(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponseDTO);
        }
        transactionService.createTransaction(transactionDTO);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateTransaction(@Valid @RequestBody TransactionDTO transactionDTO, BindingResult bindingResult) {
        ResponseDTO reponseDTO = new ResponseDTO();
        try{
            if (bindingResult.hasErrors()) {
                List<String> fieldErrors = bindingResult.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());
                reponseDTO.setMessage("Validate Failed");
                reponseDTO.setData(fieldErrors);
                return ResponseEntity.badRequest().body(reponseDTO);
            }
        }catch (Exception e){
            reponseDTO.setMessage("Internal Server Error");
            reponseDTO.setDetail(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponseDTO);
        }
        transactionService.updateTransaction(transactionDTO);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    public static void validateTransaction(Long id){
        if (id == null) {
            throw new MyException("Id Building null");
        }
    }

    @DeleteMapping("{id}/{code}/{customerId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id, @PathVariable String code, @PathVariable Long customerId){
        ResponseDTO reponseDTO = new ResponseDTO();
        validateTransaction(customerId);
        transactionService.deleteTransaction(id, code, customerId);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }
}
