package jo.sangmyung.kr.put_on_this_dress;

import java.util.Date;

public class ShopItem {
    private final String ID;
    private String name;
    private String explanation;
    private String[] images;
    private int likes;
    private int style;
    private int lat, log; // 위도, 경도
    private Date date;

    public ShopItem(String ID, String name, String explanation, String[] images, int likes, int style, int lat, int log, Date date) {
        this.ID = ID;
        this.name = name;
        this.explanation = explanation;
        this.images = images;
        this.likes = likes;
        this.style = style;
        this.lat = lat;
        this.log = log;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
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

    public String[] getImages() {
        return images;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
