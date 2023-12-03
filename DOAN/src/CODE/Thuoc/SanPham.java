package Thuoc;

public abstract class SanPham {
    protected String maSanPham;
    protected String tenSanPham;
    protected int soLuong;
    protected double donGia;
    protected String loaiSanPham;
    protected NhaSanXuat nhaSanXuat = new NhaSanXuat();

    public SanPham(){}

    public SanPham(String loaiSanPham, String maSanPham, String tenSanPham,int soLuong, double donGia, NhaSanXuat nhaSanXuat){
        this.loaiSanPham = loaiSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham= tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.nhaSanXuat = nhaSanXuat;
    }

    public void nhapMaSanPham(String maSanPham){
        this.maSanPham = maSanPham;
    }

    public String xuatMaSanPham(){
        return this.maSanPham;
    }

    public void nhapTenSanPham(String tenSanPham){
        this.tenSanPham = tenSanPham;
    }

    public void nhapTenSanPham(){
        this.tenSanPham = Nhap.nhapTenSanPham();
    }

    public String xuatTenSanPham(){
        return this.tenSanPham;
    }

    public void nhapSoLuong(int soLuong){
        this.soLuong = soLuong;
    }

    public void nhapSoLuong(){
        this.soLuong = Nhap.nhapSoLuong();
    }

    public int xuatSoLuong(){
        return this.soLuong;
    }

    public void nhapDonGia(double donGia){
        this.donGia = donGia;
    }

    public void nhapDonGia(){
        this.donGia = Nhap.nhapDonGia();
    }

    public double xuatDonGia(){
        return this.donGia;
    }

    public void nhapMaNSX(){
        this.nhaSanXuat.nhapMaNSX();
    }

    public void nhapMaNSX(String maNSX){
        this.nhaSanXuat.nhapMaNSX(maNSX);
    }

    public String xuatMaNSX(){
        return this.nhaSanXuat.xuatMaNSX();
    }

    public void nhapTenNSX(){
        this.nhaSanXuat.nhapTenNSX();
    }

    public void nhapTenNSX(String tenNSX){
        this.nhaSanXuat.nhapTenNSX(tenNSX);
    }

    public String xuatTenNSX(){
        return this.nhaSanXuat.xuatTenNSX();
    }

    public void nhapNhaSanXuat(){
        this.nhapMaNSX();
        this.nhapTenNSX();
    }

    public void nhapNhaSanXuat(NhaSanXuat nsx){
        this.nhaSanXuat = nsx;
    }

    public void nhapLoaiSanPham(String loaiSanPham){
        this.loaiSanPham = loaiSanPham;
    }

    public String xuatLoaiSanPham(){
        return this.loaiSanPham;
    }

    public abstract void nhap();

    public void nhapTuFile(String maSanPham, String tenSanPham,int soLuong, double donGia, NhaSanXuat nhaSanXuat){
        this.nhapMaSanPham(maSanPham);
        this.nhapTenSanPham(tenSanPham);
        this.nhapSoLuong(soLuong);
        this.nhapDonGia(donGia);
        this.nhapMaNSX(nhaSanXuat.xuatMaNSX());
        this.nhapTenNSX(nhaSanXuat.xuatTenNSX());
    }

    @Override
    public String toString(){
        return this.loaiSanPham + "#" + this.maSanPham + "#" + this.tenSanPham +  "#"+ this.soLuong + "#" + this.donGia + "#" +this.nhaSanXuat.toString();
    }
}
