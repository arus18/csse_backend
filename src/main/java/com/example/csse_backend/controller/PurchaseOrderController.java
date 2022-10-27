package com.example.csse_backend.controller;
import com.example.csse_backend.entities.PurchaseOrder;
import com.example.csse_backend.service.PurchaseOrderService;
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

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService){
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping("/new_purchase_order")
    public ResponseEntity<PurchaseOrder> newPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
            return new ResponseEntity<>(purchaseOrderService.newPurchaseOrder(purchaseOrder), HttpStatus.CREATED);
    }


    @GetMapping(value = "/orders",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ServerSentEvent<List<PurchaseOrder>>> getPurchaseOrders() {
       return Flux.interval(Duration.ofSeconds(3)).map(sequence -> ServerSentEvent.<List<PurchaseOrder>>builder()
                .event("order-list-event")
                .data(purchaseOrderService.getAllPurchaseOrders())
                .build());
    }

   /* @GetMapping(value = "/orders_json")
    List<PurchaseOrder> getPurchaseOrdersJson() {
        Flux<PurchaseOrder> purchaseOrderFlux = purchaseOrderService.getAllPurchaseOrders();
        return purchaseOrderFlux.collectList().block();
    }*/
}
