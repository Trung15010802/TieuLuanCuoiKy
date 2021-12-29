package com.trungbq2004110026.tieuluancuoiky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QLHangHoaTestDrive {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        HangHoa dsHang = new HangHoa();
        dsHang.add("Sanh su", 5, "Bát", 15000, 100, "20/1/2021");
        dsHang.add("Sanh su", 6, "Đĩa", 20000, 100, "10/5/2021");
        dsHang.add("Dien may", 1, "Máy giặt", 5000000, 20, "1/6/2021");
        dsHang.add("Thuc pham", 8, "Gạo", 20000, 1000, "5/5/2021");
        dsHang.add("Sanh su", 4, "Tô", 25000, 100, "2/1/2021");
        dsHang.add("Thuc pham", 7, "Bột mì", 35000, 1000, "1/1/2021");
        dsHang.add("Dien may", 2, "Tủ lạnh", 10000000, 30, "6/6/2021");
        dsHang.add("Thuc pham", 9, "Bánh kẹo", 150000, 100, "25/7/2021");
        dsHang.add("Dien may", 3, "Máy sấy tóc", 1000000, 10, "20/9/2021");
        dsHang.add("Dien may", 10, "Bếp từ", 900000, 20, "8/3/2021");
        dsHang.add("Thuc pham", 12, "Dưa hấu", 20000, 100, "5/12/2021");
        dsHang.add("Sanh su", 11, "Bình hoa", 50000, 10, "2/7/2021");
        dsHang.add("Dien may", 13, "Máy nước nóng", 70000000, 20, "1/8/2021");
        dsHang.add("Thuc pham", 15, "Bánh kem", 100000, 500, "5/9/2021");
        dsHang.add("Sanh su", 14, "Chậu hoa", 200000, 53, "2/10/2021");
        dsHang.add("Dien may", 16, "Ti vi", 10000000, 20, "7/7/2021");
        dsHang.add("Thuc pham", 18, "Sầu riêng", 90000, 47, "5/11/2021");
        dsHang.add("Sanh su", 17, "Ly sứ", 4000, 73, "2/1/2021");
        dsHang.add("Dien may", 19, "Bếp ga", 500000, 20, "1/1/2021");
        dsHang.add("Thuc pham", 20, "Xúc xích", 40000, 77, "8/10/2021");
        SimpleDateFormat spDate = new SimpleDateFormat("dd/MM/yyyy");
        String continute = "0";
        do {
            System.out.println(" __________________________MENU_________________________");
            System.out.println("|>>1. Thêm hàng hoá vào cuối danh sách                 |");
            System.out.println("|>>2. Thêm hàng hoá vào đầu danh sách                  |");
            System.out.println("|>>3. Thêm hàng hoá vào trước một hàng hoá             |");
            System.out.println("|>>4. Xoá hàng hoá ở cuối danh sách                    |");
            System.out.println("|>>5. Xoá hàng hoá ở đầu danh sách                     |");
            System.out.println("|>>6. Xoá hàng hoá bất kỳ theo mã sản phẩm             |");
            System.out.println("|>>7. Sửa thông tin hàng hoá                           |");
            System.out.println("|>>8. Tìm hàng hoá theo loại                           |");
            System.out.println("|>>9. Tìm hàng hoá theo khoảng giá từ ... đến...       |");
            System.out.println("|>>10. Tìm hàng hoá theo khoảng ngày từ ... đến...     |");
            System.out.println("|>>11. Sắp xếp tăng dần theo giá                       |");
            System.out.println("|>>12. Sắp xếp giảm dần theo giá                       |");
            System.out.println("|>>13. Sắp xếp tăng dần theo ngày                      |");
            System.out.println("|>>14. Sắp xếp giảm dần theo ngày                      |");
            System.out.println("|>>15. Sắp xếp ngày tăng dần theo loại                 |");
            System.out.println("|>>16. Sắp xếp ngày giảm dần theo loại                 |");
            System.out.println("|>>17. Sắp xếp giá tăng dần theo loại                  |");
            System.out.println("|>>18. Sắp xếp giá giảm dần theo loại                  |");
            System.out.println("|>>19. Thống kê tổng số lượng hàng hoá                 |");
            System.out.println("|>>20. Thống kê tổng giá trị hàng hoá                  |");
            System.out.println("|>>21. Thống kê tổng số lượng hàng hoá của 1 loại hàng |");
            System.out.println("|>>22. In danh sách hàng hoá                           |");
            System.out.println("|>>0. Kết thúc chương trình !                          |");
            System.out.println(" _______________________________________________________");
            System.out.print("Nhập lựa chọn của bạn: ");
            int key = sc.nextInt();
            sc.nextLine();
            switch (key) {
            case 1:
                System.out.println("|>>1. Thêm hàng hoá vào cuối danh sách                 |");
                dsHang.addLast();
                break;
            case 2:
                System.out.println("|>>2. Thêm hàng hoá vào đầu danh sách                  |");
                dsHang.addFirst();
                break;
            case 3:
                System.out.println("|>>3. Thêm hàng hoá vào trước một hàng hoá             |");
                System.out.print("Nhập mã sản phẩm của hàng hoá cần thêm trước: ");
                int maSanPham = sc.nextInt();
                dsHang.addPre(maSanPham);
                sc.nextLine();
                break;
            case 4:
                System.out.println("|>>4. Xoá hàng hoá ở cuối danh sách                    |");
                dsHang.removeTail();
                System.out.println("Xoá thành công !!!!");
                break;
            case 5:
                System.out.println("|>>5. Xoá hàng hoá ở đầu danh sách                     |");
                dsHang.removeHead();
                System.out.println("Xoá thành công !!!!");
                break;
            case 6:
                System.out.println("|>>6. Xoá hàng hoá bất kỳ theo mã sản phẩm             |");
                System.out.print("Nhập mã sản phẩm của hàng hoá cần xoá: ");
                int maSP = sc.nextInt();
                dsHang.removeAny(maSP);
                sc.nextLine();
                System.out.println("Xoá thành công !!!!");
                break;
            case 7:
                System.out.println("|>>7. Sửa thông tin hàng hoá                           |");
                System.out.print("Nhập mã sản phẩm của hàng hoá cần sửa: ");
                int id = sc.nextInt();
                dsHang.edit(id);
                sc.nextLine();
                break;
            case 8:
                System.out.println("|>>8. Tìm hàng hoá theo loại                           |");
                System.out.print("Nhập loại hàng cần tìm: ");
                String type = sc.nextLine();
                dsHang.findByType(type);
                break;
            case 9:
                System.out.println("|>>9. Tìm hàng hoá theo khoảng giá từ ... đến...       |");
                System.out.print("Nhập giá min: ");
                double min = sc.nextDouble();
                System.out.print("Nhập giá max: ");
                double max = sc.nextDouble();
                dsHang.findByPrice(min, max);
                sc.nextLine();
                break;
            case 10:
                System.out.println("|>>10. Tìm hàng hoá theo khoảng ngày từ ... đến...     |");
                System.out.print("Nhập ngày bắt đầu: ");
                Date start = spDate.parse(sc.nextLine());
                System.out.print("Nhập ngày kết thúc: ");
                Date end = spDate.parse(sc.nextLine());
                dsHang.findByDate(start, end);
                break;
            case 11:
                System.out.println("|>>11. Sắp xếp tăng dần theo giá                       |");
                dsHang.sortAscendingPrice();
                System.out.println("Đã sắp xếp !");
                break;
            case 12:
                System.out.println("|>>12. Sắp xếp giảm dần theo giá                       |");
                dsHang.sortDescendingPrice();
                System.out.println("Đã sắp xếp !");
                break;
            case 13:
                System.out.println("|>>13. Sắp xếp tăng dần theo ngày                      |");
                dsHang.sortAscendingDate();
                System.out.println("Đã sắp xếp !");
                break;
            case 14:
                System.out.println("|>>14. Sắp xếp giảm dần theo ngày                      |");
                dsHang.sortDescendingDate();
                System.out.println("Đã sắp xếp !");
                break;
            case 15:
                System.out.println("|>>15. Sắp xếp ngày tăng dần theo loại                 |");
                dsHang.sortAcsendingDateByType();
                System.out.println("Đã sắp xếp !");
                break;
            case 16:
                System.out.println("|>>16. Sắp xếp ngày giảm dần theo loại                 |");
                dsHang.sortDesendingDateByType();
                System.out.println("Đã sắp xếp !");
                break;
            case 17:
                System.out.println("|>>17. Sắp xếp giá tăng dần theo loại                  |");
                dsHang.sortAcsendingPriceByType();
                System.out.println("Đã sắp xếp !");
                break;
            case 18:
                System.out.println("|>>18. Sắp xếp giá giảm dần theo loại                  |");
                dsHang.sortDesendingPriceByType();
                System.out.println("Đã sắp xếp !");
                break;
            case 19:
                System.out.println("|>>19. Thống kê tổng số lượng hàng hoá                 |");
                System.out.println("Tổng số lượng hàng hoá là: " + dsHang.totalGoods());
                break;
            case 20:
                System.out.println("|>>20. Thống kê tổng giá trị hàng hoá                  |");
                System.out.printf("Tổng giá trị hàng hoá là: %.2f\n", dsHang.totalValue());
                break;
            case 21:
                System.out.println("|>>21. Thống kê tổng số lượng hàng hoá của 1 loại hàng |");
                System.out.print("Nhập loại hàng hoá cần thống kê số lượng: ");
                String hang = sc.nextLine();
                System.out.println("Tổng hàng hoá loại " + hang + " là: " + dsHang.numberGoods(hang));
                break;
            case 22:
                System.out.println("|>>22. In danh sách hàng hoá                           |");
                dsHang.display();
                break;
            case 0:
                System.out.println("Hẹn gặp lại!!!");
                System.exit(0);
            default:
                System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!!!");
                break;
            }
            System.out.print("Nhập y để quay về menu nhập n để kết thúc: ");
            continute = sc.nextLine();
        } while (continute.equalsIgnoreCase("y"));
        sc.close();
    }
}
