/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "LODGEMENT")
public class Lodgement {

    @Id
    private int lodgement_id;
    private String lodgement_title;
    private double lodgement_amt;
   
    @ManyToOne()
    @JoinColumn(name = "branch_id")
    private Branch br;   

    @ManyToOne()
    @JoinColumn(name = "Cust_id")
    private Customer cu;
    
    public Lodgement() {
    }

    public Lodgement(int lodgement_id, String lodgement_title, double lodgement_amt) {
        this.lodgement_id = lodgement_id;
        this.lodgement_title = lodgement_title;
        this.lodgement_amt = lodgement_amt;
      
    }

    public Lodgement(String lodgement_title, double lodgement_amt, Branch br, Customer cu) {
        this.lodgement_title = lodgement_title;
        this.lodgement_amt = lodgement_amt;
        this.br = br;
        this.cu = cu;
    }

    public Lodgement(String lodgement_title, double lodgement_amt) {
        this.lodgement_title = lodgement_title;
        this.lodgement_amt = lodgement_amt;
    }
    
    
    
    

    public int getLodgement_id() {
        return lodgement_id;
    }

    public void setLodgement_id(int lodgement_id) {
        this.lodgement_id = lodgement_id;
    }

    public String getLodgement_title() {
        return lodgement_title;
    }

    public void setLodgement_title(String lodgement_title) {
        this.lodgement_title = lodgement_title;
    }

    public double getLodgement_amt() {
        return lodgement_amt;
    }

    public void setLodgement_amt(double lodgement_amt) {
        this.lodgement_amt = lodgement_amt;
    }

    


    @Override
    public String toString() {
        return "Lodgement | " + "lodgement_id: " + lodgement_id + ", lodgement_title: " + lodgement_title + ", lodgement_amt: " + lodgement_amt;
    }

   
    
    
}
