package services;


import model.Admin;
import model.Customer;
import repository.AdminRepo;
import repository.CustomerRepo;

public class Login {
    public Login() {
    }

    public Customer customerLogin(Customer customer){
        String username = customer.getUsername();
        String password = customer.getPassword();
        Customer user = CustomerRepo.getByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        } else{
            return null;
        }
    }

    public Admin adminLogin(Admin admin){
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin user = AdminRepo.getByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        } else{
            return null;
        }

    }
}
