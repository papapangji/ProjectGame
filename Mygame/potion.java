import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class potion {
    public int x=(int) ((Math.random() * 300) + 20);
    public int y=0;
    public Image imgpt;

    public potion(){
        x = (int) ((Math.random() * 300) + 20);
        y = 0;
        this.imgpt = new ImageIcon(getClass().getResource("/bg/majic1.png")).getImage();
        runner.start();
}
        private int potion = 3;
        public void move(){
            y += potion;
            if (y >= 1300) {
                resetimgpt();

            }
        }
private void resetimgpt() {
        Random rd = new Random();
        x = rd.nextInt(1200);
        y = 0;
        }
Thread runner = new Thread(new Runnable() {
    public void run() {
        while (true) {
            y += potion;
            if (y >= 1300) {
                resetimgpt();

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetimgpt() {
        Random rd = new Random();
        x = -rd.nextInt(1200);
        y = rd.nextInt(700);
    }
});

public Image getImage() {
        return imgpt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        // System.out.println(x+""+y);
        return (new Rectangle2D.Double(x, y, 45, 45));
    }
}

