package com.works.repositories;

import com.works.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByTitleContainsAndDescriptionContainsAndPriceGreaterThanAllIgnoreCase(String title, String description, Integer price, Pageable pageable);

    @Query("""
            select p from Product p
            where p.title like concat('%', ?1, '%') or p.description like concat('%', ?2, '%') or p.price > ?3""")
    List<Product> report(String title, String description, Integer price);

}