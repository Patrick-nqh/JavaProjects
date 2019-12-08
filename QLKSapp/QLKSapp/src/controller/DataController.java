package controller;

import model.*;

import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
//file to write
    public void openFileToWrite(String fileName) throws IOException {
        File file;
        fileWriter = new FileWriter(fileName, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);
    }
    public void closeFileAfterWrite(String fileName) throws IOException {
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }
//file to read
    public void openFileToRead(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }
        //tao file trong truong hop file ko ton tai
        try {
            scanner = new Scanner(Paths.get(fileName),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void closeFileAfterRead(String fileName){
        try{
            scanner.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    doc file
    //doc thong tin khach hang tu file --> chuyen thanh doi tuong khach hang
    //                                 --> them vao danh sach cac khach hang
    //                                 --> tra ve danh sach cac khach hang
    public ArrayList<KhachHang> readKhachHangFromFile(String fileName) throws IOException {
        openFileToRead(fileName);
        //tao danh sach chua thong tin cua mot tap cac doi tuong
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        while (scanner.hasNextLine()){
            //doc du lieu tu file
            String data = scanner.nextLine();
            //chuyen doi du lieu thanh doi tuong
            KhachHang khachHang = createKhachHangFromData(data);
            //them vao mang
            khachHangs.add(khachHang);
        }
        closeFileAfterRead(fileName);
        return khachHangs;
    }

    public KhachHang createKhachHangFromData(String data) {
        String[] datas = data.split("\\|");
//        printWriter.println(khachHang.getMaKH()+"|"+khachHang.getTenKH()+"|"
//                +khachHang.getSoCMND()+"|"+khachHang.getSdt());
//         public KhachHang(int maKH ,String tenKH, String sdt, int soCMND)
        KhachHang khachHang = new KhachHang(Integer.parseInt(datas[0]), datas[1]
                , Integer.parseInt(datas[2])
                , datas[3]);
        return khachHang;
    }
    public ArrayList<Phong> readPhongFromFile(String fileName) throws IOException {
        openFileToRead(fileName);
        ArrayList<Phong> phongs = new ArrayList<>();
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            Phong phong = createPhongFromData(data);
            phongs.add(phong);
        }
        closeFileAfterRead(fileName);
        return phongs;
    }
    public Phong createPhongFromData(String data){
        String[] datas = data.split("\\|");
//        public Phong(int maPhong, String tenPhong
//        , LoaiPhong loaiPhong, int dienTich, int giaThue)
//        printWriter.println(phong.getMaPhong()+"|"+phong.getTenPhong()+"|"
//                +phong.getLoaiPhong().getMaLoai()+"|"
//                +phong.getDienTich()+"|"+phong.getGiaThue());
        Phong phong = new Phong(Integer.parseInt(datas[0]),datas[1]
                , new LoaiPhong(Integer.parseInt(datas[2]))
                , Integer.parseInt(datas[3]),Integer.parseInt(datas[4]));
        return phong;
    }
    public ArrayList<LoaiPhong> readLoaiPhongFromFile(String fileName) throws IOException {
        openFileToRead(fileName);
        ArrayList<LoaiPhong> loaiPhongs = new ArrayList<>();
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            LoaiPhong loaiPhong = createLoaiPhongFromData(data);
            loaiPhongs.add(loaiPhong);
        }
        closeFileAfterRead(fileName);
        return loaiPhongs;
    }
    public LoaiPhong createLoaiPhongFromData(String data){
        String[] datas = data.split("\\|");
//        public LoaiPhong(int maLoai, String tenLoai, String ghiChu)
//        printWriter.println(loaiPhong.getMaLoai()+"|"+loaiPhong.getTenLoai()+"|"
//                +loaiPhong.getGhiChu());
        LoaiPhong loaiPhong = new LoaiPhong(Integer.parseInt(datas[0])
                ,datas[1],datas[2]);
        return loaiPhong;
    }

    public ArrayList<ThuePhong> readThuePhongFromFile(String fileName) throws ParseException, IOException {
        openFileToRead(fileName);
        ArrayList<ThuePhong> thuePhongs = new ArrayList<>();
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            ThuePhong thuePhong = createThuePhongFromData(data);
            thuePhongs.add(thuePhong);
        }
        closeFileAfterRead(fileName);
        return thuePhongs;
    }
    public ThuePhong createThuePhongFromData(String data) throws ParseException {
        String[] datas = data.split("\\|");
//        public ThuePhong(int maThue, KhachHang khachHang, Phong phong
//                , Date ngayVao, Date ngayRa, int datCoc)

//        printWriter.println(thuePhong.getMaThue()+"|"+thuePhong.getKhachHang().getMaKH()+"|"
//                +thuePhong.getPhong().getMaPhong()+"|" +thuePhong.getNgayVao()
//                +"|"+thuePhong.getNgayRa()+"|"+thuePhong.getDatCoc());

        ThuePhong thuePhong = new ThuePhong(Integer.parseInt(datas[0])
                , new KhachHang(Integer.parseInt(datas[1]))
                , new Phong(Integer.parseInt(datas[2]))
                , new SimpleDateFormat("dd/mm/yyyy").parse(datas[3])
                , new SimpleDateFormat("dd/mm/yyyy").parse(datas[4])
                , Integer.parseInt(datas[5]));
        return thuePhong;
    }
    public ArrayList<ThanhToan> readThanhToanFromFile(String fileName) throws ParseException, IOException {
        openFileToRead(fileName);
        ArrayList<ThanhToan> thanhToans = new ArrayList<>();
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            ThanhToan thanhToan = createThanhToanFromData(data);
            thanhToans.add(thanhToan);
        }
        closeFileAfterRead(fileName);
        return thanhToans;
    }
    public ThanhToan createThanhToanFromData(String data) throws ParseException {
        String[] datas = data.split("\\|");
//        public ThanhToan(ThuePhong thuePhong
//                ,int thanhTien, String hinhThucThanhToan
//                , String ghiChu, Date ngayThanhToan)
//        printWriter.println(thanhToan.getThuePhong().getKhachHang().getMaKH()
//                +"|"+thanhToan.getThanhTien()
//                +"|" +thanhToan.getHinhThucThanhToan()
//                +"|"+thanhToan.getGhiChu()
//                +"|"+thanhToan.getNgayThanhToan());
        ThanhToan thanhToan = new ThanhToan(new ThuePhong(new KhachHang(Integer.parseInt(datas[0])))
                ,Integer.parseInt(datas[1])
                ,datas[2],datas[3]
                ,new SimpleDateFormat("dd/mm/yyyy").parse(datas[4]));
        return thanhToan;
    }






    //    ghi file
    public  void writeKhachHangToFile(KhachHang khachHang, String fileName){
        try {
            openFileToWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println(khachHang.getMaKH()+"|"+khachHang.getTenKH()+"|"
                +khachHang.getSoCMND()+"|"+khachHang.getSdt());
        try {
            closeFileAfterWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeThuePhongToFile(ThuePhong thuePhong, String fileName){
        try {
            openFileToWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println(thuePhong.getMaThue()+"|"+thuePhong.getKhachHang().getMaKH()+"|"
                +thuePhong.getPhong().getMaPhong()+"|" +thuePhong.getNgayVao()
                +"|"+thuePhong.getNgayRa()+"|"+thuePhong.getDatCoc());
        try {
            closeFileAfterWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public   void writePhongToFile(Phong phong, String fileName){
        try {
            openFileToWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println(phong.getMaPhong()+"|"+phong.getTenPhong()+"|"
                +phong.getLoaiPhong().getMaLoai()+"|"
                +phong.getDienTich()+"|"+phong.getGiaThue());
        try {
            closeFileAfterWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeLoaiPhongToFile(LoaiPhong loaiPhong, String fileName){
        try {
            openFileToWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println(loaiPhong.getMaLoai()+"|"+loaiPhong.getTenLoai()+"|"
                +loaiPhong.getGhiChu());
        try {
            closeFileAfterWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeThanhToanToFile(ThanhToan thanhToan, String fileName){
        try {
            openFileToWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println(thanhToan.getThuePhong().getKhachHang().getMaKH()
                +"|"+thanhToan.getThanhTien()
                +"|" +thanhToan.getHinhThucThanhToan()
                +"|"+thanhToan.getGhiChu()
                +"|"+thanhToan.getNgayThanhToan());
        try {
            closeFileAfterWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
