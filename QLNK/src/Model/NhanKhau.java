package Model;

public class NhanKhau {
	private int makhaisinh;
	private String hoten;
	private String ngaysinh;
	private String noisinh;
	private String quequan;
	private String noiohientai;
	private int gioitinh;
	private int cmnd;
	private String ngaycap;
	private String noicapcmnd;
	private String dantoc;
	private String tongiao;
	private String quanhevoichuho;
	private int mahokhau;
	private byte[] anh;
	
	public NhanKhau() {
		
	}



	public NhanKhau(int makhaisinh, String hoten, String ngaysinh, String noisinh, String quequan, String noiohientai,
			int gioitinh, int cmnd, String ngaycap, String noicapcmnd, String dantoc, String tongiao,
			String quanhevoichuho, int mahokhau, byte[] anh) {
		this.makhaisinh = makhaisinh;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.noisinh = noisinh;
		this.quequan = quequan;
		this.noiohientai = noiohientai;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.ngaycap = ngaycap;
		this.noicapcmnd = noicapcmnd;
		this.dantoc = dantoc;
		this.tongiao = tongiao;
		this.quanhevoichuho = quanhevoichuho;
		this.mahokhau = mahokhau;
		this.anh = anh;
	}


	public int getMakhaisinh() {
		return makhaisinh;
	}

	public void setMakhaisinh(int makhaisinh) {
		this.makhaisinh = makhaisinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getNoisinh() {
		return noisinh;
	}

	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getNoiohientai() {
		return noiohientai;
	}

	public void setNoiohientai(String noiohientai) {
		this.noiohientai = noiohientai;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getCmnd() {
		return cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public String getNgaycap() {
		return ngaycap;
	}

	public void setNgaycap(String ngaycap) {
		this.ngaycap = ngaycap;
	}

	public String getNoicap() {
		return noicapcmnd;
	}

	public void setNoicap(String noicapcmnd) {
		this.noicapcmnd = noicapcmnd;
	}

	public String getDantoc() {
		return dantoc;
	}

	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}

	public String getTongiao() {
		return tongiao;
	}

	public void setTongiao(String tongiao) {
		this.tongiao = tongiao;
	}

	public String getQuanhevoichuho() {
		return quanhevoichuho;
	}

	public void setQuanhevoichuho(String quanhevoichuho) {
		this.quanhevoichuho = quanhevoichuho;
	}

	public int getMahokhau() {
		return mahokhau;
	}

	public void setMahokhau(int mahokhau) {
		this.mahokhau = mahokhau;
	}

	public byte[] getAnh() {
		return anh;
	}

	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	
	
}
