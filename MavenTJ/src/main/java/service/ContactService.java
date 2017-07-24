/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Contact;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreslietti
 */
@Service
public interface ContactService{
    
    public void create(Contact c);
    public List <Contact> FindByName(String name);
    
}
