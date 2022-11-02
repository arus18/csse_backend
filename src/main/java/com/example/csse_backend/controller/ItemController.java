package com.example.csse_backend.controller;
import com.example.csse_backend.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order_items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @DeleteMapping("/delete_item/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
