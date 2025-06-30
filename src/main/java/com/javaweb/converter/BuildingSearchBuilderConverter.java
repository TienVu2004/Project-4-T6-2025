package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder getBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .name(MapUtils.getObject(buildingSearchRequest.getName(), String.class))
                .areaFrom(MapUtils.getObject(buildingSearchRequest.getAreaFrom(), Long.class))
                .areaTo(MapUtils.getObject(buildingSearchRequest.getAreaTo(), Long.class))
                .direction(MapUtils.getObject(buildingSearchRequest.getDirection(), String.class))
                .district(MapUtils.getObject(buildingSearchRequest.getDistrict(), String.class))
                .staffId(MapUtils.getObject(buildingSearchRequest.getStaffId(), Long.class))
                .managerPhone(MapUtils.getObject(buildingSearchRequest.getManagerPhone(), String.class))
                .floorArea(MapUtils.getObject(buildingSearchRequest.getFloorArea(), Long.class))
                .numberOfBasement(MapUtils.getObject(buildingSearchRequest.getNumberOfBasement(), Long.class))
                .typeCode(buildingSearchRequest.getTypeCode())
                .managerName(MapUtils.getObject(buildingSearchRequest.getManagerName(), String.class))
                .rentPriceFrom(MapUtils.getObject(buildingSearchRequest.getRentPriceFrom(), Long.class))
                .rentPriceTo(MapUtils.getObject(buildingSearchRequest.getRentPriceTo(), Long.class))
                .ward(MapUtils.getObject(buildingSearchRequest.getWard(), String.class))
                .level(MapUtils.getObject(buildingSearchRequest.getLevel(), String.class))
                .street(MapUtils.getObject(buildingSearchRequest.getStreet(), String.class))
                .build();
        return buildingSearchBuilder;
    }
}
