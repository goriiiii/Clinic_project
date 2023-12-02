package CODE;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    private ArrayList<Account> listAcc;

    private int slg;
    KiemTra kt = new KiemTra();
    Scanner sc = new Scanner(System.in);

    public AccountList() {
        this.listAcc = new ArrayList<>();
    }

    public AccountList(ArrayList<Account> listAcc) {
        this.listAcc = listAcc;
    }

    public Account timkiemacctheoID() {
        Account acc = null;
        System.out.println("Nhap vao ID nhan vien :");
        String id = sc.nextLine();
        for (int i = 0; i < listAcc.size(); i++)
            if (listAcc.get(i).getIDAcc().equalsIgnoreCase(id)) {
                acc = listAcc.get(i);
                break;
            }
        return acc;
    }

    public void nhapDSAcc() {
        boolean cont = true;
        while (cont == true) {

            System.out.println("Nhập vào số lượng tài khoản:");
            slg = Integer.parseInt(kt.KiemTraNhapSo());

            for (int i = 0; i < slg; i++) {
                Account acc = new Account();
                acc.inputAccount();

                boolean isDuplicate = true;
                for (Account acc1 : listAcc) {
                    while (isDuplicate == true) {
                        if (acc.getIDAcc().equals(acc1.getIDAcc())) {
                            System.out.println("Không cho phép ID trùng lặp!");
                            isDuplicate = true;
                            acc.inputAccount();
                        } else {
                            isDuplicate = false;
                        }
                    }
                }
                this.listAcc.add(acc);

            }
            cont = kt.TiepTuc(cont);
        }

    }

    // public void docfile()
    // {
    // System.out.println("Nhập vào duong dẫn của file:");
    // String file = sc.nextLine();
    // StringBuilder sb = new StringBuilder();
    // for (int i=0; i< file.length(); i++)
    // {
    // char currentChar = file.charAt(i);
    // if (currentChar!= '\"'){
    // sb.append(currentChar);
    // }
    // if (currentChar!= '\\'){
    // sb.append("\\");
    // }
    // }
    // System.out.println(sb);
    // file=sb.toString();
    // try {
    // File f = new File (file);
    // if(f.exists()){
    // Scanner read = new Scanner (f);
    // if(!read.hasNext()){
    // System.out.println("File rỗng!Đang thêm nội dung...");
    // vietfileauto(listAcc,file);
    // return;
    // }
    // while(read.hasNextLine()){
    // String line = read.nextLine();
    // String[] properties;
    // properties = line.split(",");
    // if (properties.length >= 4){
    // String[] pro= new String[4];
    // for (int i=0; i<4; i++)
    // {
    // pro[i] = properties[i].trim();
    // }
    // Account acc = new Account(pro[0],pro[1],pro[2],pro[3]);
    // this.listAcc.add(acc);
    // }
    // else
    // {
    // System.out.println("Invalid format in the line: " + line );
    // }
    // }
    // }
    // else {
    // System.out.println("File không tồn tại");
    // }
    // }
    // catch (Exception e){
    // e.printStackTrace();
    // }
    // }
    ////
    // public void ghifile_object()
    // {
    // System.out.println("C:\\Users\\jofob\\Desktop\\HKI(23-24)\\OOP\\Document\\output.txt");
    // String file = sc.nextLine();/
    // StringBuilder sb = new StringBuilder();
    // for (int i=0; i< file.length(); i++)
    // {
    // char currentChar = file.charAt(i);
    // if (currentChar!= '\"'){
    // sb.append(currentChar);
    // }
    // if (currentChar!= '\\'){
    // sb.append("\\");
    // }
    // }
    // System.out.println(sb);
    // file=sb.toString();
    // try (FileWriter filewriter = new FileWriter(file,true);
    // BufferedWriter bufferedwrite = new BufferedWriter(filewriter)){
    // for ( Account acc : listAcc){
    // if (acc!= null){
    // bufferedwrite.write(acc.getIDAcc() +
    // " "+ acc.getUsername()+ "\n");
    // }
    // }
    // System.out.println("Danh sách dã được viết vào file thành công!");
    // } catch (IOException e){
    // e.printStackTrace();
    // }
    // }
    // //----------------- end WRITE_FILE-----------------
    //
    //
    // //----------------- start RESERVE LIST -----------------
    // public void vietfileauto (ArrayList<Account> listAcc, String file)
    // {
    // Account acc1 = new Account ();
    // listAcc.add(acc1);
    // Account acc2 = new Account ();
    // listAcc.add(acc2);
    // Account acc3 = new Account ();
    // listAcc.add(acc3);
    // Account acc4 = new Account ();
    // listAcc.add(acc4);
    // Account acc5 = new Account ();
    // listAcc.add(acc5);
    // Account acc6 = new Account ();
    // listAcc.add(acc6);
    // Account acc7 = new Account ();
    // listAcc.add(acc7);
    // Account acc8 = new Account ();
    // listAcc.add(acc8);
    // Account acc9 = new Account ();
    // listAcc.add(acc9);
    // Account acc10 = new Account ();
    // listAcc.add(acc10);
    // try (FileWriter filewriter = new FileWriter(file,true);
    // BufferedWriter bufferedwrite = new BufferedWriter(filewriter)){
    // for ( Account acc : listAcc){
    // if (acc!= null){
    // bufferedwrite.write(acc.getIDAcc() +
    // " "+ acc.getUsername()+ "\n");
    // }
    // }
    // System.out.println("Danh sách dã được viết vào file thành công!");
    // } catch (IOException e){
    // e.printStackTrace();
    // }
    // }
    // //----------------- end RESERVE LIST -----------------
    //
    //
    //
    // //----------------- start CREATE/ADD_ACCOUNT (ADMIN) -----------------
    // public void Add (){
    // Account acc = null;
    // acc.inputacc(acc);
    // this.listAcc.add(acc);
    // }
    // //----------------- end CREATE/ADD_ACCOUNT (ADMIN) -----------------
    //
    //
    //
    // //----------------- start SHOW_ACCOUNTLIST (ADMIN) -----------------
    // public void print (){
    // for (Account acc : listAcc)
    // {
    // System.out.println(acc.toString());
    // }
    // }
    //
    //
    // public boolean check_acc ( Account a){
    // for (Account acc : listAcc)
    // {
    // if ( a == acc)
    // return true;
    // }
    // return false;
    // }
    // //----------------- end CHECK_EXISTION-OF-ACCOUNT-----------------
    //
    //
    //
    //
    // //----------------- start DELETE_ACCOUNT (ADMIN) -----------------
    // public boolean delete (Account acc){
    // return this.listAcc.remove(acc);
    // }
    // //----------------- end DELETE_ACCOUNT (ADMIN) -----------------
    //
    //
    //
    //
    // //----------------- start CHANGE_PASSWORD (staff + admin) -----------------
    // public void Thaydoipassword(Account acc){
    // String pass1, pass2;
    // do{
    // System.out.println("Nhap vao password moi:");
    // pass1 = sc.nextLine();
    // System.out.println("Nhap vao password moi:");
    // pass2 = sc.nextLine();}
    // while (pass1 == pass2);
    // acc.setPassword(pass2);
    // System.out.println("Bạn đã đổi password thành công!");
    // }
    // //----------------- end CHANGE_PASSWORD (staff + admin) -----------------
    //
    //
    //
    //
    // //----------------- start CHANGE_USERNAME (staff + admin) -----------------
    // public void Thaydoiusername (Account acc){
    // System.out.println("Nhap vao username moi:");
    // String name = sc.nextLine();
    // acc.setUsername(name);
    // System.out.println("Bạn đã đổi username thành công!");
    // }
    // //----------------- end CHANGE_USERNAME (staff + admin) -----------------
    //
    //
    //
    // //----------------- start LOGIN (staff + admin) -----------------
    // public void login ( Account a){
    // do{
    // System.out.println("Mời nhập thông tin tài khoản!");
    // a.inputacc();}
    // while (check_acc( a)== true);
    // System.out.println("Chúc Mừng bạn đã đăng nhập thành công!");
    // }
    //
    // public void logout (){
    // System.exit(0);
    // }
    //
    //
    //// ----------------------------MENU--------------------------------
    // public void question (){
    // int n;
    // do{
    // System.out.println("Bạn có muốn đăng nhập vào tài khoản không ?");
    // System.out.print("""
    // 1. Có
    // 2. Không
    // """);
    // n = sc.nextInt();
    // }
    // while ( n==1 );
    //
    // }
    //
    // public void Change_in4 (AccountList listacc, Account acc){
    // int n;
    // do{
    // System.out.println("Bạn có muốn thay đổi username không ?");
    // System.out.print("""
    // 1. Có
    // 2. Không
    // """);
    // n = sc.nextInt();} while (n==1 || n==2);
    // if ( n==1 )
    // {
    // listacc.Thaydoiusername(acc);
    // int x;
    // do{
    // System.out.println("Bạn có muốn thay đổi username không ?");
    // System.out.print("""
    // 1. Có
    // 2. Không
    // """);
    // x = sc.nextInt();}
    // while (x==1 || x==2);
    // if ( x==1 )
    // {
    // listacc.Thaydoipassword(acc);
    // }
    // else System.exit(0);
    // }
    // else System.exit(0);
    // }
    //
    //
    // public boolean kt_quyenhan (Account acc){
    // if (acc.getQuyenhan()== "Quản trị viên")
    // return true;
    // else return false;
    // }
    //
    // public void act_admin (){
    // System.out.println("Mời nhập vào thao tác cần thực hiện!");
    //
    // }
    public static void main(String argv[]) {
        AccountList acclist = new AccountList();
        acclist.nhapDSAcc();
    }

}
