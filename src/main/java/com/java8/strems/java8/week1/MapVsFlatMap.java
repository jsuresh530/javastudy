package com.java8.strems.java8.week1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Customer{
    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Customer() {
    }

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable (email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public static List<Customer> getAllCustomers(){

        return Stream.of (new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                          new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                          new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                          new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
                         ).collect(Collectors.toList());
    }
}
public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Customer> allCustomers = Customer.getAllCustomers ();
//It is a One-To-One mapping.
        List<Optional<String>> emailsList = allCustomers.stream ().map (cus -> cus.getEmail ()).collect (Collectors.toList ());
        System.err.println ("Email List : "+emailsList);

        List<List<String>> mapPhoneNumbers = allCustomers.stream ().map (Customer::getPhoneNumbers).collect (Collectors.toList ());
        System.err.println ("mapPhoneNumbers : "+mapPhoneNumbers);
        //This is an intermediate operation. It is a One-To-Many mapping.
        List<String> flatMap = allCustomers.stream ().flatMap (customer -> customer.getPhoneNumbers ().stream().parallel ()).collect (Collectors.toList ());
        System.err.println ("flatMap : "+flatMap);


    }

}
