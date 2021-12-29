package com.trungbq2004110026.tieuluancuoiky;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class HangHoa {

    Node head = null;
    Node tail = null;

    Scanner sc = new Scanner(System.in);

    void checkID(Node hangHoa){
        while(find(hangHoa.maHang) != null){
            System.out.print("Mã hàng hoá bị trùng vui lòng nhập lại:");
            hangHoa.maHang = sc.nextInt();
        }  
    }

    void addFirst() throws ParseException { // Hàm thêm vào đầu
        Node hangHoa = new Node();
        hangHoa.nhapThongTin();
        checkID(hangHoa);
        if (head == null) {
            head = hangHoa;
            tail = hangHoa;
        } else {
            hangHoa.next = head;
            head = hangHoa;
        }
    }

    void addLast() throws ParseException { // Hàm thêm vào cuối
        Node hangHoa = new Node();
        hangHoa.nhapThongTin();  
        checkID(hangHoa);
        if (head == null) {
            head = hangHoa;
            tail = hangHoa;
        } else {
            tail.next = hangHoa;
            tail = hangHoa;
        }
    }

    void add(String loai, int maHang, String tenHangHoa, double giaNhap, int soLuongTonKho, String inPutDate)
            throws ParseException {
        // Hàm thêm có sẵn
        Node hangHoa = new Node(loai, maHang, tenHangHoa, giaNhap, soLuongTonKho, inPutDate);
        if (head == null) {
            head = hangHoa;
            tail = hangHoa;
        } else {
            tail.next = hangHoa;
            tail = hangHoa;
        }
    }

    void addPre(int maSanPham) throws ParseException { // Thêm trước một mã hàng bất kỳ
        Node hangHoa = new Node();
        Node temp = findPre(maSanPham);
        if (head.maHang == maSanPham) {
            addFirst();
            return;
        }
        if (temp != null) {
            hangHoa.nhapThongTin();
            checkID(hangHoa);
            hangHoa.next = temp.next;
            temp.next = hangHoa;
        } else
            System.out.println("Không tìm thấy mã hàng!");
    }

    Node findPre(int maSanPham) { // Hàm tìm kiếm một phần tử có trong linkedlist không và trả về node trước nó
        Node current = head;
        while (current != null) {
            if (maSanPham == current.next.maHang)
                return current;
            current = current.next;
        }
        return null;
    }

    Node find(int id) {// Hàm tìm kiếm theo mã hãng và trả về node nếu tìm thấy và trả về null nếu
                       // không tìm thấy
        Node current = head;
        while (current != null) {
            if (current.maHang == id)
                return current;
            current = current.next;
        }
        return null;
    }

    void findByType(String type) { // Tìm theo loại và in thông tin hàng hoá
        Node current = head;
        int i = 0;
        while (current != null) {
            if (type.equalsIgnoreCase(current.loai)) {
                current.inThongTin();
                i++;
            }
            current = current.next;
        }
        if (i == 0)
            System.out.println("Không tìm thấy hàng hoá !!!");
    }

    void findByPrice(double min, double max) { // Tìm kiếm theo khoảng giá và in ra
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.giaNhap <= max && current.giaNhap >= min) {
                current.inThongTin();
                i++;
            }
            current = current.next;
        }
        if (i == 0)
            System.out.println("Không tìm thấy hàng hoá !!!");
    }

    void findByDate(Date start, Date end) { // Tìm kiếm theo khoảng ngày và in thông tin
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.ngayNhapKho.compareTo(start) > 0 && current.ngayNhapKho.compareTo(end) < 0) {
                current.inThongTin();
                i++;
            }
            current = current.next;
        }
        if (i == 0)
            System.out.println("Không tìm thấy hàng hoá !!!");
    }

    void removeHead() { // Hàm xoá hàng hoá đầu tiên
        if (head == null) {
            return;
        }
        head = head.next;
    }

    void removeTail() { // Hàm xoá hàng hoá cuối cùng
        Node current = head;
        if (head.next == null) {
            removeHead();
            return;
        }
        while (current != null) {
            if (current.next == tail) {
                tail = current;
                current.next = null;
                return;
            }
            current = current.next;
        }
    }

    void removeAny(int maSanPham) { // Hàm xoá hàng hoá bất kỳ
        Node temp = find(maSanPham);
        if (temp == null) {
            System.out.println("Không tìm thấy hàng hoá !");
        } else if (head.maHang == maSanPham) {
            removeHead();
            System.out.println("Xoá thành công !!!!");
        } else if (tail.maHang == maSanPham) {
            {
                removeTail();
                System.out.println("Xoá thành công !!!!");
            }
        } else {
            temp.next = temp.next.next;
        }

    }

    void edit(int id) throws ParseException { // Hàm sửa thông tin hàng hoá
        Node current = find(id);
        if (current != null) {
            current.suaThongTin();
        } else
            System.out.println("Không tìm thấy thông tin để sửa !");
    }

    void display() { // Hàm hiển thị danh sách hàng hoá
        Node current = head;
        if (head == null) {
            System.out.println("DANH SÁCH RỖNG!");
        } else {
            while (current != null) {
                current.inThongTin();
                current = current.next;
            }
        }
    }

    void swap(String temp1, int temp2, double temp3, Date temp4, Node current, Node index) { // Hàm đổi chỗ
        // Đổi chỗ loại hàng
        temp1 = current.loai;
        current.loai = index.loai;
        index.loai = temp1;
        // Đổi chỗ mã hàng
        temp2 = current.maHang;
        current.maHang = index.maHang;
        index.maHang = temp2;
        // Đổi chỗ tên hàng
        temp1 = current.tenHangHoa;
        current.tenHangHoa = index.tenHangHoa;
        index.tenHangHoa = temp1;
        // Đổi chỗ giá nhập
        temp3 = current.giaNhap;
        current.giaNhap = index.giaNhap;
        index.giaNhap = temp3;
        // Đổi chỗ số lượng tồn kho
        temp2 = current.soLuongTonKho;
        current.soLuongTonKho = index.soLuongTonKho;
        index.soLuongTonKho = temp2;
        // Đổi chỗ ngày nhập khó
        temp4 = current.ngayNhapKho;
        current.ngayNhapKho = index.ngayNhapKho;
        index.ngayNhapKho = temp4;
    }

    void sortAscendingPrice() { // Sắp xếp tăng dần theo giá nhập
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (index.giaNhap < current.giaNhap)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortDescendingPrice() { // Sắp xếp giảm dần theo giá nhập
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (index.giaNhap > current.giaNhap)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortAscendingDate() { // Sắp xếp tăng dần theo ngày
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (index.ngayNhapKho.compareTo(current.ngayNhapKho) < 0)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortDescendingDate() { // Sắp xếp giảm dần theo ngày
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (index.ngayNhapKho.compareTo(current.ngayNhapKho) > 0)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortType() { // Sắp xếp các loại hàng theo thứ tự bảng chữ cái
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.loai.compareToIgnoreCase(index.loai) > 0)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortAcsendingDateByType() { // Sắp xếp ngày tăng dần theo loại
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        sortType();
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (index.ngayNhapKho.compareTo(current.ngayNhapKho) < 0)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortDesendingDateByType() {// Sắp xếp ngày giảm dần theo loại
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        sortType();
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (index.ngayNhapKho.compareTo(current.ngayNhapKho) > 0)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortAcsendingPriceByType() { // Sắp xếp tăng dần giá theo loại
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        sortType();
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (index.giaNhap > current.giaNhap)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    void sortDesendingPriceByType() {// Sắp xếp giảm dần giá theo loại
        Node current = head;
        Node index;
        String temp1 = null;
        int temp2 = 0;
        double temp3 = 0;
        Date temp4 = null;
        sortType();
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (index.giaNhap > current.giaNhap)
                    swap(temp1, temp2, temp3, temp4, current, index);
                index = index.next;
            }
            current = current.next;
        }
    }

    int totalGoods() { // Tổng số lượng hàng hoá
        Node current = head;
        int count = 0;
        while (current != null) {
            count += current.soLuongTonKho;
            current = current.next;
        }
        return count;
    }

    double totalValue() {// Hàm tính tổng giá trị nhập của hàng hoá
        Node current = head;
        double value = 0;
        while (current != null) {
            value += current.giaNhap * current.soLuongTonKho;
            current = current.next;
        }
        return value;
    }

    int numberGoods(String hang) {
        Node current = head;
        int numbers = 0;
        while (current != null) {
            if (current.loai.equalsIgnoreCase(hang))
                numbers += current.soLuongTonKho;
            current = current.next;
        }
        return numbers;
    }

}