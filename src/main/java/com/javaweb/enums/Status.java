package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Status {
    DANG_XU_LY("Đang xử lí"),
    CHUA_XU_LY("Chưa xử lí"),
    DA_XU_LY("Đã xử lí");

    private final String statusName;
    Status(String statusName) {
        this.statusName = statusName;
    }
    public String getStatusName() {
        return statusName;
    }

    public static Map<String, String> getType() {
        Map<String, String> map = new LinkedHashMap<>();
        for(Status type : Status.values()) {
            map.put(type.toString(), type.getStatusName());
        }
        return map;
    }
}
