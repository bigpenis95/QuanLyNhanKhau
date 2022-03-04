package QLNKview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connect.DBConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtNewPass;
	private JButton btnNewExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoiMatKhau(String name) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNewPass = new JLabel("New Password");
		lbNewPass.setBounds(10, 39, 99, 14);
		contentPane.add(lbNewPass);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setBounds(110, 36, 200, 20);
		contentPane.add(txtNewPass);
		
		JButton btnNewPass = new JButton("Change");
		btnNewPass.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("update password name " + name);
                    System.out.println("update password");
                    
                    Connection con = DBConnect.getConnection();
                    String sql = "UPDATE dbo.ACCOUNT SET PASS=?,CONFIRM=? WHERE USERNAME=?";
                    
                    PreparedStatement cp = con.prepareStatement(sql);
                    cp.setString(1, txtNewPass.getText());
                    cp.setString(2, txtNewPass.getText());
                    cp.setString(3,name);
                    cp.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewPass, "Password has been successfully changed");

				} catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewPass.setBounds(221, 78, 89, 23);
		contentPane.add(btnNewPass);
		
		btnNewExit = new JButton("Exit");
		btnNewExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewExit.setBounds(10, 77, 99, 24);
		contentPane.add(btnNewExit);
	}
}

