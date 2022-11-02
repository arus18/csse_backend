package com.example.csse_backend;
import com.example.csse_backend.controller.PurchaseOrderController;
import com.example.csse_backend.service.ItemService;
import com.example.csse_backend.service.PurchaseOrderService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    @Primary
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

    @Bean
    @Primary
    public PurchaseOrderService purchaseOrderService() {
        return Mockito.mock(PurchaseOrderService.class);
    }

    @Bean
    @Primary
    public PurchaseOrderController purchaseOrderController() {
        return Mockito.mock(PurchaseOrderController.class);
    }
}
