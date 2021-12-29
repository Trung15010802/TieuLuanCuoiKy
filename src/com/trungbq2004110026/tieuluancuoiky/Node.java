package com.trungbq2004110026.tieuluancuoiky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Node {
    String loai;
    int maHang;
    String tenHangHoa;
    double giaNhap;
    int soLuongTonKho;
    SimpleDateFormat spDate = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhapKho;

    Node next;

    Scanner sc = new Scanner(System.in);

    public Node() {
    }

    public Node(String loai, int maHang, String tenHangHoa, double giaNhap, int soLuongTonKho, String inPutDate)
            throws ParseException {
        this.loai = loai;
        this.maHang = maHang;
        this.tenHangHoa = tenHangHoa;
        this.giaNhap = giaNhap;
        this.soLuongTonKho = soLuongTonKho;
        ngayNhapKho = spDate.parse(inPutDate);

    }

    void nhapThongTin() throws ParseException {
        System.out.println("--------------------------------------------");
        System.out.print("Nhập loại hàng hoá: ");
        loai = sc.nextLine();
        System.out.print("Nhập mã hàng hoá: ");
        maHang = sc.nextInt();
        System.out.print("Nhập tên hàng hoá: ");
        sc.nextLine();
        tenHangHoa = sc.nextLine();
        System.out.print("Nhập giá nhập: ");
        giaNhap = sc.nextDouble();
        System.out.print("Số lượng hàng tồn kho: ");
        soLuongTonKho = sc.nextInt();
        System.out.print("Nhập ngày nhập kho: ");
        sc.nextLine();
        ngayNhapKho = spDate.parse(sc.nextLine());
        System.out.println("--------------------------------------------");
    }

    void suaThongTin() throws ParseException {
        System.out.println("--------------------------------------------");
        System.out.print("Nhập loại hàng hoá: ");
        loai = sc.nextLine();
        System.out.print("Nhập tên hàng hoá: ");
        tenHangHoa = sc.nextLine();
        System.out.print("Nhập giá nhập: ");
        giaNhap = sc.nextDouble();
        System.out.print("Số lượng hàng tồn kho: ");
        soLuongTonKho = sc.nextInt();
        System.out.print("Nhập ngày nhập kho: ");
        sc.nextLine();
        ngayNhapKho = spDate.parse(sc.nextLine());
        System.out.println("--------------------------------------------");
    }

    void inThongTin() {
        System.out.println("____________________________________________");
        System.out.println("Loại hàng hoá: " + loai);
        System.out.println("Mã hàng hoá: " + maHang);
        System.out.println("Tên hàng hoá: " + tenHangHoa);
        System.out.printf("Giá nhập: %.2f đồng\n", giaNhap);
        System.out.println("Số lượng hàng tồn kho: " + soLuongTonKho);
        System.out.println("Ngày nhập kho: " + spDate.format(ngayNhapKho));
        System.out.println("____________________________________________");
    }

}
