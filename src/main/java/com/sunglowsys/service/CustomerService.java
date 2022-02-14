package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    List<Customer> search(String searchText);

    void delete(Long id);
}
