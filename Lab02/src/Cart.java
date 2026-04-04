public class Cart {
    //độ dài tối đa của giỏ hàng theo đề bài
    public static final int MAX_NUMBERS_ORDERED = 20;

    //mảng để lưu trữ các đối tượng DigitalVideoDisc
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    //biến đếm số lượng đĩa hiện có trong giỏ hàng
    private int qtyOrdered = 0;

    //phương thức thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    //phương thức xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Khi tìm thấy, dịch chuyển các phần tử phía sau lên để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa phần tử cuối cùng sau khi dịch chuyển
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart");
        }
    }

    //hương thức tính tổng giá trị giỏ hàng
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}