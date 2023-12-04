package CODE;

import java.util.Scanner;

public class Account {
    KiemTra kt = new KiemTra();
    Scanner sc = new Scanner(System.in);
    private String IDAcc;
    private String Username;
    private String Password;

    private String quyenhan;

    @Override
    public String toString() {
        return "Ma tai khoan:" + IDAcc + ", Username: " + Username + ", Password: " + Password + ", quyen han:"
                + quyenhan;
    }

    public Account(String iDAcc, String username, String password, String quyenhan) {
        IDAcc = iDAcc;
        Username = username;
        Password = password;
        this.quyenhan = quyenhan;
    }

    public Account() {
        IDAcc = Username = Password = quyenhan = "";
    }

    public String getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(String quyenhan) {
        this.quyenhan = quyenhan;
    }

    public String getIDAcc() {
        return IDAcc;
    }

    public void setIDAcc(String iDAcc) {
        IDAcc = iDAcc;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void inputAccount() {
        System.out.print("\nNhập ID account:");
        IDAcc = sc.nextLine();
        System.out.print("\nNhập Username:");
        Username = sc.nextLine();
        System.out.print("\nNhập Password:");
        Password = sc.nextLine();
        int x = 0;
        do {
            System.out.println("\nChọn Quyền hạn:");
            System.out.println("1. Quản trị viên        2. Quản lí của bác sĩ         3. Quản lí dược");
            x = Integer.parseInt(kt.KiemTraNhapSo());
            if (x == 1) {
                quyenhan = "admin";
            } else if (x == 2) {
                quyenhan = "bacsi";
            } else if (x == 3) {
                quyenhan = "duoc";
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (x != 1 && x != 2 && x != 3);

    }

    public void doiMatKhau() {
        System.out.println("Nhap mat khau moi: ");
        setPassword(kt.KiemTraNhapMaKhoa());
    }

}
