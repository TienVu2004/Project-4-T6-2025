package com.javaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {
    private String name;
    private Long floorArea;
    private String district;
    private String ward;
    private String street;
    private Long numberOfBasement;
    private String direction;
    private String level;
    private Long areaFrom;
    private Long areaTo;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private String managerName;
    private String managerPhone;
    private Long staffId;
    private List<String> typeBuilding;

    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.direction = builder.direction;
        this.level = builder.level;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.managerName = builder.nameManage;
        this.managerPhone = builder.managerPhone;
        this.staffId = builder.staffId;
        this.typeBuilding = builder.typeBuilding;
    }

    public String getNameBuilding() {
        return name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getRank() {
        return level;
    }

    public Long getAreaFrom() {
        return areaFrom;
    }

    public Long getAreaTo() {
        return areaTo;
    }

    public Long getRentalPriceFrom() {
        return rentPriceFrom;
    }

    public Long getRentalPriceTo() {
        return rentPriceTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhone;
    }

    public Long getStaffId() {
        return staffId;
    }

    public List<String> getTypeBuilding() {
        return typeBuilding;
    }

    public static class Builder {
        private String name;
        private Long floorArea;
        private String district;
        private String ward;
        private String street;
        private Long numberOfBasement;
        private String direction;
        private String level;
        private Long areaFrom;
        private Long areaTo;
        private Long rentPriceFrom;
        private Long rentPriceTo;
        private String nameManage;
        private String managerPhone;
        private Long staffId;
        private List<String> typeBuilding;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder floorArea(Long floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder ward(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder numberOfBasement(Long numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder level(String rank) {
            this.level = rank;
            return this;
        }

        public Builder areaFrom(Long rentAreaFrom) {
            this.areaFrom = rentAreaFrom;
            return this;
        }

        public Builder areaTo(Long rentAreaTo) {
            this.areaTo = rentAreaTo;
            return this;
        }

        public Builder rentPriceFrom(Long rentalPriceFrom) {
            this.rentPriceFrom = rentalPriceFrom;
            return this;
        }

        public Builder rentPriceTo(Long rentalPriceTo) {
            this.rentPriceTo = rentalPriceTo;
            return this;
        }

        public Builder managerName(String nameManage) {
            this.nameManage = nameManage;
            return this;
        }

        public Builder managerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }

        public Builder staffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder typeCode(List<String> typeBuilding) {
            this.typeBuilding = typeBuilding;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}
