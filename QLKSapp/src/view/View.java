package view;

import com.sun.javaws.util.JfxHelper;
import controller.ControllerUltility;
import controller.DataController;
import jdk.nashorn.internal.ir.CallNode;
import model.*;

import javax.lang.model.element.VariableElement;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    public static void main(String[] args) throws IOException, ParseException {
        int choise = 0;
        String khachHangFileName = "KhachHang.txt";
        String thuePhongFileName = "ThuePhong.txt";
        String phongFileName = "Phong.txt";
        String loaiPhongFileName = "LoaiPhong.txt";
        String thanhToanFileName = "ThanhToan.txt";

        DataController controller = new DataController();
        ControllerUltility ultility = new ControllerUltility();// khoi tao ultility

        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        ArrayList<ThuePhong> thuePhongs = new ArrayList<>();
        ArrayList<Phong> phongs = new ArrayList<>();
        ArrayList<LoaiPhong> loaiPhongs = new ArrayList<>();

        KhachHang currentKhachHang = new KhachHang();
        Phong currentPhong = new Phong();

        boolean isKhChecked = false;
        boolean isThuePhongChecked = false;
        boolean isPhongChecked = false;

//        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
//        Pattern pattern = Pattern.compile(regex);

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------------------MENU--------------------------");
            System.out.println("1. Them khach hang vao trong file ");
            System.out.println("2. Hien thi danh sach khach hang co trong file ");
            System.out.println("3. Them phong vao trong file ");
            System.out.println("4. Hien thi danh sach phong co trong file ");
            System.out.println("5. Them loai phong vao trong file ");
            System.out.println("6. Hien thi danh sach loai phong co trong file ");
            System.out.println("7. Dat phong ");
            System.out.println("8. Hien thi danh sach dat phong ");
            System.out.println("9. Tra phong ");
            System.out.println("0. Thoat khoi ung dung");
            System.out.println("-------------------------------------------------------");
            System.out.println("Hay chon mot trong cac tuy chon tren! ");

            choise = scanner.nextInt();
            scanner.nextLine();//doc bo dong chua lua chon

            switch (choise) {
                case 0:
                    System.out.println("------------------------------------------");
                    System.out.println("Thanks for using this app by nhom 7!");
                    break;
                case 1:
                    if (!isKhChecked) {
                        checkKhachHangId(controller, khachHangFileName);
                        isKhChecked = true;//de danh dau da check
                    }
                    //          public KhachHang( int maKH, String tenKH, int soCMND, String sdt)
                    String tenKH = "no name", sdt;
                    int soCMND;

                    System.out.println("Nhap ten khach hang: ");
                    tenKH = scanner.nextLine();

                    System.out.println("Nhap soCMND: ");
                    soCMND = scanner.nextInt();
                    scanner.nextLine();

                    do {
                        System.out.println("Nhap sdt: ");
                        sdt = scanner.nextLine();
                    } while (!sdt.matches("\\d{10}"));
                    //bat loi nhap so dien thoai

                    KhachHang khachHang = new KhachHang(0, tenKH, soCMND, sdt);
                    controller.writeKhachHangToFile(khachHang, khachHangFileName);
                    break;
                case 2:
                    khachHangs = controller.readKhachHangFromFile(khachHangFileName);
                    showKhachHangInfo(khachHangs);
                    break;
                case 3:
                    int maPhong, dienTich, giaThue, maLoai;
                    loaiPhongs = controller.readLoaiPhongFromFile(loaiPhongFileName);
                    //doc file thanh phan loai phong truoc khi them phong


//                    public Phong(int maPhong, String tenPhong, LoaiPhong loaiPhong, int dienTich, int giaThue)
//                   printWriter.println(phong.getMaPhong()+"|"+phong.getTenPhong()+"|"
//                         +phong.getLoaiPhong().getMaLoai()+"|"
//                       +phong.getDienTich()+"|"+phong.getGiaThue());

                    System.out.println("Nhap ma phong: ");
                    maPhong = scanner.nextInt();

                    System.out.println("Nhap ma loai phong: ");
                    maLoai = scanner.nextInt();

                    System.out.println("Nhap dien tich phong: ");
                    dienTich = scanner.nextInt();

                    System.out.println("Nhap gia thue: ");
                    giaThue = scanner.nextInt();

                    LoaiPhong currentLoaiPhong = getLoaiPhong(loaiPhongs, maLoai);

                    Phong phong = new Phong(maPhong, currentLoaiPhong, dienTich, giaThue);
                    controller.writePhongToFile(phong, phongFileName);
                    break;
                case 4:
                    phongs = controller.readPhongFromFile(phongFileName);
                    //ham readPhongFromFile tra ve mot danh sach kieu
                    showPhongInfo(phongs);
                    break;
                case 5:
                    String ghiChu, tenLoai;

                    System.out.println("Nhap ma loai: ");
                    maLoai = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nhap ten loai phong: ");
                    tenLoai = scanner.nextLine();

                    System.out.println("Nhap ghi chu: ");
                    ghiChu = scanner.nextLine();

                    LoaiPhong loaiPhong = new LoaiPhong(maLoai, tenLoai, ghiChu);
                    controller.writeLoaiPhongToFile(loaiPhong, loaiPhongFileName);
                    break;
                case 6:
                    loaiPhongs = controller.readLoaiPhongFromFile(loaiPhongFileName);
                    showLoaiPhongInfo(loaiPhongs);
                    break;
                case 7:
                    if (!isThuePhongChecked) {
                        checkThuePhongId(controller, thuePhongFileName);
                        isThuePhongChecked = true;//de danh dau da check
                    }
                    //de thuc hien ta can phai doc thong tin cua khach hang va phong
                    khachHangs = controller.readKhachHangFromFile(khachHangFileName);
                    phongs = controller.readPhongFromFile(phongFileName);

                    int maKh, datCoc;
                    String dayOut, dayIn;
                    SimpleDateFormat time = new SimpleDateFormat("YYYY-MM-dd");
                    boolean ttKhachHang = false;

                    do {
                        do {
                            System.out.println("Nhap id khach hang hoac 0 de bo qua ");
                            maKh = scanner.nextInt();
                            if (maKh == 0) {
                                break;//tat ca khach hang da thue phong//bo qua
                            }
                            ttKhachHang = checkKhExist(maKh, khachHangs);
                        } while (!ttKhachHang == true);
                        System.out.println("---------------Id khach hang hop le-------------------- ");
                        //neu ko break switch case cung ko break --> vong lap vo tan
                        boolean ttPhong = false;
                        do {
                            System.out.println("Nhap ma phong muon thue ");
                            maPhong = scanner.nextInt();
                            scanner.nextLine();
                            ttPhong = checkPhongExist(maPhong, phongs);
                        } while (!ttPhong == true);
                        System.out.println("---------------Ma phong hop le-------------------- ");
                    } while (false);
                    currentKhachHang = getKhachHang(khachHangs, maKh);
                    currentPhong = getPhong(phongs, maPhong);

                    phongs = ultility.updatePhong(phongs, currentPhong, maPhong);
                    controller.updatePhongFile(phongs, phongFileName);

                    do {
                        System.out.println("Nhap ngay vao: ");
                        dayIn = scanner.nextLine();
                    }while (!isValidDate(dayIn));
//dinh dang 00/00/0000
                    do {
                        System.out.println("Nhap ngay ra: ");
                        dayOut = scanner.nextLine();
                    }while (!isValidDate(dayOut));

                    System.out.println("Nhap dat coc: ");
                    datCoc = scanner.nextInt();

                    ThuePhong thuePhong = new ThuePhong(0, currentKhachHang
                            , currentPhong, dayIn, dayOut, datCoc);

                    //cap nhat danh sach thue phong
                    thuePhongs = ultility.updateThuePhong(thuePhongs, thuePhong);
//                   controller.updateThuePhongFile(thuePhongs, thuePhongFileName);
                    //cap nhap file
                    controller.writeThuePhongToFile(thuePhong, thuePhongFileName);
// update
                    break;
                case 8:
                    thuePhongs = controller.readThuePhongFromFile(thuePhongFileName);
                    showThuePhongInfo(thuePhongs);
                    break;
                case 9:
                    thuePhongs = controller.readThuePhongFromFile(thuePhongFileName);
                    int thanhTien, maThue, soHT;
                    String hinhThucThanhToan;
                    Date ngayThanhToan;
                    boolean ttThue = false;
                    String[] hinhThuc = {"ATM", "Tien mat"};
                    do {
                        System.out.println("Nhap ma thue phong hoac 0 de bo qua ");
                        maThue = scanner.nextInt();
                        if (maThue == 0) {
                            break;//tat ca khach hang da thue phong//bo qua
                        }
                        ttThue = checkThueExist(maThue, thuePhongs);
                    } while (!ttThue == true);
                    System.out.println("--------------- Ma thue hop le -------------------- ");
                    ThuePhong currentThuePhong = getThuePhong(thuePhongs, maThue);

                    tenKH = currentThuePhong.getKhachHang().getTenKH();
//
                    thanhTien = currentThuePhong.getPhong().getGiaThue();

                    do {
                        System.out.println("Nhap hinh thuc thanh toan: ");
                        System.out.println("1.ATM\n2.Tien mat");
                        soHT = scanner.nextInt();
                        hinhThucThanhToan = hinhThuc[soHT - 1];
                    } while (soHT < 1 || soHT > 2);

                    System.out.println("Nhap ghi chu ");
                    ghiChu = scanner.nextLine();

                    java.util.Date date = new java.util.Date();
                    ngayThanhToan = date;

                    ThanhToan thanhToan = new ThanhToan(currentThuePhong, thanhTien
                            , hinhThucThanhToan, ghiChu, ngayThanhToan);
                    controller.writeThanhToanToFile(thanhToan, thanhToanFileName);
                    break;
            }
        } while (choise != 0);
    }

    public static boolean isValidDate(String d)
    {
        String regex = "^(1[0-2]|0[1-9])/(3[01]"
                + "|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }

    private static void showThuePhongInfo(ArrayList<ThuePhong> thuePhongs) {
        System.out.println("--------------Danh sach thue phong trong file ----------");
        for (ThuePhong k : thuePhongs) {
            System.out.println(k);
        }
    }

    private static boolean checkThueExist(int maThue, ArrayList<ThuePhong> thuePhongs) {
        for(int i = 0 ; i < thuePhongs.size() ; i++){
            if (maThue == thuePhongs.get(i).getMaThue()){
                return true;
            }
        }
        return false;
    }

    private static void checkThuePhongId(DataController controller, String fileName) throws IOException {
        ArrayList<ThuePhong> thuePhongs = controller.readThuePhongFromFile(fileName);
        if(thuePhongs.size() == 0){
            //do nothing
            //trong th kich thuoc bang 0 id gan gt rac
        }else {
            ThuePhong.id = thuePhongs.get(thuePhongs.size()-1).getMaThue()+1;
            //lay truong id tu trong contructor de gan --> id duoc check
        }
//        sau khi reset app, static id bi reset ta can check de gan maKH gan nhat cho id--------
    }
    private static boolean checkPhongExist(int maPhong, ArrayList<Phong> phongs) {
        for (int i = 0; i<phongs.size(); i++){
            if(maPhong == phongs.get(i).getMaPhong() && phongs.get(i).getTrangThai() == "dang trong")
                return true;
        }
        return false;//kiem tra xem ma phong co trong danh sach ko va da cho thue chua de cho thue
    }

    private static void showPhongInfo(ArrayList<Phong> phongs) {
        for (Phong k : phongs) {
            System.out.println(k);
        }
    }

    private static void showLoaiPhongInfo(ArrayList<LoaiPhong> loaiPhongs) {
        System.out.println("-----------Thong tin loai phong trong file--------------");
        for (LoaiPhong k: loaiPhongs) {
            System.out.println(k);
        }
}

    private static boolean checkKhExist(int maKh, ArrayList<KhachHang> khachHangs) {
        for(int i = 0 ; i < khachHangs.size() ; i++){
            if (maKh == khachHangs.get(i).getMaKH()){
                return true;
            }
        }//kiem tra ma khach hang co ton tai trong CSDL ko neu ko se ko the thuc hien thue phong
        return false;
    }

    private static void checkKhachHangId(DataController controller, String fileName) throws IOException {
        ArrayList<KhachHang> listKhs = controller.readKhachHangFromFile(fileName);
        if(listKhs.size() == 0){
            //do nothing
            //trong th kich thuoc bang 0 id gan gt rac
        }else {
            KhachHang.id = listKhs.get(listKhs.size()-1).getMaKH()+1;
        }
//sau khi reset app, static id bi reset ta can check de gan maKH gan nhat cho id
    }
    private static void showKhachHangInfo(ArrayList<KhachHang> khachHangs) {
        System.out.println("---------------Thong tin khach hang trong file-----------------------");
        for(KhachHang k: khachHangs){
          System.out.println(k);
          //goi toString cua khachHangs
        }
    }
    private static KhachHang getKhachHang (ArrayList<KhachHang> khachHangs, int maKh){
        for (int i = 0; i < khachHangs.size(); i++){
            if(khachHangs.get(i).getMaKH() == maKh){
                return khachHangs.get(i);
            }
        }
        return null;
    }
    private static Phong getPhong (ArrayList<Phong> phongs, int maPhong){
        for (int i = 0; i < phongs.size(); i++){
            if(phongs.get(i).getMaPhong() == maPhong){
                return phongs.get(i);
            }
        }
        return null;
    }
    private static LoaiPhong getLoaiPhong (ArrayList<LoaiPhong> loaiPhongs, int maLoai){
        for (int i = 0; i < loaiPhongs.size(); i++){
            if(loaiPhongs.get(i).getMaLoai() == maLoai){
                return loaiPhongs.get(i);
            }
        }
        return null;
    }
    private static ThuePhong getThuePhong (ArrayList<ThuePhong> thuePhongs, int maThue){
        for (int i = 0; i < thuePhongs.size(); i++){
            if(thuePhongs.get(i).getMaThue() == maThue){
                return thuePhongs.get(i);
            }
        }
        return null;
    }

}
