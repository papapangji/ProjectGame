                           
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

    startgame stg = new startgame();
    mojiplayer mjp = new mojiplayer();
    potion mt = new potion();
    public int score = 0;
    public int timec = 90;
    //wood w = new wood();
    

    public static ArrayList<potion>mts = new ArrayList<potion>();
    // java.net.URL imgpotis = this.getClass().getResource("/bg/majic1.png");
    // Image imgpotis2 = new ImageIcon(imgpotis).getImage();
    private int potionRl = 0;
    private int potionINv = 150;
    private int speed = 200;
    
    
    java.net.URL imageURL = this.getClass().getResource("bg/bgbg1.jpg");
    Image imageBg = new ImageIcon(imageURL).getImage();
    java.net.URL imageURL2 = this.getClass().getResource("bg/bg11.jpg");
    Image imageBg2 = new ImageIcon(imageURL2).getImage();
    // java.net.URL imageURL3 = this.getClass().getResource("bg/monster0.jpg");
    // Image imagemons = new ImageIcon(imageURL3).getImage();
    


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
    public void newpotion(){
        potion newpotion = new potion();
        mts.add(newpotion);
    }

    public void updategame(){
        potionRl++;
        // System.out.println(potionRl);
        if(potionRl >= potionINv){
            potionRl = 0;
            potion poti = new potion();

            poti.x = (int) (Math.random() * (getWidth() - 100));
            poti.y = 0;
            if(poti.x <= getWidth()){
                mts.add(poti);
            }
            
            
        }
        for(int i=0;i<mts.size();i++){
            potion potist = mts.get(i);
            potist.move();
        }

        for (int i = 0; i < mts.size(); i++) {
            if (Intersect(mts.get(i).getbound(), mjp.getbound())) {
                mts.remove(i);
                score += 15;

                //System.out.println(1);
                
            }
        }
    }


    // public Thread time = new Thread(new Runnable() {
    //     public void run(){
    //      while(true){
    //          try{
    //              Thread.sleep(100);
    //          }
    //          catch(Exception e){
    //             System.out.println(e);
    //          }
    //          updategame();
    //          repaint();
             
    //      }
    //     } 
    //  });
     
    
     public void render(){
        repaint();
        try{
             Thread.sleep(100);   
        }catch(InterruptedException e){
            e.printStackTrace();
        }
     }
     public static void potisplus(potion mt){
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
        g.drawString("Time : "+timec,820 , 50);
        if(timec <= 0){
            g.drawString("END", 340, 400);
        }
        for(int i=0;i<mts.size();i++){
            potion m = mts.get(i);
            g.drawImage(m.imgpt, m.getX(), m.getY(), 45, 45,this);

            
        }
        // g.drawImage(w.imgwoods,w.x,w.y,getWidth()*3,getHeight()*3,this);
        // g.setColor(Color.white);
        // g.fillRect(250, 360, 100, 10);
        // g.fillRect(450, 450, 100, 10);
        // g.fillRect(200, 550, 100, 10);
        // g.fillRect(300, 600, 100, 10);
        // g.fillRect(400, 510, 100, 10);
        // g.fillRect(150, 480, 100, 10);
        // g.fillRect(530, 410, 100, 10);
        // g.fillRect(510, 580, 100, 10);
        // g.fillRect(370, 380, 100, 10);
        // g.fillRect(375, 700, 100, 10);
        // g.fillRect(100, 640, 100, 10);
        //mjp.y += 1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
    