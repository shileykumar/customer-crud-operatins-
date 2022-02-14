package com.sunglowsys.rest;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.rest.util.BadRequestException;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomers(@RequestBody Customer customer) throws URISyntaxException {
        log.debug("REST request to create Customer : {}", customer);
        if (customer.getId() != null) {
            throw new BadRequestException("id should be null in create api call");
        }
        Customer result = customerService.save(customer);
        return ResponseEntity
                .created(new URI("/api/customers/" + result.getId()))
                .body(result);
    }

    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        log.debug("REST request to update Customer : {} ", customer);
        if (customer.getId() == null) {
            throw new BadRequestException("id should not be null id update api call");
        }
        Customer result = customerService.update(customer);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(Pageable pageable) {
        log.debug("REST request to get Customers : {} ", pageable.toString());
        Page<Customer> result = customerService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        log.debug("REST request to get Customer : {} ", id);
       Optional<Customer> result = customerService.findById(id);
       return ResponseEntity
               .ok()
               .body(result.get());
    }

    @GetMapping("/_search/customers")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String searchText) {
        log.debug("REST request to search Customers : {}", searchText);
        List<Customer> result = customerService.search(searchText);
        return ResponseEntity
                .ok()
                .body(result);
    }
    
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        log.debug("REST request to delete Customer : {}", id);
        customerService.delete(id);
        return ResponseEntity
                .ok().build();
    }
}
