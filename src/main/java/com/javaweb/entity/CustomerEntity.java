package com.javaweb.entity;

import com.javaweb.model.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "fullname")
        private String fullName;
        private String phone;
        private String email;
        @Column(name = "companyname")
        private String companyName;
        private String demand;
        private String status;
        @Column(name = "is_active")
        private Boolean isActive;

//        @ManyToMany(mappedBy = "customerEntities")
//        private List<UserEntity> userEntities;
        @ManyToMany
        @JoinTable(
                name = "assignmentcustomer",
                joinColumns = @JoinColumn(name = "customerid"),
                inverseJoinColumns = @JoinColumn(name = "staffid")
        )
        private List<UserEntity> userEntities;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private List<TransactionEntity> transactions;
}
