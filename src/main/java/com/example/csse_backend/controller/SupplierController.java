package com.example.csse_backend.controller;

import com.example.csse_backend.entities.Supplier;
import com.example.csse_backend.exception.ResourceNotFoundException;
import com.example.csse_backend.repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepo supplierRepo;

    // get all supplier
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return this.supplierRepo.findAll();
    }

    // get supplier by id
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable(value = "id") Integer userId) {
        return this.supplierRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    // create supplier
    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier user) {
        return this.supplierRepo.save(user);
    }

    // update user
    @PutMapping("/{id}")
    public Supplier updateSupplier(@RequestBody Supplier supplier, @PathVariable ("id") Integer userId) {
        Supplier existingSupplier = this.supplierRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingSupplier.setSupplierName(supplier.getSupplierName());
        existingSupplier.setSupplierContactNumber(supplier.getSupplierContactNumber());
        existingSupplier.setSupplierAddress(supplier.getSupplierAddress());
        return this.supplierRepo.save(existingSupplier);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteUser(@PathVariable ("id") Integer userId){
        Supplier existingUser = this.supplierRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.supplierRepo.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}
