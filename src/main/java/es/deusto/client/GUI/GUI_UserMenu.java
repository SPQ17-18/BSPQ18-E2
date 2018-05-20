package main.java.es.deusto.client.GUI;
/**
 * 
 * Pootle translation 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.DTO.AccountDTO;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Color;
// Class to implement user interface
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class GUI_UserMenu extends JFrame {

	/**
	 * TODO Change color to match GUI_Register_New_User color palet
	 */
	
	
	
	
	private JPanel contentPane;
	private JPanel panel_Accounts,panel_AccDetail;
	private JTextField textField_CCNumberReceiver;
	private JTextField textField_AmountTransf;
	private JTextField textField_Description;
	private JRadioButton radioButton = new JRadioButton("10");
	private JRadioButton radioButton_1 = new JRadioButton("15");
	private JRadioButton radioButton_2 = new JRadioButton("20");
	private JRadioButton radioButton_3 = new JRadioButton("40");
	private JRadioButton radioButton_4 = new JRadioButton("50");
	private JRadioButton rdbtnOtherAmount = new JRadioButton("Other amount");
	private List<JRadioButton> listJRadio = new  ArrayList<JRadioButton>();
	private DefaultTableModel model;
	private JTable table;
	private Thread th2 ;
	
	public JButton btnTransfer = new JButton("Transfer");
	public JButton btnAtm = new JButton("ATM");
	public JButton btnAccounts = new JButton("Accounts");
	public final JComboBox comboBox;
	public final JComboBox comboBoxAccountOwner;
	
	public final controller c;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_UserMenu(final controller c) {
		
		this.c = c;
		
		setTitle("DeustoBank");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));
		
		listJRadio.add(radioButton);
		listJRadio.add(radioButton_1);
		listJRadio.add(radioButton_2);
		listJRadio.add(radioButton_3);
		listJRadio.add(radioButton_4);
		listJRadio.add(rdbtnOtherAmount);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 378);
		setSize(789, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 62, 771, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		panel_4.setBounds(623, 122, 148, 404);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_UserSettings f = new GUI_UserSettings(c);
				f.setVisible(true);
				f.centreWindow();
			}
		});
		btnSettings.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnSettings.setBounds(27, 171, 97, 23);
		panel_4.add(btnSettings);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_MAIN frame = new GUI_MAIN(c);
				frame.setVisible(true);
				GUI_UserMenu.this.dispose();
			}
		});
		btnLogout.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnLogout.setBounds(27, 324, 97, 40);
		panel_4.add(btnLogout);
		
		final JButton btnAccept = new JButton("Accept");
		btnAccept.setForeground(new Color(0, 51, 255));
		btnAccept.setVisible(false);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i<model.getRowCount() && model.getRowCount()!=0;i++){
					if(table.isRowSelected(i)){
						if(model.getValueAt(i, 4).equals(true)){
							Accounts_GUI f = new Accounts_GUI(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)), c);
							f.setVisible(true);
							f.centreWindow();
						}
					}
				}
			}
		});
		btnAccept.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnAccept.setBounds(27, 111, 97, 23);
		panel_4.add(btnAccept);
		
		final JButton btnNewButton = new JButton("New Account");
		btnNewButton.setBounds(12, 13, 124, 35);
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_NewAccount f = new GUI_NewAccount(c);
				f.setVisible(true);
				f.centreWindow();
			}
		});
		btnNewButton.setForeground(new Color(255, 51, 51));
		btnNewButton.setVisible(false);
		btnNewButton.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		GUI_UserMenu.this.dispose();
      	      
        		GUI_UserMenu frame = new GUI_UserMenu(c);
        		frame.setVisible(true);
        		frame.centreWindow();
			}
		});
		button_1.setIcon(new ImageIcon(GUI_UserMenu.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		button_1.setBounds(56, 61, 42, 30);
		panel_4.add(button_1);
		
		final JButton btnNewButton_1 = new JButton("Insert ");
		btnNewButton_1.setForeground(new Color(0, 51, 255));
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i <listJRadio.size(); i++){
					if(listJRadio.get(i).isSelected()){
						if(listJRadio.get(i).getLabel().equals("Other amount")){
							int amount = Integer.parseInt(textField_Description.getText());	
							c.insertMoney((String)comboBox.getSelectedItem(), amount );
						}
						else{
							int amount = Integer.parseInt(listJRadio.get(i).getLabel());		
							c.insertMoney((String)comboBox.getSelectedItem(), amount );
						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		btnNewButton_1.setBounds(27, 226, 97, 25);
		panel_4.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("Draw");
		btnNewButton_2.setForeground(new Color(0, 51, 255));
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i <listJRadio.size(); i++){
					if(listJRadio.get(i).isSelected()){
						if(listJRadio.get(i).getLabel().equals("Other amount")){
							int amount = Integer.parseInt(textField_Description.getText());	
							c.drawMoney((String)comboBox.getSelectedItem(), amount );
						}
						else{
							int amount = Integer.parseInt(listJRadio.get(i).getLabel());		
							c.drawMoney((String)comboBox.getSelectedItem(), amount );
						}
					}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		btnNewButton_2.setBounds(27, 264, 97, 25);
		panel_4.add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("Transaction");
		btnNewButton_3.setForeground(new Color(0, 51, 255));
		btnNewButton_3.setFont(new Font("Footlight MT Light", Font.PLAIN, 13));
		btnNewButton_3.setBounds(27, 110, 97, 25);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(textField_AmountTransf.getText());
				c.transaction((String)comboBoxAccountOwner.getSelectedItem(), textField_CCNumberReceiver.getText(), amount);
			}
		});
		btnNewButton_3.setVisible(false);
		panel_4.add(btnNewButton_3);
		
		panel_Accounts = new JPanel();
		panel_Accounts.setForeground(new Color(204, 204, 255));
		panel_Accounts.setBounds(0, 130, 627, 396);
		contentPane.add(panel_Accounts);
		panel_Accounts.setLayout(null);
		
		
		
		final JLabel lblCreditCardReceiver = new JLabel("Account of the receiver:");
		lblCreditCardReceiver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblCreditCardReceiver.setBounds(84, 119, 191, 14);
		panel_Accounts.add(lblCreditCardReceiver);
		
		final JLabel lblNameOfReceiver = new JLabel("Description:");
		lblNameOfReceiver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNameOfReceiver.setBounds(84, 149, 166, 14);
		panel_Accounts.add(lblNameOfReceiver);
		
		final JLabel lblAmount = new JLabel("Amount:\r\n");
		lblAmount.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblAmount.setBounds(84, 229, 166, 14);
		panel_Accounts.add(lblAmount);
		
		final JLabel lblHeader = new JLabel("Money Transfer");
		lblHeader.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
		lblHeader.setBounds(270, 13, 152, 21);
		panel_Accounts.add(lblHeader);
		
		textField_CCNumberReceiver = new JTextField();
		textField_CCNumberReceiver.setBounds(315, 119, 216, 20);
		panel_Accounts.add(textField_CCNumberReceiver);
		textField_CCNumberReceiver.setColumns(10);
		
		final JTextField textField_NameReceiver = new JTextField();
		textField_NameReceiver.setColumns(10);
		textField_NameReceiver.setBounds(314, 149, 216, 67);
		panel_Accounts.add(textField_NameReceiver);
		
		textField_AmountTransf = new JTextField();
		textField_AmountTransf.setColumns(10);
		textField_AmountTransf.setBounds(314, 229, 216, 23);
		panel_Accounts.add(textField_AmountTransf);
		
		textField_Description = new JTextField();
		textField_Description.setColumns(10);
		textField_Description.setVisible(false);
		textField_Description.setBounds(405, 280, 166, 21);
		panel_Accounts.add(textField_Description);
		
		final JLabel lblAmount_ATM = new JLabel("Amount:");
		lblAmount_ATM.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblAmount_ATM.setBounds(94, 128, 123, 21);
		panel_Accounts.add(lblAmount_ATM);
		
		
		radioButton.setBounds(270, 128, 136, 23);
		panel_Accounts.add(radioButton);
		
		radioButton_1.setBounds(270, 158, 109, 23);
		panel_Accounts.add(radioButton_1);
		
		radioButton_2.setBounds(270, 188, 109, 23);
		panel_Accounts.add(radioButton_2);
		
		radioButton_3.setBounds(270, 218, 109, 23);
		panel_Accounts.add(radioButton_3);
		
		radioButton_4.setBounds(270, 248, 109, 23);
		panel_Accounts.add(radioButton_4);
		
		rdbtnOtherAmount.setBounds(270, 278, 109, 23);
		panel_Accounts.add(rdbtnOtherAmount);
		
		final JLabel labelAccountOwner = new JLabel("Choose account to transfer from\r\n");
		labelAccountOwner.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		labelAccountOwner.setBounds(84, 89, 231, 14);
		panel_Accounts.add(labelAccountOwner);
		
		comboBoxAccountOwner = new JComboBox();
		comboBoxAccountOwner.setForeground(new Color(51, 204, 0));
		comboBoxAccountOwner.setBounds(315, 89, 216, 20);
		panel_Accounts.add(comboBoxAccountOwner);
		
				
		panel_AccDetail = new JPanel();
		panel_AccDetail.setBackground(new Color(255, 255, 255));
		panel_AccDetail.setBounds(10, 68, 597, 304);
		panel_AccDetail.setLayout(new BorderLayout(0, 0));
		panel_Accounts.add(panel_AccDetail);
		
		final JLabel lblSelectAccount = new JLabel("Select Account:");
		lblSelectAccount.setVisible(false);
		lblSelectAccount.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblSelectAccount.setBounds(94, 53, 152, 21);
		panel_Accounts.add(lblSelectAccount);
		
		comboBox = new JComboBox();
		comboBox.setVisible(false);
		comboBox.setForeground(new Color(51, 204, 0));
		comboBox.setBounds(270, 55, 261, 22);
		panel_Accounts.add(comboBox);
		
		List<String> UserAccounts = new ArrayList<>(); 

		List<AccountDTO> aList = c.getUserAccounts();
		
		for(int i = 0; i<aList.size(); i++){
			UserAccounts.add(aList.get(i).getAccountID());
		}
		
		/**
		 * for(int i=0; i<AccTypes.length();i++){
		 * 		comboBox_AccTypes.addItem();
		 * }
		 */
		
		for(String s:UserAccounts){
			comboBox.addItem(s);
			comboBoxAccountOwner.addItem(s);
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		th2 = new Thread(r2);
		th2.start();
		
		
		
		
		panel_Accounts.setVisible(false);
		
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(th2.isAlive()){
					th2.stop();	
				}
					
				ATM_choice(false);
				panel_AccDetail.setVisible(true);
				panel_Accounts.setVisible(true);
				lblCreditCardReceiver.setVisible(false);
				lblNameOfReceiver.setVisible(false);
				lblAmount.setVisible(false);
				lblHeader.setText("Accounts");
				textField_CCNumberReceiver.setVisible(false);
				textField_NameReceiver.setVisible(false);
				textField_AmountTransf.setVisible(false);
				labelAccountOwner.setVisible(false);
				comboBoxAccountOwner.setVisible(false);
				lblAmount_ATM.setVisible(false);
				btnNewButton.setVisible(true);
				radioButton.setVisible(false);
				radioButton_1.setVisible(false);
				radioButton_2.setVisible(false);
				radioButton_3.setVisible(false);
				radioButton_4.setVisible(false);
				rdbtnOtherAmount.setVisible(false);		
				lblSelectAccount.setVisible(false);
				comboBox.setVisible(false);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnAccept.setVisible(true);
				btnNewButton_3.setVisible(false);
				
				showAccounts();
				
			}
		});
		btnAccounts.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnAccounts.setBounds(52, 13, 105, 36);
		panel_1.add(btnAccounts);
		
		
		btnAtm.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnAtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(th2.isAlive()){
					th2.resume();	
				}
				th2 = new Thread(r2);
				th2.start();
				      
				panel_AccDetail.setVisible(false);
				panel_Accounts.setVisible(true);
				lblCreditCardReceiver.setVisible(false);
				lblNameOfReceiver.setVisible(false);
				lblAmount.setVisible(false);
				lblHeader.setText("ATM");
				textField_CCNumberReceiver.setVisible(false);
				textField_NameReceiver.setVisible(false);
				textField_AmountTransf.setVisible(false);
				lblAmount_ATM.setVisible(true);
				labelAccountOwner.setVisible(false);
				comboBoxAccountOwner.setVisible(false);
				btnNewButton.setVisible(false);
				radioButton.setVisible(true);
				radioButton_1.setVisible(true);
				radioButton_2.setVisible(true);
				radioButton_3.setVisible(true);
				radioButton_4.setVisible(true);
				rdbtnOtherAmount.setVisible(true);
				lblSelectAccount.setVisible(true);
				comboBox.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				btnAccept.setVisible(false);
				btnNewButton_3.setVisible(false);
				
			}
		});
		btnAtm.setBounds(337, 13, 105, 36);
		panel_1.add(btnAtm);
		
		
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(th2.isAlive()){
					th2.stop();	
				}			
				ATM_choice(false);
				
				panel_AccDetail.setVisible(false);
				panel_Accounts.setVisible(true);
				lblCreditCardReceiver.setVisible(true);
				lblNameOfReceiver.setVisible(true);
				lblAmount.setVisible(true);
				lblHeader.setText("Money Transfer");
				textField_CCNumberReceiver.setVisible(true);
				textField_NameReceiver.setVisible(true);
				textField_AmountTransf.setVisible(true);
				lblAmount_ATM.setVisible(false);
				
				labelAccountOwner.setVisible(true);
				comboBoxAccountOwner.setVisible(true);
				btnNewButton.setVisible(false);
				radioButton.setVisible(false);
				radioButton_1.setVisible(false);
				radioButton_2.setVisible(false);
				radioButton_3.setVisible(false);
				radioButton_4.setVisible(false);
				rdbtnOtherAmount.setVisible(false);
				lblSelectAccount.setVisible(false);
				comboBox.setVisible(false);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnAccept.setVisible(true);
				btnAccept.setVisible(false);
				btnNewButton_3.setVisible(true);
				
			}
		});
		btnTransfer.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
		btnTransfer.setBounds(603, 13, 99, 36);
		panel_1.add(btnTransfer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(0, 0, 771, 69);
		panel_1.add(panel_2);
		
		JButton button = new JButton("New User!");
		button.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		button.setBounds(389, 326, 184, 39);
		panel_2.add(button);
		
		JLabel label = new JLabel("You are not a Client yet?");
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		label.setBounds(63, 301, 354, 39);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Become part of DeustoBank!");
		label_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		label_1.setBounds(63, 340, 354, 39);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 153, 255));
		panel_3.setBounds(0, 285, 660, 10);
		panel_2.add(panel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 771, 63);
		contentPane.add(panel);
		
		JLabel lblBankMovements = new JLabel("Bank Movements");
		lblBankMovements.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		panel.add(lblBankMovements);
	}
	public void ATM_choice(boolean ch){
		
		if(ch==true){
		
			
			if(radioButton.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				textField_Description.setVisible(false);
				this.repaint();
			}
			else if(radioButton_1.isSelected()&&!radioButton.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				textField_Description.setVisible(false);
				panel_Accounts.repaint();
				
			}
			else if(radioButton_2.isSelected()&&!radioButton_1.isSelected()&&!radioButton.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_1.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				textField_Description.setVisible(false);
				this.repaint();
			}
			else if(radioButton_3.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				textField_Description.setVisible(false);
				this.repaint();
			}
			else if(radioButton_4.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				textField_Description.setVisible(false);
				this.repaint();
			}
			else if(rdbtnOtherAmount.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!radioButton.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton.setEnabled(false);
				radioButton_4.setEnabled(false);
				textField_Description.setVisible(true);
				this.repaint();
			}
			else{
			radioButton.setEnabled(true);
			radioButton_1.setEnabled(true);
			radioButton_2.setEnabled(true);
			radioButton_3.setEnabled(true);
			radioButton_4.setEnabled(true);
			rdbtnOtherAmount.setEnabled(true);
			textField_Description.setVisible(false);
			this.repaint();
			}
			
		}else{
			radioButton.setVisible(false);
			radioButton_1.setVisible(false);
			radioButton_2.setVisible(false);
			radioButton_3.setVisible(false);
			radioButton_4.setVisible(false);
			rdbtnOtherAmount.setVisible(false);	
			textField_Description.setVisible(false);
		}
		
		
	}	
	
	public void showAccounts(){
		
		
		/**
		 * TODO
		 * Method to get accounts details given a UserID
		 */
		//Array bidimensional de objetos con los datos de la tabla 
		List<AccountDTO> listAccounts = c.getUserAccounts();
		
				Object[][] data = new Object[listAccounts.size()][5]; 
				for(int i =0; i<listAccounts.size(); i++){
					data[i][0] = listAccounts.get(i).getAccountID();
					data[i][1] = listAccounts.get(i).getTotalAmount();
					data[i][2] = listAccounts.get(i).getAccountType();
					data[i][3] = listAccounts.get(i).isFreezeAccount();
					data[i][4] = new Boolean(false);
				}

				//Array de String con los titulos de las columnas 
				String[] columnNames = {"Account Number", "Amount","Account Type", "Account Situation", "SELECT"};
			
				
		 model =  new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				if(column<2){
					return false;
				}
				else{
					return true;
				}
			
			} 
		
			
		/*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
		};
		
		 model.setDataVector(data, columnNames);
		 table = new JTable(model);
		 
		 DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	     rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

	        for (int columnIndex = 0; columnIndex < table.getColumnCount()-1; columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
		
				JScrollPane scrollPane = new JScrollPane(table);
				panel_AccDetail.add(scrollPane,BorderLayout.CENTER);
				
				panel_AccDetail.add(scrollPane);
		
	}
	
	Runnable r2 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				ATM_choice(true);
				
					
				}
			
		}
	};
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
}