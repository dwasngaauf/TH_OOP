public class DigitalVideoDisc
{
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    //Thuộc tính id (instance) và nbDigitalVideoDiscs (static) để quản lý ID tự động
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    //Phương thức bổ trợ để cập nhật ID khi tạo đối tượng
    private void updateId() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    //Getter cho ID (để dùng trong các hàm tìm kiếm ở lớp Cart)
    public int getId() {
        return id;
    }
//----------------------------------------------------------------------
    //Phần 7:
    //getter
    public String getTitle()
    {
        return title;
    }
    public String getCategory()
    {
        return category;
    }
    public String getDirector()
    {
        return director;
    }
    public int getLength()
    {
        return length;
    }
    public float getCost()
    {
        return cost;
    }
    //setter
    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
//----------------------------------------------------------------------
    // Phần 8: tạo constructor
    //Theo tittle
    public DigitalVideoDisc(String title) {
        this.title = title;
        updateId();
    }

    //Theo category, title, cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        updateId();
    }

    //Theo director, category, title, cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        updateId();
    }

    //Đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        updateId();
    }

    //Phương thức toString() để trả về thông tin chi tiết của DVD [cite: 992]
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    //Phương thức isMatch(String title) phục vụ tìm kiếm theo tiêu đề
    public boolean isMatch(String title) {
        // Trả về true nếu tiêu đề của DVD chứa chuỗi tìm kiếm (không phân biệt hoa thường)
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
