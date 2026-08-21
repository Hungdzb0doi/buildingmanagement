package com.BuildingWeb.DTO.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuildingStatisticDTO {
    private String district;
    private Long totalAreaClassA;
    private Long totalAreaClassB;
    private Long totalAreaClassC;
}
