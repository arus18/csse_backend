package com.example.csse_backend.service;
import com.example.csse_backend.entities.Item;
import com.example.csse_backend.exception.CustomPurchaseOrderException;
import com.example.csse_backend.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }

    public void deleteById(long id){
        try{
            Optional<Item> purchaseOrder = itemRepo.findById(id);
            if(purchaseOrder.isPresent()){
                itemRepo.deleteById(id);
            }else{
                throw new CustomPurchaseOrderException("Item Not Found");
            }

        }catch(Exception ex){
            throw ex;
        }
    }

    public Item newItem(Item item){
        try{
            return itemRepo.save(item);
        }catch(Exception e){
            throw e;
        }
    }
}
