package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Connect.DBConnect;
import QLNKview.DangKyHoKhau;
import QLNKview.ThemMoiNhanKhau;


public class NhanKhauDao {
	public static List<NhanKhau> findAll(){
		List<NhanKhau>nhankhauList = new ArrayList<>();
		String query = "SELECT * FROM NHANKHAU";
		try {
			Connection con = DBConnect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				NhanKhau  nk= new NhanKhau(rs.getInt("makhaisinh"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("noisinh"),rs.getString("quequan"),rs.getString("noiohientai"),rs.getInt("gioitinh"),rs.getInt("cmnd"),rs.getString("ngaycap"),rs.getString("noicapcmnd"),rs.getString("dantoc"),rs.getString("tongiao"),rs.getString("quanhevoichuho"),rs.getInt("mahokhau"), rs.getBytes("anh"));
				nhankhauList.add(nk);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return nhankhauList;
	}
	
	public static boolean insert(NhanKhau nk) throws Exception {
		String query = "INSERT INTO NHANKHAU(MAKHAISINH,HOTEN,NGAYSINH,NOISINH,QUEQUAN,NOIOHIENTAI,GIOITINH,CMND,NGAYCAP,NOICAPCMND,"
						+ "DANTOC,TONGIAO,QUANHEVOICHUHO,MAHOKHAU,ANH) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection con = DBConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);){
			pstmt.setInt(1, nk.getMakhaisinh());
			pstmt.setString(2, nk.getHoten());
			pstmt.setString(3, nk.getNgaysinh());
			pstmt.setString(4, nk.getNoisinh());
			pstmt.setString(5, nk.getQuequan());
			pstmt.setString(6, nk.getNoiohientai());
			pstmt.setInt(7, nk.getGioitinh());
			pstmt.setInt(8, nk.getCmnd());
			pstmt.setString(9, nk.getNgaycap());
			pstmt.setString(10, nk.getNoicap());
			pstmt.setString(11, nk.getDantoc());
			pstmt.setString(12, nk.getTongiao());
			pstmt.setString(13, nk.getQuanhevoichuho());
			pstmt.setInt(14, nk.getMahokhau());
			pstmt.setBytes(15,ThemMoiNhanKhau.person_image);
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public static void delete(NhanKhau nk) {
		String query = "DELETE FROM NHANKHAU WHERE MAKHAISINH = '" + nk.getMakhaisinh() +"'";
		try {
			Connection con = DBConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static boolean update(NhanKhau nk) throws Exception {
		String query = "UPDATE NHANKHAU SET MAKHAISINH=?,HOTEN=?,NGAYSINH=?,NOISINH=?,QUEQUAN=?,NOIOHIENTAI=?,GIOITINH=?,CMND=?,NGAYCAP=?,NOICAPCMND=?,DANTOC=?,TONGIAO=?,QUANHEVOICHUHO=?,MAHOKHAU=?, ANH=? WHERE HOTEN = N'" + nk.getHoten() +"'";
		try(Connection con = DBConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);) {
			pstmt.setInt(1, nk.getMakhaisinh());
			pstmt.setString(2, nk.getHoten());
			pstmt.setString(3, nk.getNgaysinh());
			pstmt.setString(4, nk.getNoisinh());
			pstmt.setString(5, nk.getQuequan());
			pstmt.setString(6, nk.getNoiohientai());
			pstmt.setInt(7, nk.getGioitinh());
			pstmt.setInt(8, nk.getCmnd());
			pstmt.setString(9, nk.getNgaycap());
			pstmt.setString(10, nk.getNoicap());
			pstmt.setString(11, nk.getDantoc());
			pstmt.setString(12, nk.getTongiao());
			pstmt.setString(13, nk.getQuanhevoichuho());
			pstmt.setInt(14, nk.getMahokhau());
			pstmt.setBytes(15,ThemMoiNhanKhau.person_image);
			return pstmt.executeUpdate() > 0;
		}	
	}
	
	public static List<NhanKhau>findbyname(NhanKhau n) {
		List<NhanKhau>nhankhaul = new ArrayList<>();
		String query = "SELECT * FROM NHANKHAU WHERE HOTEN= N'" + n.getHoten() + "'";
		try {
			Connection con = DBConnect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				NhanKhau  nk= new NhanKhau(rs.getInt("makhaisinh"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("noisinh"),rs.getString("quequan"),rs.getString("noiohientai"),rs.getInt("gioitinh"),rs.getInt("cmnd"),rs.getString("ngaycap"),rs.getString("noicapcmnd"),rs.getString("dantoc"),rs.getString("tongiao"),rs.getString("quanhevoichuho"),rs.getInt("mahokhau"), rs.getBytes("anh"));
				nhankhaul.add(nk);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return nhankhaul;
	}
}
