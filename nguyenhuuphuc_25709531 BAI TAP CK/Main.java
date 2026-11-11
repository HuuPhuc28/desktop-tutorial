package nguyenhuuphuc_25709531;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void inTieuDe() {
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
        System.out.printf("| %-10s | %-10s | %10s | %12s | %-12s | %-35s |\n",
                "Mã Sản Phẩm", ", Tên Sản Phẩm", "Ngày Sản Xuất", "Giá Nhập", "Số Lượng Tồn Kho");
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
    }

    public static void hienThiDanhSach(List<SanPham> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        inTieuDe();
        for (SanPham ph : ds) {
            System.out.println(ph);
        }
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
    }
 static void nhapDuLieuMau(QuanLySanPham ql) {
	 ql.themSanPham(new)
}
    public static void main(String[]args) {
    	QuanLySanPham ql = new QuanLySanPham();
    	nhapDuLieuMau(ql);
 ql.xuatSanPhamTheoLoai("Dien Tu");
 ql.xuatSanPhamTheoLoai("ThucPham");
 ql.xuatSanPhamGiaBanCaoNhat();
 ql.suaSoLuongTon("SP01",50);
 ql.xoaSanPham("SP02");
    }

   
}