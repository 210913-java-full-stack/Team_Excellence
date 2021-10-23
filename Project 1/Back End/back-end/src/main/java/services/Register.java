package services;

import model.Customer;
import repository.CustomerRepo;

public class Register {
    public Customer registerForAccount(Customer customer){
        CustomerRepo.saveNewCustomer(customer);
        return CustomerRepo.getByUsername(customer.getUsername());
    }
}
