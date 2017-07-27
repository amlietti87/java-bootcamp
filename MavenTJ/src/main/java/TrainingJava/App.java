package TrainingJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Contact;
import model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ContactService;
import service.PersonService;
import serviceimpl.ContactServiceImpl;
import serviceimpl.PersonServiceImpl;



public class App
{
    public static void main( String[] args )
    {
        
      Scanner sc = new Scanner(System.in); 
      
        ApplicationContext ac = new AnnotationConfigApplicationContext(config.AppConfig.class);
        ApplicationContext ac1 = new AnnotationConfigApplicationContext(config.AppConfig.class);
      
      PersonService ps =   ac.getBean(PersonService.class);
      ContactService cs =   ac1.getBean(ContactService.class);  
      
      Person p = new Person();
      System.out.println("Please enter your name: ");
      String pname = sc.nextLine();
      p.setName(pname);
      System.out.println("Please enter your lastname: ");
      String plastname = sc.nextLine();
      p.setLastName(plastname);
      System.out.println("Please enter your dni: ");
      String pdni = sc.nextLine();
      p.setDni(pdni);
      ps.create(p);
      
      List<Person> list = ps.FindByName(pname);
        System.out.println(pname);
        System.out.println(ps.FindByName(pname));
      
      Contact c = new Contact();
      System.out.println("Please enter your contact name: ");
      String cname = sc.nextLine();
      p.setName(cname);
      System.out.println("Please enter your contact lastname: ");
      String clastname = sc.nextLine();
      p.setLastName(clastname);
      System.out.println("Please enter your contact phone: ");
      String cphone = sc.nextLine();
      p.setDni(cphone);
      System.out.println("Please enter your contact mail: ");
      String cmail = sc.nextLine();
      p.setDni(cmail);
      cs.create(c);
      
      list.get(0).getContacts().add(c);
      ps.create(list.get(0));
      
      for (Person person : list) {
            System.out.println(person.getName());
            System.out.println(person.getLastName());
            System.out.println(person.getDni());
            for (Contact contact : person.getContacts()) {
                System.out.println(contact.getName());
                System.out.println(contact.getLastname());
                System.out.println(contact.getPhone());
                System.out.println(contact.getMail());
            }

            
        }
      
    }
}
