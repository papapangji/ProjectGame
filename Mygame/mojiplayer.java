import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.ImageIcon;

public class mojiplayer {
    public int x,y;//ซ้ายขวา
    public Image img;

public mojiplayer() {
    this.img = new ImageIcon(getClass().getResource("/bg/idle0.png")).getImage();
}
public Rectangle2D getbound() {
    // System.out.println(x+""+y);
        return (new Rectangle2D.Double(x+336, y+320, 70, 120));
    }
}