package main.java.es.deusto.client.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
//has to be imported for sql part..!?
//import java.sql.*;

public class GUI_Register_NewUser extends JFrame implements ActionListener
{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		JLabel l1, l2, l3, l4, l5, l6, l7, l8;

	    JTextField tf1, tf2, tf5, tf6, tf7;

	    JButton btn1, btn2;

	    JPasswordField p1, p2;
	    
		private JPanel contentPane;
	 
	    GUI_Register_NewUser()
	     {

	        setVisible(true);
	        setSize(700, 700);
	        setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("DeustoBank");
			//setBounds(100, 100, 511, 368);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
	        
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.NORTH);
			//panel_1.setLayout(null);
			
			JLabel lblDeustobank = new JLabel("DeustoBank");
			lblDeustobank.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
			panel_1.add(lblDeustobank);
			
			JPanel panel_2 = new JPanel();
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			contentPane.add(panel_3, BorderLayout.SOUTH);
			//panel_3.setLayout(null);
			
	        l1 = new JLabel("Register a new member:");
	        l1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
	        l1.setBounds(80, 30, 400, 30);
	        panel_2.add(l1);
	        
	        l2 = new JLabel("Name:");
	        l2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l2.setBounds(80, 70, 200, 30);
	        panel_2.add(l2);
	        
	        l3 = new JLabel("Email-ID:");
	        l3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l3.setBounds(80, 110, 200, 30);
	        panel_2.add(l3);
	        
	        l4 = new JLabel("Create Passowrd:");
	        l4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l4.setBounds(80, 150, 200, 30);
	        panel_2.add(l4);
	        
	        l5 = new JLabel("Confirm Password:");
	        l5.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l5.setBounds(80, 190, 200, 30);
	        panel_2.add(l5);
	        
	        l6 = new JLabel("Country:");
	        l6.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l6.setBounds(80, 230, 200, 30);
	        panel_2.add(l6);
	        
	        l7 = new JLabel("State:");
	        l7.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l7.setBounds(80, 270, 200, 30);
	        panel_2.add(l7);
	        
	        l8 = new JLabel("Phone No:"); 
	        l8.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
	        l8.setBounds(80, 310, 200, 30);
	        panel_2.add(l8);
	        
	        tf1 = new JTextField();
	        tf1.setBounds(300, 70, 200, 30);
			tf1.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tf1);
	        
	        tf2 = new JTextField();
	        tf2.setBounds(300, 110, 200, 30);
	        panel_2.add(tf2);
	        
	        p1 = new JPasswordField();
	        p1.setBounds(300, 150, 200, 30);
	        panel_2.add(p1);
	        
	        p2 = new JPasswordField();
	        p2.setBounds(300, 190, 200, 30);
	        panel_2.add(p2);
	        
	        tf5 = new JTextField();
	        tf5.setBounds(300, 230, 200, 30);
	        panel_2.add(tf5);
	        
	        tf6 = new JTextField();
	        tf6.setBounds(300, 270, 200, 30);
	        panel_2.add(tf6);
	        
	        tf7 = new JTextField();
	        tf7.setBounds(300, 310, 200, 30);
	        panel_2.add(tf7);
	        
	        btn1 = new JButton("Submit");
			btn1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
	        //btn1.setBounds(50, 350, 100, 30);
			panel_3.add(btn1);	
            btn1.addActionListener(this);
		
	        btn2 = new JButton("Clear");
			btn2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
	        //btn2.setBounds(170, 350, 100, 30);
			panel_3.add(btn2);
	        btn2.addActionListener(this);
	        
	        repaint();

	    }

	 

	    public void actionPerformed(ActionEvent e)
	    {

	        if (e.getSource() == btn1)
	        {
	        	
//	            String s1 = tf1.getText();
//	            String s2 = tf2.getText();

	            char[] s3 = p1.getPassword();
	            char[] s4 = p2.getPassword(); 

	            String s8 = new String(s3);
	            String s9 = new String(s4);

//	            String s5 = tf5.getText();
//	            String s6 = tf6.getText();
//	            String s7 = tf7.getText();

	            if (s8.equals(s9))
	            {
	                try
	                {
	                	//TODO the new member has to be created in the database (sql) here
	                	
	                    //if ('user is created')
	                    //{
                        //
	                    //    JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                        //
	                    //}

	                }
	          catch (Exception ex)
	                {
	                    System.out.println(ex);
	                }
	            }
	          else
	           {
	                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
               } 
           }
	       if (e.getSource() == btn2)
   	       {

	            tf1.setText("");
	            tf2.setText("");

	            p1.setText("");
	            p2.setText("");

	            tf5.setText("");
	            tf6.setText("");
	            tf7.setText("");

	        }

	    } 
// 		main for testing gui... 
	    public static void main(String args[])
	   {
	        GUI_Register_NewUser frame = new GUI_Register_NewUser();
			frame.setVisible(true);

       }
	}


