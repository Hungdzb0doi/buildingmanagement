package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.AssigmentCustomerDTO;

import java.util.List;

public interface AssignmentCustomerService {
void insertAssignmentCustomer(AssigmentCustomerDTO assigmentCustomerDTO);
List<Long> getIdUserByIdCustomer(Long idCustomer);
}
