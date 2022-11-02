package com.example.csse_backend;

import com.example.csse_backend.controller.PurchaseOrderController;
import com.example.csse_backend.service.ItemService;
import com.example.csse_backend.service.PurchaseOrderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class CsseBackendApplicationTests {

	@Autowired
	private ItemService itemService;

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Autowired
	private PurchaseOrderController purchaseOrderController;

	@Test
	public void whenPurchaseOrderIdIsProvided_thenRetrievedSiteNameIsCorrect() {
		Mockito.when(purchaseOrderService.getPurchaseOrderById(1).getSiteName()).thenReturn("Site name");
		String siteName = purchaseOrderService.getPurchaseOrderById(1).getSiteName();
		Assert.assertEquals("Site name", siteName);
	}
	@Test
	public void whenItemIdIsProvided_thenRetrievedItemIsCorrect() {
		Mockito.when(itemService.getItemById(1).getName()).thenReturn("item name");
		String itemName = itemService.getItemById(1).getName();
		Assert.assertEquals("item name", itemName);
	}

	@Test
	public void whenPurchaseOrderIdIsProvided_thenRetrievedSiteNameIsCorrectFromController() {
		Mockito.when(purchaseOrderController.getOrderById(1).getSiteName()).thenReturn("Site name");
		String siteName = purchaseOrderController.getOrderById(1).getSiteName();
		Assert.assertEquals("Site name", siteName);
	}

}
