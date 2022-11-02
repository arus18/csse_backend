package com.example.csse_backend.controller;
import com.example.csse_backend.entities.Item;
import com.example.csse_backend.entities.PurchaseOrder;
import com.example.csse_backend.repo.ItemRepo;
import com.example.csse_backend.service.ItemService;
import com.example.csse_backend.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.List;


@RestController
@RequestMapping("purchase_orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    private final ItemService itemService;


    public PurchaseOrderController(PurchaseOrderService purchaseOrderService,ItemService itemService){
        this.purchaseOrderService = purchaseOrderService;
        this.itemService = itemService;
    }

    @PostMapping("/new_purchase_order")
    public ResponseEntity<PurchaseOrder> newPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
            PurchaseOrder purchaseOrdern = purchaseOrderService.newPurchaseOrder(purchaseOrder);
            for(Item item:purchaseOrder.getItems()){
                item.setPurchaseOrder(purchaseOrder);
                itemService.newItem(item);
            }
            return new ResponseEntity<>(purchaseOrdern, HttpStatus.CREATED);
    }


    @GetMapping(value = "/orders",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ServerSentEvent<List<PurchaseOrder>>> getPurchaseOrders() {
       return Flux.interval(Duration.ofSeconds(3)).map(sequence -> ServerSentEvent.<List<PurchaseOrder>>builder()
                .event("order-list-event")
                .data(purchaseOrderService.getAllPurchaseOrders())
                .build());
    }

    @PostMapping("/update_status/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable long id,@PathVariable String status){
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        purchaseOrder.setStatus(status);
        purchaseOrderService.newPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/{id}")
    public PurchaseOrder getOrderById(@PathVariable long id){
        return purchaseOrderService.getPurchaseOrderById(id);
    }

    @GetMapping("/search/{siteName}")
    public List<PurchaseOrder> getPurchaseOrderBySiteName(@PathVariable String siteName){
        return purchaseOrderService.getPurchaseOrdersBySiteName(siteName);
    }

}
