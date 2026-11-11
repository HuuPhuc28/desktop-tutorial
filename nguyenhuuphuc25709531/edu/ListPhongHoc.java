package nguyenlecongnguyen25718721.edu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListPhongHoc {
    private List<PhongHoc> ls;

    public ListPhongHoc() {
        this.ls = new ArrayList<>();
    }

    public boolean themPhongHoc(PhongHoc ph) {
        if (ph == null || ls.contains(ph)) {
            return false;
        }
        return ls.add(ph);
    }

    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc ph : ls) {
            if (ph.getMaPhong().equalsIgnoreCase(maPhong)) {
                return ph;
            }
        }
        return null;
    }

    public List<PhongHoc> layToanBoDanhSach() {
        return new ArrayList<>(ls);
    }

    public List<PhongHoc> layDanhSachPhongDatChuan() {
        List<PhongHoc> ketQua = new ArrayList<>();
        for (PhongHoc ph : ls) {
            if (ph.datChuan()) {
                ketQua.add(ph);
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

    public boolean xoaPhongHoc(String maPhong) {
        PhongHoc ph = timPhongHoc(maPhong);
        if (ph != null) {
            return ls.remove(ph);
        }
        return false;
    }

    public int tinhTongSoPhongHoc() {
        return ls.size();
    }

    public List<PhongHoc> layDanhSachPhongMay60May() {
        List<PhongHoc> ketQua = new ArrayList<>();
        for (PhongHoc ph : ls) {
            if (ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoMayTinh() == 60) {
                ketQua.add(ph);
            }
        }
        return ketQua;
    }
}