/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceimpl;

import daos.ContactDao;
import java.util.List;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import service.ContactService;

/**
 *
 * @author andreslietti
 */

public class ContactServiceImpl implements ContactService{

    @Autowired (required = true)
    private ContactDao cs;

    public void create(Contact c) {
        cs.add(c);
    }

    public List<Contact> FindByName(String name) {
        return cs.findByName(name);
    }

   
    
    

}
