
package CODE;

import java.util.Scanner;
import Thuoc.Run;

public class Quyenhan {
     KiemTra kt = new KiemTra();
     DSBENHNHAN dsbn = new DSBENHNHAN();
     DSNHANSU dsns = new DSNHANSU();
     DSKHOA dskhoa = new DSKHOA();
     DSBAN dsban = new DSBAN();
     DSPHIEUKHAM dspk = new DSPHIEUKHAM();
     DSDICHVU dsdv = new DSDICHVU();
     AccountList list = new AccountList();
     Run r = new Run();

     HangCho hc = new HangCho();

     public void quyen1() {

          boolean menu = true;
          while (menu == true) {
               System.out.println("\n+-----------------[NGHIỆP VỤ QUẢN LÝ]--------------------+");
               System.out.println("| 1. Quản lý bệnh nhân                                   |");
               System.out.println("| 2. Quản lý nhân sự                                     |");
               System.out.println("| 3. Quản lý khoa                                        |");
               System.out.println("| 4. Quản lý ban                                         |");
               System.out.println("| 5. Quản lý phiếu khám                                  |");
               System.out.println("| 6. Quản lý tai khoan                                     |");
               System.out.println("| 7. Quản lý dịch vụ                                     |");
               System.out.println("| 8. Thoát                                               |");
               System.out.println("+--------------------------------------------------------+\n");
               System.out.print("Nhập mục: ");
               String choice = kt.KiemTraNhapSo();
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
                         list.main(list);
                         break;
                    case "7":
                         dsdv.main(dsdv);
                         break;
                    case "8":
                         System.out.println("Bạn chắc chắn muốn đăng xuất? y|n ");
                         String lc = kt.KiemTraNhapChuoi();
                         lc = lc.toLowerCase();
                         if (lc.equals("y")) {
                              menu = false;
                              break;
                         } else if (lc.equals("n")) {
                              menu = true;
                              break;
                         } else {
                              System.out.println("Lựa chọn không hợp lệ");
                              menu = true;
                              break;
                         }

                    default:
                         System.out.println("Lựa chọn không hợp lệ!");
                         menu = true;
                         break;
               }
          }

     }

     public void quyen2() {

          boolean menu = true;
          while (menu == true) {
               System.out.println("\n+-----------------[NGHIỆP VỤ QUẢN LÝ]--------------------+");
               System.out.println("| 1. Quản lý bệnh nhân                                   |");
               System.out.println("| 2. Quản lý phiếu khám                                  |");
               System.out.println("| 3. Quản lý hàng chờ                                    |");
               System.out.println("| 4. Thoát                                               |");
               System.out.println("+--------------------------------------------------------+\n");
               System.out.print("Nhập mục: ");
               String choice = kt.KiemTraNhapSo();
               switch (choice) {
                    case "1":
                         dsbn.main(dsbn);
                         break;
                    case "2":
                         dspk.main();
                         break;
                    case "3":
                         hc.main(dsbn);
                         break;
                    case "4":
                         System.out.println("Bạn chắc chắn muốn đăng xuất? y|n ");
                         String lc = kt.KiemTraNhapChuoi();
                         lc = lc.toLowerCase();
                         if (lc.equals("y")) {
                              menu = false;
                              break;
                         } else if (lc.equals("n")) {
                              menu = true;
                              break;
                         } else {
                              System.out.println("Lựa chọn không hợp lệ");
                              menu = true;
                              break;
                         }
                    default:
                         System.out.println("Lựa chọn không hợp lệ!");
                         menu = true;
                         break;
               }
          }

     }

     public void quyen3() {
          Run.thuKho();
     }

     // public static void main(String[] argv) {
     // Quyenhan qh = new Quyenhan();

     // qh.quyen1();
     // qh.quyen2();
     // qh.quyen3();
     // }

}
