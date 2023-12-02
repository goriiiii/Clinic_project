// package CODE;

// import java.util.ArrayList;

// import java.io.*;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Scanner;

// public class DSNVHANHCHINH {
// static Scanner scanner = new Scanner(System.in);
// private int slg;
// KiemTra kt = new KiemTra();

// private ArrayList<NVHANHCHINH> nvhcarr;

// public DSNVHANHCHINH(int n, ArrayList<NVHANHCHINH> nvhcarr) {
// this.setSlg(n);
// this.nvhcarr = nvhcarr;
// }

// public DSNVHANHCHINH() {
// this.setSlg(0);
// this.nvhcarr = new ArrayList<NVHANHCHINH>();
// }

// public int getSlg() {
// return slg;
// }

// public void setSlg(int slg) {
// this.slg = slg;
// }

// public ArrayList<NVHANHCHINH> getNvhcarr() {
// return nvhcarr;
// }

// public void setNvhcarr(ArrayList<NVHANHCHINH> nvhcarr) {
// this.nvhcarr = nvhcarr;

// }

// public void nhapDSNvhc() {

// System.out.println("Nhập vào số lượng nhan vien hanh chinh:");
// slg = Integer.parseInt(kt.KiemTraNhapSo());

// for (int i = 0; i < slg; i++) {
// NVHANHCHINH n = new NVHANHCHINH();
// n.nhapThongTin();
// n.nhapThongTinNhanSu();
// n.nhapBoPhan();

// boolean isDuplicate = true;
// for (NVHANHCHINH nv : nvhcarr) {
// isDuplicate = true;
// while (isDuplicate == true) {
// if (n.getEmployeeId().equalsIgnoreCase(nv.getEmployeeId())) {
// System.out.println("Không cho phép ID trùng lặp!");
// isDuplicate = true;
// n.nhapThongTinNhanSu();
// } else {
// isDuplicate = false;
// }
// }
// }
// this.nvhcarr.add(n);

// }
// }

// public void xuatDSNvhc() {
// System.out.println("Danh sách các nhan vien hanh chinh: ");

// System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "ID", "Ho
// ten", "Ngay sinh", "Phai", "SDT",
// "Dia chi", "CCCD", "Ban");
// for (NVHANHCHINH nv : this.nvhcarr) {
// System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n",
// nv.getEmployeeId(), nv.getName(),
// nv.getBirthday(), nv.getGender(), nv.getPhonenumber(),
// nv.getAddress(), nv.getIdentificationCode(), nv.getMA_BAN());
// }
// }

// public void themNvhc() {

// System.out.println("Nhap nhan vien hanh chinh can them");
// nhapDSNvhc();

// }

// public NVHANHCHINH timkiemNVHCtheoid() {
// NVHANHCHINH nv = null;
// System.out.println("Nhập vào ID nhan vien cần tìm:");
// String id = scanner.nextLine();
// for (NVHANHCHINH nhanvien : nvhcarr)
// if (id.equalsIgnoreCase(nhanvien.getEmployeeId())) {
// nv = nhanvien;
// System.out.println(nv.toString());
// return nv;

// }
// if (!this.findMatchingStrings(nvhcarr, id).isEmpty()) {

// System.out.println("Có phải bạn muốn tìm: ");
// for (String str : this.findMatchingStrings(nvhcarr, id)) {
// System.out.println(str);
// }

// } else {
// System.out.println("Không tìm thấy nhan vien!");
// }
// return nv;
// }

// public NVHANHCHINH timkiemNVCMtheoten() {
// NVHANHCHINH nv = null;
// System.out.println("Nhập vào tên nhan vien cần tìm:");
// String name = scanner.nextLine();
// for (NVHANHCHINH n1 : nvhcarr)
// if (n1.getName().equalsIgnoreCase(name)) {
// nv = n1;
// System.out.println(nv.toString());

// return nv;
// }
// if (!this.findMatchingStrings(nvhcarr, name).isEmpty()) {

// System.out.println("Có phải bạn muốn tìm: ");
// for (String str : this.findMatchingStrings(nvhcarr, name)) {
// System.out.println(str);
// }

// } else {
// System.out.println("Không tìm thấy nhan vien!");
// }
// return nv;
// }

// public void xoaNhanvien() {
// System.out.println("Nhap ID khoa can xoa");
// KHOA k = timkiemKhoatheoid();
// if (k == null) {
// System.out.println("Không tìm thấy để xóa!");
// return;
// } else {
// k.toString();
// System.out.println("Xac nhan xoa? y|n");
// String choice = scanner.nextLine();
// choice.toLowerCase();
// boolean menu = true;
// while (menu == true) {
// switch (choice) {
// case "y":
// khoaarr.remove(k);
// System.out.println("Da xoa");
// KHOA.decrementSlg();
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

// public ArrayList<String> findMatchingStrings(ArrayList<NVHANHCHINH> nvhcarr,
// String pattern) {
// ArrayList<String> matchingStrings = new ArrayList<String>();

// for (NVHANHCHINH NV : nvhcarr) {
// if (NV.getName().toLowerCase().contains(pattern.toLowerCase())
// || NV.getEmployeeId().toLowerCase().contains(pattern.toLowerCase())) {
// matchingStrings.add(NV.toString());
// }

// }

// return matchingStrings;
// }

// public void suaKhoa() {

// System.out.println("Nhap ID dich vu can sua");
// KHOA k = timkiemKhoatheoid();
// if (k == null) {
// System.out.println("Khong tim thay");
// return;
// } else {

// boolean menu1 = true;
// while (menu1 == true) {
// System.out.println("1.Sửa khoa ID 2.Sửa Tên khoa 3.Thoát");
// String choice = scanner.nextLine();

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

// }

// }

// public void docFile(DSKHOA ds) {
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

// KHOA khoaobj = new KHOA(property1, property2);
// kt.formatChuoi(khoaobj.getTen());
// khoaarr.add(khoaobj);
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
// for (KHOA khoa : khoaarr) {
// if (khoa != null) {
// bufferedWriter.write(khoa.getId() +
// " , " + khoa.getTen() + "\n");
// }
// }
// System.out.println("Array of KHOA has been written to file.");

// } catch (IOException e) {
// e.printStackTrace();
// }
// }

// public void vietFileauto(DSKHOA ds, String file) {

// khoaarr.add(new KHOA("TM", "Tim mạch"));
// khoaarr.add(new KHOA("NHI", "NHI"));
// khoaarr.add(new KHOA("MAT", "Mắt"));
// khoaarr.add(new KHOA("VLTL", "Vật lý trị liệu"));
// khoaarr.add(new KHOA("TMH", "Tai - mũi -họng"));
// khoaarr.add(new KHOA("CC", "Cấp cứu"));
// khoaarr.add(new KHOA("YHCT", "Y học cổ truyền"));
// khoaarr.add(new KHOA("XN", "Xét nghiệm"));
// khoaarr.add(new KHOA("TK", "Thần kinh"));
// khoaarr.add(new KHOA("DL", "Da liễu"));

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
// }

// public void main(DSKHOA ds) {

// String c;
// boolean menu = true;
// while (menu == true) {
// System.out.println("QUẢN LÍ CÁC KHOA");
// System.out.println("1. Nhập danh sách");
// System.out.println("2. Xuất danh sách");
// System.out.println("3. Thêm khoa");
// System.out.println("4. Tìm kiếm theo ID");
// System.out.println("5. Tìm kiếm theo tên");
// System.out.println("6. Xóa khoa");
// System.out.println("7. Sửa khoa");
// System.out.println("8. Nhập thông tin từ file");
// System.out.println("9. Xuất thông tin ra file");
// System.out.println("10. Exit");
// c = scanner.nextLine();
// switch (c) {
// case "1":
// ds.nhapDSKhoa();
// break;
// case "2":
// ds.xuatDSKhoa();
// break;
// case "3":
// ds.themKhoa();
// break;
// case "4":
// ds.timkiemKhoatheoid();
// break;
// case "5":
// ds.timkiemKhoatheoten();
// break;
// case "6":
// ds.xoaKhoa();
// break;
// case "7":
// ds.suaKhoa();
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
