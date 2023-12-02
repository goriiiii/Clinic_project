package CODE;

public class NVCHUYENMON extends NHANSU {
    private String MA_KHOA;

    public NVCHUYENMON(String name, String birthday, String phonenumber, String address, String gender,
            String employee_id, String identification_code, String MA_KHOA) {
        super(name, birthday, phonenumber, address, gender, employee_id, identification_code);
        this.MA_KHOA = MA_KHOA;
    }

    public NVCHUYENMON() {
        super();
        this.MA_KHOA = "";
    }

    public String getMA_KHOA() {
        return MA_KHOA;
    }

    public void setMA_KHOA(String MA_KHOA) {
        this.MA_KHOA = MA_KHOA;
    }

    @Override
    public String toString() {
        return super.toString() + ", MA KHOA: " + MA_KHOA;
    }

    public void nhapBoPhan() {

        System.out.println("Nhap ma khoa: ");
        this.MA_KHOA = kt.KiemTraNhapMaKhoa();

    }

    public static void main(String argv[]) {

        NVCHUYENMON nv = new NVCHUYENMON();
        nv.nhapBoPhan();
    }
}
