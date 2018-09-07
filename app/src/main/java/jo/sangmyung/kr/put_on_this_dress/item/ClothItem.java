package jo.sangmyung.kr.put_on_this_dress.item;

import java.util.Date;

public class ClothItem {
    private final String ID;
    private int category;
    private String name;
    private String description;
    private String[] images;
    private int cost;
    private int style;
    private int size;
    private Date date;

    public ClothItem(String ID, int category, String name, String description, String[] images, int cost, int style, int size, Date date) {
        this.ID = ID;
        this.category = category;
        this.name = name;
        this.description = description;
        this.images = images;
        this.cost = cost;
        this.style = style;
        this.size = size;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
