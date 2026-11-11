package nguyenhuuphuc_25709531;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSanPham{
    private List<SanPham> ls;

    public ListSanPham() {
        this.ls = new ArrayList<>();
    }

    public boolean themSanPham(SanPham ph) {
        if (ph == null || ls.contains(ph)) {
            return false;
        }
        return ls.add(ph);
    }

    public SanPham timSanPham(String maSanPham) {
        for (SanPham sp : ls) {

			if (sp.getMaSanPham().equalsIgnoreCase(maSanPham)) {
                return sp;
            }
        }
        return null;
    }

    public List<SanPham>> ArrayList layToanBoDanhSach() {
        return new ArrayList<>(ls);
    }

    public List<SanPham> layDanhSachSanPhamTinhGiaBan() {
        List<SanPham> ketQua = new ArrayList<>();
        for (SanPham sp : ls) {
            if (sp.tinhGiaBan()) {
                ketQua.add(sp);
            }
        }
        return ketQua;
    }

    public void sapXepTangDanTheoDayNha() {
        ls.sort(Comparator.comparing(PhongHoc::getDayNha, String.CASE_INSENSITIVE_ORDER));
    }

    public void sapXepGiamDanTheoDienTich() {
        ls.sort(Comparator.comparingDouble(PhongHoc::getDienTich).reversed());
    }

    public void sapXepTangDanTheoSoBongDen() {
        ls.sort(Comparator.comparingInt(PhongHoc::getSoBongDen));
    }

    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        PhongHoc ph = timPhongHoc(maPhong);
        if (ph instanceof PhongMayTinh) {
            ((PhongMayTinh) ph).setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    public boolean xoaPhongHoc(String maSanPham) {
SanPham sp = timPhongHoc(maSanPham);
        if (sp != null) {
            return ls.remove(sp);
        }
        return false;
    }

    public int tinhTongSoSanPham() {
        return ls.size();
    }

    public List<SanPham> layDanhSachThucPham() {
        List<SanPham> ketQua = new ArrayList<>();
        for (SanPham sp : ls) {
            if (sp instanceof SanPhamThucPham && ((SanPhamThucPham) ph).getSoThucPham()) {
                ketQua.add(ph);
            }
        }
        return ketQua;
    }
}