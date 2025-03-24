import java.util.Random;

public class Ground {
    private final static Random random = new Random();
    private final Item[][] items;
    private int level;
    private int score;
    private int n, m;
    private Frog frog;

    public Ground(int n, int m, int level) {
        this.n = n;
        this.m = m;
        this.level = level;
        this.frog = new Frog(this, 0, m / 2);
        this.items = new Item[n][m];
        for (int i = 0; i < m; i++) {
            new Wood(this, 0, i, 0);
            new Wood(this, n - 1, i, 0);
        }
        for (int i = 1; i < n - 1; i++)
            for (int j = 0; j < m; j++)
                new Water(this, i, j);
        for (int i = 1; i < n - 1; i++)
            for (int j = 0; j < m; j++)
                if (random.nextInt(level + 1) == 0) {
                    if (random.nextInt(2) % 2 == 0)
                        new Wood(this, i, j, 2 * (i % 2) - 1);
                    else
                        new Turtle(this, i, j, 2 * (i % 2) - 1);
                } else if (random.nextInt(50 - level) < 10) {
                    new Crocodile(this, i, j, 2 * (i % 2) - 1);
                }
    }

    public Item[][] getItems() {
        return items;
    }

    public void update() {
        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) {
                for (int j = m - 1; j > 0; j--) {
                    items[i][j] = items[i][j - 1];
                    if (frog.getX() == i && frog.getY() == j)
                        frog.setY(frog.getY() + 1);
                }
                if (random.nextInt(level + 1) == 0) {
                    if (random.nextInt(2) % 2 == 0)
                        new Wood(this, i, 0, 2 * (i % 2) - 1);
                    else
                        new Turtle(this, i, 0, 2 * (i % 2) - 1);
                } else if (random.nextInt(50 - level) < 10) {
                    new Crocodile(this, i, 0, 2 * (i % 2) - 1);
                } else {
                    new Water(this, i, 0);
                }
            } else {
                for (int j = 0; j < m - 1; j++) {
                    items[i][j] = items[i][j + 1];
                    if (frog.getX() == i && frog.getY() == j)
                        frog.setY(frog.getY() - 1);
                }
                if (random.nextInt(level + 1) == 0) {
                    if (random.nextInt(2) % 2 == 0)
                        new Wood(this, i, m - 1, 2 * (i % 2) - 1);
                    else
                        new Turtle(this, i, m - 1, 2 * (i % 2) - 1);
                } else if (random.nextInt(50 - level) < 10) {
                    new Crocodile(this, i, m - 1, 2 * (i % 2) - 1);
                } else {
                    new Water(this, i, m - 1);
                }
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Frog getFrog() {
        return frog;
    }

    public Item getItem(int i, int j) {

        return items[i][j];

    }


}
