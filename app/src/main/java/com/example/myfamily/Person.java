package com.example.myfamily;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String username;

    // The constructor method
    public Person(String firstName, String lastName, String address, String username)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
    }

    // The new constructor method
    public Person(String firstName, String lastName, String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = "";
    }

    // A method to display the state of the object to the screen
    public void displayPersonDetails()
    {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Username: " + username);
    }
}
