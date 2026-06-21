package ra.entity;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private String specialized;

    public Student(String id, String name, int age, String specialized) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialized = specialized;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public void inputData(Scanner sc){
        System.out.print("Nhập mã sinh viên :");
        id =sc.nextLine().trim();
        System.out.print("Nhập tên sinh viên :");
        name =sc.nextLine().trim();
        System.out.print("Nhập tuổi sinh viên :");
        age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nhập chuyên ngành sinh viên :");
        specialized =sc.nextLine().trim();
        Student student = new Student(id,name,age,specialized);
        System.out.println("Thêm sinh viên thành công !");

    }

    public void displayData(){
        System.out.println("Mã sinh viên :" + getId() + " ,Tên sinh viên :" + getName() +" ,Tuổi : "+ getAge() + " ,Chuyên ngành :"+getSpecialized());
    }
}
