package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotal; // Đảm bảo bạn đã đặt fx:id là lblTotal trong Scene Builder
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // 1. Cấu hình bảng
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        if (cart != null) {
            tblMedia.setItems(this.cart.getItemsOrdered());
        }

        // 2. Thiết lập trạng thái ban đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotalPrice();

        // 3. Listener để ẩn/hiện nút khi chọn dòng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
        );
    }

    // Cập nhật tổng tiền
    private void updateTotalPrice() {
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
    }

    // Cập nhật nút bấm
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    // Xử lý nút Remove
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalPrice(); // Cập nhật lại tiền sau khi xóa
        }
    }

    // Xử lý nút Place Order
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        System.out.println("Order placed!");
        cart.getItemsOrdered().clear();
        updateTotalPrice();
    }

    // Xử lý điều hướng MenuBar (View Store)
    @FXML
    void viewStorePressed(ActionEvent event) {
        // Giả sử bạn có class StoreScreen
        new StoreScreen(this.cart);
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}