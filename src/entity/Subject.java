package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable{
private static int AUTO_ID = -1;
	
	private int id;
	private String name;
	private int unit;
	private String type;
    
    public Subject() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
    public Subject(String name, int unit, String type) {
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.name = name;
        this.unit = unit;
        this.type = type;
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

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
        return "entity.Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", type='" + type + '\'' +'}';
    }
	
	public void inputInfo() {
        System.out.print("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết: ");
        this.unit = new Scanner(System.in).nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        this.type = new Scanner(System.in).nextLine();
    }
}
