package com.javaweb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private String structure;
    @Column(name = "numberofbasement")
    private Integer numberOfBasement;
    @Column(name = "floorarea")
    private Integer floorArea;
    private String direction;
    private String level;
    @Column(name = "rentprice")
    private Integer rentPrice;
    @Column(name = "rentpricedescription")
    private String rentPriceDescription;
    @Column(name = "servicefee")
    private String serviceFee;
    @Column(name = "carfee")
    private String carFee;
    @Column(name = "motofee")
    private String motoFee;
    @Column(name = "overtimefee")
    private String overtimeFee;
    @Column(name = "waterfee")
    private String waterFee;
    @Column(name = "electricityfee")
    private String electricityFee;
    private String deposit;
    private String payment;
    @Column(name = "renttime")
    private String rentTime;
    @Column(name = "decorationtime")
    private String decorationTime;
    @Column(name = "brokeragefee")
    private Integer brokerageFee;
    private String type;
    private String note;
    @Column(name = "linkofbuilding")
    private String linkOfBuilding;
    private String map;
    @Column(name="avatar")
    private String image;
    @Column(name = "createddate")
    private Date createdDate;
    @Column(name = "modifieddate")
    private Date modifiedDate;
    @Column(name = "createdby")
    private String createdBy;
    @Column(name = "modifiedby")
    private String modifiedBy;
    @Column(name = "managername")
    private String managerName;
    @Column(name = "managerphone")
    private String managerPhone;

    @ManyToMany
    @JoinTable(
            name = "assignmentbuilding",
            joinColumns =@JoinColumn(name = "buildingid"),
            inverseJoinColumns = @JoinColumn(name = "staffid")
    )
    private List<UserEntity> userEntities;

    @OneToMany(mappedBy = "buildingEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AreaEntity> areaEntities;
}