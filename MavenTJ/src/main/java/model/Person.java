/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreslietti
 */
public class Person {

    
    private String name;
    private String lastname;
    private String dni;
    List<Contact> contacts = new ArrayList<Contact>();


    public String getLastName() {
        return lastname;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

}
