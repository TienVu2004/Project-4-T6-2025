package com.javaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String note;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private UserEntity user;
}
