import javax.swing.*;

public class Crocodile extends Item {
    public Crocodile(Ground ground, int x, int y, int d) {
        super(ground, new ImageIcon("Crocodile"+d+".png"), x, y, d);
    }
}
