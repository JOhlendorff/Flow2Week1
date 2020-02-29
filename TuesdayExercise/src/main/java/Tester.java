
import entity.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import entity.Customer;
import entity.Customer2;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jenso
 */
    public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    Tester facade = Tester.getTester(emf);
//    Customer c = new Customer();
//    c.setFirstName("jens");
//    c.addHobbies("sport");
//    c.addHobbies("håndværk");
//    c.addHobbies("madlavning");
//    c.addHobbies("træning");
//    c.addPhone("12543212", "burner");
//    c.addPhone("42543212", "mobil");
//    facade.addCustomer(c);
     
    Customer2 c = new Customer2("Lars", "Larsen");
    Address address = new Address("Charlottenlund", "Hovmarkvej 2");
    Address address2 = new Address("Charlottenlund", "Hovmarkvej 3");
    c.setAddress(address);
    c.setAddress(address2);
    facade.addCustomer(c);
    }

    private static Tester instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    //Private Constructor to ensure Singleton
    private Tester() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static Tester getTester(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Tester();
        }
        return instance;
    }
    Customer2 addCustomer(Customer2 cust){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;

        }finally {
            em.close();
        }
    }


}
