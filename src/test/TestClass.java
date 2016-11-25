/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dbServices.BankOperations;
import dbServices.JPAService;
import java.util.Calendar;
import java.util.Scanner;

public class TestClass {

    static JPAService jpas = new JPAService();

    public static void main(String[] args) {
        BankOperations bo = new BankOperations();
        bo.openDB();

        //Drop sequences
        bo.dropSystemUserSequence();
        bo.dropBranchSequence();
        bo.dropBankAccountSequence();
        bo.dropCustomerSequence();
        bo.dropLodgementSequence();

        //Drop tables
        bo.dropSystemUserTable();
        bo.dropLodgementTable();
        bo.dropStudentAccountTable();
        bo.dropAccCustTable();
        bo.dropBankAccountTable();
        bo.dropCustomerTable();
        bo.dropBranchTable();

        //create sequences
        bo.createSystemUserSequence();
        bo.createBranchSequence();
        bo.createBankAccountSequence();
        bo.createCustomerSequence();
        bo.createLodgementSequence();

        //create tables
        bo.createSystemUserTable();
        bo.createBranchTable();
        bo.createBankAccounttable();
        bo.createStudentAccountTable();
        bo.createCustomertable();
        bo.createAccCusttable();
        bo.createLodgementTable();

        displayMenu1();
    }

    public static void displayMenu1() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("**************************************************");
            System.out.println("Please press 1 to Start");
            System.out.println("Please press 2 to quit");
            System.out.println("**************************************************");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("**************************************************");
                    System.out.println("Welcome to JS Bank");
                    System.out.println("Please enter your Username: ");
                    String username = in.nextLine();
                    System.out.println("Please enter your Password: ");
                    String password = in.nextLine();
                    if (!jpas.findSystemUser(username, password)) {
                        System.out.println("System User not found");
                    } else {
                        displayMenu2(username, password);
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void displayMenu2(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to view tables");
            System.out.println("Please press 2 to update tables");
            System.out.println("Please press 3 to delete from tables");
            System.out.println("Please press 4 to add to tables");
            System.out.println("Please press 5 to go back to main menu");
            System.out.println("Press 6 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

                    viewTablesMenu(username, password);

                    break;
                case 2:

                    updateTablesMenu(username, password);
                    break;

                case 3:

                    deleteTablesMenu(username, password);
                    break;

                case 4:

                    addToTableMenu(username, password);
                    break;

                case 5:
                    displayMenu1();
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void viewTablesMenu(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to view Customer table");
            System.out.println("Please press 2 to view Branch table");
            System.out.println("Please press 3 to view Lodgement table");
            System.out.println("Please press 4 to view BankAccount table");
            System.out.println("Please press 5 to view StudentAccount table");
            System.out.println("Please press 6 to go back to previous menu");
            System.out.println("Press 7 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

                    jpas.readCustomer();

                    break;
                case 2:
                    jpas.readBranch();

                    break;

                case 3:
                    jpas.readLodgement();

                    break;

                case 4:
                    jpas.readBankAccount();

                    break;

                case 5:
                    jpas.readStudentAccount();

                    break;

                case 6:
                    displayMenu2(username, password);
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void updateTablesMenu(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to update Customer Address");
            System.out.println("Please press 2 to update Customer Surname");
            System.out.println("Please press 3 to update BankAccount name");
            System.out.println("Please press 4 to update StudentAccount college name");
            System.out.println("Please press 5 to go back to previous menu");
            System.out.println("Press 6 to quit");

            int choice = in.nextInt();
            in.nextLine();
            int id;

            switch (choice) {

                case 1:

                    System.out.println("Please enter the Customer's Id that you wish to update: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter Customer's new House Number: ");
                    String House_Num = in.nextLine();
                    System.out.println("Please enter Customer's new Street Address: ");
                    String Street = in.nextLine();
                    System.out.println("Please enter Customer's new City: ");
                    String city = in.nextLine();
                    System.out.println("Please enter Customer's new County: ");
                    String County = in.nextLine();
                    System.out.println("Please enter Customer's new Country: ");
                    String Country = in.nextLine();

                    jpas.updateCustomerAddress(id, House_Num, Street, city, County, Country);

                    break;
                case 2:
                    System.out.println("Please enter the Customer's Id that you wish to update: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter Customer's new Surname: ");
                    String surname = in.nextLine();

                    jpas.updateCustomerSurname(id, surname);

                    break;

                case 3:
                    System.out.println("Please enter the BankAccount Number that you wish to update: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter new Bank account name: ");
                    String nameAdd = in.nextLine();

                    jpas.updateCustomerSurname(id, nameAdd);

                    break;

                case 4:
                    System.out.println("Please enter the Student BankAccount Number that you wish to update: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the students new college: ");
                    String collegeAdd = in.nextLine();

                    jpas.updateCustomerSurname(id, collegeAdd);

                    break;

                case 5:
                    displayMenu2(username, password);
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void addToTableMenu(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to add Customer");
            System.out.println("Please press 2 to add Branch");
            System.out.println("Please press 3 to add Lodgement");
            System.out.println("Please press 4 to add BankAccount");
            System.out.println("Please press 5 to add Student Account");
            System.out.println("Please press 6 to go back to main menu");
            System.out.println("Press 6 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Please enter Customer's First Name: ");
                    String Fname = in.nextLine();
                    System.out.println("Please enter Customer's Last Name: ");
                    String Lname = in.nextLine();
                    System.out.println("Please enter Customer's House Number: ");
                    String House_Num = in.nextLine();
                    System.out.println("Please enter Customer's Street Address: ");
                    String Street = in.nextLine();
                    System.out.println("Please enter Customer's City: ");
                    String city = in.nextLine();
                    System.out.println("Please enter Customer's County: ");
                    String County = in.nextLine();
                    System.out.println("Please enter Customer's Country: ");
                    String Country = in.nextLine();
                    System.out.println("Please enter Customer's Birth Date: ");
                    int day = in.nextInt();
                    System.out.println("Please enter Customer's Birth Month: ");
                    int month = in.nextInt();
                    System.out.println("Please enter Customer's Birth Year: ");
                    int year = in.nextInt();
                    Calendar dob1 = Calendar.getInstance();
                    dob1.set(year, month, day);

                    Calendar DOB = dob1;
                    
                     jpas.createCustomer(Fname, Lname, House_Num, Street, city, County, Country, dob1);
                    
                    /*

                    System.out.println("**** Please choose the Account type you wish to create ****");
                    System.out.println("Please press 1 to make a Current Account");
                    System.out.println("Please press 2 to make a Student Account");
                    System.out.println("Please press 3 to exit");
                    System.out.println("**************************************************");

                    int acc = in.nextInt();
                    in.nextLine();

                    if (acc == 1) {
                        System.out.println("Please enter new Account Name: ");
                        String accNameAdd = in.nextLine();

                        System.out.println("Please enter Branch Name: ");
                        String branchNameBank = in.nextLine();
                        jpas.createCustomerCurrentAccount(Fname, Lname, House_Num, Street, city, County, Country, dob1, accNameAdd, branchNameBank);
                    } else if (acc == 2) {

                        System.out.println("Please enter new Student Account Name: ");
                        String studentAccName = in.nextLine();

                        System.out.println("Please enter the college being attended: ");
                        String collegeName = in.nextLine();

                        System.out.println("Please enter Branch Name: ");
                        String branchNameStudent = in.nextLine();
                        jpas.createCustomerStudentAccount(Fname, Lname, House_Num, Street, city, County, Country, dob1, studentAccName, collegeName, branchNameStudent);
                    } else {

                        jpas.createCustomer(Fname, Lname, House_Num, Street, city, County, Country, dob1);
                    }*/
                    
                    
                    break;
                case 2:
                    System.out.println("Please enter Branch Name: ");
                    String nameAdd = in.nextLine();
                    System.out.println("Please enter Branch Address: ");
                    String addressAdd = in.nextLine();

                    jpas.createBranch(nameAdd, addressAdd);
                    break;

                case 3:
                    System.out.println("Please enter Lodgement Title: ");
                    String titleAdd = in.nextLine();
                    System.out.println("Please enter Lodgement Amount: ");
                    double amtAdd = in.nextDouble();
                    in.nextLine();
                    System.out.println("Please enter Customer's First Name: ");
                    String fname = in.nextLine();
                    System.out.println("Please enter Customer's Last Name: ");
                    String lname = in.nextLine();
                    System.out.println("Please enter Branch Name: ");
                    String branchName = in.nextLine();

                    jpas.createLodgement(titleAdd, amtAdd, fname, lname, branchName);
                    break;

                case 4:
                    System.out.println("Please enter new Account Name: ");
                    String accNameAdd = in.nextLine();

                    System.out.println("Please enter Branch Name: ");
                    String branchNameBank = in.nextLine();

                    System.out.println("Please enter Customer's First Name: ");
                    String fname2 = in.nextLine();
                    
                    System.out.println("Please enter Customer's Last Name: ");
                    String lname2 = in.nextLine();

                    jpas.createBankAccount(accNameAdd, branchNameBank, fname2, lname2);
                    break;
                case 5:
                    System.out.println("Please enter new Student Account Name: ");
                    String studentAccName = in.nextLine();

                    System.out.println("Please enter the college being attended: ");
                    String collegeName = in.nextLine();

                    System.out.println("Please enter Branch Name: ");
                    String branchNameStudent = in.nextLine();
                    
                    System.out.println("Please enter Customer's First Name: ");
                    String fname3 = in.nextLine();
                    
                    System.out.println("Please enter Customer's Last Name: ");
                    String lname3 = in.nextLine();

                    jpas.createStudentAccount(studentAccName, collegeName, branchNameStudent,fname3, lname3);
                    break;
                case 6:
                    displayMenu2(username, password);
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void deleteTablesMenu(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to delete from Customer");
            System.out.println("Please press 2 to delete from Branch");
            System.out.println("Please press 3 to delete from BankAccount");
            System.out.println("Please press 4 to delete from StudentAccount");
            System.out.println("Please press 5 to go back to main menu");
            System.out.println("Press 6 to quit");

            int choice = in.nextInt();
            in.nextLine();
            int id;

            switch (choice) {
                case 1:
                    System.out.println("Please enter the Customer's Id that you wish to remove: ");
                    id = in.nextInt();

                    jpas.removeCustomer(id);
                    break;
                case 2:
                    System.out.println("Please enter the Branch Id that you wish to remove: ");
                    id = in.nextInt();

                    jpas.removeBranch(id);
                    break;

                case 3:
                    System.out.println("Please enter the BankAccount Number that you wish to remove: ");
                    id = in.nextInt();

                    jpas.removeBankAccount(id);
                    break;

                case 4:
                    System.out.println("Please enter the Student BankAccount Number that you wish to remove: ");
                    id = in.nextInt();

                    jpas.removeBankAccount(id);
                    break;
                case 5:
                    displayMenu2(username, password);
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

    public static void displayMenu3(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******** " + username + " ********");
            System.out.println("Please press 1 to view tables");
            System.out.println("Please press 2 to update tables");
            System.out.println("Please press 3 to delete from tables");
            System.out.println("Please press 4 to add to tables");
            System.out.println("Please press 5 to go back to main menu");
            System.out.println("Press 6 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

                    viewTablesMenu(username, password);
                    jpas.readCustomer();
                    break;
                case 2:
                /*System.out.println("please enter the id of the contact you wish to update");
                 int cid = in.nextInt();
                 in.nextLine();
                 if (!jpas.findContact(cid, owner)) {
                 System.out.println("Entity not found");
                 } else {
                 System.out.println("Please enter the new phone number for " + cid);
                 String newNum = in.nextLine();
                 //jpas.updateContact(cid, newNum);
                 }
                 break;
                 */
                case 3:
                /*
                 System.out.println("please enter the id of the contact you wish to delete");
                 int idDelete = in.nextInt();
                 in.nextLine();
                 if (!jpas.findContact(idDelete, owner)) {
                 System.out.println("Entity not found");
                 } else {
                 jpas.removeContact(idDelete);
                 System.out.println("Entity removed");
                 }
                 break;
                 */
                case 4:
                /*
                 System.out.println("please enter the name of the contact you wish to add");
                 String nameAdd = in.nextLine();
                 System.out.println("please enter the address of the contact you wish to add");
                 String addAdd = in.nextLine();
                 System.out.println("please enter the email of the contact you wish to add");
                 String emailAdd = in.nextLine();
                 System.out.println("please enter the number of the contact you wish to add");
                 String numAdd = in.nextLine();
                 jpas.createContact(nameAdd, addAdd, numAdd, emailAdd, owner);
                 break;
                 */
                case 5:
                    displayMenu1();
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }
    }

}
