package com.example.productservice.repositories;

import com.example.productservice.Projections.ProductWithIdTitle;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long>{

    Optional<Product> findById(Long id);

    Optional<Product> findByTitleAndDescription(String title, String description);
    List<Product> findByTitleContaining(String word);

    Optional<Product> findTopThreeByTitle(String title);
    Optional<Product> findByCategory(Category category);
    void deleteById(Long id);

    void deleteByTitle(String title);
    Product save(Product product);

    @Query("select p from Product p where p.id=2")
   List<ProductWithIdTitle> someRandomquery();


}





/*

C -> Create
R -> Read
U -> Update
D -> Delete

Create, Update => save()

Product save(Product product);

ProductRepository -> Product

Product findById(id) => select * from product where id = <id>
List<Product> findAll() => select * from product
Product findByTitle(String title) => select * from product where title = "";
 */