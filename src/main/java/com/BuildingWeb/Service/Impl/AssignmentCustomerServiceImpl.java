package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.AssigmentCustomerDTO;
import com.BuildingWeb.Entity.AssignmentCustomerEntity;
import com.BuildingWeb.Entity.CustomerEntity;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Repository.AssignmentCustomerRepository;
import com.BuildingWeb.Repository.CustomerRepository;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Service.AssignmentCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AssignmentCustomerServiceImpl implements AssignmentCustomerService {
    private final AssignmentCustomerRepository assignmentCustomerRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    @Override
    public void insertAssignmentCustomer(AssigmentCustomerDTO assigmentCustomerDTO) {
        assignmentCustomerRepository.deleteBycustomer_idCustomer(assigmentCustomerDTO.getIdCustomer());
        if(assigmentCustomerDTO.getIdUser()!=null&&!assigmentCustomerDTO.getIdUser().isEmpty()){
            CustomerEntity customerEntity = customerRepository.findById(assigmentCustomerDTO.getIdCustomer()).get();
        for(Long idUser: assigmentCustomerDTO.getIdUser()) {
            UserEntity userEntity = userRepository.findById(idUser).get();
            AssignmentCustomerEntity assignmentCustomerEntity = new AssignmentCustomerEntity();
            assignmentCustomerEntity.setCustomer(customerEntity);
            assignmentCustomerEntity.setUser(userEntity);
            assignmentCustomerRepository.save(assignmentCustomerEntity);
        }
        }
    }
    @Override

    public List<Long> getIdUserByIdCustomer(Long idCustomer) {
        return assignmentCustomerRepository.findUserIdByCustomerId(idCustomer);
    }
}
