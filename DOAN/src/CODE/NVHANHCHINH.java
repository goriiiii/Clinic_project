package CODE;

public class NVHANHCHINH extends NHANSU {
    private String MA_BAN;

    public NVHANHCHINH(String name, String birthday, String phonenumber, String address, String gender,
            String employee_id, String identification_code, String MA_BAN) {
        super(name, birthday, phonenumber, address, gender, employee_id, identification_code);
        this.MA_BAN = MA_BAN;
    }

    public NVHANHCHINH() {
        super();
        this.MA_BAN = "";
    }

    public String getMA_BAN() {
        return MA_BAN;
    }

    public void setMA_BAN(String MA_KHOA) {
        this.MA_BAN = MA_KHOA;
    }

    @Override
    public String toString() {
        return super.toString() + ", MA BAN: " + MA_BAN;
    }

    public void nhapBoPhan() {

        System.out.println("Nhap ma ban: ");
        this.MA_BAN = kt.KiemTraNhapMaKhoa();

    }

    public static void main(String argv[]) {

        NVHANHCHINH nv = new NVHANHCHINH();
        nv.nhapBoPhan();
    }
}
