package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IAssignmentBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assign")
public class AssignmentBuildingAPI {
    @Autowired
    private IAssignmentBuilding assignmentBuildingService;

    @PostMapping
    public ResponseEntity<?> updateAssignment(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (assignmentBuildingDTO.getBuildingId() == null) {
            responseDTO.setMessage("Assignment ID is null");
            return ResponseEntity.badRequest().body(responseDTO);
        }
        //xuống service
        assignmentBuildingService.updateAssignedBuildings(assignmentBuildingDTO);
        responseDTO.setMessage("Assignment ID is Updated Successfully");
        return ResponseEntity.ok().body(responseDTO);
    }
}