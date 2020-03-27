package com.example.demo.DataAccessObject;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDataAccessObject extends CrudRepository<Customer, Integer> {

    @Override
    // should return list of customer instead of iterable customer object
    List<Customer> findAll();

}
