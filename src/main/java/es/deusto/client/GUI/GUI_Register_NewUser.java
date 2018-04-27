package main.java.es.deusto.client.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.es.deusto.client.controller.controller;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
//has to be imported for sql part..!?
//import java.sql.*;
import java.util.UUID;

public class GUI_Register_NewUser extends JFrame implements ActionListener
{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		JLabel l1, l2, l3, l4, l5, l6, l7, l9, l10, l13, l15;

	    JTextField tName, tEmail, tCountry, tSurname1, tSurname2, tAdress, tPostalcode, tCity, tAge;

	    JButton btn1;

	    JPasswordField pPassword;
	    
		private JPanel contentPane;
		private JPanel panel;
		private JPanel panel_1;
		private JLabel lblpassword;
		private JTextField tPhone;
		private JLabel lblaccountType;
		private JLabel comboBoxAccount;
		private JPasswordField p2;
	    GUI_Register_NewUser()
	     {

	        setVisible(true);
	        setSize(760, 544);
	        getContentPane().setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("DeustoBank");
			//setBounds(100, 100, 511, 368);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(204, 204, 255));
			panel_2.setForeground(Color.GRAY);
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(204, 204, 255));
			contentPane.add(panel_3, BorderLayout.SOUTH);
	        
	        l2 = new JLabel("*Name:");
	        l2.setForeground(Color.DARK_GRAY);
	        l2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l2.setBounds(50, 151, 200, 30);
	        panel_2.add(l2);

	        l3 = new JLabel("*Surname_1:"); 
	        l3.setForeground(Color.DARK_GRAY);
	        l3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l3.setBounds(359, 151, 200, 30);
	        panel_2.add(l3);
	        
	        l4 = new JLabel("*Surname_2:"); 
	        l4.setForeground(Color.DARK_GRAY);
	        l4.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l4.setBounds(50, 192, 200, 30);
	        panel_2.add(l4);
	        
	        l5 = new JLabel("*Address:"); 
	        l5.setForeground(Color.DARK_GRAY);
	        l5.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l5.setBounds(359, 192, 200, 30);
	        panel_2.add(l5);
	        
	        l6 = new JLabel("*Postal Code:");  
	        l6.setForeground(Color.DARK_GRAY);
	        l6.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l6.setBounds(50, 233, 200, 30);
	        panel_2.add(l6);
	        
	        l7 = new JLabel("City:");  
	        l7.setForeground(Color.DARK_GRAY);
	        l7.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l7.setBounds(359, 233, 200, 30);
	        panel_2.add(l7);

	        l9 = new JLabel("*Country:");
	        l9.setForeground(Color.DARK_GRAY);
	        l9.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l9.setBounds(50, 274, 200, 30);
	        panel_2.add(l9);
	        
	        l10 = new JLabel("*Email-ID:"); 
	        l10.setForeground(Color.DARK_GRAY);
	        l10.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l10.setBounds(50, 315, 200, 30);
	        panel_2.add(l10);;
	        
	        l13 = new JLabel("Phone No:"); 
	        l13.setForeground(Color.DARK_GRAY);
	        l13.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l13.setBounds(359, 274, 200, 30);
	        panel_2.add(l13);
	
	        l15 = new JLabel("*Birthdate:"); 
	        l15.setForeground(Color.DARK_GRAY);
	        l15.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l15.setBounds(359, 317, 200, 30);
	        panel_2.add(l15);
	        
	        
	        tName = new JTextField();
	        tName.setBounds(149, 154, 200, 30);
			tName.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tName);
	        
	        tSurname1 = new JTextField();
	        tSurname1.setBounds(452, 154, 200, 30);
			tSurname1.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tSurname1);

	        tSurname2= new JTextField();
	        tSurname2.setBounds(149, 195, 200, 30);
			tSurname2.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tSurname2);
	        
	        tAdress = new JTextField();
	        tAdress.setBounds(452, 192, 200, 30);
	        tAdress.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tAdress);

	        tPostalcode = new JTextField();
	        tPostalcode.setBounds(149, 233, 200, 30);
	        tPostalcode.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tPostalcode);
	        
	        tCity = new JTextField();
	        tCity.setBounds(452, 233, 200, 30);
	        panel_2.add(tCity);
	        
	        tCountry = new JTextField();
	        tCountry.setBounds(149, 274, 200, 30);
	        panel_2.add(tCountry);
	        
	        tEmail = new JTextField();
	        tEmail.setBounds(149, 318, 200, 30);
	        panel_2.add(tEmail);
	    
	        pPassword = new JPasswordField();
	        pPassword.setBounds(176, 357, 173, 30);
	        panel_2.add(pPassword);
	        
	        tAge = new JTextField();
	        tAge.setBounds(452, 318, 200, 30);
	        tAge.setColumns(10);
	        panel_2.add(tAge);
	        
	        JLabel lblMustBe = new JLabel("(* must be filled)");
	        lblMustBe.setFont(new Font("Microsoft JhengHei UI Light", Font.ITALIC, 12));
	        lblMustBe.setBounds(319, 106, 153, 30);
	        panel_2.add(lblMustBe);
	        //panel_3.setLayout(null);
	        
	        l1 = new JLabel("Please fill the gaps below                  :");
	        l1.setBounds(83, 93, 378, 51);
	        panel_2.add(l1);
	        l1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
	        
	        panel = new JPanel();
	        panel.setBackground(new Color(204, 153, 255));
	        panel.setBounds(0, 0, 734, 79);
	        panel_2.add(panel);
	        panel.setLayout(null);
	        JLabel label = new JLabel("");
	        label.setBounds(92, 31, 46, 14);
	        panel.add(label);
	        
	        JLabel lblDeustobank = new JLabel("DeustoBank");
	        lblDeustobank.setFont(new Font("Lucida Bright", Font.PLAIN, 26));
	        lblDeustobank.setBounds(277, 0, 175, 84);
	        panel.add(lblDeustobank);
	        
	              
	        
	        JButton btnNewButton = new JButton("");
	        btnNewButton.setIcon(new ImageIcon(GUI_Register_NewUser.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
	        btnNewButton.setBounds(663, 93, 42, 30);
	        panel_2.add(btnNewButton);
	        
	        JButton btnBack = new JButton("");
	        btnBack.setIcon(new ImageIcon(GUI_Register_NewUser.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
	        btnBack.setBounds(610, 93, 42, 30);
	        panel_2.add(btnBack);
	        
	        lblpassword = new JLabel("*Create password:");
	        lblpassword.setForeground(Color.DARK_GRAY);
	        lblpassword.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lblpassword.setBounds(50, 356, 200, 30);
	        panel_2.add(lblpassword);
	        
	        JLabel lblP2 = new JLabel("*Repeat password:");
	        lblP2.setForeground(Color.DARK_GRAY);
	        lblP2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lblP2.setBounds(359, 359, 200, 30);
	        panel_2.add(lblP2);
	        
	        tPhone = new JTextField();
	        tPhone.setColumns(10);
	        tPhone.setBounds(452, 280, 200, 30);
	        panel_2.add(tPhone);
	        
	        lblaccountType = new JLabel("*Account type\r\n:");
	        lblaccountType.setForeground(Color.DARK_GRAY);
	        lblaccountType.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lblaccountType.setBounds(176, 415, 158, 30);
	        panel_2.add(lblaccountType);
	        
	        JComboBox comboBoxAccount = new JComboBox();
	        comboBoxAccount.setBounds(308, 421, 153, 20);
	        panel_2.add(comboBoxAccount);
	        
	        p2 = new JPasswordField();
	        p2.setBounds(479, 362, 173, 30);
	        panel_2.add(p2);
	        
	        btn1 = new JButton("Submit");
	        btn1.setSelectedIcon(new ImageIcon(GUI_Register_NewUser.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
			btn1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
	        //btn1.setBounds(50, 350, 100, 30);
			panel_3.add(btn1);	
            btn1.addActionListener(this);
	        
	        repaint();

	    }

	 

	    public void actionPerformed(ActionEvent e)
	    {

	        if (e.getSource() == btn1)
	        {
	        	//TODO: create an UserID which has the same value when the same user registers... @Phil
	        	String UserID = generateString();
	        	String name = tName.getText();
	        	String surname1 = tSurname1.getText();
	        	String surname2 = tSurname2.getText();
	        	String address = tAdress.getText(); 
	            String postal = tPostalcode.getText();
	            int postalcode = Integer.parseInt(postal);
	        	String city = tCity.getText();
	            String coun = tCountry.getText();
	            
	            String email = tEmail.getText();

	            char[] s3 = pPassword.getPassword();
	            char[] s4 = p2.getPassword(); 

	            String pass = new String(s3);
	            String s9 = new String(s4);

	            String ph = tPhone.getText();
	            int phone = Integer.parseInt(ph);
	            
	            String TypeofAccount = comboBoxAccount.getText();
	            if (pass.equals(s9))
	            {
	                try
	                {
	                	/**
	                	 * TODO: are the user attributes in the correct order??
	                	 */
	                   // if (controller.newUser(UserID, name, surname1, surname2, address, postalcode, city, null, coun, email, pass, phone, TypeofAccount, 0))
	                    	
	                    {
                        
	                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                        
	                    }

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

	    } 
// 		main for testing gui... 
	    public static void main(String args[])
	   {
	        GUI_Register_NewUser frame = new GUI_Register_NewUser();
			frame.setVisible(true);

       }
	    
	    public static String generateString() 
	    {
	        String uuid = UUID.randomUUID().toString().replace("-", "");
	        return "uuid = " + uuid;
	    }
	    
	    /**
	     * TODO Develop method to insert image to make window look better.
	     * @param location
	     * @param width
	     * @param height
	     * @return
	     */
	    private ImageIcon image(URL location, int width, int height) {
			ImageIcon icon = new ImageIcon(location);
			Image img = icon.getImage(); 
			Image otraimg = img.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH);
			ImageIcon otroicon = new ImageIcon(otraimg);
			return otroicon;
			//This is the method that must be placed in the window, it calls this method from above. Must have Path (/img/logo-universidad.deusto.png)
			//lblGIF.setIcon(redimensionarImagen(VentanaRutina.class.getResource("/"+gif), 312, 283));
		}
	}

