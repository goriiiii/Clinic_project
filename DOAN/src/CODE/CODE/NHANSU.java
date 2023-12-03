package CODE;

public abstract class NHANSU extends CONNGUOI {
	private String employee_id;
	private String cccd_code;
	private static int slg;

	public NHANSU(String name, String birthday, String phonenumber, String address, String gender,
			String employee_id, String identification_code) {
		super(name, birthday, phonenumber, address, gender);
		this.employee_id = employee_id;
		this.cccd_code = identification_code;
		slg++;
	}

	public NHANSU() {
		super();
		this.employee_id = "";
		this.cccd_code = "";
		slg++;
	}

	public String getEmployeeId() {
		return employee_id;
	}

	public void setEmployeeId(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getIdentificationCode() {
		return cccd_code;
	}

	public void setIdentificationCode(String identification_code) {
		this.cccd_code = identification_code;
	}

	public static int getSlg() {
		return slg;
	}

	public static void decrementSlg() {
		slg--;
	}

	@Override
	public String toString() {
		return super.toString() + ", ma nhan vien: " + employee_id + ", ma so cccd: " + cccd_code;
	}

	public void nhapThongTinNhanSu() {
		System.out.println("Nhap ma nhan vien: ");
		this.employee_id = kt.KiemTraNhapMaKhoa();
		System.out.println("Nhap ma cccd: ");
		this.cccd_code = kt.KiemTraNhapSo();

	}

	public abstract void nhapBoPhan();

}