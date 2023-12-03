package CODE;

import java.util.ArrayList;

public class DSPHIEUKHAM {
    KiemTra kt = new KiemTra();
    private ArrayList<PhieuKham> phieukhamarr;

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
        System.out.println("1.Tạo phiêu khám mới");
        System.out.println("2. In ra phieu kham");
        System.out.println("");
    }
}
