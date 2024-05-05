package com.example.productservice.services;

import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProduct")
@Primary
public class selfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    selfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){

        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getProducBytId(Long id) throws InvalidProductIdException {

        Optional<Product> optionalProduct= productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            return null;
        }
        return optionalProduct.get();

    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct= productRepository.findById(id);

        if(optionalProduct.isEmpty()) throw new RuntimeException();
        Product currentProduct= optionalProduct.get();
        if(product.getTitle() != null){
            currentProduct.setTitle(product.getTitle());
        }
        if(product.getDescription() != null){
            currentProduct.setDescription(product.getDescription());
        }

        return productRepository.save(currentProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category=product.getCategory();
        if(category.getId()== null){
            Category savedCategory= categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct() {

    }
}
