package Thuoc;

public class NhaSanXuat {
    private String maNSX;
    private String tenNSX;

    public NhaSanXuat(){
        this.maNSX = "";
        this.tenNSX = "";
    }

    public NhaSanXuat(String maNSX, String tenNSX){
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public void nhapMaNSX(String maNSX){
        this.maNSX = maNSX;
    }

    public void nhapMaNSX(){
        this.maNSX = Nhap.nhapMaNSX();
    }

    public String xuatMaNSX(){
        return this.maNSX;
    }

    public void nhapTenNSX(String tenNSX){
        this.tenNSX = tenNSX;
    }

    public void nhapTenNSX(){
        this.tenNSX = Nhap.nhapTenNSX();
    }

    public String xuatTenNSX(){
        return this.tenNSX;
    }

    public void nhap(){
        this.nhapMaNSX();
        this.nhapTenNSX();
    }

    public String toString(){
        return this.maNSX + "#" + this.tenNSX;
    }
}
