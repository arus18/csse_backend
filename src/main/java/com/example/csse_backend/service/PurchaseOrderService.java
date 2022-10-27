package com.example.csse_backend.service;
import com.example.csse_backend.entities.PurchaseOrder;
import com.example.csse_backend.exception.CustomPurchaseOrderException;
import com.example.csse_backend.repo.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    public PurchaseOrderService(PurchaseOrderRepo purchaseOrderRepo){
        this.purchaseOrderRepo = purchaseOrderRepo;
    }

    public PurchaseOrder newPurchaseOrder(PurchaseOrder purchaseOrder){
        try{
            return purchaseOrderRepo.save(purchaseOrder);
        }catch(Exception e){
            throw e;
        }
    }

    public PurchaseOrder getPurchaseOrderById(int id){
        try{
            Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findById(id);
            if(purchaseOrder.isPresent()){
                return purchaseOrder.get();
            }
            throw new CustomPurchaseOrderException("Purchase Order Not Found");
        }catch(Exception e){
            throw e;
        }
    }

    public List<PurchaseOrder> getAllPurchaseOrders(){
        try{
            List<PurchaseOrder> purchaseOrders = purchaseOrderRepo.findAll();
            return purchaseOrders;
        }catch(Exception e){
            throw e;
        }
    }
}
