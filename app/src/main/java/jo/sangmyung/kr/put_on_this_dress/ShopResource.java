package jo.sangmyung.kr.put_on_this_dress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopResource {

    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("explanation")
    @Expose
    private String explanation;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("style")
    @Expose
    private Integer style;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("log")
    @Expose
    private Integer log;
    @SerializedName("date")
    @Expose
    private String date;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLog() {
        return log;
    }

    public void setLog(Integer log) {
        this.log = log;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*List<ShopItem> getShops() {
        ArrayList<ShopItem> items = new ArrayList<>();
        items.add(new ShopItem(_id, name, explanation, likes, style, images, clothes, date, lat, log));

        return items;
    }*/

}
