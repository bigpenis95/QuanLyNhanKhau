package QLNKview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connect.DBConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ThemTaiKhoan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel content;
	private JTextField txtsUser;
	private JTextField txtsGmail;
	private JPasswordField txtsPass;
	private JPasswordField txtsConfirmPass;
	private JButton btnsLogin;
	private JPanel panel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lbliconsignup;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemTaiKhoan frame = new ThemTaiKhoan();
					frame.setLocationRelativeTo(null);
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
	public ThemTaiKhoan() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 300);
		content = new JPanel();
		content.setBackground(new Color(255, 153, 102));
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(null);
		
		//Set icon
		URL urlIconSignup = ThemTaiKhoan.class.getResource("signup.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconSignup);
		this.setIconImage(img);
		
		JLabel lbsUser = new JLabel("");
		lbsUser.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("user.png"))));
		lbsUser.setBounds(229, 45, 31, 24);
		content.add(lbsUser);
		
		JLabel lbsGmail = new JLabel("");
		lbsGmail.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("Gmail.png"))));
		lbsGmail.setBounds(229, 80, 31, 26);
		content.add(lbsGmail);
		
		JLabel lbsPass = new JLabel("");
		lbsPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("pass.png"))));
		lbsPass.setBounds(229, 116, 31, 29);
		content.add(lbsPass);
		
		JLabel lbsConfirmPass = new JLabel("");
		lbsConfirmPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("confirmpass.png"))));
		lbsConfirmPass.setBounds(229, 160, 31, 26);
		content.add(lbsConfirmPass);
		
		txtsUser = new JTextField();
		txtsUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsUser.setText("");
			}
		});
		txtsUser.setText("User");
		txtsUser.setBorder(null);
		txtsUser.setBackground(new Color(255, 153, 102));
		txtsUser.setBounds(257, 45, 205, 20);
		content.add(txtsUser);
		txtsUser.setColumns(10);
		
		txtsGmail = new JTextField();
		txtsGmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsGmail.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtsGmail.isVisible()) {
					String day = txtsGmail.getText();
					String reg = "^\\w+[a-z0-9]*@gmail.com$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: kimbii@gmail.com");
							txtsGmail.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtsGmail.requestFocus();
					}
				}
			}
		});
		txtsGmail.setText("Gmail");
		txtsGmail.setBorder(null);
		txtsGmail.setBackground(new Color(255, 153, 102));
		txtsGmail.setBounds(257, 80, 205, 20);
		content.add(txtsGmail);
		txtsGmail.setColumns(10);
		
		txtsPass = new JPasswordField();
		txtsPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsPass.setText("");
			}
			
		});
		txtsPass.setText("Password");
		txtsPass.setBorder(null);
		txtsPass.setBackground(new Color(255, 153, 102));
		txtsPass.setBounds(257, 117, 205, 20);
		content.add(txtsPass);
		
		txtsConfirmPass = new JPasswordField();
		txtsConfirmPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsConfirmPass.setText("");
			}
		});
		txtsConfirmPass.setText("Password");
		txtsConfirmPass.setBorder(null);
		txtsConfirmPass.setBackground(new Color(255, 153, 102));
		txtsConfirmPass.setBounds(257, 166, 205, 20);
		content.add(txtsConfirmPass);
		
		btnsLogin = new JButton("LOG IN");
		btnsLogin.setBackground(new Color(255, 153, 102));
		btnsLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap l=new DangNhap();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnsLogin.setBounds(229, 215, 97, 35);
		content.add(btnsLogin);
		
		JButton btnsSignup = new JButton("SIGNUP");
		btnsSignup.setBackground(new Color(255, 153, 102));
		btnsSignup.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				int dk=JOptionPane.showConfirmDialog(btnsSignup,"Bạn có muốn đăng ký","Confirm",JOptionPane.YES_NO_OPTION);
//				if(dk!=JOptionPane.YES_OPTION) {
//					return;
//				}
				try {
					Connection con = DBConnect.getConnection();
			        String sql="INSERT INTO dbo.ACCOUNT VALUES (?,?,?,?)";
			        PreparedStatement ps=con.prepareStatement(sql);
			        ps.setString(1, txtsUser.getText());
			        ps.setString(2, txtsGmail.getText());
			        ps.setString(3, txtsPass.getText());
			        ps.setString(4, txtsConfirmPass.getText());
			        
			        int n=ps.executeUpdate();
			        
			        if(txtsUser.getText().equals("") | txtsGmail.getText().equals("") | txtsPass.getText().equals("") | txtsConfirmPass.getText().equals("")) {
			        	JOptionPane.showMessageDialog(btnsSignup,"Không để thông tin trống");
			        	Statement statement = con.createStatement();
			        	String delete = "DELETE FROM dbo.ACCOUNT " +
			                    		"WHERE USERNAME = '' OR GMAIL='' OR PASS='' OR CONFIRM=''";
			        	statement.executeUpdate(delete);
			        }
			        else if (n!=0 && txtsPass.getText().equals(txtsConfirmPass.getText())) {
			        	JOptionPane.showMessageDialog(btnsSignup,"Đăng ký thành công");
			        }
			        else {
			        	JOptionPane.showMessageDialog(btnsSignup,"Đăng ký thất bại");
			        	Statement statement = con.createStatement();
			        	String delete = "DELETE FROM dbo.ACCOUNT "+
			        					"WHERE PASS <> CONFIRM";
			        	statement.executeUpdate(delete);
			        }
				} catch (Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(btnsSignup, "Đã tồn tại user");
				}
			}
		});
		btnsSignup.setBounds(365, 215, 97, 35);
		content.add(btnsSignup);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 0, 219, 261);
		content.add(panel);
		panel.setLayout(null);
		
		lbliconsignup = new JLabel("");
		lbliconsignup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("signup-icon.png"))));
		lbliconsignup.setBounds(47, 31, 133, 128);
		panel.add(lbliconsignup);
		
		lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setForeground(new Color(255, 153, 102));
		lblNewLabel.setFont(new Font("Tekton Pro", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 170, 115, 40);
		panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(257, 67, 205, 2);
		content.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(257, 104, 205, 2);
		content.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(257, 143, 205, 2);
		content.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(257, 186, 205, 2);
		content.add(separator_3);
	}
}

