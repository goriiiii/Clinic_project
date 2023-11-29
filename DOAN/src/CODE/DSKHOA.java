package CODE;
import java.util.ArrayList;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class DSKHOA {
	static Scanner scanner = new Scanner(System.in);
	private int slg;
	KiemTra kt=new KiemTra();
	
	private ArrayList<KHOA> khoaarr;
	
	public DSKHOA(int n, ArrayList<KHOA> khoaarr) {
		this.setSlg(n);
		this.khoaarr = khoaarr;
	}
	public DSKHOA()
	{
		this.setSlg(0);
		khoaarr=new ArrayList<KHOA>();
	}
	public int getSlg() {
		return slg;
	}
	public void setSlg(int slg) {
		this.slg = slg;
	}
	
	public ArrayList<KHOA> getKhoaarr() {
		return khoaarr;
	}
	public void setKhoaarr(ArrayList<KHOA> khoaarr) {
		this.khoaarr = khoaarr;
		
	}
	public void sort() {
    	Collections.sort(khoaarr, Comparator.comparing(KHOA::getTen));
    }
	
	public void nhapDSKhoa() 
    {
        
        System.out.println("Nhập vào số lượng khoa:");
        slg=Integer.parseInt(scanner.nextLine());
      
    
        for (int i = 0; i < slg; i++) {
            KHOA k = new KHOA();
            k.NhapKhoa();

            boolean isDuplicate = true;
            for (KHOA khoa : this.khoaarr) {
            	while(isDuplicate==true) {
                if (k.getId().equals(khoa.getId())) {
                    System.out.println("Không cho phép ID trùng lặp!");
                    isDuplicate = true;
                    k.NhapKhoa();
                    }
                else {
                	isDuplicate=false;
                }
                }
            }         
                this.khoaarr.add(k);
            
        }
        sort();
    	   
       }
       

	public void xuatDSKhoa()
	{
		System.out.println("Danh sách các khoa: ");

		  System.out.printf("%-12s%-12s\n","ID","Khoa");
        for( KHOA khoa: this.khoaarr)
        {    
            System.out.printf("%-12s%-12s\n",khoa.id,khoa.ten);
        }
    }
	


     public void themKhoa() {
    	 
    	 System.out.println("Nhap khoa can them");
    	 KHOA k=new KHOA();
    	 k.NhapKhoa();
    	 khoaarr.add(k);
    	 sort();
     }
     
     public KHOA timkiemKhoatheoid()
       {
        KHOA k=null;
        System.out.println("Nhập vào ID khoa cần tìm:");
        String id=scanner.nextLine();
        for(KHOA k1:khoaarr)
            if(k1.getId().equalsIgnoreCase(id))
            {    
                k=k1;
                System.out.println(k.toString());
                return k;
                
            }
        if(!this.findMatchingStrings(khoaarr, id).isEmpty())
        {
      	
      	  System.out.println("Có phải bạn muốn tìm: ");
      	  for(String str: this.findMatchingStrings(khoaarr, id)) {
      		  System.out.println(str);
      	  }
      	  
        }
        else {
        System.out.println("Không tìm thấy khoa!");}
        return k;
    }
		
     public KHOA timkiemKhoatheoten()
     {
      KHOA k=null;
      System.out.println("Nhập vào tên khoa cần tìm:");
      String name=scanner.nextLine();
      for(KHOA k1:khoaarr)
          if(k1.getTen().equalsIgnoreCase(name))
          {    
              k=k1;
              System.out.println(k.toString());
             
              return k;
          }
      if(!this.findMatchingStrings(khoaarr, name).isEmpty())
      {
    	
    	  System.out.println("Có phải bạn muốn tìm: ");
    	  for(String str: this.findMatchingStrings(khoaarr, name)) {
    		  System.out.println(str);
    	  }
    	  
      }
      else {
     System.out.println("Không tìm thấy khoa!");
     }
      return k;
  }
     public void xoaKhoa()
     {
    	 
    	String c;
    	 boolean menu=true;
    	 while(menu==true)
    	 {    		 
    		 System.out.println("Lựa chọn loại tìm kiếm để xóa: 1.Theo ID  2.Theo ten  X.Thoat");
    		 c=scanner.nextLine();
    	 switch(c) 
    	 {
    	 case "1":
    		khoaarr.remove(timkiemKhoatheoid());    	
    		System.out.println("Đã xóa!");
    		 break;
    	 case "2":
    		 khoaarr.remove(timkiemKhoatheoten());  
    		 System.out.println("Đã xóa!");
    		 break;
    	 case"x":
    		 return;
    	 case"X":
    		 return;
    		 
    	 default:
    		 System.out.println("Lua chon khong hop le, hay nhap lai!");
    		 menu=true;
    		 break;    			 
    	 }
    	
    	menu=kt.TiepTuc(menu);
    	
     }
     }
     public ArrayList<String> findMatchingStrings(ArrayList<KHOA> khoaarr, String pattern)
     {
         ArrayList<String> matchingStrings = new ArrayList<String>();

         for (KHOA khoa : khoaarr) {
        	if (khoa.ten.toLowerCase().contains(pattern.toLowerCase())||khoa.id.toLowerCase().contains(pattern.toLowerCase())) {
                 matchingStrings.add(khoa.toString());
             }
             
         } 
       
         return matchingStrings;
     }
     public void suaKhoa()
     {
    	 String c;
    	 boolean menu=true;
    	 while(menu==true)
    	 {    		 
    		 System.out.println("Lựa chọn loại tìm kiếm để sửa: 1.Theo ID  2.Theo tên  X.Thoát");
    		 c=scanner.nextLine();
    	 switch(c) 
    	 {
    	 case "1":
    		KHOA khoa =timkiemKhoatheoid();    
    		
    		boolean menu1=true;
    		while(menu1==true)
    		{
    			System.out.println("1.Sửa Khoa ID   2.Sửa Tên Khoa  3.Thoát");
        		String choice=scanner.nextLine();
        		
        		if (choice.matches("1"))
        		{
        			System.out.println("Nhập ID mới: ");
        			khoa.id=kt.KiemTraNhapMaKhoa();
        			khoa.XuatKhoa();
        			System.out.println("Lựa chọn tiếp tục sửa thêm?");
        			menu1=kt.TiepTuc(menu1);
        		}
        		else if(choice.matches("2"))
        				{
        			System.out.println("Nhập tên mới: ");
        			khoa.ten=kt.KiemTraNhapTen();
        			khoa.XuatKhoa();
        			System.out.println("Lựa chọn tiếp tục sửa thêm?.");
        			menu1=kt.TiepTuc(menu1);
        				}
        		else if(choice.matches("3"))
        		{
        			menu1=false;        			
        		}
        		else {
        			System.out.println("Nhập không hợp lệ, vui lòng lựa chọn 1 hoặc"
        					+ " 2 hoặc 3 ");
        			menu1=true;
        		}
    		}
    		 break;
    	 case "2":
    			KHOA khoa2 =timkiemKhoatheoten();    
        		
        		boolean menu2=true;
        		while(menu2==true)
        		{
        			System.out.println("1.Sửa Khoa ID   2.Sửa Tên Khoa  3.Thoát");
            		String choice=scanner.nextLine();
            		
            		if (choice.matches("1"))
            		{
            			System.out.println("Nhập ID mới: ");
            			khoa2.id=kt.KiemTraNhapMaKhoa();
            			khoa2.XuatKhoa();
            			System.out.println("Lựa chọn tiếp tục sửa.");
            			menu2=kt.TiepTuc(menu2);
            		}
            		else if(choice.matches("2"))
            				{
            			System.out.println("Nhập tên mới: ");
            			khoa2.ten=kt.KiemTraNhapTen();
            			khoa2.XuatKhoa();
            			System.out.println("Lựa chọn tiếp tục sửa.");
            			menu2=kt.TiepTuc(menu2);
            				}
            		else if(choice.matches("3"))
            		{
            			menu2=false;
            			
            		}
            		else {
            			System.out.println("Nhập không hợp lệ, vui lòng lựa chọn 1 hoặc"
            					+ " 2 hoặc 3 ");
            			menu2=true;
            		}
        		}
    				 
    		 break;
    	 case"x":
    		 menu=false;
    		 break;
    	 case"X":
    		 menu=false;
    		 break;
    		 
    	 default:
    		 System.out.println("Lựa chọn không hợp lệ hãy nhập lại!!");
    		 menu=true;
    		 break;    			 
    	 }
    	 System.out.println("Lựa chọn tiếp tục tìm kiếm để sửa.");
    	menu=kt.TiepTuc(menu);
    	
     }
    	
    	 
     }
     
     public void docFile(DSKHOA ds) {
    	System.out.println("Nhập đường dẫn của file: ");
    	 String file=scanner.nextLine();
    	StringBuilder sb = new StringBuilder();
 	   for (int i = 0; i < file.length(); i++) {
            char currentChar = file.charAt(i);
         if(currentChar!='\"'){
         	  sb.append(currentChar);
            }
         if (currentChar == '\\') {
             sb.append("\\");
         }
        }
 	 System.out.println(sb);
 	 file=sb.toString();
    	 try {
    		 File f=new File(file);
    		 
    		 if(f.exists()) {
    			 Scanner read=new Scanner(f);
    			 if (!read.hasNext()) { // Check if the file is empty
                     System.out.println("File is empty. Generating content...");
                     vietFileauto(ds,file); // Call vietFile to generate content
                     return;
                 }
    			  while (read.hasNextLine()) {
    	                String line = read.nextLine();
    	                String[] properties = line.split(",");

    	                if (properties.length >= 2) { // Ensure you have at least two properties in the line
    	                    String property1 = properties[0].trim();
    	                    String property2 = properties[1].trim();

    	                    // Create YourObject instance and add it to the list
    	                    KHOA khoaobj = new KHOA(property1, property2);
    	                   kt.formatChuoi(khoaobj.ten);
    	                   this.khoaarr.add(khoaobj);
    	                } else {
    	                    System.out.println("Invalid format in the line: " + line);
    	                }
    	            }
    			 
    		 }
    		 else {
    			 System.out.println("File không tồn tại");
    		 }
    	 }
    	 catch (Exception e){
    		 e.printStackTrace();
    		 
    	 }
    	 sort();
     } 
     
	public void vietFile() {
		
    	 System.out.println("Nhập đường dẫn file để viết: ");
    	 String file=scanner.nextLine();//"C:\Users\ADMIN\Documents\input.txt"
    	 StringBuilder sb = new StringBuilder();
    	   for (int i = 0; i < file.length(); i++) {
               char currentChar = file.charAt(i);
            if(currentChar!='\"'){
            	  sb.append(currentChar);
               }
            if (currentChar == '\\') {
                sb.append("\\");
            }
           }
    	 System.out.println(sb);
    	 file=sb.toString();
         try (FileWriter fileWriter = new FileWriter(file,true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Loop through the array and write each product's information to the file
                for (KHOA khoa : khoaarr) {
                    if (khoa != null) {
                        bufferedWriter.write( khoa.getId()+
                                " , "+khoa.getTen()+ "\n");
                    }
                }
                System.out.println("Array of KHOA has been written to file.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     public void vietFileauto(DSKHOA ds, String file) {
    	 
    	 ds.khoaarr.add(new KHOA("TM","Tim mạch"));
    	 ds.khoaarr.add(new KHOA("NHI","NHI")); 
    	 ds.khoaarr.add(new KHOA("MAT","Mắt"));
    	 ds.khoaarr.add(new KHOA("VLTL","Vật lý trị liệu"));
    	 ds.khoaarr.add(new KHOA("TMH","Tai - mũi -họng"));
    	 ds.khoaarr.add(new KHOA("CC","Cấp cứu"));
    	 ds.khoaarr.add(new KHOA("YHCT","Y học cổ truyền"));
    	 ds.khoaarr.add(new KHOA("XN","Xét nghiệm"));
    	 ds.khoaarr.add(new KHOA("TK","Thần kinh"));
    	 ds.khoaarr.add(new KHOA("DL","Da liễu"));
    	 
    	
         try (FileWriter fileWriter = new FileWriter(file,true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Loop through the array and write each product's information to the file
                for (KHOA khoa : ds.khoaarr) {
                    if (khoa != null) {
                        bufferedWriter.write( khoa.getId()+
                                " , "+khoa.getTen()+ "\n");
                    }
                }
                System.out.println("Array of KHOA has been written to file.");

            } catch (IOException e) {
                e.printStackTrace();
            }
     }
     
     
	
	public static void main(String argv[]) 
	{
		
		DSKHOA ds = new DSKHOA();
		 
    	String c;
    	 boolean menu=true;
    	 while(menu==true)
    	 {    		 
    		 System.out.println("QUẢN LÍ CÁC KHOA");
    		 System.out.println("1. Nhập danh sách");
    		 System.out.println("2. Xuất danh sách");
    		 System.out.println("3. Thêm khoa");
    		 System.out.println("4. Tìm kiếm theo ID");
    		 System.out.println("5. Tìm kiếm theo tên");
    		 System.out.println("6. Xóa khoa");
    		 System.out.println("7. Sửa khoa");
    		 System.out.println("8. Nhập thông tin từ file");
    		 System.out.println("9. Xuất thông tin ra file");
    		 System.out.println("10. Exit");
    		 c=scanner.nextLine();
    	 switch(c) 
    	 {
    	 case "1":
    		ds.nhapDSKhoa();
    		 break;
    	 case "2":
    		 ds.xuatDSKhoa();
    		 break;
    	 case"3":
    		 ds.themKhoa();
    		 break;
    	 case"4":
    		 ds.timkiemKhoatheoid();
    		 break;
    	 case"5":
    		 ds.timkiemKhoatheoten();
    		 break;
    	 case"6":
    		 ds.xoaKhoa();
    		 break;
    	 case "7":
    		 ds.suaKhoa();
    		 break;
    	 case"8":
    		 ds.docFile(ds);
    		 break;
    	 case"9":
    		 ds.vietFile();
    		 break;
    	 case "10":
    		 menu=false;
    		 break;  	 
    	 default:
    		 System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại");
    		 menu=true; 
    		 break;    			 
    	}
     }
  }
}
