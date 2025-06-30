package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.NumberUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    private void buildJoin(BuildingSearchBuilder buildingSearchBuider, StringBuilder join) {
        if (buildingSearchBuider.getAreaFrom() != null || buildingSearchBuider.getAreaTo() != null) {
            join.append(" JOIN rentarea r ON b.id = r.buildingid \n");
        }
        if (buildingSearchBuider.getStaffId() != null) {
            join.append(" JOIN assignmentbuilding a ON b.id = a.buildingid \n");
        }
    }

    private void buildWhere(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        try {
            Field field[] = BuildingSearchBuilder.class.getDeclaredFields();
            for(Field item: field) {
                item.setAccessible(true);
                String key = item.getName();
                if (!key.equals("staffId") && !key.startsWith("area") && !key.startsWith("rentPrice") && !key.equals("typeBuilding")) {
                    Object value = item.get(buildingSearchBuilder);
                    if (value != null && NumberUtils.isValue(value.toString())) {
                        if (NumberUtils.isLong(value.toString())) {
                            where.append(" AND b." + key + " = " + value.toString());
                        } else {
                            where.append(" AND b." + key + " LIKE '%" + value.toString()+ "%'");
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            where.append(" AND a.staffid = " + staffId);
        }
        Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
        if (rentAreaFrom != null) {
            where.append(" AND r.value >= " + rentAreaFrom);
        }
        Long rentAreaTo = buildingSearchBuilder.getAreaTo();
        if (rentAreaTo != null) {
            where.append(" AND r.value <= " + rentAreaTo);
        }
        List<String> typeCode = buildingSearchBuilder.getTypeBuilding();
        if (typeCode != null && !typeCode.isEmpty()) {
            where.append(" AND b.type IN (")
                    .append(typeCode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(","))).append(")");
        }
        Long rentPriceFrom = buildingSearchBuilder.getRentalPriceFrom();
        if (rentPriceFrom != null) {
            where.append(" AND r.value >= " + rentPriceFrom);
        }
        Long rentPriceTo = buildingSearchBuilder.getRentalPriceTo();
        if (rentPriceTo != null) {
            where.append(" AND r.value <= " + rentPriceTo);
        }
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder searchBuilder) {
        StringBuilder sql = new StringBuilder("select DISTINCT b.* from building b ");
        StringBuilder whereSql = new StringBuilder("where 1=1");
        buildJoin(searchBuilder, sql);
        buildWhere(searchBuilder, whereSql);
        sql.append(whereSql).append(" order by b.createddate desc ");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public List<BuildingEntity> getBuildingBySearch(Pageable pageable, BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("select DISTINCT b.* from building b ");
        StringBuilder whereSql = new StringBuilder(" where 1=1 ");

        buildJoin(buildingSearchBuilder, sql);
        buildWhere(buildingSearchBuilder, whereSql);

        sql.append(whereSql)
                .append(" order by b.createddate desc ")
                .append(" LIMIT ").append(pageable.getPageSize())
                .append(" OFFSET ").append(pageable.getOffset());
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItems(Pageable pageable, BuildingSearchBuilder buildingSearchBuilder) {
        String sql = getCountBySearch(buildingSearchBuilder);
        Query query = entityManager.createNativeQuery(sql);
        Number countResult = (Number) query.getSingleResult();
        return countResult.intValue();
    }

    private String getCountBySearch(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("select count(distinct b.id) from building b\n");
        StringBuilder whereSql = new StringBuilder("where 1=1");
        buildJoin(buildingSearchBuilder, sql);
        buildWhere(buildingSearchBuilder, whereSql);
        return sql.toString();
    }

}
