package hust.soict.dsai.test.media; // Hãy kiểm tra lại dòng này để khớp với cấu trúc gói thực tế của bạn

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        // 1. Khởi tạo danh sách kiểu dữ liệu cha Media
        List<Media> mediae = new ArrayList<Media>();

        // 2. Tạo các đối tượng cụ thể bằng cách truyền tham số thẳng vào Constructor (Vì Setter đã bị xóa)
        Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 19.95f);

        Book book = new Book(1, "Java Programming", "Technology", 29.95f);
        book.addAuthor("James Gosling");

        CompactDisc cd = new CompactDisc(2, "Suboi Album", "Rap/HipHop", 15.0f, 0, "Suboi", "Suboi");
        cd.addTrack(new Track("Song 1", 3));
        cd.addTrack(new Track("Song 2", 4));

        // 3. Thêm các đối tượng con vào danh sách chung Media
        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        // 4. Duyệt danh sách và in ra màn hình để kiểm tra tính Đa hình
        System.out.println("\n--- KẾT QUẢ IN DANH SÁCH ĐA HÌNH ---");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}