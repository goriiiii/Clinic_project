package DonNhapThuoc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import QuanLy.QuanLySP;
import QuanLy.QuanLyPhieuNhap;
import Thuoc.NhaSanXuat;
import Thuoc.Nhap;

public class PhieuNhap {

    private String maPhieuNhap;

    private NhaSanXuat Nhasx = new NhaSanXuat();
    private ArrayList<ChiTietPhieuNhap> ctpn = new ArrayList<ChiTietPhieuNhap>();
    private String ngayNhap;
    private double tongTien = 0;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPhieuNhap, ArrayList<ChiTietPhieuNhap> ctpn, NhaSanXuat Nhasx,
            String ngayNhap, double tongTien) {
        this.maPhieuNhap = maPhieuNhap;

        this.ctpn = ctpn;
        this.Nhasx = Nhasx;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public void nhapMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public void nhapMaPhieuNhap() {
        this.maPhieuNhap = Nhap.nhapMaPhieuNhap();
    }

    public String xuatMaPhieuNhap() {
        return this.maPhieuNhap;
    }

    public void nhapCTPN(ArrayList<ChiTietPhieuNhap> ctpn) {
        this.ctpn = ctpn;
    }

    public ArrayList<ChiTietPhieuNhap> xuatCTPN() {
        return ctpn;
    }

    public void nhapNhaSanXuat() {
        this.Nhasx.nhapMaNSX();
        this.Nhasx.nhapTenNSX();
    }

    public String xuatMaNCC() {
        return this.Nhasx.xuatMaNSX();
    }

    public String xuatTenNCC() {
        return this.Nhasx.xuatTenNSX();
    }

    public void nhapNgayNhap() {
        this.ngayNhap = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String xuatNgayNhap() {
        return this.ngayNhap;
    }

    public void nhapTongTien() {
        for (ChiTietPhieuNhap t : ctpn) {
            this.tongTien += t.xuatThanhTien();
        }
    }

    public double xuatTongTien() {
        return this.tongTien;
    }

    public void nhapCTPN() {
        do {
            System.out.println("[Chi tiết phiếu nhập]");
            ChiTietPhieuNhap ctpn1 = new ChiTietPhieuNhap();
            if (ctpn1.nhapCTPN() == true) {
                if (this.ctpn.isEmpty())
                    this.ctpn.add(ctpn1);
                else {
                    boolean check = false;
                    for (var ctpn2 : ctpn) {
                        if (ctpn1.xuatMaSanPham().equals(ctpn2.xuatMaSanPham())) {
                            check = true;
                            System.out.println(
                                    "[Thông báo]> Đã tồn tại sản phẩm đã nhập trong phiếu nhập. Vui lòng chọn sản phẩm khác");
                            break;
                        }
                    }
                    if (check == false) {
                        this.ctpn.add(ctpn1);
                    }
                }
            }
            System.out.println("Tiếp tục thêm sản phẩm ?");
            if (!Nhap.nhapXacNhan())
                break;
        } while (true);
    }

    public void nhap() {
        this.maPhieuNhap = "PN" + QuanLyPhieuNhap.themMaPhieuNhap();
        QuanLySP.xuatDSSP();
        this.nhapCTPN();
        this.nhapNhaSanXuat();
        this.nhapTongTien();
        this.nhapNgayNhap();
    }

    public String toString() {
        String text = this.maPhieuNhap + "#";
        for (var ctpn1 : ctpn) {
            text += ctpn1.toString();
        }
        return text += "#" + this.Nhasx.toString() + "#" + this.ngayNhap + "#" + this.tongTien;
    }
}
