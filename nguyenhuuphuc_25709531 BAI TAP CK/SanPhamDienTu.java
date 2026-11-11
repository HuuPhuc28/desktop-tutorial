package nguyenhuuphuc_25709531;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham {
private double thoiGianBaoHanh;

public SanPhamDienTu(String masp, String tensp, int soluongtonkho, LocalDate ngaysanxuat, double gianhap,
		double thoiGianBaoHanh) {
	super(masp, tensp, soluongtonkho, ngaysanxuat, gianhap);
	this.thoiGianBaoHanh = thoiGianBaoHanh;
}

 SanPhamDienTu(String string, String string2, int i, int j, boolean b) {
	// TODO Auto-generated constructor stub
}

public double getThoiGianBaoHanh() {
	return thoiGianBaoHanh;
}

public void setThoiGianBaoHanh(double thoiGianBaoHanh) {
	this.thoiGianBaoHanh = thoiGianBaoHanh;
}


@Override
double tinhGiaBan() {
	// TODO Auto-generated method stub
	return gianhap + (gianhap * 0.1)+ (thoiGianBaoHanh * 5000);
}

@Override
public String toString() {
	return "SanPhamDienTu [thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
}

}
