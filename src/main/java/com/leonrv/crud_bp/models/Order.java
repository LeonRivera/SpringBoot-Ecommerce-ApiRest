package com.leonrv.crud_bp.models;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor
public class Order implements Serializable{
    static final long serialVersionUID = 3L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    // private Integer quantity;
    private Date createAt;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;
}
