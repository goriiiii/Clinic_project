package CODE;

public class ChitietPhieuKham_Thuoc {
    KiemTra kt = new KiemTra();

    private String thuoc_id;
    private String tenthuoc;
    private int dongia;
    private int slg;
    private int thanhTien;

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getThuoc_id() {
        return thuoc_id;
    }

    public void setThuoc_id(String thuoc_id) {
        this.thuoc_id = thuoc_id;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChitietPhieuKham_Thuoc [Ma thuoc=" + thuoc_id + ", dongia=" + dongia + ", slg=" + slg
                + ", thanhTien=" + thanhTien + "]";
    }

    public void nhapChitiet() {

        System.out.println("Nhap ma thuoc: ");
        thuoc_id = kt.KiemTraNhapMaKhoa();
        System.out.println("Nhap ten thuoc");
        tenthuoc = kt.KiemTraNhapTen();
        System.out.println("Nhap don gia: ");
        dongia = Integer.parseInt(kt.KiemTraNhapSo());
        System.out.println("Nhap so luong: ");
        slg = Integer.parseInt(kt.KiemTraNhapSo());
        thanhTien = dongia * slg;
    }

}