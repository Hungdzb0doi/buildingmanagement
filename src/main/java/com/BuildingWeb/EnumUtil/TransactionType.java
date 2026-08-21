package com.BuildingWeb.EnumUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    CSKH("CSKH","Chăm sóc khách hàng"),
    THUONG_LUONG("THUONG_LUONG","Thương lượng"),
    DAN_XEM("DAN_XEM","Dẫn xem");
    private String code;
    private String transactionTypeName;
}
