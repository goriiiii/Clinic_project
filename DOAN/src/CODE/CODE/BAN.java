package CODE;

public class BAN {

    private String id;
    private String ten;
    private static int slg;

    KiemTra kiemtra = new KiemTra();

    public BAN(String id, String ten) {
        this.id = id;
        this.ten = ten;
        slg++;

    }

    public BAN() {
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
        return "Ban " + ten + ", mã: " + id;
    }

    public void NhapBan() {
        System.out.println("Nhap ID: ");
        id = kiemtra.KiemTraNhapMaKhoa();
        System.out.println("Nhap ten ban: ");
        ten = kiemtra.KiemTraNhapTen();
        id.toUpperCase();

    }

    public void XuatBan() {
        System.out.println(this.toString());
    }

}
