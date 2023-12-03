package Thuoc;

import java.util.Scanner;

import QuanLy.*;

public class Run {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        thuKho();
    }

    public static void dangNhap() {
        boolean kt = false;
        while (kt == false) {
            System.out.println("\n+-----------------------[ĐĂNG NHẬP]-----------------------+");
            System.out.println("| 1. Đăng nhập                                            |");
            System.out.println("| 2. Thoát                                                |");
            System.out.println("+---------------------------------------------------------+\n");
            System.out.print("- Chọn chức năng: ");
            String i = scanner.nextLine();
            switch (i) {
                case "1":
                    System.out.println("QuanLy[ MaNV: NV0 ; Mat khau: 123 ]");
                    System.out.println("ThuKho[ MaNV: NV2 ; Mat khau: 123 ]");
                    System.out.println("BanHang[ MaNV: NV3 ; Mat khau: 123 ]");

                case "2":
                    System.out.println("[Thông báo]> Bạn đã thoát chương trình\n");
                    kt = true;
                    break;
                default:
                    System.out.println("[Thông báo]> Chức năng vừa nhập không tồn tại. Vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void thuKho() {
        // System.out.println("[Thông tin nhân viên]> Nhân viên: " +
        // nhanVien.xuatHoTen() + " | Mã chức vụ: " + nhanVien.xuatMaChucVu());
        boolean kt = false;
        while (kt == false) {
            System.out.println("\n+---------------[NGHIỆP VỤ QUẢN LÝ KHO]------------------+");
            System.out.println("| 1. Quản lý sản phẩm                                    |");
            System.out.println("| 2. Nhập kho                                            |");
            System.out.println("| 4. Thoát                                               |");
            System.out.println("+--------------------------------------------------------+\n");
            System.out.print("Nhập mục: ");
            String i = scanner.nextLine();
            switch (i) {
                case "1":
                    new QuanLySP();
                    break;
                case "2":
                    new QuanLyPhieuNhap().hienThiChucNang();

                    break;

                case "4":
                    kt = true;
                    System.out.println("[Thông báo]> Bạn đã thoát chương trình");
                    break;
                default:
                    System.out.println("[Thông báo]> Mục vừa nhập không tồn tại. Vui lòng nhập lại");
                    break;
            }
        }
    }
}
