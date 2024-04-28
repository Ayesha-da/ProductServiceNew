package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
   private ProductService producService;

   ProductController(ProductService productService){
       this.producService=productService;
   }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducBytId(@PathVariable("id") Long id){

       Product product= producService.getProducBytId(id);
      return  new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public List<Product> getAllProducts(){

       return producService.getAllProduct();
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
        return producService.replaceProduct(id,product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
    }
}
