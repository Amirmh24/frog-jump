import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic {
    private JFrame frame;
    private JPanel panel;
    private Ground ground;
    private JButton[][] buttons;

    public Graphic(Ground ground) throws Exception {
        this.ground = ground;
        this.frame = new JFrame("Heatpoint: "+ground.getFrog().getHeatPoint());
        frame.setSize(ground.getN() * 100, ground.getM() * 100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(ground.getN(), ground.getM()));
        this.buttons = new JButton[ground.getN()][ground.getM()];
        for (int i = 0; i < ground.getN(); i++) {
            for (int j = 0; j < ground.getM(); j++) {
                this.buttons[i][j] = new JButton();
                buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
                int I = i, J = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Math.abs(ground.getFrog().getX() - I)+Math.abs(ground.getFrog().getY() - J)<3) {
                            ground.getFrog().setX(I);
                            ground.getFrog().setY(J);
                        }

                    }
                });
                panel.add(buttons[i][j]);
            }
        }
        update();
        frame.add(panel);
        frame.setVisible(true);
        for (int i = 0; i < 100; i++) {
            Thread.sleep((100-ground.getLevel())*10);
            update();
        }
    }

    public void update() throws Exception {
        ground.update();
        for (int i = 0; i < ground.getN(); i++) {
            for (int j = 0; j < ground.getM(); j++) {
                this.buttons[i][j].setIcon(ground.getItem(i, j).getImage());
            }
        }
        try {
            Item underFrog = ground.getItem(ground.getFrog().getX(), ground.getFrog().getY());
            if (underFrog instanceof Wood)
                this.buttons[ground.getFrog().getX()][ground.getFrog().getY()].setIcon(new ImageIcon("WoodFrog.png"));
            else if (underFrog instanceof Turtle)
                this.buttons[ground.getFrog().getX()][ground.getFrog().getY()].setIcon(new ImageIcon("Turtle" + underFrog.getD() + "Frog.png"));
            else
                this.buttons[ground.getFrog().getX()][ground.getFrog().getY()].setIcon(new ImageIcon("Water.png"));
        } catch (Exception e) {
            ground.getFrog().setX(0);
            ground.getFrog().setY(ground.getM() / 2);
            ground.getFrog().setHeatPoint(ground.getFrog().getHeatPoint()-1);
            if (ground.getFrog().getHeatPoint()==0)
                System.exit(0);
            frame.setTitle("Heatpoint: "+ground.getFrog().getHeatPoint());
        }
        if (ground.getFrog().getX()==ground.getN()-1){
            Thread.sleep(1000);
            frame.dispose();
            new Graphic(new Ground(ground.getN(),ground.getM(),ground.getLevel()+1));
        }

    }
}
