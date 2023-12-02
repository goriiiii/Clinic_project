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
		boolean cont = true;
		while (cont == true) {

			System.out.println("Nhap vao so luong dich vu:");
			slg = Integer.parseInt(kt.KiemTraNhapSo());

			for (int i = 0; i < slg; i++) {
				DICHVU k = new DICHVU();
				k.NhapDichvu();

				boolean isDuplicate = true;
				for (DICHVU dv : dvarr) {
					isDuplicate = true;
					while (isDuplicate == true) {
						if (k.getId().equalsIgnoreCase(dv.getId())) {
							System.out.println("Khong cho phep ID trung lap!");
							isDuplicate = true;
							k.NhapDichvu();
						} else {
							isDuplicate = false;
						}
					}
				}
				dvarr.add(k);

			}
			cont = kt.TiepTuc(cont);
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

		String c;
		boolean menu = true;
		while (menu == true) {
			System.out.println("Lua chon tim kiem: 1.Theo ID  2.Theo ten  3.Xoa het  X.Thoat");
			c = scanner.nextLine();
			switch (c) {
				case "1":
					DICHVU dv = timkiemDichvutheoid();
					if (dv == null) {
						System.out.println("Khong tim thay de xoa!");
						break;
					} else
						dvarr.remove(dv);
					System.out.println("Da xoa!");

					break;
				case "2":
					DICHVU dv1 = timkiemDichvutheoten();
					if (dv1 == null) {
						System.out.println("Khong tim thay de xoa!");
						break;
					} else
						dvarr.remove(dv1);
					System.out.println("Da xoa!");
				case "3":
					dvarr.removeAll(dvarr);
					System.out.println("Da xoa");
					break;

				case "x":
					return;
				case "X":
					return;

				default:
					System.out.println("Lua chon khong hop le, hay nhap lai!");
					menu = true;
					break;
			}

			menu = kt.TiepTuc(menu);

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
		String c;
		boolean menu = true;
		while (menu == true) {
			System.out.println("Lua chon loai tim kiem de sua: 1.Theo ID  2.Theo ten   X.Thoat");
			c = scanner.nextLine();
			switch (c) {
				case "1":
					DICHVU dv = timkiemDichvutheoid();

					if (dv == null) {
						System.out.println("Khong tim thay de xoa!");
						break;
					} else {
						boolean menu1 = true;
						while (menu1 == true) {
							System.out.println("1.Sua ID  2.Sua ten   X.Thoat");
							String choice = scanner.nextLine();

							if (choice.matches("1")) {
								System.out.println("Nhập ID moi: ");
								dv.setId(kt.KiemTraNhapMaKhoa());
								dv.XuatDichvu();
								System.out.println("Tiep tuc sua thong tin?");
								menu1 = kt.TiepTuc(menu1);
							} else if (choice.matches("2")) {
								System.out.println("Nhap ten moi: ");
								dv.setTen(kt.KiemTraNhapTen());
								dv.XuatDichvu();
								System.out.println("Tiep tuc sua thong tin?");
								menu1 = kt.TiepTuc(menu1);
							} else if (choice.equalsIgnoreCase("x")) {
								menu1 = false;
							} else {
								System.out.println("Lua chon khong hop le!");
								menu1 = true;
							}
						}
						break;
					}
				case "2":
					DICHVU dv1 = timkiemDichvutheoten();
					if (dv1 == null) {
						System.out.println("Khong tim thay de xoa!");
						break;
					} else {

						boolean menu2 = true;
						while (menu2 == true) {
							System.out.println("1.Sua ID  2.Sua ten   X.Thoat");
							String choice = scanner.nextLine();

							if (choice.matches("1")) {
								System.out.println("Nhap ID moi: ");
								dv1.setId(kt.KiemTraNhapMaKhoa());
								dv1.XuatDichvu();
								System.out.println("Tiep tuc sua thong tin?");
								menu2 = kt.TiepTuc(menu2);
							} else if (choice.matches("2")) {
								System.out.println("Nhap ten moi: ");
								dv1.setTen(kt.KiemTraNhapTen());
								dv1.XuatDichvu();
								System.out.println("Tiep tuc sua thong tin?");
								menu2 = kt.TiepTuc(menu2);
							} else if (choice.equalsIgnoreCase("x")) {
								menu2 = false;
							} else {
								System.out.println("Lua chon khong hop le!");
								menu2 = true;
							}
						}
						break;
					}
				case "x":
					menu = false;
					break;
				case "X":
					menu = false;
					break;

				default:
					System.out.println("Lua chon khong hop le!!");
					menu = true;
					break;
			}
			System.out.println("Tiep tuc tim kiem de sua?");
			menu = kt.TiepTuc(menu);

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

	public static void main(String argv[]) {

		DSDICHVU ds = new DSDICHVU();

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
