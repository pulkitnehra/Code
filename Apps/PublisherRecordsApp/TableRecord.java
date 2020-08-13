/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherRecordsApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
//had to add r2s.xml to import this
import net.proteanit.sql.DbUtils;

/**
 *
 * @author nehra
 */
public class TableRecord extends JFrame{

           private JPanel contPane;
           private JTable table;
           private JLabel pubid;
           private JLabel pubname;
           private JLabel phno;
           private JLabel add;
           private JLabel city;
           private JLabel state;
           private JLabel zip;
           ResultSet re;
    
    public TableRecord() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contPane = new JPanel();
        contPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contPane);
        contPane.setLayout(null);
        
        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contPane.add(table);
        
        JButton loadBtn = new JButton("Load Records");
        loadBtn.setBounds(350, 500, 120, 30);
        loadBtn.setBackground(Color.BLACK);
        loadBtn.setForeground(Color.WHITE);
        contPane.add(loadBtn);
        
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Conn c = new Conn();
                    String qr = "select *from pub;";
                    re = c.rs;
                     re = c.s.executeQuery(qr);
//                     method that adds columns to table
                     table.setModel(DbUtils.resultSetToTableModel(re));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
//        Exit button Functionality
           JButton exit  = new JButton("Exit");
           exit.setBounds(500, 500, 120, 30);
           exit.setBackground(Color.BLACK);
           exit.setForeground(Color.WHITE);
           contPane.add(exit);
           
           exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    
        pubid = new JLabel("id");
        pubid.setBounds(41, 11, 46, 14);
        contPane.add(pubid);
        pubname = new JLabel("Publication");
        pubname.setBounds(159, 11, 86, 14);
        contPane.add(pubname);
        phno = new JLabel("Phone");
        phno.setBounds(300, 11, 50, 14);
        contPane.add(phno);
        add = new JLabel("Address");
        add.setBounds(450, 11, 86, 14);
        contPane.add(add);
        city = new JLabel("City");
        city.setBounds(600, 11, 46, 14);
        contPane.add(city);
        state = new JLabel("State");
        state.setBounds(750, 11, 46, 14);
        contPane.add(state);
        zip = new JLabel("Zip");
        zip.setBounds(900, 11, 46, 14);
        contPane.add(zip);
    
    
    getContentPane().setBackground(Color.WHITE);
    
    
    
    }
    public static void main(String[] args) {
               try {
                   TableRecord t = new TableRecord();
                   t.setVisible(true);
               } catch (SQLException ex) {
                   Logger.getLogger(TableRecord.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
    
}
