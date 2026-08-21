package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.request.RequestTransactionDTO;
import com.BuildingWeb.DTO.response.StaffKpiDTO;
import com.BuildingWeb.DTO.response.TransactionDTO;

import java.util.List;

public interface TransactionService {
     List<TransactionDTO> searchTransactions(String customerName, String userName, String code, String currentUserName);
     void insertTransactions(RequestTransactionDTO requestTransactionDTO);
     Long countDdxTransactions();
     List<StaffKpiDTO> getTopStaffPerformance();
}
