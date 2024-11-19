package com.works.services;

import com.works.entities.Customer;
import com.works.projections.CustomerAddressJoin;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<CustomerAddressJoin> findAllCustomer(){
        List<CustomerAddressJoin> ls = customerRepository.customerAddressJoin();
        ls.forEach(item -> {
            System.out.println(item.getCity());
        });
        return ls;
    }

}
