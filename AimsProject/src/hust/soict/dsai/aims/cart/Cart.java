package hust.soict.dsai.aims.cart;

public class Cart {
    // Độ dài tối đa của giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Mảng lưu trữ các đối tượng hust.soict.dsai.aims.disc.DigitalVideoDisc
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Biến đếm số lượng đĩa hiện có trong giỏ hàng
    private int qtyOrdered = 0;

    // --- CÁC PHƯƠNG THỨC THÊM DVD ---

    /**
     * Sử dụng Varargs (...) để có thể nhận:
     * - Một đối tượng đơn lẻ: addDigitalVideoDisc(dvd1)
     * - Một danh sách đối tượng: addDigitalVideoDisc(dvd1, dvd2, dvd3)
     * - Một mảng đối tượng: addDigitalVideoDisc(dvdArray)
     * Cách này giúp sửa lỗi "cannot declare both" mà bạn gặp phải.
     */
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }

    // --- CÁC PHƯƠNG THỨC KHÁC ---

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // --- PHƯƠNG THỨC IN HÓA ĐƠN ---

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            // Sử dụng phương thức toString() đã viết ở lớp hust.soict.dsai.aims.disc.DigitalVideoDisc
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // --- CÁC PHƯƠNG THỨC TÌM KIẾM (Method Overloading) ---

    // Tìm kiếm theo ID
    public void search(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Tìm kiếm theo Title
    public void search(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
}