package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.CustomerSearchResponse;

import java.util.List;

public interface ICustomerService {
    int countTotalItems(CustomerSearchRequest request);
    List<CustomerSearchResponse> findAll(CustomerSearchRequest customerSearchRequest);
    CustomerEntity createCustomer(CustomerDTO customerDTO);
    CustomerEntity updateCustomer(CustomerDTO  customerDTO);
    CustomerDTO findByActive(Long id, Boolean isActive);
    String deleteCustomer(List<Long> customerIds);
    boolean checkAssignedCustomer(Long customerId, Long staffId);
}
