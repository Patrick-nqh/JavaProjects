package model;

public class Phong {
    private int maPhong;
    private String tenPhong;
    private LoaiPhong loaiPhong;
    private int dienTich;
    private int giaThue;

    public Phong() {
    }

    public Phong(int maPhong) {
        this.maPhong = maPhong;
    }

    public Phong(int maPhong, String tenPhong, LoaiPhong loaiPhong, int dienTich, int giaThue) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
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

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
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
}

