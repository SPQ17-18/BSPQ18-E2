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

public class GUI_Register_NewUser extends JFrame
{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		JLabel l1, l2, l3, l4, l6, l7, l9, l10, l13, l15;

	    JTextField tName, tEmail, tCountry, tSurname1, tSurname2, tPostalcode, tCity, tAge;

	    JPasswordField pPassword;
	    
		private controller c;
	    
		private JPanel contentPane;
		private JPanel panel;
		private JPanel panel_1;
		private JLabel lblpassword;
		private JTextField tPhone;
		private JLabel comboBoxAccount;
		private JPasswordField p2;
		private JLabel lblNewClient;
		private JButton btnNewButton_1;
		private JPanel panel_4;
		private JLabel label_1;
		private JLabel lblPleaseFillThe;
		private JLabel label_2;
		private JLabel lbluserId;
		private JTextField textField;
		
		
	    GUI_Register_NewUser(final controller c)
	     {
	    	
	    	this.c = c;
	    	
	    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));

	        setVisible(true);
	        setSize(760, 610);
	        getContentPane().setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("DeustoBank");
			setBounds(100, 100, 760, 610);
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
	        
	        l2 = new JLabel("*"+c.getResourceBundle().getString("name")+":");
	        l2.setForeground(Color.DARK_GRAY);
	        l2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l2.setBounds(50, 151, 200, 30);
	        panel_2.add(l2);

	        l3 = new JLabel("*"+c.getResourceBundle().getString("surname_first")+":"); 
	        l3.setForeground(Color.DARK_GRAY);
	        l3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l3.setBounds(359, 151, 200, 30);
	        panel_2.add(l3);
	        
	        l4 = new JLabel("*"+c.getResourceBundle().getString("surname_second")+":"); 
	        l4.setForeground(Color.DARK_GRAY);
	        l4.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l4.setBounds(359, 190, 200, 30);
	        panel_2.add(l4);
	        
	        l6 = new JLabel("*"+c.getResourceBundle().getString("post_code")+":");  
	        l6.setForeground(Color.DARK_GRAY);
	        l6.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l6.setBounds(50, 233, 200, 30);
	        panel_2.add(l6);
	        
	        l7 = new JLabel(c.getResourceBundle().getString("city")+":");  
	        l7.setForeground(Color.DARK_GRAY);
	        l7.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l7.setBounds(359, 233, 200, 30);
	        panel_2.add(l7);

	        l9 = new JLabel("*"+c.getResourceBundle().getString("country")+":");
	        l9.setForeground(Color.DARK_GRAY);
	        l9.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l9.setBounds(50, 274, 200, 30);
	        panel_2.add(l9);
	        
	        l10 = new JLabel("*"+c.getResourceBundle().getString("email_id")+":"); 
	        l10.setForeground(Color.DARK_GRAY);
	        l10.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l10.setBounds(50, 315, 200, 30);
	        panel_2.add(l10);;
	        
	        l13 = new JLabel(c.getResourceBundle().getString("phone_no")+":"); 
	        l13.setForeground(Color.DARK_GRAY);
	        l13.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        l13.setBounds(359, 274, 200, 30);
	        panel_2.add(l13);
	
	        l15 = new JLabel("*"+c.getResourceBundle().getString("birthdate")+":"); 
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
	        tSurname2.setBounds(452, 194, 200, 30);
			tSurname2.setColumns(10);
			//tf1.setVisible(true);
	        panel_2.add(tSurname2);

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
	        tEmail.setText(""+"*"+c.getResourceBundle().getString("example")+":"+": xxxx@xxxx.com");
	        panel_2.add(tEmail);
	    
	        pPassword = new JPasswordField();
	        pPassword.setBounds(171, 461, 173, 30);
	        panel_2.add(pPassword);
	        
	        tAge = new JTextField();
	        tAge.setBounds(452, 318, 200, 30);
	        tAge.setColumns(10);
	        tAge.setText("dd/mm/yyyy");
	        panel_2.add(tAge);
	        
	        JLabel lblMustBe = new JLabel("(* "+c.getResourceBundle().getString("must_be_filled")+")");
	        lblMustBe.setFont(new Font("Microsoft JhengHei UI Light", Font.ITALIC, 12));
	        lblMustBe.setBounds(319, 106, 153, 30);
	        panel_2.add(lblMustBe);
	        //panel_3.setLayout(null);
	        
	        l1 = new JLabel(c.getResourceBundle().getString("please_fill_gaps")+"                 :");
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
	        
	        lblNewClient = new JLabel(c.getResourceBundle().getString("new_client_app"));
	        lblNewClient.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
	        lblNewClient.setBounds(207, 0, 353, 67);
	        panel.add(lblNewClient);
	        
	              
	        
	        JButton btnNewButton = new JButton("");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		GUI_Register_NewUser.this.dispose();
	      
	        		GUI_Register_NewUser frame = new GUI_Register_NewUser(c);
	        		frame.setVisible(true);
	        		frame.centreWindow();
	        	}
	        });
	        btnNewButton.setIcon(new ImageIcon(GUI_Register_NewUser.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
	        btnNewButton.setBounds(663, 93, 42, 30);
	        panel_2.add(btnNewButton);
	        
	        JButton btnBack = new JButton("");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		GUI_MAIN frame = new GUI_MAIN(c);
					frame.setVisible(true);
					GUI_Register_NewUser.this.dispose();
	        	}
	        });
	        btnBack.setIcon(new ImageIcon(GUI_Register_NewUser.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
	        btnBack.setBounds(610, 93, 42, 30);
	        panel_2.add(btnBack);
	        
	        lblpassword = new JLabel("*"+c.getResourceBundle().getString("create_pass"));
	        lblpassword.setForeground(Color.DARK_GRAY);
	        lblpassword.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lblpassword.setBounds(50, 461, 200, 30);
	        panel_2.add(lblpassword);
	        
	        JLabel lblP2 = new JLabel("*"+c.getResourceBundle().getString("repeat_pass")+":");
	        lblP2.setForeground(Color.DARK_GRAY);
	        lblP2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lblP2.setBounds(359, 461, 200, 30);
	        panel_2.add(lblP2);
	        
	        tPhone = new JTextField();
	        tPhone.setColumns(10);
	        tPhone.setBounds(452, 280, 200, 30);
	        panel_2.add(tPhone);
	        
	        p2 = new JPasswordField();
	        p2.setBounds(479, 461, 173, 30);
	        panel_2.add(p2);
	        
	        panel_4 = new JPanel();
	        panel_4.setLayout(null);
	        panel_4.setBackground(new Color(204, 153, 255));
	        panel_4.setBounds(0, 363, 734, 10);
	        panel_2.add(panel_4);
	        
	        label_1 = new JLabel("");
	        label_1.setBounds(92, 31, 46, 14);
	        panel_4.add(label_1);
	        
	        lblPleaseFillThe = new JLabel(c.getResourceBundle().getString("login_info")+":             :");
	        lblPleaseFillThe.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
	        lblPleaseFillThe.setBounds(83, 369, 339, 51);
	        panel_2.add(lblPleaseFillThe);
	        
	        label_2 = new JLabel("(* "+c.getResourceBundle().getString("must_be_filled")+")");
	        label_2.setFont(new Font("Microsoft JhengHei UI Light", Font.ITALIC, 12));
	        label_2.setBounds(319, 382, 153, 30);
	        panel_2.add(label_2);
	        
	        lbluserId = new JLabel("*"+c.getResourceBundle().getString("client_id")+":");
	        lbluserId.setForeground(Color.DARK_GRAY);
	        lbluserId.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
	        lbluserId.setBounds(50, 418, 200, 30);
	        panel_2.add(lbluserId);
	        
	        textField = new JTextField();
	        textField.setBounds(144, 418, 200, 30);
	        panel_2.add(textField);
	        textField.setColumns(10);
	        
	        btnNewButton_1 = new JButton(c.getResourceBundle().getString("submit"));
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String stringValueOf = String.valueOf(p2.getPassword());
	        		String stringValueOf2 = String.valueOf(pPassword.getPassword());
	        		if(!tName.getText().isEmpty() && !tSurname1.getText().isEmpty() && !tSurname2.getText().isEmpty() && !tCountry.getText().isEmpty() && 
	        				!tPostalcode.getText().isEmpty() && !tAge.getText().equals("dd/mm/yyyy") && !textField.getText().isEmpty() && !stringValueOf.isEmpty()
	        				&& !stringValueOf2.isEmpty() && !tEmail.getText().isEmpty()){
	        			
	        			if(tPhone.getText().isEmpty()){
	        				tPhone.setText("0");
	        			}
	        			
	        			if(tCity.getText().isEmpty()){
	        				tCity.setText(null);
	        			}
	        			
	        			if(stringValueOf.equals(stringValueOf2)){
	        				
	        				int intNumber = Integer.parseInt(tPhone.getText());
	        				int intPostalCode = Integer.parseInt(tPostalcode.getText());
	        				
	      
	        				if(c.newUser(tName.getText(), tSurname1.getText(), tSurname2.getText(), intPostalCode, tCity.getText(), 
	        						tCountry.getText(), intNumber, tEmail.getText(), tAge.getText(), textField.getText(), stringValueOf ) == true){
	        					GUI_MAIN frame = new GUI_MAIN(c);
	        					frame.setVisible(true);
								GUI_Register_NewUser.this.dispose();
	        				}
	        				
	        			}
	        			else{
	        				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("not_same_pass")+c.getResourceBundle().getString("try_again"));
	        			}
	        		}
					else{
						JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("fill_gaps_first")+"!!");
					}
	        	}	
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        panel_3.add(btnNewButton_1);
	        
	        repaint();

	    }
	   
		public void centreWindow() {
			Dimension dim = getToolkit().getScreenSize();
			Rectangle abounds = getBounds();
			setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
		}
	}
