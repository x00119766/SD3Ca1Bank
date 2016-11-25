package dbServices;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.Calendar;

public class BankOperations {

    private Connection conn;
    private ResultSet rset;
    private PreparedStatement pstmt;

    // This method opens a connection to the Oracle database
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            //college persistence
            //<property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@//10.10.2.7:1521/global1"/>
            //<property name="javax.persistence.jdbc.user" value="x00119766"/>
            //<property name="javax.persistence.jdbc.driver" value="oracle.jdbc.OracleDriver"/>
            //<property name="javax.persistence.jdbc.password" value="db05Jun97"/>
            
            //home persistence
             /*<property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
      <property name="javax.persistence.jdbc.user" value="hr"/>
      <property name="javax.persistence.jdbc.driver" value="oracle.jdbc.OracleDriver"/>
      <property name="javax.persistence.jdbc.password" value="05Jun97"/>
              */
              
            // Tallaght
            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
            ods.setUser("x00119766");
            ods.setPassword("db05Jun97");
            // Home Oracle XE
            //ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
           //ods.setUser("hr");
           // ods.setPassword("05Jun97");

            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (Exception e) {
            System.out.print("Unable to load driver " + e);
            System.exit(1);
        }
        return conn;
    }

    public void dropSystemUserTable() {
        System.out.println("Checking for existence of systemUser table");
        try {
            String s1 = "DROP TABLE systemUser";
            pstmt = conn.prepareStatement(s1);
            try {
                // Drop the lodgement table.
                pstmt.execute();
                System.out.println("systemUser table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the systemUser table");
        }

    }

    public void dropLodgementTable() {
        System.out.println("Checking for existence of lodgement table");
        try {
            String s1 = "DROP TABLE lodgement";
            pstmt = conn.prepareStatement(s1);
            try {
                // Drop the lodgement table.
                pstmt.execute();
                System.out.println("lodgement table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the lodgement table");
        }

    }

    public void dropStudentAccountTable() {
        System.out.println("Checking for existence of Student_Account table");
        try {
            String s1 = "DROP TABLE Student_Account";
            pstmt = conn.prepareStatement(s1);
            try {
                // Drop the lodgement table.
                pstmt.execute();
                System.out.println("Student_Account table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the Student_Account table");
        }

    }

    public void dropAccCustTable() {
        System.out.println("Checking for existence of AccCust table");
        try {
            String s1 = "DROP TABLE AccCust";
            pstmt = conn.prepareStatement(s1);
            try {
                // Drop the lodgement table.
                pstmt.execute();
                System.out.println("AccCust table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the AccCust table");
        }

    }

    public void dropBankAccountTable() {
        System.out.println("Checking for existence of Bank_Account table.");
        try {
            String s1 = "DROP TABLE Bank_Account";
            pstmt = conn.prepareStatement(s1);
            try {
                pstmt.execute();
                System.out.println("Bank_Account table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the Bank_Account table");
        }
    }

    public void dropCustomerTable() {
        System.out.println("Checking for existence of customer2 table.");
        try {
            String s1 = "DROP TABLE customer2";
            pstmt = conn.prepareStatement(s1);
            try {
                pstmt.execute();
                System.out.println("customer2 table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the customer2 table");
        }
    }

    public void dropBranchTable() {
        System.out.println("Checking for existence of branch table.");
        try {
            String s1 = "DROP TABLE branch";
            pstmt = conn.prepareStatement(s1);
            try {
                pstmt.execute();
                System.out.println("branch table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the branch table");
        }
    }

    public void dropLodgementSequence() {
        try {
            String s2 = "drop sequence lodgement_id_seq";
            pstmt = conn.prepareStatement(s2);
            try {
                pstmt.execute();
                System.out.println("lodgement Sequence dropped");
            } catch (SQLException ex) {
                // No need to report an error.
                // The sequence does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the lodgement sequence");
        }
    }

    public void dropSystemUserSequence() {
        try {
            String s2 = "drop sequence user_id_seq";
            pstmt = conn.prepareStatement(s2);
            try {
                pstmt.execute();
                System.out.println("systemUser Sequence dropped");
            } catch (SQLException ex) {
                // No need to report an error.
                // The sequence does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the systemUser sequence");
        }
    }

    public void dropBankAccountSequence() {
        try {
            String s2 = "drop sequence AccNumber_seq";
            pstmt = conn.prepareStatement(s2);
            try {
                pstmt.execute();
                System.out.println("BankAccount Sequence dropped");
            } catch (SQLException ex) {
                // No need to report an error.
                // The sequence does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the BankAccount sequence");
        }
    }

    public void dropCustomerSequence() {
        try {
            String s2 = "drop sequence Cust_id_seq";
            pstmt = conn.prepareStatement(s2);
            try {
                pstmt.execute();
                System.out.println("Customer Sequence dropped");
            } catch (SQLException ex) {
                // No need to report an error.
                // The sequence does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the Customer sequence");
        }
    }

    public void dropBranchSequence() {
        try {
            String s2 = "drop sequence branch_id_seq";
            pstmt = conn.prepareStatement(s2);
            try {
                pstmt.execute();
                System.out.println("Branch Sequence dropped");
            } catch (SQLException ex) {
                // No need to report an error.
                // The sequence does not exist.
            }
        } catch (SQLException ex) {
            System.out.println("Problem dropping the Branch sequence");
        }
    }

    public void createSystemUserSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence user_id_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("SystemUser Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Create Sequence SystemUser " + ex.getMessage());
        }

    }

    public void createBranchSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence branch_id_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Branch Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Create Sequence Branch " + ex.getMessage());
        }

    }

    public void createCustomerSequence() {
        // Creating a sequence    
        try {
            String createseq2 = "create sequence Cust_id_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq2);
            pstmt.executeUpdate();
            System.out.println("Customer Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Create Sequence Customer " + ex.getMessage());
        }
    }

    public void createBankAccountSequence() {
        // Creating a sequence    
        try {
            String createseq3 = "create sequence AccNumber_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq3);
            pstmt.executeUpdate();
            System.out.println("BankAccount Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Create Sequence BankAccount " + ex.getMessage());
        }
    }

    public void createLodgementSequence() {
        // Creating a sequence    
        try {
            String createseq4 = "create sequence lodgement_id_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq4);
            pstmt.executeUpdate();
            System.out.println("Lodgement Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Create Sequence Lodgement " + ex.getMessage());
        }
    }

    public void createSystemUserTable() {
        try {

            // Create a Table
            String create = "Create Table systemUser "
                    + "(user_id	INTEGER,\n"
                    + "username	varchar2(255),\n"
                    + "password	varchar2(255),\n"
                    + "Primary Key(user_id))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO systemUser(user_id, username, password) "
                    + "values(user_id_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setString(1, "user");
            pstmt.setString(2, "pass");
            pstmt.execute();

            pstmt.setString(1, "name");
            pstmt.setString(2, "word");
            pstmt.execute();

            pstmt.setString(1, "a");
            pstmt.setString(2, "b");
            pstmt.execute();


            System.out.println("systemUser table created");
        } catch (SQLException e) {
            System.out.print("SQL Exception creating and inserting values into systemUser " + e.getMessage());
            System.exit(1);
        }
    }

    public void createBranchTable() {
        try {

            // Create a Table
            String create = "CREATE TABLE branch "
                    + "(branch_id INTEGER, branch_name varchar2(255), branchAddress varchar2(255), Primary Key(branch_id))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO branch(branch_id,branch_name,branchAddress) "
                    + "values(branch_id_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setString(1, "Finglas");
            pstmt.setString(2, "Dublin");
            pstmt.execute();

            pstmt.setString(1, "Terenure");
            pstmt.setString(2, "Dublin");
            pstmt.execute();

            pstmt.setString(1, "Templeogue");
            pstmt.setString(2, "Dublin");
            pstmt.execute();

            pstmt.setString(1, "Clonee");
            pstmt.setString(2, "Meath");
            pstmt.execute();

            System.out.println("Branch table created");
        } catch (SQLException e) {
            System.out.print("SQL Exception creating and inserting values into Branch " + e.getMessage());
            System.exit(1);
        }
    }

    public void createStudentAccountTable() {
        try {

            // Create a Table
            String create = "CREATE TABLE Student_Account "
                    + "(AccNumber INTEGER,\n"
                    + "college_name VARCHAR2(20),\n"
                    + "Primary Key(AccNumber),\n"
                    + "Foreign Key(AccNumber) references Bank_Account(AccNumber))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO Student_Account(AccNumber,college_name) "
                    + "values(?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setInt(1, 1);
            pstmt.setString(2, "ITT");
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "IADT");
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setString(2, "DIT");
            pstmt.execute();

            pstmt.setInt(1, 8);
            pstmt.setString(2, "ITB");
            pstmt.execute();

            System.out.println("StudentAccount table created");
        } catch (SQLException e) {
            System.out.print("SQL Exception creating and inserting values into StudentAccount " + e.getMessage());
            System.exit(1);
        }
    }

    public void createBankAccounttable() {
        // Create a Table           
        try {
            String create = "CREATE TABLE Bank_Account "
                    + "(AccNumber INTEGER,\n"
                    + "type VARCHAR2(20),\n"
                    + "AccName varchar2(255),\n"
                    + "branch_id	INTEGER,\n"
                    + "Primary Key(AccNumber),\n"
                    + "Foreign Key(Branch_id) references branch(branch_id))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO Bank_Account(AccNumber, type, AccName, branch_id) "
                    + "values(AccNumber_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setString(1, "Student");
            pstmt.setString(2, "Smith");
            pstmt.setInt(3, 1);
            pstmt.execute();

            pstmt.setString(1, "Current");
            pstmt.setString(2, "Jones");
            pstmt.setInt(3, 1);
            pstmt.execute();

            pstmt.setString(1, "Current");
            pstmt.setString(2, "Murphy");
            pstmt.setInt(3, 1);
            pstmt.execute();

            pstmt.setString(1, "Student");
            pstmt.setString(2, "Dunne");
            pstmt.setInt(3, 2);
            pstmt.execute();

            pstmt.setString(1, "Student");
            pstmt.setString(2, "Smith");
            pstmt.setInt(3, 2);
            pstmt.execute();

            pstmt.setString(1, "Current");
            pstmt.setString(2, "Farrell");
            pstmt.setInt(3, 3);
            pstmt.execute();

            pstmt.setString(1, "Current");
            pstmt.setString(2, "Byrne");
            pstmt.setInt(3, 3);
            pstmt.execute();

            pstmt.setString(1, "Student");
            pstmt.setString(2, "James");
            pstmt.setInt(3, 4);
            pstmt.execute();

            System.out.println("BankAccount table created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating and inserting values into BankAccount" + ex.getMessage());
        }
    }

    public void createCustomertable() {
        // Create a Table           
        try {
            String create = "CREATE TABLE Customer2 "
                    + "(Cust_id		INTEGER,\n"
                    + "Fname		varchar2(255),\n"
                    + "Lname		varchar2(255),\n"
                    + "House_Num	varchar2(255),\n"
                    + "Street		varchar2(255),\n"
                    + "city		varchar2(255),\n"
                    + "County		varchar2(255),\n"
                    + "Country		varchar2(255),\n"
                    + "DOB		date,\n"
                    + "Primary Key (Cust_id))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO Customer2(Cust_id, Fname, Lname, House_Num, Street, city, County, Country, DOB)"
                    + "values(Cust_id_seq.nextVal,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setString(1, "Joe");
            pstmt.setString(2, "Smith");
            pstmt.setString(3, "45");
            pstmt.setString(4, "Main Street");
            pstmt.setString(5, "Tallaght");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "23-Jun-1990");
            pstmt.execute();

            pstmt.setString(1, "Bob");
            pstmt.setString(2, "Jones");
            pstmt.setString(3, "33");
            pstmt.setString(4, "Blue Street");
            pstmt.setString(5, "Drimnagh");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "03-Mar-1984");
            pstmt.execute();

            pstmt.setString(1, "Ryan");
            pstmt.setString(2, "Bloggs");
            pstmt.setString(3, "104");
            pstmt.setString(4, "Green Street");
            pstmt.setString(5, "Crumlin");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "13-Jun-1980");
            pstmt.execute();

            pstmt.setString(1, "Joe");
            pstmt.setString(2, "Bloggs");
            pstmt.setString(3, "45");
            pstmt.setString(4, "Main Street");
            pstmt.setString(5, "Tallaght");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "23-Mar-1980");
            pstmt.execute();

            pstmt.setString(1, "Karl");
            pstmt.setString(2, "Carey");
            pstmt.setString(3, "455");
            pstmt.setString(4, "Purple Street");
            pstmt.setString(5, "Kingswoord");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "18-Jan-1980");
            pstmt.execute();

            pstmt.setString(1, "Bobby");
            pstmt.setString(2, "Keane");
            pstmt.setString(3, "45");
            pstmt.setString(4, "Main Street");
            pstmt.setString(5, "Tallaght");
            pstmt.setString(6, "Dublin");
            pstmt.setString(7, "Ireland");
            pstmt.setString(8, "24-Mar-1980");
            pstmt.execute();

            System.out.println("Customer2 table created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating and inserting values into Customer2" + ex.getMessage());
        }
    }

    public void createAccCusttable() {
        // Create a Table           
        try {
            String create = "CREATE TABLE AccCust "
                    + "(AccNumber INTEGER,\n"
                    + "Cust_id		INTEGER,\n"
                    + "Primary Key(AccNumber,Cust_id),\n"
                    + "Foreign Key(Cust_id) references customer2(Cust_id),\n"
                    + "Foreign Key(AccNumber) references bank_account(AccNumber) ON DELETE CASCADE)";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO AccCust(AccNumber, Cust_id) "
                    + "values(?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
            pstmt.execute();

            pstmt.setInt(1, 2);
            pstmt.setInt(2, 2);
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setInt(2, 2);
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setInt(2, 3);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2, 4);
            pstmt.execute();

            pstmt.setInt(1, 6);
            pstmt.setInt(2, 4);
            pstmt.execute();

            pstmt.setInt(1, 7);
            pstmt.setInt(2, 5);
            pstmt.execute();

            pstmt.setInt(1, 8);
            pstmt.setInt(2, 6);
            pstmt.execute();

            System.out.println("AccCust table created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating and inserting values into AccCust" + ex.getMessage());
        }
    }

    public void createLodgementTable() {
        try {

            // Create a Table
            String create = "CREATE TABLE lodgement "
                    + "(lodgement_id	INTEGER,\n"
                    + "lodgement_title	varchar2(255),\n"
                    + "lodgement_amt	number,\n"
                    + "Branch_id	INTEGER,\n"
                    + "Cust_id		INTEGER,\n"
                    + "Primary Key(lodgement_id),\n"
                    + "foreign key (branch_id) references branch(branch_id), \n"
                    + "foreign key (cust_id) references customer2(cust_id) )";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate();

            // Insert data into table
            String insertString1 = "INSERT INTO lodgement(lodgement_id, lodgement_title, lodgement_amt, Branch_id, Cust_id) "
                    + "values(lodgement_id_seq.nextVal,?,?,?,?)";
            pstmt = conn.prepareStatement(insertString1);

            pstmt.setString(1, "Babysitting");
            pstmt.setInt(2, 123);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.execute();

            pstmt.setString(1, "Holiday fund");
            pstmt.setInt(2, 303);
            pstmt.setInt(3, 2);
            pstmt.setInt(4, 1);
            pstmt.execute();

            System.out.println("lodgement table created");
        } catch (SQLException e) {
            System.out.print("SQL Exception creating and inserting values into lodgement " + e.getMessage());
            System.exit(1);
        }
    }

    public void closeDB() {
        try {
            pstmt.close();
            rset.close();
            conn.close();
            System.out.print("Connection closed");
        } catch (SQLException e) {
            System.out.print("Could not close connection ");
        }
    }

    public static void main(String[] args) {
        BankOperations co = new BankOperations();
        co.openDB();

        //Drop sequences
        co.dropSystemUserSequence();
        co.dropBranchSequence();
        co.dropBankAccountSequence();
        co.dropCustomerSequence();
        co.dropLodgementSequence();

        //Drop tables
        co.dropSystemUserTable();
        co.dropLodgementTable();
        co.dropStudentAccountTable();
        co.dropAccCustTable();
        co.dropBankAccountTable();
        co.dropCustomerTable();
        co.dropBranchTable();

        //create sequences
        co.createSystemUserSequence();
        co.createBranchSequence();
        co.createBankAccountSequence();
        co.createCustomerSequence();
        co.createLodgementSequence();

        //create tables
        co.createSystemUserTable();
        co.createBranchTable();
        co.createBankAccounttable();
        co.createStudentAccountTable();
        co.createCustomertable();
        co.createAccCusttable();
        co.createLodgementTable();

    }
}
