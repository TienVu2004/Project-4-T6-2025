package com.javaweb.api.admin;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
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
        customerService.createCustomer(customerDTO);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO,  BindingResult bindingResult){
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
        customerService.updateCustomer(customerDTO);
        reponseDTO.setMessage("Success");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    public static void validateCustomer(List<Long> ids){
        if (ids == null || ids.isEmpty()) {
            throw new MyException("Id Building null");
        }
    }
    @DeleteMapping("/{ids}")
    public ResponseEntity<?> deleteCustomer(@PathVariable List<Long> ids){
        ResponseDTO reponseDTO = new ResponseDTO();
        validateCustomer(ids);
        customerService.deleteCustomer(ids);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    @GetMapping("/{id}/staffs")
    public ResponseEntity<?> loadStaff(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<UserEntity> staffList = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            responseDTO.setMessage("Customer not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }
        CustomerEntity customer = optionalCustomer.get();
        List<UserEntity> assignedStaffs = customer.getUserEntities();
        List<StaffResponseDTO> staffResponseDTOList = new ArrayList<>();
        for (UserEntity staff : staffList) {
            StaffResponseDTO dto = new StaffResponseDTO();
            dto.setStaffId(staff.getId());
            dto.setFullName(staff.getFullName());
            dto.setChecked(assignedStaffs.contains(staff) ? "checked" : "");
            staffResponseDTOList.add(dto);
        }
        responseDTO.setMessage("Success");
        responseDTO.setData(staffResponseDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
