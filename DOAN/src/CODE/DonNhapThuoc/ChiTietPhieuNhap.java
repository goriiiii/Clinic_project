package DonNhapThuoc;

import QuanLy.QuanLySP;
import Thuoc.NhaSanXuat;
import Thuoc.Nhap;
import Thuoc.SanPham;

public class ChiTietPhieuNhap {
    private SanPham sanPham;
    private double thanhTien;

    public ChiTietPhieuNhap(){}

    public ChiTietPhieuNhap(String loaiSanPham, String maSanPham ,String tenSanPham, int soLuong,double donGia,String maNSX, String tenNSX, double thanhTien){
        NhaSanXuat nsx = new NhaSanXuat(maNSX, tenNSX);
        this.sanPham = Nhap.kiemTraLoaiSanPham(loaiSanPham);
        this.sanPham.nhapMaSanPham(maSanPham);
        this.sanPham.nhapTenSanPham(tenSanPham);
        this.sanPham.nhapSoLuong(soLuong);
        this.sanPham.nhapDonGia(donGia);
        this.sanPham.nhapNhaSanXuat(nsx);
        this.thanhTien = thanhTien;
    }

    public void nhapMaSanPham(String maSanPham){
        this.sanPham.nhapMaSanPham(maSanPham);
    }

    public void nhapMaSanPham(){
        this.sanPham.nhapMaSanPham(Nhap.nhapMaSanPham_1());
    }

    public String xuatMaSanPham(){
        return this.sanPham.xuatMaSanPham();
    }

    public String xuatTenSanPham(){
        return this.sanPham.xuatTenSanPham();
    }

    public void nhapSoLuong(){
        this.sanPham.nhapSoLuong();
    }

    public int xuatSoLuong(){
        return this.sanPham.xuatSoLuong();
    }

    public void nhapDonGia(double donGia){
        this.sanPham.nhapDonGia(donGia);
    }

    public SanPham xuatSanPham(){
        return this.sanPham;
    }

    public void nhapDonGia(){
        this.sanPham.nhapDonGia();
    }

    public double xuatDonGia(){
        return this.sanPham.xuatDonGia();
    }

    public void nhapThanhTien(){
        this.thanhTien = this.sanPham.xuatDonGia() * this.sanPham.xuatSoLuong();
    }

    public double xuatThanhTien(){
        return this.thanhTien;
    }

    public boolean nhapCTPN(){
        String maSP = Nhap.nhapMaSanPham_1();
        if(maSP.equals("")){ System.out.println("[Thông báo]> Hủy thêm sản phẩm"); return false;}
        else if(!QuanLySP.timKiemSanPham(maSP)) {System.out.println("[Thông báo]> Sản phẩm không tồn tại"); return false;}
        else{
            this.sanPham = QuanLySP.traVeSanPham(maSP);
            this.nhapSoLuong();
            this.nhapThanhTien();
            return true;
        }
    }

    @Override
    public String toString(){
        return this.sanPham.xuatLoaiSanPham() + "/" +  this.sanPham.xuatMaSanPham()+ "/"+ this.sanPham.xuatTenSanPham() + "/" + this.sanPham.xuatSoLuong() + "/" + this.sanPham.xuatDonGia() + "/" + this.sanPham.xuatMaNSX() + "/" + this.sanPham.xuatTenNSX() + "/" +  this.thanhTien +"!";
    }

}