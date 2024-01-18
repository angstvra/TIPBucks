package utils;

import javax.swing.JOptionPane;

public class tables {
    public static void main(String []args) {
        try{
            String userTable = "create table user (id int AUTO_INCREMENT primary key,name varchar(255), email varchar(255), mobileNumber varchar(10), address varchar(255), password varchar(255), securityQuestion varchar(255), answer varchar(255),status varchar(20), UNIQUE (email))";
            String adminDetails = "insert into user (name, email, mobileNumber, address, password, securityQuestion, answer, status) values ('Admin', 'admin@domain.com', '0987654321', 'QC', 'admin', 'Potato?', 'yea', 'true')";
            String categoryTable = "create table category (id int AUTO_INCREMENT primary key,name varchar(255))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(255),category varchar(255),price varchar(255))";
            String billTable = "create table bill (id int primary key, name varchar(255), mobileNumber varchar(10), email varchar(255), date varchar(50), total varchar(200), createdBy varchar(200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
            DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
            DbOperations.setDataOrDelete(billTable, "Bill Table Added Successfully");

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
