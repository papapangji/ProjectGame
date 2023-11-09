                           
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Draw extends JPanel implements ActionListener{

    public startgame stg = new startgame();
    public tomatoplayer mjp = new tomatoplayer();
    public tomato mt = new tomato();
    public int score = 0;
    public int timec = 90;
    

    public static ArrayList<tomato>mts = new ArrayList<tomato>();
    private int tomatoRi = 0;
    private int tomatoNv = 150;

    
    
    java.net.URL imageURL = this.getClass().getResource("bg/bgbg1.jpg");
    Image imageBg = new ImageIcon(imageURL).getImage();
    java.net.URL imageURL2 = this.getClass().getResource("bg/bg11.jpg");
    Image imageBg2 = new ImageIcon(imageURL2).getImage();



    public Thread time = new Thread(new Runnable() {
        public void run(){
         while(true){
             try{
                 Thread.sleep(10);
             }
             catch(Exception e){
                System.out.println(e);
             }
             if(timec > 0){
                 updategame();
                 repaint();
             }
            
             
         }
        } 
     });
     public Thread timecount = new Thread(new Runnable() {
        public void run(){
         while(true){
             try{
                 Thread.sleep(1000);
             }
             catch(Exception e){
                System.out.println(e);
             }
             timec--;
        
             
         }
        } 
     });
    
    public Draw(){

        
        this.setFocusable(true);
        this.setLayout(null);
        
        mjp.x = 0;
        mjp.y = 450;
        
        
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){

                if(e.getKeyCode() == KeyEvent.VK_A){
                    if(mjp.x > -5){
                        mjp.x -= 15;
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_D){
                    if(mjp.x < 920){
                         mjp.x += 15;
                    }
                   
                }
                
            }
        });   
        time.start();  
        timecount.start();  
    }
    public void newtomato(){
        tomato newtomato = new tomato();
        mts.add(newtomato);
    }

    public void updategame(){
        tomatoRi++;
    
        if(tomatoRi >= tomatoNv){
            tomatoRi = 0;
            tomato toma = new tomato();

            toma.x = (int) (Math.random() * (getWidth() - 100));
            toma.y = 0;
            if(toma.x <= getWidth()){
                mts.add(toma);
            }
            
            
        }
        for(int i=0;i<mts.size();i++){
            tomato tomast = mts.get(i);
            tomast.move();
        }

        for (int i = 0; i < mts.size(); i++) {
            if (Intersect(mts.get(i).getbound(), mjp.getbound())) {
                mts.remove(i);
                score += 15;
                                                                                              
                
            }
        }
    }
     
    
     public void render(){
        repaint();
        try{
             Thread.sleep(100);   
        }catch(InterruptedException e){
            e.printStackTrace();
        }
     }
     public static void tomasplus(tomato mt){
        mts.add(mt);
     }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);
        if(timec < 45){
            g.drawImage(imageBg2, 0, 0, getWidth(), getHeight(), this);
        }
        //g.drawRect(mjp.x+7, 470, 80, 80);
        g.drawImage(mjp.img,mjp.x,mjp.y,100,100 ,this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
        g.drawString("SCORE : "+score,50 , 50);
        g.drawString("Time : "+timec,800 , 50);
        if(timec <= 0){
            g.drawString("End Game", 450, 350);
        }
        for(int i=0;i<mts.size();i++){
            tomato m = mts.get(i);
            g.drawImage(m.imgpt, m.getX(), m.getY(), 45, 45,this);

            
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
    