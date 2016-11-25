package dbServices;

import java.util.List;
import javax.persistence.*;
import bank.BankAccount;
import bank.Branch;
import bank.Customer;
import bank.Lodgement;
import bank.StudentAccount;
import bank.SystemUser;
import java.util.Calendar;
import java.util.Scanner;

import dbServices.BankOperations;

public class JPAService {

    Scanner in = new Scanner(System.in);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SD3CABankPU");
    EntityManager em = emf.createEntityManager();

    /*public int findUsernameID(String user1) {
     int userID = 0;
     Query query = em.createQuery("SELECT c.user_id from SystemUser c "
     + "WHERE c.username=:value", 
     SystemUser.class).setParameter("value", user1);
     try {
     userID = (int) query.getSingleResult();

     } catch (NoResultException e) {
     System.out.println("Nothing found  " + e.getMessage());
     }
     return userID;
     }
    
     public boolean findUsername(String username) {
     int user_id = findUsernameID(username);
     boolean found = false;
     SystemUser abo = em.find(SystemUser.class, user_id);
     if (abo != null) {
     found = true;
     }
     return found;
     }
     */
    public int findSystemUserID(String username, String password) {
        int userID = 0;
        Query query = em.createQuery("SELECT c.user_id from SystemUser c "
                + "WHERE c.username=:value and c.password=:value2",
                SystemUser.class).setParameter("value", username).setParameter("value2", password);
        try {
            userID = (int) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Nothing found  " + e.getMessage());
        }
        return userID;
    }

    public boolean findSystemUser(String username, String password) {
        int id = findSystemUserID(username, password);
        boolean found = false;
        SystemUser abo = em.find(SystemUser.class, id);
        if (abo != null) {
            found = true;
        }
        return found;
    }

    public int findCustomerID(String fname, String lname) {
        int custID = 0;
        Query query = em.createQuery("SELECT c.Cust_id from Customer c "
                + "WHERE c.Fname=:value and c.Lname=:value2",
                Customer.class).setParameter("value", fname).setParameter("value2", lname);
        try {
            custID = (int) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Nothing found  " + e.getMessage());
        }
        return custID;
    }

    public boolean findCustomer(String fname, String lname) {
        int id = findCustomerID(fname, lname);
        boolean found = false;
        Customer abo = em.find(Customer.class, id);
        if (abo != null) {
            found = true;
        }
        return found;
    }

    public int findBranchID(String branchName) {
        int branchID = 0;
        Query query = em.createQuery("SELECT b.branch_id from Branch b "
                + "WHERE b.branch_name=:value",
                Branch.class).setParameter("value", branchName);
        try {
            branchID = (int) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Nothing found  " + e.getMessage());
        }
        return branchID;
    }

    public void printAllCustomers(String fname, String lname) {
        int id = findCustomerID(fname, lname);
        Query q = em.createNativeQuery("SELECT C.Cust_id, C.Fname, C.Lname,"
                + "C.House_Num, C.Street, C.city, C.County"
                + ", C.Country, C.DOB FROM Customer2 C, "
                + "WHERE C.Cust_id=" + id, Customer.class);
        List<Customer> results = q.getResultList();

        for (Customer c : results) {
            System.out.println(c);
        }
    }

    public void readCustomer() {
        System.out.println("==========================================");
        TypedQuery<Customer> query
                = em.createQuery("SELECT c FROM Customer c order by c.Cust_id", Customer.class);
        List<Customer> results = query.getResultList();

        for (Customer c : results) {
            System.out.println(c);
        }

    }

    public void readBranch() {
        System.out.println("==========================================");
        TypedQuery<Branch> query
                = em.createQuery("SELECT b FROM Branch b order by b.branch_id", Branch.class);
        List<Branch> results = query.getResultList();

        for (Branch b : results) {
            System.out.println(b);
        }

    }

    public void readLodgement() {
        System.out.println("==========================================");
        TypedQuery<Lodgement> query
                = em.createQuery("SELECT l FROM Lodgement l order by l.lodgement_id", Lodgement.class);
        List<Lodgement> results = query.getResultList();

        for (Lodgement l : results) {
            System.out.println(l);
        }

    }

    public void readBankAccount() {
        System.out.println("==========================================");
        TypedQuery<BankAccount> query
                = em.createQuery("SELECT b FROM BankAccount b order by b.AccNumber", BankAccount.class);
        List<BankAccount> results = query.getResultList();

        for (BankAccount b : results) {
            System.out.println(b);
        }

    }

    public void readStudentAccount() {
        System.out.println("==========================================");
        TypedQuery<StudentAccount> query
                = em.createQuery("SELECT b FROM StudentAccount b order by b.AccNumber", StudentAccount.class);
        List<StudentAccount> results = query.getResultList();

        for (StudentAccount b : results) {
            System.out.println(b);
        }

    }
/*
    public Customer createCustomerCurrentAccount(String FnameAdd, String LnameAdd, String House_NumAdd,
            String StreetAdd, String cityAdd, String CountyAdd, String CountryAdd, Calendar DOBAdd, String accNameAdd, String branchNameBank) {
        
       
       
        
       Customer c =  createCustomer(FnameAdd, LnameAdd, House_NumAdd, StreetAdd, cityAdd, CountyAdd, CountryAdd, DOBAdd);
       BankAccount b = createBankAccount(accNameAdd, branchNameBank, FnameAdd, LnameAdd);

        em.getTransaction().begin();
      
       
        c.addBankAccount(b);
        
        em.persist(c);

        em.getTransaction().commit();
        return c;

    }

    public Customer createCustomerStudentAccount(String FnameAdd, String LnameAdd, String House_NumAdd,
            String StreetAdd, String cityAdd, String CountyAdd, String CountryAdd, Calendar DOBAdd, String accNameAdd, String collegeName, String branchNameBank) {

        Customer c = new Customer(FnameAdd, LnameAdd, House_NumAdd,
                StreetAdd, cityAdd, CountyAdd, CountryAdd, DOBAdd);

        c.addBankAccount(createStudentAccount(accNameAdd, collegeName, branchNameBank,FnameAdd, LnameAdd ));

        em.getTransaction().begin();

        em.persist(c);

        em.getTransaction().commit();
        return c;

    }*/

    public Customer createCustomer(String FnameAdd, String LnameAdd, String House_NumAdd,
            String StreetAdd, String cityAdd, String CountyAdd, String CountryAdd, Calendar DOBAdd) {

        em.getTransaction().begin();
        Customer c = new Customer(FnameAdd, LnameAdd, House_NumAdd,
                StreetAdd, cityAdd, CountyAdd, CountryAdd, DOBAdd);

        em.persist(c);

        em.getTransaction().commit();
        return c;

    }

    public Branch createBranch(String nameAdd, String addressAdd) {
        em.getTransaction().begin();
        Branch b = new Branch(nameAdd, addressAdd);
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }

    public Lodgement createLodgement(String titleAdd,
            double amtAdd, String fname, String lname, String branchName) {

        int Cid = findCustomerID(fname, lname);
        Customer cu = em.find(Customer.class, Cid);

        int Bid = findBranchID(branchName);
        Branch br = em.find(Branch.class, Bid);

        em.getTransaction().begin();
        Lodgement l = new Lodgement(titleAdd, amtAdd, br, cu);

        l.setBr(br);
        l.setCu(cu);

        em.persist(l);

        em.getTransaction().commit();
        return l;
    }
    /*
    public BankAccount createBankAccountNewCustomer(String AccName, String branchName) {

        int Bid = findBranchID(branchName);
        Branch br = em.find(Branch.class, Bid);

      

        em.getTransaction().begin();

        BankAccount b = new BankAccount(AccName, br);

        b.setBr(br);
     

        em.persist(b);

        em.getTransaction().commit();
        return b;
    }*/

    public BankAccount createBankAccount(String AccName, String branchName, String fname, String lname) {

        int Bid = findBranchID(branchName);
        Branch br = em.find(Branch.class, Bid);

        int id = findCustomerID(fname, lname);
        Customer c = em.find(Customer.class, id);

        em.getTransaction().begin();

        BankAccount b = new BankAccount(AccName, br);

        b.setBr(br);
        b.addCustomer(c);

        em.persist(b);

        em.getTransaction().commit();
        return b;
    }

    public StudentAccount createStudentAccount(String AccName, String collegeName, String branchName, String fname, String lname) {

        int Bid = findBranchID(branchName);
        Branch br = em.find(Branch.class, Bid);

        int id = findCustomerID(fname, lname);
        Customer c = em.find(Customer.class, id);

        em.getTransaction().begin();

        StudentAccount s = new StudentAccount(AccName, collegeName, br);
        
        s.setBr(br);
        s.addCustomer(c);

        em.persist(s);

        em.getTransaction().commit();
        return s;
    }

    public void updateCustomerAddress(int id, String houseNumAdd, String streetAdd, String cityAdd,
            String countyAdd, String countryAdd) {
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, id);
        c.setHouse_Num(houseNumAdd);
        c.setStreet(streetAdd);
        c.setCity(cityAdd);
        c.setCounty(countyAdd);
        c.setCountry(countryAdd);
        em.getTransaction().commit();
    }

    public void updateCustomerSurname(int id, String surnameAdd) {
        em.getTransaction().begin();

        Customer c = em.find(Customer.class, id);

        c.setLname(surnameAdd);

        em.getTransaction().commit();
    }

    public void updateBankAccountName(int id, String nameAdd) {
        em.getTransaction().begin();

        BankAccount b = em.find(BankAccount.class, id);

        b.setAccName(nameAdd);

        em.getTransaction().commit();
    }

    public void updateStudentAccountCollegeName(int id, String collegeAdd) {
        em.getTransaction().begin();

        StudentAccount s = em.find(StudentAccount.class, id);

        s.setAccName(collegeAdd);

        em.getTransaction().commit();
    }

    public void removeCustomer(int id) {
        Customer c = em.find(Customer.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void removeBranch(int id) {
        Branch b = em.find(Branch.class, id);
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
    }

    public void removeBankAccount(int id) {
        BankAccount b = em.find(BankAccount.class, id);
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
    }

    /*
     public boolean findContact(int cid, String owner) {
     System.out.println("In here Contact Id" + cid);
     boolean found = false;
     int ownerid = findOwnerID(owner);

     Query q = em.createNativeQuery("SELECT C.PNUMBER\n"
     + "FROM CONTACTS C, CONTACTSADDRESSBOOK CAB\n"
     + "where C.ID = CAB.CID\n"
     + "and CAB.ABID = " + ownerid
     + "and c.id = " + cid);
     List<Contact> results = q.getResultList();
        
     //easier than for loop below
     if (!results.isEmpty()){
     found = true;
     }
     return found;
     }
    
     public void updateContact(int id , String newNum){
     em.getTransaction().begin();
     Contact c = em.find(Contact.class, id);
     c.setPhoneNumber(newNum);
     em.getTransaction().commit();
     }

     public void removeContact(int id) {
     Contact c = em.find(Contact.class, id);
     em.getTransaction().begin();
     em.remove(c);
     em.getTransaction().commit();
     }
    
     public Contact createContact(String nameAdd, String addAdd, String emailAdd, 
     String numAdd, String owner){
     int id = findOwnerID(owner);
     AddressBookOwner abo =  em.find(AddressBookOwner.class, id);
     em.getTransaction().begin();
     Contact c = new Contact(nameAdd, addAdd, emailAdd, numAdd);
     c.addStaff(abo);
     em.getTransaction().commit();
     return c;
     }
     */
}
