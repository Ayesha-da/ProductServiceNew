package com.example.productservice.controllers;

import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
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

   ProductController(@Qualifier("selfProduct") ProductService productService){
       this.producService=productService;
   }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducBytId(@PathVariable("id") Long id) throws InvalidProductIdException {
        Product product=null;
      try {
          product = producService.getProducBytId(id);
      }
      catch(RuntimeException e){
          System.out.println("something went wrong");
          return new ResponseEntity<>(product,HttpStatus.NOT_FOUND);
      }
      return  new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getAllProducts(){

       return producService.getAllProduct();
    }
@PostMapping
    public Product createProduct(@RequestBody Product product){
        return producService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, Product product){

       return producService.updateProduct(id,product);
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
