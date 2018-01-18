package com.company;

public class Main {

    public static void main(String[] args) {
        Movie movie1987 = new Movie("1987", 1);
        Rental rental = new Rental(movie1987,7);
        Customer customer = new Customer("Hyuk");
        customer.addRental(rental);

        System.out.println(customer.statement());
    }
}
