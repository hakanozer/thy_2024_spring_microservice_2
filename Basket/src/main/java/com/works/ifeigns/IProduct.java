package com.works.ifeigns;

import com.works.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("product")
public interface IProduct {

    @GetMapping("/product/singleProdu/{pid}")
    Product getProduct(@PathVariable long pid);

    @PostMapping("/product/save")
    Product saveProduct(@RequestBody Product product);

}
