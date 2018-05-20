package main.java.es.deusto.client.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.java.es.deusto.client.controller.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

	public class GUI_MAIN extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private static JTextField textField;
		private static JPasswordField passwordField;
		private controller c;
		
		/**
		 * Launch the application.
		 */
		public GUI_MAIN(controller c) {
			setTitle("DeustoBank");
			setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));
			this.c = c;
			init_GUI_MAIN();
			centreWindow();
			this.setVisible(true);		
		}

		/**
		 * Create the frame.
		 */
		public void init_GUI_MAIN() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 688, 536);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(204, 153, 255));
			contentPane.add(panel, BorderLayout.NORTH);
			
			JLabel lblDeustobank = new JLabel("DeustoBank");
			lblDeustobank.setFont(new Font("Yu Gothic UI", Font.BOLD, 50));
			panel.add(lblDeustobank);
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.SOUTH);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(204, 204, 255));
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			
			JLabel lblWelcomeToThe = new JLabel(c.getResourceBundle().getString("welcome_innovative"));
			lblWelcomeToThe.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblWelcomeToThe.setBounds(136, 13, 495, 39);
			panel_2.add(lblWelcomeToThe);
			
			JLabel lblIdNumber = new JLabel(c.getResourceBundle().getString("client_id")+":");
			lblIdNumber.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			lblIdNumber.setBounds(136, 65, 124, 46);
			panel_2.add(lblIdNumber);
			
			JLabel lblPassword = new JLabel(c.getResourceBundle().getString("password")+":");
			lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			lblPassword.setBounds(136, 124, 100, 34);
			panel_2.add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(292, 81, 202, 20);
			panel_2.add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(292, 134, 202, 20);
			panel_2.add(passwordField);
			
			JButton btnEnter = new JButton(c.getResourceBundle().getString("enter"));
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					String stringValueOf = String.valueOf(passwordField.getPassword());
					if(!textField.getText().isEmpty() && !stringValueOf.isEmpty()){
						if(textField.getText().equals("director")){
							if(c.logIn("director", stringValueOf) == true){
								JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("welcome_director")+"!!");
								GUI_Director frame = new GUI_Director(c);
								frame.setVisible(true);
								frame.centreWindow();
								GUI_MAIN.this.dispose();
							}
						}
						
						else if(c.logIn(textField.getText(), stringValueOf) == true){
							JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_login_ok"));
							GUI_UserMenu frame = new GUI_UserMenu(c);
							frame.setVisible(true);
							frame.centreWindow();
							GUI_MAIN.this.dispose();	
						}
					}
					else{
						JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("fill_gaps_first")+"!!");
					}
				}
			});
			btnEnter.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			btnEnter.setBounds(253, 179, 135, 34);
			panel_2.add(btnEnter);
			
			JButton btnLogin = new JButton("New User!");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Register_NewUser frame = new GUI_Register_NewUser(c);
					frame.setVisible(true);
					frame.centreWindow();
					GUI_MAIN.this.dispose();
				}
			});
			btnLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			btnLogin.setBounds(389, 326, 184, 39);
			panel_2.add(btnLogin);
			
			JButton btnForgotYourPassword = new JButton(c.getResourceBundle().getString("forgot_pass"));
			btnForgotYourPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					GUI_ForgotPassword frame = new GUI_ForgotPassword(c);
					frame.setVisible(true);
					GUI_MAIN.this.dispose();
				}
			});
			btnForgotYourPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			btnForgotYourPassword.setBounds(224, 226, 193, 30);
			panel_2.add(btnForgotYourPassword);
			
			JLabel lblYouAreNot = new JLabel(c.getResourceBundle().getString("not_client_yet"));
			lblYouAreNot.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblYouAreNot.setBounds(63, 301, 354, 39);
			panel_2.add(lblYouAreNot);
			
			JLabel lblBecomePartOf = new JLabel(c.getResourceBundle().getString("become_part"));
			lblBecomePartOf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblBecomePartOf.setBounds(63, 340, 354, 39);
			panel_2.add(lblBecomePartOf);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(204, 153, 255));
			panel_3.setBounds(0, 285, 660, 10);
			panel_2.add(panel_3);
			
			final JComboBox comboBox = new JComboBox();
			comboBox.setForeground(new Color(51, 102, 51));
			comboBox.setBounds(565, 42, 42, 30);
			comboBox.addItem("ES");
			comboBox.addItem("EN");
			comboBox.addItem("GE");
			
			if(c.language == 0){
				comboBox.setSelectedIndex(0);
			}
			else if(c.language == 1){
				comboBox.setSelectedIndex(1);
			}
			else if(c.language == 2){
				comboBox.setSelectedIndex(2);
			}
			
			panel_2.add(comboBox);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setForeground(new Color(0, 204, 0));
			btnNewButton.setIcon(new ImageIcon(GUI_MAIN.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));
			btnNewButton.setBounds(621, 42, 27, 30);
			panel_2.add(btnNewButton);
			
			JLabel lblLanguage = new JLabel("Language");
			lblLanguage.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
			lblLanguage.setBounds(565, 13, 83, 16);
			panel_2.add(lblLanguage);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					if(comboBox.getSelectedItem().equals("EN")){
						GUI_MAIN.this.dispose();
						c.language = 1;
						try {
							controller.main(c.Args);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (comboBox.getSelectedItem().equals("ES")){
						GUI_MAIN.this.dispose();
						c.language = 0;
						try {
							controller.main(c.Args);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (comboBox.getSelectedItem().equals("GE")){
						GUI_MAIN.this.dispose();
						c.language = 2;
						try {
							controller.main(c.Args);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	
				}
			});
			

		}
		
		public void centreWindow() {
			Dimension dim = getToolkit().getScreenSize();
			Rectangle abounds = getBounds();
			setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
		}
	}