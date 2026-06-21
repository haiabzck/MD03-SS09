package Exercise1.ra.presentation;

import Exercise1.ra.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static final List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1 .Hiển thị danh sách sinh viên");
            System.out.println("2 .Thêm sinh viên");
            System.out.println("3 .Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4 .Xóa sinh viên theo mã sinh viên");
            System.out.println("5 .Tìm sinh viên theo tên sinh viên");
            System.out.println("6 .Thoát");
            System.out.print("\nLựa chọn của bạn :");

            int choie = Integer.parseInt(sc.nextLine());

            switch (choie){
                case 1:
                    if(studentList.isEmpty()){
                        System.out.println("Chưa có sinh viên . Mời thêm sinh viên");
                        break;
                    }
                    System.out.println("Danh sách sinh viên :");
                    for (Student student :studentList){
                        student.displayData();
                    }
                    break;
                case 2:
                    System.out.print("Nhập số lượng sinh viên muốn thêm :");
                    int n = Integer.parseInt(sc.nextLine());
                    while (true){
                        try{
                            if(n > 0){
                                break;
                            }else {
                                System.out.print("Số lượng phải lớn hơn 0 . Mời bạn nhập lại :");
                            }
                        }catch (NumberFormatException e){
                            System.out.print("Vui lòng nhập số nguyên :");
                        }
                    }
                    for (int i = 0 ; i < n; i++){
                        System.out.println("\nNhập thông tin sinh viên thứ " +(i+1)+" :");
                        Student student = new Student();
                        student.inputData(sc);
                        studentList.add(student);
                    }
                    System.out.println("Thêm thành công " + n + " sinh viên");
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần cập nhật : ");
                    String idUpdate = sc.nextLine().toUpperCase().trim();
                    boolean isUpdate = false;
                    for (int i = 0 ;i < studentList.size(); i++){
                        if(studentList.get(i).getId().equals(idUpdate)){
                            isUpdate = true;
                            System.out.println("Nhập thông tin mới cho sinh viên ");
                            System.out.print("Nhập tên mới : ");
                            studentList.get(i).setName(sc.nextLine().trim());
                            System.out.print("Nhập tuổi mới : ");
                            while (true) {
                                try {
                                    studentList.get(i).setAge(Integer.parseInt(sc.nextLine().trim()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.print("Tuổi phải là số nguyên. Nhập lại: ");
                                }
                            }
                            System.out.print("Nhập chuyên nghành mới : ");
                            studentList.get(i).setSpecialized(sc.nextLine().trim());
                            System.out.println("Cập nhật thông tin thành công !");
                            break;
                        }
                    }
                    if(!isUpdate){
                        System.out.println("Mã sinh viên không tồn tại !");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa : ");
                    String idDelete = sc.nextLine().toLowerCase().trim();
                    for (int i = 0; i < studentList.size(); i++){
                        if (studentList.get(i).getId().toLowerCase().equals(idDelete)){
                            studentList.remove(i);
                            System.out.println("Đã xóa thành công sinh viên có mã " +idDelete);
                            break;
                        }
                    }
                    System.out.println("Mã sinh viên không tồn tại");
                    break;
                case 5:
                    System.out.print("Nhập tên sinh viên muốn tìm : ");
                    String searchName = sc.nextLine().trim().toLowerCase();
                    int countStudent = 0;
                    boolean isSearch = false;
                    for (Student student : studentList){
                        if (student.getName().toLowerCase().contains(searchName)){
                            student.displayData();
                            countStudent++;
                            isSearch = true;
                        }
                    }
                    if(!isSearch){
                        System.out.println("Không tìm thấy sinh viên nào !");
                    }
                    System.out.println("Tổng số lượng sinh viên tìm thấy: " + countStudent);
                    break;
                case 6:
                    System.out.println("Thoát chương trình thành công !");
                    return;
                default:
                    System.out.println("Nhâp lựa chọn sai .Vui lòng nhập lại(1-6) !");
            }
        }
    }
}
