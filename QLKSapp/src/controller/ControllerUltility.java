package controller;

import model.ThuePhong;

import java.util.ArrayList;

public class ControllerUltility {
    //cap nhat doi tuong cho thue phong

//
       public ArrayList<ThuePhong> updateThuePhong(ArrayList<ThuePhong> thuePhongs
               , ThuePhong thuePhong){
           boolean isUpdate =false;
        for (int i = 0; i < thuePhongs.size(); i++) {
            if (thuePhongs.get(i).getKhachHang().getMaKH() == thuePhong.getKhachHang().getMaKH()
                    && thuePhongs.get(i).getPhong().getMaPhong() == thuePhong.getPhong().getMaPhong()) {
                thuePhongs.set(i, thuePhong);
                isUpdate = true;
                break;
                //neu id ma khach hang trung voi ma khach hang
                // co trong list thi ta tien hanh update
                // tinh trang cua doi tuong khach hang
            }

            if (!isUpdate) {
                thuePhongs.add(thuePhong);
            }
        }
        return thuePhongs;
       }

}
