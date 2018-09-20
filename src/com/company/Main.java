package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("154841452");
    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printPhoneContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyPhoneContacts();
                    break;
                case 4:
                    removeContacts();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }
    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("\t 0 - to print choice option");
        System.out.println("\t 1 - to print list of contacts ");
        System.out.println("\t 2 - to add a contact to the Phone");
        System.out.println("\t 3 - to modify a contact from the Phone");
        System.out.println("\t 4 - to remove a contact from the Phone");
        System.out.println("\t 5 - to search for a contact in the Phone");
        System.out.println("\t 6 - to quit the application");
    }

    public static void addContact(){
        System.out.print("enter the contact name ");
        String name = scanner.nextLine();
        System.out.println("enter phone number");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name,number);
        if(mobilePhone.addContact(newContact)){
            System.out.println("new contact created");
        }else{
            System.out.println("can not add "+name+" already in contacts list");
        }

    }

    private static void modifyPhoneContacts() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if(mobilePhone.modifyPhoneContacts(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }
    private static void removeContacts() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContacts(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getNumber());
    }
}
