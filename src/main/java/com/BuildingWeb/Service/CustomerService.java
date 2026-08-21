package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.request.RequestBuildingDTO;
import com.BuildingWeb.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAllCustomer(String customerName, String phone, Long idUser);
    void insertCustomer(CustomerDTO requestCustomerDTO);
    void updateCustomer(CustomerDTO requestCustomerDTO);
    void deleteCustomer(Long[] idCustomer);
    Long countNeglectedCustomers();
    List<CustomerDTO> findNeglectedCustomers();
}
