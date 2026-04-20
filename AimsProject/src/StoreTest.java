public class StoreTest {
    public static void main(String[] args) {
        // 1. Khởi tạo cửa hàng
        Store myStore = new Store();

        // 2. Tạo một vài đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // 3. Test tính năng thêm đĩa (addDVD)
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);

        // In kho hàng sau khi thêm
        myStore.printStore();

        // 4. Test tính năng xóa đĩa (removeDVD)
        myStore.removeDVD(dvd2); // Xóa Star Wars
        myStore.removeDVD(new DigitalVideoDisc("Non-existent DVD")); // Thử xóa đĩa không có

        // In kho hàng cuối cùng
        myStore.printStore();
    }
}