package main.java.es.deusto.client.GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.DTO.AccountTypeDTO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class GUI_NewAccount extends JFrame {

	private JPanel contentPane;
	
	private controller c;
	
	public List<AccountTypeDTO> atdto;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GUI_NewAccount(controller c) {
		
		this.c = c;
		
		setTitle("DeustoBank");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(204, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JComboBox comboBox_AccTypes = new JComboBox();
		comboBox_AccTypes.setBounds(250, 72, 156, 20);
		panel.add(comboBox_AccTypes);
		
		/**
		 * Method to introduce AccountsType to ComboBox
		 */
	 
		
		
		List<String> AccTypes = new ArrayList<>(); 

		atdto = c.getAccountTypes();
		
		for(int i = 0; i<atdto.size(); i++){
			AccTypes.add(atdto.get(i).getAccountType());
		}
		
		/**
		 * for(int i=0; i<AccTypes.length();i++){
		 * 		comboBox_AccTypes.addItem();
		 * }
		 */
		
		for(String s:AccTypes){
			comboBox_AccTypes.addItem(s);
		}
		
		
		/**
		 * Method to create Account by giving userId of current user and AccountType
		 */
		
		
		JLabel lblChooseTheType = new JLabel(c.getResourceBundle().getString("choose_acc_type")+":");
		lblChooseTheType.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		lblChooseTheType.setBounds(12, 73, 200, 20);
		panel.add(lblChooseTheType);
		
		JButton btnCreate = new JButton(c.getResourceBundle().getString("create"));
		btnCreate.setForeground(new Color(0, 0, 153));
		btnCreate.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.newUserAccount((String)comboBox_AccTypes.getSelectedItem());
				GUI_NewAccount.this.dispose();
			}
		});
		btnCreate.setBounds(162, 268, 99, 50);
		panel.add(btnCreate);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_NewAccount.this.dispose();
			}
		});
		button.setIcon(new ImageIcon(GUI_NewAccount.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		button.setBounds(366, 13, 40, 23);
		panel.add(button);
		
		JLabel lblNewAccount = new JLabel(c.getResourceBundle().getString("new_acc"));
		lblNewAccount.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewAccount.setBounds(151, 13, 137, 34);
		panel.add(lblNewAccount);
		
		final JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 204, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(12, 139, 410, 92);
		panel.add(lblNewLabel);
		lblNewLabel.setText("");
		
		JButton btnNewButton = new JButton(c.getResourceBundle().getString("description"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < atdto.size(); i++){
					if(comboBox_AccTypes.getSelectedItem().equals(atdto.get(i).getAccountType())){
						lblNewLabel.setText(" [" + atdto.get(i).getAccountType() + "] " + atdto.get(i).getDescription());
					}
				}	
			}
			
		});
		btnNewButton.setFont(new Font("Footlight MT Light", Font.PLAIN, 15));
		btnNewButton.setBounds(151, 120, 121, 25);
		panel.add(btnNewButton);
	}
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
}