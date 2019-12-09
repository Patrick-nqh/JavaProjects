package controller;

import model.Phong;
import model.ThuePhong;

import java.util.ArrayList;

public class ControllerUltility {
    //cap nhat doi tuong cho thue phong

//update danh sach
       public ArrayList<ThuePhong> updateThuePhong(ArrayList<ThuePhong> thuePhongs
               , ThuePhong thuePhong){
           boolean isUpdate =false;
        for (int i = 0; i < thuePhongs.size(); i++) {
            if (thuePhongs.get(i).getKhachHang().getMaKH()
                        == thuePhong.getKhachHang().getMaKH()
                    && thuePhongs.get(i).getPhong().getMaPhong()
                        == thuePhong.getPhong().getMaPhong()) {
                thuePhongs.set(i, thuePhong);
                //thuePhong truyen vao thuePhongs.get(i)
                isUpdate = true;
                break;
                //neu id ma khach hang trung voi ma khach hang
                // co trong list thi ta tien hanh update
                // tinh trang cua doi tuong khach hang
            }else {
                thuePhongs.add(thuePhong);
            }

        }
        return thuePhongs;
       }
       public ArrayList<Phong> updatePhong(ArrayList<Phong> phongs
            , Phong phong, int maPhong){
          boolean isUpdate = false;
           for (Phong k : phongs) {
               if ( maPhong == k.getMaPhong())
                   phong.setTrangThai("da thue");
               else {
                   phong.setTrangThai("dang trong");
               }
           }
           return phongs;
       }

}
