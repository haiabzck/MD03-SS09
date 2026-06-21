package Exercise2.ra.entity;

import java.util.List;
import java.util.Scanner;

public abstract class Pet {
    private String id;
    private String name;
    private int age;

    public Pet(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Pet() {
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
    public void inputData(Scanner scanner, List<Pet> petList){
        while (true){
            System.out.print("Nhập mã thú cưng (Cxxx hoặc Dxxx, ví dụ C001): ");
            String inputId = scanner.nextLine().toUpperCase().trim();

            if (!inputId.matches("^[CD]\\d{3}$")) {
                System.out.println("Lỗi: Mã phải gồm 4 ký tự, bắt đầu bằng C hoặc D, tiếp theo là 3 chữ số!");
                continue;
            }
            boolean isDuplicate = false;
            for (Pet p : petList) {
                if (p.getId().toUpperCase().equals(inputId)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Lỗi: Mã thú cưng này đã tồn tại trong hệ thống!");
                continue;
            }

            this.id = inputId;
            break;
        }
        while (true){
            System.out.print("Nhập tên thú cưng : ");
            String inputName =scanner.nextLine().toUpperCase().trim();
            if (inputName.length() < 20 || inputName.length() > 50) {
                System.out.println("Lỗi: Tên thú cưng phải có độ dài từ 20 đến 50 ký tự!");
                continue;
            }
            this.name = inputName;
            break;
        }

        System.out.print("Nhập tuổi thú cưng : ");
        while (true){
            try {
                int inputAge = Integer.parseInt(scanner.nextLine().trim());
                if (inputAge <= 0) {
                    System.out.println("Lỗi: Tuổi phải là số nguyên lớn hơn 0!");
                    continue;
                }
                this.age = inputAge;
                break;
            } catch (NumberFormatException e) {
                System.out.print("Tuổi phải là số nguyên. Nhập lại: ");
            }
        }

    }
    public void displayData(){
        System.out.println("Mã : "+ getId()+ ", Tên : "+getName()+", Tuổi : "+getAge());
    }
    public abstract void speak();
}
