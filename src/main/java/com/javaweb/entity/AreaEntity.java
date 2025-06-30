package com.javaweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rentarea")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Long value;

    @Column(name = "createddate")
    private LocalDate createdDate;

    @Column(name = "modifieddate")
    private LocalDate modifiedDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    @JsonBackReference
    private BuildingEntity buildingEntity;
}
