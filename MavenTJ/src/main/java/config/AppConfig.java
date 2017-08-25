/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ContactService;
import service.PersonService;
import serviceimpl.ContactServiceImpl;
import serviceimpl.PersonServiceImpl;


/**
 *
 * @author andreslietti
 */

@Configuration

public class AppConfig {
    
    @Bean
    public ContactService getContactService() {
        return new ContactServiceImpl();
    }
    
    @Bean
    public PersonService getPersonService() {
        return new PersonServiceImpl();
    }
    
}
