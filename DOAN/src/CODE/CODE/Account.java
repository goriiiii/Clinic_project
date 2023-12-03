package CODE;

import java.util.Scanner;

public class Account {

    Scanner sc = new Scanner(System.in);
    private String IDAcc;
    private String Username;
    private String Password;
    public String quyenhan;
    public Account() {  
        this.IDAcc="";
        this.Username="";
        this.Password="";
        this.quyenhan="";        
    }

    public Account(String IDAcc, String Username, String Password, String qh) {
        this.IDAcc = IDAcc;
        this.Username = Username;
        this.Password = Password;
        this.quyenhan = qh;
    }

    public String getIDAcc() {
        return IDAcc;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getQuyenhan() {
        return quyenhan;
    }

    public void setIDAcc(String IDAcc) {
        this.IDAcc = IDAcc;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setQuyenhan(String quyenhan) {
        this.quyenhan = quyenhan;
    }
    
    @Override
 
   	public String toString() {
   		return "Account [IDAcc=" + IDAcc + ", Username=" + Username + ", Password=" + Password + ", quyenhan="
   				+ quyenhan + "]";
   	}
    
     public void inputAccount(){
        System.out.print("\nNhập ID account:");
                IDAcc = sc.nextLine();
        System.out.print("\nNhập Username:");
                Username = sc.nextLine();
        System.out.print("\nNhập Password:");
                Password = sc.nextLine();
                   int x = 0;
                   do 
                   {
         System.out.println("\nChọn Quyền hạn:");
         System.out.println("""
                          1. Quản trị viên 
                          2. Nhân viên
                          """);
         x = sc.nextInt();
       if ( x == 1)
        {
            quyenhan = "Quản trị viên";
           
        }
        else {
        	quyenhan = "Nhân viên";
        
        }
        }while(x!=1&&x!=2);
       
   }
    public static void main(String argv[]) {
    	 Account acc=new Account();
    	 acc.inputAccount();
    	 System.out.println(acc.toString());
     }

	
}
