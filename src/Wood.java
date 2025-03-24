import javax.swing.*;

public class Wood extends Item {
    public Wood(Ground ground, int x, int y,int d) {
        super(ground, new ImageIcon("Wood.png"), x, y, d);
    }
}
