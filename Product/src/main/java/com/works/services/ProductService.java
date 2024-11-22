package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final JmsTemplate jmsTemplate;

    public Product save(Product product) {
        productRepository.save(product);
        jmsTemplate.convertAndSend("q1", product);
        return product;
    }

    public Page<Product> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Product> ls = productRepository.findAll(pageable);
        return ls;
    }

    public Optional<Product> findById(long pid) {
        Optional<Product> optionalProduct = productRepository.findById(pid);
        return optionalProduct;
    }


    public Page<Product> report(String title, String description, int price, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return productRepository.findByTitleContainsAndDescriptionContainsAndPriceGreaterThanAllIgnoreCase(title, description, price, pageable);
    }

    public List<Product> allSave(List<Product> products) {
        return productRepository.saveAll(products);
    }

}
