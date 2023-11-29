package CODE;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class KiemTra {
	static Scanner scanner = new Scanner(System.in);

    public String KiemTraNhapChuoi() {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            DauVao = DauVao.trim();
            if (DauVao != null) {
                return DauVao;
            } else {
                System.out.print("Không được bỏ trống ! Mời nhập lại: ");
            }
        }
    }
    
 
    public String KiemTraNhapGia()//kiểm tra nhập số nguyên
    {
    	String DauVao;
    	while (true) {
            DauVao = scanner.nextLine();
           
            if (DauVao.matches("^\\d+(\\.\\d+)?$")&&!DauVao.contains(" ")&&Integer.parseInt(DauVao)>10000) 
            {
                return DauVao;
            } 
            else {
                System.out.println("Giá không hợp lệ!");
            }
            System.out.print("Mời nhập lại: ");

        }
  
    }
    
    public String KiemTraNhapMaKhoa() {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            DauVao = DauVao.toUpperCase();
            if (DauVao.matches("^[a-zA-Z0-9]{1,9}$")&&!DauVao.contains(" ")) 
            {
                return DauVao;
            } 
            else {
                System.out.println("Định dạng mã sai, chỉ được phép nhập chữ cái và chữ số!");
            }
            System.out.print("Mời nhập lại: ");

        }
    }
    public String formatChuoi(String chuoi) {
        
        String[] tu = chuoi.split("\\s+");

       
        for (int i = 0; i < tu.length; i++) {
          
            if (tu[i].length() > 0) {
              
                tu[i] = tu[i].substring(0, 1).toUpperCase() + tu[i].substring(1).toLowerCase();
            }
        }

        String ketQua = String.join(" ", tu);

        return ketQua;
    }
    public  String KiemTraNhapTen()
    {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            if (DauVao.matches("[\\pL\\pMn*\\s*]+")) {
                DauVao = DauVao.trim();
                DauVao = DauVao.replaceAll("\\s+", " ");
                DauVao = DauVao.toLowerCase();
                String[] Chuoi = DauVao.split(" ");
                DauVao = "";
                for (int i = 0; i < Chuoi.length; i++) {
                    DauVao += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
                    if (i < Chuoi.length - 1) {
                        DauVao += " ";
                    }
                }
                return DauVao;
            } else {
                System.out.print("Tên không hợp lệ ! Mời nhập lại: ");
            }

        }
    }
 
        public boolean TiepTuc(boolean menu) 
        {
        	
        System.out.println("Tiếp tục? y/n");
            String DauVao;
            String DinhDang = "[n|y]";
            while (true) 
            {
                DauVao = scanner.nextLine();
                DauVao = DauVao.toLowerCase();
                if (DauVao.matches(DinhDang)) {
              
                	  if (DauVao.matches("y"))
                      {
                      	menu=true;
                      }
                      else 
                      {
                      	menu=false;
                      }
                
                    return menu;
                } else {
                    System.out.print("Sai định dạng, mời nhập lại lựa chọn!");
                }
             }
        }
        public  String formatPath(String path) {
            // Remove double quotes
            String formattedPath = path.replace("\"", "");

            // Add an additional backslash
            formattedPath = formattedPath.replaceAll("\\", "\\\\");

            return formattedPath;
        }

        public static boolean isValidBirthday(String input) {
            try {
                parseBirthday(input); // Attempt to parse the input
                return true; // If successful, it's a valid date
            } catch (DateTimeParseException e) {
                return false; // Invalid date format
            }
        }

        public static LocalDate parseBirthday(String input) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(input, formatter);
        }
        public String check_birthday(String input) {
        	while(true)
        		{
        		System.out.println("Nhập ngày tháng năm sinh (DD-MM-YYYY): ");
            input = scanner.nextLine();

            if (isValidBirthday(input)) {
               return input;
                
            } else {
                System.out.println("Không hợp lệ!");
               
            }}
            
        }
      
}