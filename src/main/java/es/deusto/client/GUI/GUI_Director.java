package main.java.es.deusto.client.GUI;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.DTO.AccountDTO;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

class GUI_Director extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SavingName;
	private JTextField textField_SavingDescri;
	private JPasswordField textField_OldPass;
	private JPasswordField textField_NewPass1;
	private JPasswordField textField_NewPassRepeat;
	private String type = "";
	private JPanel panel_AccTable;
	private DefaultTableModel model;
	private JTable table;
	
	private controller c;
	
	public JButton btnNewButton;
	public JButton btnSave;

	/**
	 * Create the frame.
	 */
	public GUI_Director(final controller c) {
		
		this.c = c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 385);
		setSize(813, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel_Center = new JPanel();
		panel_Center.setBackground(new Color(204, 204, 204));
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setBounds(10, 11, 763, 42);
		panel_Center.add(panel_1);
		
		JLabel label_Title = new JLabel("Director\u00B4s Menu\r\n");
		label_Title.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_1.add(label_Title);
		
		final JPanel panel_SavingDesc = new JPanel();
		panel_SavingDesc.setBackground(new Color(204, 204, 255));
		panel_SavingDesc.setBounds(146, 59, 627, 425);
		panel_Center.add(panel_SavingDesc);
		panel_SavingDesc.setLayout(null);
		
		final JLabel lblSavingsPlanName = new JLabel("Savings Plan Name:");
		lblSavingsPlanName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblSavingsPlanName.setBounds(77, 108, 150, 14);
		panel_SavingDesc.add(lblSavingsPlanName);
		
		final JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblDescription.setBounds(77, 158, 150, 14);
		panel_SavingDesc.add(lblDescription);
		
		textField_SavingName = new JTextField();
		textField_SavingName.setColumns(10);
		textField_SavingName.setBounds(202, 102, 326, 20);
		panel_SavingDesc.add(textField_SavingName);
		
		textField_SavingDescri = new JTextField();
		textField_SavingDescri.setColumns(10);
		textField_SavingDescri.setBounds(202, 152, 326, 84);
		panel_SavingDesc.add(textField_SavingDescri);
		
		final JLabel lblOldPassword = new JLabel("Old password:");
		lblOldPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblOldPassword.setBounds(58, 133, 169, 14);
		panel_SavingDesc.add(lblOldPassword);
		
		textField_OldPass = new JPasswordField();
		textField_OldPass.setColumns(10);
		textField_OldPass.setBounds(202, 127, 326, 20);
		panel_SavingDesc.add(textField_OldPass);
		
		final JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewPassword.setBounds(58, 176, 169, 14);
		panel_SavingDesc.add(lblNewPassword);
		
		textField_NewPass1 = new JPasswordField();
		textField_NewPass1.setColumns(10);
		textField_NewPass1.setBounds(202, 170, 326, 20);
		panel_SavingDesc.add(textField_NewPass1);
		
		textField_NewPassRepeat = new JPasswordField();
		textField_NewPassRepeat.setColumns(10);
		textField_NewPassRepeat.setBounds(202, 216, 326, 20);
		panel_SavingDesc.add(textField_NewPassRepeat);
		
		final JLabel lblRepeatNewPassword = new JLabel("Repeat new password:");
		lblRepeatNewPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblRepeatNewPassword.setBounds(57, 222, 170, 14);
		panel_SavingDesc.add(lblRepeatNewPassword);
		
		panel_AccTable = new JPanel();
		panel_AccTable.setBounds(12, 30, 603, 273);
		panel_SavingDesc.add(panel_AccTable);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_AccTable.add(scrollPane);
		
		final JButton btnFreeze = new JButton("Freeze account");
		btnFreeze.setForeground(new Color(255, 0, 0));
		btnFreeze.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		btnFreeze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i<model.getRowCount() && model.getRowCount()!=0;i++){
					if(table.isRowSelected(i)){
						if(model.getValueAt(i, 5).equals(true)){
							controller.freezeAccount(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
							JOptionPane.showMessageDialog(null, "ACCOUNT: "+ String.valueOf(model.getValueAt(table.getSelectedRow(), 0)) + " FREEZED!");
						}
					}
				}
				
			}
		});
		btnFreeze.setBounds(112, 345, 169, 55);
		panel_SavingDesc.add(btnFreeze);
		
		final JButton btnUnfreezeAccount = new JButton("Unfreeze account");
		btnUnfreezeAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<model.getRowCount() && model.getRowCount()!=0;i++){
					if(table.isRowSelected(i)){
						if(model.getValueAt(i, 5).equals(true)){
							controller.unfreezeAccount(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
							JOptionPane.showMessageDialog(null, "ACCOUNT: "+ String.valueOf(model.getValueAt(table.getSelectedRow(), 0)) + " UNFREEZED!");
						}
					}
				}
			}
		});
		btnUnfreezeAccount.setForeground(new Color(0, 51, 255));
		btnUnfreezeAccount.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		btnUnfreezeAccount.setBounds(330, 345, 170, 55);
		panel_SavingDesc.add(btnUnfreezeAccount);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 153, 204));
		panel_3.setBounds(10, 64, 126, 399);
		panel_Center.add(panel_3);
		panel_3.setLayout(null);
		
		//Iniziate window
		panel_SavingDesc.setVisible(false);
		panel_AccTable.setVisible(false);
		
		
		JButton btnBack = new JButton("Back\r\n");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_MAIN frame = new GUI_MAIN(c);
				frame.setVisible(true);
				GUI_Director.this.dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnBack.setBounds(10, 312, 106, 23);
		panel_3.add(btnBack);
		
		btnSave = new JButton("Save\r\n");
		btnSave.setForeground(new Color(0, 204, 0));
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_SavingName.getText().isEmpty() && !textField_SavingDescri.getText().isEmpty()){
					controller.newaccountType(textField_SavingName.getText(), textField_SavingDescri.getText());
					JOptionPane.showMessageDialog(null, "New Saving Plan created!!");
				}
			}
		});
		btnSave.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnSave.setBounds(10, 346, 106, 23);
		panel_3.add(btnSave);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 138, 311);
		panel_3.add(panel);
		panel.setBackground(new Color(153, 153, 204));
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		menuBar.setBackground(new Color(204, 204, 204));
		menuBar.setBounds(10, 149, 116, 20);
		panel.add(menuBar);
		
		JMenu menu_Accounts = new JMenu("Accounts settings\r\n");
		menuBar.add(menu_Accounts);
		
		JMenuItem menuItem_CheckAccount = new JMenuItem("Check account");
		menuItem_CheckAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel_AccTable.setVisible(true);
				showAccounts();
				btnFreeze.setVisible(true);
				btnUnfreezeAccount.setVisible(true);
				
				panel_SavingDesc.setVisible(true);
				lblDescription.setVisible(false);
				lblNewPassword.setVisible(false);
				lblOldPassword.setVisible(false);
				lblRepeatNewPassword.setVisible(false);
				lblSavingsPlanName.setVisible(false);
				
				
				 
			
				  textField_SavingName.setVisible(false);
				  textField_SavingDescri.setVisible(false);
				  textField_OldPass.setVisible(false);
				  textField_NewPass1.setVisible(false);
				  textField_NewPassRepeat.setVisible(false);
				  btnNewButton.setVisible(false);
				  btnSave.setVisible(false);
				  
				  /*
				   * TODO METHOD TO ALTER PASSWORD OF DIRECTOR.
				   */
				
				  type = "Check account";
			}
		});
		menu_Accounts.add(menuItem_CheckAccount);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		menuBar_3.setBackground(new Color(204, 204, 204));
		menuBar_3.setBounds(10, 225, 116, 20);
		panel.add(menuBar_3);
		
		JMenu mnDirectorsSettings = new JMenu("Director\u00B4s settings\r\n");
		menuBar_3.add(mnDirectorsSettings);
		
		JMenuItem menuItem_AlterPassword = new JMenuItem("Alter password");
		menuItem_AlterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_AccTable.setVisible(false);
				btnFreeze.setVisible(false);
				btnUnfreezeAccount.setVisible(false);
				
				panel_SavingDesc.setVisible(true);
				lblDescription.setVisible(false);
				lblNewPassword.setVisible(true);
				lblOldPassword.setVisible(true);
				lblRepeatNewPassword.setVisible(true);
				lblSavingsPlanName.setVisible(false);
				 
			
				  textField_SavingName.setVisible(false);
				  textField_SavingDescri.setVisible(false);
				  textField_OldPass.setVisible(true);
				  textField_NewPass1.setVisible(true);
				  textField_NewPassRepeat.setVisible(true);
				  btnNewButton.setVisible(true);
				  btnSave.setVisible(false);
				  
				  
				  /*
				   * TODO METHOD TO ALTER PASSWORD OF DIRECTOR.
				   */
				
				  type = "Alter password";
			}
		});
		mnDirectorsSettings.add(menuItem_AlterPassword);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		menuBar_2.setBackground(new Color(204, 204, 204));
		menuBar_2.setBounds(10, 74, 126, 20);
		panel.add(menuBar_2);
		
		JMenu mnSavingsPlanSettings = new JMenu("Savings Plan Settings\r\n");
		menuBar_2.add(mnSavingsPlanSettings);
		
		JMenuItem menuItem_CreateSavingsPlan = new JMenuItem("Create Savings Plan");
		menuItem_CreateSavingsPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_AccTable.setVisible(false);
				btnFreeze.setVisible(false);
				btnUnfreezeAccount.setVisible(false);
				
				
				panel_SavingDesc.setVisible(true);
				lblDescription.setVisible(true);
				lblNewPassword.setVisible(false);
				lblOldPassword.setVisible(false);
				lblRepeatNewPassword.setVisible(false);
				lblSavingsPlanName.setVisible(true);
				 
				 
				  textField_SavingName.setVisible(true);
				  textField_SavingDescri.setVisible(true);
				  textField_OldPass.setVisible(false);
				  textField_NewPass1.setVisible(false);
				  textField_NewPassRepeat.setVisible(false);
				  btnNewButton.setVisible(false);
				  btnSave.setVisible(true);
				  
				  type = "Create Savings Plan";
				
			}
		});
		mnSavingsPlanSettings.add(menuItem_CreateSavingsPlan);
		
		
		btnNewButton = new JButton("Change");
		btnNewButton.setForeground(new Color(0, 204, 0));
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldP = String.valueOf(textField_OldPass.getPassword());
        		String newP = String.valueOf(textField_NewPass1.getPassword());
        		String newPR = String.valueOf(textField_NewPassRepeat.getPassword());
        		
					if(!oldP.isEmpty() && !newP.isEmpty() && !newPR.isEmpty()){
						if(newP.equals(newPR)){
							c.changePassword(oldP, newP);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "You have to fill the gaps first!!");
					}
				}
				
			});
		btnNewButton.setBounds(12, 345, 104, 25);
		panel_3.add(btnNewButton);
		
		
	}
public void showAccounts(){
		
		
	/**
	 * TODO
	 * Method to get accounts details given a UserID
	 */
	//Array bidimensional de objetos con los datos de la tabla 
	List<AccountDTO> listAccounts = c.getAllAccounts();
	
			Object[][] data = new Object[listAccounts.size()][6]; 
			for(int i =0; i<listAccounts.size(); i++){
				String date = listAccounts.get(i).getDay() + "/" + listAccounts.get(i).getMonth() + "/" + listAccounts.get(i).getYear() +
								" " + listAccounts.get(i).getHour() + ":" + listAccounts.get(i).getMinute();
				data[i][0] = listAccounts.get(i).getAccountID();
				data[i][1] = listAccounts.get(i).getTotalAmount();
				data[i][2] = listAccounts.get(i).getAccountType();
				data[i][3] = listAccounts.get(i).isFreezeAccount();
				data[i][4] = date;
				data[i][5] = new Boolean(false);
			}

			//Array de String con los titulos de las columnas 
			String[] columnNames = {"Account Number", "Amount","Account Type", "Account Situation", "Creation date", "SELECT"};
		
			
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
				
			table.setSize(12, 98);
			TableColumnModel columnModel = table.getColumnModel();

	        columnModel.getColumn(0).setPreferredWidth(230);
	        
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10,25,516,203);
				
				panel_AccTable.add(scrollPane,BorderLayout.CENTER);
				panel_AccTable.add(scrollPane);
				
				JLabel lblAccountNumber = new JLabel("Account Number:");
				lblAccountNumber.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
				lblAccountNumber.setBounds(177, 39, 183, 47);
				panel_AccTable.add(lblAccountNumber);
				
				JLabel lblBankTransactions = new JLabel("Bank Transactions");
				lblBankTransactions.setFont(new Font("Footlight MT Light", Font.BOLD, 28));
				lblBankTransactions.setBounds(244, 0, 248, 47);
				panel_AccTable.add(lblBankTransactions);
				
				
		
	}

	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
	
}