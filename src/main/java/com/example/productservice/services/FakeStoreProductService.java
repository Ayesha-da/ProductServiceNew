package com.example.productservice.services;

import com.example.productservice.DTOs.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakestoreToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product= new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        Category category= new Category();
        category.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(category);

        return product;
    }
    @Override
    public Product getProducBytId(Long id) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
      // convert fakestoreproduct object to product object
      if(fakeStoreProductDto == null){
          return null;
      }
        return convertFakestoreToProduct(fakeStoreProductDto);
    }



    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
