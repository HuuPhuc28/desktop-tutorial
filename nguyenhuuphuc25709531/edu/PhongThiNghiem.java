package nguyenlecongnguyen25718721.edu;

public class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem() {
        super();
        this.chuyenNganh = "";
        this.sucChua = 0;
        this.coBonRua = false;
    }

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen,
                          String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setChuyenNganh(chuyenNganh);
        setSucChua(sucChua);
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        if (chuyenNganh == null || chuyenNganh.trim().isEmpty()) {
            throw new IllegalArgumentException("Chuyên ngành không được rỗng!");
        }
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Sức chứa phải lớn hơn 0!");
        }
        this.sucChua = sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coBonRua;
    }

    @Override
    public String toString() {
        String info = String.format("CN: %s, SC: %d, Bồn rửa: %s",
                chuyenNganh, sucChua, coBonRua ? "Có" : "Không");
        return super.toString() + String.format(" %-35s |", info);
    }
}