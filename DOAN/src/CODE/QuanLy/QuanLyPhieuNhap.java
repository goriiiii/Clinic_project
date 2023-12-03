package QuanLy;

import java.io.*;
import java.util.ArrayList;

import DonNhapThuoc.ChiTietPhieuNhap;
import Thuoc.NhaSanXuat;
import Thuoc.Nhap;
import DonNhapThuoc.PhieuNhap;
import Thuoc.SanPham;

public class QuanLyPhieuNhap implements QuanLy {

    private static ArrayList<PhieuNhap> dspn = new ArrayList<PhieuNhap>();
    private static final String filePath = "C:\\Users\\ADMIN\\Documents\\22.txt";

    public QuanLyPhieuNhap() {

        this.hienThiChucNang();
    }

    public void hienThiChucNang() {
        boolean kt = false;
        while (kt == false) {
            System.out.println("\n+------------------[QUẢN LÝ PHIẾU NHẬP]-------------------+");
            System.out.println("| 1. Tạo phiếu nhập                                       |");
            System.out.println("| 2. Xóa phiếu nhập                                       |");
            System.out.println("| 3. Tìm kiếm phiếu nhập                                  |");
            System.out.println("| 4. Xem danh sách phiếu nhập                             |");
            System.out.println("| 5. Thoát                                                |");
            System.out.println("+---------------------------------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            String i = Nhap.nhapChucNang();
            System.out.println();
            switch (i) {
                case "1":
                    them();
                    break;
                case "2":
                    xoa();
                    break;
                case "3":
                    timKiem();
                    break;
                case "4":
                    xuatDSPN();
                    break;
                case "5":
                    kt = true;
                    System.out.println("[Thông báo]> Bạn đã thoát quản lý phiếu nhập");
                    break;
                default:
                    System.out.println("[Thông báo]> Chức năng vừa nhập không tồn tại. Vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < dspn.size(); i++) {
                bw.write(dspn.get(i).toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void docFile() {
        dspn.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] thuocTinhPN = line.split("#");
                String[] thuocTinhCTPN = thuocTinhPN[2].split("!");
                ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<ChiTietPhieuNhap>();
                for (int i = 0; i < thuocTinhCTPN.length; i++) {
                    String[] ctpn = thuocTinhCTPN[i].split("/");
                    ChiTietPhieuNhap ctpn1 = new ChiTietPhieuNhap(ctpn[0], ctpn[1], ctpn[2], Integer.parseInt(ctpn[3]),
                            Double.parseDouble(ctpn[4]), ctpn[5], ctpn[6], Double.parseDouble(ctpn[7]));
                    dsctpn.add(ctpn1);
                }
                NhaSanXuat nhaCC = new NhaSanXuat(thuocTinhPN[3], thuocTinhPN[4]);
                PhieuNhap pn = new PhieuNhap(thuocTinhPN[0], thuocTinhPN[1], dsctpn, nhaCC, thuocTinhPN[5],
                        Double.parseDouble(thuocTinhPN[6]));
                dspn.add(pn);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ------tạo phiếu nhập--------
    @Override
    public void them() {
        dspn.clear();
        docFile();
        PhieuNhap pn = new PhieuNhap();
        pn.nhap();
        if (pn.xuatCTPN().isEmpty())
            System.out.println("[Thông báo]> Không tồn tại sản phẩm trong phiếu nhập. Tạo phiếu nhập thất bại");
        else {
            System.out.println("Xác nhận tạo phiếu nhập ?");
            if (Nhap.nhapXacNhan()) {
                dspn.add(pn);
                ArrayList<SanPham> dssp = new ArrayList<SanPham>();
                for (var ctpn : pn.xuatCTPN())
                    dssp.add(ctpn.xuatSanPham());
                QuanLySP.tangSanPham(dssp);
                ghiFile();
                System.out.println("[Thông báo]> Tạo phiếu nhập thành công");
                xuatPN(pn);
            } else
                System.out.println("[Thông báo]> Đã hủy tạo phiếu nhập");
        }
    }

    // -------xóa phiếu nhập--------
    @Override
    public void xoa() {
        dspn.clear();
        docFile();
        System.out.println(" - Nhập mã số cần xóa");
        String maso = Nhap.nhapMaPhieuNhap();
        for (int i = 0; i < dspn.size(); i++) {
            if (dspn.get(i).xuatMaPhieuNhap().equals(maso)) {
                System.out.println("Xác nhận xóa phiếu nhập ?");
                if (Nhap.nhapXacNhan()) {
                    dspn.remove(dspn.get(i));
                    ghiFile();
                    System.out.println("[Thông báo]> Xóa phiếu nhập thành công");
                } else
                    System.out.println("[Thông báo]> Đã hủy xóa phiếu nhập");
                return;
            }
        }
        System.out.println("[Thông báo]> Không tìm thấy phiếu nhập. Xóa phiếu nhập thất bại");
    }

    // ------tìm kiếm phiếu nhập--------
    @Override
    public void timKiem() {
        dspn.clear();
        docFile();
        System.out.println("- Nhập mã số cần tìm ");
        String maso = Nhap.nhapMaPhieuNhap();
        for (int i = 0; i < dspn.size(); i++) {
            if (maso.equals(dspn.get(i).xuatMaPhieuNhap())) {
                xuatPN(dspn.get(i));
                System.out.println("[Thông báo]> Tìm kiếm phiếu nhập thành công");
                return;
            }
        }
        System.out.println("[Thông báo]> Phiếu nhập không tồn tại. Tìm kiếm phiếu nhập thất bại");
    }

    // ------xuất dspn--------
    public static void xuatDSPN() {
        dspn.clear();
        docFile();
        if (dspn.isEmpty())
            System.out.println("[Thông báo]> Không có dữ liệu");
        else {
            System.out.println("[DANH SÁCH PHIẾU NHẬP]");
            for (var pn : dspn) {
                xuatPN(pn);
            }
        }
    }

    // -----thêm tự động mã phiếu nhập (không phải chức năng)-------
    public static String themMaPhieuNhap() {
        dspn.clear();
        docFile();
        int i;
        for (i = 0; i < dspn.size(); i++) {
            int count = 0;
            for (int j = 0; j < dspn.size(); j++) {
                if (dspn.get(j).xuatMaPhieuNhap().equals("PN" + Integer.toString(i)))
                    count++;
            }
            if (count == 0)
                break;
        }
        return Integer.toString(i);
    }

    public static void xuatPN(PhieuNhap pn) {
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
        System.out.printf(
                "|                                               PHIẾU NHẬP | MÃ %-10s                                         |\n",
                pn.xuatMaPhieuNhap());
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| Mã nhân viên: %-10s |\n", pn.getManv());
        System.out.printf("| Ngày nhập: %-10s |\n", pn.xuatNgayNhap());
        System.out.println(
                "+---------------+------------------------------+--------------------+--------------------+-------------------------+");
        System.out.printf("|%-15s|%-30s|%-20s|%-20s|%-25s|\n", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá",
                "Số lượng nhập", "Thành tiền");
        System.out.println(
                "+---------------+------------------------------+--------------------+--------------------+-------------------------+");
        for (var ctpn : pn.xuatCTPN()) {
            System.out.printf("|%-15s|%-30s|%,-20.0f|%-20d|%,-25.0f|\n", ctpn.xuatMaSanPham(), ctpn.xuatTenSanPham(),
                    ctpn.xuatDonGia(), ctpn.xuatSoLuong(), ctpn.xuatThanhTien());
            System.out.println(
                    "+---------------+------------------------------+--------------------+--------------------+-------------------------+");
        }
        System.out.printf(
                "| Tổng tiền: %,-12.0f                                                                                          |\n",
                pn.xuatTongTien());
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
    }

    @Override
    public void sua() {
        // TODO Auto-generated method stub
    }
}
