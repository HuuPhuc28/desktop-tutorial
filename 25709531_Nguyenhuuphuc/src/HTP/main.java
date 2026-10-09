package HTP;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KẾT QUẢ CHẠY THỬ NGHIỆM LỚP HÀNG THỰC PHẨM ===");
        
        System.out.println("\n1. Tạo mặt hàng bằng Constructor mặc định:");
        HangThucPham h1 = new HangThucPham();
        inThongTin(h1);
        
        System.out.println("\n2. Tạo mặt hàng bằng Constructor có tham số (Hợp lệ):");
        HangThucPham h2 = new HangThucPham("TP001", "Gạo lúa thơm ST25", LocalDate.of(2023, 5, 10), LocalDate.of(2024, 5, 10), 150000);
        inThongTin(h2);
        
        System.out.println("\n3. Kiểm tra các điều kiện báo lỗi (Ví dụ: Nhập giá âm):");
        try {
            HangThucPham h3 = new HangThucPham("TP002", "Bánh kẹo", LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), -5000);
        } catch (Exception e) {
            System.out.println("-> Đã chặn được lỗi: " + e.getMessage());
        }
        
        System.out.println("\n4. Kiểm tra các điều kiện báo lỗi (Ví dụ: Ngày hết hạn trước ngày sản xuất):");
        try {
            HangThucPham h4 = new HangThucPham("TP003", "Sữa tươi", LocalDate.of(2024, 1, 1), LocalDate.of(2023, 1, 1), 30000);
        } catch (Exception e) {
            System.out.println("-> Đã chặn được lỗi: " + e.getMessage());
        }
    }
    
    // Hàm phụ trợ để in thông tin ra màn hình cho gọn
    public static void inThongTin(HangThucPham h) {
        System.out.println("- Mã hàng: " + h.getMaHang());
        System.out.println("- Tên hàng: " + h.getTenHang());
        System.out.println("- Ngày SX: " + h.getNgaySanXuat());
        System.out.println("- Ngày HH: " + h.getNgayHetHan());
        System.out.println("- Giá: " + h.getGia() + " VNĐ");
    }
}