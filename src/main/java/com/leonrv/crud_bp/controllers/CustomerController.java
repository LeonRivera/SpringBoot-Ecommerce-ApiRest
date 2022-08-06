package com.leonrv.crud_bp.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonrv.crud_bp.models.*;
import com.leonrv.crud_bp.repositories.*;
import com.leonrv.crud_bp.services.GenericService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.leonrv.crud_bp.repositories.*;
import com.leonrv.crud_bp.services.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private AzureBlobService azureBlobAdapter;

    GenericService<Customer, Long> service;

    public CustomerController(IGenericRepository<Customer, Long> repositoryCustomer) {
        this.service = new GenericService<Customer, Long>(repositoryCustomer)
        {
        };
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<?>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    // public ResponseEntity<Page<T>> getPage(Pageable pageable){
    //     return ResponseEntity.ok(service.getPage(pageable));
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestParam(required = false) MultipartFile file,
    @RequestParam String customer
    )throws IOException{
        System.out.println("updating");
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customerJson = new Customer();
        // System.out.println(customer);
        customerJson = objectMapper.readValue(customer, Customer.class);
        customerJson.setCreateAt(new Date());
        // System.out.println(customerJson);
        if(file!=null){
            String fileUrl = azureBlobAdapter.upload(file);
            customerJson.setUrlImage(fileUrl);
        }
        return ResponseEntity.ok(service.save(customerJson));
        // return ResponseEntity.ok("OK");
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> create(@RequestParam(required = false) MultipartFile file,
    @RequestParam String customer
    )throws IOException{
        System.out.println("saving");
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customerJson = new Customer();
        // System.out.println(customer);
        customerJson = objectMapper.readValue(customer, Customer.class);

        customerJson.setId(null);
        customerJson.setCreateAt(new Date());

        // System.out.println(customerJson);

        if(file!=null){
            String fileUrl = azureBlobAdapter.upload(file);
            customerJson.setUrlImage(fileUrl);
        }
        return ResponseEntity.ok(service.save(customerJson));
        // return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(id);
    }

    // public T createWithOneImage(T t){
    //     return t;
    // }


}
