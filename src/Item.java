import javax.swing.*;

public class Item {
    private final ImageIcon image;
    private Ground ground;
    private int x;
    private int y;
    private int d;

    public Item(Ground ground, ImageIcon image, int x, int y, int d) {
        this.ground = ground;
        this.image = image;
        this.x = x;
        this.y = y;
        this.d = d;
        if(image!=null)
            ground.getItems()[x][y] = this;
    }

    public ImageIcon getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
