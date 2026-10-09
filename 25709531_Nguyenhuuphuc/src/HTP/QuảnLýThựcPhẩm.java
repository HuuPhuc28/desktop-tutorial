package HTP;

import java.time.LocalDate;

public class QuanLyThucPham {
   
    private HangThucPham[] danhSach;   
    private int soLuong;               
    private int khaNang;               

    private static final int KICH_THUOC_BAN_DAU = 5;

   
    public QuanLyThucPham() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0;
    }

  
    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        HangThucPham[] mangMoi = new HangThucPham[kichThuocMoi];
        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }
        danhSach = mangMoi;
        khaNang = kichThuocMoi;
        System.out.println("✅ Đã mở rộng mảng lên " + khaNang + " phần tử.");
    }

   
    public int timViTriTheoMa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang))
                return i;
        }
        return -1;
    }

   
    public int timViTriTheoId(int id) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getId() == id) return i;
        }
        return -1;
    }

    
    public boolean them(HangThucPham h) {
        if (timViTriTheoMa(h.getMaHang()) != -1) {
            System.out.println("x Lỗi: Mã hàng '" + h.getMaHang() + "' đã tồn tại!");
            return false;
        }
        if (soLuong == khaNang) moRongMang();
        danhSach[soLuong] = h;
        soLuong++;
        return true;
    }

   
    public boolean xoa(int id) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("x Không tìm thấy hàng có id " + id);
            return false;
        }
        for (int i = viTri; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }
        danhSach[soLuong - 1] = null;
        soLuong--;
        return true;
    }

    
    public boolean sua(int id, String tenMoi, LocalDate ngaySXMoi, LocalDate ngayHHMoi, float giaMoi) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("x Không tìm thấy hàng có id " + id);
            return false;
        }
        HangThucPham h = danhSach[viTri];
        h.setTenHang(tenMoi);
        h.setNgaySanXuat(ngaySXMoi);
        h.setNgayHetHan(ngayHHMoi);
        h.setGia(giaMoi);
        return true;
    }
    
    
    public void inDanhSach() {
        System.out.println("--- DANH SÁCH HÀNG THỰC PHẨM (" + soLuong + "/" + khaNang + ") ---");
        for (int i = 0; i < soLuong; i++) {
            HangThucPham h = danhSach[i];
            System.out.printf("ID: %d | Mã: %s | Tên: %s | Giá: %.0f\n", 
                    h.getId(), h.getMaHang(), h.getTenHang(), h.getGia());
        }
    }
}
