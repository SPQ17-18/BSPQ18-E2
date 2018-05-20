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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

	public class GUI_ForgotPassword extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private static JTextField textField;
		private controller c;
		private JTextField textField_1;
		
		/**
		 * Launch the application.
		 */
		public GUI_ForgotPassword(controller c) {
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
			
			JLabel lblWelcomeToThe = new JLabel(c.getResourceBundle().getString("forgot_pass"));
			lblWelcomeToThe.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblWelcomeToThe.setBounds(166, 13, 328, 39);
			panel_2.add(lblWelcomeToThe);
			
			JLabel lblIdNumber = new JLabel(c.getResourceBundle().getString("client_id")+":");
			lblIdNumber.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			lblIdNumber.setBounds(136, 65, 124, 46);
			panel_2.add(lblIdNumber);
			
			JLabel lblPassword = new JLabel(c.getResourceBundle().getString("email")+":");
			lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			lblPassword.setBounds(136, 124, 100, 34);
			panel_2.add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(292, 81, 202, 20);
			panel_2.add(textField);
			textField.setColumns(10);
			
			JButton btnEnter = new JButton(c.getResourceBundle().getString("recover_pass")+"!");
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty()){
						if(c.forgetPassword(textField.getText(), textField_1.getText()) == true){
			        		GUI_MAIN frame = new GUI_MAIN(c);
							frame.setVisible(true);
							GUI_ForgotPassword.this.dispose();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("fill_gaps_first")+"!!");
					}
				}
			});
			btnEnter.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			btnEnter.setBounds(230, 199, 193, 34);
			panel_2.add(btnEnter);
			
			JButton btnLogin = new JButton(c.getResourceBundle().getString("new_user")+"!");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Register_NewUser frame = new GUI_Register_NewUser(c);
					frame.setVisible(true);
					frame.centreWindow();
					GUI_ForgotPassword.this.dispose();
				}
			});
			btnLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			btnLogin.setBounds(389, 326, 184, 39);
			panel_2.add(btnLogin);
			
			JLabel lblYouAreNot = new JLabel(c.getResourceBundle().getString("not_client_yet")+"?");
			lblYouAreNot.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblYouAreNot.setBounds(63, 301, 354, 39);
			panel_2.add(lblYouAreNot);
			
			JLabel lblBecomePartOf = new JLabel(c.getResourceBundle().getString("become_part")+"!");
			lblBecomePartOf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
			lblBecomePartOf.setBounds(63, 340, 354, 39);
			panel_2.add(lblBecomePartOf);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(204, 153, 255));
			panel_3.setBounds(0, 285, 660, 10);
			panel_2.add(panel_3);
			
			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		GUI_MAIN frame = new GUI_MAIN(c);
					frame.setVisible(true);
					GUI_ForgotPassword.this.dispose();
	        	}
	        });
			button.setIcon(new ImageIcon(GUI_ForgotPassword.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
			button.setBounds(592, 13, 42, 30);
			panel_2.add(button);
			
			textField_1 = new JTextField();
			textField_1.setBounds(292, 134, 202, 20);
			textField_1.setText(c.getResourceBundle().getString("example")+": xxxx@xxxx.com");
			panel_2.add(textField_1);
			textField_1.setColumns(10);
		}
		
		public void centreWindow() {
			Dimension dim = getToolkit().getScreenSize();
			Rectangle abounds = getBounds();
			setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
		}
	}