package com.leonrv.crud_bp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonrv.crud_bp.models.Customer;
import com.leonrv.crud_bp.repositories.ICustomerRepository;
import com.leonrv.crud_bp.repositories.IGenericRepository;

@Service
public class CustomerService extends  GenericService<Customer, Long>{

    @Autowired
    ICustomerRepository customerRepository;

    public CustomerService(IGenericRepository<Customer, Long> repository) {
        super(repository);
    }

    public Customer findByEmail(String email){
        return customerRepository.findFirstByEmail(email);
    }
    
}
