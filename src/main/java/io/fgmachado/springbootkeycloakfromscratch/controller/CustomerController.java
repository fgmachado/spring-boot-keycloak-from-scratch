package io.fgmachado.springbootkeycloakfromscratch.controller;

import io.fgmachado.springbootkeycloakfromscratch.entity.Customer;
import io.fgmachado.springbootkeycloakfromscratch.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        try {
            final List<Customer> customers = customerService.findAll();

            if (Objects.isNull(customers) || customers.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        try {
            final Optional<Customer> customer = customerService.findById(id);

            if (Objects.isNull(customer) || customer.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(customer.get());

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(customerService.save(customer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(customerService.save(customer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(customerService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
