package CODE;

public class BenhNhan extends CONNGUOI {
    private String mabenhnhan;
    private static int slg;

    public String getMabenhnhan() {
        return mabenhnhan;
    }

    public BenhNhan(String mabenhnhan, String name, String birthday, String phonenumber, String address,
            String gender) {
        super(name, birthday, phonenumber, address, gender);
        this.mabenhnhan = mabenhnhan;
        slg++;
    }

    public BenhNhan() {
        super();
        mabenhnhan = "";
        slg++;
    }

    @Override
    public String toString() {
        return "Ma benh nhan: " + mabenhnhan + ", " + super.toString();
    }

    public void setMabenhnhan(String mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public int getSlg() {
        return slg;
    }

    public static void decrementSlg() {
        slg--;
    }

    public void nhapBenhNhan() {
        System.out.println("Nhap ma benh nhan: ");
        mabenhnhan = kt.KiemTraNhapMaKhoa();
    }

}
