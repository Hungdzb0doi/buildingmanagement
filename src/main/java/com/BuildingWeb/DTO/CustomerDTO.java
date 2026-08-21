package com.BuildingWeb.DTO;



import lombok.Data;

@Data
public class CustomerDTO {
    private Long idCustomer;
    private String customerName;
    private String phone;
    private String email;
}
