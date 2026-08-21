package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.response.TransactionTypeDTO;
import com.BuildingWeb.Entity.TransactionTypeEntity;
import com.BuildingWeb.EnumUtil.TransactionType;
import com.BuildingWeb.Repository.TransactionTypeRepository;
import com.BuildingWeb.Service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private final ModelMapper modelMapper;
    @Override
    public List<TransactionTypeDTO> findAllTransactionTypes() {
        List<TransactionTypeDTO> list =new ArrayList<>();
        for(TransactionType t: TransactionType.values()){
           list.add(modelMapper.map(t,TransactionTypeDTO.class));
        }
        return list;
    }
}
