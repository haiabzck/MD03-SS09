package Exercise3.ra.entity;

import Exercise2.ra.entity.Pet;

import java.util.Scanner;

public class Categories implements IShop{
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus ;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index){
        if (arrCategories == null || index == 0) {
            this.catalogId = 0; // Nếu danh sách trống, bắt đầu từ mã 1
        }

        int maxId = arrCategories[0].getCatalogId();
        for (int i =0; i < index ; i++) {
            if (arrCategories[i].getCatalogId() > maxId) {
                maxId = arrCategories[i].getCatalogId();

            }
        }
        this.catalogId = maxId + 1;
        System.out.println("Mã danh mục tự động cấp phát: " + this.catalogId);
        while (true){
            System.out.print("Nhập tên danh mục :");
            String catalogName = scanner.nextLine().toLowerCase().trim();
            if (catalogName.length() > 50) {
                System.out.println("Lỗi: Tên danh mục có độ dài tối đa 50 ký tự!");
                continue;
            }
            boolean isDuplicate = false;
            for (int i =0; i < index ; i++) {
                if ((arrCategories[i].getCatalogName().toLowerCase()).equals(catalogName)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Lỗi: Tên danh mục bị trùng !");
                continue;
            }

            this.catalogName = catalogName;
            break;
        }

        System.out.print("Nhập mô tả :");
        this.descriptions = scanner.nextLine().trim();
        while (true) {
            System.out.print("Nhập trạng thái danh mục (true - hoạt động / false - không hoạt động): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("true")) {
                this.catalogStatus = true;
                break;
            } else if (input.equalsIgnoreCase("false")) {
                this.catalogStatus = false;
                break;
            } else {
                System.out.println("Lỗi: Giá trị nhập vào không hợp lệ! Chỉ nhận 'true' hoặc 'false'.");
            }
        }
    }
    @Override
    public void displayData(){
        System.out.println("Mã danh mục : "+getCatalogId()+" ,Tên danh mục: "+getCatalogName()+" ,Mô tả : "+getDescriptions()+",Tình trạng : "+(catalogStatus ? "Hoạt động" : "Không hoạt động"));
    }
}
