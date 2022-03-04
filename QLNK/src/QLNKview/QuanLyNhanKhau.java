package QLNKview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

public class QuanLyNhanKhau extends JFrame {
	private JPanel childPanel;
	private JPanel MainPanel;
	private JPanel SubPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanKhau frame = new QuanLyNhanKhau();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public QuanLyNhanKhau() {
		
	}

	/**
	 * Create the frame.
	 */
	public QuanLyNhanKhau(String userSes) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1362, 777);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		SubPanel = new JPanel();
		SubPanel.setBounds(222, 101, 1124, 637);
		MainPanel.add(SubPanel);
		SubPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Quản Lý Nhân Khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		SubPanel.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 94, 1360, 2);
		MainPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 94, 218, 644);
		MainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" QUẢN LÝ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 117, 27);
		panel.add(lblNewLabel);
		
		JLabel lblquanlynk = new JLabel("Nhân khẩu");
		lblquanlynk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("people.png"))));
		lblquanlynk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPanel(new TraCuuNhanKhau());
			}
		});
		lblquanlynk.setBounds(20, 37, 198, 54);
		panel.add(lblquanlynk);
		
		JLabel lblquanlyhk = new JLabel("Hộ khẩu");
		lblquanlyhk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPanel(new QLHK());
				
			}
		});
		lblquanlyhk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("book.png"))));
		lblquanlyhk.setBounds(20, 102, 198, 64);
		panel.add(lblquanlyhk);
		
		JLabel lblNewLabel_3 = new JLabel("THỦ TỤC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 177, 117, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lbladdcongdan = new JLabel("Thêm mới công dân");
		lbladdcongdan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("add-user.png"))));
		lbladdcongdan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPanel(new ThemMoiNhanKhau());
			}
		});
		lbladdcongdan.setBounds(20, 210, 198, 56);
		panel.add(lbladdcongdan);
		
		JLabel lblNewLabel_5 = new JLabel("ĐĂNG KÝ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 277, 97, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lbladdhk = new JLabel("Hộ khẩu");
		lbladdhk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("book.png"))));
		lbladdhk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPanel(new DangKyHoKhau());
			}
		});
		lbladdhk.setBounds(20, 309, 198, 56);
		panel.add(lbladdhk);
		
		JLabel lblNewLabel_1 = new JLabel("HELP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 376, 117, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lbldoimk = new JLabel("Đổi mật khẩu");
		lbldoimk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("changepass.png"))));
		lbldoimk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoiMatKhau bo = new DoiMatKhau(userSes);
                bo.setTitle("Đổi mật khẩu");
                bo.setLocationRelativeTo(null);
                bo.setVisible(true);
			}
		});
		lbldoimk.setBounds(20, 409, 198, 50);
		panel.add(lbldoimk);
		JLabel lbldangxuat = new JLabel("ĐĂNG XUẤT");
		lbldangxuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("logout.png"))));
		lbldangxuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhap l=new DangNhap();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		lbldangxuat.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbldangxuat.setForeground(Color.RED);
		lbldangxuat.setBackground(Color.WHITE);
		lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldangxuat.setHorizontalAlignment(SwingConstants.CENTER);
		lbldangxuat.setBounds(10, 518, 198, 50);
		panel.add(lbldangxuat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 0, 1346, 83);
		MainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("QUẢN LÝ NHÂN KHẨU");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 1346, 83);
		panel_1.add(lblNewLabel_4);
	}
	public void showPanel(JPanel panel) {
		childPanel = panel;
		SubPanel.removeAll();
		SubPanel.add(childPanel);
		SubPanel.validate();
	}
}