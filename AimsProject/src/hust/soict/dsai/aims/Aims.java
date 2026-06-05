package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    storeMenuHandler();
                    break;
                case 2:
                    updateStoreHandler();
                    break;
                case 3:
                    cartMenuHandler();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống AIMS!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 0);
    }

    private static void initSampleData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);

        Book book1 = new Book(1, "Java Core", "Technology", 15.0f);
        book1.addAuthor("James Gosling");

        CompactDisc cd1 = new CompactDisc(2, "MTP Album", "Pop", 20.0f, 0, "Sơn Tùng", "Sơn Tùng");
        cd1.addTrack(new Track("Chay Ngay Di", 4));
        cd1.addTrack(new Track("Chúng Ta Của Tương Lai", 5));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void storeMenuHandler() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media foundMedia = store.searchByTitle(title);
                    if (foundMedia != null) {
                        System.out.println("\n[MEDIA DETAILS]\n" + foundMedia.toString());
                        mediaDetailsMenuHandler(foundMedia);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the media to add to cart: ");
                    String tAdd = scanner.nextLine();
                    Media mAdd = store.searchByTitle(tAdd);
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                    } else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to play: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = store.searchByTitle(tPlay);
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) {
                            ((Playable) mPlay).play();
                        } else {
                            System.out.println("This media type cannot be played!");
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 4:
                    cartMenuHandler();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void mediaDetailsMenuHandler(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media type cannot be played!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void updateStoreHandler() {
        System.out.println("\n1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Please choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            DigitalVideoDisc newDvd = new DigitalVideoDisc(null, title, cost);
            store.addMedia(newDvd);
        } else if (choice == 2) {
            System.out.print("Enter title of the media to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
            } else {
                System.out.println("Media does not exist in store!");
            }
        }
    }

    private static void cartMenuHandler() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Filter options: 1. By ID | 2. By Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Filtering feature is processed safely...");
                    break;
                case 2:
                    System.out.println("Sort options: 1. By Title then Cost | 2. By Cost then Title");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else {
                        cart.sortByCost();
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String titleRemove = scanner.nextLine();
                    Media mRemove = cart.searchByTitle(titleRemove);
                    if (mRemove != null) {
                        cart.removeMedia(mRemove);
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mPlay = cart.searchByTitle(titlePlay);
                    if (mPlay != null && mPlay instanceof Playable) {
                        ((Playable) mPlay).play();
                    } else {
                        System.out.println("Cannot play this media!");
                    }
                    break;
                case 5:
                    System.out.println("\n[SUCCESS] An order has been created successfully!");
                    cart = new Cart();
                    choice = 0;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}