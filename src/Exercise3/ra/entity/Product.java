package Exercise3.ra.entity;

import java.util.Scanner;

public class Product implements  IShop{
    private String productid;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product(String productid, String productName, float price, String description, int catalogId, int productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public Product() {
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog){
        while (true){
            System.out.print("Nhập mã sản phẩm (Cxxx hoặc Sxxx hoặc Axxx ): ");
            String inputId = scanner.nextLine().toUpperCase().trim();

            if (!inputId.matches("^[ACS]\\d{3}$")) {
                System.out.println("Lỗi: Mã phải gồm 4 ký tự, bắt đầu bằng C hoặc S hoặc A, tiếp theo là 3 chữ số!");
                continue;
            }
            boolean isDuplicate = false;
            for (int i =0; i < indexCatalog ; i++) {
                if ((arrProduct[i].getProductid().toUpperCase()).equals(inputId)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Lỗi: Mã sản phẩm này đã tồn tại trong hệ thống!");
                continue;
            }

            this.productid = inputId;
            break;
        }
        while (true){
            System.out.print("Nhập tên sản phẩm :");
            String inputName = scanner.nextLine().toLowerCase().trim();
            if (inputName.length() < 10 ||inputName.length() > 50) {
                System.out.println("Lỗi: Tên sản phẩm có độ dài từ 10-50 ký tự!");
                continue;
            }
            boolean isDuplicate = false;
            for (int i =0; i < indexCatalog ; i++) {
                if ((arrProduct[i].getProductName().toLowerCase()).equals(inputName)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Lỗi: Tên sản phẩm bị trùng !");
                continue;
            }

            this.productName = inputName;
            break;
        }
        System.out.print("Nhập giá : ");
        while (true){
            try {
                float inputPrice = Integer.parseInt(scanner.nextLine().trim());
                if (inputPrice <= 0) {
                    System.out.println("Lỗi: Giá phải là số nguyên lớn hơn 0!");
                    continue;
                }
                this.price = inputPrice;
                break;
            } catch (NumberFormatException e) {
                System.out.print("Giá phải là số nguyên. Nhập lại: ");
            }
        }
        System.out.print("Nhập mô tả :");
        this.description = scanner.nextLine().trim();
        System.out.print("Nhập mã danh mục : ");
        if (arrCategories == null || indexCatalog == 0) {
            System.out.println("Cảnh báo: Hiện chưa có danh mục nào trong hệ thống! Tạm thời gán mã danh mục = 0.");
            this.catalogId = 0;
        }else {
            while (true) {
                System.out.println("\n--- DANH SÁCH DANH MỤC ĐANG CÓ ---");
                for (int i = 0; i < indexCatalog; i++) {
                    // Hiển thị số thứ tự (i+1) kèm tên danh mục cho người dùng chọn
                    System.out.printf("%d. %s (Mã DM: %d)\n",
                            (i + 1), arrCategories[i].getCatalogName(), arrCategories[i].getCatalogId());
                }
                System.out.print("Lựa chọn danh mục sản phẩm (Nhập từ 1 đến " + indexCatalog + "): ");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 1 && choice <= indexCatalog) {
                        // Lấy ra danh mục tương ứng với số thứ tự người dùng chọn
                        Categories selectedCatalog = arrCategories[choice - 1];
                        // Gán mã danh mục của danh mục đó cho sản phẩm
                        this.catalogId = selectedCatalog.getCatalogId();
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
            System.out.println("Chọn trạng thái sản phẩm:");
            System.out.println("0. Đang bán");
            System.out.println("1. Hết hàng");
            System.out.println("2. Không bán");
            System.out.print("Lựa chọn của bạn (0-2): ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                this.productStatus = 0;
                break;
            } else if (choice == 1) {
                this.productStatus = 1;
                break;
            }
            else if (choice == 2) {
                this.productStatus = 2;
                break;
            }else {
                System.out.println("Lỗi: Vui lòng chỉ chọn số 0 đến số 2!");
            }
        }
    }
    @Override
    public void displayData(){
        System.out.println("Mã sản phẩm : "+getProductid()+" ,Tên sản phẩm : "+getProductName()+" ,Giá : "+getPrice()+" ,Mổ tả : "+getDescription()+" ,Mã danh mục : "+getCatalogId()+" ,Trạng thái : " +((productStatus == 1) ? "Hết hàng" : (productStatus == 2) ? "Không bán" : "Đang bán"));
    }
}
