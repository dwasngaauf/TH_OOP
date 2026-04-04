public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        //PHẦN 11: TEST REMOVE
        // 1. Thử xóa đĩa dvd2 (Star Wars - 24.95)
        anOrder.removeDigitalVideoDisc(dvd2);

        // 2. In lại tổng tiền để kiểm tra
        // Kết quả mong đợi: 63.89 - 24.95 = 38.94
        System.out.println("Total Cost after removing is: ");
        System.out.println(anOrder.totalCost());

        // 3. Thử xóa một đĩa không có trong giỏ (để test logic thông báo)
        //DigitalVideoDisc dvd4 = new DigitalVideoDisc("Test");
        //anOrder.removeDigitalVideoDisc(dvd4);
    }
}