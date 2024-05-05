package com.example.productservice.services;

import com.example.productservice.DTOs.ProductDto;
import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("FakeStore")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakestoreToProduct(ProductDto productDto){
        Product product= new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());

        Category category= new Category();
        category.setTitle(productDto.getTitle());
        product.setCategory(category);

        return product;
    }
    @Override
    public Product getProducBytId(Long id) throws InvalidProductIdException {
        ProductDto productDto =restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class);
      // convert fakestoreproduct object to product object
      if(productDto == null){
          throw new InvalidProductIdException(id,"Product not found");
      }
       return convertFakestoreToProduct(productDto);
    }



    @Override
    public List<Product> getAllProduct() {
        ProductDto[] listOfProducts=
                restTemplate.getForObject("https://fakestoreapi.com/products/",
                        ProductDto[].class);
        List<Product> products= new ArrayList<>();
        for(ProductDto productDto : listOfProducts){
            products.add(convertFakestoreToProduct(productDto));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }


    // put method
    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor(ProductDto.class,
                restTemplate.getMessageConverters());
        ProductDto productDto = restTemplate.execute("https://fakestoreapi.com/products/" +id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakestoreToProduct(productDto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
