package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    // Hàm tìm kiếm phụ trợ trong giỏ hàng để phục vụ chức năng xóa/phát thử
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Phương thức sắp xếp giỏ hàng theo Title trước, Cost sau
    public void sortByTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo Title.");
    }

    // Phương thức sắp xếp giỏ hàng theo Cost trước, Title sau
    public void sortByCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo Cost.");
    }

    // Hàm in hóa đơn hiển thị danh sách giỏ hàng
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}