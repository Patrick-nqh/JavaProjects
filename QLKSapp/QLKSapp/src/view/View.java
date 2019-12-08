package view;

import com.sun.javaws.util.JfxHelper;
import controller.DataController;
import jdk.nashorn.internal.ir.CallNode;
import model.KhachHang;
import model.LoaiPhong;
import model.Phong;
import model.ThuePhong;

import javax.lang.model.element.VariableElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws IOException {
        int choise = 0;
        String khachHangFileName = "KhachHang.txt";
        String thuePhongFileName = "ThuePhong.txt";
        String phongFileName = "Phong.txt";
        String loaiPhongFileName = "LoaiPhong.txt";

        DataController controller = new DataController();

        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        ArrayList<ThuePhong> thuePhongs = new ArrayList<>();
        ArrayList<Phong> phongs = new ArrayList<>();
        ArrayList<LoaiPhong> loaiPhongs = new ArrayList<>();

        boolean isKhChecked = false;
        boolean isThuePhongChecked = false;
        boolean isPhongChecked = false;

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("----------------------MENU--------------------------");
            System.out.println("1. Them khach hang vao trong file ");
            System.out.println("2. Hien thi danh sach khach hang co trong file ");
            System.out.println("3. Them phong vao trong file ");
            System.out.println("4. Hien thi danh sach phong co trong file ");
            System.out.println("5. Dat phong ");
            System.out.println("0. Thoat khoi ung dung");
            System.out.println("Hay chon mot trong cac tuy chon tren! ");

           choise = scanner.nextInt();
           scanner.nextLine();//doc bo dong chua lua chon

           switch (choise){
               case 0:
                   System.out.println("------------------------------------------");
                   System.out.println("Thanks for using this app by nhom 7!");
                   break;
               case 1:
                   if (!isKhChecked){
                       checkKhachHangId(controller,khachHangFileName);
                        isKhChecked = true;//de danh dau da check
                   }
        //          public KhachHang( int maKH, String tenKH, int soCMND, String sdt)
                   String tenKH, sdt;
                   int soCMND;

                   System.out.println("Nhap ten khach hang: ");
                   tenKH = scanner.nextLine();

                   System.out.println("Nhap soCMND: ");
                   soCMND = scanner.nextInt();
                   scanner.nextLine();

                   do {
                       System.out.println("Nhap sdt: ");
                       sdt = scanner.nextLine();
                   }while (!sdt.matches("\\d{10}"));
                   //bat loi nhap so dien thoai

                   KhachHang khachHang = new KhachHang(0,tenKH,soCMND,sdt);
                   controller.writeKhachHangToFile(khachHang, khachHangFileName);
                   break;
               case 2:
                   khachHangs = controller.readKhachHangFromFile(khachHangFileName);
                   showKhachHangInfo(khachHangs);
                   break;
               case 3:
                   int maPhong, dienTich, giaThue;
                   String tenPhong;
                   loaiPhongs = controller.readLoaiPhongFromFile(loaiPhongFileName);
                   //doc file thanh phan loai phong truoc khi them phong


//                    public Phong(int maPhong, String tenPhong, LoaiPhong loaiPhong, int dienTich, int giaThue)
//                   printWriter.println(phong.getMaPhong()+"|"+phong.getTenPhong()+"|"
//                         +phong.getLoaiPhong().getMaLoai()+"|"
//                       +phong.getDienTich()+"|"+phong.getGiaThue());

                    System.out.println("Nhap maPhong: ");
                    maPhong = scanner.nextInt();

                    System.out.println("Nhap dien tich phong: ");
                    dienTich = scanner.nextInt();

                    System.out.println("Nhap ");
                   break;
               case 4:
                   break;
               case 5:
                   khachHangs = controller.readKhachHangFromFile(khachHangFileName);
                   phongs = controller.readPhongFromFile(phongFileName);
                   int maKh ,maP;
                   boolean ttKhachHang = false;
                   do {
                       System.out.println("Nhap id khach hang hoac 0 de bo qua ");
                       maKh = scanner.nextInt();
                       if (maKh == 0){
                           break;//tat ca khach hang da thue phong
                       }
                       ttKhachHang = checkKhExist(maKh, khachHangs);
                       //neu ko break switch case cung ko break --> vong lap vo tan
                   }while(!ttKhachHang == true);
                   System.out.println("---------------Id khach hang hop le-------------------- ");
                   break;
           }
        }while (choise != 0);
    }

    private static boolean checkKhExist(int maKh, ArrayList<KhachHang> khachHangs) {
        for(int i = 0 ; i < khachHangs.size() ; i++){
            if (maKh == khachHangs.get(i).getMaKH()){
                return true;
            }
        }
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
//        sau khi reset app, static id bi reset ta can check de gan maKH gan nhat cho id--------
    }
    private static void showKhachHangInfo(ArrayList<KhachHang> khachHangs) {
        System.out.println("---------------Thong tin khach hang trong file-----------------------");
        for(KhachHang k: khachHangs){
          System.out.println(k);
          //goi toString cua khachHangs
        }
    }
}
