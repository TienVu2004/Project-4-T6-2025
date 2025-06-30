package com.javaweb.converter;

import com.javaweb.entity.AreaEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.District;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.utils.RentAreaUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;


    public BuildingSearchResponse toBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buildingEntity.getAreaEntities().stream().map(i -> i.getValue().toString()).collect(Collectors.joining(",")));
        buildingSearchResponse.setRentArea(stringBuilder.toString());
        buildingSearchResponse.setAddress(Stream.of(buildingEntity.getStreet(), buildingEntity.getWard(),
                        District.valueOf(buildingEntity.getDistrict()).getDistrictName())
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.joining(", ")));
        return buildingSearchResponse;
    }

    public BuildingEntity toBuildingEntityDTO(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        List<String> typeCode = buildingDTO.getTypeCode();
        String type = null;
        if (typeCode != null && !typeCode.isEmpty()) {
            type = String.join(",", typeCode);
        }
        buildingEntity.setType(type);
        List<Long> rentAreaValues = RentAreaUtils.parseRentArea(buildingDTO.getRentArea());
        List<AreaEntity> areaEntities = rentAreaValues.stream()
                .map(value -> {
                    AreaEntity areaEntity = new AreaEntity();
                    areaEntity.setValue(value);
                    areaEntity.setBuildingEntity(buildingEntity);
                    return areaEntity;
                })
                .collect(Collectors.toList());

        if (buildingDTO.getImageName() != null && !buildingDTO.getImageName().isEmpty()) {
            String path = "/images/" + buildingDTO.getImageName();
            buildingEntity.setImage(path);
        }
        buildingEntity.setAreaEntities(areaEntities);
        buildingEntity.setCreatedDate(new Date());
        return buildingEntity;
    }


    public BuildingDTO toBuildingUpdateDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buildingEntity.getAreaEntities().stream().map(i -> i.getValue().toString()).collect(Collectors.joining(",")));
        if (buildingEntity.getType() != null && !buildingEntity.getType().isEmpty()) {
            List<String> typeCode = Arrays.asList(buildingEntity.getType().split(","));
            buildingDTO.setTypeCode(typeCode);
        }
        buildingDTO.setRentArea(stringBuilder.toString());
        return buildingDTO;
    }
}
