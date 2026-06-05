package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // 1. Bộ so sánh: Sắp xếp theo Tên (Alphabet), nếu trùng tên thì xếp theo Giá giảm dần
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            Comparator.comparing(Media::getTitle)
                    .thenComparing(Comparator.comparing(Media::getCost).reversed());

    // 2. Bộ so sánh: Sắp xếp theo Giá giảm dần, nếu trùng giá thì xếp theo Tên (Alphabet)
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            Comparator.comparing(Media::getCost).reversed()
                    .thenComparing(Media::getTitle);

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;
        if (this.title == null) return other.getTitle() == null;
        return this.title.equalsIgnoreCase(other.getTitle());
    }
}