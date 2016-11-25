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
@Table(name = "Student_Account")
@DiscriminatorValue("Student")
@PrimaryKeyJoinColumn(referencedColumnName = "AccNumber")

public class StudentAccount extends BankAccount {

    private String college_name;

    public StudentAccount() {
    }

    public StudentAccount(int AccNumber, String AccName, String college_name) {
        super(AccNumber, AccName);
        this.college_name = college_name;
    }

    public StudentAccount(String AccName, String college_name, Branch br) {
        super(AccName, br);
        this.college_name = college_name;
    }
    
    

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    @Override
    public String toString() {
        return "Student " +super.toString() + ", College name: " + college_name ;
    }

    
    
}
