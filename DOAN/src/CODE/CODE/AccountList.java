package CODE;

import java.util.ArrayList;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AccountList {

    static Scanner scanner = new Scanner(System.in);
    private int slg;
    KiemTra kt = new KiemTra();

    private ArrayList<Account> listarr;

    public AccountList(int n, ArrayList<Account> listarr) {
        this.setSlg(n);
        this.listarr = listarr;
    }

    public AccountList() {
        this.setSlg(0);
        listarr = new ArrayList<Account>();

    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public ArrayList<Account> getAccountarr() {
        return listarr;
    }

    public void setKhoaarr(ArrayList<Account> listarr) {
        this.listarr = listarr;

    }

    public void taoAccountmacdinh() {
        Account account = new Account("1", "admin", "12345", "admin");
        this.listarr.add(account);
    }

    public void nhapDSAccount() {

        System.out.println("Nhập vào số lượng tai khoan:");
        slg = Integer.parseInt(kt.KiemTraNhapSo());

        for (int i = 0; i < slg; i++) {
            Account a = new Account();

            boolean isDuplicate = true;
            while (isDuplicate) {
                a.inputAccount();
                isDuplicate = false;

                for (Account acc : this.listarr) {
                    if ((a.getIDAcc().equals(acc.getIDAcc())) || a.getUsername().equals(acc.getUsername())) {

                        System.out.println("Không cho phép ID va username trùng lặp!");
                        isDuplicate = true;
                        break;

                    }
                }
            }
            listarr.add(a);

        }
    }

    public void xuatDSAccount() {
        System.out.println("Danh sách các account: ");

        System.out.printf("%-12s%-12s%-12s%-12s\n", "ID", "Username", "Password", "Quyen han");
        for (Account a : listarr) {
            System.out.printf("%-12s%-12s%-12s%-12s\n", a.getIDAcc(), a.getUsername(), a.getPassword(),
                    a.getQuyenhan());
        }
    }

    public void themAcc() {

        System.out.println("Them tai khoan moi");
        nhapDSAccount();

    }

    public Account timkiemAcctheoid() {
        Account acc = null;
        System.out.println("Nhập vào ID tai khoan cần tìm:");
        String id = kt.KiemTraNhapMaKhoa();
        for (Account a : listarr)
            if (a.getIDAcc().equalsIgnoreCase(id)) {
                acc = a;
                System.out.println(a.toString());
                return a;

            }
        if (!this.findMatchingStrings(listarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(listarr, id)) {
                System.out.println(str);
            }

        } else {
            System.out.println("Không tìm thấy khoa!");
        }
        return acc;
    }

    public Account timkiemAccountByUsername() {
        Account acc = null;
        System.out.println("Nhập vào username tai khoan cần tìm:");
        String id = kt.KiemTraNhapMaKhoa();
        for (Account a : listarr)
            if (a.getUsername().equalsIgnoreCase(id)) {
                acc = a;
                System.out.println(a.toString());
                return a;

            }
        if (!this.findMatchingStrings2(listarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(listarr, id)) {
                System.out.println(str);
            }

        } else {
            System.out.println("Không tìm thấy khoa!");
        }
        return acc;
    }

    public void xoaAcc() {
        System.out.println("Nhap ID tai khoan can xoa");
        Account a = timkiemAcctheoid();
        if (a == null) {
            System.out.println("Không tìm thấy để xóa!");
            return;
        } else {
            a.toString();
            System.out.println("Xac nhan xoa? y|n");
            String choice = scanner.nextLine();
            choice.toLowerCase();
            boolean menu = true;
            while (menu == true) {
                switch (choice) {
                    case "y":
                        listarr.remove(a);
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

    public ArrayList<String> findMatchingStrings(ArrayList<Account> listarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (Account a : listarr) {
            if (a.getIDAcc().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(a.toString());
            }

        }

        return matchingStrings;
    }

    public ArrayList<String> findMatchingStrings2(ArrayList<Account> listarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (Account a : listarr) {
            if (a.getUsername().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(a.toString());
            }

        }

        return matchingStrings;
    }

    public void suaAcc() {

        System.out.println("Nhap ID tai can sua");
        Account a = timkiemAcctheoid();
        if (a == null) {
            System.out.println("Khong tim thay");
            return;
        } else {

            boolean menu1 = true;
            while (menu1 == true) {
                System.out.println(
                        "1.Sửa  ID     2.Sửa Username     3.Sua quyen han     X.Thoát");
                String choice = scanner.nextLine();

                choice = choice.toLowerCase();
                switch (choice) {
                    case "1":
                        System.out.println("Nhập ID mới: ");
                        boolean isDuplicate = true;

                        while (isDuplicate) {
                            String newid = kt.KiemTraNhapMaKhoa();

                            String currentId = a.getIDAcc();

                            if (newid.equalsIgnoreCase(currentId)) {
                                System.out.println("ID mới giống với ID hiện tại. Vui lòng nhập ID khác.");
                                continue;
                            }

                            isDuplicate = false;
                            for (Account acc : listarr) {
                                if (newid.equalsIgnoreCase(acc.getIDAcc())) {
                                    System.out.println("Không cho phép ID trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("Vui lòng nhập ID mới.");
                            } else {
                                a.setIDAcc(newid);
                                System.out.println("Da luu");
                                break;
                            }
                        }
                        System.out.println(a.toString());
                        menu1 = false;
                        break;
                    case "2":
                        System.out.println("Nhập Username mới: ");
                        boolean isDuplicate2 = true;

                        while (isDuplicate2) {
                            String newid = kt.KiemTraNhapMaKhoa();

                            String currentId = a.getUsername();

                            if (newid.equalsIgnoreCase(currentId)) {
                                System.out.println("ID mới giống với ID hiện tại. Vui lòng nhập ID khác.");
                                continue;
                            }

                            isDuplicate = false;
                            for (Account acc : listarr) {
                                if (newid.equalsIgnoreCase(acc.getUsername())) {
                                    System.out.println("Không cho phép username trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("Vui lòng nhập username mới.");
                            } else {
                                a.setUsername(newid);
                                System.out.println("Da luu");
                                break;
                            }
                        }
                        System.out.println(a.toString());
                        menu1 = false;
                        break;
                    case "3":
                        int x = 0;
                        do {
                            System.out.println("\nChọn Quyền hạn:");
                            System.out.println("1. Quản trị viên        2. Quản lí của bác sĩ         3. Quản lí dược");
                            x = Integer.parseInt(kt.KiemTraNhapSo());
                            if (x == 1) {
                                a.setQuyenhan("admin");
                            } else if (x == 2) {
                                a.setQuyenhan("bacsi");
                            } else if (x == 3) {
                                a.setQuyenhan("duoc");
                            } else {
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                            }
                        } while (x != 1 && x != 2 && x != 3);

                }
            }
        }
    }

    public void docFile(AccountList ds) {
        System.out.println("Nhap duong dan cua file: ");
        String file = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < file.length(); i++) {
            char currentChar = file.charAt(i);
            if (currentChar != '\"') {
                sb.append(currentChar);
            }
            if (currentChar == '\\') {
                sb.append("\\");
            }
        }
        System.out.println(sb);
        file = sb.toString();
        try {
            File f = new File(file);

            if (f.exists()) {
                Scanner read = new Scanner(f);
                if (!read.hasNext()) {
                    System.out.println("File is empty. Generating content...");
                    vietFileauto(ds, file);

                    return;
                }
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] properties = line.split(",");

                    if (properties.length >= 3) {
                        String property1 = properties[0].trim();
                        String property2 = properties[1].trim();
                        String property3 = properties[2].trim();
                        String property4 = properties[3].trim();

                        Account dvobj = new Account(property1, property2, property3, property4);

                        listarr.add(dvobj);

                    } else {
                        System.out.println("Invalid format in the line: " + line);
                        return;
                    }
                }

            } else {
                System.out.println("File khong ton tai");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        Set<String> uniqueIds = new HashSet<>();
        ArrayList<Account> duplicatesToRemove = new ArrayList<>();

        for (Account a : listarr) {
            String currentId = a.getIDAcc();
            String currentUsername = a.getUsername();
            if (uniqueIds.contains(currentId) || uniqueIds.contains(currentUsername)) {
                System.out.println("ID trung lap: " + a.getIDAcc() + "hoac username trung lap: " + a.getUsername());
                duplicatesToRemove.add(a);
            } else {
                uniqueIds.add(a.getIDAcc());

            }
        }

        listarr.removeAll(duplicatesToRemove);
        System.out.println("Go bo nhung ID/username trung lap thanh cong");

    }

    public void vietFile() {

        System.out.println("Nhap duong dan cua file de viet: ");
        String file = scanner.nextLine();// "C:\Users\ADMIN\Documents\input.txt"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < file.length(); i++) {
            char currentChar = file.charAt(i);
            if (currentChar != '\"') {
                sb.append(currentChar);
            }
            if (currentChar == '\\') {
                sb.append("\\");
            }
        }
        System.out.println(sb);
        file = sb.toString();
        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Account acc : listarr) {
                if (acc != null) {
                    bufferedWriter.write(acc.getIDAcc() +
                            " , " + acc.getUsername() + ", " + acc.getPassword() + ",  " + acc.getQuyenhan());
                }
            }
            System.out.println("Array of DICHVU has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vietFileauto(AccountList l, String file) {
        listarr.add(new Account("2", "admin2", "12345", "admin"));
        listarr.add(new Account("3", "bacsi1", "12345", "bacsi"));
        listarr.add(new Account("4", "duoc", "12345", "duoc"));

        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Account acc : listarr) {
                if (acc != null) {
                    bufferedWriter.write(acc.getIDAcc() +
                            " , " + acc.getUsername() + ", " + acc.getPassword() + ",  " + acc.getQuyenhan());
                }
            }
            System.out.println("Array of Account has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(AccountList ds) {

        String c;
        boolean menu = true;
        while (menu == true) {
            System.out.println("QUẢN LÍ TAI KHOAN");
            System.out.println("1. Nhập them tai khoan");
            System.out.println("2. Xuất thong tin");
            System.out.println("3. Thêm tai khoan");
            System.out.println("4. Tìm kiếm theo ID");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Xóa tai khoa ");
            System.out.println("7. Sửa tai khoan");
            System.out.println("8. Nhập thông tin từ file");
            System.out.println("9. Xuất thông tin ra file");
            System.out.println("10. Exit");
            c = scanner.nextLine();
            switch (c) {
                case "1":
                    ds.nhapDSAccount();
                    break;
                case "2":
                    ds.xuatDSAccount();

                    break;
                case "3":
                    ds.themAcc();
                    break;
                case "4":
                    ds.timkiemAcctheoid();
                    break;
                case "5":
                    ds.timkiemAccountByUsername();
                    break;
                case "6":
                    ds.xoaAcc();
                    ;
                    break;
                case "7":
                    ds.suaAcc();
                    break;
                case "8":
                    ds.docFile(ds);
                    break;
                case "9":
                    ds.vietFile();
                    break;
                case "10":
                    menu = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại");
                    menu = true;
                    break;
            }
        }
    }

    public static void main(String argv[]) {
        AccountList l = new AccountList();

        l.main(l);
    }
}
