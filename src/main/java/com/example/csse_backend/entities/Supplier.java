package com.example.csse_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "supplier_Name", nullable = false)
    private String supplierName ;

    @Column(name = "supplier_Address", nullable = false)
    private String supplierAddress;

    @Column(name = "supplier_ContactNumber", nullable = false)
    private String supplierContactNumber;

}
