/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceimpl;


import daos.PersonDao;
import java.util.List;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import service.PersonService;



/**
 *
 * @author andreslietti
 */

public class PersonServiceImpl implements PersonService{
    
    @Autowired (required = true)
    private PersonDao ps;

   
   
    public void create (Person p){
        ps.add(p);
    }
    
    
    public List FindByName(String name){ 
        return ps.findByName(name);
        
    }
}
