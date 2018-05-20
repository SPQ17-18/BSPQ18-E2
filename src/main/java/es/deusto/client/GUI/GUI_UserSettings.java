package main.java.es.deusto.client.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.es.deusto.client.controller.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;

public class GUI_UserSettings extends JFrame {

	private JPanel contentPane;
	
	private controller c;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_UserSettings(controller c) {
		
		this.c = c;
		
		setTitle("DeustoBank");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIntroduceNewUser = new JLabel("Change Password");
		lblIntroduceNewUser.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblIntroduceNewUser.setBounds(125, 13, 259, 33);
		panel.add(lblIntroduceNewUser);
		
		JLabel lblNewPassword = new JLabel("New password:\r\n");
		lblNewPassword.setForeground(new Color(0, 0, 0));
		lblNewPassword.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		lblNewPassword.setBounds(27, 127, 130, 14);
		panel.add(lblNewPassword);
		
		JLabel lblRepeatNewPassword = new JLabel("Repeat new password:");
		lblRepeatNewPassword.setForeground(new Color(0, 0, 0));
		lblRepeatNewPassword.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		lblRepeatNewPassword.setBounds(27, 154, 154, 14);
		panel.add(lblRepeatNewPassword);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setForeground(new Color(0, 0, 204));
		btnAccept.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String oldPass = String.valueOf(passwordField.getPassword());
        		String newPass = String.valueOf(passwordField_1.getPassword());
        		String newPassRepeat = String.valueOf(passwordField_2.getPassword());
        		
				if(newPass.equals(newPassRepeat)){
					if(controller.changePassword(oldPass, newPass) == true){
						GUI_UserSettings.this.dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Passwords are not the same. Try again!");
				}
			}
		});
		btnAccept.setBounds(162, 193, 90, 33);
		panel.add(btnAccept);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI_UserSettings.this.dispose();
			}
		});
		button.setIcon(new ImageIcon(GUI_UserSettings.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		button.setBounds(373, 13, 42, 23);
		panel.add(button);
		
		JLabel lblOldPassword = new JLabel("Old password:\r\n");
		lblOldPassword.setForeground(new Color(0, 0, 0));
		lblOldPassword.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		lblOldPassword.setBounds(27, 85, 130, 14);
		panel.add(lblOldPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 80, 167, 22);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(199, 122, 168, 22);
		panel.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(200, 149, 167, 22);
		panel.add(passwordField_2);
	}
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
}
