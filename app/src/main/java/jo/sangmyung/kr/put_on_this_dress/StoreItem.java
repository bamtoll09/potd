package jo.sangmyung.kr.put_on_this_dress;

import java.util.ArrayList;

public class StoreItem {
    private String name;
    private String explanation;
    private int likes;
    private int style;
    private ArrayList<ClothItem> clothes;
    private int lat, log; // 위도, 경도

    public StoreItem(String name, String explanation, int likes, int style, ArrayList<ClothItem> clothes, int lat, int log) {
        this.name = name;
        this.explanation = explanation;
        this.likes = likes;
        this.style = style;
        this.clothes = clothes;
        this.lat = lat;
        this.log = log;
    }

    public StoreItem(String name, String explanation, int style, ArrayList<ClothItem> clothes, int lat, int log) {
        this.name = name;
        this.explanation = explanation;
        this.style = style;
        this.clothes = clothes;
        this.lat = lat;
        this.log = log;
        this.likes = 0;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public ArrayList<ClothItem> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<ClothItem> clothes) {
        this.clothes = clothes;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLog() {
        return log;
    }

    public void setLog(int log) {
        this.log = log;
    }
}
