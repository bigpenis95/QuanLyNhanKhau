package QLNKview;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connect.MessageDialogHelper;
import Model.HoKhau;
import Model.HoKhauDao;
import Model.NhanKhau;
import Model.NhanKhauDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class QLHK extends JPanel {
	private JTextField txtHoTenChuHo;
	private JTextField txtMaHoKhau;
	private JTextField txtNgaySinh;
	private JTextField txtQuocTich;
	private JTextField txtNgayDangKy;
	private JTextField txtDiaChi;
	private JTextField txtDanToc;
	private JTable table;
	private JLabel lblAnh;
	private JComboBox cbGioitinh;

	/**
	 * Create the panel.
	 */
	public QLHK() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 29, 1171, -1);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD H\u1ED8 KH\u1EA8U");
		lblNewLabel.setBounds(10, 0, 211, 28);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 42, 110, 192);
		add(panel_1);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("repairing.png"))));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoKhau hk = new HoKhau();
					hk.setMahokhau(Integer.parseInt(txtMaHoKhau.getText()));
					hk.setHotenchuho(txtHoTenChuHo.getText());
					hk.setNgaysinh(txtNgaySinh.getText());
					hk.setGioitinh(cbGioitinh.getSelectedIndex());
					hk.setDantoc(txtDanToc.getText());
					hk.setQuoctich(txtQuocTich.getText());
					hk.setDiachi(txtDiaChi.getText());
					hk.setNgaydangky(txtNgayDangKy.getText());
					hk.setAnh(DangKyHoKhau.person_image);
					if(HoKhauDao.update(hk)) {
						MessageDialogHelper.showMassageDialog(btnSua, "Ho khau da duoc sua", "Thông Báo");
						showData(HoKhauDao.findAll());
					} else {
						MessageDialogHelper.showMassageDialog(btnSua, "Ho khau khong duoc sua do loi", "Lỗi");
					}
					
				} catch(Exception ex) {
					ex.printStackTrace();
					Connect.MessageDialogHelper.showErrorDialog(btnSua, "Lỗi", ex.getMessage());
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSua.setBounds(10, 60, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("delete.png"))));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoKhau hk=new HoKhau();
					hk.setMahokhau(Integer.parseInt(txtMaHoKhau.getText()));
					HoKhauDao.delete(hk);
					JOptionPane.showMessageDialog(btnXoa, "delete success");
					showData(HoKhauDao.findAll());
				} catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnXoa, "lỗi", ex.getMessage());
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnXoa.setBounds(10, 94, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("search (1).png"))));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoKhau nk = new HoKhau();
					nk.setHotenchuho(txtHoTenChuHo.getText());
					showData(HoKhauDao.findbyname(nk));
				} catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnTimKiem, "lỗi", ex.getMessage());
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnTimKiem.setBounds(10, 26, 90, 23);
		panel_1.add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("refresh.png"))));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaHoKhau.setText("");
				txtHoTenChuHo.setText("");
				txtDanToc.setText("");
				txtDiaChi.setText("");
				txtNgayDangKy.setText("");
				txtNgaySinh.setText("");
				txtQuocTich.setText("");
				cbGioitinh.setSelectedIndex(0);
				lblAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
				showData(HoKhauDao.findAll());
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnLamMoi.setBounds(10, 128, 89, 23);
		panel_1.add(btnLamMoi);
		
		JButton btnaddAnh = new JButton("Chọn ảnh");
		btnaddAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("new.png"))));
		btnaddAnh.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnaddAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				DangKyHoKhau.filename = f.getAbsolutePath();
				ImageIcon imageicon = new  ImageIcon(new ImageIcon(DangKyHoKhau.filename).getImage().getScaledInstance(lblAnh.getWidth(),lblAnh.getHeight(),Image.SCALE_SMOOTH));
				lblAnh.setIcon(imageicon);
				
				try {
					File image = new File(DangKyHoKhau.filename);
					FileInputStream fis =  new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1023];
					for(int readNum; (readNum=fis.read(buf)) != -1;) {
						bos.write(buf,0,readNum);
					}
					DangKyHoKhau.person_image = bos.toByteArray();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnaddAnh.setBounds(10, 158, 89, 23);
		panel_1.add(btnaddAnh);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(130, 42, 563, 192);
		add(panel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(59, 11, 751, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 h\u1ED9 kh\u1EA9u");
		lblNewLabel_2.setBounds(20, 55, 74, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD T\u00EAn Ch\u1EE7 H\u1ED9");
		lblNewLabel_3.setBounds(20, 30, 89, 14);
		panel.add(lblNewLabel_3);
		
		txtHoTenChuHo = new JTextField();
		txtHoTenChuHo.setColumns(10);
		txtHoTenChuHo.setBounds(114, 27, 149, 20);
		panel.add(txtHoTenChuHo);
		
		txtMaHoKhau = new JTextField();
		txtMaHoKhau.setColumns(10);
		txtMaHoKhau.setBounds(114, 56, 149, 20);
		panel.add(txtMaHoKhau);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1.setBounds(293, 26, 111, 22);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Qu\u1ED1c t\u1ECBch");
		lblNewLabel_2_1_1.setBounds(293, 55, 111, 22);
		panel.add(lblNewLabel_2_1_1);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNgaySinh.isVisible()) {
					String day = txtNgaySinh.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtNgaySinh.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtNgaySinh.requestFocus();
					}
				}
			}
		});
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(403, 24, 139, 20);
		panel.add(txtNgaySinh);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setColumns(10);
		txtQuocTich.setBounds(403, 56, 139, 20);
		panel.add(txtQuocTich);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Ng\u00E0y \u0111\u0103ng k\u00FD");
		lblNewLabel_2_1_2.setBounds(293, 87, 110, 22);
		panel.add(lblNewLabel_2_1_2);
		
		txtNgayDangKy = new JTextField();
		txtNgayDangKy.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNgayDangKy.isVisible()) {
					String day = txtNgayDangKy.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtNgayDangKy.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtNgayDangKy.requestFocus();
					}
				}
			}
		});
		txtNgayDangKy.setColumns(10);
		txtNgayDangKy.setBounds(404, 87, 138, 20);
		panel.add(txtNgayDangKy);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Giới tính");
		lblNewLabel_2_1_4.setBounds(20, 87, 74, 22);
		panel.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin");
		lblNewLabel_1.setBounds(1, 0, 65, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_2_1_2_1.setBounds(293, 120, 110, 22);
		panel.add(lblNewLabel_2_1_2_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(403, 120, 139, 20);
		panel.add(txtDiaChi);
		
		JLabel lblNewLabel_2_2 = new JLabel("D\u00E2n T\u1ED9c");
		lblNewLabel_2_2.setBounds(20, 120, 74, 22);
		panel.add(lblNewLabel_2_2);
		
		txtDanToc = new JTextField();
		txtDanToc.setColumns(10);
		txtDanToc.setBounds(114, 121, 149, 20);
		panel.add(txtDanToc);
		
		String s1[] = {"Nam","Nữ"};
		cbGioitinh = new JComboBox(s1);
		cbGioitinh.setBounds(114, 87, 149, 22);
		panel.add(cbGioitinh);
		
		lblAnh = new JLabel("");
		lblAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblAnh.setBounds(703, 42, 160, 192);
		add(lblAnh);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 245, 853, 277);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				txtMaHoKhau.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtHoTenChuHo.setText(model.getValueAt(selectedRowIndex, 1).toString());
				txtNgaySinh.setText(model.getValueAt(selectedRowIndex, 2).toString());
				txtQuocTich.setText(model.getValueAt(selectedRowIndex, 3).toString());
				cbGioitinh.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
				txtDanToc.setText(model.getValueAt(selectedRowIndex, 5).toString());
				txtDiaChi.setText(model.getValueAt(selectedRowIndex, 6).toString());
				txtNgayDangKy.setText(model.getValueAt(selectedRowIndex, 7).toString());
				byte[] img = (HoKhauDao.findAll().get(selectedRowIndex).getAnh());
				if(img != null) {
					ImageIcon imageIcon =  new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH));
					lblAnh.setIcon(imageIcon);
				} else {
					lblAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u1ED9 Kh\u1EA9u", "H\u1ECD T\u00EAn Ch\u1EE7 H\u1ED9", "Ng\u00E0y Sinh", "Qu\u1ED1c T\u1ECBch", "Gi\u1EDBi T\u00EDnh", "D\u00E2n T\u1ED9c", "\u0110\u1ECBa Ch\u1EC9", "Ng\u00E0y \u0110\u0103ng K\u00FD"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(7).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		showData(HoKhauDao.findAll());

	}
	public void showData(List<HoKhau>hokhaul) {
		List<HoKhau>listNhanKhau=new ArrayList<>();
		listNhanKhau=hokhaul;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listNhanKhau.forEach((hokhau) -> {
			String gioitinh;
			if(hokhau.getGioitinh() == 0) {
				gioitinh = "Nam";
			}
			else{
				gioitinh="Nữ";
				}
			tableModel.addRow(new Object[] {
					hokhau.getMahokhau(), hokhau.getHotenchuho(),hokhau.getNgaysinh(),hokhau.getQuoctich(),gioitinh,hokhau.getDantoc(), hokhau.getDiachi(),hokhau.getNgaydangky()
			});
		});
	}
}
