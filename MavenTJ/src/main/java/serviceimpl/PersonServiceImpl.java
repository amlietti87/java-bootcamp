/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceimpl;


import java.util.ArrayList;
import java.util.List;
import model.Person;
import service.PersonService;



/**
 *
 * @author andreslietti
 */

public class PersonServiceImpl implements PersonService{
    
    private List <Person> ps = new ArrayList();

   
   
    public void create (Person p){
        ps.add(p);
    }
    
    
    public List FindByName(String name){ 
        
        for (int i = 0; i < ps.size(); i++) {
            if (name.equals(ps.get(i).getName())) {
                return ps;
            }
        }
        return null;
        
    }
}
