package QuanLy;

import java.io.*;
import java.util.ArrayList;

import Thuoc.NhaSanXuat;
import Thuoc.SanPham;
import Thuoc.Nhap;

public class QuanLySP implements QuanLy{
    
    public static ArrayList<SanPham> dsdp = new ArrayList<SanPham>();
    private static final String filePath = "C:\\Users\\ngotr\\Work\\DoAnPhongMach\\Thuoc\\Thuoc.txt";

    public QuanLySP(){
        hienThiChucNang();
    }

    public void hienThiChucNang(){
        boolean kt = false;
        while(kt == false){
            System.out.println("\n+--------------------[QUẢN LÝ SẢN PHẨM]-------------------+");
            System.out.println("| 1. Thêm thông tin sản phẩm                              |");
            System.out.println("| 2. Sửa thông tin sản phẩm                               |"); 
            System.out.println("| 3. Thanh lý sản phẩm                                    |");
            System.out.println("| 4. Tìm kiếm sản phẩm                                    |");
            System.out.println("| 5. Xem danh sách sản phẩm                               |");
            System.out.println("| 6. Phân loại sản phẩm                                   |");
            System.out.println("| 7. Thoát                                                |");
            System.out.println("+---------------------------------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            String i = Nhap.nhapChucNang();
            switch (i) {
                case "1":
                    them();
                    break;
                case "2":
                    sua();
                    break;
                case "3":
                    xoa();
                    break;
                case "4":
                    timKiem();
                    break;
                case "5":
                    xuatDSSP();
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("[Thông báo]> Bạn đã thoát quản lý sản pham");
                    kt = true;
                    break;
                default:
                    System.out.println("[Thông báo]> Chức năng vừa nhập không tồn tại. Vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void ghiFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for(int i = 0 ; i < dsdp.size() ; i++){
                bw.write(dsdp.get(i).toString() + "\n");
            }
            bw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void docFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split("#");
                NhaSanXuat nsx = new NhaSanXuat(values[5], values[6]);
                SanPham sp =  Nhap.kiemTraLoaiSanPham(values[0]);
                if(sp.xuatLoaiSanPham() != ""){
                    sp.nhapTuFile(values[1], values[2], Integer.parseInt(values[3]), Double.parseDouble(values[4]), nsx);
                    dsdp.add(sp);
                }
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //------thêm thông tin sản phẩm--------
    @Override
    public void them() {
        dsdp.clear();
        docFile();
        SanPham sp = Nhap.nhapLoaiSanPham();
        sp.nhap();
        dsdp.add(sp);
        ghiFile();
        System.out.println("[Thông báo]> Thêm sản phẩm thành công");
    }

    //------sửa thông tin sản phẩm--------
    @Override
    public void sua() {
        dsdp.clear();
        docFile();
        xuatDSSP();
        String maSo = Nhap.nhapMaSanPham();
        for(int i = 0 ; i < dsdp.size() ; i++){
            if(dsdp.get(i).xuatMaSanPham().equals(maSo)){
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|                                                           THÔNG TIN SẢN PHẨM                                                                         |\n");
                System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");
                System.out.printf("|%-15s|%-30s|%-20s|%-20s|%-30s|%-15s|%-15s|\n", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Mã nhà sản xuất", "Tên nhà sản xuất","Đơn giá", "Số lượng" , "Đơn giá");
                System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");   
                xuatSP(dsdp.get(i));
                System.out.println("[Sửa sản phẩm]");
                dsdp.get(i).nhapTenSanPham();
                dsdp.get(i).nhapMaNSX();
                dsdp.get(i).nhapTenNSX();
                dsdp.get(i).nhapDonGia();
                System.out.println("Xác nhận sửa sản phẩm ?");
                if(Nhap.nhapXacNhan()){
                    ghiFile();
                    System.out.println("[Thông báo]> Sửa sản phẩm thành công");
                }
                else {System.out.println("[Thông báo]> Đã hủy sửa sản phẩm");}
                return;
            }
        }
        System.out.println("[Thông báo]> Sản phẩm không tồn tại. Sửa sản phẩm thất bại");
    }

    //------thanh lý sản phẩm--------
    @Override
    public void xoa() {
        dsdp.clear();
        docFile();
        System.out.println("- Nhập mã số sản phẩm cần thanh lý");
        String maSo = Nhap.nhapMaSanPham();
        for (int i = 0; i < dsdp.size(); i++) {
            if (dsdp.get(i).xuatMaSanPham().equals(maSo)) {
                System.out.println("Xác nhận thanh lý ?");
                if(Nhap.nhapXacNhan()){
                    dsdp.remove(i);
                    ghiFile();
                    System.out.println("[Thông báo]> Sản phẩm đã được thanh lý");
                }
                else System.out.println("[Thông báo]> Đã hủy thanh lý sản phẩm");
                return;
            }
        }
        System.out.println("[Thông báo]> Sản phẩm không tồn tại.");
    }

    //-----tìm kiếm sản phẩm------
    @Override
    public void timKiem() {
        dsdp.clear();
        docFile();
        System.out.println(" Nhập mã số cần tìm");
        String maSo = Nhap.nhapMaSanPham();
        for (int i = 0; i < dsdp.size(); i++) {
            if(dsdp.get(i).xuatMaSanPham().equals(maSo)) {
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|                                                           THÔNG TIN SẢN PHẨM                                                                          |\n");
                System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");
                System.out.printf("|%-15s|%-30s|%-20s|%-20s|%-30s|%-15s|%-15s|\n", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Mã nhà sản xuất", "Tên nhà sản xuất","Đơn giá", "Số lượng" );
                System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");   
                xuatSP(dsdp.get(i));
                return;
            }
        }
        System.out.println("[Thông báo]> Sản phẩm không tồn tại");
    }

    //------xuất dssp--------
    public static void xuatDSSP(){
        dsdp.clear();
        docFile();
        if(dsdp.isEmpty()) System.out.println("[Thông báo]> Không có dữ liệu");
        else{
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|                                                           DANH SÁCH SẢN PHẨM                                                                          |\n");
            System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");
            System.out.printf("|%-15s|%-30s|%-20s|%-20s|%-30s|%-15s|%-15s|\n", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Mã nhà sản xuất", "Tên nhà sản xuất","Đơn giá", "Số lượng" );
            System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");
            for(var sp : dsdp){
                xuatSP(sp);
            }
        }
    }

    // public static void phanLoaiSanPham(){
    //     dssp.clear();
    //     docFile();
    //     String i = Nhap.
    //     if(dssp.isEmpty()) System.out.println("[Thông báo]> Không có dữ liệu");
    //     else{
    //         System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
    //         System.out.printf("|                                                         DANH SÁCH SẢN PHẨM                                                                       |\n");
    //         System.out.println("+---------------+------------------------------+---------------+--------------------+------------------------------+---------------+---------------+");
    //         System.out.printf("|%-15s|%-30s|%-15s|%-20s|%-30s|%-15s|%-15s|\n", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Mã nhà sản xuất", "Tên nhà sản xuất","Đơn giá", "Số lượng" );
    //         System.out.println("+---------------+------------------------------+---------------+--------------------+------------------------------+---------------+---------------+");
    //         for(var sp : dssp){
    //             if(sp instanceof SanPhamBut){

    //             }
    //         }
    //     }
    // }

    public static void tangSanPham(ArrayList<SanPham> dsSP){
        dsdp.clear();
        docFile();
        for (var sp : dsSP) 
            for (int i = 0; i < dsdp.size(); i++) {
                if (sp.xuatMaSanPham().equals(dsdp.get(i).xuatMaSanPham())) {
                    dsdp.get(i).nhapSoLuong(dsdp.get(i).xuatSoLuong() + sp.xuatSoLuong());
                    break;
                }
            }
        ghiFile();
    }

    public static void giamSanPham(ArrayList<SanPham> dsSP){
        dsdp.clear();
        docFile();
        for (var sp : dsSP) 
            for (int i = 0; i < dsdp.size(); i++) {
                if (sp.xuatMaSanPham().equals(dsdp.get(i).xuatMaSanPham())) {
                    dsdp.get(i).nhapSoLuong(dsdp.get(i).xuatSoLuong() - sp.xuatSoLuong());
                    break;
                }
            }
        ghiFile();
    }

     //-----tự động thêm mã sản phẩm khi thêm sản phẩm (không phải chức năng)--------
     public static String themMaSanPham(){
        dsdp.clear();
        docFile();
        int i;
        for(i = 0;i<dsdp.size(); i++){
            int count = 0;
            for(int j =0; j<dsdp.size();j++){
                if(dsdp.get(j).xuatMaSanPham().equals("SP" + Integer.toString(i))) count ++;
            }
            if(count == 0) break;
        }
        return Integer.toString(i);
    }

    public static boolean timKiemSanPham(String maSP){
        dsdp.clear();
        docFile();
        for (int i = 0; i < dsdp.size(); i++) {
            if (dsdp.get(i).xuatMaSanPham().equals(maSP)) {
                return true;
            }
        }
        return false;
    }

    public static SanPham traVeSanPham(String maSanPham){
        dsdp.clear();
        docFile();
        SanPham sp = null;
        for (int i = 0; i < dsdp.size(); i++) {
            if (maSanPham.equals(dsdp.get(i).xuatMaSanPham())) {
                sp = dsdp.get(i);
                break;
            }
        }
        return sp;
    }

    public static boolean kiemTraSoLuong(SanPham sanPham){
        dsdp.clear();
        docFile();
        for (int i = 0; i < dsdp.size(); i++) {
            if (sanPham.xuatMaSanPham().equals(dsdp.get(i).xuatMaSanPham())) {
                if(dsdp.get(i).xuatSoLuong() == 0) return false;
                if(sanPham.xuatSoLuong() <= dsdp.get(i).xuatSoLuong()) return true;
                else return false;
            }
        }
        return false;
    }

    public static boolean kiemTraKho(){
        dsdp.clear();
        docFile();
        if(dsdp.isEmpty()) return false;
        else return true;
    }

    public static void xuatSP(SanPham sp){
        System.out.printf("|%-15s|%-30s|%-20s|%-20s|%-30s|%,-15.0f|%,-15d|\n", sp.xuatMaSanPham(), sp.xuatTenSanPham(), sp.xuatLoaiSanPham(),sp.xuatMaNSX(), sp.xuatTenNSX(),sp.xuatDonGia(), sp.xuatSoLuong());
        System.out.println("+---------------+------------------------------+--------------------+--------------------+------------------------------+---------------+---------------+");
    }

}

