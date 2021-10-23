package services;


import model.Admin;
import model.Customer;
import repository.AdminRepo;
import repository.CustomerRepo;

public class Login {
    public Login() {
    }

    /**
     * This method takes the username and password the user inputted in the UI and checks to see if
     * the username is in the database. If it is, then the password from the database is compared to the
     * data inputted in the UI.
     * @param customer Requires the username and password sent from the Front End
     * @return Returns user if the username is in the database and the passwords match. If the username is
     * not in the database or the password does not match, then this method returns null.
     */
    public Customer customerLogin(Customer customer){
        String password = customer.getPassword();
        Customer user = CustomerRepo.getByUsername(customer.getUsername());
        if (user != null && user.getPassword().equals(password)){
            return user;
        } else{
            return null;
        }
    }

    /**
     * This method takes the username and password the user inputted in the UI and checks to see if
     * the username is in the database. If it is, then the password from the database is compared to the
     * data inputted in the UI.
     * @param admin Requires the username and password sent from the Front End
     * @return Returns user if the username is in the database and the passwords match. If the username is
     * not in the database or the password does not match, then this method returns null.
     */
    public Admin adminLogin(Admin admin){
        String password = admin.getPassword();
        Admin user = AdminRepo.getByUsername(admin.getUsername());
        if (user != null && user.getPassword().equals(password)){
            return user;
        } else{
            return null;
        }

    }
}
