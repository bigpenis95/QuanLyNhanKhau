package QLNKview;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;

import Model.HoKhauDao;
import Model.NhanKhau;
import Model.NhanKhauDao;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Connect.DBConnect;
import Connect.MessageDialogHelper;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ThemMoiNhanKhau extends JPanel {
	private JTextField txtaddMakhaisinh;
	private JTextField txtaddHoten;
	private JTextField txtaddNgaysinh;
	private JTextField txtaddNoisinh;
	private JTextField txtaddQuequan;
	private JTextField txtaddNoiohientai;
	private JTextField txtaddCmnd;
	private JTextField txtaddNgaycap;
	private JTextField txtaddNoicapcmnd;
	private JTextField txtaddDantoc;
	private JTextField txtaddTongiao;
	private JTextField txtaddMahokhau;
	private JTextField txtaddQuanhevoichuho;
	public static String filename = null;
	public static byte[] person_image=null;

	/**
	 * Create the panel.
	 */
	public ThemMoiNhanKhau() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 khai sinh");
		lblNewLabel.setBounds(10, 77, 92, 14);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 1229, 2);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("TH\u00CAM M\u1EDAI NH\u00C2N KH\u1EA8U");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(233, 11, 318, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD T\u00EAn");
		lblNewLabel_2.setBounds(10, 124, 92, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_3.setBounds(10, 171, 92, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u01A1i sinh");
		lblNewLabel_4.setBounds(10, 216, 92, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Qu\u00EA qu\u00E1n");
		lblNewLabel_5.setBounds(10, 263, 92, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("N\u01A1i \u1EDF hi\u1EC7n t\u1EA1i");
		lblNewLabel_6.setBounds(10, 306, 92, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_7.setBounds(10, 354, 92, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CMND");
		lblNewLabel_8.setBounds(10, 404, 92, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Ngay c\u1EA5p");
		lblNewLabel_9.setBounds(10, 452, 92, 14);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(" N\u01A1i c\u1EA5p CMND");
		lblNewLabel_10.setBounds(10, 499, 92, 14);
		add(lblNewLabel_10);
		
		JLabel lblDnTc = new JLabel("D\u00E2n t\u1ED9c");
		lblDnTc.setBounds(379, 354, 122, 14);
		add(lblDnTc);
		
		JLabel lblTnGio = new JLabel("T\u00F4n gi\u00E1o");
		lblTnGio.setBounds(379, 404, 122, 14);
		add(lblTnGio);
		
		JLabel lblMHKhu = new JLabel("M\u00E3 h\u1ED9 kh\u1EA9u");
		lblMHKhu.setBounds(379, 452, 122, 14);
		add(lblMHKhu);
		
		JLabel lblNewLabel_14 = new JLabel("Quan h\u1EC7 v\u1EDBi ch\u1EE7 h\u1ED9");
		lblNewLabel_14.setBounds(379, 499, 122, 14);
		add(lblNewLabel_14);
		
		txtaddMakhaisinh = new JTextField();
		txtaddMakhaisinh.setBounds(94, 74, 226, 20);
		add(txtaddMakhaisinh);
		txtaddMakhaisinh.setColumns(10);
		
		txtaddHoten = new JTextField();
		txtaddHoten.setColumns(10);
		txtaddHoten.setBounds(94, 121, 226, 20);
		add(txtaddHoten);
		
		txtaddNgaysinh = new JTextField();
		txtaddNgaysinh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtaddNgaysinh.isVisible()) {
					String day = txtaddNgaysinh.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtaddNgaysinh.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtaddNgaysinh.requestFocus();
					}
				}
			}
		});
		txtaddNgaysinh.setColumns(10);
		txtaddNgaysinh.setBounds(94, 168, 226, 20);
		add(txtaddNgaysinh);
		
		txtaddNoisinh = new JTextField();
		txtaddNoisinh.setColumns(10);
		txtaddNoisinh.setBounds(94, 213, 226, 20);
		add(txtaddNoisinh);
		
		txtaddQuequan = new JTextField();
		txtaddQuequan.setColumns(10);
		txtaddQuequan.setBounds(94, 260, 226, 20);
		add(txtaddQuequan);
		
		txtaddNoiohientai = new JTextField();
		txtaddNoiohientai.setColumns(10);
		txtaddNoiohientai.setBounds(94, 303, 226, 20);
		add(txtaddNoiohientai);
		
		txtaddCmnd = new JTextField();
		txtaddCmnd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtaddCmnd.isVisible()) {
					String day = txtaddCmnd.getText();
					String reg = "^[0-9]{9,9}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng 9 số");
							txtaddCmnd.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtaddCmnd.requestFocus();
					}
				}
			}
		});
		txtaddCmnd.setColumns(10);
		txtaddCmnd.setBounds(94, 401, 226, 20);
		add(txtaddCmnd);
		
		txtaddNgaycap = new JTextField();
		txtaddNgaycap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtaddNgaycap.isVisible()) {
					String day = txtaddNgaycap.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtaddNgaycap.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtaddNgaycap.requestFocus();
					}
				}
			}
		});
		txtaddNgaycap.setColumns(10);
		txtaddNgaycap.setBounds(94, 449, 226, 20);
		add(txtaddNgaycap);
		
		txtaddNoicapcmnd = new JTextField();
		txtaddNoicapcmnd.setColumns(10);
		txtaddNoicapcmnd.setBounds(94, 496, 226, 20);
		add(txtaddNoicapcmnd);
		
		txtaddDantoc = new JTextField();
		txtaddDantoc.setColumns(10);
		txtaddDantoc.setBounds(500, 351, 226, 20);
		add(txtaddDantoc);
		
		txtaddTongiao = new JTextField();
		txtaddTongiao.setColumns(10);
		txtaddTongiao.setBounds(500, 401, 226, 20);
		add(txtaddTongiao);
		
		txtaddMahokhau = new JTextField();
		txtaddMahokhau.setColumns(10);
		txtaddMahokhau.setBounds(500, 449, 226, 20);
		add(txtaddMahokhau);
		
		txtaddQuanhevoichuho = new JTextField();
		txtaddQuanhevoichuho.setColumns(10);
		txtaddQuanhevoichuho.setBounds(500, 496, 226, 20);
		add(txtaddQuanhevoichuho);
		
		String s1[] = {"Nam","Nữ"};
		JComboBox txtaddGioitinh = new JComboBox(s1);
		txtaddGioitinh.setBounds(94, 350, 226, 22);
		add(txtaddGioitinh);
		
		JButton btnadd = new JButton("Th\u00EAm");
		btnadd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("add-user (1).png"))));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanKhau nk = new NhanKhau();
					nk.setMakhaisinh(Integer.parseInt(txtaddMakhaisinh.getText()));
					nk.setHoten(txtaddHoten.getText());
					nk.setNgaysinh(txtaddNgaysinh.getText());
					nk.setNoisinh(txtaddNoisinh.getText());
					nk.setQuequan(txtaddQuequan.getText());
					nk.setNoiohientai(txtaddNoiohientai.getText());
					nk.setGioitinh(txtaddGioitinh.getSelectedIndex());
					nk.setCmnd(Integer.parseInt(txtaddCmnd.getText()));
					nk.setNgaycap(txtaddNgaycap.getText());
					nk.setNoicap(txtaddNoicapcmnd.getText());
					nk.setDantoc(txtaddDantoc.getText());
					nk.setTongiao(txtaddTongiao.getText());
					nk.setQuanhevoichuho(txtaddQuanhevoichuho.getText());
					nk.setMahokhau(Integer.parseInt(txtaddMahokhau.getText()));
					nk.setAnh(person_image);
					if(NhanKhauDao.insert(nk)) {
						MessageDialogHelper.showMassageDialog(btnadd, "Nhan khau da duoc luu", "Thông Báo");
					} else {
						MessageDialogHelper.showMassageDialog(btnadd, "Nhan khau khong duoc luu do loi", "Lỗi");
					}
				} catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnadd, "lỗi", ex.getMessage());
				}
			}
		});
		btnadd.setBounds(622, 544, 104, 23);
		add(btnadd);
		
		JLabel lbAnh = new JLabel("");
		lbAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lbAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
		lbAnh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lbAnh.setBounds(500, 77, 226, 219);
		add(lbAnh);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("refresh.png"))));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaddMakhaisinh.setText("");
				txtaddHoten.setText("");
				txtaddNgaysinh.setText("");
				txtaddNoisinh.setText("");
				txtaddQuequan.setText("");
				txtaddGioitinh.setSelectedIndex(0);
				txtaddNoiohientai.setText("");
				txtaddCmnd.setText("");
				txtaddNoicapcmnd.setText("");
				txtaddDantoc.setText("");
				txtaddTongiao.setText("");
				txtaddQuanhevoichuho.setText("");
				txtaddMahokhau.setText("");
				txtaddNgaycap.setText("");
				lbAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
			}
		});
		btnLamMoi.setBounds(500, 544, 104, 23);
		add(btnLamMoi);
		
		JButton btnAnh = new JButton("Chọn ảnh");
		btnAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("new.png"))));
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				ImageIcon imageicon = new  ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbAnh.getWidth(),lbAnh.getHeight(),Image.SCALE_SMOOTH));
				lbAnh.setIcon(imageicon);
				
				try {
					File image = new File(filename);
					FileInputStream fis =  new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1023];
					for(int readNum; (readNum=fis.read(buf)) != -1;) {
						bos.write(buf,0,readNum);
					}
					person_image = bos.toByteArray();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		btnAnh.setBounds(551, 317, 129, 23);
		add(btnAnh);

	}
}
