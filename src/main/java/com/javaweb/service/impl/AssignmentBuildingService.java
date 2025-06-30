package com.javaweb.service.impl;


import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IAssignmentBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AssignmentBuildingService implements IAssignmentBuilding {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateAssignedBuildings(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).orElse(null);
        if (buildingEntity != null) {
            buildingEntity.getUserEntities().clear();
            if (assignmentBuildingDTO.getStaffs() != null && !assignmentBuildingDTO.getStaffs().isEmpty()) {
                for (Long staffId : assignmentBuildingDTO.getStaffs()) {
                    userRepository.findById(staffId).ifPresent(userEntity -> {
                        buildingEntity.getUserEntities().add(userEntity);
                    });
                }
            }
            buildingRepository.save(buildingEntity);
        }
    }
}