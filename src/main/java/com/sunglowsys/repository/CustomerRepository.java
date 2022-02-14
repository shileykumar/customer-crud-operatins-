package com.sunglowsys.repository;

import com.sunglowsys.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from Customer cust where cust.firstName like %:searchText% " +
            " or cust.lastName like %:searchText% or cust.email like %:searchText% " +
            " or cust.mobile like %:searchText% or cust.gender like %:searchText% ")
    List<Customer> search(@RequestParam("searchText") String searchText);
}
