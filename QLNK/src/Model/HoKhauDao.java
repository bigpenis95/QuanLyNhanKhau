package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connect.DBConnect;
import QLNKview.DangKyHoKhau;
import QLNKview.ThemMoiNhanKhau;

public class HoKhauDao {
	public static List<HoKhau> findAll(){
		List<HoKhau>hokhauList = new ArrayList<>();
		String query = "SELECT * FROM HOKHAU";
		try {
			Connection con = DBConnect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				HoKhau  hk= new HoKhau(rs.getInt("mahokhau"),rs.getString("hotenchuho"),rs.getString("ngaysinh"),rs.getInt("gioitinh"),rs.getString("dantoc"),rs.getString("quoctich"),rs.getString("diachi"),rs.getString("ngaydangky"), rs.getBytes("anh"));
				hokhauList.add(hk);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return hokhauList;
	}
	
	public static boolean insert(HoKhau hk) throws Exception {
		String query = "INSERT INTO HOKHAU(MAHOKHAU,HOTENCHUHO,NGAYSINH,GIOITINH,DANTOC,QUOCTICH,DIACHI,NGAYDANGKY,ANH) VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection con = DBConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);){
		
		
			pstmt.setInt(1, hk.getMahokhau());
			pstmt.setString(2, hk.getHotenchuho());
			pstmt.setString(3, hk.getNgaysinh());
			pstmt.setInt(4, hk.getGioitinh());
			pstmt.setString(5, hk.getDantoc());
			pstmt.setString(6, hk.getQuoctich());
			pstmt.setString(7, hk.getDiachi());
			pstmt.setString(8, hk.getNgaydangky());
			pstmt.setBytes(9,DangKyHoKhau.person_image); 
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public static void delete(HoKhau hk) {
		String query = "DELETE FROM HOKHAU WHERE MAHOKHAU= '" + hk.getMahokhau() +"'";
		try {
			Connection con = DBConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static boolean update(HoKhau hk) throws Exception{
		String query = "UPDATE HOKHAU SET MAHOKHAU = ?, HOTENCHUHO = ?, NGAYSINH = ?, GIOITINH = ?, DANTOC = ?, QUOCTICH = ?, DIACHI = ?, NGAYDANGKY = ?, ANH = ?  WHERE MAHOKHAU = '" + hk.getMahokhau() +"'";
		try(Connection con = DBConnect.getConnection();
				PreparedStatement pstmt = con.prepareStatement(query);) 
		{
			pstmt.setInt(1, hk.getMahokhau());
			pstmt.setString(2, hk.getHotenchuho());
			pstmt.setString(3, hk.getNgaysinh());
			pstmt.setInt(4, hk.getGioitinh());
			pstmt.setString(5, hk.getDantoc());
			pstmt.setString(6, hk.getQuoctich());
			pstmt.setString(7, hk.getDiachi());
			pstmt.setString(8, hk.getNgaydangky());
			pstmt.setBytes(9,DangKyHoKhau.person_image); 
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public static List<HoKhau>findbyname(HoKhau h) {
		List<HoKhau>hokhaul = new ArrayList<>();
		String query = "SELECT * FROM HOKHAU WHERE HOTENCHUHO= N'" + h.getHotenchuho() + "'";
		try {
			Connection con = DBConnect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				HoKhau  hk= new HoKhau(rs.getInt("mahokhau"),rs.getString("hotenchuho"),rs.getString("ngaysinh"),rs.getInt("gioitinh"),rs.getString("dantoc"),rs.getString("quoctich"),rs.getString("diachi"),rs.getString("ngaydangky"),rs.getBytes("anh"));
				hokhaul.add(hk);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return hokhaul;
	}
}
