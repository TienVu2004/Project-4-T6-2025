package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.Status;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.MyUserDetail;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.security.utils.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class CustomerConverter {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerRepository customerRepository;


    public CustomerSearchResponse toCustomerSearchResponseDTO(CustomerEntity customerEntity){
        CustomerSearchResponse customerSearchResponse = modelMapper.map(customerEntity, CustomerSearchResponse.class);
        return customerSearchResponse;
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        customerEntity.setIsActive(true);
        String status = customerDTO.getStatus();
        if(status != null ){
            customerEntity.setStatus(Status.valueOf(customerDTO.getStatus()).getStatusName());
        }
        else{
            customerEntity.setStatus(Status.CHUA_XU_LY.getStatusName());
        }
        return customerEntity;
    }

    public CustomerEntity toUpdateCustomerEntity(CustomerDTO customerDTO){
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerDTO.getId());
        if (!optionalCustomer.isPresent()) {
            throw new MyException("Customer not found");
        }

        CustomerEntity existingCustomer = optionalCustomer.get();
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        customerEntity.setIsActive(true);
        String status = customerDTO.getStatus();
        if(status != null ){
            customerEntity.setStatus(Status.valueOf(customerDTO.getStatus()).getStatusName());
        }
        else{
            customerEntity.setStatus(Status.CHUA_XU_LY.getStatusName());
        }
        customerEntity.setCreatedDate(existingCustomer.getCreatedDate());
        customerEntity.setCreatedBy(existingCustomer.getCreatedBy());
        return customerEntity;
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
        return customerDTO;
    }
}
