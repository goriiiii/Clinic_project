package CODE;

import java.util.ArrayList;

public class DSPHIEUKHAM {
    KiemTra kt = new KiemTra();
    private ArrayList<PhieuKham> phieukhamarr = new ArrayList<PhieuKham>();

    public ArrayList<PhieuKham> getPhieukhamarr() {
        return phieukhamarr;
    }

    public void setPhieukhamarr(ArrayList<PhieuKham> phieukhamarr) {
        this.phieukhamarr = phieukhamarr;
    }

    public PhieuKham timphieukhamtheoid() {
        System.out.println("Nhap ID cua phieu kham can tim");
        String id = kt.KiemTraNhapChuoi();
        for (PhieuKham pk : phieukhamarr)
            if (pk.IDPhieuKham.equalsIgnoreCase(id)) {

                System.out.println(pk.toString());
                return pk;
            }
        if (!this.findMatchingStrings(phieukhamarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(phieukhamarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy!");
            return null;
        }

    }

    public PhieuKham timphieukhamtheoidbacsi() {
        System.out.println("Nhap ID bac si cua phieu kham can tim");
        String id = kt.KiemTraNhapChuoi();
        for (PhieuKham pk : phieukhamarr)
            if (pk.IDBacSi.equalsIgnoreCase(id)) {

                System.out.println(pk.toString());
                return pk;
            }
        if (!this.findMatchingStrings(phieukhamarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(phieukhamarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy!");
            return null;
        }

    }

    public PhieuKham timphieukhamtheoidbenhnhan() {
        System.out.println("Nhap ID benh nhan cua phieu kham can tim");
        String id = kt.KiemTraNhapChuoi();
        for (PhieuKham pk : phieukhamarr)
            if (pk.IDBenhNhan.equalsIgnoreCase(id)) {

                System.out.println(pk.toString());
                return pk;
            }
        if (!this.findMatchingStrings(phieukhamarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(phieukhamarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy!");
            return null;
        }

    }

    public PhieuKham timphieukhamtheongaythang() {
        System.out.println("Nhap ngay thang cua phieu kham can tim");
        String id = kt.validateBirthday();
        for (PhieuKham pk : phieukhamarr)
            if (pk.ngaythang.equalsIgnoreCase(id)) {

                System.out.println(pk.toString());
                return pk;
            }
        if (!this.findMatchingStrings(phieukhamarr, id).isEmpty()) {

            System.out.println("Có phải bạn muốn tìm: ");
            for (String str : this.findMatchingStrings(phieukhamarr, id)) {
                System.out.println(str);
            }
            return null;

        } else {
            System.out.println("Không tìm thấy!");
            return null;
        }

    }

    public ArrayList<String> findMatchingStrings(ArrayList<PhieuKham> phieukhamarr, String pattern) {
        ArrayList<String> matchingStrings = new ArrayList<String>();

        for (PhieuKham pk : phieukhamarr) {
            if (pk.IDBacSi.toLowerCase().contains(pattern.toLowerCase())
                    || pk.IDBenhNhan.toLowerCase().contains(pattern.toLowerCase())
                    || pk.IDPhieuKham.toLowerCase().contains(pattern.toLowerCase())
                    || pk.ngaythang.toLowerCase().contains(pattern.toLowerCase())) {
                matchingStrings.add(pk.toString());
            }

        }
        return matchingStrings;
    }

    public void main() {
        boolean menu = true;

        while (menu == true) {

            System.out.println("1. Tạo phiêu khám mới");
            System.out.println("2. In ra phieu kham");
            System.out.println("3. Tìm phiếu theo mã bác sĩ");
            System.out.println("4. Tim phieu theo ma benh nhan");
            System.out.println("5. Tim phieu theo ngay");
            System.out.println("6. Tim kiem theo ma phieu");
            System.err.println("7. Huy phieu");

            System.out.println("8. In ra tat ca phieu kham");
            System.out.println("9. Thoat");
            String choice = kt.KiemTraNhapSo();
            switch (choice) {
                case "1":

                    PhieuKham p = new PhieuKham();
                    System.out.println("Nhap ma phieu kham: ");
                    p.IDPhieuKham = kt.KiemTraNhapMaKhoa();
                    System.out.println("Nhap ma benh nhan");
                    p.IDBenhNhan = kt.KiemTraNhapMaKhoa();
                    System.out.println("Nhap ma bac si: ");
                    p.IDBacSi = kt.KiemTraNhapMaKhoa();
                    System.out.println("Nhap ngay: ");
                    p.ngaythang = kt.validateBirthday();
                    p.getDs().main(p.getDs(), p);
                    phieukhamarr.add(p);
                    break;
                case "2":
                    PhieuKham pk = timphieukhamtheoid();
                    if (pk != null)
                        pk.xuatPhieuKham();
                    break;

                case "3":
                    timphieukhamtheoidbacsi();
                    break;
                case "4":
                    timphieukhamtheoidbenhnhan();
                    break;
                case "5":
                    timphieukhamtheongaythang();
                    break;
                case "6":
                    timphieukhamtheoid();
                case "7":

                    PhieuKham phieukham = timphieukhamtheoid();
                    phieukham.HuyPhieu();
                    System.out.println("Da huy");

                    break;
                case "8":
                    menu = false;
                    break;
                case "9":
                    for (PhieuKham PHIEUKHAM : phieukhamarr) {
                        PHIEUKHAM.xuatPhieuKham();
                    }
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    menu = true;
                    break;
            }
            menu = kt.TiepTuc(menu);

        }

    }

}