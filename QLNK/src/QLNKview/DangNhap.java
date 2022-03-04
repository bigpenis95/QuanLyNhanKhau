package QLNKview;

import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DangNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtlgUser;
	private JPasswordField txtlgPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Set icon
		URL urlIconSignup = DangNhap.class.getResource("loginicon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconSignup);
		this.setIconImage(img);
		
		JLabel lblgLogin = new JLabel("");
		lblgLogin.setForeground(new Color(119, 136, 153));
		lblgLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblgLogin.setBounds(340, 11, 173, 27);
		contentPane.add(lblgLogin);
		
		JLabel lblgUser = new JLabel("");
		lblgUser.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("user.png"))));
		lblgUser.setBounds(250, 70, 24, 27);
		contentPane.add(lblgUser);
		
		JLabel lblgPass = new JLabel("");
		lblgPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("pass.png"))));
		lblgPass.setBounds(250, 129, 24, 27);
		contentPane.add(lblgPass);
		
		txtlgUser = new JTextField();
		txtlgUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtlgUser.setText("");
			}
		});
		txtlgUser.setBackground(new Color(255, 153, 102));
		txtlgUser.setBorder(null);
		txtlgUser.setText("User");
		txtlgUser.setBounds(284, 70, 173, 24);
		contentPane.add(txtlgUser);
		txtlgUser.setColumns(10);
		
		txtlgPass = new JPasswordField();
		txtlgPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtlgPass.setText("");
			}
		});
		txtlgPass.setBorder(null);
		txtlgPass.setCaretColor(Color.BLACK);
		txtlgPass.setText("Password");
		txtlgPass.setBackground(new Color(255, 153, 102));
		txtlgPass.setBounds(284, 129, 173, 24);
		contentPane.add(txtlgPass);
		
		JButton btnlgSignup = new JButton("SIGNUP");
		btnlgSignup.setBackground(new Color(255, 153, 102));
		btnlgSignup.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnlgSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemTaiKhoan l=new ThemTaiKhoan();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnlgSignup.setBounds(250, 189, 96, 27);
		contentPane.add(btnlgSignup);
		
		JButton btnlgLogin = new JButton("LOG IN");
		btnlgLogin.setBackground(new Color(255, 153, 102));
		btnlgLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnlgLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnect.getConnection();
					String sql = "SELECT * FROM dbo.ACCOUNT WHERE USERNAME=? AND PASS=?";
					PreparedStatement ps = con.prepareCall(sql);
					ps.setString(1,txtlgUser.getText());
					ps.setString(2, txtlgPass.getText());
					ResultSet rs=ps.executeQuery();
					if(txtlgUser.getText().equals("") || txtlgPass.getText().equals("")) {
						JOptionPane.showMessageDialog(btnlgLogin,"Chưa nhập USER và PASS");
					}
					else if (rs.next()) {
						QuanLyNhanKhau ql=new QuanLyNhanKhau(txtlgUser.getText());
						ql.setVisible(true);
						ql.setLocationRelativeTo(null);
						dispose();
						JOptionPane.showMessageDialog(btnlgLogin,"Đăng nhập thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnlgLogin,"Đăng nhập thất bại");
					}
				} catch(Exception ex) {
				}
			}
		});
		btnlgLogin.setBounds(371, 189, 96, 27);
		contentPane.add(btnlgLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 220, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbliconlogin = new JLabel("");
		lbliconlogin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("iconlogin.png"))));
		lbliconlogin.setBounds(36, 26, 136, 134);
		panel.add(lbliconlogin);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(new Color(255, 153, 102));
		lblNewLabel.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 172, 136, 37);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(284, 95, 183, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(284, 154, 183, 2);
		contentPane.add(separator_1);
	}
}