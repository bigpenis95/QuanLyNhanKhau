package Model;
public class HoKhau {
	private int mahokhau;
	private String hotenchuho;
	private String ngaysinh;
	private int gioitinh;
	private String dantoc;
	private String quoctich;
	private String diachi;
	private String ngaydangky;
	private byte[] anh;
	
	public HoKhau() {
		
	}

	public HoKhau(int mahokhau, String hotenchuho, String ngaysinh, int gioitinh, String dantoc, String quoctich,
			String diachi, String ngaydangky, byte[] anh) {
		this.mahokhau = mahokhau;
		this.hotenchuho = hotenchuho;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.dantoc = dantoc;
		this.quoctich = quoctich;
		this.diachi = diachi;
		this.ngaydangky = ngaydangky;
		this.anh = anh;
	}

	public int getMahokhau() {
		return mahokhau;
	}

	public void setMahokhau(int mahokhau) {
		this.mahokhau = mahokhau;
	}

	public String getHotenchuho() {
		return hotenchuho;
	}

	public void setHotenchuho(String hotenchuho) {
		this.hotenchuho = hotenchuho;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDantoc() {
		return dantoc;
	}

	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}

	public String getQuoctich() {
		return quoctich;
	}

	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNgaydangky() {
		return ngaydangky;
	}

	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}

	public byte[] getAnh() {
		return anh;
	}

	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	
}
