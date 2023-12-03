package CODE;

public class KHOA {

	private String id;
	private String ten;
	private static int slg;

	KiemTra kiemtra = new KiemTra();

	public KHOA(String id, String ten) {
		this.id = id;
		this.ten = ten;
		slg++;
	}

	public KHOA() {
		id = "";
		ten = "";
		slg++;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public static int getSlg() {
		return slg;
	}

	public static void decrementSlg() {
		slg--;
	}

	public String toString() {
		return "Khoa " + ten + ", mã: " + id;
	}

	public void NhapKhoa() {
		System.out.println("Nhap ID: ");
		id = kiemtra.KiemTraNhapMaKhoa();
		System.out.println("Nhap ten khoa: ");
		ten = kiemtra.KiemTraNhapTen();
		id.toUpperCase();

	}

	public void XuatKhoa() {
		System.out.println(this.toString());
	}

}
