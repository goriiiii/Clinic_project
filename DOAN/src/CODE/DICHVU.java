package CODE;

import java.util.Scanner;

public class DICHVU implements performQualityChecks{
 	
		private String id;
		private String ten;
	    private	String price;
		KiemTra kiemtra =new KiemTra();
		static Scanner scanner = new Scanner(System.in);
		

		public DICHVU(String id, String ten, String price) {
			this.id = id;
			this.ten = ten;
			this.price=price;
		}


		public DICHVU() {
			id="";
			ten="";
			price="";
		
			
		}
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getTen() {
			return ten;
		}


		public void setTen(String ten) {
			this.ten = ten;
		}
		
		 

	    public String getPrice() {
			return price;
		}


		public void setPrice(String price) {
			this.price = price;
		}
		public String toString() {
			return "Dịch vụ " + ten + ", mã: "+ id+", phí "+price+" đồng";
		}
		 public void NhapDichvu()
		 {	 
			 System.out.println("Nhập ID dịch vụ: ");
			 id=kiemtra.KiemTraNhapMaKhoa();
			 System.out.println("Nhập tên dịch vụ: ");
			 ten=kiemtra.KiemTraNhapTen();
			 id.toUpperCase();	 
			 System.out.println("Nhập phí dịch vụ: ");
			 price=kiemtra.KiemTraNhapGia();
		 }
		 public void XuatDichvu() 
		 {
			 System.out.println(this.toString());
		 }	 

	
		 public static void main(String args[]) {
			 DICHVU dv=new DICHVU();
			 dv.NhapDichvu();
			 dv.XuatDichvu();
		 }


		@Override
		public String Maintenance() {
			
			
			this.NhapDichvu();
			System.out.println("Nhập thông tin chi tiết về bảo dưỡng "
					+ "máy móc/thiết bị... liên quan đến dịch vụ này");
			
			String info=scanner.nextLine();
			
			return this.toString()+". "+info;
		}


		@Override
		public String feedbackHandler() {
			System.out.println("Phản hồi về lỗi/sự cố dịch vụ");
			String info=scanner.nextLine();
			return this.toString()+". "+info;	
			
		}

		
}
