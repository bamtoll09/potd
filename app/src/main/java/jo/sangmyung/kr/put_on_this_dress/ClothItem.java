package jo.sangmyung.kr.put_on_this_dress;

import android.graphics.Bitmap;

public class ClothItem {
    private String name;
    private String explanation;
    private int style;
    private Bitmap[] images;

    public ClothItem(String name, String explanation, int style, Bitmap[] images) {
        this.name = name;
        this.explanation = explanation;
        this.style = style;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public Bitmap[] getImages() {
        return images;
    }

    public void setImages(Bitmap[] images) {
        this.images = images;
    }
}
