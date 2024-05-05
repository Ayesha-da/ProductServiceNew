package com.example.productservice.services;

import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ProductService {
Product getProducBytId(Long id) throws InvalidProductIdException;
List<Product> getAllProduct();
Product updateProduct(Long id, Product product);
Product replaceProduct(Long id, Product product);
Product createProduct(Product product);
void  deleteProduct();

}
