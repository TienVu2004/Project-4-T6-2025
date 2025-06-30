package com.javaweb.service.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.converter.CustomerSearchBuilderConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerSearchBuilderConverter customerSearchBuilder;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerConverter customerConverter;

    @Override
    public List<CustomerSearchResponse> findAll(CustomerSearchRequest customerSearchRequest) {
        Pageable pageable = PageRequest.of(customerSearchRequest.getPage() - 1, customerSearchRequest.getMaxPageItems());
        CustomerSearchBuilder builder = customerSearchBuilder.getCustomerSearchBuilder(customerSearchRequest);
        List<CustomerEntity> entities = customerRepository.getCustomersBySearch(pageable, builder);
        return entities.stream()
                .map(customerConverter::toCustomerSearchResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerEntity createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.toCustomerEntity(customerDTO);
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(customerDTO.getId()).get();
        if (customerEntity == null) {
            throw new RuntimeException("Customer not found");
        }
        CustomerEntity updatedEntity = customerConverter.toUpdateCustomerEntity(customerDTO);
        return customerRepository.save(updatedEntity);
    }

    @Override
    public CustomerDTO findByActive(Long id, Boolean isActive) {
        CustomerEntity customerEntity =  customerRepository.findByIdAndIsActive(id, isActive);
        if (customerEntity != null) {
            return customerConverter.toCustomerDTO(customerEntity);
        }
        return null;
    }

    @Override
    public String deleteCustomer(List<Long> customerIds) {
        List<CustomerEntity> customers = customerRepository.findAllById(customerIds);
        for (CustomerEntity customer : customers) {
            customer.setIsActive(false);
        }
        customerRepository.saveAll(customers);
        return "Deleted Customer!";
    }

    @Override
    public int countTotalItems(CustomerSearchRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getMaxPageItems());
        return customerRepository.countTotalItems(pageable, customerSearchBuilder.getCustomerSearchBuilder(request));
    }

    @Override
    public boolean checkAssignedCustomer(Long customerId, Long staffId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        return customerEntity.getUserEntities().stream().anyMatch(userEntity -> userEntity.getId() == staffId) ;
    }
}
