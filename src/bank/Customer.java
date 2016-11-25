/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Stephen
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Customer2")
public class Customer {

    @Id
    private int Cust_id;
    private String Fname;
    private String Lname;
    private String House_Num;
    private String Street;
    private String city;
    private String County;
    private String Country;
    @Temporal(TemporalType.DATE)
    private Calendar DOB;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AccCust",
            joinColumns = @JoinColumn(name = "Cust_id"),
            inverseJoinColumns = @JoinColumn(name = "AccNumber"))
    private List<BankAccount> blist = new ArrayList<>();
    
    @OneToMany(mappedBy = "cu")
    private List<Lodgement> llist = new ArrayList<>();

    public Customer() {
    }

    public Customer(int Cust_id, String Fname, String Lname, String House_Num, String Street, String city, String County, String Country, Calendar DOB) {
        this.Cust_id = Cust_id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.House_Num = House_Num;
        this.Street = Street;
        this.city = city;
        this.County = County;
        this.Country = Country;
        this.DOB = DOB;
    }

    public Customer(String Fname, String Lname, String House_Num, String Street, String city, String County, String Country, Calendar DOB) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.House_Num = House_Num;
        this.Street = Street;
        this.city = city;
        this.County = County;
        this.Country = Country;
        this.DOB = DOB;
    }
    
    

    public int getCust_id() {
        return Cust_id;
    }

    public void setCust_id(int Cust_id) {
        this.Cust_id = Cust_id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getHouse_Num() {
        return House_Num;
    }

    public void setHouse_Num(String House_Num) {
        this.House_Num = House_Num;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public Calendar getDOB() {
        return DOB;
    }

    public void setDOB(Calendar DOB) {
        this.DOB = DOB;
    }

    public List<BankAccount> getBlist() {
        return blist;
    }

    public void setBlist(List<BankAccount> blist) {
        this.blist = blist;
    }

    public void addBankAccount(BankAccount b) {
        blist.add(b);
        b.getClist().add(this);
    }

    public void removeBankAccount(BankAccount b) {
        blist.remove(b);
        b.getClist().remove(this);
    }

    public void remove() {
        ArrayList<BankAccount> temp = new ArrayList<>(blist);
        for (int i = 0; i < temp.size(); i++) {
            removeBankAccount(temp.get(i));
        }
    }

    @Override
    public String toString() {
        String d = String.format("%1$s %2$tB %2$td, %2$tY", 
                         " Date of Birth:", DOB);
        return "Customer | " + "Cust_id: " + Cust_id + ", Fname: " + Fname + ", Lname: " + Lname + ", House_Num: " + House_Num + ", Street: " + Street + ", city: " + city + ", County: " + County + ", Country: " + Country + ", " + d;
    }

}
