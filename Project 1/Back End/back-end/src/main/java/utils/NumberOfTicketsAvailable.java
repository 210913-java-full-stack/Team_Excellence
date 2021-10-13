package utils;

public class NumberOfTicketsAvailable {

    public NumberOfTicketsAvailable() {
    }

    //Finds the number of tickets available for purchase
    public static int ticketsAvailable(){
        int tickets = 0; //TODO: Change this initialization after implementing Hibernate
        int maxTickets = 20; //TODO: Discuss this value
        int purchasedTickets = 0; //TODO: Change this initialization after implementing Hibernate
        //TODO: Write code after implementing Hibernate
        tickets = maxTickets - purchasedTickets;
        return tickets;
    }

}
