package CODE;

import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

public class DSCHITIETPHIEUKHAM {
    static Scanner scanner = new Scanner(System.in);
    private int slg;
    KiemTra kt = new KiemTra();

    private ArrayList<ChitietPhieuKham_Thuoc> thuocarr;
    private ArrayList<ChitietPhieuKham_Dichvu> dichvuarr;

    public DSCHITIETPHIEUKHAM(int n, ArrayList<ChitietPhieuKham_Thuoc> thuocarr,
            ArrayList<ChitietPhieuKham_Dichvu> dichvuarr) {
        this.setSlg(n);
        this.thuocarr = thuocarr;
        this.dichvuarr = dichvuarr;
    }

    public DSCHITIETPHIEUKHAM() {
        this.setSlg(0);
        thuocarr = new ArrayList<ChitietPhieuKham_Thuoc>();
        dichvuarr = new ArrayList<ChitietPhieuKham_Dichvu>();
    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public ArrayList<ChitietPhieuKham_Thuoc> getThuocarr() {
        return thuocarr;
    }

    public ArrayList<ChitietPhieuKham_Dichvu> getDichvuarr() {
        return dichvuarr;
    }

    public void setThuocarr(ArrayList<ChitietPhieuKham_Thuoc> thuocarr) {
        this.thuocarr = thuocarr;

    }

    public void setDichvuarr(ArrayList<ChitietPhieuKham_Dichvu> dichvuarr) {
        this.dichvuarr = dichvuarr;

    }

    public void nhapDSChiTiet() {
        boolean menu = true;
        while (menu == true) {

            System.out.println("1. Nhap chi tiet thuoc     2.Nhap chi tiet dich vu    3.Thoat");

            String choice = kt.KiemTraNhapSo();
            switch (choice) {
                case "1":
                    System.out.println("Nhap so luong chi tiet thuoc: ");
                    slg = Integer.parseInt(kt.KiemTraNhapSo());

                    for (int i = 0; i < slg; i++) {
                        ChitietPhieuKham_Thuoc A = new ChitietPhieuKham_Thuoc();
                        boolean isDuplicate = true;

                        while (isDuplicate) {
                            A.nhapChitiet();
                            isDuplicate = false;

                            for (ChitietPhieuKham_Thuoc detail : thuocarr) {
                                if (A.getThuoc_id().equals(detail.getThuoc_id())) {
                                    System.out.println("Không cho phép ID trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }
                        }

                        if (!isDuplicate) {
                            thuocarr.add(A);
                        }
                    }
                    break;

                case "2":
                    System.out.println("Nhap so luong chi tiet dich vu: ");
                    slg = Integer.parseInt(kt.KiemTraNhapSo());

                    for (int i = 0; i < slg; i++) {
                        ChitietPhieuKham_Dichvu A = new ChitietPhieuKham_Dichvu();
                        boolean isDuplicate = true;

                        while (isDuplicate) {
                            A.nhapChitietDV();
                            isDuplicate = false;

                            for (ChitietPhieuKham_Dichvu detail : dichvuarr) {
                                if (A.getDichvu_id() == (detail.getDichvu_id())) {
                                    System.out.println("Không cho phép ID trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }
                        }

                        if (!isDuplicate) {
                            dichvuarr.add(A);
                        }
                    }
                    break;

            }
            menu = kt.TiepTuc(menu);
        }

    }

    public ChitietPhieuKham_Thuoc timThuocdetailbyID() {
        System.out.println("Nhập vào ID thuoc cần tìm:");
        String id = kt.KiemTraNhapChuoi();
        for (ChitietPhieuKham_Thuoc a : thuocarr)
            if (a.getThuoc_id().equalsIgnoreCase(id)) {

                System.out.println(a.toString());
                return a;
            }
        if (!this.findMatchingStrings(thuocarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(thuocarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy chi tiet!");
            return null;
        }

    }

    public ChitietPhieuKham_Dichvu timDichvudetailbyID() {
        System.out.println("Nhập vào ID dich vu cần tìm:");
        String id = kt.KiemTraNhapChuoi();
        for (ChitietPhieuKham_Dichvu a : dichvuarr)
            if (a.getDichvu_id().equalsIgnoreCase(id)) {

                System.out.println(a.toString());
                return a;
            }
        if (!this.findMatchingStrings2(dichvuarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings2(dichvuarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy chi tiet!");
            return null;
        }

    }

    public ArrayList<String> findMatchingStrings(ArrayList<ChitietPhieuKham_Thuoc> thuocarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (ChitietPhieuKham_Thuoc a : thuocarr) {
            if (a.getThuoc_id().toLowerCase().contains(pattern.toLowerCase())
                    || a.getTenthuoc().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(a.toString());
            }

        }

        return matchingStrings;
    }

    public ArrayList<String> findMatchingStrings2(ArrayList<ChitietPhieuKham_Dichvu> dichvuarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (ChitietPhieuKham_Dichvu a : dichvuarr) {
            if (a.getDichvu_id().toLowerCase().contains(pattern.toLowerCase())
                    || a.getTendichvu().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(a.toString());
            }

        }

        return matchingStrings;
    }

    public void xuat() {
        System.out.println("DANH MUC THUOC");
        System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Ma thuoc", "Ten thuoc", "Don gia", "So luong",
                "Thanh tien");

        for (ChitietPhieuKham_Thuoc a : thuocarr) {
            System.out.printf("%-12s%-12s%-12s%-12s%-12s\n",

                    a.getThuoc_id(),
                    a.getTenthuoc(),
                    Integer.toString(a.getDongia()),
                    Integer.toString(a.getSlg()),
                    Integer.toString(a.getThanhTien()));
        }

        System.out.println("BANG DICH VU");
        System.out.printf("%-12s%-12s%-12s\n", "Ma Dich vu", "Ten Dich vu", "Phi");

        for (ChitietPhieuKham_Dichvu a : dichvuarr) {
            System.out.printf("%-12s%-12s%-12s%-12s\n",

                    a.getDichvu_id(),
                    a.getTendichvu(),
                    Integer.toString(a.getPhi()));
        }
    }

    public void xoaChitietthuoc() {
        System.out.println("Nhap ID thuoc can xoa");
        ChitietPhieuKham_Thuoc a = timThuocdetailbyID();
        if (a == null) {
            System.out.println("Không tìm thấy để xóa!");
            return;
        } else {

            System.out.println("Xac nhan xoa? y|n");
            String choice = scanner.nextLine();
            choice.toLowerCase();
            boolean menu = true;
            while (menu == true) {
                switch (choice) {
                    case "y":
                        thuocarr.remove(a);
                        System.out.println("Da xoa");
                        menu = false;
                        break;
                    case "n":
                        menu = false;
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        menu = true;
                        break;
                }
            }
        }
    }

    public void xoaChitietDichvu() {
        System.out.println("Nhap ID dich vu can xoa");
        ChitietPhieuKham_Dichvu a = timDichvudetailbyID();
        if (a == null) {
            System.out.println("Không tìm thấy để xóa!");
            return;
        } else {

            System.out.println("Xac nhan xoa? y|n");
            String choice = scanner.nextLine();
            choice.toLowerCase();
            boolean menu = true;
            while (menu == true) {
                switch (choice) {
                    case "y":
                        dichvuarr.remove(a);
                        System.out.println("Da xoa");
                        menu = false;
                        break;
                    case "n":
                        menu = false;
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        menu = true;
                        break;
                }
            }
        }
    }

    public int TotalMoney() {
        int TotalMoney = 0;
        for (ChitietPhieuKham_Thuoc a : thuocarr) {
            TotalMoney += a.getThanhTien();
        }
        for (ChitietPhieuKham_Dichvu a : dichvuarr) {
            TotalMoney += a.getPhi();
        }
        return TotalMoney;
    }

    public void main(DSCHITIETPHIEUKHAM ds, PhieuKham pk) {

        String c;
        boolean menu = true;
        while (menu == true) {

            System.out.println("1. Nhập chi tiet");
            System.out.println("2. Xuất cac chi tiet");
            System.out.println("3. Thêm chi tiet");
            System.out.println("4. Tim chi tiet thuoc");
            System.out.println("5. Tim chi thiet dich vu");
            System.out.println("6. Xoa chi tiet thuoc");
            System.out.println("7. Xoa chi tiet dich vu");
            System.out.println("8. Xac nhan nhap cac chi tiet vao phieu");
            System.out.println("9. Huy nhap va thoat");

            c = scanner.nextLine();
            switch (c) {
                case "1":
                    ds.nhapDSChiTiet();
                    break;
                case "2":
                    ds.xuat();
                    break;
                case "3":
                    ds.nhapDSChiTiet();
                    break;
                case "4":
                    ds.timThuocdetailbyID();
                    break;
                case "5":
                    ds.timDichvudetailbyID();
                    break;
                case "6":
                    ds.xoaChitietthuoc();
                    break;
                case "7":
                    ds.xoaChitietDichvu();
                    break;
                case "8":
                    System.out.println("Xac nhan nhap phieu? y|n");
                    String choice = kt.KiemTraNhapTen();
                    if (choice.equalsIgnoreCase("y")) {
                        pk.setDs(ds);
                        System.out.println("Nhap thanh cong");
                    } else if (choice.equalsIgnoreCase("n")) {
                        break;
                    } else {
                        System.out.println("Lua chon khong hop le");
                        break;
                    }
                    break;

                case "9":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại");
                    menu = true;
                    break;
            }
            menu = kt.TiepTuc(menu);
        }

    }

    public static void main(String argv[]) {
        DSCHITIETPHIEUKHAM a = new DSCHITIETPHIEUKHAM();
        a.nhapDSChiTiet();
        a.xuat();
    }
}