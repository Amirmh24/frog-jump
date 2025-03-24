import javax.swing.*;

public class Water extends Item {
    public Water(Ground ground, int x, int y) {
        super(ground, new ImageIcon("Water.png"), x, y, 0);
    }
}