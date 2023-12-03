package Thuoc;

import java.io.Console;
import java.util.Scanner;


public class Nhap {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String nhapMaSanPham(){
        do{
            System.out.print("- Nhập mã sản phẩm (VD: SP1): ");
            String maSP = scanner.nextLine().toUpperCase();
            if(!maSP.matches("SP\\d{1,}"))
                System.out.println("[Thông báo]> Mã sản phẩm không hợp lệ");
            return maSP;
        }
        while(true);
    }

    public static String nhapTenSanPham(){
        do{
            System.out.print("- Nhập tên sản phẩm: ");
            String tenSP = scanner.nextLine();
            if(!tenSP.matches("[a-zA-Z0-9_\\s]{0,30}"))
                System.out.println("[Thông báo]> Tên sản phẩm không hợp lệ và chứa tối đa 30 kí tự");
            return tenSP;
        }
        while(true);
    }

    public static SanPham nhapLoaiSanPham(){
        try{
            boolean kt = false;
            while(kt==false){
                System.out.println("[Chọn loại sản phẩm]");
                System.out.println("1. Sản phẩm thuốc");
                System.out.println("2. Sản phẩm thực phẩm chức năng");
                System.out.print("- Nhập loại sản phẩm: ");
                String i = scanner.nextLine();
                switch(i){
                    case "1":
                        SanPhamThuoc Thuoc = new SanPhamThuoc();
                        kt = true;
                        return Thuoc;
                    case "2":
                        SanPhamTpcn Tpcn = new SanPhamTpcn();
                        kt = true;
                        return Tpcn;
                    default:
                        System.out.println("[Thông báo]> Nhập sai vui lòng nhập lại");
                        break;
                }   
            }
        }
        catch(Exception ex){
            System.out.println("[Thông báo]> Đã xảy ra lỗi trog quá trình nhập");
        }
        return null;
    }

    public static SanPham kiemTraLoaiSanPham(String loaiSanPham){   
        if(loaiSanPham.equals("Thuoc")){
            SanPhamThuoc Thuoc = new SanPhamThuoc();
            return Thuoc;
        }
                else if(loaiSanPham.equals("Tpcn")){
            SanPhamTpcn Tpcn = new SanPhamTpcn();
            return Tpcn;
        }
        return null;
    }
    //Nha San Xuat
    public static String nhapMaNSX(){
        do{
        System.out.print("- Nhập mã nhà sản xuất: ");
            String maNSX = scanner.nextLine();
            if(!maNSX.matches("[a-zA-Z0-9_\\s]{0,20}"))
                System.out.println("[Thông báo]> Mã nhà sản xuất không chứa kí tự đặc biệt và chứa tối đa 20 kí tự");
            else return maNSX;
        }
        while(true);
    }

    public static String nhapTenNSX(){
        do{
        System.out.print("- Nhập tên nhà sản xuất: ");
            String tenNSX = scanner.nextLine();
            if(!tenNSX.matches("[a-zA-Z0-9_\\s]{0,30}"))
                System.out.println("[Thông báo]> Tên nhà sản xuất không chứa kí tự đặc biệt và chứa tối đa 30 kí tự");
            else return tenNSX;
        }
        while(true);
    }

    public static int nhapSoLuong(){
        do{
            try{
                System.out.print("- Nhập số lượng: ");
                int soLuong = Integer.parseInt(scanner.nextLine());
                if(soLuong <= 0) System.out.println("[Thông báo]> Số lượng không được âm hoặc bằng 0");
                else return soLuong;
            }
            catch(Exception ex){
                System.out.println("[Thông báo]> Số lượng không hợp lệ");
            }
        }
        while(true);
    }

    public static double nhapDonGia(){
        do{
            try{
                System.out.print("- Nhập đơn giá: ");
                double donGia = Double.parseDouble(scanner.nextLine());
                if(donGia <= 0) System.out.println("[Thông báo]> Đơn giá không được âm hoặc bằng 0");
                else return donGia;
            }
            catch(Exception ex){
                System.out.println("[Thông báo]> Đơn giá không hợp lệ");
            }
        }
        while(true);
    }
    public static String nhapChucNang(){
        return scanner.nextLine();
    }
    public static boolean nhapXacNhan(){
        do{
            try{
                System.out.print(" - Xác nhận (Y/N): ");
                String xacNhan = scanner.nextLine().toUpperCase();
                if(xacNhan.charAt(0) == 'Y'){
                    return true;
                }
                else if(xacNhan.charAt(0) == 'N') return false;
                else System.out.println("[Thông báo]> Nhập sai vui lòng nhập lại");
            }
            catch(Exception ex){
                System.out.println("[Thông báo]> Nhập sai vui lòng nhập lại");
            }
        }
        while(true);
    }
    public static String nhapMaSanPham_1(){
        do{
            System.out.print("- Nhập mã sản phẩm (SP1) (hoặc nhấn Enter để hủy nhập): ");
            String maSP = scanner.nextLine().toUpperCase();
            if(maSP.equals("")) return maSP;
            else if(!maSP.matches("SP\\d{1,}")){
                System.out.println("[Thông báo]> Mã sản phẩm không hợp lệ");
            }
            else return maSP;
        }
        while(true);
    }
    public static String nhapMaPhieuNhap(){
        do{
            System.out.print("- Nhập mã phiếu nhập (VD: PN1): ");
            String maPN = scanner.nextLine().toUpperCase();
            if(!maPN.matches("PN\\d{1,}"))
                System.out.println("[Thông báo]> Mã phiếu nhập không hợp lệ");
            return maPN;
            }
            while(true);
    }
}

