package com.javaweb.repository.custom.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.Status;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    private void buildJoin(CustomerSearchBuilder builder, StringBuilder join) {
        if (builder.getStaffId() != null) {
            join.append(" JOIN assignmentcustomer ac ON c.id = ac.customerid ");
        }
    }

    private void buildWhere(CustomerSearchBuilder builder, StringBuilder where) {
        where.append(" AND c.is_active = 1");
        if (StringUtils.hasText(builder.getFullname())) {
            where.append(" AND LOWER(c.fullname) LIKE LOWER('%").append(builder.getFullname()).append("%')");
        }
        if (StringUtils.hasText(builder.getPhone())) {
            where.append(" AND c.phone LIKE '%").append(builder.getPhone()).append("%'");
        }
        if (StringUtils.hasText(builder.getEmail())) {
            where.append(" AND LOWER(c.email) LIKE LOWER('%").append(builder.getEmail()).append("%')");
        }
        if (StringUtils.hasText(builder.getStatus())) {
            String statusName = Status.valueOf(builder.getStatus()).getStatusName();
            where.append(" AND c.status = '").append(statusName).append("'");
        }
        if (builder.getStaffId() != null) {
            where.append(" AND ac.staffid = ").append(builder.getStaffId());
        }
    }

    @Override
    public List<CustomerEntity> findAll(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT c.* FROM customer c ");
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        buildJoin(builder, sql);
        buildWhere(builder, where);
        sql.append(where).append(" ORDER BY c.createddate DESC");
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    public List<CustomerEntity> getCustomersBySearch(Pageable pageable, CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT c.* FROM customer c ");
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        buildJoin(builder, sql);
        buildWhere(builder, where);

        sql.append(where)
                .append(" ORDER BY c.createddate DESC ")
                .append(" LIMIT ").append(pageable.getPageSize())
                .append(" OFFSET ").append(pageable.getOffset());

        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItems(Pageable pageable, CustomerSearchBuilder builder) {
        String sql = getCountBySearch(builder);
        Query query = entityManager.createNativeQuery(sql);
        Number countResult = (Number) query.getSingleResult();
        return countResult.intValue();
    }

    private String getCountBySearch(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT c.id) FROM customer c ");
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        buildJoin(builder, sql);
        buildWhere(builder, where);
        sql.append(where);
        return sql.toString();
    }
}
