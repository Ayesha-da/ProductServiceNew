package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ProductService {
Product getProducBytId(Long id);
List<Product> getAllProduct();
Product updateProduct();
Product replaceProduct();
Product createProduct();
void  deleteProduct();

}
