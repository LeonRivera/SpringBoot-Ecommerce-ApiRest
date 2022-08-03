package com.leonrv.crud_bp.controllers;

import org.springframework.web.bind.annotation.*;
import com.leonrv.crud_bp.models.*;
import com.leonrv.crud_bp.repositories.*;

@RestController @RequestMapping("/api/v1/product") @CrossOrigin("*")
public class ProductController extends GenericController<Product, Long> {
    public ProductController(IGenericRepository<Product, Long> repository) {
        super(repository);
    }
}
