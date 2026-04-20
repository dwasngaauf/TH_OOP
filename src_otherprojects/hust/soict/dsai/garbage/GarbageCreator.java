package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.exe"; // Hãy chọn 1 file nặng trong máy bạn
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Mỗi lần cộng là 1 lần tạo rác
        }
        System.out.println("Thời gian xử lý (String +): " + (System.currentTimeMillis() - startTime) + " ms");
    }
}