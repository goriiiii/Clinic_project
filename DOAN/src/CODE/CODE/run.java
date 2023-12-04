package CODE;

import java.util.ArrayList;
import java.util.Scanner;

public class run {

    public static void main(String argv[]) {
        KiemTra kt = new KiemTra();
        Quyenhan qh = new Quyenhan();
        qh.list.taoAccountmacdinh();

        boolean menu = true;
        while (menu == true) {
            System.out.println("1.Dang nhap          2.Thoat");
            String choice = kt.KiemTraNhapSo();
            switch (choice) {
                case "1":
                    System.out.println("Nhap username");
                    String username = kt.KiemTraNhapChuoi();
                    System.out.println("Nhap mat khau");
                    String password = kt.KiemTraNhapChuoi();
                    boolean login = false;

                    for (Account a : qh.list.getAccountarr()) {
                        if (username.equals(a.getUsername()) && password.equals(a.getPassword())) {
                            System.out.println("Dang nhap thanh cong!");
                            login = true;
                            if (a.getQuyenhan() == "admin") {
                                qh.quyen1();
                                break;
                            } else if (a.getQuyenhan() == "bacsi") {
                                qh.quyen2();
                                break;
                            } else if (a.getQuyenhan() == "duoc") {
                                qh.quyen3();
                                break;
                            }

                        }

                    }
                    if (login == false) {
                        System.out.println("Thong tin dang nhap khong dung");
                        break;
                    }
                    break;

                case "2":
                    menu = false;
                    break;

                default:
                    System.out.println("Hay nhap lua chon hop le");
                    menu = true;
                    break;
            }
        }

    }
}