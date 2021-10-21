package services;


import model.Customer;
import repository.CustomerRepo;

public class Login {
    public Login() {
    }

    public Customer customerLogin(Customer customer){
        Customer user = CustomerRepo.getByUsername(customer.getUsername()/*,customer.getPassword()*/);
        return user;

    }


    public void pilotLogin(){

    }

    public void adminLogin(){

    }
}
