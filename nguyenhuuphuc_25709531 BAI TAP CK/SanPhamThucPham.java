package nguyenhuuphuc_25709531;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {
protected double ngayHetHan;

public SanPhamThucPham(String masp, String tensp, int soluongtonkho, LocalDate ngaysanxuat, double gianhap,
		double ngayHetHan) {
	super(masp, tensp, soluongtonkho, ngaysanxuat, gianhap);
	this.ngayHetHan = ngayHetHan;
}

public double getNgayHetHan() {
	return ngayHetHan;
}

public void setNgayHetHan(double ngayHetHan) {
	this.ngayHetHan = ngayHetHan;
}

@Override
public String toString() {
	return "SanPhamThucPham [ngayHetHan=" + ngayHetHan + "]";
}

@Override
double tinhGiaBan() {
	// TODO Auto-generated method stub
	return 0;
}


}
