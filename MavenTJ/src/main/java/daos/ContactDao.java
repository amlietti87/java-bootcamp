/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author andreslietti
 */
public interface ContactDao {
    
    List <Contact> add (Contact contact);
    List <Contact> findByName(String nombre);
    
}
