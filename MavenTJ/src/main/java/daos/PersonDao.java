/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import model.Person;

/**
 *
 * @author andreslietti
 */
public interface PersonDao {
    List <Person> add (Person person);
    List <Person> findByName (String nombre);
}
