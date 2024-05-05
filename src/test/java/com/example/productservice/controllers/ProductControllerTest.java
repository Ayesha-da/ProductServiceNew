package com.example.productservice.controllers;

import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
   private ProductController productController;

    @MockBean
    private ProductService productService;
    @Test
    void GetProducBytIdValidCase() throws InvalidProductIdException {
      // f  productController.getProducBytId(1L);
        Product product= new Product();
        product.setId(10L);
        product.setTitle("dummy");
        product.setPrice(24266);
        product.setDescription("fgdgdhd");
        when(productService.getProducBytId(10L)).thenReturn(product);

        ResponseEntity<Product> expextedOutput= new ResponseEntity<>(product,);
        assertEquals(product,productController.getProducBytId(10L).getBody() );
    }

    @Test
    void GetProducBytIdInValidCase() {
    }
    @Test
    void GetProducByEdgeCase() {
    }

    @Test
    void getAllProducts() {
    }
}