package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.CustomerDTO;
import com.BuildingWeb.Entity.CustomerEntity;
import com.BuildingWeb.Repository.CustomerRepository;
import com.BuildingWeb.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<CustomerDTO> findAllCustomer(String customerName, String phone, Long idUser) {
        return customerRepository.searchCustomers(customerName, phone, idUser).stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public void insertCustomer(CustomerDTO requestCustomerDTO) {
        customerRepository.save(modelMapper.map(requestCustomerDTO, CustomerEntity.class));
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity=customerRepository.findById(customerDTO.getIdCustomer())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        modelMapper.map(customerDTO, customerEntity);
        customerRepository.save(customerEntity);
    }

    @Override
    public void deleteCustomer(Long[] idCustomer) {
        customerRepository.deleteByIdCustomerIn(idCustomer);
    }

    @Override
    public Long countNeglectedCustomers() {
        return customerRepository.countNeglectedCustomers();
    }
    @Override
    public List<CustomerDTO> findNeglectedCustomers() {
        return customerRepository.findNeglectedCustomers().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).toList();
    }
}
