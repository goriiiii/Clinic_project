package CODE;

import java.util.Scanner;

public class PhieuKham {
    protected String IDPhieuKham;

    @Override
    public String toString() {
        return "ID Phieu Kham: " + IDPhieuKham + ", ID Benh Nhan=" + IDBenhNhan + ", ID Bac Si=" + IDBacSi
                + ", ngay: " + ngaythang + ", tinh trang: " + status;
    }

    protected String IDBenhNhan;
    protected String IDBacSi;
    private DSCHITIETPHIEUKHAM ds = new DSCHITIETPHIEUKHAM();
    protected String ngaythang;
    protected String status = "Hope le";
    protected int slg;
    KiemTra kt = new KiemTra();

    static Scanner sc = new Scanner(System.in);

    public String getIDPhieuKham() {
        return IDPhieuKham;
    }

    public void setIDPhieuKham(String iDPhieuKham) {
        IDPhieuKham = iDPhieuKham;
    }

    public String getIDBenhNhan() {
        return IDBenhNhan;
    }

    public void setIDBenhNhan(String iDBenhNhan) {
        IDBenhNhan = iDBenhNhan;
    }

    public String getIDBacSi() {
        return IDBacSi;
    }

    public void setIDBacSi(String iDBacSi) {
        IDBacSi = iDBacSi;
    }

    public DSCHITIETPHIEUKHAM getDs() {
        return ds;
    }

    public void setDs(DSCHITIETPHIEUKHAM ds) {
        this.ds = ds;
    }

    public String getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(String ngaythang) {
        this.ngaythang = ngaythang;
    }

    public PhieuKham(String IDPhieuKham, String IDBenhNhan, String IDBacSi, String ngaythang) {
        this.IDPhieuKham = IDPhieuKham;
        this.IDBenhNhan = IDBenhNhan;
        this.IDBacSi = IDBacSi;
        this.ngaythang = ngaythang;
        slg++;
    }

    public PhieuKham() {
        this.ngaythang = this.IDBacSi = this.IDBenhNhan = this.IDPhieuKham = "";
        slg++;
    }

    public void Nhap() {

    }

    public void HuyPhieu() {
        status = "Da huy";
    }

    public void xuatPhieuKham() {
        System.out.println("Ma benh nhan: " + IDBenhNhan);
        System.out.println("Ma bac si: " + IDBacSi);
        System.out.println("Ngay: " + ngaythang);
        ds.xuat();
    }

}
