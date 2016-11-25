drop table lodgement;
drop table Student_Account;
drop table AccCust;
drop table Bank_Account;
drop table customer2;
drop table branch;
drop table systemUser;

Create Table systemUser
(
user_id	INTEGER,
username	varchar2(255),
password	varchar2(255),
Primary Key(user_id)
);

Create Table branch
(
branch_id	INTEGER,
branch_name	varchar2(255),
branchAddress	varchar2(255),
Primary Key(branch_id)
);


Create Table Bank_Account
(
AccNumber INTEGER,
type VARCHAR2(20),
AccName varchar2(255),
branch_id	INTEGER,
Primary Key(AccNumber),
Foreign Key(Branch_id) references branch(branch_id)
);

Create Table Student_Account
(
AccNumber INTEGER,
college_name VARCHAR2(20),
Primary Key(AccNumber),
Foreign Key(AccNumber) references Bank_Account(AccNumber)
);

Create Table Customer2(
Cust_id		INTEGER,
Fname		varchar2(255),
Lname		varchar2(255),
House_Num	varchar2(255),
Street		varchar2(255),
city		varchar2(255),
County		varchar2(255),
Country		varchar2(255),
DOB		varchar2(255),
Primary Key (Cust_id)
);


Create Table AccCust(
AccNumber INTEGER,
Cust_id		INTEGER,
Primary Key(AccNumber,Cust_id),
Foreign Key(Cust_id) references customer2(Cust_id),
Foreign Key(AccNumber) references bank_account(AccNumber)
);


Create Table lodgement(
lodgement_id	INTEGER,
lodgement_title	varchar2(255),
lodgement_amt	number,
Branch_id	INTEGER,
Cust_id		INTEGER,
Primary Key(lodgement_id),
foreign key (branch_id) references branch(branch_id), 
foreign key (cust_id) references customer2(cust_id) 
);


insert into branch values(1234, 'Finglas','Dublin');
insert into branch values(1235, 'Terenure','Dublin');
insert into branch values(1236, 'Templeogue','Dublin');
insert into branch values(1237, 'Dalky','Dublin');
insert into branch values(1238, 'Lucan','Dublin');
insert into branch values(1239, 'Clonee','Meath');



insert into Bank_account values(34,'Student', 'Smith','1234');
insert into Bank_account values(35,'Current', 'Jones','1234');
insert into Bank_account values(36, 'Current','Murphy','1235');
insert into Bank_account values(37, 'Current','Dunne','1236');
insert into Bank_account values(38, 'Current','Farrell','1236');
insert into Bank_account values(39, 'Current','Byrne','1237');
insert into Bank_account values(40, 'Current','James','1237');
insert into Bank_account values(41,'Current', 'Reilly','1237');
insert into Bank_account values(42, 'Current','Greene','1238');
insert into Bank_account values(43, 'Current','Black','1238');
insert into Bank_account values(44, 'Current','Brown','1239');
insert into Bank_account values(45, 'Current','Byrne','1239');


insert into Customer2 values(11,'Joe','Bloggs','45', 'Main Street','Tallaght','Dublin','Ireland','23-Mar-1980');
insert into Customer2 values(12,'James','Ryan','56', 'Long road','Terenure','Dublin','Ireland','21-Jan-1965');
insert into Customer2 values(13,'John','Byrne','32', 'short Street','Tempelogue','Dublin','Ireland','3-Feb-1986');
insert into Customer2 values(14,'Paul','Farrell','98', 'Cedar Way','Killiney','Dublin','Ireland','30-Jun-1972');
insert into Customer2 values(15,'Jane','Dunne','75', 'Redwood Road','Finglas','Dublin','Ireland','29-Mar-1949');
insert into Customer2 values(16,'Josh','Kelly','112', 'Long Lane','Tallaght','Dublin','Ireland','7-Apr-1987');
insert into Customer2 values(17,'Aoife','Byrne','83', 'Boden Wood','Ballyboden','Dublin','Ireland','10-May-1969');
insert into Customer2 values(18,'Caroline','Ryan','122', 'Ash Brook','Glasneven','Dublin','Ireland','9-Jul-1976');
insert into Customer2 values(19,'Amy','Fenlon','91', 'Chestnut Drive','Finglas','Dublin','Ireland','15-Aug-1980');
insert into Customer2 values(20,'Hannah','Bloomer','39', 'Riversbed Road','Dalky','Dublin','Ireland','25-Sep-1990');


insert into Lodgement values (1, 'Babysitting', 123, 1234, 11);
insert into Lodgement values (2, 'Holiday fund', 50, 1235, 11);
insert into Lodgement values (3, 'Christmas', 90, 1236, 12);
insert into Lodgement values (4, 'Birthday', 100, 1237, 13);
insert into Lodgement values (5, 'Overtime', 75, 1238, 14);
insert into Lodgement values (6, 'Savings', 150,1239, 15);

insert into AccCust values(38,11);
insert into AccCust values(39,12);
insert into AccCust values(40,13);
insert into AccCust values(41,14);
insert into AccCust values(42,15);
insert into AccCust values(43,16);
insert into AccCust values(44,17);
insert into AccCust values(45,18);
insert into AccCust values(36,18);
insert into AccCust values(37,19);
insert into AccCust values(38,20);
insert into AccCust values(39,11);



