package com.works.restcontrollers;

import com.works.models.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketRestController {

    final ProductService productService;

    @GetMapping("singleProd/{pid}")
    public ResponseEntity<Product> singleProduct(@PathVariable long pid) {
        return productService.singleProduct(pid);
    }

    @GetMapping("productSave")
    public ResponseEntity<Product> productSave() {
        return productService.save();
    }

    @GetMapping("productList")
    public String productList() {
        return productService.listProduct();
    }

}
