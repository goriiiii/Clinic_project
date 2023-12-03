package CODE;

public class ChitietPhieuKham_Dichvu {
    KiemTra kt = new KiemTra();
    private String dichvu_id;
    private String tendichvu;
    private int phi;

    public String getDichvu_id() {
        return dichvu_id;
    }

    public void setDichvu_id(String dichvu_id) {
        this.dichvu_id = dichvu_id;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public int getPhi() {
        return phi;
    }

    public void setPhi(int phi) {
        this.phi = phi;
    }

    public void nhapChitietDV() {
        System.out.println("Nhap ID dich vu");
        dichvu_id = kt.KiemTraNhapMaKhoa();
        System.out.println("Nhap ten dich vu");
        tendichvu = kt.KiemTraNhapTen();
        System.out.println("Nhap phi dich vu");
        phi = Integer.parseInt(kt.KiemTraNhapSo());
    }
}
