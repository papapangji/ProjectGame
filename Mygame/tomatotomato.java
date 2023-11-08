import java.util.ArrayList;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class tomatotomato extends JFrame implements ActionListener{
    startgame stg = new startgame();
    Draw d = new Draw();

    tomatotomato(){
        
        // add(d);
        add(stg);
        stg.Bext.addActionListener(this);
        stg.Bst.addActionListener(this);
        
        // d.requestFocus();
        // monster mons = new monster();
        // d.monsplus(mons);    
        
    }

    
public static void main(String[] args){
    tomatotomato mjmj = new tomatotomato();
    mjmj.setSize(1020,700);
    mjmj.setTitle("tomatotomato");
    mjmj.setVisible(true);
    mjmj.setLocationRelativeTo(null);
    mjmj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    

    

}


@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==stg.Bst){
        this.setLocationRelativeTo(null);
        this.remove(stg);
        this.add(d);
        this.setSize(1020,700);
        d.requestFocusInWindow();
        revalidate();
}
else if(e.getSource()==stg.Bext){
    System.exit(0);
}
}
}