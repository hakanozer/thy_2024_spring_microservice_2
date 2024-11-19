package com.works.repositories;

import com.works.entities.Customer;
import com.works.projections.CustomerAddressJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select  CUSTOMER.NAME, CUSTOMER.SURNAME, A.AID, A.CITY, A.STREET from PUBLIC.CUSTOMER\n" +
            "inner join PUBLIC.CUSTOMER_ADDRESSES CA on CUSTOMER.CID = CA.CUSTOMER_CID\n" +
            "inner join PUBLIC.ADDRESS A on A.AID = CA.ADDRESSES_AID", nativeQuery = true)
    List<CustomerAddressJoin> customerAddressJoin();

}