package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            System.out.println("The media is not in the store.");
        }
    }

    // Hàm tìm kiếm cực kỳ quan trọng để phục vụ lớp Aims gọi menu
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("\n**********STORE INVENTORY**********");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("************************************\n");
    }
}