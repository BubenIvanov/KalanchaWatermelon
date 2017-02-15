package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 06.02.2017.
 */
public class Fruits {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMud() {
        return mud;
    }

    public void setMud(String mud) {
        this.mud = mud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhotoResId() {
        return photoResId;
    }

    public void setPhotoResId(int photoResId) {
        this.photoResId = photoResId;
    }

    String name,mud;
    int id;
    int photoResId;

    public Fruits( int id,String name, String mud, int photoResId) {
        this.name = name;
        this.mud = mud;
        this.id = id;
        this.photoResId = photoResId;
    }
}

