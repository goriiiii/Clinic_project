package CODE;

import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

public class DSNHANSU {
    static Scanner scanner = new Scanner(System.in);
    private int slg;
    KiemTra kt = new KiemTra();

    private ArrayList<NHANSU> nvarr;

    public DSNHANSU(int n, ArrayList<NHANSU> nvarr) {
        this.setSlg(n);
        this.nvarr = nvarr;
    }

    public DSNHANSU() {
        this.setSlg(0);
        nvarr = new ArrayList<NHANSU>();

    }

    public int getSlg() {
        return slg;
    }

    public void setSlg(int slg) {
        this.slg = slg;
    }

    public ArrayList<NHANSU> getNvarr() {
        return nvarr;

    }

    public void setNvarr(ArrayList<NHANSU> nvarr) {
        this.nvarr = nvarr;

    }

    public void nhapDSNhansu() {

        System.out.println("Nhập vào số lượng nhan vien:");
        slg = Integer.parseInt(kt.KiemTraNhapSo());

        for (int i = 0; i < slg; i++) {
            NHANSU ns = null;
            boolean menu = true;
            while (menu == true) {

                System.out.println("Phan loai nhan vien:  1. Hanh chinh   2.Chuyen mon");
                String choice = kt.KiemTraNhapSo();
                switch (choice) {
                    case "1":
                        ns = new NVHANHCHINH();
                        menu = false;
                        break;

                    case "2":
                        ns = new NVCHUYENMON();
                        menu = false;
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        menu = true;
                        break;
                }
            }
            ns.nhapThongTin();

            ns.nhapBoPhan();
            boolean isDuplicate = true;
            while (isDuplicate) {
                ns.nhapThongTinNhanSu();
                isDuplicate = false;

                for (NHANSU nhansu : this.nvarr) {
                    if (ns.getEmployeeId().equalsIgnoreCase(nhansu.getEmployeeId())
                            || ns.getIdentificationCode().equalsIgnoreCase(nhansu.getIdentificationCode())) {
                        System.out.println("Không cho phép ID/CCCD trùng lặp!");
                        isDuplicate = true;
                        break;

                    }
                }
            }
            nvarr.add(ns);

        }

    }

    public void themNhansu()

    {
        System.out.println("Nhap so luong nhan vien can them");
        nhapDSNhansu();
    }

    public void xuatDSNhansu() {
        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "ID", "Ho ten", "Ngay sinh",
                "Phai",
                "SDT",
                "Dia chi", "CCCD", "Phan loai", "Ma bo phan");
        for (NHANSU nhansu : nvarr) {
            if (nhansu instanceof NVHANHCHINH) {
                NVHANHCHINH nvHanhChinh = (NVHANHCHINH) nhansu;
                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                        nhansu.getEmployeeId(), nhansu.getName(),
                        nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                        nhansu.getAddress(), nhansu.getIdentificationCode(), "Hanh chinh",
                        nvHanhChinh.getMA_BAN());

            } else {
                NVCHUYENMON nvChuyenMon = (NVCHUYENMON) nhansu;
                System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n",
                        nhansu.getEmployeeId(), nhansu.getName(),
                        nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                        nhansu.getAddress(), nhansu.getIdentificationCode(), "Chuyen mon",
                        nvChuyenMon.getMA_KHOA());

            }
        }
    }

    public NHANSU timkiemNVtheoID() {
        NHANSU ns = null;
        System.out.println("Nhập vào ID nhan vien cần tìm:");
        String id = kt.KiemTraNhapChuoi();
        for (NHANSU nhansu : nvarr)
            if (nhansu.getEmployeeId().equalsIgnoreCase(id)) {
                ns = nhansu;
                if (ns instanceof NVHANHCHINH) {
                    NVHANHCHINH nvHanhChinh = (NVHANHCHINH) nhansu;
                    System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                            nhansu.getEmployeeId(), nhansu.getName(),
                            nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                            nhansu.getAddress(), nhansu.getIdentificationCode(), "Hanh chinh",
                            nvHanhChinh.getMA_BAN());
                    return ns;
                } else {
                    NVCHUYENMON nvChuyenMon = (NVCHUYENMON) nhansu;
                    System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n",
                            nhansu.getEmployeeId(), nhansu.getName(),
                            nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                            nhansu.getAddress(), nhansu.getIdentificationCode(), "Chuyen mon",
                            nvChuyenMon.getMA_KHOA());
                }

            }
        if (!this.findMatchingStrings(nvarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(nvarr, id)) {
                System.out.println(str);
            }

        } else {
            System.out.println("Không tìm thấy!");
        }
        return ns;
    }

    public NHANSU timkiemNVtheoten() {
        NHANSU ns = null;
        System.out.println("Nhập vào ten nhan vien cần tìm:");
        String ten = kt.KiemTraNhapChuoi();
        for (NHANSU nhansu : nvarr)
            if (nhansu.getName().equalsIgnoreCase(ten)) {
                ns = nhansu;
                if (ns instanceof NVHANHCHINH) {
                    NVHANHCHINH nvHanhChinh = (NVHANHCHINH) nhansu;
                    System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                            nhansu.getEmployeeId(), nhansu.getName(),
                            nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                            nhansu.getAddress(), nhansu.getIdentificationCode(), "Hanh chinh",
                            nvHanhChinh.getMA_BAN());
                    return ns;
                } else {
                    NVCHUYENMON nvChuyenMon = (NVCHUYENMON) nhansu;
                    System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n",
                            nhansu.getEmployeeId(), nhansu.getName(),
                            nhansu.getBirthday(), nhansu.getGender(), nhansu.getPhonenumber(),
                            nhansu.getAddress(), nhansu.getIdentificationCode(), "Chuyen mon",
                            nvChuyenMon.getMA_KHOA());
                }

            }
        if (!this.findMatchingStrings(nvarr, ten).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(nvarr, ten)) {
                System.out.println(str);
            }

        } else {
            System.out.println("Không tìm thấy!");
        }
        return ns;
    }

    public ArrayList<String> findMatchingStrings(ArrayList<NHANSU> nvarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (NHANSU ns : nvarr) {
            if (ns.getName().toLowerCase().contains(pattern.toLowerCase())
                    || ns.getEmployeeId().toLowerCase().contains(pattern.toLowerCase())) {
                if (ns instanceof NVCHUYENMON) {
                    NVCHUYENMON nvChuyenMon = (NVCHUYENMON) ns;
                    String formattedString = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n",
                            ns.getEmployeeId(), ns.getName(),
                            ns.getBirthday(), ns.getGender(), ns.getPhonenumber(),
                            ns.getAddress(), ns.getIdentificationCode(), "Chuyen mon",
                            nvChuyenMon.getMA_KHOA());
                    matchingStrings.add(formattedString);
                } else {
                    NVHANHCHINH nvHanhChinh = (NVHANHCHINH) ns;
                    String formattedString = String.format("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                            ns.getEmployeeId(), ns.getName(),
                            ns.getBirthday(), ns.getGender(), ns.getPhonenumber(),
                            ns.getAddress(), ns.getIdentificationCode(), "Hanh chinh",
                            nvHanhChinh.getMA_BAN());
                    matchingStrings.add(formattedString);
                }
            }

        }

        return matchingStrings;
    }

    public void xoaNhanvien() {
        System.out.println("Nhap ID nhan vien can xoa");
        NHANSU nv = timkiemNVtheoID();
        if (nv == null) {
            System.out.println("Không tìm thấy để xóa!");
            return;
        } else {
            nv.toString();
            System.out.println("Xac nhan xoa? y|n");
            String choice = scanner.nextLine();
            choice.toLowerCase();
            boolean menu = true;
            while (menu == true) {
                switch (choice) {
                    case "y":
                        nvarr.remove(nv);
                        System.out.println("Da xoa");
                        NHANSU.decrementSlg();
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

    public void suaNhanvien() {

        System.out.println("Nhap ID nhan vien can sua");
        NHANSU ns = timkiemNVtheoID();
        if (ns == null) {
            System.out.println("Khong tim thay");
            return;
        } else {

            boolean menu1 = true;
            while (menu1 == true) {
                System.out.println(
                        "1.Sửa ID   2.Sửa Tên 3. Sua ngay sinh  4.Sua dia chi  5.sua phai  6.Sua cccd  7.sua sdt  X.Thoát");
                String choice = scanner.nextLine();

                // if (choice.matches("1")) {
                // System.out.println("Nhập ID mới: ");

                // KHOA k1 = new KHOA();
                // k1.setTen(k.getTen());
                // k.setId(kt.KiemTraNhapMaKhoa());

                // boolean isDuplicate = true;
                // for (KHOA khoa : this.khoaarr) {
                // isDuplicate = true;
                // while (isDuplicate == true) {
                // if (k1.getId().equalsIgnoreCase(khoa.getId())) {
                // System.out.println("Không cho phép ID trùng lặp!");
                // isDuplicate = true;
                // k1.setId(kt.KiemTraNhapMaKhoa());
                // } else {
                // isDuplicate = false;
                // }
                // }
                // }

                // khoaarr.add(k1);
                // khoaarr.remove(k);
                // KHOA.decrementSlg();
                // System.out.println("Lựa chọn tiếp tục sửa thêm?");
                // menu1 = kt.TiepTuc(menu1);
                // } else if (choice.matches("2")) {
                // System.out.println("Nhập ten mới: ");

                // k.setTen(kt.KiemTraNhapTen());

                // System.out.println("Lựa chọn tiếp tục sửa thêm?");
                // menu1 = kt.TiepTuc(menu1);
                // } else if (choice.matches("3")) {
                // menu1 = false;
                // } else {
                // System.out.println("Nhập không hợp lệ, vui lòng lựa chọn 1 hoặc"
                // + " 2 hoặc 3 ");
                // menu1 = true;
                // }
                // }
            }
        }

    }

    public void docFile(DSKHOA ds) {
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

                    if (properties.length ==9) {
                        String property1 = properties[0].trim();
                        String property2 = properties[1].trim();
                        String property3 = properties[2].trim();
                        String property4 = properties[3].trim();
                        String property5 = properties[4].trim();
                        String property6 = properties[5].trim();
                        String property7 = properties[6].trim();
                        String property8 = properties[7].trim();
                        String property9 = properties[8].trim();
                        NHANSU ns;
                      if(property8.equalsIgnoreCase("Hành chính")){
                        ns=new NVHANHCHINH(property1,property2,property3,property4,property5,property6,property7,property9);
                      
                        nvarr.add(ns);
                        read.close();
                    } else {
                         ns=new NVCHUYENMON(property1,property2,property3,property4,property5,property6,property7,property9);
                       nvarr.add(ns);
                    }
                   
                }

            } else {
                System.out.println("File không tồn tại");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void main(String argv[]) {
        DSNHANSU ds = new DSNHANSU();
        ds.nhapDSNhansu();
        ds.xuatDSNhansu();
    }

}

// public void xuatDSBan() {
// System.out.println("Danh sách các ban: ");

// System.out.printf("%-12s%-12s\n", "ID", "Ban");
// for (BAN b : this.banarr) {
// System.out.printf("%-12s%-12s\n", b.getId(), b.getTen());
// }
// }

// public void themBan() {

// System.out.println("Nhap ban can them");
// nhapDSBan();

// }

// public BAN timkiemBantheoid() {

// System.out.println("Nhập vào ID ban cần tìm:");
// String id = kt.KiemTraNhapChuoi();
// for (BAN b1 : banarr)
// if (b1.getId().equalsIgnoreCase(id)) {
// ;
// System.out.println(b1.toString());
// return b1;
// }
// if (!this.findMatchingStrings(banarr, id).isEmpty()) {

// System.out.println("Có phải bạn muốn tìm: ");
// for (String str : this.findMatchingStrings(banarr, id)) {
// System.out.println(str);
// }
// return null;

// } else {
// System.out.println("Không tìm thấy ban!");
// return null;
// }

// }

// public BAN timkiemBantheoten() {

// System.out.println("Nhập vào tên ban cần tìm:");
// String name = scanner.nextLine();
// for (BAN b1 : banarr)
// if (b1.getTen().equalsIgnoreCase(name)) {
// System.out.println(b1.toString());
// return b1;
// }
// if (!this.findMatchingStrings(banarr, name).isEmpty()) {

// System.out.println("Có phải bạn muốn tìm: ");
// for (String str : this.findMatchingStrings(banarr, name)) {
// System.out.println(str);

// }
// return null;

// } else {
// System.out.println("Không tìm thấy ban!");
// return null;
// }

// }

// public void xoaBan() {

// System.out.println("Nhap ID ban can xoa");
// BAN b = timkiemBantheoid();
// if (b == null) {
// System.out.println("Không tìm thấy để xóa!");
// return;
// } else {
// b.toString();
// System.out.println("Xac nhan xoa? y|n");
// String choice = scanner.nextLine();
// choice.toLowerCase();
// boolean menu = true;
// while (menu == true) {
// switch (choice) {
// case "y":
// banarr.remove(b);
// System.out.println("Da xoa");
// BAN.decrementSlg();
// menu = false;
// break;
// case "n":
// menu = false;
// break;
// default:
// System.out.println("Lua chon khong hop le");
// menu = true;
// break;
// }
// }
// }
// }

// public ArrayList<String> findMatchingStrings(ArrayList<BAN> banarr, String
// pattern) {
// ArrayList<String> matchingStrings = new ArrayList<String>();

// for (BAN b : banarr) {
// if (b.getTen().toLowerCase().contains(pattern.toLowerCase())
// || b.getId().toLowerCase().contains(pattern.toLowerCase())) {
// matchingStrings.add(b.toString());
// }

// }

// return matchingStrings;
// }

// public void suaBan() {

// System.out.println("Nhap ID ban can sua");
// BAN b = timkiemBantheoid();
// if (b == null) {
// System.out.println("Khong tim thay");
// return;
// } else {

// boolean menu1 = true;
// while (menu1 == true) {
// System.out.println("1.Sửa Ban ID 2.Sửa Tên Ban 3.Thoát");
// String choice = scanner.nextLine();

// if (choice.matches("1")) {
// System.out.println("Nhập ID mới: ");

// BAN b1 = new BAN();
// b1.setTen(b.getTen());
// b1.setId(kt.KiemTraNhapMaKhoa());

// boolean isDuplicate = true;
// for (BAN ban : this.banarr) {
// isDuplicate = true;
// while (isDuplicate == true) {
// if (b1.getId().equalsIgnoreCase(ban.getId())) {
// System.out.println("Không cho phép ID trùng lặp!");
// isDuplicate = true;
// b1.setId(kt.KiemTraNhapMaKhoa());
// } else {
// isDuplicate = false;
// }
// }
// }
// banarr.add(b1);
// banarr.remove(b);
// System.out.println("Lựa chọn tiếp tục sửa thêm?");
// menu1 = kt.TiepTuc(menu1);
// } else if (choice.matches("2")) {
// System.out.println("Nhập ten mới: ");

// b.setTen(kt.KiemTraNhapTen());

// System.out.println("Lựa chọn tiếp tục sửa thêm?");
// menu1 = kt.TiepTuc(menu1);
// } else if (choice.matches("3")) {
// menu1 = false;
// } else {
// System.out.println("Nhập không hợp lệ, vui lòng lựa chọn 1 hoặc"
// + " 2 hoặc 3 ");
// menu1 = true;
// }
// }

// }

// }

// public void docFile(DSBAN ds) {
// System.out.println("Nhập đường dẫn của file: ");
// String file = scanner.nextLine();
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < file.length(); i++) {
// char currentChar = file.charAt(i);
// if (currentChar != '\"') {
// sb.append(currentChar);
// }
// if (currentChar == '\\') {
// sb.append("\\");
// }
// }
// System.out.println(sb);
// file = sb.toString();
// try {
// File f = new File(file);

// if (f.exists()) {
// Scanner read = new Scanner(f);
// if (!read.hasNext()) {
// System.out.println("File is empty. Generating content...");
// vietFileauto(ds, file);
// read.close();
// return;
// }
// while (read.hasNextLine()) {
// String line = read.nextLine();
// String[] properties = line.split(",");

// if (properties.length == 2) {
// String property1 = properties[0].trim();
// String property2 = properties[1].trim();

// BAN banobj = new BAN(property1, property2);
// kt.formatChuoi(banobj.getTen());
// banarr.add(banobj);
// read.close();
// } else {
// System.out.println("Invalid format in the line: " + line);
// return;
// }
// }

// } else {
// System.out.println("File không tồn tại");
// }
// } catch (Exception e) {
// e.printStackTrace();

// }

// }

// public void vietFile() {

// System.out.println("Nhập đường dẫn file để viết: ");
// String file = scanner.nextLine();
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < file.length(); i++) {
// char currentChar = file.charAt(i);
// if (currentChar != '\"') {
// sb.append(currentChar);
// }
// if (currentChar == '\\') {
// sb.append("\\");
// }
// }
// System.out.println(sb);
// file = sb.toString();
// try (FileWriter fileWriter = new FileWriter(file, true);
// BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
// for (BAN ban : banarr) {
// if (ban != null) {
// bufferedWriter.write(ban.getId() +
// " , " + ban.getTen() + "\n");
// }
// }
// System.out.println("Array of BAN has been written to file.");

// } catch (IOException e) {
// e.printStackTrace();
// }
// }

// public void vietFileauto(DSBAN ds, String file) {

// banarr.add(new BAN("TC", "Tài chính"));
// banarr.add(new BAN("KT1", "Kế toán"));
// banarr.add(new BAN("KT2", "Kế toán"));
// banarr.add(new BAN("QLK", "Quản lý cung ứng"));
// banarr.add(new BAN("HC", "Hành chính tiếp đón"));
// banarr.add(new BAN("HC2", "Quản lý nhân sự"));

// try (FileWriter fileWriter = new FileWriter(file, true);
// BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

// for (BAN b : banarr) {
// if (b != null) {
// bufferedWriter.write(b.getId() +
// " , " + b.getTen() + "\n");
// }
// }

// } catch (IOException e) {
// e.printStackTrace();
// }
// }

// public void main(DSBAN ds) {

// String c;
// boolean menu = true;
// while (menu == true) {
// System.out.println("QUẢN LÍ CÁC BAN");
// System.out.println("1. Nhập danh sách");
// System.out.println("2. Xuất danh sách");
// System.out.println("3. Thêm ban");
// System.out.println("4. Tìm kiếm theo ID");
// System.out.println("5. Tìm kiếm theo tên");
// System.out.println("6. Xóa ban");
// System.out.println("7. Sửa ban");
// System.out.println("8. Nhập thông tin từ file");
// System.out.println("9. Xuất thông tin ra file");
// System.out.println("10. Exit");
// c = scanner.nextLine();
// switch (c) {
// case "1":
// ds.nhapDSBan();
// break;
// case "2":
// ds.xuatDSBan();
// break;
// case "3":
// ds.themBan();
// break;
// case "4":
// ds.timkiemBantheoid();
// break;
// case "5":
// ds.timkiemBantheoten();
// break;
// case "6":
// ds.xoaBan();
// break;
// case "7":
// ds.suaBan();
// break;
// case "8":
// ds.docFile(ds);
// break;
// case "9":
// ds.vietFile();
// break;
// case "10":
// menu = false;
// break;
// default:
// System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại");
// menu = true;
// break;
// }
// }
// }

// }
