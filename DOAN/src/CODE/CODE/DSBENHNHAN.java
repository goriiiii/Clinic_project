package CODE;

import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

public class DSBENHNHAN {
    static Scanner scanner = new Scanner(System.in);
    private int slg;
    KiemTra kt = new KiemTra();

    private ArrayList<BenhNhan> benhnhanarr;

    public DSBENHNHAN(int n, ArrayList<BenhNhan> benhnhanarr) {
        this.setSlg(n);
        this.benhnhanarr = benhnhanarr;
    }

    public DSBENHNHAN() {
        this.setSlg(0);
        benhnhanarr = new ArrayList<BenhNhan>();

    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public ArrayList<BenhNhan> getBenhnhanDS() {
        return benhnhanarr;

    }

    public void setBenhNhanarr(ArrayList<BenhNhan> banarr) {
        this.benhnhanarr = banarr;

    }

    public void nhapDSBenhNhan() {

        System.out.println("Nhập vào số lượng benh nhan:");
        slg = Integer.parseInt(kt.KiemTraNhapSo());

        for (int i = 0; i < slg; i++) {
            BenhNhan b = new BenhNhan();
            b.nhapThongTin();
            boolean isDuplicate = true;
            while (isDuplicate) {

                b.nhapBenhNhan();
                isDuplicate = false;

                for (BenhNhan bn : benhnhanarr) {
                    if (b.getMabenhnhan().equalsIgnoreCase(bn.getMabenhnhan())) {

                        System.out.println("Không cho phép ID trùng lặp!");
                        isDuplicate = true;
                        break;

                    }
                }
            }
            benhnhanarr.add(b);

        }
    }

    public void xuatDSBenhNhan() {
        System.out.println("Danh sách các benh nhan: ");

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s\n", "ID", "Ten", "Ngay sinh", "Dia chi", "Phai", "SDT");
        for (BenhNhan bn : this.benhnhanarr) {
            System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s\n", bn.getMabenhnhan(), bn.getName(), bn.getBirthday(),
                    bn.getAddress(),
                    bn.getGender(), bn.getPhonenumber());
        }
    }

    public void themBenhNhan() {

        System.out.println("Nhap Benh nhan can them");
        nhapDSBenhNhan();

    }

    public BenhNhan timkiemBNtheoid() {

        System.out.println("Nhập vào ID benh nhan cần tìm:");
        String id = kt.KiemTraNhapChuoi();
        for (BenhNhan bn : benhnhanarr)
            if (bn.getMabenhnhan().equalsIgnoreCase(id)) {

                System.out.println(bn.toString());
                return bn;
            }
        if (!this.findMatchingStrings(benhnhanarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(benhnhanarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy benh nhan!");
            return null;
        }

    }

    public BenhNhan timkiemBenhnhantheoten() {

        System.out.println("Nhập vào tên benh nhan cần tìm:");
        String name = scanner.nextLine();
        for (BenhNhan bn : benhnhanarr)
            if (bn.getMabenhnhan().equalsIgnoreCase(name)) {
                System.out.println(bn.toString());
                return bn;
            }
        if (!this.findMatchingStrings(benhnhanarr, name).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(benhnhanarr, name)) {
                System.out.println(str);

            }
            return null;

        } else {
            System.out.println("Không tìm thấy benh nhan!");
            return null;
        }

    }

    public void xoaBan() {

        System.out.println("Nhap ID benh nhan can xoa");
        BenhNhan b = timkiemBNtheoid();
        if (b == null) {
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
                        benhnhanarr.remove(b);
                        System.out.println("Da xoa");
                        BenhNhan.decrementSlg();
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

    public ArrayList<String> findMatchingStrings(ArrayList<BenhNhan> benhnhanarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (BenhNhan bn : benhnhanarr) {
            if (bn.getMabenhnhan().toLowerCase().contains(pattern.toLowerCase())
                    || bn.getName().toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(bn.toString());
            }

        }

        return matchingStrings;
    }

    public void suaBenhNhan() {

        System.out.println("Nhap ID benh nhan can sua");
        BenhNhan bn = timkiemBNtheoid();
        if (bn == null) {
            System.out.println("Khong tim thay");
            return;
        } else {

            boolean menu1 = true;
            while (menu1 == true) {
                System.out.println(
                        "1.Sửa  ID   2.Sửa Tên  3.Sua ngay sinh  4.Sua dia chi 5. Sua phai  6.Sua SDT  X.Thoát");
                String choice = scanner.nextLine();

                choice = choice.toLowerCase();
                switch (choice) {
                    case "1":
                        System.out.println("Nhập ID mới: ");
                        boolean isDuplicate = true;

                        while (isDuplicate) {
                            String newid = kt.KiemTraNhapMaKhoa();

                            String currentId = bn.getMabenhnhan();

                            if (newid.equalsIgnoreCase(currentId)) {
                                System.out.println("ID mới giống với ID hiện tại. Vui lòng nhập ID khác.");
                                continue;
                            }

                            isDuplicate = false;
                            for (BenhNhan benhnhan : this.benhnhanarr) {
                                if (newid.equalsIgnoreCase(benhnhan.getMabenhnhan())) {
                                    System.out.println("Không cho phép ID trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("Vui lòng nhập ID mới.");
                            } else {
                                bn.setMabenhnhan(newid);
                                System.out.println("Da luu");
                                break;
                            }
                        }
                        System.out.println(bn.toString());
                        menu1 = false; // Exit the while loop
                        break;

                    case "2":
                        System.out.println("Nhập ten mới: ");
                        String newname = kt.KiemTraNhapTen();
                        bn.setName(newname);
                        System.out.println("Da luu");
                        menu1 = false;
                        break;

                    case "3":
                        System.out.println("Nhập ngay sinh mới: ");
                        String newbd = kt.validateBirthday();
                        bn.setBirthday(newbd);
                        System.out.println("Da luu");
                        menu1 = false;
                        break;
                    case "4":

                        System.out.println("Nhập dia chi mới: ");
                        String newad = kt.KiemTraNhapChuoi();
                        bn.setAddress(newad);
                        System.out.println("Da luu");
                        menu1 = false;
                        break;
                    case "5":
                        System.out.println("Sua phai: ");
                        String gender = kt.validateGender();
                        bn.setGender(gender);
                        System.out.println("Da luu");
                        menu1 = false;
                        break;

                    case "6":
                        System.out.println("Sua so dien thoai: ");
                        String number = kt.validatePhoneNumber();
                        bn.setPhonenumber(number);
                        System.out.println("Da luu");
                        menu1 = false;
                        break;
                    case "x":
                        menu1 = false;
                        break;

                }

            }

        }

    }

    public void docFile(DSBENHNHAN ds) {
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
                        String property3 = properties[2].trim();
                        String property4 = properties[3].trim();
                        String property5 = properties[4].trim();
                        String property6 = properties[5].trim();

                        BenhNhan obj = new BenhNhan(property1, property2, property3, property4, property5, property6);

                        benhnhanarr.add(obj);
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
            for (BenhNhan bn : benhnhanarr) {
                if (bn != null) {
                    bufferedWriter.write(bn.getMabenhnhan() + ",  " + bn.getName() + ",  " + bn.getBirthday() + ",  "
                            + bn.getPhonenumber() + ",  " + bn.getAddress() + ",  " + bn.getGender());
                }
            }
            System.out.println("Array of BenhNhan has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vietFileauto(DSBENHNHAN ds, String file) {
        benhnhanarr.add(new BenhNhan("001", "Bùi Thị Ngọc Hoa", "12/01/1984", " 431 đường Liên Tỉnh, p5 - q8 - TP HCM",
                "Nữ", "0947746986"));
        benhnhanarr.add(new BenhNhan("002", "Trần Thanh Phong", "03/09/1994",
                " 22/98 Trần Bình Trọng, p1 - q5 - TP HCM", "Nam", "0816099200"));
        benhnhanarr.add(new BenhNhan("003", "Lê Thị Xuân", "24/12/1988", "178 An Dương Vương, p16 - q8 - TP HCM", "Nữ",
                "0777022540"));
        benhnhanarr.add(new BenhNhan("004", "Phan Tuấn Anh", "16/4/1993", "2/3B Chánh Hưng, p4 - q8 - TP HCM", "Nam",
                "0945822606"));
        benhnhanarr.add(new BenhNhan("005", "Võ Phước Triều", "15/07/1990", "17S Đường Bình Phú, p10 - q6 - TP HCM",
                "Nam", "0814926555"));
        benhnhanarr.add(new BenhNhan("006", "Trương Hồ Thảo Nhi", "11/03/1999",
                "Số 55 HT06, phường Hiệp Thanh - q12 - TP HCM", "Nữ", "0776922101"));
        benhnhanarr.add(new BenhNhan("007", "Lê Thị Hồng Gấm", "14/08/1980",
                "164/3/14 Lê Đính Thám, phường Tân Quý - Quận Tân Phú - TP HCM", "Nữ", "0943826444"));
        benhnhanarr.add(new BenhNhan("008", "Trương Gia Phú", "30/11/1898",
                "31 DDienj Biên Phủ, p15 - quận Bình Thạnh - TP HCM", "Nam", "0313824666"));
        benhnhanarr.add(new BenhNhan("009", "Hồ Trần Lan Anh", "03/12/1988", " 09 Đồng Nai, p15 - q10 - TP HCM", "Nữ",
                "0770938356"));
        benhnhanarr.add(new BenhNhan("010", "Trịnh văn Thanh", "11/03/1999", "25 Hồ Ngọc Lãm , p16 - q8 - TP HCM",
                "Nam", "0946928622"));
        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (BenhNhan bn : benhnhanarr) {
                if (bn != null) {
                    bufferedWriter.write(bn.getMabenhnhan() + ",  " + bn.getName() + ",  " + bn.getBirthday() + ",  "
                            + bn.getPhonenumber() + ",  " + bn.getAddress() + ",  " + bn.getGender());
                }
            }
            System.out.println("Array of BenhNhan has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(DSBENHNHAN ds) {

        String c;
        boolean menu = true;
        while (menu == true) {
            System.out.println("QUẢN LÍ DANH SACH BENH NHAN");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Thêm benh nhan");
            System.out.println("4. Tìm kiếm theo ID");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Xóa benh nhan");
            System.out.println("7. Sửa benh nhan");
            System.out.println("8. Nhập thông tin từ file");
            System.out.println("9. Xuất thông tin ra file");
            System.out.println("10. Exit");
            c = scanner.nextLine();
            switch (c) {
                case "1":
                    ds.nhapDSBenhNhan();
                    break;
                case "2":
                    ds.xuatDSBenhNhan();
                    break;
                case "3":
                    ds.themBenhNhan();
                    break;
                case "4":
                    ds.timkiemBNtheoid();
                    break;
                case "5":
                    ds.timkiemBenhnhantheoten();
                    break;
                case "6":
                    ds.xoaBan();
                    break;
                case "7":
                    ds.suaBenhNhan();
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
            menu = kt.TiepTuc(menu);
        }
    }

    public static void main(String argv[]) {
        DSBENHNHAN ds = new DSBENHNHAN();
        ds.main(ds);
    }

}
