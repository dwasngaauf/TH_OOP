package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Khởi tạo nhãn tiêu đề
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Khởi tạo nhãn giá tiền
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Vùng chứa các nút bấm
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Xử lý nút "Add to cart"
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Theo Note của thầy, tạm thời in ra Console
                System.out.println("Đã thêm [" + media.getTitle() + "] vào giỏ hàng!");
            }
        });
        container.add(btnAddToCart);

        // Xử lý nút "Play" (Chỉ hiện nếu đối tượng là Playable)
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Hiển thị JDialog khi nhấn Play theo yêu cầu mục 3.2
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing Media");
                    dialog.setSize(300, 150);
                    dialog.setLayout(new BorderLayout());

                    // Nội dung hiển thị trong Dialog
                    JLabel playLabel = new JLabel("Playing: " + media.getTitle());
                    playLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    playLabel.setFont(new Font("Arial", Font.BOLD, 16));

                    dialog.add(playLabel, BorderLayout.CENTER);
                    dialog.setLocationRelativeTo(null); // Cho hộp thoại hiện ở chính giữa màn hình
                    dialog.setVisible(true);
                }
            });
            container.add(btnPlay);
        }

        // Đẩy các thành phần vào Panel chính
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        // Tạo viền đen bao quanh từng ô sản phẩm
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}