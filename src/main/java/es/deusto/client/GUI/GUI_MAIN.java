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
	import java.awt.event.ActionEvent;
import java.awt.Color;

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
			setBounds(100, 100, 687, 494);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(204, 153, 255));
			contentPane.add(panel, BorderLayout.NORTH);
			
			JLabel lblDeustobank = new JLabel("DeustoBank");
			lblDeustobank.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
			panel.add(lblDeustobank);
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.SOUTH);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(204, 204, 255));
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			
			JLabel lblWelcomeToThe = new JLabel("Welcome to the most innovative banking system");
			lblWelcomeToThe.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
			lblWelcomeToThe.setBounds(197, 13, 255, 14);
			panel_2.add(lblWelcomeToThe);
			
			JLabel lblIdNumber = new JLabel("ID Number:");
			lblIdNumber.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			lblIdNumber.setBounds(136, 95, 124, 34);
			panel_2.add(lblIdNumber);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			lblPassword.setBounds(136, 141, 100, 34);
			panel_2.add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(292, 105, 202, 20);
			panel_2.add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(292, 151, 202, 20);
			panel_2.add(passwordField);
			
			JButton btnEnter = new JButton("Enter");
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					String stringValueOf = String.valueOf(passwordField.getPassword());
					if(!textField.getText().isEmpty() && !stringValueOf.isEmpty()){
						if(c.logIn(textField.getText(), stringValueOf) == true){
							GUI_UserMenu frame = new GUI_UserMenu();
							frame.setVisible(true);
							GUI_MAIN.this.dispose();	
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "You have to fill the gaps first!!");
					}
				}
			});
			btnEnter.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			btnEnter.setBounds(192, 216, 124, 23);
			panel_2.add(btnEnter);
			
			JButton btnLogin = new JButton("New User!");
			btnLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			btnLogin.setBounds(339, 216, 124, 23);
			panel_2.add(btnLogin);
			
			JButton btnForgotYourPassword = new JButton("Forgot your password?");
			btnForgotYourPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
			btnForgotYourPassword.setBounds(260, 252, 152, 30);
			panel_2.add(btnForgotYourPassword);
		}
		
		public void centreWindow() {
			Dimension dim = getToolkit().getScreenSize();
			Rectangle abounds = getBounds();
			setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
		}
		
	}
