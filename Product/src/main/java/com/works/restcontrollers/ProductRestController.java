package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
       Product pro = productService.save(product);
       if (pro == null) {
           return ResponseEntity.status(500).body(product);
       }
       return new ResponseEntity<>(pro, HttpStatus.OK);
    }

    @GetMapping("list")
    public Page<Product> list(@RequestParam(defaultValue = "0") int pageNumber) {
        return productService.findAll(pageNumber);
    }

    @GetMapping("singleProduct/{pid}")
    public ResponseEntity singleProduct(@PathVariable long pid) {
        Optional<Product> pro = productService.findById(pid);
        if (pro.isPresent()) {
            return new ResponseEntity<>(pro.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("product not fount :" + pid, HttpStatus.NOT_FOUND);
    }

    @GetMapping("report")
    public ResponseEntity report(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "0") Integer price,
            @RequestParam(defaultValue = "0") Integer pageNumber
    ) {
        Page<Product> ls = productService.report(title, description, price, pageNumber);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    @PostMapping("saveAll")
    public ResponseEntity saveAll(@RequestBody List<Product> products) {
        return new ResponseEntity(productService.allSave(products), HttpStatus.OK);
    }


}

