package com.javaweb.api.admin;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.impl.BuildingService;
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
@RequestMapping("/api/buildings")
public class BuildingAPI {

    private BuildingService buildingService;
    private UserRepository userRepository;
    private BuildingRepository buildingRepository;

    @Autowired
    public BuildingAPI(BuildingService buildingService, UserRepository userRepository,BuildingRepository buildingRepository) {
        this.buildingService = buildingService;
        this.userRepository = userRepository;
        this.buildingRepository = buildingRepository;
    }

    @PostMapping
    public ResponseEntity<?> createBuilding(@Valid @RequestBody BuildingDTO buildingDTO, BindingResult bindingResult) {
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
        buildingService.createBuilding(buildingDTO);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }


    @PutMapping
    public ResponseEntity<?> updateBuilding(@Valid @RequestBody BuildingDTO buildingDTO,  BindingResult bindingResult){
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
        buildingService.updateBuilding(buildingDTO);
        reponseDTO.setMessage("Success");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }

    @GetMapping("/{id}/staffs")
    public ResponseEntity<?> loadStaff(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<UserEntity> staffList = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        Optional<BuildingEntity> optionalBuilding = buildingRepository.findById(id);
        if (!optionalBuilding.isPresent()) {
            responseDTO.setMessage("Building not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }
        BuildingEntity building = optionalBuilding.get();
        List<UserEntity> assignedStaffs = building.getUserEntities();
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

    public static void validateBuilding(List<Long> ids){
        if (ids == null || ids.isEmpty()) {
            throw new MyException("Id Building null");
        }
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<?> deleteBuilding(@PathVariable List<Long> ids){
        ResponseDTO reponseDTO = new ResponseDTO();
        validateBuilding(ids);
        buildingService.deleteBuilding(ids);
        reponseDTO.setMessage("Completed");
        return ResponseEntity.status(HttpStatus.OK).body(reponseDTO);
    }
}

