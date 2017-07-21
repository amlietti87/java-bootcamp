/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceimpl;

import java.util.List;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import service.ContactService;

/**
 *
 * @author andreslietti
 */
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactService cs;

    public void create(Contact c) {
        cs.create(c);
    }

    public List<Contact> FindByName(String name) {
        return cs.FindByName(name);
    }

   
    
    

}
