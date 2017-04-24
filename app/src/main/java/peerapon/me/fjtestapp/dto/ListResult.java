package peerapon.me.fjtestapp.dto;

/**
 * Created by peerapon01 on 4/24/2017 AD.
 */
import com.google.gson.annotations.SerializedName;

public class ListResult {

    @SerializedName("name") String name;
    @SerializedName("type") String type;
    @SerializedName("id")   int id;
    @SerializedName("cover") String coverUrl;

    public int getId() {
        return id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
