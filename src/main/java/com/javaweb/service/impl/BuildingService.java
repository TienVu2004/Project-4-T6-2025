package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AreaEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.custom.impl.BuildingRepositoryImpl;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.RentAreaUtils;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BuildingService implements IBuildingService {

//    @Autowired
//    BuildingSearchBuilderConverter buildingSearchBuilderConverter;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    BuildingSearchBuilderConverter builderConverter;
    @Autowired
    BuildingConverter buildingConverter;
    @Autowired
    UploadFileUtils uploadFileUtils;
    @Autowired
    BuildingRepositoryImpl buildingRepositoryImpl;

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest) {
        Pageable pageable = PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems());
        BuildingSearchBuilder builder = builderConverter.getBuildingSearchBuilder(buildingSearchRequest);
        List<BuildingEntity> entities = buildingRepository.getBuildingBySearch(pageable, builder);
        return entities.stream()
                .map(buildingConverter::toBuildingSearchResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BuildingEntity createBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.toBuildingEntityDTO(buildingDTO);
        saveThumbnail(buildingDTO, buildingEntity);
        buildingRepository.save(buildingEntity);
        return buildingEntity;
    }

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/images/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("C://home/office" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }

    @Override
    public BuildingEntity updateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
        if (buildingEntity == null) {
            throw new RuntimeException("Building not found");
        }
        BuildingEntity updatedEntity = buildingConverter.toBuildingEntityDTO(buildingDTO);
        updatedEntity.setImage(buildingDTO.getImageBase64());
        if (buildingDTO.getImageBase64() != null) {
            saveThumbnail(buildingDTO, updatedEntity);
        }
        return buildingRepository.save(updatedEntity);
    }


    @Override
    public String deleteBuilding(List<Long> buildingIds) {
        buildingRepository.deleteByIdIn(buildingIds);
        return "Deleted Building";
    }

    @Override
    public int countTotalItems(BuildingSearchRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getMaxPageItems());
        return buildingRepositoryImpl.countTotalItems(pageable, builderConverter.getBuildingSearchBuilder(request));
    }

    @Override
    public boolean checkAssignedBuildings(Long buildingId, Long staffId) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
        return buildingEntity.getUserEntities().stream().anyMatch(userEntity -> userEntity.getId() == staffId) ;
    }


}
