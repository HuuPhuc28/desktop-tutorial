package nguyenhuuphuc_25709531;

import java.time.LocalDate;

public abstract class SanPham {
protected String masp,tensp;
protected int soluongtonkho;
protected LocalDate ngaysanxuat;
protected double gianhap;
public SanPham(String masp, String tensp, int soluongtonkho, LocalDate ngaysanxuat, double gianhap) {
	super();
	this.masp = masp;
	this.tensp = tensp;
	this.soluongtonkho = soluongtonkho;
	this.ngaysanxuat = ngaysanxuat;
	this.gianhap = gianhap;
}
public SanPham() {
	super();
}
public String getMasp() {
	return masp;
}
public void setMasp(String masp) {
	this.masp = masp;
}
public String getTensp() {
	return tensp;
}
public void setTensp(String tensp) {
	this.tensp = tensp;
}
public int getSoluongtonkho() {
	return soluongtonkho;
}
public void setSoluongtonkho(int soluongtonkho) {
	this.soluongtonkho = soluongtonkho;
}
public LocalDate getNgaysanxuat() {
	return ngaysanxuat;
}
public void setNgaysanxuat(LocalDate ngaysanxuat) {
	this.ngaysanxuat = ngaysanxuat;
}
public double getGianhap() {
	return gianhap;
}
public void setGianhap(double gianhap) {
	this.gianhap = gianhap;
}
abstract double tinhGiaBan();
@Override
public String toString() {
	return "SanPham [masp=" + masp + ", tensp=" + tensp + ", soluongtonkho=" + soluongtonkho + ", ngaysanxuat="
			+ ngaysanxuat + ", gianhap=" + gianhap + "]";
}

}
