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
                choice = choice.toLowerCase();
                switch (choice) {
                    case "1":
                        System.out.println("Nhập ID mới: ");
                        boolean isDuplicate = true;

                        while (isDuplicate) {
                            String newid = kt.KiemTraNhapMaKhoa();

                            String currentId = ns.getEmployeeId();

                            if (newid.equalsIgnoreCase(currentId)) {
                                System.out.println("ID mới giống với ID hiện tại. Vui lòng nhập ID khác.");
                                continue;
                            }

                            isDuplicate = false;
                            for (NHANSU nhansu : this.nvarr) {
                                if (newid.equalsIgnoreCase(nhansu.getEmployeeId())) {
                                    System.out.println("Không cho phép ID/CCCD trùng lặp!");
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("Vui lòng nhập ID mới.");
                            } else {
                                ns.setEmployeeId(newid);
                                break;
                            }
                        }
                        System.out.println(ns.toString());
                        menu1 = false; // Exit the while loop
                        break;

                    case "2":
                        System.out.println("Nhập ten mới: ");
                        String newname = kt.KiemTraNhapTen();
                        ns.setName(newname);
                        menu1 = false;
                        break;

                    case "3":
                        System.out.println("Nhập ngay sinh mới: ");
                        String newbd = kt.validateBirthday();
                        ns.setBirthday(newbd);
                        menu1 = false;
                        break;
                    case "4":

                        System.out.println("Nhập dia chi mới: ");
                        String newad = kt.KiemTraNhapChuoi();
                        ns.setAddress(newad);
                        menu1 = false;
                        break;
                    case "5":
                        System.out.println("Sua phai: ");
                        String gender = kt.validateGender();
                        ns.setGender(gender);
                        menu1 = false;
                        break;

                    case "6":
                        System.out.println("Sua cccd: ");
                        String cccd = kt.KiemTraNhapSo();
                        ns.setIdentificationCode(cccd);
                        menu1 = false;

                        break;

                    case "7":
                        System.out.println("Sua so dien thoai: ");
                        String number = kt.validatePhoneNumber();
                        ns.setPhonenumber(number);
                        menu1 = false;
                        break;
                    case "x":
                        menu1 = false;
                        break;

                }

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
                    // vietFileauto(ds, file);
                    read.close();
                    return;
                }
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] properties = line.split(",");

                    if (properties.length == 9) {
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
                        if (property8.equalsIgnoreCase("Hành chính")) {
                            ns = new NVHANHCHINH(property1, property2, property3, property4, property5, property6,
                                    property7, property9);

                            nvarr.add(ns);
                            read.close();
                        } else {
                            ns = new NVCHUYENMON(property1, property2, property3, property4, property5, property6,
                                    property7, property9);
                            nvarr.add(ns);
                        }

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
            for (NHANSU ns : nvarr) {
                if (ns != null) {
                    if (ns instanceof NVCHUYENMON) {
                        NVCHUYENMON nvChuyenMon = (NVCHUYENMON) ns;

                        bufferedWriter.write(ns.getName() + ", " + ns.getBirthday() + ", " + ns.getPhonenumber() + ", "
                                + ns.getAddress() + ", "
                                + ns.getGender() + ", " + ns.getEmployeeId() + ", " + ns.getIdentificationCode()
                                + ", Chuyên môn" + nvChuyenMon.getMA_KHOA());
                    } else {
                        NVHANHCHINH nvhanhchinh = (NVHANHCHINH) ns;

                        bufferedWriter.write(ns.getName() + ", " + ns.getBirthday() + ", " + ns.getPhonenumber() + ", "
                                + ns.getAddress() + ", "
                                + ns.getGender() + ", " + ns.getEmployeeId() + ", " + ns.getIdentificationCode()
                                + ", Hành chính" + nvhanhchinh.getMA_BAN());
                    }
                }
            }
            System.out.println("Array of NHANSU has been written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vietFileauto(DSNHANSU ds, String file) {

        //nvarr.add(new NVCHUYENMON("Hồ Trương Thảo Vân", "23/11/1993", "0774887411", "225 Lý Thường Kiệt, p14 - q10 - TP HCM", "Nữ", "001", "056874644", "MAT"));
        //nvarr.add(new NVHANHCHINH("Lê Nhật Nam", "10/04/1990", "0948938211", "52/1A Cư xá Lữ Gia, p15 - q11 - TP HCM", "Nam", "002", "052870074","TC"));   
        //nvarr.add(new NVCHUYENMON("Vũ Duy Thái Hùng", "12/08/1990", "0972465008", "322 Nguyễn Tri Phương, p4 - q10 - TP HCM", "Nam", "003", "048293811","NHI"));
        //nvarr.add(new NVCHUYENMON("Nguyễn Ngọc Trân", "19/07/1996", "0814845516", "12 Trịnh Đình Thảo, phường Hòa Thạnh - quận Tân Phú - TP HCM", "Nữ", "004", "054400913", "DL"));
        //nvarr.add(new NVCHUYENMON("Trần Dương Thảo Uyên", "26/11/1899", "0775112987", "20 Thạch Lam, phường Phú Thạnh - quận Tân Phú - TP HCM", "Nữ", "005", "059592271","TK"));   
        //nvarr.add(new NVHANHCHINH("Hà Thị NGọc Như", "22/01/1995", "0948918211", "124 Hồng Bàng, p12 - q5 - TP HCM", "Nữ", "006", "046292637","KT1"));
        //nvarr.add(new NVHANHCHINH("Dương Duy Tân", "16/05/1990", "0774365411", "82 Cửu Long, p15 - q10 - TP HCM", "Nam", "007", "028802817", "QLK"));
        //nvarr.add(new NVCHUYENMON("Đào Phú Nghĩa", "10/04/1990", "0989930008", "97 Trường Chinh, p12 - quận Tân Bình - TP HCM", "Nam", "008", "048392814","XN"));   
        //nvarr.add(new NVHANHCHINH("Vũ Thị Lan Anh", "29/02/1997", "0774933721", "155 Sư Vạn Hạnh, p13 - q10 - TP HCM", "Nữ", "009", "057391119","HC"));
        //nvarr.add(new NVHANHCHINH("Trương Tấn An", "14/11/1994", "0818937661", "46 Hoàng Việt, p4 - quận Tân Bình - TP HCM", "Nam", "010", "049275556","HC2"));
        
        // try (FileWriter fileWriter = new FileWriter(file, true);
        // BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

        // for (KHOA khoa : khoaarr) {
        // if (khoa != null) {
        // bufferedWriter.write(khoa.getId() +
        // " , " + khoa.getTen() + "\n");
        // }
        // }

        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        //
    }

    public void main(DSNHANSU ds) {

        String c;
        boolean menu = true;
        while (menu == true) {
            System.out.println("QUẢN LÍ DANH SACH NHAN SU");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Thêm nhan su");
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
                    ds.nhapDSNhansu();
                    break;
                case "2":
                    ds.xuatDSNhansu();
                    break;
                case "3":
                    ds.themNhansu();
                    break;
                case "4":
                    ds.timkiemNVtheoID();
                    break;
                case "5":
                    ds.timkiemNVtheoten();
                    break;
                case "6":
                    ds.xoaNhanvien();
                    break;
                case "7":
                    ds.suaNhanvien();
                    break;
                case "8":
                    // ds.docFile(ds);
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
}
