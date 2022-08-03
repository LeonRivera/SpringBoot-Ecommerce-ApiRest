package com.leonrv.crud_bp.models;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor
public class Product implements Serializable{
    static final long serialVersionUID = 3L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Date createAt;
    private Integer quantity;
    private String urlImage;

    @ManyToOne
    private Seller seller;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<ImageProduct> images;
}
