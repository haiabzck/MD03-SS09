package Exercise3.ra.presentation;

import Exercise3.ra.entity.Categories;
import Exercise3.ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    private static final Categories[] arrCategories = new Categories[100];
    private static int countCate = 0;

    private static final Product[] arrProduct = new Product[100];
    private static int countPro = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn :");

            int choie = Integer.parseInt(scanner.nextLine());

            switch (choie){
                case 1:
                    while (true) {
                        System.out.println("\n********************CATEGORIES MENU***********");
                        System.out.println("1. Nhập thông tin các danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Cập nhật trạng thái danh mục");
                        System.out.println("6. Thoát");
                        System.out.print("Lựa chọn của bạn :");

                        int choieCate = Integer.parseInt(scanner.nextLine());

                        switch (choieCate) {
                            case 1:
                                System.out.print("Nhập số lượng danh mục muốn thêm :");
                                int n = Integer.parseInt(scanner.nextLine());

                                for (int i =0; i < n ; i++) {
                                    if (countCate >= 100) {
                                        System.out.println("Bộ nhớ mảng danh mục đã đầy!");
                                        break;
                                    }
                                    System.out.println("\nNhập thông tin danh mục thứ " +(i+1)+" :");
                                    arrCategories[countCate] = new Categories();
                                    arrCategories[countCate].inputData(scanner,arrCategories,countCate);
                                    countCate++;
                                }
                                break;
                            case 2:
                                System.out.println("Danh sách danh mục :");
                                for (int i =0; i < countCate ; i++) {
                                    arrCategories[i].displayData();
                                }
                                break;
                            case 3:
                                System.out.print("Nhập mã danh mục cần cập nhật :");
                                int inputUpdate = Integer.parseInt(scanner.nextLine());
                                for (int i =0; i < countCate ; i++) {
                                    if (arrCategories[i].getCatalogId() == inputUpdate ){
                                        System.out.print("Cập nhật tên mới:");
                                        arrCategories[i].setCatalogName(scanner.nextLine());
                                        System.out.print("Cập nhật mô tả mới: ");
                                        arrCategories[i].setDescriptions(scanner.nextLine());
                                        System.out.println("Cập nhật thông tin danh mục thành công!");
                                        break;
                                    } else {
                                        System.out.println("Mã danh mục không tồn tại.");
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("Nhập mã danh mục cần xóa :");
                                int inputDelete = Integer.parseInt(scanner.nextLine());
                                boolean isCate = false;
                                for (int i =0; i < countCate ; i++) {
                                    if (arrCategories[i].getCatalogId() == inputDelete ){
                                        for (int j = 0; j < countPro; j++) {
                                            if (arrCategories[j].getCatalogId() == inputDelete ){
                                                isCate = true;
                                                break;
                                            }
                                        }
                                        if(isCate){
                                            System.out.println("Không thể xóa danh mục vì đang chứa sản phẩm!");
                                        }else {
                                            for (int j = i; j < countCate -1  ; j++) {
                                                arrCategories[j] = arrCategories[j+1];
                                            }
                                            arrCategories[countCate-1] = null;
                                            countCate--;
                                            System.out.println("Xóa danh mục thành công.");
                                            return;
                                        }
                                    }else {
                                        System.out.println("Mã danh mục không tồn tại.");
                                    }
                                }
                                break;
                            case 5:
                                System.out.print("Nhập mã danh mục cần cập nhật trạng thái :");
                                int input = Integer.parseInt(scanner.nextLine());
                                for (int i =0; i < countCate ; i++) {
                                    if (arrCategories[i].getCatalogId() == input ){
                                        arrCategories[i].setCatalogStatus(!arrCategories[i].isCatalogStatus());
                                        System.out.println("Đã chuyển đổi trạng thái danh mục thành công!");
                                        break;
                                    }else {
                                        System.out.println("Mã danh mục không tồn tại.");
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Thoát thành công ! Quay lại menu ");
                                break;
                            default:
                                System.out.println("Nhâp lựa chọn sai .Vui lòng nhập lại(1-6) !");
                        }
                        break;
                    }
                    break;
                case 2 :
                    while (true){
                        System.out.println("\n*******************PRODUCT MANAGEMENT*****************");
                        System.out.println("1. Nhập thông tin các sản phẩm");
                        System.out.println("2. Hiển thị thông tin các sản phẩm");
                        System.out.println("3. Sắp xếp các sản phẩm theo giá");
                        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
                        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
                        System.out.println("8. Thoát ");
                        System.out.print("Lựa chọn của bạn :");

                        int choiePro = Integer.parseInt(scanner.nextLine());
                        switch (choiePro){
                            case 1:
                                System.out.print("Nhập số lượng sản phẩm muốn thêm :");
                                int n = Integer.parseInt(scanner.nextLine());
                                for (int i = 0; i < n ; i++) {
                                    if (countPro >= 100) {
                                        System.out.println("Bộ nhớ mảng sản phẩm đã đầy!");
                                        break;
                                    }
                                    System.out.println("Nhập thông tin sản phẩm thứ "+ (i + 1) +" :");
                                    arrProduct[countPro] = new Product();
                                    arrProduct[countPro].inputData(scanner,arrProduct,countPro,arrCategories,countCate);
                                    countPro++;
                                    System.out.println("Thêm sản phẩm thành công !");
                                }
                                break;
                            case 2:
                                System.out.println("Danh sách sản phẩm :");
                                for (int i =0; i < countPro ; i++) {
                                    arrProduct[i].displayData();
                                }
                                break;
                            case 3:
                                for (int i = 0; i < countPro - 1; i++) {
                                    for (int j = i + 1; j < countPro; j++) {
                                        if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                                            Product temp = arrProduct[i];
                                            arrProduct[i] = arrProduct[j];
                                            arrProduct[j] = temp;
                                        }
                                    }
                                }
                                System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần!");
                                break;
                            case 4:
                                System.out.print("Nhập mã sản phẩm cần cập nhật :");
                                String inputUpdate = scanner.nextLine().toUpperCase().trim();
                                boolean isId = false;
                                for (int i =0; i < countPro ; i++) {
                                    if ((arrProduct[i].getProductid()).equals(inputUpdate)){
                                        isId = true;
                                        System.out.print("Cập nhật tên mới:");
                                        arrProduct[i].setProductName(scanner.nextLine().toUpperCase());
                                        System.out.print("Cập nhật giá :");
                                        arrProduct[i].setPrice(Float.parseFloat(scanner.nextLine()));
                                        System.out.print("Cập nhật mô tả mới: ");
                                        arrProduct[i].setDescription(scanner.nextLine());
                                        System.out.print("Cập nhật mã danh mục");
                                        if ( countCate == 0) {
                                            System.out.println("Cảnh báo: Hiện chưa có danh mục nào trong hệ thống! Tạm thời gán mã danh mục = 0.");
                                            arrProduct[i].setCatalogId(0);
                                        }else {
                                            while (true) {
                                                System.out.println("\n--- DANH SÁCH DANH MỤC ĐANG CÓ ---");
                                                for (int j = 0; j < countCate; j++) {
                                                    // Hiển thị số thứ tự (i+1) kèm tên danh mục cho người dùng chọn
                                                    System.out.printf("%d. %s (Mã DM: %d)\n",
                                                            (j + 1), arrCategories[j].getCatalogName(), arrCategories[j].getCatalogId());
                                                }
                                                System.out.print("Lựa chọn danh mục sản phẩm (Nhập từ 1 đến " + countCate + "): ");

                                                try {
                                                    int choice = Integer.parseInt(scanner.nextLine());
                                                    if (choice >= 1 && choice <= countCate) {
                                                        // Lấy ra danh mục tương ứng với số thứ tự người dùng chọn
                                                        Categories selectedCatalog = arrCategories[choice - 1];
                                                        // Gán mã danh mục của danh mục đó cho sản phẩm
                                                        arrProduct[i].setCatalogId(selectedCatalog.getCatalogId());
                                                        System.out.println("Đã chọn danh mục: " + selectedCatalog.getCatalogName());
                                                        break;
                                                    } else {
                                                        System.out.println("Lỗi: Số bạn chọn nằm ngoài danh sách. Vui lòng chọn lại!");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Lỗi: Vui lòng nhập vào một số nguyên hợp lệ!");
                                                }
                                            }
                                        }
                                        while (true) {
                                            System.out.println("Chọn trạng thái cập nhật sản phẩm:");
                                            System.out.println("0. Đang bán");
                                            System.out.println("1. Hết hàng");
                                            System.out.println("2. Không bán");
                                            System.out.print("Lựa chọn của bạn (0-2): ");

                                            int choice = Integer.parseInt(scanner.nextLine().trim());
                                            if (choice == 0) {
                                                arrProduct[i].setProductStatus(0);
                                                break;
                                            } else if (choice == 1) {
                                                arrProduct[i].setProductStatus(1);
                                                break;
                                            }
                                            else if (choice == 2) {
                                                arrProduct[i].setProductStatus(2);
                                                break;
                                            }else {
                                                System.out.println("Lỗi: Vui lòng chỉ chọn số 0 đến số 2!");
                                            }
                                        }
                                        System.out.println("Cập nhật thông tin danh mục thành công!");
                                        break;
                                    }
                                }
                                if (!isId){
                                    System.out.println("Mã danh mục không tồn tại.");
                                }
                                break;
                            case 5:
                                System.out.print("Nhập mã sản phẩm cần xóa :");
                                String inputDelete =scanner.nextLine().toUpperCase();
                                boolean isProduct = false;
                                for (int i =0; i < countPro ; i++) {
                                    if ((arrProduct[i].getProductid()).equals(inputDelete)){
                                        for (int j = i; j < countPro -1 ; j++) {
                                            arrProduct[j] = arrProduct[j + 1];
                                        }
                                        arrProduct[countPro - 1] = null;
                                        countPro--;
                                        System.out.println("Xóa sản phẩm thành công.");
                                        isProduct = true;
                                        break;
                                    }
                                }
                                if (!isProduct){
                                    System.out.println("Mã sản phẩm không tồn tại !");
                                }
                                break;
                            case 6:
                                System.out.print("Nhập tên sản phẩm muốn tìm : ");
                                String searchInput = scanner.nextLine().toLowerCase().trim();
                                boolean isSearch = false;
                                for (int i = 0; i < countPro; i++) {
                                    if((arrProduct[i].getProductName().toLowerCase()).contains(searchInput)){
                                        arrProduct[i].displayData();
                                        isSearch = true;
                                    }
                                }
                                if(!isSearch){
                                    System.out.println("Không tìm thấy sản phẩm !");
                                }
                                break;
                            case 7:
                                System.out.print("Nhập giá sàn (a): ");
                                float a = Float.parseFloat(scanner.nextLine());
                                System.out.print("Nhập giá trần (b): ");
                                float b = Float.parseFloat(scanner.nextLine());
                                System.out.println("--- Kết quả tìm kiếm từ khoảng giá " + a + " đến " + b + " ---");
                                for (int i = 0; i < countPro; i++) {
                                    if (arrProduct[i].getPrice() >= a && arrProduct[i].getPrice() <= b) {
                                        arrProduct[i].displayData();
                                    }
                                }
                                break;
                            case 8:
                                System.out.println("Thoát thành công ! Quay lại menu ");
                                break;
                            default:
                            System.out.println("Nhâp lựa chọn sai .Vui lòng nhập lại(1-8) !");
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình thành công !");
                    return;
                default:
                    System.out.println("Nhâp lựa chọn sai .Vui lòng nhập lại(1-3) !");
            }
        }
    }
}
