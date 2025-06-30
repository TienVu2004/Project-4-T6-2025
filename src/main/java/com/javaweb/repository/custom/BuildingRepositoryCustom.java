package com.javaweb.repository.custom;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder searchBuilder);

    List<BuildingEntity> getBuildingBySearch(Pageable pageable, BuildingSearchBuilder buildingSearchBuilder);

    int countTotalItems(Pageable pageable, BuildingSearchBuilder buildingSearchBuilder);
}
