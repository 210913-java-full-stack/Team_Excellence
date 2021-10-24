package services;

import model.Customer;
import repository.CustomerRepo;

public class Register {
    /**
     * This class adds the new user to the database and returns the user's information.
     * @param customer Requires the inputted user information from the front end.
     */
    public Customer registerForAccount(Customer customer){
        CustomerRepo.saveNewCustomer(customer);
        return CustomerRepo.getByUsername(customer.getUsername());
    }
}
