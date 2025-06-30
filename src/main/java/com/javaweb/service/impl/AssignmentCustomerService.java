package com.javaweb.service.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IAssignmentCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AssignmentCustomerService implements IAssignmentCustomer {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository  userRepository;

    @Override
    public void updateAssignedCustomer(AssignmentCustomerDTO assignmentCustomerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(assignmentCustomerDTO.getCustomerId()).orElse(null);

        if (customerEntity != null) {
            customerEntity.getUserEntities().clear();
            if (assignmentCustomerDTO.getStaffs() != null && !assignmentCustomerDTO.getStaffs().isEmpty()) {
                for (Long staffId : assignmentCustomerDTO.getStaffs()) {
                    userRepository.findById(staffId).ifPresent(userEntity -> {
                        customerEntity.getUserEntities().add(userEntity);
                    });
                }
            }
            customerRepository.save(customerEntity);
        }
    }
}
