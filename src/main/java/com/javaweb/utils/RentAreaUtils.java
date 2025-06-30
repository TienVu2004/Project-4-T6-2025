package com.javaweb.utils;

import java.util.ArrayList;
import java.util.List;

public class RentAreaUtils {
    public static List<Long> parseRentArea(String rentAreaString) {
        List<Long> rentAreas = new ArrayList<>();

        if (rentAreaString == null || rentAreaString.isEmpty()) {
            return rentAreas;
        }
        String[] parts = rentAreaString.split(",");
        for (String part : parts) {
            part = part.trim();
            if (!part.isEmpty()) {
                try {
                    rentAreas.add(Long.parseLong(part));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return rentAreas;
    }
}
