package QLNKview;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import Model.HoKhau;
import Model.HoKhauDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.Normalizer.Form;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Connect.MessageDialogHelper;


import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DangKyHoKhau extends JPanel {
	private JTextField txtaddMahokhau;
	private JTextField txtadddantoc;
	private JTextField txtaddHotenchuho;
	private JTextField txtaddNgaysinh;
	private JTextField txtaddQuoctich;
	private JTextField txtaddNgaydangky;
	private JTextField txtaddDiachi;
	public static String filename = null;
	public static byte[] person_image=null;

	/**
	 * Create the panel.
	 */
	public DangKyHoKhau() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u0103ng k\u00FD h\u1ED9 kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 739, 325);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 h\u1ED9 kh\u1EA9u");
		lblNewLabel.setBounds(10, 37, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHTnCh = new JLabel("H\u1ECD t\u00EAn ch\u1EE7 h\u1ED9");
		lblHTnCh.setBounds(254, 66, 77, 14);
		panel.add(lblHTnCh);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setBounds(10, 66, 77, 14);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		lblNgySinh.setBounds(254, 97, 77, 14);
		panel.add(lblNgySinh);
		
		JLabel lblDnTc = new JLabel("D\u00E2n t\u1ED9c");
		lblDnTc.setBounds(10, 138, 77, 14);
		panel.add(lblDnTc);
		
		JLabel lblQucTch = new JLabel("Qu\u1ED1c t\u1ECBch");
		lblQucTch.setBounds(254, 138, 77, 14);
		panel.add(lblQucTch);
		
		JLabel lblNgyngK = new JLabel("Ng\u00E0y \u0111\u0103ng k\u00FD");
		lblNgyngK.setBounds(10, 183, 77, 14);
		panel.add(lblNgyngK);
		
		txtaddMahokhau = new JTextField();
		txtaddMahokhau.setBounds(86, 36, 158, 20);
		panel.add(txtaddMahokhau);
		txtaddMahokhau.setColumns(10);
		
		txtadddantoc = new JTextField();
		txtadddantoc.setColumns(10);
		txtadddantoc.setBounds(86, 135, 158, 20);
		panel.add(txtadddantoc);
		
		txtaddHotenchuho = new JTextField();
		txtaddHotenchuho.setColumns(10);
		txtaddHotenchuho.setBounds(334, 63, 158, 20);
		panel.add(txtaddHotenchuho);
		
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
		txtaddNgaysinh.setBounds(334, 94, 158, 20);
		panel.add(txtaddNgaysinh);
		
		txtaddQuoctich = new JTextField();
		txtaddQuoctich.setColumns(10);
		txtaddQuoctich.setBounds(334, 135, 158, 20);
		panel.add(txtaddQuoctich);
		
		txtaddNgaydangky = new JTextField();
		txtaddNgaydangky.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtaddNgaydangky.isVisible()) {
					String day = txtaddNgaydangky.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtaddNgaydangky.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtaddNgaydangky.requestFocus();
					}
				}
			}
		});
		txtaddNgaydangky.setColumns(10);
		txtaddNgaydangky.setBounds(86, 180, 406, 20);
		panel.add(txtaddNgaydangky);
		
		txtaddDiachi = new JTextField();
		txtaddDiachi.setColumns(10);
		txtaddDiachi.setBounds(86, 217, 406, 20);
		panel.add(txtaddDiachi);
		
		JLabel lblNewLabel_6_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_6_1.setBounds(10, 220, 77, 14);
		panel.add(lblNewLabel_6_1);
		
		String s1[] = {"Nam","Nữ"};
		JComboBox txtaddgioitinh = new JComboBox(s1);
		txtaddgioitinh.setBounds(86, 62, 158, 22);
		panel.add(txtaddgioitinh);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaddMahokhau.setText("");
				txtaddHotenchuho.setText("");
				txtaddNgaysinh.setText("");
				txtaddQuoctich.setText("");
				txtaddgioitinh.setSelectedIndex(0);
				txtaddDiachi.setText("");
				txtadddantoc.setText("");
				txtaddNgaydangky.setText("");
			}
		});
		btnLamMoi.setBounds(270, 252, 89, 23);
		panel.add(btnLamMoi);
		
		JButton btnDangky = new JButton("\u0110\u0103ng k\u00FD");
		btnDangky.setBounds(386, 252, 89, 23);
		panel.add(btnDangky);
		
		JLabel lbAnh = new JLabel("");
		lbAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lbAnh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lbAnh.setBounds(503, 18, 226, 219);
		panel.add(lbAnh);
		
		JButton btnaddAnh = new JButton("Chọn ảnh");
		btnaddAnh.addActionListener(new ActionListener() {
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
		btnaddAnh.setBounds(575, 252, 89, 23);
		panel.add(btnaddAnh);
		btnDangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoKhau hk = new HoKhau();
					hk.setMahokhau(Integer.parseInt(txtaddMahokhau.getText()));
					hk.setHotenchuho(txtaddHotenchuho.getText());
					hk.setNgaysinh(txtaddNgaysinh.getText());
					hk.setGioitinh(txtaddgioitinh.getSelectedIndex());
					hk.setDantoc(txtadddantoc.getText());
					hk.setQuoctich(txtaddQuoctich.getText());
					hk.setDiachi(txtaddDiachi.getText());
					hk.setNgaydangky(txtaddNgaydangky.getText());
					hk.setAnh(person_image);
					if(HoKhauDao.insert(hk)) {
						MessageDialogHelper.showMassageDialog(btnDangky, "Ho khau da duoc luu", "Thông Báo");
					} else {
						MessageDialogHelper.showMassageDialog(btnDangky, "Ho khau khong duoc luu do loi", "Lỗi");
					}
					
				} catch(Exception ex) {
					ex.printStackTrace();
					Connect.MessageDialogHelper.showErrorDialog(btnaddAnh, "Lỗi", ex.getMessage());
				}
			}
		});

	}
}
