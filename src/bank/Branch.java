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
@Table(name = "Branch")
public class Branch {

    @Id
    private int branch_id;
    private String branch_name;
    private String branchAddress;

    @OneToMany(mappedBy = "br")
    private List<BankAccount> blist = new ArrayList<>();
    
    @OneToMany(mappedBy = "br")
    private List<Lodgement> llist = new ArrayList<>();

    public Branch() {
    }

    public Branch(int branch_id, String branch_name, String branchAddress) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.branchAddress = branchAddress;
    }

    public Branch(String branch_name, String branchAddress) {
        this.branch_name = branch_name;
        this.branchAddress = branchAddress;
    }
    
    

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Override
    public String toString() {
        return "Branch | " + "branch_id: " + branch_id + ", branch_name: " + branch_name + ", branchAddress: " + branchAddress;
    }

}
