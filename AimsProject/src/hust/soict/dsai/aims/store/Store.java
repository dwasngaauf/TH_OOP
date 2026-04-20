package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {
    // Thuộc tính: Danh sách các đĩa có trong cửa hàng
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    // Phương thức thêm đĩa vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("The disc '" + dvd.getTitle() + "' has been added to the store.");
    }

    // Phương thức xóa đĩa khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("The disc '" + dvd.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The disc '" + dvd.getTitle() + "' is not in the store.");
        }
    }

    // Phương thức bổ trợ để in danh sách trong kho (tiện cho việc test)
    public void printStore() {
        System.out.println("\n**********STORE INVENTORY**********");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("************************************\n");
    }
}