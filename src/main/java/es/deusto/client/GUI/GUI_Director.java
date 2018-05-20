//package main.java.es.deusto.client.GUI;
//
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JMenuBar;
//import java.awt.Color;
//import java.awt.Font;
//
//public class GUI_Director extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField textField_SavingName;
//	private JTextField textField_SavingDescri;
//	private JTextField textField_OldPass;
//	private JTextField textField_NewPass1;
//	private JTextField textField_NewPassRepeat;
//	private String type = "";
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Director frame = new GUI_Director();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public GUI_Director() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 517, 385);
//		setSize(760, 544);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		JPanel panel_Center = new JPanel();
//		panel_Center.setBackground(new Color(204, 204, 204));
//		contentPane.add(panel_Center, BorderLayout.CENTER);
//		panel_Center.setLayout(null);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(204, 153, 255));
//		panel_1.setBounds(10, 11, 714, 42);
//		panel_Center.add(panel_1);
//		
//		JLabel label_Title = new JLabel("Director\u00B4s Menu\r\n");
//		label_Title.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
//		panel_1.add(label_Title);
//		
//		final JPanel panel_SavingDesc = new JPanel();
//		panel_SavingDesc.setBackground(new Color(204, 204, 255));
//		panel_SavingDesc.setBounds(146, 59, 578, 425);
//		panel_Center.add(panel_SavingDesc);
//		panel_SavingDesc.setLayout(null);
//		
//		final JLabel lblSavingsPlanName = new JLabel("Savings Plan Name:");
//		lblSavingsPlanName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
//		lblSavingsPlanName.setBounds(77, 108, 150, 14);
//		panel_SavingDesc.add(lblSavingsPlanName);
//		
//		final JLabel lblDescription = new JLabel("Description:");
//		lblDescription.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
//		lblDescription.setBounds(77, 158, 150, 14);
//		panel_SavingDesc.add(lblDescription);
//		
//		textField_SavingName = new JTextField();
//		textField_SavingName.setColumns(10);
//		textField_SavingName.setBounds(202, 102, 326, 20);
//		panel_SavingDesc.add(textField_SavingName);
//		
//		textField_SavingDescri = new JTextField();
//		textField_SavingDescri.setColumns(10);
//		textField_SavingDescri.setBounds(202, 152, 326, 84);
//		panel_SavingDesc.add(textField_SavingDescri);
//		
//		final JLabel lblOldPassword = new JLabel("Old password:");
//		lblOldPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
//		lblOldPassword.setBounds(69, 133, 158, 14);
//		panel_SavingDesc.add(lblOldPassword);
//		
//		textField_OldPass = new JTextField();
//		textField_OldPass.setColumns(10);
//		textField_OldPass.setBounds(202, 127, 326, 20);
//		panel_SavingDesc.add(textField_OldPass);
//		
//		final JLabel lblNewPassword = new JLabel("New password:");
//		lblNewPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
//		lblNewPassword.setBounds(58, 176, 169, 14);
//		panel_SavingDesc.add(lblNewPassword);
//		
//		textField_NewPass1 = new JTextField();
//		textField_NewPass1.setColumns(10);
//		textField_NewPass1.setBounds(202, 170, 326, 20);
//		panel_SavingDesc.add(textField_NewPass1);
//		
//		textField_NewPassRepeat = new JTextField();
//		textField_NewPassRepeat.setColumns(10);
//		textField_NewPassRepeat.setBounds(202, 216, 326, 20);
//		panel_SavingDesc.add(textField_NewPassRepeat);
//		
//		final JLabel lblRepeatNewPassword = new JLabel("Repeat new password:");
//		lblRepeatNewPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
//		lblRepeatNewPassword.setBounds(57, 222, 170, 14);
//		panel_SavingDesc.add(lblRepeatNewPassword);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(153, 153, 204));
//		panel_3.setBounds(10, 381, 126, 82);
//		panel_Center.add(panel_3);
//		panel_3.setLayout(null);
//		
//		//Iniziate window
//		panel_SavingDesc.setVisible(false);
//		
//		JButton btnBack = new JButton("Back\r\n");
//		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		btnBack.setBounds(10, 11, 106, 23);
//		panel_3.add(btnBack);
//		
//		JButton btnSave = new JButton("Save\r\n");
//		btnSave.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		btnSave.setBounds(10, 45, 106, 23);
//		panel_3.add(btnSave);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(153, 153, 204));
//		panel.setBounds(10, 59, 138, 311);
//		panel_Center.add(panel);
//		panel.setLayout(null);
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		menuBar.setBackground(new Color(204, 204, 204));
//		menuBar.setBounds(10, 149, 116, 20);
//		panel.add(menuBar);
//		
//		JMenu menu_Accounts = new JMenu("Accounts settings\r\n");
//		menuBar.add(menu_Accounts);
//		
//		JMenu mnUnusedAccounts = new JMenu("Unused accounts");
//		menu_Accounts.add(mnUnusedAccounts);
//		
//		JMenuItem menuItem_FreezeAccout = new JMenuItem("Freeze Acount");
//		menuItem_FreezeAccout.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id_account_freeze = JOptionPane.showInputDialog("Insert Account ID: ");
//				
//				/*
//				 * TODO METHOD TO FREEZE AN ACCOUNT BASED ON AN ACCOUNT_ID
//				 */
//			}
//		});
//		mnUnusedAccounts.add(menuItem_FreezeAccout);
//		
//		JMenuItem mntmUnfreezeAccount = new JMenuItem("Unfreeze Account");
//		mntmUnfreezeAccount.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id_account_UNfreeze = JOptionPane.showInputDialog("Insert Account ID: ");
//				
//				/*
//				 * TODO METHOD TO UN-FREEZE AN ACCOUNT BASED ON AN ACCOUNT_ID
//				 */
//			}
//		});
//		mnUnusedAccounts.add(mntmUnfreezeAccount);
//		
//		JMenuItem mntmCheckFrozenAccounts = new JMenuItem("Check  Frozen accounts\r\n");
//		mnUnusedAccounts.add(mntmCheckFrozenAccounts);
//		
//		JMenuItem menuItem_CheckAccount = new JMenuItem("Check account");
//		menu_Accounts.add(menuItem_CheckAccount);
//		
//		JMenuBar menuBar_3 = new JMenuBar();
//		menuBar_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		menuBar_3.setBackground(new Color(204, 204, 204));
//		menuBar_3.setBounds(10, 225, 116, 20);
//		panel.add(menuBar_3);
//		
//		JMenu mnDirectorsSettings = new JMenu("Director\u00B4s settings\r\n");
//		menuBar_3.add(mnDirectorsSettings);
//		
//		JMenuItem menuItem_AlterPassword = new JMenuItem("Alter password");
//		menuItem_AlterPassword.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				panel_SavingDesc.setVisible(true);
//				lblConditions.setVisible(false);
//				lblDescription.setVisible(false);
//				lblNewPassword.setVisible(true);
//				lblOldPassword.setVisible(true);
//				lblRates.setVisible(false);
//				lblRepeatNewPassword.setVisible(true);
//				lblSavingsPlanId.setVisible(false);
//				lblSavingsPlanName.setVisible(false);
//				 
//				  textField_SavingID.setVisible(false);
//				  textField_SavingName.setVisible(false);
//				  textField_SavingDescri.setVisible(false);
//				  textField_SavingCondi.setVisible(false);
//				  textField_SavingRate.setVisible(false);
//				  textField_OldPass.setVisible(true);
//				  textField_NewPass1.setVisible(true);
//				  textField_NewPassRepeat.setVisible(true);
//				  
//				  /*
//				   * TODO METHOD TO ALTER PASSWORD OF DIRECTOR.
//				   */
//				
//				  type = "Alter password";
//			}
//		});
//		mnDirectorsSettings.add(menuItem_AlterPassword);
//		
//		JMenuBar menuBar_2 = new JMenuBar();
//		menuBar_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		menuBar_2.setBackground(new Color(204, 204, 204));
//		menuBar_2.setBounds(10, 74, 126, 20);
//		panel.add(menuBar_2);
//		
//		JMenu mnSavingsPlanSettings = new JMenu("Savings Plan Settings\r\n");
//		menuBar_2.add(mnSavingsPlanSettings);
//		
//		JMenuItem menuItem_CreateSavingsPlan = new JMenuItem("Create Savings Plan");
//		menuItem_CreateSavingsPlan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				panel_SavingDesc.setVisible(true);
//				lblConditions.setVisible(true);
//				lblDescription.setVisible(true);
//				lblNewPassword.setVisible(false);
//				lblOldPassword.setVisible(false);
//				lblRates.setVisible(true);
//				lblRepeatNewPassword.setVisible(false);
//				lblSavingsPlanId.setVisible(true);
//				lblSavingsPlanName.setVisible(true);
//				 
//				  textField_SavingID.setVisible(true);
//				  textField_SavingName.setVisible(true);
//				  textField_SavingDescri.setVisible(true);
//				  textField_SavingCondi.setVisible(true);
//				  textField_SavingRate.setVisible(true);
//				  textField_OldPass.setVisible(false);
//				  textField_NewPass1.setVisible(false);
//				  textField_NewPassRepeat.setVisible(false);
//				
//				  type = "Create Savings Plan";
//				
//			}
//		});
//		mnSavingsPlanSettings.add(menuItem_CreateSavingsPlan);
//		
//		JMenuItem menuItem_AlterSavingsPlan = new JMenuItem("Alter Savings Plan");
//		menuItem_AlterSavingsPlan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id_SavingPlan = JOptionPane.showInputDialog("Insert Saving Plan�s  ID: ");
//				
//				/*
//				 * TODO METHOD TO ALTER SAVING PLAN. METHOD TO CHECK IF SAVING PLAN EXISTS.
//				 */
//				panel_SavingDesc.setVisible(true);
//				lblConditions.setVisible(true);
//				lblDescription.setVisible(true);
//				lblNewPassword.setVisible(false);
//				lblOldPassword.setVisible(false);
//				lblRates.setVisible(true);
//				lblRepeatNewPassword.setVisible(false);
//				lblSavingsPlanId.setVisible(true);
//				lblSavingsPlanName.setVisible(true);
//				 
//				  textField_SavingID.setVisible(true);
//				  textField_SavingID.setText(id_SavingPlan);
//				  textField_SavingID.setEditable(false);
//				  textField_SavingName.setVisible(true);
//				  textField_SavingDescri.setVisible(true);
//				  textField_SavingCondi.setVisible(true);
//				  textField_SavingRate.setVisible(true);
//				  textField_OldPass.setVisible(false);
//				  textField_NewPass1.setVisible(false);
//				  textField_NewPassRepeat.setVisible(false);
//				  
//				
//				  type = "Alter Savings Plan";
//			}
//		});
//		mnSavingsPlanSettings.add(menuItem_AlterSavingsPlan);
//		
//		JMenuItem mntmEraseSavingsPlan = new JMenuItem("Erase Savings Plan");
//		mnSavingsPlanSettings.add(mntmEraseSavingsPlan);
//		
//		
//	}
//}