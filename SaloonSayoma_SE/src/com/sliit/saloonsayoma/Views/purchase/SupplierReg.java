/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sliit.saloonsayoma.Views.purchase;

import com.sliit.saloonsayoma.utils.DB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ravishanka
 */
public class SupplierReg {
    
    private String supplierid;
    private String comapnyName;
    private String companyReg;
    private String conatctname;
    private String address;
    private String country;
    private String telephone;
    private String phone;
    private String email;
    private String bankname;
    private String branch;
    private String account;
    
    Connection con =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    

    public SupplierReg() {
    }

    public SupplierReg(String supplierid, String comapnyName, String companyReg, String conatctname, String address, String country, String telephone, String phone, String email, String bankname, String branch, String account) {
        this.supplierid = supplierid;
        this.comapnyName = comapnyName;
        this.companyReg = companyReg;
        this.conatctname = conatctname;
        this.address = address;
        this.country = country;
        this.telephone = telephone;
        this.phone = phone;
        this.email = email;
        this.bankname = bankname;
        this.branch = branch;
        this.account = account;
    }

    /*SupplierReg(String supplierID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public SupplierReg(String supplierid){
        
        
        this.supplierid=supplierid;
    
    }

    public void AddSupplier() {
        con=DB.getConnection();
        
        try {
            
            DB.executeUpdate("INSERT INTO supplier(comapnyName, companyReg, ContactName, Address, country, Telephone, phone, Email, Bank, Branch, Account)Values('"+this.comapnyName+"','"+this.companyReg+"','"+this.conatctname+"','"+this.address+"','"+this.country+"','"+this.telephone+"','"+this.phone+"','"+this.email+"','"+this.bankname+"','"+this.branch+"','"+this.account+"')");
            String st="SUCCESSFULLY ADDED";
            JOptionPane.showMessageDialog(null,st);
            
        }
        
        
        catch(HeadlessException e ){
            
            JOptionPane.showMessageDialog(null,"Not Added", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
  public void UpdateSupplier(){
    con=DB.getConnection();
    
        try {
            DB.executeUpdate("Update supplier SET comapnyName='"+this.comapnyName+"', companyReg='"+this.companyReg+"', ContactName='"+this.conatctname+"', Address='"+this.address+"', country='"+this.country+"', Telephone='"+this.telephone+"',phone='"+this.phone+"', Email='"+this.email+"', Bank='"+this.bankname+"',Branch='"+this.branch+"',Account='"+this.account+"' where supplierid='"+this.supplierid+"'");
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY UPDATED");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"ERROR PLEASE CHEACK");
        }
    }

    
    
    
    //Delete Product
    public void DeleteSupplier(){
    con=DB.getConnection();
    
        try {
            DB.executeUpdate("DELETE from supplier where supplierID='"+this.supplierid+"'");
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"CANNOT BE DELETED!!");
        }
    
    }
}


