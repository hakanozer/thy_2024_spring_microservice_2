package com.works.ifeigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dummy", url = "https://dummyjson.com/")
public interface IDummy {

    @GetMapping("products")
    String getProducts();

}
