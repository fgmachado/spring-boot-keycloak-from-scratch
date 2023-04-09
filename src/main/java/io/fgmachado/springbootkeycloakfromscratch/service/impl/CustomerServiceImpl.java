package io.fgmachado.springbootkeycloakfromscratch.service.impl;

import io.fgmachado.springbootkeycloakfromscratch.entity.Customer;
import io.fgmachado.springbootkeycloakfromscratch.repository.CustomerRepository;
import io.fgmachado.springbootkeycloakfromscratch.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(final Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Invalid customer ID!");
        }

        return customerRepository.findById(id);
    }

    @Override
    public Customer save(final Customer customer) {
        if (Objects.isNull(customer)) {
            throw new IllegalArgumentException("Invalid customer!");
        }

        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Invalid customer ID!");
        }

        customerRepository.deleteById(id);

        return Boolean.TRUE;
    }

}
