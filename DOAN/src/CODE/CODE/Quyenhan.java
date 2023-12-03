
package CODE;

import java.util.Scanner;
import QuanLy.QuanLyPhieuNhap;

public class Quyenhan {
     KiemTra kt = new KiemTra();
     DSBENHNHAN dsbn = new DSBENHNHAN();
     DSNHANSU dsns = new DSNHANSU();
     DSKHOA dskhoa = new DSKHOA();
     DSBAN dsban = new DSBAN();
     DSPHIEUKHAM dspk = new DSPHIEUKHAM();

     public void menu1() {
          System.out.println(
                    "1. Quan ly benh nhan     2.Quan ly nhan su      3.Quan ly khoa     4.Quan ly ban    5.Quan ly phieu kham  6. Quan ly thuoc   7.Dang xuat");
          String choice = kt.KiemTraNhapSo();
          boolean menu = true;
          while (menu == true) {
               switch (choice) {
                    case "1":
                         dsbn.main(dsbn);
                         break;
                    case "2":
                         dsns.main(dsns);
                         break;
                    case "3":
                         dskhoa.main(dskhoa);
                         break;
                    case "4":
                         dsban.main(dsban);
                         break;
                    case "5":
                         dspk.main();
                    case "6":
                         break;
                    case "7":
                         System.out.println("Ban chac chan muon dang xuat? y|n ");
                         String lc = kt.KiemTraNhapSo();
                         lc = lc.toLowerCase();
                         if (lc.equals("y")) {
                              menu = false;
                              break;
                         } else if (lc.equals("n")) {
                              menu = true;
                              break;
                         } else {
                              System.out.println("Lua chon khong hop le");
                              menu = true;
                              break;
                         }

                    default:
                         System.out.println("Lua chon khong hop le!");
                         menu = true;
                         break;
               }
          }

     }

     public void quyen2() {
          System.out.println(
                    "1. Quan ly benh nhan      2. Quan ly phieu kham         3.Dang xuat");
          String choice = kt.KiemTraNhapSo();
          boolean menu = true;
          while (menu == true) {
               switch (choice) {
                    case "1":
                         dsbn.main(dsbn);
                         break;
                    case "2":
                         dspk.main();
                         break;
                    case "3":
                         System.out.println("Ban chac chan muon dang xuat? y|n ");
                         String lc = kt.KiemTraNhapSo();
                         lc = lc.toLowerCase();
                         if (lc.equals("y")) {
                              menu = false;
                              break;
                         } else if (lc.equals("n")) {
                              menu = true;
                              break;
                         } else {
                              System.out.println("Lua chon khong hop le");
                              menu = true;
                              break;
                         }
                    default:
                         System.out.println("Lua chon khong hop le!");
                         menu = true;
                         break;
               }
          }

     }

}
