// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;

// // import mojimojijump.Draw;

// public class mojikeybord implements KeyListener{

//     Draw d = new Draw();
//     public mojikeybord(Draw d){
//         this.d = d;
//     }

//     @Override
//     public void keyTyped(KeyEvent e) {
//     }

//     @Override
//     public void keyPressed(KeyEvent e) {
//         int i = e.getKeyCode();
//         if(i == KeyEvent.VK_A){
//             System.out.println("kf");
//         }
//         switch (i) {
//             case KeyEvent.VK_A:
//                 d.changeXDelta(-15);
//                 //System.out.println(87);
//                 break;
//             case KeyEvent.VK_D:
//                 d.changeXDelta(15);
//                 break;
//             case KeyEvent.VK_W:
//                 d.changeYDelta(15);
//                 break;
//             default:
//                 break;
//         }
        
//     }
//     @Override
//     public void keyReleased(KeyEvent e){
    
//     }
    

// }