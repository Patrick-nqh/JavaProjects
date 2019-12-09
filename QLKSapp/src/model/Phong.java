package model;

public class Phong extends LoaiPhong{
    private int maPhong;
    private LoaiPhong loaiPhong;
    private int dienTich;
    private int giaThue;
    private String trangThai = "dang trong";

    public Phong() {
    }

    public Phong(int maPhong) {
        this.maPhong = maPhong;
    }

    public Phong(String trangThai) {
        this.trangThai = trangThai;
    }

    public Phong(int maPhong, LoaiPhong loaiPhong, int dienTich, int giaThue) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.dienTich = dienTich;
        this.giaThue = giaThue;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }



    @Override
    public String toString() {
        return "Phong{" +
                "maPhong=" + maPhong +
                ", maLoaiPhong=" + loaiPhong.getMaLoai() +
                ", dienTich=" + dienTich +
                ", giaThue=" + giaThue +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}

