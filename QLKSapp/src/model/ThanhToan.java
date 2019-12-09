package model;

import java.util.Date;

public class ThanhToan {
    private int thanhTien;
    private String hinhThucThanhToan;
    private String ghiChu;
    private Date ngayThanhToan;
    private ThuePhong thuePhong;

    public ThanhToan() {
    }

    public ThanhToan(ThuePhong thuePhong
            ,int thanhTien, String hinhThucThanhToan
            , String ghiChu, Date ngayThanhToan) {
        this.thanhTien = thanhTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
        this.ngayThanhToan = ngayThanhToan;
        this.thuePhong = thuePhong;
    }

    public ThuePhong getThuePhong() {
        return thuePhong;
    }

    public void setThuePhong(ThuePhong thuePhong) {
        this.thuePhong = thuePhong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    @Override
    public String toString() {
        return "ThanhToan{" +
                "Ten khach hang"+ thuePhong.getKhachHang().getTenKH()+
                "thanhTien=" + thanhTien +
                ", hinhThucThanhToan='" + hinhThucThanhToan + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", ngayThanhToan=" + ngayThanhToan +
                ", thuePhong=" + thuePhong +
                '}';
    }
}
