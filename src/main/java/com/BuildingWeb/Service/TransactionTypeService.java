package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.response.TransactionTypeDTO;


import java.util.List;

public interface TransactionTypeService {
    List<TransactionTypeDTO> findAllTransactionTypes();
}
