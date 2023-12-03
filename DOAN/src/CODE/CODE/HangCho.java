package CODE;

import java.util.ArrayList;

public class HangCho {
    KiemTra kt = new KiemTra();

    private ArrayList<BenhNhan> hangcho = new ArrayList<BenhNhan>();

    public void themvaoHangcho(DSBENHNHAN ds) {
        System.out.println("Nhap ID benh nhan can them: ");
        String id = kt.KiemTraNhapMaKhoa();
        boolean exist = true;
        for (BenhNhan bn : ds.getBenhnhanDS()) {

            if (bn.getMabenhnhan().equalsIgnoreCase(id)) {
                System.out.println(bn.toString());
                exist = true;

                hangcho.add(bn);
                System.out.println("Da them!");

                return;
            }
        }
        exist = false;
        System.out.println("Khong ton tai ma benh nhan");

    }

    public void BenhNhanTiepTheo() {
        if (!hangcho.isEmpty()) {
            hangcho.remove(0);
            System.out.println("Da goi benh nhan tiep theo!");
        } else {
            System.out.println("Hang cho trong.");
        }

    }

    public void xemHangcho() {
        if (!hangcho.isEmpty()) {
            System.out.println("Hang cho trong!");

        } else {
            for (BenhNhan bn : hangcho) {
                System.out.println(bn.toString());
            }
        }
    }

    public void main(DSBENHNHAN ds) {

        boolean menu = true;
        while (menu == true) {
            System.out.println("QUAN LY HANH CHO");
            System.out.println("1.Them benh nhan vao hang cho");
            System.out.println("2.Goi benh nhan tiep theo");
            System.out.println("3.Xem hang cho");
            System.out.println("4.Thoat");
            String choice = kt.KiemTraNhapSo();
            switch (choice) {
                case "1":
                    themvaoHangcho(ds);
                    menu = false;
                    break;

                case "2":
                    BenhNhanTiepTheo();
                    menu = false;
                    break;
                case "3":
                    xemHangcho();
                    menu = false;
                    break;
                case "4":
                    menu = false;
                    break;

                default:
                    System.out.println("Lua chon khong hop le, hay nhap lai");
                    menu = true;
                    break;
            }
            menu = kt.TiepTuc(menu);
        }

    }

    public static void main(String argv[]) {
        DSBENHNHAN ds = new DSBENHNHAN();
        HangCho hc = new HangCho();
        ds.nhapDSBenhNhan();
        hc.main(ds);

    }
}
