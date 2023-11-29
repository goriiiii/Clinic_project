package CODE;

public abstract class NHANSU {
	String id;
	String hoten;
	String ngaysinh;
	String diachi;
	
	static int soluong;
	public NHANSU() {
		hoten=ngaysinh=diachi=id="";
		soluong++;
		
	}
	public NHANSU(String hoten,String ngaysinh,String diachi,String id) {
		this.hoten=hoten;
		this.ngaysinh=ngaysinh;
		this.diachi=diachi;
		this.id=id;
		soluong++;
	}
	public void nhapThongtin()
	{
		
	}

}
