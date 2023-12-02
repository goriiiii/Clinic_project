package CODE;

import java.util.ArrayList;

import java.io.*;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DSDICHVU {
	static Scanner scanner = new Scanner(System.in);
	private int slg;
	KiemTra kt = new KiemTra();

	private ArrayList<DICHVU> dvarr;

	public DSDICHVU(int n, ArrayList<DICHVU> dvarr) {
		this.setSlg(n);
		this.dvarr = dvarr;
	}

	public DSDICHVU() {
		this.setSlg(0);
		dvarr = new ArrayList<DICHVU>();
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}

	public ArrayList<DICHVU> getKhoaarr() {
		return dvarr;
	}

	public void setKhoaarr(ArrayList<DICHVU> dvarr) {
		this.dvarr = dvarr;

	}

	public void nhapDSDichvu() {

		System.out.println("Nhập vào số lượng dich vu:");
		slg = Integer.parseInt(kt.KiemTraNhapSo());

		for (int i = 0; i < slg; i++) {
			DICHVU dv = new DICHVU();

			boolean isDuplicate = true;
			while (isDuplicate) {
				dv.NhapDichvu();();
				isDuplicate = false;

				for (DICHVU dichvu : this.dvarr) {
					if (dv.getId().equalsIgnoreCase(dichvu.getId())) {

						System.out.println("Không cho phép ID trùng lặp!");
						isDuplicate = true;
						break;

					}
				}
			}
			dvarr.add(dv);

		}
	}

	public void xuatDSDichvu() {
		System.out.println("Danh sach cac dich vu: ");

		System.out.printf("%-12s%-12s%-12s\n", "ID", "Dich vuụ", "Gia");
		System.out.println("_________________________________");
		for (DICHVU dv : this.dvarr) {
			System.out.printf("%-12s%-12s%-12s\n", dv.getId(), dv.getTen(), dv.getPrice());
		}
	}

	public void themDichvu() {
		System.out.println("Nhap de them dich vu");
		nhapDSDichvu();
	}

	public DICHVU timkiemDichvutheoid() {
		DICHVU k = null;
		System.out.println("Nhap vao ID dich vu can tim:");
		String id = kt.KiemTraNhapChuoi();
		for (DICHVU k1 : dvarr)
			if (k1.getId().equalsIgnoreCase(id)) {
				k = k1;
				System.out.println(k.toString());
				return k;

			}
		if (!this.findMatchingStrings(dvarr, id).isEmpty()) {

			System.out.println("Co phai ban muon tim: ");
			for (String str : this.findMatchingStrings(dvarr, id)) {
				System.out.println(str);
			}

		} else {
			System.out.println("Khong tim thay!");
		}
		return k;
	}

	public DICHVU timkiemDichvutheoten() {
		DICHVU k = null;
		System.out.println("Nhap vao ten khoa can tim:");
		String name = scanner.nextLine();
		for (DICHVU k1 : dvarr)
			if (k1.getTen().equalsIgnoreCase(name)) {
				k = k1;
				System.out.println(k.toString());

				return k;
			}
		if (!this.findMatchingStrings(dvarr, name).isEmpty()) {

			System.out.println("Co phai ban muon tim: ");
			for (String str : this.findMatchingStrings(dvarr, name)) {
				System.out.println(str);
			}

		} else {
			System.out.println("Khong tim thay!");
		}
		return k;
	}

	public void xoaDV() {
		System.out.println("Nhap ID ban can xoa");
		DICHVU DV = timkiemDichvutheoid();
		if (DV == null) {
			System.out.println("Không tìm thấy để xóa!");
			return;
		} else {
			DV.toString();
			System.out.println("Xac nhan xoa? y|n");
			String choice = scanner.nextLine();
			choice.toLowerCase();
			boolean menu = true;
			while (menu == true) {
				switch (choice) {
					case "y":
						dvarr.remove(DV);
						System.out.println("Da xoa");
						DICHVU.decrementSlg();
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

	public ArrayList<String> findMatchingStrings(ArrayList<DICHVU> dvarr2, String pattern) {
		ArrayList<String> matchingStrings = new ArrayList<String>();

		for (DICHVU dv : dvarr) {
			if (dv.getTen().toLowerCase().contains(pattern.toLowerCase())
					|| dv.getId().toLowerCase().contains(pattern.toLowerCase())) {
				matchingStrings.add(dv.toString());
			}

		}

		return matchingStrings;
	}

	public void suaDichvu() {
		System.out.println("Nhap ID dich vu can sua");
		DICHVU DV = timkiemDichvutheoid();
		if (DV == null) {
			System.out.println("Khong tim thay");
			return;
		} else {

			boolean menu1 = true;
			while (menu1 == true) {
				System.out.println("1.Sửa Dich vu ID   2.Sửa Tên Dich vu  3.Thoát");
				String choice = scanner.nextLine();

				if (choice.matches("1")) {
					System.out.println("Nhập ID mới: ");

					DICHVU dv1 = new DICHVU();
					dv1.setTen(DV.getTen());
					dv1.setId(kt.KiemTraNhapMaKhoa());

					boolean isDuplicate = true;
					for (DICHVU dv : this.dvarr) {
						isDuplicate = true;
						while (isDuplicate == true) {
							if (dv1.getId().equalsIgnoreCase(dv.getId())) {
								System.out.println("Không cho phép ID trùng lặp!");
								isDuplicate = true;
								dv1.setId(kt.KiemTraNhapMaKhoa());
							} else {
								isDuplicate = false;
							}
						}
					}
					dvarr.add(dv1);
					dvarr.remove(DV);
					System.out.println("Lựa chọn tiếp tục sửa thêm?");
					menu1 = kt.TiepTuc(menu1);
				} else if (choice.matches("2")) {
					System.out.println("Nhập ten mới: ");

					DV.setTen(kt.KiemTraNhapTen());

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

	public void docFile(DSDICHVU ds) {
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
				if (!read.hasNext()) { // Check if the file is empty
					System.out.println("File is empty. Generating content...");
					vietFileauto(ds, file); // Call vietFile to generate content

					return;
				}
				while (read.hasNextLine()) {
					String line = read.nextLine();
					String[] properties = line.split(",");

					if (properties.length >= 3) { // Ensure you have at least two properties in the line
						String property1 = properties[0].trim();
						String property2 = properties[1].trim();
						String property3 = properties[2].trim();

						DICHVU dvobj = new DICHVU(property1, property2, Integer.parseInt(property3));
						kt.formatChuoi(dvobj.getTen());
						this.dvarr.add(dvobj);

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
		List<DICHVU> duplicatesToRemove = new ArrayList<>();

		for (DICHVU dv : dvarr) {
			String currentId = dv.getId().toLowerCase();

			if (uniqueIds.contains(currentId)) {
				System.out.println("ID trung lap: " + dv.getId());
				duplicatesToRemove.add(dv);
			} else {
				uniqueIds.add(currentId);
			}
		}

		dvarr.removeAll(duplicatesToRemove);
		System.out.println("Go bo nhung ID trung lap thanh cong");

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

			// Loop through the array and write each product's information to the file
			for (DICHVU dv : dvarr) {
				if (dv != null) {
					bufferedWriter.write(dv.getId() +
							" , " + dv.getTen() + ", " + dv.getPrice() + "\n");
				}
			}
			System.out.println("Array of DICHVU has been written to file.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void vietFileauto(DSDICHVU ds, String file) {
		dvarr.add(new DICHVU("KB", "Khám bệnh", 100000));
		dvarr.add(new DICHVU("SA", "Siêu âm", 100000));
		dvarr.add(new DICHVU("XQ", "X Quang", 100000));
		dvarr.add(new DICHVU("XN", "Xét nghiệm", 100000));
		dvarr.add(new DICHVU("PHCN", "Phục hồi chức năng", 100000));
		dvarr.add(new DICHVU("DT", "Điện tim", 100000));

		try (FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			for (DICHVU dv : dvarr) {
				if (dv != null) {
					bufferedWriter.write(dv.getId() +
							" , " + dv.getTen() + ", " + dv.getPrice() + "\n");
				}
			}
			System.out.println("Array of KHOA has been written to file.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void main(DSDICHVU ds) {

		String c;
		boolean menu = true;
		while (menu == true) {
			System.out.println("	QUAN LI CAC DICH VU");
			System.out.println("1. Nhap danh sach");
			System.out.println("2. Xuat danh sach");
			System.out.println("3. Them");
			System.out.println("4. Tim kiem theo ID");
			System.out.println("5. Tim kiem theo ten");
			System.out.println("6. Xoa");
			System.out.println("7. Sua");
			System.out.println("8. Nhap thong tin tu file");
			System.out.println("9. Xuat thong tin ra file");
			System.out.println("10. Exit");
			c = scanner.nextLine();
			switch (c) {
				case "1":
					ds.nhapDSDichvu();
					break;
				case "2":
					ds.xuatDSDichvu();
					break;
				case "3":
					ds.themDichvu();
					break;
				case "4":
					ds.timkiemDichvutheoid();
					break;
				case "5":
					ds.timkiemDichvutheoten();
					break;
				case "6":
					ds.xoaDV();
					break;
				case "7":
					ds.suaDichvu();
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
					System.out.println("Lua chon khong hop le!");
					menu = true;
					break;
			}
		}

	}

}
