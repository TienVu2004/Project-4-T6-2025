package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IAssignmentBuilding;
import com.javaweb.service.IAssignmentCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assign")
public class AssignmentCustomerAPI {
    @Autowired
    private IAssignmentCustomer assignmentCustomer;

    @PostMapping("/customer")
    public ResponseEntity<?> updateAssignment(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (assignmentCustomerDTO.getCustomerId() == null) {
            responseDTO.setMessage("Assignment ID is null");
            return ResponseEntity.badRequest().body(responseDTO);
        }
        //xuống service
        assignmentCustomer.updateAssignedCustomer(assignmentCustomerDTO);
        responseDTO.setMessage("Assignment ID is Updated Successfully");
        return ResponseEntity.ok().body(responseDTO);
    }
}
