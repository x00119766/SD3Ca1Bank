/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Stephen
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("SD3CABankPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer c1 = new Customer();
        c1.setCust_id(1);
        c1.setFname("Tom");
        c1.setLname("Tom");
        c1.setHouse_Num("Tom");
        c1.setStreet("Tom");
        c1.setCity("Tom");
        c1.setCounty("Tom");
        c1.setCountry("Tom");
        Calendar dob1 = Calendar.getInstance();
        dob1.set(2016, 0, 13);
        c1.setDOB(dob1);
        em.persist(c1);
        

       Customer c2 = new Customer();
        c2.setCust_id(2);
        c2.setFname("Bob");
        c2.setLname("Bob");
        c2.setHouse_Num("Bob");
        c2.setStreet("TBob");
        c2.setCity("Bob");
        c2.setCounty("Bob");
        c2.setCountry("Bob");
        Calendar dob2 = Calendar.getInstance();
        dob1.set(2016, 0, 13);
        c2.setDOB(dob2);
        em.persist(c2);
        


        BankAccount b1 = new BankAccount(1, "Tom Personal");
        c1.addBankAccount(b1);

        BankAccount b2 = new BankAccount(2, "Mary Savings");
        c1.addBankAccount(b2);
        
        BankAccount b3 = new BankAccount(3, "Bob Personal");
        c2.addBankAccount(b3);

        BankAccount b4 = new BankAccount(4, "Ms Bob Savings");
        c2.addBankAccount(b4);
        

        System.out.println(c1);
        System.out.println(c2);

        //c3.remove();

        em.getTransaction().commit();
        
         em.getTransaction().begin();
        
        StudentAccount sa1 = new StudentAccount(5, "Jack", "ITT");
        em.persist(sa1);

        System.out.println(sa1);
        System.out.println(b1);
        
        em.getTransaction().commit();
        
        em.getTransaction().begin();

        readCustomer();
        int deletedCount = em.createQuery("DELETE FROM Customer c WHERE c.Cust_id = 2").executeUpdate();
        System.out.println(deletedCount + " entity removed");

        readCustomer();


        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static void readCustomer() {
        System.out.println("==========================================");
        TypedQuery<Customer> query
                = em.createQuery("SELECT c FROM Customer c order by c.Cust_id", Customer.class);
        List<Customer> results = query.getResultList();

        for (Customer c : results) {
            System.out.println(c);
        }
        
    }
    
 
    
}
