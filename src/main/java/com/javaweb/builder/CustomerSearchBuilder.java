package com.javaweb.builder;


public class CustomerSearchBuilder {
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;
    private String status;

    private CustomerSearchBuilder(Builder builder) {
        this.fullName = builder.fullName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.staffId = builder.staffId;
        this.status = builder.status;
    }

    public String getFullname() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private String fullName;
        private String phone;
        private String email;
        private Long staffId;
        private String status;

        public Builder fullname(String fullname) {
            this.fullName = fullname;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder staffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public CustomerSearchBuilder build() {
            return new CustomerSearchBuilder(this);
        }
    }
}
