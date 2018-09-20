package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Contacts> phoneContacts;
    private String number;

    public MobilePhone(String number) {
        this.phoneContacts = new ArrayList<Contacts>();
        this.number = number;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.phoneContacts.size(); i++) {
            System.out.println((i+1) + "." +
                    this.phoneContacts.get(i).getName() + " -> " +
                    this.phoneContacts.get(i).getNumber());
        }

    }

    public boolean addContact(Contacts contacts){
        if (findContacts(contacts.getName())>=0) {
            System.out.println("Number already in phone");
            return false;
        }
        phoneContacts.add(contacts);
        return true;
    }


    public boolean modifyPhoneContacts(Contacts currentContact,Contacts newContact){
        int possition = findContact(currentContact);
        if(possition<0){
            System.out.println("contact not found");
            return false;
        }
        this.phoneContacts.set(possition,newContact);
        System.out.println(currentContact+" was replace with "+newContact);
        return true;

    }

    public boolean removeContacts(Contacts contact){
        int position = findContact(contact);
        if(position<0) {
            System.out.println("contact not found");
            return false;
        }
        this.phoneContacts.remove(position);
        System.out.println("contact "+contact.getName()+" was deleted");
        return true;
    }

    public int findContact(Contacts contact){
        return this.phoneContacts.indexOf(contact);
    }

    public int findContacts(String searchContact){
        for(int i=0; i<phoneContacts.size();i++){
            Contacts contact= this.phoneContacts.get(i);
            if(contact.getName().equals(searchContact)){
                return i;
            }
        }
        return -1;
    }
    public Contacts queryContact(String name) {
        int position = findContacts(name);
        if(position >=0) {
            return this.phoneContacts.get(position);
        }

        return null;
    }

}

