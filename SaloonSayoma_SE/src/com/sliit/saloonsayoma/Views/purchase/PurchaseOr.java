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
 * @author Visitor
 */
public class PurchaseOr {
    
    
    private String purchaseordersID;
    private String supplierID;
    private String OrderDate;
    private String comapnyName;
    private String idproducts;
    private String pname;
    private String QtyOrder;
    private String UnitPrice;
    private String Description;
    
    private String total;
    private String discount;
    private String grandtot;

    public PurchaseOr(String supplierID, String OrderDate, String comapnyName, String idproducts, String pname, String QtyOrder, String UnitPrice, String Description) {
        this.supplierID = supplierID;
        this.OrderDate = OrderDate;
        this.comapnyName = comapnyName;
        this.idproducts = idproducts;
        this.pname = pname;
        this.QtyOrder = QtyOrder;
        this.UnitPrice = UnitPrice;
        this.Description = Description;
    }
    
    
    Connection con =null;
    PreparedStatement pst=null;
    ResultSet rs=null;

    public PurchaseOr(String purchaseordersID, String supplierID, String OrderDate, String comapnyName, String idproducts, String pname, String QtyOrder, String UnitPrice, String Description) {
        this.purchaseordersID = purchaseordersID;
        this.supplierID = supplierID;
        this.OrderDate = OrderDate;
        this.comapnyName = comapnyName;
        this.idproducts = idproducts;
        this.pname = pname;
        this.QtyOrder = QtyOrder;
        this.UnitPrice = UnitPrice;
        this.Description = Description;
    }

    public PurchaseOr(String purchaseordersID) {
        this.purchaseordersID = purchaseordersID;
    }

    public PurchaseOr(String supplierID, String comapnyName) {
        this.supplierID = supplierID;
        this.comapnyName = comapnyName;
    }

    public PurchaseOr(String total, String discount, String grandtot) {
        this.total = total;
        this.discount = discount;
        this.grandtot = grandtot;
    }
    
    
    
   public void AddPurchaseOrders(){    
        
        
        con=DB.getConnection();
        try {
        
      
            DB.executeUpdate("INSERT INTO purchaseorders(supplierID,OrderDate,comapnyName,QtyOrder,UnitPrice,Description,idproducts,pname)Values('"+this.supplierID+"','"+this.OrderDate+"','"+this.comapnyName+"','"+this.QtyOrder+"','"+this.UnitPrice+"','"+this.Description+"','"+this.idproducts+"','"+this.pname+"')");
            
                 String pt="SUCCESSFULLY ADDED";
                JOptionPane.showMessageDialog(null,pt);
        }
      catch(HeadlessException e ){
               
                JOptionPane.showMessageDialog(null,"Not Added");
            }
         }
    public void UpdatepurchaseOrders(){
            con=DB.getConnection();

        try {
            DB.executeUpdate("UPDATE purchaseorders SET OrderDate='"+this.OrderDate+"',comapnyName='"+this.comapnyName+"',QtyOrder='"+this.QtyOrder+"',UnitPrice='"+this.UnitPrice+"',Description='"+this.Description+"',idproducts='"+this.idproducts+"',pname='"+this.pname+"' where purchaseordersID='"+this.purchaseordersID+"'");
            String pt="SUCCESSFULLY UPDATED";
                JOptionPane.showMessageDialog(null,pt);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Not Updated");
        }
    }
    
    public void DeletepurchaseOreders(){
             con=DB.getConnection();
             
             try {
                  DB.executeUpdate("DELETE from purchaseorders where purchaseordersID='"+this.purchaseordersID+"'");
            String pt="SUCCESSFULLY DELETED";
                JOptionPane.showMessageDialog(null,pt);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"CANNOT BE DELETED!!");
        }
             
    }
    
    public void SearchPurchaseOrders(){
    con=DB.getConnection();
    
        try {
            DB.executeUpdate("SELECTE * from purchaseorders where purchaseordersID LIKE %'"+this.purchaseordersID+"'");
            String pt="SUCCESSFULLY FOUNDED";
            JOptionPane.showMessageDialog(null,pt);
        } catch (Exception e) {
        }
        
    }
    
    
    public void submitetot(){
    con=DB.getConnection();
    
        try {
            DB.executeUpdate("INSERT INTO totalpurchase(TotalPrice,Discount,GrandTotal)Values('"+this.total+"','"+this.discount+"','"+this.grandtot+"')");
            String tot="SUCCESSFULLY ADDED";
        } catch (Exception e) {
        }
    }
    
    
    public void updatetot(){
    con=DB.getConnection();
    
     try {
            DB.executeUpdate("UPDATE totalpurchase SET TotalPrice='"+this.total+"',Discount='"+this.discount+"',GrandTotal='"+this.grandtot+"'");
            String pt="SUCCESSFULLY UPDATED";
                JOptionPane.showMessageDialog(null,pt);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Not Updated");
        }
    }
    
    public void deleted(){
     try {
                  DB.executeUpdate("DELETE from totalpurchase where TotalPrice='"+this.total+"'");
            String pt="SUCCESSFULLY DELETED";
                JOptionPane.showMessageDialog(null,pt);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"CANNOT BE DELETED!!");
        }
    
    }
}


