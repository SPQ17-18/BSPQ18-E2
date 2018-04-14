package main.java.GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class GUI_UserMenu extends JFrame {

	private JPanel contentPane;
	private JTable tableAccountsDetails;
	private JPanel panel_Accounts;
	private JTextField textField_CCNumberReceiver;
	private JTextField textField_AmountTransf;
	private JTextField textField_Description;
	private JRadioButton radioButton = new JRadioButton("10");
	private JRadioButton radioButton_1 = new JRadioButton("15");
	private JRadioButton radioButton_2 = new JRadioButton("20");
	private JRadioButton radioButton_3 = new JRadioButton("40");
	private JRadioButton radioButton_4 = new JRadioButton("50");
	private JRadioButton rdbtnOtherAmount = new JRadioButton("Other amount");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_UserMenu frame = new GUI_UserMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_UserMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(380, 11, 121, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("X");
		lblName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblName.setBounds(10, 11, 101, 14);
		panel.add(lblName);
		
		JLabel lblCreditCard = new JLabel("y");
		lblCreditCard.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblCreditCard.setBounds(10, 32, 101, 14);
		panel.add(lblCreditCard);
		
		JLabel labelMoneyAmount = new JLabel("X");
		labelMoneyAmount.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		labelMoneyAmount.setBounds(10, 57, 101, 14);
		panel.add(labelMoneyAmount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 37, 360, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 0, 360, 37);
		contentPane.add(panel_3);
		
		JLabel lblDeustobank = new JLabel("DeustoBank");
		lblDeustobank.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_3.add(lblDeustobank);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(417, 103, 97, 225);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnSettings.setBounds(0, 141, 97, 23);
		panel_4.add(btnSettings);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnLogout.setBounds(0, 177, 97, 23);
		panel_4.add(btnLogout);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAccept.setBounds(0, 101, 97, 23);
		panel_4.add(btnAccept);
		
		panel_Accounts = new JPanel();
		panel_Accounts.setBounds(10, 98, 397, 230);
		contentPane.add(panel_Accounts);
		panel_Accounts.setLayout(null);
		
		tableAccountsDetails = new JTable();
		tableAccountsDetails.setBounds(198, 5, 0, 0);
		panel_Accounts.add(tableAccountsDetails);
		
		panel_Accounts.setVisible(false);
		
		final JLabel lblCreditCardReceiver = new JLabel("CreditCard Number of Receiver:");
		lblCreditCardReceiver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblCreditCardReceiver.setBounds(32, 55, 191, 14);
		panel_Accounts.add(lblCreditCardReceiver);
		
		final JLabel lblNameOfReceiver = new JLabel("Name of Receiver:");
		lblNameOfReceiver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNameOfReceiver.setBounds(32, 80, 166, 14);
		panel_Accounts.add(lblNameOfReceiver);
		
		final JLabel lblAmount = new JLabel("Amount:\r\n");
		lblAmount.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblAmount.setBounds(32, 105, 166, 14);
		panel_Accounts.add(lblAmount);
		
		final JLabel lblDecription = new JLabel("Decription:");
		lblDecription.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblDecription.setBounds(32, 144, 166, 14);
		panel_Accounts.add(lblDecription);
		
		final JLabel lblHeader = new JLabel("Money Transfer");
		lblHeader.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblHeader.setBounds(126, 11, 146, 21);
		panel_Accounts.add(lblHeader);
		
		textField_CCNumberReceiver = new JTextField();
		textField_CCNumberReceiver.setBounds(233, 53, 136, 20);
		panel_Accounts.add(textField_CCNumberReceiver);
		textField_CCNumberReceiver.setColumns(10);
		
		final JTextField textField_NameReceiver = new JTextField();
		textField_NameReceiver.setColumns(10);
		textField_NameReceiver.setBounds(233, 78, 136, 20);
		panel_Accounts.add(textField_NameReceiver);
		
		textField_AmountTransf = new JTextField();
		textField_AmountTransf.setColumns(10);
		textField_AmountTransf.setBounds(233, 103, 136, 20);
		panel_Accounts.add(textField_AmountTransf);
		
		textField_Description = new JTextField();
		textField_Description.setColumns(10);
		textField_Description.setBounds(126, 142, 243, 77);
		panel_Accounts.add(textField_Description);
		
		final JLabel lblAmount_ATM = new JLabel("Amount:");
		lblAmount_ATM.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblAmount_ATM.setBounds(29, 52, 123, 21);
		panel_Accounts.add(lblAmount_ATM);
		
		
		radioButton.setBounds(185, 52, 136, 23);
		panel_Accounts.add(radioButton);
		
		
		radioButton_1.setBounds(185, 76, 109, 23);
		panel_Accounts.add(radioButton_1);
		
		radioButton_2.setBounds(185, 101, 109, 23);
		panel_Accounts.add(radioButton_2);
		
		radioButton_3.setBounds(185, 126, 109, 23);
		panel_Accounts.add(radioButton_3);
		
		radioButton_4.setBounds(185, 152, 109, 23);
		panel_Accounts.add(radioButton_4);
		
		rdbtnOtherAmount.setBounds(185, 178, 109, 23);
		panel_Accounts.add(rdbtnOtherAmount);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Accounts.setVisible(true);
				tableAccountsDetails.setVisible(true);
				lblCreditCardReceiver.setVisible(false);
				lblNameOfReceiver.setVisible(false);
				lblAmount.setVisible(false);
				lblDecription.setVisible(false);
				lblHeader.setText("Accounts");
				textField_CCNumberReceiver.setVisible(false);
				textField_NameReceiver.setVisible(false);
				textField_AmountTransf.setVisible(false);
				textField_Description.setVisible(false);
				lblAmount_ATM.setVisible(false);
				ATM_choice(false);
			}
		});
		btnAccounts.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAccounts.setBounds(10, 26, 89, 23);
		panel_1.add(btnAccounts);
		
		JButton btnAtm = new JButton("ATM");
		btnAtm.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_Accounts.setVisible(true);
				tableAccountsDetails.setVisible(false);
				lblCreditCardReceiver.setVisible(false);
				lblNameOfReceiver.setVisible(false);
				lblAmount.setVisible(false);
				lblDecription.setVisible(false);
				lblHeader.setText("ATM");
				textField_CCNumberReceiver.setVisible(false);
				textField_NameReceiver.setVisible(false);
				textField_AmountTransf.setVisible(false);
				textField_Description.setVisible(false);
				lblAmount_ATM.setVisible(true);
				ATM_choice(true);
			}
		});
		btnAtm.setBounds(131, 26, 89, 23);
		panel_1.add(btnAtm);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Accounts.setVisible(true);
				tableAccountsDetails.setVisible(false);
				lblCreditCardReceiver.setVisible(true);
				lblNameOfReceiver.setVisible(true);
				lblAmount.setVisible(false);
				lblDecription.setVisible(true);
				lblHeader.setText("Money Transfer");
				textField_CCNumberReceiver.setVisible(true);
				textField_NameReceiver.setVisible(true);
				textField_AmountTransf.setVisible(true);
				textField_Description.setVisible(true);
				lblAmount_ATM.setVisible(false);
				ATM_choice(false);
				
			}
		});
		btnTransfer.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnTransfer.setBounds(261, 26, 89, 23);
		panel_1.add(btnTransfer);
	}
	public void ATM_choice(boolean ch){
		
		if(ch==true){
			radioButton.setVisible(true);
			radioButton_1.setVisible(true);
			radioButton_2.setVisible(true);
			radioButton_3.setVisible(true);
			radioButton_4.setVisible(true);
			rdbtnOtherAmount.setVisible(true);
			
			if(radioButton.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				this.repaint();
			}
			else if(radioButton_1.isSelected()&&!radioButton.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				panel_Accounts.repaint();
				
			}
			else if(radioButton_2.isSelected()&&!radioButton_1.isSelected()&&!radioButton.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_1.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				this.repaint();
			}
			else if(radioButton_3.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton.isSelected()&&!radioButton_4.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton.setEnabled(false);
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_4.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				this.repaint();
			}
			else if(radioButton_4.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton.isSelected()&&!rdbtnOtherAmount.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton.setEnabled(false);
				rdbtnOtherAmount.setEnabled(false);
				this.repaint();
			}
			else if(rdbtnOtherAmount.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
					&&!radioButton_3.isSelected()&&!radioButton_4.isSelected()&&!radioButton.isSelected()){
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton.setEnabled(false);
				radioButton_4.setEnabled(false);
				this.repaint();
			}
			else{
			radioButton.setEnabled(true);
			radioButton_1.setEnabled(true);
			radioButton_2.setEnabled(true);
			radioButton_3.setEnabled(true);
			radioButton_4.setEnabled(true);
			rdbtnOtherAmount.setEnabled(true);
			this.repaint();
		}
		}
		}
		
		
		
}
