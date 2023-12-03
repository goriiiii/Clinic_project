package CODE;

import java.util.Scanner;

abstract class CONNGUOI {
    KiemTra kt = new KiemTra();
    Scanner scanner = new Scanner(System.in);
    String name;
    String birthday;
    String phonenumber;
    String address;
    String gender;

    public CONNGUOI() {
        this.name = "";
        this.birthday = "";
        this.phonenumber = "";
        this.address = "";
        this.gender = "";
    }

    public CONNGUOI(String name, String birthday, String phonenumber, String address, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = address;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Ho va ten:" + name + ", ngay sinh: " + birthday
                + ", so dien thoai:  " + phonenumber + ", dia chi: " + address + ", phai: " + gender + "]";
    }

    public void nhapThongTin() {
        System.out.println("Nhap ho ten:");
        this.name = kt.KiemTraNhapChuoi();

        System.out.println("Nhap ngay sinh: (dd-MM-yyyy):");
        this.birthday = kt.validateBirthday();

        System.out.println("Nhap so dien thoai:");
        this.phonenumber = kt.validatePhoneNumber();

        System.out.println("Nhap dia chi:");
        this.address = kt.KiemTraNhapChuoi();

        System.out.println("Nhap phai: (nam/nu)");
        this.gender = kt.validateGender();
    }

}
