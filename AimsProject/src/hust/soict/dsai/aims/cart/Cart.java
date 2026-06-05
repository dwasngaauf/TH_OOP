package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Đã đổi sang ObservableList để hỗ trợ JavaFX TableView
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

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

    // Getter cần thiết cho JavaFX TableView
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void sortByTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo Title.");
    }

    public void sortByCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo Cost.");
    }

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