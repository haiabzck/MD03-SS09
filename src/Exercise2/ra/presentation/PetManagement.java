package Exercise2.ra.presentation;

import Exercise2.ra.entity.Cat;
import Exercise2.ra.entity.Dog;
import Exercise2.ra.entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetManagement {
    private static final List<Pet> petList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n*********************QUẢN LÝ THÚ CƯNG********************");
            System.out.println("1 .Hiển thị danh sách thú cưng");
            System.out.println("2 .Thêm thú cưng");
            System.out.println("3 .Gọi tiếng kêu");
            System.out.println("4 .Xóa thú cưng");
            System.out.println("5 .Tìm thú cưng theo tên");
            System.out.println("6 .Thoát ");
            System.out.print("\nLựa chọn của bạn : ");

            int choie = Integer.parseInt(sc.nextLine());

            switch (choie){
                case 1:
                    if(petList.isEmpty()){
                        System.out.println("Chưa có Pet . Mời thêm Pet");
                        break;
                    }
                    System.out.println("Danh sách Pet :");
                    for (Pet pets :petList){
                        pets.displayData();
                        System.out.print("Tiếng kêu :");
                        pets.speak();
                    }
                    break;
                case 2:
                    System.out.println("Chọn loại thú cưng muốn thêm:");
                    System.out.println("1. Chó (Dog)");
                    System.out.println("2. Mèo (Cat)");
                    System.out.print("Lựa chọn của bạn: ");

                    int type;
                    try {
                        type = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        type = 0;
                    }

                    Pet newPet;
                    if (type == 1) {
                        newPet = new Dog();
                    } else if (type == 2) {
                        newPet = new Cat();
                    } else {
                        System.out.println("Lựa chọn loại thú cưng không hợp lệ. Hủy thao tác.");
                        return;
                    }

                    newPet.inputData(sc, petList);
                    petList.add(newPet);
                    System.out.println("Thêm thú cưng mới thành công!");
                    break;
                case 3:
                    if (petList.isEmpty()) {
                        System.out.println("Không có thú cưng nào trong danh sách để phát tiếng kêu.");
                        break;
                    }
                    System.out.println("--- DÀN ĐỒNG CA THÚ CƯNG ---");
                    for (Pet pet : petList) {
                        System.out.print(pet.getName() + " kêu: ");
                        pet.speak();
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã Pet cần xóa : ");
                    String idDelete = sc.nextLine().toUpperCase().trim();
                    boolean isDelete =false;
                    for (int i = 0; i < petList.size(); i++){
                        if (petList.get(i).getId().toUpperCase().equals(idDelete)){
                            petList.remove(i);
                            System.out.println("Đã xóa thành công Pet có mã " +idDelete);
                            isDelete = true;
                            break;
                        }
                    }
                    if (!isDelete){
                        System.out.println("Mã Pet không tồn tại");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên Pet muốn tìm : ");
                    String searchName = sc.nextLine().trim().toLowerCase();
                    int countPet = 0;
                    boolean isSearch = false;
                    for (Pet pets : petList){
                        if (pets.getName().toLowerCase().contains(searchName)){
                            pets.displayData();
                            System.out.print("Tiếng kêu: ");
                            pets.speak();
                            countPet++;
                            isSearch = true;
                        }
                    }
                    if(!isSearch){
                        System.out.println("Không tìm thấy Pet nào !");
                    }
                    System.out.println("Tổng số lượng Pet tìm thấy: " + countPet);
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
