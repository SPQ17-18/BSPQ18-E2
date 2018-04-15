package main.java.es.deusto.client.GUI;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class GUI_MAIN extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JPasswordField passwordField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI_MAIN frame = new GUI_MAIN();
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
		public GUI_MAIN() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 511, 368);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			JLabel lblDeustobank = new JLabel("DeustoBank");
			lblDeustobank.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
			panel.add(lblDeustobank);
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.SOUTH);
			
			JPanel panel_2 = new JPanel();
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			
			JLabel lblWelcomeToThe = new JLabel("Welcome to the most innovative banking system");
			lblWelcomeToThe.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
			lblWelcomeToThe.setBounds(117, 0, 255, 14);
			panel_2.add(lblWelcomeToThe);
			
			JLabel lblIdNumber = new JLabel("ID Number:");
			lblIdNumber.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
			lblIdNumber.setBounds(61, 48, 88, 14);
			panel_2.add(lblIdNumber);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
			lblPassword.setBounds(61, 87, 100, 14);
			panel_2.add(lblPassword);
			
			JLabel lblCreditcardNumber = new JLabel("CreditCard Number:");
			lblCreditcardNumber.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
			lblCreditcardNumber.setBounds(61, 121, 152, 14);
			panel_2.add(lblCreditcardNumber);
			
			textField = new JTextField();
			textField.setBounds(236, 48, 152, 20);
			panel_2.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(236, 121, 152, 20);
			panel_2.add(textField_1);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(236, 87, 152, 20);
			panel_2.add(passwordField);
			
			JButton btnEnter = new JButton("Enter");
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Check if everything is correct: it exists in the data Base
					/**
					 * We stil haven�t done the DB therefore i will put like number and password were introduced correctly
					 */
					
					GUI_UserMenu frame = new GUI_UserMenu();
					frame.setVisible(true);
					GUI_MAIN.this.dispose();	
				}
			});
			btnEnter.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			btnEnter.setBounds(118, 170, 124, 23);
			panel_2.add(btnEnter);
			
			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
			btnLogin.setBounds(264, 170, 124, 23);
			panel_2.add(btnLogin);
			
			JButton btnForgotYourPassword = new JButton("Forgot your password?");
			btnForgotYourPassword.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
			btnForgotYourPassword.setBounds(185, 204, 152, 30);
			panel_2.add(btnForgotYourPassword);
		}
	}
