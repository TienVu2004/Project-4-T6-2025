package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import java.util.List;

public interface IBuildingService {
    List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
    BuildingEntity createBuilding(BuildingDTO buildingDTO);
    BuildingEntity updateBuilding(BuildingDTO buildingDTO);
    String deleteBuilding(List<Long> buildingIds);
    int countTotalItems(BuildingSearchRequest request);
    boolean checkAssignedBuildings(Long buildingId, Long staffId);
}
