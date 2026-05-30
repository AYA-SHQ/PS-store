/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_store;

import java.sql.*; 
import javax.swing.*; 

public class Connect { 
    public static Connection connect() { 
        try { 
            Connection con = 
DriverManager.getConnection("jdbc:derby://localhost:1527/PSstore", "aya", "ayashq");  
            //  JOptionPane.showMessageDialog(null, "connected"); 
            return con; 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "can't connect to database" + e); 
        } 
        return null; 
    } 
    public static void main(String[] args) { 
        Connect.connect();    } 
}
 
