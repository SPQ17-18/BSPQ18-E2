package main.java.es.deusto.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.DTO.BankTransactionDTO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accounts_GUI extends JFrame {

	private JPanel contentPane,panel;
	private DefaultTableModel model;
	private JTable table;
	
	private controller c;
	private String accountID;

	/**
	 * Create the frame.
	 */
	public Accounts_GUI(String nu, controller c) {
		
		this.c = c;
		this.accountID = nu;
		
		setTitle("DeustoBank");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\xabie\\git\\BSPQ18-E2\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 panel = new JPanel();
		 panel.setBackground(new Color(204, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		label.setBounds(372, 53, 224, 14);
		panel.add(label);
		
		label.setText(nu);
		showAccounts();
		
	}
public void showAccounts(){
		
		
		/**
		 * TODO
		 * Method to get all details of an acount given AccountNumber
		 */
		//Array bidimensional de objetos con los datos de la tabla 
		List<BankTransactionDTO> bankTransactions = c.getAccountBankTransactions(accountID);
	
				Object[][] data = new Object[bankTransactions.size()][4];
				for(int i =0; i<bankTransactions.size(); i++){
					String time = bankTransactions.get(i).getDay() + "/" + bankTransactions.get(i).getMonth() + "/" + bankTransactions.get(i).getYear()
								  + " - " + bankTransactions.get(i).getHour() + ":" +bankTransactions.get(i).getMinute();
					data[i][0] = bankTransactions.get(i).getTargetBankingAccount();
					data[i][1] = bankTransactions.get(i).getDesc();
					data[i][2] = time;
					data[i][3] = bankTransactions.get(i).getAmount();
				}
				
				//Array de ‘String’ con los titulos de las columnas 
				String[] columnNames = {"Target Banking Account","Description", "Time" , "Amount"};

		
		 model =  new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				if(column<4){
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
			
		
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(12, 98, 692, 324);
				panel.add(scrollPane,BorderLayout.CENTER);
				
				panel.add(scrollPane);
				
				JLabel lblAccountNumber = new JLabel("Account Number:");
				lblAccountNumber.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
				lblAccountNumber.setBounds(177, 39, 183, 47);
				panel.add(lblAccountNumber);
				
				JLabel lblBankTransactions = new JLabel("Bank Transactions");
				lblBankTransactions.setFont(new Font("Footlight MT Light", Font.BOLD, 28));
				lblBankTransactions.setBounds(244, 0, 248, 47);
				panel.add(lblBankTransactions);
				
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Accounts_GUI.this.dispose();
					}
				});
				button.setIcon(new ImageIcon(Accounts_GUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
				button.setSelectedIcon(new ImageIcon(Accounts_GUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
				button.setBounds(648, 13, 42, 30);
				panel.add(button);
		
	}
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
}