import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;

public class startgame extends JPanel{
    
    public ImageIcon feild = new ImageIcon(this.getClass().getResource("/bg/bgbg.jpg"));
	public ImageIcon start = new ImageIcon(this.getClass().getResource("/bg/start1.png"));
	public ImageIcon exit = new ImageIcon(this.getClass().getResource("/bg/exit.png"));
    public JButton Bst = new JButton(start);
    public JButton Bext = new JButton(exit);

    public startgame(){
        setLayout(null);
        add(Bst);
        Bst.setBounds(315, 320, 90, 45);
        add(Bext);
        Bext.setBounds(315, 420, 90, 45);
        

    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(feild.getImage(),0,0,750,800, this);
        //g.drawImage(start.getImage(),175,120,120,400, this);


    }
}
