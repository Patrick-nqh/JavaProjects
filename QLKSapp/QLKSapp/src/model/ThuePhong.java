package model;

import java.util.Date;

public class ThuePhong {
    private int maThue ;
    private static int id = 200;
    private KhachHang khachHang;
    private Phong phong;
    private Date ngayVao;
    private Date ngayRa;
    private int datCoc;

    public ThuePhong() {
    }

    public ThuePhong(int maThue) {
        this.maThue = maThue;
    }

    public ThuePhong(int maThue, KhachHang khachHang, Phong phong
            , Date ngayVao, Date ngayRa, int datCoc) {
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.datCoc = datCoc;
       if (maThue == 0){
           this.maThue = id++;
       }else {
           this.maThue = maThue;
       }
    }

    public ThuePhong(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }

    public Date getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(Date ngayRa) {
        this.ngayRa = ngayRa;
    }

    public int getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(int datCoc) {
        this.datCoc = datCoc;
    }

    @Override
    public String toString() {
        return "ThuePhong{" +
                "maThue=" + maThue +
                ", maKhachHang=" + khachHang.getMaKH() +
                ", maPhong=" + phong.getMaPhong() +
                ", ngayVao=" + ngayVao +
                ", ngayRa=" + ngayRa +
                ", datCoc=" + datCoc +
                '}';
    }
}
