package com.javaweb.converter;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerSearchBuilderConverter {
    public CustomerSearchBuilder getCustomerSearchBuilder(CustomerSearchRequest customerSearchRequest) {
       CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder.Builder()
               .fullname(MapUtils.getObject(customerSearchRequest.getName(), String.class))
               .phone(MapUtils.getObject(customerSearchRequest.getPhone(), String.class))
               .email(MapUtils.getObject(customerSearchRequest.getEmail(), String.class))
               .status(MapUtils.getObject(customerSearchRequest.getStatus(), String.class))
               .staffId(MapUtils.getObject(customerSearchRequest.getStaffId(), Long.class))
               .build();
        return customerSearchBuilder;

    }
}
