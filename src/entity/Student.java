package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
	
	private static int AUTO_ID = -1;
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String className;
    
    public Student() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
    public Student(String name, String address, String phoneNumber, String className) {
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.className = className;
    }

	public int getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String toString() {
        return "entity.Teacher{" +
                "id=" + id +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' + 
                ", className='" + this.getClassName() + '\'' +'}';
    }
	
	public void inputInfo() {
		System.out.print("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập SĐT: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.print("Nhập lớp: ");
        this.className = new Scanner(System.in).nextLine();
    }

}
