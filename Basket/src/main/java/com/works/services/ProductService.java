package com.works.services;

import com.works.ifeigns.IDummy;
import com.works.ifeigns.IProduct;
import com.works.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    final DiscoveryClient discoveryClient;
    final RestTemplate restTemplate;
    final IProduct iProduct;
    final IDummy iDummy;

    public ResponseEntity<Product> singleProduct(long pid ) {
        /*
        List<ServiceInstance> list = discoveryClient.getInstances("product");
        if (!list.isEmpty()) {
            ServiceInstance serviceInstance = list.get(0);
            String url = serviceInstance.getUri().toString() + "/product/singleProduct/" + pid;
            ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
            return response.getBody();
        }
        return null;
         */
        return iProduct.getProduct(pid);
    }

    public ResponseEntity<Product> save() {
        Product product = new Product();
        product.setCity("İstanbul");
        product.setTitle(UUID.randomUUID().toString());
        product.setDescription("Detail");
        product.setPrice( new Random().nextInt(10000) );
        return iProduct.saveProduct(product);
    }

    public String listProduct() {
        return iDummy.getProducts();
    }

}
