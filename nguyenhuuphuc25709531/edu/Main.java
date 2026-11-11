package nguyenlecongnguyen25718721.edu;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void inTieuDe() {
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
        System.out.printf("| %-10s | %-10s | %10s | %12s | %-12s | %-35s |\n",
                "Mã Phòng", "Dãy Nhà", "Diện Tích", "Số Bóng Đèn", "Đánh Giá", "Thông Tin Riêng");
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
    }

    public static void hienThiDanhSach(List<PhongHoc> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        inTieuDe();
        for (PhongHoc ph : ds) {
            System.out.println(ph);
        }
        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
    }

    public static void nhapDuLieuMau(ListPhongHoc ql) {
        ql.themPhongHoc(new PhongLyThuyet("A101", "Nhà A", 100, 10, true));
        ql.themPhongHoc(new PhongLyThuyet("B202", "Nhà B", 80, 6, true));
        ql.themPhongHoc(new PhongMayTinh("H501", "Nhà H", 90, 10, 60));
        ql.themPhongHoc(new PhongMayTinh("H502", "Nhà H", 60, 6, 45));
        ql.themPhongHoc(new PhongThiNghiem("F301", "Nhà F", 120, 12, "Hóa Học", 50, true));
        ql.themPhongHoc(new PhongThiNghiem("C102", "Nhà C", 90, 9, "Sinh Học", 40, false));
    }

    public static PhongHoc nhapPhongHocMoi() {
        System.out.println("Chọn loại phòng: 1. Phòng Lý Thuyết | 2. Phòng Máy Tính | 3. Phòng Thí Nghiệm");
        System.out.print("Lựa chọn: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập mã phòng: ");
        String ma = sc.nextLine();
        System.out.print("Nhập dãy nhà: ");
        String dayNha = sc.nextLine();
        System.out.print("Nhập diện tích (m2): ");
        double dienTich = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số bóng đèn: ");
        int soBongDen = Integer.parseInt(sc.nextLine());

        switch (loai) {
            case 1:
                System.out.print("Có máy chiếu không (true/false): ");
                boolean coMayChieu = Boolean.parseBoolean(sc.nextLine());
                return new PhongLyThuyet(ma, dayNha, dienTich, soBongDen, coMayChieu);
            case 2:
                System.out.print("Nhập số lượng máy tính: ");
                int soMay = Integer.parseInt(sc.nextLine());
                return new PhongMayTinh(ma, dayNha, dienTich, soBongDen, soMay);
            case 3:
                System.out.print("Nhập chuyên ngành: ");
                String chuyenNganh = sc.nextLine();
                System.out.print("Nhập sức chứa: ");
                int sucChua = Integer.parseInt(sc.nextLine());
                System.out.print("Có bồn rửa không (true/false): ");
                boolean coBonRua = Boolean.parseBoolean(sc.nextLine());
                return new PhongThiNghiem(ma, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
            default:
                System.out.println("Loại phòng không hợp lệ!");
                return null;
        }
    }

    public static void main(String[] args) {
        ListPhongHoc ql = new ListPhongHoc();
        nhapDuLieuMau(ql);

        int chon;
        do {
            System.out.println("\n================ MENU QUẢN LÝ PHÒNG HỌC ================");
            System.out.println("1. Thêm một phòng học mới");
            System.out.println("2. Tìm kiếm phòng học theo mã phòng");
            System.out.println("3. Hiển thị toàn bộ danh sách phòng học");
            System.out.println("4. Hiển thị các phòng học đạt chuẩn");
            System.out.println("5. Sắp xếp danh sách tăng dần theo dãy nhà");
            System.out.println("6. Sắp xếp danh sách giảm dần theo diện tích");
            System.out.println("7. Sắp xếp danh sách tăng dần theo số bóng đèn");
            System.out.println("8. Cập nhật số máy tính theo mã phòng");
            System.out.println("9. Xóa một phòng học theo mã phòng");
            System.out.println("10. Tính tổng số phòng học");
            System.out.println("11. Hiển thị các phòng máy có 60 máy");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    try {
                        PhongHoc phMoi = nhapPhongHocMoi();
                        if (phMoi != null) {
                            if (ql.themPhongHoc(phMoi)) {
                                System.out.println("-> Thêm phòng học thành công!");
                            } else {
                                System.out.println("-> Thêm thất bại: Trùng mã phòng!");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("-> Lỗi dữ liệu: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maTim = sc.nextLine();
                    PhongHoc kqTim = ql.timPhongHoc(maTim);
                    if (kqTim != null) {
                        inTieuDe();
                        System.out.println(kqTim);
                        System.out.println("+------------+------------+------------+--------------+--------------+-------------------------------------+");
                    } else {
                        System.out.println("-> Không tìm thấy phòng có mã: " + maTim);
                    }
                    break;

                case 3:
                    System.out.println("DANH SÁCH TOÀN BỘ PHÒNG HỌC:");
                    hienThiDanhSach(ql.layToanBoDanhSach());
                    break;

                case 4:
                    System.out.println("DANH SÁCH CÁC PHÒNG HỌC ĐẠT CHUẨN:");
                    hienThiDanhSach(ql.layDanhSachPhongDatChuan());
                    break;

                case 5:
                    ql.sapXepTangDanTheoDayNha();
                    System.out.println("-> Đã sắp xếp tăng dần theo dãy nhà:");
                    hienThiDanhSach(ql.layToanBoDanhSach());
                    break;

                case 6:
                    ql.sapXepGiamDanTheoDienTich();
                    System.out.println("-> Đã sắp xếp giảm dần theo diện tích:");
                    hienThiDanhSach(ql.layToanBoDanhSach());
                    break;

                case 7:
                    ql.sapXepTangDanTheoSoBongDen();
                    System.out.println("-> Đã sắp xếp tăng dần theo số bóng đèn:");
                    hienThiDanhSach(ql.layToanBoDanhSach());
                    break;

                case 8:
                    System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    System.out.print("Nhập số lượng máy tính mới: ");
                    try {
                        int soMayMoi = Integer.parseInt(sc.nextLine());
                        if (ql.capNhatSoMayTinh(maCapNhat, soMayMoi)) {
                            System.out.println("-> Cập nhật số máy tính thành công!");
                        } else {
                            System.out.println("-> Không tìm thấy phòng máy tính có mã: " + maCapNhat);
                        }
                    } catch (Exception e) {
                        System.out.println("-> Lỗi: " + e.getMessage());
                    }
                    break;

                case 9:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maXoa = sc.nextLine();
                    PhongHoc phXoa = ql.timPhongHoc(maXoa);
                    if (phXoa == null) {
                        System.out.println("-> Không tìm thấy phòng có mã: " + maXoa);
                    } else {
                        System.out.print("Bạn có chắc chắn muốn xóa phòng " + maXoa + " không? (Y/N): ");
                        String xacNhan = sc.nextLine();
                        if (xacNhan.equalsIgnoreCase("Y")) {
                            ql.xoaPhongHoc(maXoa);
                            System.out.println("-> Đã xóa phòng học thành công!");
                        } else {
                            System.out.println("-> Đã hủy thao tác xóa.");
                        }
                    }
                    break;

                case 10:
                    System.out.println("-> Tổng số phòng học hiện có: " + ql.tinhTongSoPhongHoc());
                    break;

                case 11:
                    System.out.println("DANH SÁCH CÁC PHÒNG MÁY CÓ 60 MÁY:");
                    hienThiDanhSach(ql.layDanhSachPhongMay60May());
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 0);
    }
}