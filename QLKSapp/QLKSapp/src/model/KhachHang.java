package model;

public class KhachHang {
    private int maKH ;
    private String tenKH;
    private String sdt;
    private int soCMND;
    public static int id = 100;

    public KhachHang() {
    }

//    public KhachHang(int maKH) {
//        this.maKH = maKH;
//    }

    public KhachHang(int maKH) {
        this.maKH = maKH;
    }

    public KhachHang(int maKH, String tenKH, int soCMND, String sdt) {
        if (maKH == 0){
            this.maKH = id++ ;
        }else {
            this.maKH = maKH;
        }
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.soCMND = soCMND;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ",tenKH='" + tenKH + '\'' +
                ", sdt='" + sdt + '\'' +
                ", soCMND=" + soCMND +
                '}';
    }
}
