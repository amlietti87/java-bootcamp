/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceimpl;

import java.util.ArrayList;
import java.util.List;
import model.Contact;
import service.ContactService;

/**
 *
 * @author andreslietti
 */

public class ContactServiceImpl implements ContactService{

    
    private List <Contact> cs = new ArrayList<Contact>();

    public void create(Contact c) {
        cs.add(c);
    }

    

   
    
    

}
