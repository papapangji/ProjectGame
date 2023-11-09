import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;

public class startgame extends JPanel{
    
    public ImageIcon feild = new ImageIcon(this.getClass().getResource("/bg/bgbg.jpg"));
	public ImageIcon start = new ImageIcon(this.getClass().getResource("/bg/starta.png"));
	public ImageIcon exit = new ImageIcon(this.getClass().getResource("/bg/exit.png"));
    public JButton Bst = new JButton(start);
    public JButton Bext = new JButton(exit);

    public startgame(){
        
        setLayout(null);
        add(Bst);
        Bst.setBounds(405, 220, 210, 70);
        add(Bext);
        Bext.setBounds(395, 350, 230, 70);
        

    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(feild.getImage(),0,0,1020,700, this);
        //g.drawImage(start.getImage(),175,120,120,400, this);


    }
}
