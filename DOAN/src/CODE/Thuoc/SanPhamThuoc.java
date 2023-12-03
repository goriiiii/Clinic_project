package Thuoc;

import QuanLy.QuanLySP;

public class SanPhamThuoc extends SanPham{
    public SanPhamThuoc(){
        this.nhapLoaiSanPham("Thuoc");
    }

    public SanPhamThuoc(String loaiSP, String maSanPham, String tenSanPham,int soLuong, double donGia, NhaSanXuat nhaSanXuat){
        super(loaiSP, maSanPham, tenSanPham, soLuong, donGia, nhaSanXuat);

    }

    // public String xuatLoaiSanPham(){
    //     return super.xuatLoaiSanPham();
    // }

    public void nhap(){
        maSanPham = "SP" + QuanLySP.themMaSanPham();
        this.nhapTenSanPham();
        this.nhapNhaSanXuat();
        this.nhapDonGia();
    }

    @Override
    public String toString(){
        return super.toString();
    }
    
}
    
