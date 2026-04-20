package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // 1. Thử hàm swap SAI
        System.out.println("Test Swap lỗi");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle()); // Vẫn là Jungle
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle()); // Vẫn là Cinderella

        // 2. Thử hàm changeTitle
        System.out.println("\n--- Test ChangeTitle ---");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle()); // Đã thành Cinderella

        // 3. Thử hàm swap ĐÚNG
        System.out.println("\n--- Test Swap Đúng (correctSwap) ---");
        // Khởi tạo lại để test cho khách quan
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");

        correctSwap(dvd1, dvd2);
        System.out.println("dvd1 title: " + dvd1.getTitle()); // Sẽ ra Cinderella
        System.out.println("dvd2 title: " + dvd2.getTitle()); // Sẽ ra Jungle

        System.out.println("\nKiểm tra ID tự động tăng");
        // Tạo thêm đĩa mới để thấy ID tăng tiếp từ 2 lên 3 và 4
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin");

        System.out.println("ID của đĩa 1 (Jungle): " + dvd1.getId());
        System.out.println("ID của đĩa 2 (Cinderella): " + dvd2.getId());
        System.out.println("ID của đĩa 3 (Star Wars): " + dvd3.getId());
        System.out.println("ID của đĩa 4 (Aladdin): " + dvd4.getId());
    }

    // Hàm swap SAI (Giữ nguyên theo đề bài Figure 3)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm changeTitle (Giữ nguyên theo đề bài Figure 3)
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    // Hàm swap ĐÚNG
    public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        String tmpCategory = dvd1.getCategory();
        String tmpDirector = dvd1.getDirector();
        int tmpLength = dvd1.getLength();
        float tmpCost = dvd1.getCost();

        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());

        dvd2.setTitle(tmpTitle);
        dvd2.setCategory(tmpCategory);
        dvd2.setDirector(tmpDirector);
        dvd2.setLength(tmpLength);
        dvd2.setCost(tmpCost);
    }
}