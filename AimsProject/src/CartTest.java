public class CartTest {
    public static void main(String[] args) {
        // 1. Tạo giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các đĩa DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // 3. Test hàm in giỏ hàng
        cart.print();

        // 4. Test hàm tìm kiếm
        System.out.println("\n--- Search by ID ---");
        cart.search(1); // Thử tìm ID có thật
        cart.search(99); // Thử tìm ID không tồn tại

        System.out.println("\n--- Search by Title ---");
        cart.search("Star Wars"); // Tìm đúng tên
        cart.search("Lion");      // Tìm tên gần đúng (nhờ hàm isMatch)
        cart.search("Iron Man");  // Tìm tên không có
    }
}