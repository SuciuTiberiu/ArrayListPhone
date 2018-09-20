package com.company;

public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    public static Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }
}
