import javax.swing.*;

public class Turtle extends Item {
    public Turtle(Ground ground, int x, int y,int d) {
        super(ground, new ImageIcon("Turtle"+d+".png"), x, y, d);
    }
}
