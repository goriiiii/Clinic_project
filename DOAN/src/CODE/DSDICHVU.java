package CODE;
import java.util.ArrayList;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class DSDICHVU {
	static Scanner scanner = new Scanner(System.in);
	private int slg;
	KiemTra kt=new KiemTra();
	
	private ArrayList<DICHVU> dvarr;
	
	public DSDICHVU(int n, ArrayList<DICHVU> dvarr) {
		this.setSlg(n);
		this.dvarr = dvarr;
	}
	public DSDICHVU()
	{
		this.setSlg(0);
		dvarr=new ArrayList<DICHVU>();
	}
	public int getSlg() {
		return slg;
	}
	public void setSlg(int slg) {
		this.slg = slg;
	}
	
	public ArrayList<DICHVU> getKhoaarr() {
		return dvarr;
	}
	public void setKhoaarr(ArrayList<DICHVU> dvarr) {
		this.dvarr = dvarr;
		
	}
	public void sort() {
    	Collections.sort(dvarr, Comparator.comparing(DICHVU::getTen));
    }
	
	public void nhapDSDichvu() 
    { 
		boolean cont=true;
    while (cont==true) {
    	
    	System.out.println("Nhập vào số lượng dịch vụ:");
        slg=Integer.parseInt(kt.KiemTraNhapGia());
        
        for (int i = 0; i < slg; i++) {
            DICHVU k = new DICHVU();
            k.NhapDichvu();

            boolean isDuplicate = true;
            for (DICHVU dv : dvarr) {
            	while(isDuplicate==true) {
                if (k.getId().equals(dv.getId()))
                {
                    System.out.println("Không cho phép ID trùng lặp!");
                    isDuplicate = true;
                    k.NhapDichvu();
                 }
                else 
                {
                	isDuplicate=false;
                }
               }
            }         
                this.dvarr.add(k);
            
        }
        cont=kt.TiepTuc(cont);
     }
    sort();
    	   
 }
       

	public void xuatDSDichvu()
	{
		System.out.println("Danh sách các dịch vụ: ");

		  System.out.printf("%-12s%-12s%-12s\n","ID","Dịch vụ","Gía");
		  System.out.println("_________________________________");
        for(DICHVU dv: this.dvarr)
        {    
            System.out.printf("%-12s%-12s%-12s\n",dv.getId(),dv.getTen(),dv.getPrice());
        }
    }
	


     public void themDichvu() {
    	 
    	 System.out.println("Nhập dịch vụ cần thêm");
    	 DICHVU k=new DICHVU();
    	 k.NhapDichvu();

         boolean isDuplicate = true;
         for (DICHVU dv : this.dvarr) {
         	while(isDuplicate==true) {
             if (k.getId().equals(dv.getId())) 
             {
                 System.out.println("Không cho phép ID trùng lặp!");
                 isDuplicate = true;
                 k.NhapDichvu();
              }
             else 
             {
             	isDuplicate=false;
             }
            }
         }         
             this.dvarr.add(k);
         
    	
    	 sort();
     }
     
     public DICHVU timkiemDichvutheoid()
     {
     DICHVU k=null;
      System.out.println("Nhập vào ID dịch vụ cần tìm:");
      String id=scanner.nextLine();
      for(DICHVU k1:dvarr)
          if(k1.getId().equalsIgnoreCase(id))
          {    
              k=k1;
              System.out.println(k.toString());
              return k;
              
          }
      if(!this.findMatchingStrings(dvarr, id).isEmpty())
      {
    	
    	  System.out.println("Có phải bạn muốn tìm: ");
    	  for(String str: this.findMatchingStrings(dvarr, id)) {
    		  System.out.println(str);
    	  }
    	  
      }
      else {
      System.out.println("Không tìm thấy!");}
      return k;
  }
     public DICHVU timkiemDichvutheoten()
     {
      DICHVU k=null;
      System.out.println("Nhập vào tên khoa cần tìm:");
      String name=scanner.nextLine();
      for(DICHVU k1:dvarr)
          if(k1.getTen().equalsIgnoreCase(name))
          {    
              k=k1;
              System.out.println(k.toString());
             
              return k;
          }
      if(!this.findMatchingStrings(dvarr, name).isEmpty())
      {
    	
    	  System.out.println("Có phải bạn muốn tìm: ");
    	  for(String str: this.findMatchingStrings(dvarr, name)) {
    		  System.out.println(str);
    	  }
    	  
      }
      else {
     System.out.println("Không tìm thấy!");
     }
      return k;
  }
     public void xoaDV()
     {
    	 
    	String c;
    	 boolean menu=true;
    	 while(menu==true)
    	 {    		 
    		 System.out.println("Lựa chọn loại tìm kiếm để xóa: 1.Theo ID  2.Theo tên  X.Thoát");
    		 c=scanner.nextLine();
    	 switch(c) 
    	 {
    	 case "1":
    		dvarr.remove(timkiemDichvutheoid());    	
    		System.out.println("Đã xóa!");
    		 break;
    	 case "2":
    		 dvarr.remove(timkiemDichvutheoten());  
    		 System.out.println("Đã xóa!");
    		 break;
    	 case"x":
    		 return;
    	 case"X":
    		 return;
    		 
    	 default:
    		 System.out.println("Lựa chọn không hợp lệ, hãy nhập lại!");
    		 menu=true;
    		 break;    			 
    	 }
    	
    	menu=kt.TiepTuc(menu);
    	
     }
     }
     public ArrayList<String> findMatchingStrings(ArrayList<DICHVU> dvarr2, String pattern)
     {
         ArrayList<String> matchingStrings = new ArrayList<String>();

         for (DICHVU dv : dvarr) {
        	if (dv.getTen().toLowerCase().contains(pattern.toLowerCase())||dv.getId().toLowerCase().contains(pattern.toLowerCase())) {
                 matchingStrings.add(dv.toString                		 ());
             }
             
         } 
       
         return matchingStrings;
     }
     public void suaDichvu()
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
    		DICHVU dv =timkiemDichvutheoid();    
    		
    		boolean menu1=true;
    		while(menu1==true)
    		{
    			System.out.println("1.Sửa ID   2.Sửa Tên   3.Thoát");
        		String choice=scanner.nextLine();
        		
        		if (choice.matches("1"))
        		{
        			System.out.println("Nhập ID mới: ");
        			dv.setId(kt.KiemTraNhapMaKhoa());
        			dv.XuatDichvu();
        			System.out.println("Lựa chọn tiếp tục sửa thêm?");
        			menu1=kt.TiepTuc(menu1);
        		}
        		else if(choice.matches("2"))
        				{
        			System.out.println("Nhập tên mới: ");
        			dv.setTen(kt.KiemTraNhapTen());
        			dv.XuatDichvu();
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
    			DICHVU dv1 =timkiemDichvutheoten();    
        		
        		boolean menu2=true;
        		while(menu2==true)
        		{
        			System.out.println("1.Sửa ID   2.Sửa Tên   3.Thoát");
            		String choice=scanner.nextLine();
            		
            		if (choice.matches("1"))
            		{
            			System.out.println("Nhập ID mới: ");
            			dv1.setId(kt.KiemTraNhapMaKhoa());
            			dv1.XuatDichvu();
            			System.out.println("Lựa chọn tiếp tục sửa.");
            			menu2=kt.TiepTuc(menu2);
            		}
            		else if(choice.matches("2"))
            				{
            			System.out.println("Nhập tên mới: ");
            			dv1.setTen(kt.KiemTraNhapTen());
            			dv1.XuatDichvu();
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
     
     public void docFile(DSDICHVU ds) {
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

    	                if (properties.length >= 3) { // Ensure you have at least two properties in the line
    	                    String property1 = properties[0].trim();
    	                    String property2 = properties[1].trim();
    	                    String property3 = properties[2].trim();

    	                    // Create YourObject instance and add it to the list
    	                    DICHVU dvobj = new DICHVU(property1, property2,property3);
    	                   kt.formatChuoi(dvobj.getTen());
    	                   this.dvarr.add(dvobj);
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
                for (DICHVU dv : dvarr) {
                  if  ( dv != null) {
                        bufferedWriter.write(dv.getId()+
                                " , "+dv.getTen()+ ", "+dv.getPrice()+"\n");
                    }
                }
                System.out.println("Array of DICHVU has been written to file.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     public void vietFileauto(DSDICHVU ds, String file) {
    	 
    	
         try (FileWriter fileWriter = new FileWriter(file,true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
     
                for (DICHVU dv : dvarr) {
                    if (dv != null) {
                        bufferedWriter.write( dv.getId()+
                                " , "+dv.getTen()+ ", "+dv.getPrice()+ "\n");
                    }
                }
                System.out.println("Array of KHOA has been written to file.");

            } catch (IOException e) {
                e.printStackTrace();
            }
     }
     
     
	
	public static void main(String argv[]) 
	{
		

		DSDICHVU ds = new DSDICHVU();
		 
    	String c;
    	 boolean menu=true;
    	 while(menu==true)
    	 {    		 
    		 System.out.println("QUẢN LÍ CÁC DỊCH VỤ");
    		 System.out.println("1. Nhập danh sách");
    		 System.out.println("2. Xuất danh sách");
    		 System.out.println("3. Thêm ");
    		 System.out.println("4. Tìm kiếm theo ID");
    		 System.out.println("5. Tìm kiếm theo tên");
    		 System.out.println("6. Xóa");
    		 System.out.println("7. Sửa");
    		 System.out.println("8. Nhập thông tin từ file");
    		 System.out.println("9. Xuất thông tin ra file");
    		 System.out.println("10. Exit");
    		 c=scanner.nextLine();
    	 switch(c) 
    	 {
    	 case "1":
    		ds.nhapDSDichvu();
    		 break;
    	 case "2":
    		 ds.xuatDSDichvu();
    		 break;
    	 case"3":
    		 ds.themDichvu();
    		 break;
    	 case"4":
    		 ds.timkiemDichvutheoid();
    		 break;
    	 case"5":
    		 ds.timkiemDichvutheoten();
    		 break;
    	 case"6":
    		 ds.xoaDV();
    		 break;
    	 case "7":
    		 ds.suaDichvu();
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
