package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThuePhong {
    public static int id = 200;
    private int maThue ;
    private KhachHang khachHang;
    private Phong phong;
    private String ngayVao;
    private String ngayRa;
    private int datCoc;

    public ThuePhong() {
    }

    public ThuePhong(int maThue) {
        this.maThue = maThue;
    }



    public ThuePhong(int maThue, KhachHang khachHang, Phong phong
            , String ngayVao, String ngayRa, int datCoc) {
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

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public int getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(int datCoc) {
        this.datCoc = datCoc;
    }

    SimpleDateFormat time = new SimpleDateFormat("YYYY-MM-dd");
    @Override
    public String toString() {
        return "ThuePhong{" +
                "maThue=" + maThue +
                ", maKhachHang=" + khachHang.getMaKH() +
                ", maPhong=" + phong.getMaPhong() +
                ", ngayVao=" + ngayVao +//test thu
                ", ngayRa=" + ngayRa +
                ", datCoc=" + datCoc +
                '}';
    }
}
