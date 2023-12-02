package CODE;

import java.util.Scanner;

public class DICHVU {

	private String id;
	private String ten;
	private int price;
	KiemTra kiemtra = new KiemTra();
	private static int slg;
	static Scanner scanner = new Scanner(System.in);

	public DICHVU(String id, String ten, int price) {
		this.id = id;
		this.ten = ten;
		this.price = price;
	}

	public DICHVU() {
		id = "";
		ten = "";
		price = 0;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static int getSlg() {
		return slg;
	}

	public static void decrementSlg() {
		slg--;
	}

	public String toString() {
		return "Dịch vụ " + ten + ", mã: " + id + ", phí " + price + " đồng";
	}

	public void NhapDichvu() {
		System.out.println("Nhập ID dịch vụ: ");
		id = kiemtra.KiemTraNhapMaKhoa();
		System.out.println("Nhập tên dịch vụ: ");
		ten = kiemtra.KiemTraNhapTen();
		id.toUpperCase();
		System.out.println("Nhập phí dịch vụ: ");
		price = Integer.parseInt(kiemtra.KiemTraNhapSo());
	}

	public void XuatDichvu() {
		System.out.println(this.toString());
	}

	public static void main(String args[]) {
		DICHVU dv = new DICHVU();
		dv.NhapDichvu();
		dv.XuatDichvu();
	}

}
