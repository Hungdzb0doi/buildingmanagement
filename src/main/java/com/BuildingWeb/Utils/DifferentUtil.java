package com.BuildingWeb.Utils;

public class DifferentUtil {
    public static String getBuildingTypeNameByCode(String code) {
        if (code == null) return "";
        switch (code) {
            case "TANG_TRET": return "Tầng trệt";
            case "NGUYEN_CAN": return "Nguyên căn";
            case "NOI_THAT": return "Nội Thất ";
            default: return "Loại khác";
        }
    }
}
