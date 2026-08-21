package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.request.RequestTransactionDTO;
import com.BuildingWeb.DTO.response.StaffKpiDTO;
import com.BuildingWeb.DTO.response.TransactionDTO;
import com.BuildingWeb.Entity.TransactionEntity;
import com.BuildingWeb.Entity.TransactionTypeEntity;
import com.BuildingWeb.EnumUtil.TransactionType;
import com.BuildingWeb.Repository.CustomerRepository;
import com.BuildingWeb.Repository.TransactionRepository;
import com.BuildingWeb.Repository.TransactionTypeRepository;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    @Override
    public List<TransactionDTO> searchTransactions(String customerName, String userName, String code, String currentUserName) {
        return transactionRepository.searchTransactions(customerName, userName, code, currentUserName).stream()
                .map(transaction -> {
                    TransactionDTO transactionDTO=modelMapper.map(transaction, TransactionDTO.class);
                            transactionDTO.setCustomer(transaction.getCustomer().getCustomerName());
                            transactionDTO.setUser(transaction.getUser().getUserName());
                            transactionDTO.setCode(transaction.getTransactionType().stream().map(type->type.getCode()).toList());
                            transactionDTO.setTransactionTypeName(transaction.getTransactionType().stream().map(type->type.getTransactionTypeName()).toList());
                            return transactionDTO;
                })
                .toList();
    }
    @Override
    public void insertTransactions(RequestTransactionDTO requestTransactionDTO) {
        TransactionEntity transactionEntity=new TransactionEntity();
        transactionEntity.setCustomer(customerRepository.findById(requestTransactionDTO.getIdCustomer()).get());
        transactionEntity.setUser(userRepository.findByphone(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        transactionEntity.setNote(requestTransactionDTO.getNote());
        transactionEntity.setTransactionType(requestTransactionDTO.getCode().stream().map(code ->{
           TransactionTypeEntity transactionTypeEntity = new TransactionTypeEntity();
           transactionTypeEntity.setTransactionTypeName(TransactionType.valueOf(code).getTransactionTypeName());
           transactionTypeEntity.setCode(code);
           transactionTypeEntity.setTransaction(transactionEntity);
           transactionTypeRepository.save(transactionTypeEntity);
           return transactionTypeEntity;
        }).toList());
        transactionRepository.save(transactionEntity);
    }

    @Override
    public Long countDdxTransactions() {
        return transactionRepository.countDdxTransactions();
    }

    @Override
    public List<StaffKpiDTO> getTopStaffPerformance() {
        Pageable topTen = PageRequest.of(0, 10);
        List<Object[]> results = transactionRepository.getTopStaffPerformance(topTen);
        return results.stream().map(row -> {
            StaffKpiDTO dto = new StaffKpiDTO();
            dto.setUserName((String) row[0]);
            dto.setTotalTransactions((Long) row[1]);
            return dto;
        }).collect(Collectors.toList());
    }
}
