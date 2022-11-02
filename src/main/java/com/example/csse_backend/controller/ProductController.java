package com.example.csse_backend.controller;

import com.example.csse_backend.entities.Product;
import com.example.csse_backend.exception.ProductNotFoundException;
import com.example.csse_backend.repo.productRepo;
import com.example.csse_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;
    private productRepo ProductRepo;

    @GetMapping("/getAll")
    public List<Product> list(){
        return productService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Product product){
        productService.saveProduct(product);
        return "New Product Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
        return ProductRepo.findById(id)
                .map(product -> {
                    product.setQuantity(newProduct.getQuantity());
                    return ProductRepo.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    /*@PostMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable Integer id){
        try{
            Product existingProduct=productService.get(id);
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }*/

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "Deleted Product with id "+id;
    }
}
