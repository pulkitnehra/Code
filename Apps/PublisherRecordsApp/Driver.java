/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherRecordsApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nehra
 */
public class Driver extends Conn implements ActionListener{

//    all elements must be static for results to display correctly
    
    static JFrame f,j2;
     static JTextField t1, t2, t3, t4, t5, t6, t7;
    static JLabel pubid, pubname, phno, add, city, state, zip; 
    static JButton insert, exit, fetch,clear, restart;
    static JTable table;
     String[] columnNames = {"pub_id", "pub_name", "Address", "City", "State","Zip"};

     static Connection cn;
     static Statement st1,st2;
     static  ResultSet rs1;
    
    
    public Driver()
    {
        
//        Initializing the elements
        f = new JFrame("PUBLISHERS");
        pubid = new JLabel("Publishers ID:");
        t1 = new JTextField();
        pubname = new JLabel("Publishers Name:");
        t2 = new JTextField();
        phno = new JLabel("Phone Number:");
        t3 = new JTextField();
        add = new JLabel("Address:");
        t4 = new JTextField();
        city = new JLabel("City:");
        t5 = new JTextField();
        state = new JLabel("State:");
        t6 = new JTextField();
        zip = new JLabel("Zip:");
        t7 = new JTextField(); 
        insert = new JButton("Insert");
        exit = new JButton("Exit");
        fetch = new JButton("Fetch Records");
        clear = new JButton("Clear");
        restart = new JButton("Restart");
        
        
//        setting positions and adding background
        pubid.setBounds(60, 20, 250, 200);
        t1.setBounds(300,110,100,30);
        pubname.setBounds(60, 85, 250, 200);
        t2.setBounds(300,170,180,30);
        phno.setBounds(60, 150, 250, 200);
        t3.setBounds(300,230,150,30);
        add.setBounds(60, 215, 250, 200);
        t4.setBounds(300,300,180,30);
        city.setBounds(60, 280, 250, 200);
        t5.setBounds(300,370,150,30);
        state.setBounds(60, 350, 250, 200);
        t6.setBounds(300,440,150,30);
        zip.setBounds(60, 420, 250, 200);
        t7.setBounds(300,510,150,30);
        insert.setBounds(20, 590, 120, 50 );
        insert.setBackground(Color.BLACK);
        insert.setForeground(Color.WHITE);
        fetch.setBounds(170,590,120,50);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        clear.setBounds(320, 590, 120, 50 );
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        exit.setBounds(460, 590, 120, 50 );
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        restart.setBounds(600, 590, 120, 50);
        restart.setBackground(Color.BLACK);
        restart.setForeground(Color.WHITE);
        
//        Adding all the elemnts onto the frame
        f.setBackground(Color.WHITE);
        f.add(pubid);
        f.add(t1);
        f.add(pubname);
        f.add(t2);
        f.add(phno);
        f.add(t3);
        f.add(add);
        f.add(t4);
        f.add(city);
        f.add(t5);
        f.add(state);
        f.add(t6);
        f.add(zip);
        f.add(t7);
        f.add(insert);
        f.add(fetch);
        f.add(clear);
        f.add(exit);
        f.add(restart);
        f.setBackground(Color.BLACK);
        
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(800, 800);
        
        
//        Adding the onclick functionality
        insert.addActionListener(this);
        exit.addActionListener(this);
        fetch.addActionListener(this);
        clear.addActionListener(this);
        restart.addActionListener(this);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        
        else if(e.getSource()==insert)
        {
           
            String s1 = t1.getText();
            String s2 = t2.getText();
            String s3 = t3.getText();
            String s4 = t4.getText();
            String s5 = t5.getText();
            String s6 = t6.getText();
            String s7 = t7.getText();


    if(s1 == null || s2 == null || s3 == null || s4 == null || s5 == null || s6 == null || s7 == null)
    {

            JOptionPane.showMessageDialog(null,"Either one or all the values are left blank");
            insert.setEnabled(false);
            fetch.setEnabled(false);

    }	

    else{   
    try{
//        should always establish and use db query like this
            Conn c1 = new Conn();
            String rx =  "insert into pub values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"')";
            c1.s.executeUpdate(rx);
            
            JOptionPane.showMessageDialog(null,"Records Updated Successfully");
            t1.setText(s1);
            t2.setText(s2);
            t3.setText(s3);
            t4.setText(s4);
            t5.setText(s5);
            t6.setText(s6);
            t7.setText(s7);
            
            

    }catch(Exception ex)
    {
            JOptionPane.showMessageDialog(null, "Same entry exists"+ex.getMessage());
            
    }
    }
    
    
}     
        
        else if(e.getSource()==fetch)
        {
            try {
                //            Fetch the values from database and diplay it ona table in a new frame window
                //            new frame instance created
                    
                    JOptionPane.showMessageDialog(null, "Getting Records");
                    TableRecord t  = new TableRecord();
                    t.setVisible(true);
                    f.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
       else if(e.getSource()==clear)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            insert.setEnabled(true);
            fetch.setEnabled(true);
           
            
            
            JOptionPane.showMessageDialog(null, "All fields cleared successfully");
        
        }
        
        
       else if(e.getSource()==restart)
       {
//           restarts the java application 
           Restart r = new Restart();
            try {
                r.restartApplication(null);
            } catch (IOException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       }
        
    }
        
    public static void main(String[] args) {
        Driver d = new Driver();
    }
    
    
    
   
}




