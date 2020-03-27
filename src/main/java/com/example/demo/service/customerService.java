package com.example.demo.service;
import com.example.demo.DataAccessObject.CustomerDataAccessObject;
import com.example.demo.ErrorHandling.CustomerNotFoundError;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class customerService {

    @Autowired
    private CustomerDataAccessObject customerDAO;

    private int customerIDCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();

    // add the customer to the database
    // don't have to generate any ID (customerIDCount++) in this class because ID will generated automatically
    // since we used @Id annotation in the customer.java as well as @GeneratedValue annotation
    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    // get the data of all the customers list
    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    // retrieve one specific customer using customer ID
    public Customer getCustomer(int customerID) {
        //storing customerDAO.findById(customerID) in variable optionalCustomer
        Optional<Customer> optionalCustomer = customerDAO.findById(customerID);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundError("Customer is not found/it does not exist");

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerID, Customer customer) {
        //have to send the customerID to the customer object so whatever customer ID we receive, we have to pass that customer ID to this object
        customer.setCustomerID(customerID);
        return customerDAO.save(customer);
    }

    // this method is going to delete the customer based on the ID that we passed
    public void deleteCustomer(int customerID) {
        customerDAO.deleteById(customerID);
    }
}
