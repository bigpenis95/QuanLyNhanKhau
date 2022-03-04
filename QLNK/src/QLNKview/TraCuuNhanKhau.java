package QLNKview;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.table.DefaultTableModel;

import Connect.MessageDialogHelper;

import javax.swing.ImageIcon;
import java.awt.Image;

import Model.HoKhauDao;
import Model.NhanKhau;
import Model.NhanKhauDao;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TraCuuNhanKhau extends JPanel {
	private JTextField txtHoTen;
	private JTextField txtMaKhaiSinh;
	private JTextField txtNgaySinh;
	private JTextField txtNoiSinh;
	private JTextField txtQueQuan;
	private JTextField txtCMND;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField txtNgayCap;
	private JTextField txtNoiCapCMND;
	private JTextField txtChoOHienTai;
	private JTextField txtMaHoKhau;
	private JTextField txtDanToc;
	private JTextField txtTonGiao;
	private JTextField txtQuanHeVoiChuHo;
	private JLabel lblAnh;

	/**
	 * Create the panel.
	 */
	public TraCuuNhanKhau() {
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 26, 1262, 2);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN KHẨU");
		lblNewLabel.setBounds(10, 0, 656, 25);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(130, 39, 820, 192);
		add(panel);
		panel.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(59, 11, 751, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 khai sinh");
		lblNewLabel_2.setBounds(20, 55, 74, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD T\u00EAn");
		lblNewLabel_3.setBounds(20, 30, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(114, 27, 149, 20);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtMaKhaiSinh = new JTextField();
		txtMaKhaiSinh.setBounds(114, 56, 149, 20);
		panel.add(txtMaKhaiSinh);
		txtMaKhaiSinh.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_2_1.setBounds(293, 26, 111, 22);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("N\u01A1i sinh");
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
		txtNgaySinh.setBounds(403, 24, 139, 20);
		panel.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		txtNoiSinh = new JTextField();
		txtNoiSinh.setBounds(403, 56, 139, 20);
		panel.add(txtNoiSinh);
		txtNoiSinh.setColumns(10);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Qu\u00EA qu\u00E1n");
		lblNewLabel_2_1_2.setBounds(293, 87, 110, 22);
		panel.add(lblNewLabel_2_1_2);
		
		txtQueQuan = new JTextField();
		txtQueQuan.setBounds(404, 87, 138, 20);
		panel.add(txtQueQuan);
		txtQueQuan.setColumns(10);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("S\u1ED1 CMND");
		lblNewLabel_2_1_3.setBounds(572, 26, 74, 22);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_2_1_4.setBounds(20, 87, 74, 22);
		panel.add(lblNewLabel_2_1_4);
		
		txtCMND = new JTextField();
		txtCMND.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCMND.isVisible()) {
					String day = txtCMND.getText();
					String reg = "^[0-9]{9,9}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng 9 số");
							txtCMND.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtCMND.requestFocus();
					}
				}
			}
		});
		txtCMND.setBounds(659, 27, 139, 20);
		panel.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y c\u1EA5p");
		lblNewLabel_4.setBounds(572, 59, 74, 14);
		panel.add(lblNewLabel_4);
		
		txtNgayCap = new JTextField();
		txtNgayCap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNgayCap.isVisible()) {
					String day = txtNgayCap.getText();
					String reg = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
					if(day.length()>0) {
						if(!day.matches(reg)) {
							JOptionPane.showMessageDialog(null, "Sai định dạng\n ví dụ: 05/08/2003");
							txtNgayCap.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Trường không được để trống");
						txtNgayCap.requestFocus();
					}
				}
			}
		});
		txtNgayCap.setColumns(10);
		txtNgayCap.setBounds(659, 56, 139, 20);
		panel.add(txtNgayCap);
		
		JLabel lblNewLabel_4_1 = new JLabel("N\u01A1i c\u1EA5p CMND");
		lblNewLabel_4_1.setBounds(572, 90, 89, 14);
		panel.add(lblNewLabel_4_1);
		
		txtNoiCapCMND = new JTextField();
		txtNoiCapCMND.setColumns(10);
		txtNoiCapCMND.setBounds(659, 87, 139, 20);
		panel.add(txtNoiCapCMND);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u00F4ng tin");
		lblNewLabel_1.setBounds(1, 0, 65, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Ch\u1ED7 \u1EDF hi\u1EC7n t\u1EA1i");
		lblNewLabel_2_1_2_1.setBounds(293, 120, 110, 22);
		panel.add(lblNewLabel_2_1_2_1);
		
		txtChoOHienTai = new JTextField();
		txtChoOHienTai.setColumns(10);
		txtChoOHienTai.setBounds(403, 120, 139, 20);
		panel.add(txtChoOHienTai);
		
		JLabel lblNewLabel_2_2 = new JLabel("M\u00E3 h\u1ED9 kh\u1EA9u");
		lblNewLabel_2_2.setBounds(20, 120, 74, 22);
		panel.add(lblNewLabel_2_2);
		
		txtMaHoKhau = new JTextField();
		txtMaHoKhau.setColumns(10);
		txtMaHoKhau.setBounds(114, 121, 149, 20);
		panel.add(txtMaHoKhau);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("D\u00E2n t\u1ED9c");
		lblNewLabel_4_1_1.setBounds(572, 124, 89, 14);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("T\u00F4n gi\u00E1o");
		lblNewLabel_4_1_1_1.setBounds(572, 159, 89, 22);
		panel.add(lblNewLabel_4_1_1_1);
		
		txtDanToc = new JTextField();
		txtDanToc.setColumns(10);
		txtDanToc.setBounds(659, 121, 139, 20);
		panel.add(txtDanToc);
		
		txtTonGiao = new JTextField();
		txtTonGiao.setColumns(10);
		txtTonGiao.setBounds(659, 160, 139, 20);
		panel.add(txtTonGiao);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Quan h\u1EC7 v\u1EDBi ch\u1EE7 h\u1ED9");
		lblNewLabel_2_2_1.setBounds(293, 159, 111, 22);
		panel.add(lblNewLabel_2_2_1);
		
		txtQuanHeVoiChuHo = new JTextField();
		txtQuanHeVoiChuHo.setColumns(10);
		txtQuanHeVoiChuHo.setBounds(403, 160, 140, 20);
		panel.add(txtQuanHeVoiChuHo);
		
		String s1[] = {"Nam","Nữ"};
		
		JComboBox cbGioitinh = new JComboBox(s1);
		cbGioitinh.setBounds(114, 87, 149, 22);
		panel.add(cbGioitinh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 39, 110, 192);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("repairing.png"))));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanKhau nk = new NhanKhau();
					nk.setMakhaisinh(Integer.parseInt(txtMaKhaiSinh.getText()));
					nk.setHoten(txtHoTen.getText());
					nk.setNgaysinh(txtNgaySinh.getText());
					nk.setNoisinh(txtNoiSinh.getText());
					nk.setQuequan(txtQueQuan.getText());
					nk.setNoiohientai(txtChoOHienTai.getText());
					nk.setGioitinh(cbGioitinh.getSelectedIndex());
					nk.setCmnd(Integer.parseInt(txtCMND.getText()));
					nk.setNgaycap(txtNgayCap.getText());
					nk.setNoicap(txtNoiCapCMND.getText());
					nk.setDantoc(txtDanToc.getText());
					nk.setTongiao(txtTonGiao.getText());
					nk.setQuanhevoichuho(txtQuanHeVoiChuHo.getText());
					nk.setMahokhau(Integer.parseInt(txtMaHoKhau.getText()));
					nk.setAnh(ThemMoiNhanKhau.person_image);
					if(NhanKhauDao.update(nk)) {
						MessageDialogHelper.showMassageDialog(btnSua, "Ho khau da duoc sua", "Thông Báo");
						showData(NhanKhauDao.findAll());
					} else {
						MessageDialogHelper.showMassageDialog(btnSua, "Ho khau khong duoc sua do loi", "Lỗi");
					}
				} catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnSua, "lỗi", ex.getMessage());
				}
			}
		});
		btnSua.setBounds(10, 60, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa =new JButton("X\u00F3a");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnXoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("delete.png"))));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanKhau nk=new NhanKhau();
					nk.setMakhaisinh(Integer.parseInt(txtMaKhaiSinh.getText()));
					NhanKhauDao.delete(nk);
					JOptionPane.showMessageDialog(btnSua, "delete success");
					showData(NhanKhauDao.findAll());
				}catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnXoa, "lỗi", ex.getMessage());
				}
				
			}
		});
		btnXoa.setBounds(10, 94, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnTimKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("search (1).png"))));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanKhau nk = new NhanKhau();
					nk.setHoten(txtHoTen.getText());
					showData(NhanKhauDao.findbyname(nk));
				} catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showMassageDialog(btnTimKiem, "lỗi", ex.getMessage());
				}
			}
		});
		btnTimKiem.setBounds(10, 26, 90, 23);
		panel_1.add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnLamMoi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("refresh.png"))));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaKhaiSinh.setText("");
				txtHoTen.setText("");
				txtNgaySinh.setText("");
				txtNoiSinh.setText("");
				txtQueQuan.setText("");
				cbGioitinh.setSelectedIndex(0);
				txtChoOHienTai.setText("");
				txtCMND.setText("");
				txtNoiCapCMND.setText("");
				txtDanToc.setText("");
				txtTonGiao.setText("");
				txtQuanHeVoiChuHo.setText("");
				txtMaHoKhau.setText("");
				txtNgayCap.setText("");
				lblAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
				showData(NhanKhauDao.findAll());
			}
		});
		btnLamMoi.setBounds(10, 128, 89, 23);
		panel_1.add(btnLamMoi);
		
		JButton btnAnh = new JButton("Chọn ảnh");
		btnAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("new.png"))));
		btnAnh.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				ThemMoiNhanKhau.filename = f.getAbsolutePath();
				ImageIcon imageicon = new  ImageIcon(new ImageIcon(ThemMoiNhanKhau.filename).getImage().getScaledInstance(lblAnh.getWidth(),lblAnh.getHeight(),Image.SCALE_SMOOTH));
				lblAnh.setIcon(imageicon);
				
				try {
					File image = new File(ThemMoiNhanKhau.filename);
					FileInputStream fis =  new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1023];
					for(int readNum; (readNum=fis.read(buf)) != -1;) {
						bos.write(buf,0,readNum);
					}
					ThemMoiNhanKhau.person_image = bos.toByteArray();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnAnh.setBounds(10, 158, 89, 23);
		panel_1.add(btnAnh);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				txtMaKhaiSinh.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtHoTen.setText(model.getValueAt(selectedRowIndex, 1).toString());
				txtNgaySinh.setText(model.getValueAt(selectedRowIndex, 2).toString());
				txtNoiSinh.setText(model.getValueAt(selectedRowIndex, 3).toString());
				txtQueQuan.setText(model.getValueAt(selectedRowIndex, 4).toString());
				txtChoOHienTai.setText(model.getValueAt(selectedRowIndex, 5).toString());
				cbGioitinh.setSelectedItem(model.getValueAt(selectedRowIndex, 6).toString());
				txtCMND.setText(model.getValueAt(selectedRowIndex, 7).toString());
				txtNgayCap.setText(model.getValueAt(selectedRowIndex, 8).toString());
				txtNoiCapCMND.setText(model.getValueAt(selectedRowIndex, 9).toString());
				txtDanToc.setText(model.getValueAt(selectedRowIndex, 10).toString());
				txtTonGiao.setText(model.getValueAt(selectedRowIndex, 11).toString());
				txtQuanHeVoiChuHo.setText(model.getValueAt(selectedRowIndex, 12).toString());
				txtMaHoKhau.setText(model.getValueAt(selectedRowIndex, 13).toString());
				byte[] img = (NhanKhauDao.findAll().get(selectedRowIndex).getAnh());
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
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Makhaisinh", "Hoten", "Ngaysinh", "Noisinh", "Quequan", "Noiohientai", "Gioitinh", "CMND", "Ngaycap", "Noicapcmnd", "Dantoc", "Tongiao", "Quanhevoichuho", "Mahokhau"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(98);
		table.getColumnModel().getColumn(6).setPreferredWidth(58);
		table.getColumnModel().getColumn(7).setPreferredWidth(97);
		table.getColumnModel().getColumn(8).setPreferredWidth(82);
		table.getColumnModel().getColumn(9).setPreferredWidth(98);
		table.getColumnModel().getColumn(10).setPreferredWidth(64);
		table.getColumnModel().getColumn(11).setPreferredWidth(64);
		table.getColumnModel().getColumn(12).setPreferredWidth(110);
		table.getColumnModel().getColumn(12).setMinWidth(110);
		table.getColumnModel().getColumn(12).setMaxWidth(132);
		
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 242, 1110, 277);
		add(scrollPane);
		
		lblAnh = new JLabel("");
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThemTaiKhoan.class.getResource("question.png"))));
		lblAnh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblAnh.setBounds(960, 39, 160, 192);
		add(lblAnh);
		showData(NhanKhauDao.findAll());

	}
	
	public void showData(List<NhanKhau>nhankhaul) {
		List<NhanKhau>listNhanKhau=new ArrayList<>();
		listNhanKhau=nhankhaul;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listNhanKhau.forEach((nhankhau) -> {
			String gioitinh;
			if(nhankhau.getGioitinh() == 0) {
				gioitinh = "Nam";
			}
			else{
				gioitinh="Nữ";
				}
			tableModel.addRow(new Object[] {
					nhankhau.getMakhaisinh(),nhankhau.getHoten(),nhankhau.getNgaysinh(),nhankhau.getNoisinh(),nhankhau.getQuequan(),
					nhankhau.getNoiohientai(),gioitinh,nhankhau.getCmnd(),nhankhau.getNgaycap(),nhankhau.getNoicap(),nhankhau.getDantoc(),
					nhankhau.getTongiao(),nhankhau.getQuanhevoichuho(),nhankhau.getMahokhau(),nhankhau.getAnh()
			});
		});
	}
}

