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
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Bank_Account")
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name = "type" )
@DiscriminatorValue("Current")
public class BankAccount implements Serializable{
    
    @Id
    private int AccNumber;
    private String AccName;
    
    @ManyToOne()
    @JoinColumn(name = "branch_id")
    private Branch br;
    
    @ManyToMany(mappedBy = "blist")
    private List<Customer> clist = new ArrayList<>();


    public BankAccount() {
    }

    public BankAccount(int AccNumber, String AccName) {
        this.AccNumber = AccNumber;
        this.AccName = AccName;
        
    }

    public BankAccount(String AccName, Branch br) {
        this.AccName = AccName;
    }

    public Branch getBr() {
        return br;
    }

    public void setBr(Branch br) {
        this.br = br;
    }
    
    

    public int getAccNumber() {
        return AccNumber;
    }

    public void setAccNumber(int AccNumber) {
        this.AccNumber = AccNumber;
    }

    public String getAccName() {
        return AccName;
    }

    public void setAccName(String AccName) {
        this.AccName = AccName;
    }

 
    public List<Customer> getClist() {
        return clist;
    }

    public void setClist(List<Customer> clist) {
        this.clist = clist;
    }

    
    
    @Override
    public String toString() {
        return "Bank Account | " + "AccNumber: " + AccNumber + ", AccName: " + AccName;
    }
    
    

}
