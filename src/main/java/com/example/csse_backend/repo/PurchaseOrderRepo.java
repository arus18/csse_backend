package com.example.csse_backend.repo;
import com.example.csse_backend.entities.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseOrderRepo extends CrudRepository<PurchaseOrder,Integer> {

    List<PurchaseOrder> findAll();
}
