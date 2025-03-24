import javax.swing.*;

public class Frog extends Item {
    private int heatPoint;
    public Frog(Ground ground, int x, int y) {
        super(ground, null, x, y,0);
        this.heatPoint=3;
    }

    public int getHeatPoint() {
        return heatPoint;
    }

    public void setHeatPoint(int heatPoint) {
        this.heatPoint = heatPoint;
    }
}
