package io.fgmachado.springbootkeycloakfromscratch.service;

import io.fgmachado.springbootkeycloakfromscratch.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    boolean deleteById(Long id);

}
