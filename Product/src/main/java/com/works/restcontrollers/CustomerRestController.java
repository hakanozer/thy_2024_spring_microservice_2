package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.projections.CustomerAddressJoin;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("customer/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("customer/list")
    public List<CustomerAddressJoin> customerList(){
        return customerService.findAllCustomer();
    }

}
