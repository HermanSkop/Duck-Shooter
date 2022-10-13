import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightDuckMover extends Duck{
    RightDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("duck.png");
        duck.setIcon(icon);
    }

    @Override
    public void run() {
        // actual movement of the duck
        while(x<currGame.game.getWidth()) {
            x += 1;
            panel.setBounds(x, y, 50, 50);
            try {
                try {
                    sleep(64/currGame.difflvl);
                } catch (InterruptedException e) {}
            } catch (Exception e) {
            }
            if(x==currGame.game.getWidth()){
                reduceHp(hp);
                removeDuck(panel);
            };
        }
    }
}
