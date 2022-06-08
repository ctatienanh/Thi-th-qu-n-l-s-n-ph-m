import java.util.ArrayList;
import java.util.Scanner;

public class ManageProduct {
    ArrayList<ClassProduct> classProducts = ReaderAndWriter.Reader();
    Scanner scanner = new Scanner(System.in);
    public void Menu(){
        System.out.println("1:Xem danh sách");
        System.out.println("2:Thêm mới sản phẩm");
        System.out.println("3:Cập nhật");
        System.out.println("4:Xóa");
        System.out.println("5:Sắp xếp");
        System.out.println("6:Tìm sản phẩm có giá đắt nhất");
        System.out.println("7:Đọc từ file");
        System.out.println("8:Ghi vào file");
        System.out.println("9:Thoát");
        System.out.println("Chọn chức năng:");
        switch (Integer.parseInt(Validate.Choice())){
            case 1:
                show();
                break;
            case 2:
                add();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                sort();
                break;
            case 6:
                checkprice();
                break;
            case 7:
                ReaderAndWriter.Reader();
                break;
            case 8:
                ReaderAndWriter.writer(classProducts);
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn nhập lại");
        }
    }

    public ClassProduct creatProduct(){
        System.out.println("Nhập Thông tin của sản phẩm ");

        System.out.println("Nhập id sản phẩm ");
        System.out.print("Nhập id :");
        String id = Validate.id();

        System.out.print("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá : ");
        int price = Integer.parseInt(Validate.Choice());

        System.out.print("Nhập số lượng :");
        int amount = Integer.parseInt(Validate.Choice());

        System.out.print("Mô tả sản phẩm :");
        String describle = scanner.nextLine();

        return new ClassProduct(id,name,price,amount,describle);
    }

    public void add(){
        classProducts.add(creatProduct());
    }

    public void show(){
        for (int i = 0; i < classProducts.size(); i++) {
            System.out.println(" Sản phẩm "+(i+1) +" :");
            System.out.println(" id sản phẩm       : "+classProducts.get(i).getId() );
            System.out.println(" Tên sản phẩm      : "+classProducts.get(i).getName());
            System.out.println(" Giá sản phẩm      : " +classProducts.get(i).getPrice());
            System.out.println(" Số lượng sản phẩm : "+classProducts.get(i).getAmount());
            System.out.println(" Mô tả sản phẩm    : " +classProducts.get(i).getDescribe());
            System.out.println("----------------------------------------------------");
        }
    }

    public int checkid(){
        while (true) {
            System.out.print("Nhập mã sản phẩm :");
            String id = scanner.nextLine();
            for (int i = 0; i < classProducts.size(); i++) {
                if (classProducts.get(i).getId().equals(id)) {
                    return i;
                }
            }
            System.out.println("Không tìm thấy mã sản phẩm ");
            Menu();
        }
    }

    public void edit(){
        classProducts.set(checkid(),creatProduct());
    }

    public void delete(){
        int index = checkid();
        System.out.println("bạn có chắc chắn muốn xóa mã sản phẩm " + classProducts.get(index).getId());
        while (true) {
            System.out.println("1: có");
            System.out.println("2: không");
            switch (Integer.parseInt(Validate.Choice())) {
                case 1:
                    classProducts.remove(index);
                    break;
                case 2:
                    Menu();
                    break;
                default:
                    System.out.println("Không tìm thấy lựa chọn");
            }
        }
    }

    public void sort() {
        while (true) {
            System.out.println("1:Hiển thị sản phẩm theo giá tăng");
            System.out.println("2:Hiển thị sản phẩm theo giá giảm");
            System.out.println("3:Quay lại Menu");
            System.out.println("Nhập lựa chọn");
            switch (Integer.parseInt(Validate.Choice())){
                case 1:
                    classProducts.sort(new SortTang());
                    show();
                    break;
                case 2:
                    classProducts.sort(new SortGiam());
                    show();
                    break;
                case 3:
                    Menu();
                    break;
                default:
                    System.out.println("Không tìm thấy lựa chọn ");
            }
        }
    }
    public void checkprice(){
        int max = classProducts.get(0).getPrice();
        int index =0 ;
        for (int i = 0; i < classProducts.size(); i++) {
               if (max < classProducts.get(i).getPrice()){
                   index =i;
               }
        }
        System.out.println(" Sản phẩm có giá tiền lớn nhất "+( index +1) +" :");
        System.out.println(" id sản phẩm       : "+classProducts.get(index).getId() );
        System.out.println(" Tên sản phẩm      : "+classProducts.get(index).getName());
        System.out.println(" Giá sản phẩm      : " +classProducts.get(index).getPrice());
        System.out.println(" Số lượng sản phẩm : "+classProducts.get(index).getAmount());
        System.out.println(" Mô tả sản phẩm    : " +classProducts.get(index).getDescribe());
        System.out.println("----------------------------------------------------");
    }


}
