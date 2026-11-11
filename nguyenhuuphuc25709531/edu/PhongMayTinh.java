package nguyenlecongnguyen25718721.edu;

public class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh() {
        super();
        this.soMayTinh = 0;
    }

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setSoMayTinh(soMayTinh);
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        if (soMayTinh <= 0) {
            throw new IllegalArgumentException("Số máy tính phải lớn hơn 0!");
        }
        this.soMayTinh = soMayTinh;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && (this.dienTich / this.soMayTinh <= 1.5);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-35s |", 
                "Số máy tính: " + soMayTinh);
    }
}