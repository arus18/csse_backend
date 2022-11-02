package com.example.csse_backend.repo;

import com.example.csse_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface productRepo extends JpaRepository<Product,Integer> {
}
