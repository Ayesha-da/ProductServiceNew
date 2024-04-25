package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProductId(@PathVariable("id") Long id){
        return new Product();
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }
@PostMapping
    public Product createProduct(@RequestBody Product product){
        return product;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, Product product){
        return new Product();
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
    }
}
