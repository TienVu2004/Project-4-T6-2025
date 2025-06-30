package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.enums.District;
import com.javaweb.enums.RentType;
import com.javaweb.enums.Status;
import com.javaweb.enums.Transaction;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value="customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUserService userService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/admin/customer-list")
    public ModelAndView getAllCustomer(@ModelAttribute("modelSearch") CustomerSearchRequest customerSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        DisplayTagUtils.of(request, customerSearchRequest);
        if(SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)){
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerSearchRequest.setStaffId(staffId);
        }
        int totalItems = customerService.countTotalItems(customerSearchRequest);
        customerSearchRequest.setTotalItems(totalItems);
        List<CustomerSearchResponse> results = customerService.findAll(customerSearchRequest);
        customerSearchRequest.setListResult(results);
        mav.addObject("status", Status.getType());
        mav.addObject("staffs", userService.getStaffs());
        mav.addObject("customerSearch", results);
        return mav;
    }

    @GetMapping("/admin/customer-edit")
    public ModelAndView createCustomer(@ModelAttribute CustomerDTO customerDTO){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("status", Status.getType());
        mav.addObject("transaction", Transaction.getTransactionType());
        mav.addObject("customerEdit", customerDTO);
        return mav;
    }
    @GetMapping("/admin/customer-edit-{id}")
    public ModelAndView updateCustomer(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
//        CustomerEntity customerEntity = customerRepository.findById(id).get();
        if(SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)){
            Long staffId = SecurityUtils.getPrincipal().getId();
            if (customerService.checkAssignedCustomer(id, staffId) == false) {
                mav.setViewName("redirect:/error/404");
                return mav;
            }
        }
        CustomerDTO customerDTO = customerService.findByActive(id, true);
        mav.addObject("transactionType",  Transaction.getTransactionType());
        mav.addObject("status", Status.getType());
        List<TransactionEntity> DDX = transactionRepository.findByCodeAndCustomerId("DDX", id);
        List<TransactionEntity> CSKH = transactionRepository.findByCodeAndCustomerId("CSKH", id);
        mav.addObject("CSKH", CSKH);
        mav.addObject("DDX", DDX);
        customerDTO.setStatus(Status.CHUA_XU_LY.name());
        mav.addObject("customerEdit", customerDTO);
        return mav;
    }
}
