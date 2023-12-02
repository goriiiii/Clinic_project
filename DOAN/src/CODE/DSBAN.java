package CODE;

import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

public class DSBAN {
    static Scanner scanner = new Scanner(System.in);
    private int slg;
    KiemTra kt = new KiemTra();

    private ArrayList<BAN> banarr;

    public DSBAN(int n, ArrayList<BAN> banarr) {
        this.setSlg(n);
        this.banarr = banarr;
    }

    public DSBAN() {
        this.setSlg(0);
        banarr = new ArrayList<BAN>();

    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public ArrayList<BAN> getBanarr() {
        return banarr;

    }

    public void setKhoaarr(ArrayList<BAN> banarr) {
        this.banarr = banarr;

    }

    public void nhapDSBan() {

        System.out.println("Nhập vào số lượng ban:");
        slg = Integer.parseInt(kt.KiemTraNhapSo());

        for (int i = 0; i < slg; i++) {
            BAN b = new BAN();

            boolean isDuplicate = true;
            while (isDuplicate) {
                b.NhapBan();
                isDuplicate = false;

                for (BAN ban : banarr) {
                    if (b.getId().equalsIgnoreCase(ban.getId())) {

                        System.out.println("Không cho phép ID trùng lặp!");
                        isDuplicate = true;
                        break;

                    }
                }
            }
            banarr.add(b);

        }
    }

    public void xuatDSBan() {
        System.out.println("Danh sách các ban: ");

        System.out.printf("%-12s%-12s\n", "ID", "Ban");
        for (BAN b : this.banarr) {
            System.out.printf("%-12s%-12s\n", b.getId(), b.getTen());
        }
    }

    public void themBan() {

        System.out.println("Nhap ban can them");
        nhapDSBan();

    }

    public BAN timkiemBantheoid() {

        System.out.println("Nhập vào ID ban cần tìm:");
        String id = kt.KiemTraNhapChuoi();
        for (BAN b1 : banarr)
            if (b1.getId().equalsIgnoreCase(id)) {
                ;
                System.out.println(b1.toString());
                return b1;
            }
        if (!this.findMatchingStrings(banarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(banarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy ban!");
            return null;
        }

    }

    public BAN timkiemBantheoten() {

        System.out.println("Nhập vào tên ban cần tìm:");
        String name = scanner.nextLine();
        for (BAN b1 : banarr)
            if (b1.getTen().equalsIgnoreCase(name)) {
                System.out.println(b1.toString());
                return b1;
            }
        if (!this.findMatchingStrings(banarr, name).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(banarr, name)) {
                System.out.println(str);

            }
            return null;

        } else {
            System.out.println("Không tìm thấy ban!");
            return null;
        }

    }

    public void xoaBan() {

        System.out.println("Nhap ID ban can xoa");
        BAN b = timkiemBantheoid();
        if (b == null) {
            System.out.println("Không tìm thấy để xóa!");
            return;
        } else {
            b.toString();
            System.out.println("Xac nhan xoa? y|n");
            String choice = scanner.nextLine();
            choice.toLowerCase();
            boolean menu = true;
            while (menu == true) {
                switch (choice) {
                    case "y":
                        banarr.remove(b);
                        System.out.println("Da xoa");
                        BAN.decrementSlg();
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

    public ArrayList<String> findMatchingStrings(ArrayList<BAN> banarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (BAN b : banarr) {
            if (b.getTen().toLowerCase().contains(pattern.toLowerCase())
                    || b.getId().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(b.toString());
            }

        }

        return matchingStrings;
    }

    public void suaBan() {

        System.out.println("Nhap ID ban can sua");
        BAN b = timkiemBantheoid();
        if (b == null) {
            System.out.println("Khong tim thay");
            return;
        } else {

            boolean menu1 = true;
            while (menu1 == true) {
                System.out.println("1.Sửa Ban ID   2.Sửa Tên Ban  3.Thoát");
                String choice = scanner.nextLine();

                if (choice.matches("1")) {
                    System.out.println("Nhập ID mới: ");

                    BAN b1 = new BAN();
                    b1.setTen(b.getTen());
                    b1.setId(kt.KiemTraNhapMaKhoa());

                    boolean isDuplicate = true;
                    for (BAN ban : this.banarr) {
                        isDuplicate = true;
                        while (isDuplicate == true) {
                            if (b1.getId().equalsIgnoreCase(ban.getId())) {
                                System.out.println("Không cho phép ID trùng lặp!");
                                isDuplicate = true;
                                b1.setId(kt.KiemTraNhapMaKhoa());
                            } else {
                                isDuplicate = false;
                            }
                        }
                    }
                    banarr.add(b1);
                    banarr.remove(b);
                    System.out.println("Lựa chọn tiếp tục sửa thêm?");
                    menu1 = kt.TiepTuc(menu1);
                } else if (choice.matches("2")) {
                    System.out.println("Nhập ten mới: ");

                    b.setTen(kt.KiemTraNhapTen());

                    System.out.println("Lựa chọn tiếp tục sửa thêm?");
                    menu1 = kt.TiepTuc(menu1);
                } else if (choice.matches("3")) {
                    menu1 = false;
                } else {
                    System.out.println("Nhập không hợp lệ, vui lòng lựa chọn 1 hoặc"
                            + " 2 hoặc 3 ");
                    menu1 = true;
                }
            }

        }

    }

    public void docFile(DSBAN ds) {
        System.out.println("Nhập đường dẫn của file: ");
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
                    read.close();
                    return;
                }
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] properties = line.split(",");

                    if (properties.length == 2) {
                        String property1 = properties[0].trim();
                        String property2 = properties[1].trim();

                        BAN banobj = new BAN(property1, property2);
                        kt.formatChuoi(banobj.getTen());
                        banarr.add(banobj);
                        read.close();
                    } else {
                        System.out.println("Invalid format in the line: " + line);
                        return;
                    }
                }

            } else {
                System.out.println("File không tồn tại");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void vietFile() {

        System.out.println("Nhập đường dẫn file để viết: ");
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
        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (BAN ban : banarr) {
                if (ban != null) {
                    bufferedWriter.write(ban.getId() +
                            " , " + ban.getTen() + "\n");
                }
            }
            System.out.println("Array of BAN has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vietFileauto(DSBAN ds, String file) {

        banarr.add(new BAN("TC", "Tài chính"));
        banarr.add(new BAN("KT1", "Kế toán"));
        banarr.add(new BAN("KT2", "Kế toán"));
        banarr.add(new BAN("QLK", "Quản lý cung ứng"));
        banarr.add(new BAN("HC", "Hành chính tiếp đón"));
        banarr.add(new BAN("HC2", "Quản lý nhân sự"));

        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (BAN b : banarr) {
                if (b != null) {
                    bufferedWriter.write(b.getId() +
                            " , " + b.getTen() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(DSBAN ds) {

        String c;
        boolean menu = true;
        while (menu == true) {
            System.out.println("QUẢN LÍ CÁC BAN");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Thêm ban");
            System.out.println("4. Tìm kiếm theo ID");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Xóa ban");
            System.out.println("7. Sửa ban");
            System.out.println("8. Nhập thông tin từ file");
            System.out.println("9. Xuất thông tin ra file");
            System.out.println("10. Exit");
            c = scanner.nextLine();
            switch (c) {
                case "1":
                    ds.nhapDSBan();
                    break;
                case "2":
                    ds.xuatDSBan();
                    break;
                case "3":
                    ds.themBan();
                    break;
                case "4":
                    ds.timkiemBantheoid();
                    break;
                case "5":
                    ds.timkiemBantheoten();
                    break;
                case "6":
                    ds.xoaBan();
                    break;
                case "7":
                    ds.suaBan();
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

}
