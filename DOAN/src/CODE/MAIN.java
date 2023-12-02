package CODE;

import java.util.Scanner;

public class MAIN {

    public static void main(String argv[]) {
        NHANSU ns;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap loai nhan su (hanh chinh / chuyen mon):");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("hanh chinh")) {
            ns = new NVHANHCHINH();
        } else if (input.equalsIgnoreCase("chuyen mon")) {
            ns = new NVCHUYENMON();
        } else {
            return;
        }

        ns.nhapThongTin();
        ns.nhapThongTinNhanSu();
        ns.nhapBoPhan();

    }

}
